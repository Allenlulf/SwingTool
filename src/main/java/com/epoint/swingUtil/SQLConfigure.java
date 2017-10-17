package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.epoint.action.Configuration;
import com.epoint.service.PanelService;
import com.epoint.toolUtil.ComboxItem;

/**
 * 数据库配置
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月11日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SQLConfigure extends JPanel implements PanelService
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private MainFrame mainframe;
    private JLabel lab1e1, lable2, lable3, label4, label5;
    private JTextField field1, field2, field3, field4;
    private JComboBox<ComboxItem> box1, box2;
    private static Map<String, String> jdbcmap;

    public SQLConfigure(MainFrame mainframe) {
        this.mainframe = mainframe;
        init();
    }

    public void init() {
        this.setLayout(null);
        lab1e1 = new JLabel("数据库连接IP端口 :");
        lable2 = new JLabel("数据库名  :");
        lable3 = new JLabel("数据库用户名  :");
        label4 = new JLabel("数据库密码  :");
        label5 = new JLabel("配置文件名称  :");

        field1 = new JTextField();
        field2 = new JTextField();
        field3 = new JTextField();
        field4 = new JTextField();
        box1 = new JComboBox<ComboxItem>();
        box2 = new JComboBox<ComboxItem>();

        lab1e1.setBounds(5, 55, 120, 25);
        lable2.setBounds(5, 100, 120, 25);
        lable3.setBounds(5, 145, 120, 25);
        label4.setBounds(5, 190, 120, 25);
        label5.setBounds(5, 10, 120, 25);
        field1.setBounds(140, 55, 200, 25);
        field2.setBounds(140, 100, 200, 25);
        field3.setBounds(140, 145, 200, 25);
        field4.setBounds(140, 190, 200, 25);
        box1.setBounds(580, 55, 150, 25);
        box2.setBounds(140, 10, 200, 25);

        lab1e1.setFont(new Font("微软雅黑", 0, 14));
        lab1e1.setForeground(Color.BLACK);
        lable2.setFont(new Font("微软雅黑", 0, 14));
        lable2.setForeground(Color.BLACK);
        lable3.setFont(new Font("微软雅黑", 0, 14));
        lable3.setForeground(Color.BLACK);
        label4.setFont(new Font("微软雅黑", 0, 14));
        label4.setForeground(Color.BLACK);
        label5.setFont(new Font("微软雅黑", 0, 14));
        label5.setForeground(Color.BLACK);
        field1.setFont(new Font("微软雅黑", 0, 14));
        field1.setForeground(Color.darkGray);
        field2.setFont(new Font("微软雅黑", 0, 14));
        field2.setForeground(Color.darkGray);
        field3.setFont(new Font("微软雅黑", 0, 14));
        field3.setForeground(Color.darkGray);
        field4.setFont(new Font("微软雅黑", 0, 14));
        field4.setForeground(Color.darkGray);
        box1.setFont(new Font("微软雅黑", 0, 14));
        box1.setForeground(Color.BLACK);
        box2.setFont(new Font("微软雅黑", 0, 14));
        box2.setForeground(Color.BLACK);

        box1.addItem(new ComboxItem("1", "MYSQL"));
        box1.addItem(new ComboxItem("2", "SQLSERVER"));
        box1.addItem(new ComboxItem("3", "Oracle"));
        box2.addItem(new ComboxItem("1", "jdbc.properties"));
        box2.addItem(new ComboxItem("2", "persistence.xml"));

        this.add(lab1e1);
        this.add(lable2);
        this.add(lable3);
        this.add(label4);
        this.add(label5);
        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(field4);
        this.add(box1);
        this.add(box2);
        this.setVisible(true);
    }

    public void LoadData() {
        jdbcmap = mainframe.getMap(mainframe.getSQLCfgFileName());
        try {
            field3.setText(jdbcmap.get("username"));
            field4.setText(jdbcmap.get("password"));
            if (jdbcmap.get("urlAddr").contains("mysql")) {
                box1.setSelectedIndex(0);
            }
            else if (jdbcmap.get("urlAddr").contains("sqlserver")) {
                box1.setSelectedIndex(1);
            }
            else {
                box1.setSelectedIndex(2);
            }

            if (mainframe.getSQLCfgFileName().equals("jdbc.properties"))
                box2.setSelectedIndex(0);
            else {
                box2.setSelectedIndex(1);
            }
            Map<String, String> map = getsqlconn(jdbcmap.get("urlAddr"));
            field1.setText(map.get("urlconn"));
            field2.setText(map.get("databasename"));
        }
        catch (Exception e) {
            field1.setText("");
            field2.setText("");
        }
    }

    /**
     * 根据数据库连接字符串剥离连接ip及数据库名
     * 
     * @param value
     * @return
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public Map<String, String> getsqlconn(String value) {
        Map<String, String> map = new HashMap<String, String>();
        // 使用正则匹配来获取相应的连接ip
        String reg = ".*\\/\\/([^\\/\\/]*).*";
        String reg1 = ".*\\/\\/([^\\/\\;]*).*";
        String urlconn = "";
        String databasename = "";
        // 由于三种数据库的连接字符不一致，所以要分段解析
        if (box1.getSelectedIndex() == 0) {
            urlconn = value.replaceAll(reg, "$1");
            databasename = value.substring(
                    value.lastIndexOf(value.replaceAll(reg, "$1")) + value.replaceAll(reg, "$1").length() + 1,
                    value.lastIndexOf("?"));
        }
        else if (box1.getSelectedIndex() == 1) {
            urlconn = value.replaceAll(reg1, "$1");
            databasename = value.substring(value.lastIndexOf("=") + 1, value.length() - 1);
        }
        else {
            urlconn = value.replaceAll("@", "//").replaceAll(reg, "$1").substring(0,
                    value.replaceAll("@", "//").replaceAll(reg, "$1").lastIndexOf(":"));
            databasename = value.substring(value.lastIndexOf(":") + 1);
        }
        map.put("urlconn", urlconn);
        map.put("databasename", databasename);
        return map;
    }

    /**
     * 保存数据
     */
    public void SaveData(Configuration configuration) {
        String str = mainframe.getSQLCfgFileName();
        mainframe.getMap(str).put("username", field3.getText().toString());
        mainframe.getMap(str).put("password", field4.getText().toString());
        String value;
        String ip = field1.getText().toString();
        String databasename = field2.getText().toString();
        if ("MYSQL".equals(box1.getSelectedItem().toString())) {
            value = "jdbc:mysql://" + ip + "/" + databasename
                    + "?characterEncoding=utf8&useSSL=false&autoReconnect=true&failOverReadOnly";
            if (str.equals("persistence.xml")) {
                mainframe.getMap(str).put("dialect", "org.hibernate.dialect.MySQL5Dialect");
                mainframe.getMap(str).put("driverclass", "com.mysql.jdbc.Driver");
            }
        }
        else if ("SQLSERVER".equals(box1.getSelectedItem().toString())) {
            value = "jdbc:sqlserver://" + ip + ";databaseName=" + databasename;
            if (str.equals("persistence.xml")) {
                if (str.equals("persistence.xml")) {
                    mainframe.getMap(str).put("dialect", "org.hibernate.dialect.SQLServer2008Dialect");
                    mainframe.getMap(str).put("driverclass", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                }
            }
        }
        else {
            value = "jdbc:oracle:thin:@" + ip + ":" + databasename;
            if (str.equals("persistence.xml")) {
                if (str.equals("persistence.xml")) {
                    mainframe.getMap(str).put("dialect", "org.hibernate.dialect.Oracle10gDialectExtend");
                    mainframe.getMap(str).put("driverclass", "oracle.jdbc.driver.OracleDriver");
                }
            }
        }
        mainframe.getMap(str).put("urlAddr", value);
    }

    public JComboBox<ComboxItem> getBox1() {
        return box1;
    }

    public void setBox1(JComboBox<ComboxItem> box1) {
        this.box1 = box1;
    }
}
