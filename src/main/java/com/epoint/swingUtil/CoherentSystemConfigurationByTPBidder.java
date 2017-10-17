package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.epoint.action.Configuration;
import com.epoint.service.PanelService;

public class CoherentSystemConfigurationByTPBidder extends JPanel implements PanelService
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private MainFrame mainframe;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12,
            label13, label14;
    private JTextField field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11,
            field12, field13, field14;

    private JCheckBox JCheckBox;

    private static Map<String, String> ztbmap;

    private static Map<String, String> configmap;

    public CoherentSystemConfigurationByTPBidder(MainFrame mainframe) {
        this.mainframe = mainframe;
        init();
    }

    public void init() {
        this.setLayout(null);
        label1 = new JLabel("调用dotnet服务器地址  :");
        label2 = new JLabel("BS招标工具地址 :");
        label3 = new JLabel("评标系统地址 :");
        label4 = new JLabel("评标系统接口地址 :");
        label5 = new JLabel("网站后台接口地址 :");
        label6 = new JLabel("网站大师生成服务接口地址:");
        label7 = new JLabel("Redis地址:");
        label8 = new JLabel("加密数据库资源命名空间  :");
        label9 = new JLabel("竞价系统地址:");
        label10 = new JLabel("竞价系统Name:");
        label11 = new JLabel("竞价系统Key:");
        label12 = new JLabel("网上支付订单号前缀:");
        label13 = new JLabel("附件链接字符串  :");
        label14 = new JLabel("License  :");
        JCheckBox = new JCheckBox("是否启用三大数据库交互平台 ");

        field1 = new JTextField();
        field2 = new JTextField();
        field3 = new JTextField();
        field4 = new JTextField();
        field5 = new JTextField();
        field6 = new JTextField();
        field7 = new JTextField();
        field8 = new JTextField();
        field9 = new JTextField();
        field10 = new JTextField();
        field11 = new JTextField();
        field12 = new JTextField();
        field13 = new JTextField();
        field14 = new JTextField();

        label1.setBounds(5, 10, 200, 25);
        label2.setBounds(5, 40, 200, 25);
        label3.setBounds(5, 70, 200, 25);
        label4.setBounds(5, 100, 200, 25);
        label5.setBounds(5, 130, 200, 25);
        label6.setBounds(5, 160, 200, 25);
        label7.setBounds(5, 190, 200, 25);
        label8.setBounds(5, 220, 200, 25);
        label9.setBounds(330, 220, 200, 25);
        label10.setBounds(5, 250, 200, 25);
        label11.setBounds(330, 250, 200, 25);
        label12.setBounds(5, 280, 200, 25);
        JCheckBox.setBounds(420, 280, 280, 25);
        label13.setBounds(5, 310, 200, 25);
        label14.setBounds(5, 340, 200, 25);

        field1.setBounds(190, 10, 550, 25);
        field2.setBounds(190, 40, 550, 25);
        field3.setBounds(190, 70, 550, 25);
        field4.setBounds(190, 100, 550, 25);
        field5.setBounds(190, 130, 550, 25);
        field6.setBounds(190, 160, 550, 25);
        field7.setBounds(190, 190, 550, 25);
        field8.setBounds(190, 220, 130, 25);
        field9.setBounds(420, 220, 320, 25);
        field10.setBounds(190, 250, 130, 25);
        field11.setBounds(420, 250, 320, 25);
        field12.setBounds(190, 280, 130, 25);
        field13.setBounds(190, 310, 550, 25);
        field14.setBounds(190, 340, 550, 25);

        label1.setFont(new Font("微软雅黑", 0, 14));
        label1.setForeground(Color.BLACK);
        label2.setFont(new Font("微软雅黑", 0, 14));
        label2.setForeground(Color.BLACK);
        label3.setFont(new Font("微软雅黑", 0, 14));
        label3.setForeground(Color.BLACK);
        label4.setFont(new Font("微软雅黑", 0, 14));
        label4.setForeground(Color.BLACK);
        label5.setFont(new Font("微软雅黑", 0, 14));
        label5.setForeground(Color.BLACK);
        label6.setFont(new Font("微软雅黑", 0, 14));
        label6.setForeground(Color.BLACK);
        label7.setFont(new Font("微软雅黑", 0, 14));
        label7.setForeground(Color.BLACK);
        label8.setFont(new Font("微软雅黑", 0, 14));
        label8.setForeground(Color.BLACK);
        label9.setFont(new Font("微软雅黑", 0, 14));
        label9.setForeground(Color.BLACK);
        label10.setFont(new Font("微软雅黑", 0, 14));
        label10.setForeground(Color.BLACK);
        label11.setFont(new Font("微软雅黑", 0, 14));
        label11.setForeground(Color.BLACK);
        label12.setFont(new Font("微软雅黑", 0, 14));
        label12.setForeground(Color.BLACK);
        label13.setFont(new Font("微软雅黑", 0, 14));
        label13.setForeground(Color.BLACK);
        label14.setFont(new Font("微软雅黑", 0, 14));
        label14.setForeground(Color.BLACK);
        field1.setFont(new Font("微软雅黑", 0, 14));
        field1.setForeground(Color.darkGray);
        field2.setFont(new Font("微软雅黑", 0, 14));
        field2.setForeground(Color.darkGray);
        field3.setFont(new Font("微软雅黑", 0, 14));
        field3.setForeground(Color.darkGray);
        field4.setFont(new Font("微软雅黑", 0, 14));
        field4.setForeground(Color.darkGray);
        field5.setFont(new Font("微软雅黑", 0, 14));
        field5.setForeground(Color.darkGray);
        field6.setFont(new Font("微软雅黑", 0, 14));
        field6.setForeground(Color.darkGray);
        field7.setFont(new Font("微软雅黑", 0, 14));
        field7.setForeground(Color.darkGray);
        field8.setFont(new Font("微软雅黑", 0, 14));
        field8.setForeground(Color.darkGray);
        field9.setFont(new Font("微软雅黑", 0, 14));
        field9.setForeground(Color.darkGray);
        field10.setFont(new Font("微软雅黑", 0, 14));
        field10.setForeground(Color.darkGray);
        field11.setFont(new Font("微软雅黑", 0, 14));
        field11.setForeground(Color.darkGray);
        field12.setFont(new Font("微软雅黑", 0, 14));
        field12.setForeground(Color.darkGray);
        field13.setFont(new Font("微软雅黑", 0, 14));
        field13.setForeground(Color.darkGray);
        field14.setFont(new Font("微软雅黑", 0, 14));
        field14.setForeground(Color.darkGray);
        JCheckBox.setFont(new Font("微软雅黑", 0, 14));
        JCheckBox.setForeground(Color.BLACK);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(label10);
        this.add(label11);
        this.add(label12);
        this.add(label13);
        this.add(label14);
        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(field4);
        this.add(field5);
        this.add(field6);
        this.add(field7);
        this.add(field8);
        this.add(field9);
        this.add(field10);
        this.add(field11);
        this.add(field12);
        this.add(field13);
        this.add(field14);
        this.add(JCheckBox);
        this.setVisible(true);
    }

    @Override
    public void LoadData() {
        try {
            ztbmap = mainframe.getMap("ztb.properties");
            configmap = mainframe.getMap("config.jsp");
            try {
                field1.setText(ztbmap.get("DotNetResutFulUrl"));
                field2.setText(ztbmap.get("Bid_BSTool_Url"));
                field3.setText(ztbmap.get("Bid_PingBiao_Url"));
                field4.setText(ztbmap.get("Bid_PingBiaoInterface_Url"));
                field5.setText(ztbmap.get("CmsWebserviceUrl"));
                field6.setText(ztbmap.get("GenerateServiceUrl"));
                field7.setText(ztbmap.get("UsingRedis"));
                field8.setText(ztbmap.get("Bid_EncryXMLPath"));
                field9.setText(ztbmap.get("JingJiaSystemURL"));
                field10.setText(ztbmap.get("JingJiaqueueName"));
                field11.setText(ztbmap.get("JingJiaroutingKey"));
                field12.setText(ztbmap.get("Bid_NetpayNoPrefix"));
                field13.setText(ztbmap.get("AttachConnectionStringName"));
                field14.setText(configmap.get("License"));
                if ("1".equals(ztbmap.get("Bid_IsOpenDataExChange")))
                    JCheckBox.setSelected(true);
                else {
                    JCheckBox.setSelected(false);
                }
            }
            catch (Exception e) {
                e.getStackTrace();
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void SaveData(Configuration configuration) {
        mainframe.getMap("ztb.properties").put("DotNetResutFulUrl", field1.getText().toString());
        mainframe.getMap("ztb.properties").put("Bid_BSTool_Url", field2.getText().toString());
        mainframe.getMap("ztb.properties").put("Bid_PingBiao_Url", field3.getText().toString());
        mainframe.getMap("ztb.properties").put("Bid_PingBiaoInterface_Url", field4.getText().toString());
        mainframe.getMap("ztb.properties").put("CmsWebserviceUrl", field5.getText().toString());
        mainframe.getMap("ztb.properties").put("GenerateServiceUrl", field6.getText().toString());
        mainframe.getMap("ztb.properties").put("UsingRedis", field7.getText().toString());
        mainframe.getMap("ztb.properties").put("Bid_EncryXMLPath", field8.getText().toString());
        mainframe.getMap("ztb.properties").put("JingJiaSystemURL", field9.getText().toString());
        mainframe.getMap("ztb.properties").put("JingJiaqueueName", field10.getText().toString());
        mainframe.getMap("ztb.properties").put("JingJiaroutingKey", field11.getText().toString());
        mainframe.getMap("ztb.properties").put("Bid_NetpayNoPrefix", field12.getText().toString());
        mainframe.getMap("ztb.properties").put("AttachConnectionStringName", field13.getText().toString());
        mainframe.getMap("ztb.properties").put("Bid_IsOpenDataExChange", getSelectValue(JCheckBox.isSelected()));
        mainframe.getMap("config.jsp").put("License", field14.getText().toString());
    }

    private String getSelectValue(boolean isselected) {
        if (isselected)
            return "1";
        else
            return "0";
    }

}
