package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.yaml.snakeyaml.Yaml;

import com.epoint.action.Configuration;
import com.epoint.action.ConfigurationUtil;
import com.epoint.service.PanelService;
import com.epoint.service.RefinedPanelAbstraction;

public class MainFrame extends JFrame implements ChangeListener
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JButton btn1, btn2, btn3, btn4, btn5;
    private static JTabbedPane tab;
    private static NameConfigure nameConfigure;
    private SQLConfigure sqlConfigure;
    private Yaml yaml = new Yaml();
    private static String path;
    private static ConfigurationUtil configuration = null;
    private static String yamlfilepath;
    private int oldIndex = 0;
    public Map<String, String> map = new HashMap<String, String>();
    public PanelService panelService;

    public MainFrame(String path) throws Exception {
        MainFrame.path = path;
        init();
        loadTab();
    }

    public void init() throws Exception {
        this.setTitle("电子交易部署包工具");
        this.setSize(760, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        nameConfigure = new NameConfigure(this);
        sqlConfigure = new SQLConfigure(this);

        tab = new JTabbedPane();
        tab.addChangeListener(this);
        tab.setFont(new Font("微软雅黑", 0, 14));
        tab.setBounds(0, 0, 1000, 400);
        btn1 = new JButton("首页");
        btn2 = new JButton("上一页");
        btn3 = new JButton("下一页");
        btn4 = new JButton("尾页");
        btn5 = new JButton("保存数据");

        btn1.setBounds(340, 425, 70, 25);
        btn2.setBounds(420, 425, 70, 25);
        btn3.setBounds(500, 425, 70, 25);
        btn4.setBounds(580, 425, 70, 25);
        btn5.setBounds(660, 425, 90, 25);

        btn1.setFocusPainted(false);
        btn2.setFocusPainted(false);
        btn3.setFocusPainted(false);
        btn4.setFocusPainted(false);
        btn5.setFocusPainted(false);

        btn1.setFont(new Font("微软雅黑", 0, 12));
        btn1.setForeground(Color.BLACK);
        btn2.setFont(new Font("微软雅黑", 0, 12));
        btn2.setForeground(Color.BLACK);
        btn3.setFont(new Font("微软雅黑", 0, 12));
        btn3.setForeground(Color.BLACK);
        btn4.setFont(new Font("微软雅黑", 0, 12));
        btn4.setForeground(Color.BLACK);
        btn5.setFont(new Font("微软雅黑", 0, 12));
        btn5.setForeground(Color.BLACK);

        this.add(tab);
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);

        btn1.addActionListener((e) -> FirstPage());
        btn2.addActionListener((e) -> LastPage());
        btn3.addActionListener((e) -> NextPage());
        btn4.addActionListener((e) -> LastFirstPage());
        btn5.addActionListener((e) -> SaveData());

        yamlfilepath = getYamlPath();
        configuration = new ConfigurationUtil(yamlfilepath);
        this.setVisible(true);
    }

    public void loadTab() throws FileNotFoundException {
        tab.removeAll();
        tab.add("配置名称", nameConfigure);
        // 评标系统及业务系统在此分流
        if ("EpointWebService".equals(nameConfigure.getBox1Text()))
            tab.add("数据库", sqlConfigure);
        else {
            tab.add("数据库", sqlConfigure);
            tab.add("群集配置", new ClusterConfiguration(this));
            tab.add("文件服务器配置", new FileServerConfiguration(this));
            if ("TPPingBiao".equals(nameConfigure.getBox1Text()))
                tab.add("评标系统配置", new CoherentSystemConfiguration(this));
            else {
                if ("TPFrame".equals(nameConfigure.getBox1Text()))
                    tab.addTab("业务系统配置", new CoherentSystemConfigurationByTPFrame(this));
                else {
                    tab.addTab("业务系统配置", new CoherentSystemConfigurationByTPBidder(this));
                    tab.addTab("定时服务配置", new ColonyConfiguration(this));
                }
            }
        }
    }

    private void SetTabIndex(int newIndex) {
        oldIndex = newIndex;
    }

    public void SaveData() {
        // 获取当前页面的信息保存
        savepage(tab.getSelectedIndex());
        // 执行修改保存方法
        configuration.save(yamlfilepath, this);
        JOptionPane.showMessageDialog(null, "保存成功！");
    }

    public void FirstPage() {
        tab.setSelectedIndex(0);
        SetTabIndex(0);
    }

    public void NextPage() {
        if (tab.getSelectedIndex() == (tab.getComponentCount() - 1)) {
            JOptionPane.showMessageDialog(null, "已经是尾页了！");
        }
        else {
            tab.setSelectedIndex(tab.getSelectedIndex() + 1);
        }
        SetTabIndex(tab.getSelectedIndex());
    }

    public void LastPage() {
        if (tab.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "已经是首页了！");
        }
        else {
            tab.setSelectedIndex(tab.getSelectedIndex() - 1);
        }
        SetTabIndex(tab.getSelectedIndex());
    }

    public void LastFirstPage() {
        tab.setSelectedIndex(tab.getComponentCount() - 1);
        SetTabIndex(tab.getSelectedIndex());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        yamlfilepath = getYamlPath();
        try {
            if (tab.getComponent(tab.getSelectedIndex()) instanceof PanelService)
                ((PanelService) tab.getComponent(tab.getSelectedIndex())).LoadData();
        }
        catch (Exception e2) {
            e2.getStackTrace();
        }
        // 保存切换之前页面的数据
        savepage(oldIndex);
        SetTabIndex(tab.getSelectedIndex());
    }

    public void savepage(int index) {
        // 不需要保存首页
        if (index != 0 && yamlfilepath.equals(getYamlPath())) {
            try {
                panelService = ((PanelService) tab.getComponent(oldIndex));
                RefinedPanelAbstraction abstraction = new RefinedPanelAbstraction(panelService);
                Configuration config = yaml.loadAs(new FileInputStream(yamlfilepath), Configuration.class);
                abstraction.operation(config);
            }
            catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    /**
     * 根据名称配置界面的状态获取当前的yaml文件路径
     * 
     * @param nameConfigure
     * @return
     */
    public static String getYamlPath() {
        String filepath = "";
        filepath = path + File.separator + nameConfigure.getBox1Text() + File.separator + "src" + File.separator
                + "main" + File.separator + "resources" + File.separator + "Docker" + File.separator;
        filepath += nameConfigure.getBox2Text();
        return filepath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        MainFrame.path = path;
    }

    public Map<String, String> getMap(String name) {
        map = configuration.getMap(yamlfilepath, name);
        return map;
    }

    public String getSQLCfgFileName() {
        String value = configuration.getSQLConFileName(yamlfilepath);
        if (value.contains("persistence.xml"))
            return "persistence.xml";
        return "jdbc.properties";
    }

    public static JTabbedPane getTab() {
        return tab;
    }

    public static void setTab(JTabbedPane tab) {
        MainFrame.tab = tab;
    }

    public static NameConfigure getNameConfigure() {
        return nameConfigure;
    }

    public static void setNameConfigure(NameConfigure nameConfigure) {
        MainFrame.nameConfigure = nameConfigure;
    }
}
