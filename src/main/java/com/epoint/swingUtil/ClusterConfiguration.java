package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.epoint.action.Configuration;
import com.epoint.service.PanelService;

/**
 * 群集配置
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月14日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ClusterConfiguration extends JPanel implements PanelService

{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private MainFrame mainframe;
    private JCheckBox JCheckBox;
    private JLabel lab1e1, label2, label3, label4;
    private JTextField field1, field2, field3;
    private static Map<String, String> webmap;
    private static Map<String, String> epointframemap;

    public ClusterConfiguration(MainFrame mainframe) {
        this.mainframe = mainframe;
        init();
    }

    public void init() {
        this.setLayout(null);
        JCheckBox = new JCheckBox("是否启动集群 :");
        lab1e1 = new JLabel("Redis路径 :");
        label2 = new JLabel();

        label3 = new JLabel("额外redis订阅频道 :");
        label4 = new JLabel("websocket初始化地址:");
        field1 = new JTextField();
        field2 = new JTextField();
        field3 = new JTextField();

        JCheckBox.setBounds(5, 10, 200, 25);
        lab1e1.setBounds(5, 40, 100, 25);
        label2.setBounds(5, 70, 700, 25);
        label3.setBounds(5, 100, 200, 25);
        label4.setBounds(5, 130, 200, 25);
        field1.setBounds(150, 40, 300, 25);
        field2.setBounds(180, 100, 300, 25);
        field3.setBounds(180, 130, 300, 25);

        JCheckBox.setFont(new Font("微软雅黑", 0, 14));
        JCheckBox.setForeground(Color.BLACK);
        lab1e1.setFont(new Font("微软雅黑", 0, 14));
        lab1e1.setForeground(Color.BLACK);
        label2.setFont(new Font("微软雅黑", 0, 14));
        label2.setForeground(Color.RED);
        label3.setFont(new Font("微软雅黑", 0, 14));
        label3.setForeground(Color.BLACK);
        label4.setFont(new Font("微软雅黑", 0, 14));
        label4.setForeground(Color.BLACK);
        field1.setFont(new Font("微软雅黑", 0, 14));
        field1.setForeground(Color.darkGray);
        field2.setFont(new Font("微软雅黑", 0, 14));
        field2.setForeground(Color.darkGray);
        field3.setFont(new Font("微软雅黑", 0, 14));
        field3.setForeground(Color.darkGray);

        this.add(lab1e1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(JCheckBox);

        JCheckBox.addItemListener((e) -> boxListener(e));
        this.setVisible(true);
    }

    @SuppressWarnings("static-access")
    public void boxListener(ItemEvent e) {
        JCheckBox b = (javax.swing.JCheckBox) e.getSource();
        if (b.isSelected()) {
            lab1e1.setVisible(true);
            field1.setVisible(true);
            label2.setText("【Redis】示例：redis://192.168.203.100:6379/9");
            if ("TPBidder".equals(mainframe.getNameConfigure().getBox1Text())) {
                label3.setVisible(true);
                label4.setVisible(true);
                field2.setVisible(true);
                field3.setVisible(true);
            }
        }
        else {
            lab1e1.setVisible(false);
            field1.setVisible(false);
            label2.setText("");
            label3.setVisible(false);
            label4.setVisible(false);
            field2.setVisible(false);
            field3.setVisible(false);
        }
    }

    @Override
    public void LoadData() {
        webmap = mainframe.getMap("web.xml");
        epointframemap = mainframe.getMap("epointframe.properties");
        try {
            try {
                field1.setText(epointframemap.get("redisSetting"));
                if ("<!--".equals(webmap.get("CustEnable1")) && "-->".equals(webmap.get("CustEnable2"))) {
                    JCheckBox.setSelected(false);
                    lab1e1.setVisible(false);
                    field1.setVisible(false);
                    label3.setVisible(false);
                    label4.setVisible(false);
                    field2.setVisible(false);
                    field3.setVisible(false);
                    label2.setText("");
                }
                else {
                    JCheckBox.setSelected(true);
                    lab1e1.setVisible(true);
                    field1.setVisible(true);
                    if ("TPBidder".equals(mainframe.getNameConfigure().getBox1Text())) {
                        label3.setVisible(true);
                        label4.setVisible(true);
                        field2.setVisible(true);
                        field3.setVisible(true);
                    }
                    else {
                        label3.setVisible(false);
                        label4.setVisible(false);
                        field2.setVisible(false);
                        field3.setVisible(false);
                    }
                    field1.setText(epointframemap.get("redisSetting"));
                    label2.setText("【Redis】示例：redis://192.168.203.100:6379/9");
                    field2.setText(epointframemap.get("extendRedisChannel"));
                    field3.setText(webmap.get("WebSocketInitURL"));
                }
            }
            catch (Exception e) {
                lab1e1.setVisible(false);
                field1.setVisible(false);
                label2.setText("");
            }
        }
        catch (Exception e) {
            lab1e1.setVisible(false);
            field1.setVisible(false);
            label2.setText("");
            e.printStackTrace();
        }
    }

    @Override
    public void SaveData(Configuration configuration) {
        // 判断是否启动集群【是否勾选CheckBox】
        if (this.getJCheckBox().isSelected()) {
            mainframe.getMap("web.xml").put("CustEnable1", "");
            mainframe.getMap("web.xml").put("CustEnable2", "");
            mainframe.getMap("epointframe.properties").put("redisSetting", field1.getText().toString());
            if ("TPBidder".equals(mainframe.getNameConfigure().getBox1Text())) {
                mainframe.getMap("epointframe.properties").put("extendRedisChannel", field2.getText().toString());
                mainframe.getMap("web.xml").put("WebSocketInitURL", field3.getText().toString());
            }
        }
        else {
            mainframe.getMap("web.xml").put("CustEnable1", "<!--");
            mainframe.getMap("web.xml").put("CustEnable2", "-->");
            mainframe.getMap("epointframe.properties").put("redisSetting", "");
        }
    }

    public JCheckBox getJCheckBox() {
        return JCheckBox;
    }

    public void setJCheckBox(JCheckBox jCheckBox) {
        JCheckBox = jCheckBox;
    }
}
