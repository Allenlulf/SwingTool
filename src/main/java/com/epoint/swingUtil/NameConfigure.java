package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.epoint.Util.FileUtil;
import com.epoint.toolUtil.ComboxItem;
import com.epoint.toolUtil.CreateNewYaml;

public class NameConfigure extends JPanel
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private MainFrame mainframe;
    private JLabel lab1e1, label2, label3;
    private JComboBox<ComboxItem> box1, box2;
    private JTextField field;
    private JButton btn1, btn2;
    private String path;
    private static List<String> listtemp = new ArrayList<String>();
    private int flag = 0;
    private static String dir = "";

    public NameConfigure(MainFrame mainframe) {
        this.mainframe = mainframe;
        this.path = mainframe.getPath();
        init();
        LoadData();
    }

    public void init() {
        this.setLayout(null);
        lab1e1 = new JLabel("工程名  :");
        label2 = new JLabel("yaml文件路径 :");
        label3 = new JLabel("请输入新增yaml文件的名称【请注意文件格式必须是yaml,即xxx.yaml】");
        btn1 = new JButton("新建");
        btn2 = new JButton("确认");
        box1 = new JComboBox<ComboxItem>();
        box2 = new JComboBox<ComboxItem>();
        field = new JTextField();

        lab1e1.setBounds(45, 20, 100, 25);
        label2.setBounds(5, 60, 100, 25);
        label3.setBounds(5, 165, 600, 25);
        btn1.setBounds(5, 90, 70, 25);
        btn2.setBounds(150, 130, 70, 25);
        box1.setBounds(120, 20, 610, 25);
        box2.setBounds(120, 60, 610, 25);

        field.setBounds(5, 130, 120, 25);

        btn1.setFocusPainted(false);
        btn2.setFocusPainted(false);

        lab1e1.setFont(new Font("微软雅黑", 0, 14));
        lab1e1.setForeground(Color.BLACK);
        label2.setFont(new Font("微软雅黑", 0, 14));
        label2.setForeground(Color.BLACK);
        label3.setFont(new Font("微软雅黑", 0, 14));
        label3.setForeground(Color.RED);
        field.setFont(new Font("微软雅黑", 0, 14));
        field.setForeground(Color.BLACK);
        box1.setFont(new Font("微软雅黑", 0, 12));
        box1.setForeground(Color.BLACK);
        box2.setFont(new Font("微软雅黑", 0, 14));
        box2.setForeground(Color.darkGray);

        this.add(lab1e1);
        this.add(label2);
        this.add(label3);
        this.add(field);
        this.add(btn1);
        this.add(btn2);
        this.add(box1);
        this.add(box2);
        
        listtemp = new FileUtil().getFileNameList(path);
        for (int i = 0; i < listtemp.size(); i++) {
            box1.addItem(new ComboxItem((i + 1) + "", listtemp.get(i).toString()));
        }

        box1.addItemListener((e) -> boxListener(e));
        box2.addItemListener((e) -> box2Listener(e));

        btn1.addActionListener((e) -> openNewPath());
        btn2.addActionListener((e) -> CreateNewFile());

        this.setVisible(true);
    }

    // 下拉框2 监听
    public void box2Listener(ItemEvent e) {
        if (flag == 0)
            return;
        field.setVisible(false);
        label3.setVisible(false);
        btn2.setVisible(false);
    }

    // 下拉框监听
    private void boxListener(ItemEvent e) {
        if (flag == 0)
            return;
        try {
            mainframe.loadTab();
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        field.setVisible(false);
        box2.setVisible(true);
        if (e.getStateChange() == ItemEvent.SELECTED) {
            box2.removeAllItems();
            String newpath = path + File.separator + box1.getSelectedItem().toString() + File.separator + "src"
                    + File.separator + "main" + File.separator + "resources" + File.separator + "Docker";
            FileUtil fUtil = new FileUtil();
            fUtil.getList().clear();
            List<String> list = fUtil.getYamlList(new File(newpath));
            for (int i = 0; i < list.size(); i++) {
                box2.addItem(new ComboxItem(i + "",
                        list.get(i).toString().substring(list.get(i).toString().lastIndexOf(File.separator) + 1)));
            }
        }
    }

    public void LoadData() {
        flag = 0;
        // 遍历传入的文件夹，判断文件夹下面的 item + \src\main\resources\Docker\Template
        // 是否存在。
        dir = File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "Docker";
        //box1.removeAllItems();
        box2.removeAllItems();
//        listtemp = new FileUtil().getFileNameList(path);
//        for (int i = 0; i < listtemp.size(); i++) {
//            box1.addItem(new ComboxItem((i + 1) + "", listtemp.get(i).toString()));
//        }
        String newpath = path + File.separator + box1.getSelectedItem() + dir;
        FileUtil fUtil = new FileUtil();
        fUtil.getList().clear();
        List<String> list = fUtil.getYamlList(new File(newpath));
        for (int i = 0; i < list.size(); i++) {
            box2.addItem(new ComboxItem(i + "",
                    list.get(i).toString().substring(list.get(i).toString().lastIndexOf(File.separator) + 1)));
        }
        flag = 1;
        field.setVisible(false);
        label3.setVisible(false);
        btn2.setVisible(false);
    }

    private void openNewPath() {
        field.setVisible(true);
        label3.setVisible(true);
        btn2.setVisible(true);
    }

    private void CreateNewFile() {
        // 根据输入的文件名自动拼接其绝对路径并且反馈到下拉列表中
        // 1 先对输入的名称做校验
        if (!field.getText().toString().endsWith("yaml")) {
            field.setVisible(false);
            label3.setVisible(false);
            btn2.setVisible(false);
            JOptionPane.showMessageDialog(null, "文件格式错误");
            return;
        }
        // 2 拼接绝对路径
        String pathdir = path + File.separator + box1.getSelectedItem().toString() + File.separator + "src"
                + File.separator + "main" + File.separator + "resources" + File.separator + "Docker" + File.separator;
        pathdir += field.getText().toString();
        try {
            new CreateNewYaml().createyaml(pathdir,box1.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "新增成功");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "新增失败");
            e.getMessage().toString();
        }
        // 3 新增控件隐藏
        field.setVisible(false);
        label3.setVisible(false);
        btn2.setVisible(false);
        LoadData();
    }

    public String getBox1Text() {
        return box1.getSelectedItem().toString();
    }

    public String getBox2Text() {
        return box2.getSelectedItem().toString();
    }
}
