package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.epoint.action.Configuration;
import com.epoint.service.PanelService;

/**
 * 关联系统配置
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月15日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CoherentSystemConfiguration extends JPanel implements PanelService
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private MainFrame mainframe;

    private JLabel lab1e1, lable2, lab1e3, lable4, lable5, lab1e6, lable7, lable8;

    private JTextField field1, field2, field3, field4, field5, field6, field7, field8;

    private static Map<String, String> ztbmap;

    private static Map<String, String> configmap;

    public CoherentSystemConfiguration(MainFrame mainframe) {
        this.mainframe = mainframe;
        init();
    }

    public void init() {
        this.setLayout(null);
        lab1e1 = new JLabel("调用dotnet服务器地址  :");
        lable2 = new JLabel("业务系统webservice地址  :");
        lab1e3 = new JLabel("业务系统数据库链接  :");
        lable4 = new JLabel("业务系统数据库账户  :");
        lable5 = new JLabel("业务系统数据库密码  :");
        lab1e6 = new JLabel("云签章地址  :");
        lable7 = new JLabel("时间戳服务地址  :");
        lable8 = new JLabel("License  :");
        field1 = new JTextField();
        field2 = new JTextField();
        field3 = new JTextField();
        field4 = new JTextField();
        field5 = new JTextField();
        field6 = new JTextField();
        field7 = new JTextField();
        field8 = new JTextField();

        lab1e1.setBounds(5, 10, 200, 25);
        lable2.setBounds(5, 45, 200, 25);
        lab1e3.setBounds(5, 80, 200, 25);
        lable4.setBounds(5, 115, 200, 25);
        lable5.setBounds(370, 115, 200, 25);
        lab1e6.setBounds(5, 150, 200, 25);
        lable7.setBounds(5, 185, 200, 25);
        lable8.setBounds(5, 220, 200, 25);
        field1.setBounds(190, 10, 500, 25);
        field2.setBounds(190, 45, 500, 25);
        field3.setBounds(190, 80, 500, 25);
        field4.setBounds(190, 115, 180, 25);
        field5.setBounds(510, 115, 180, 25);
        field6.setBounds(190, 150, 500, 25);
        field7.setBounds(190, 185, 500, 25);
        field8.setBounds(190, 220, 500, 25);

        lab1e1.setFont(new Font("微软雅黑", 0, 14));
        lab1e1.setForeground(Color.BLACK);
        lable2.setFont(new Font("微软雅黑", 0, 14));
        lable2.setForeground(Color.BLACK);
        lab1e3.setFont(new Font("微软雅黑", 0, 14));
        lab1e3.setForeground(Color.BLACK);
        lable4.setFont(new Font("微软雅黑", 0, 14));
        lable4.setForeground(Color.BLACK);
        lable5.setFont(new Font("微软雅黑", 0, 14));
        lable5.setForeground(Color.BLACK);
        lab1e6.setFont(new Font("微软雅黑", 0, 14));
        lab1e6.setForeground(Color.BLACK);
        lable7.setFont(new Font("微软雅黑", 0, 14));
        lable7.setForeground(Color.BLACK);
        lable8.setFont(new Font("微软雅黑", 0, 14));
        lable8.setForeground(Color.BLACK);
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

        this.add(lab1e1);
        this.add(lable2);
        this.add(lab1e3);
        this.add(lable4);
        this.add(lable5);
        this.add(lab1e6);
        this.add(lable7);
        this.add(lable8);
        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(field4);
        this.add(field5);
        this.add(field6);
        this.add(field7);
        this.add(field8);

        this.setVisible(true);

    }

    public void LoadData() {
        try {
            ztbmap = mainframe.getMap("ztb.properties");
            configmap = mainframe.getMap("config.jsp");
            try {
                field1.setText(ztbmap.get("DotNetResutFulUrl"));
                field2.setText(ztbmap.get("WebReferencePath"));
                field3.setText(ztbmap.get("url_yw"));
                field4.setText(ztbmap.get("user_yw"));
                field5.setText(ztbmap.get("password_yw"));
                field6.setText(ztbmap.get("CloudSignatureURL"));
                field7.setText(ztbmap.get("TimeStampSvrUrl"));
                field8.setText(configmap.get("License"));
            }
            catch (Exception e) {
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SaveData(Configuration configuration) {
        mainframe.getMap("ztb.properties").put("DotNetResutFulUrl", field1.getText().toString());
        mainframe.getMap("ztb.properties").put("WebReferencePath", field2.getText().toString());
        mainframe.getMap("ztb.properties").put("url_yw", field3.getText().toString());
        mainframe.getMap("ztb.properties").put("user_yw", field4.getText().toString());
        mainframe.getMap("ztb.properties").put("password_yw", field5.getText().toString());
        mainframe.getMap("ztb.properties").put("CloudSignatureURL", field6.getText().toString());
        mainframe.getMap("ztb.properties").put("TimeStampSvrUrl", field7.getText().toString());
        mainframe.getMap("config.jsp").put("License", field8.getText().toString());
    }
}
