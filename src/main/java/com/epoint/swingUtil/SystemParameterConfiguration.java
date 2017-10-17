/*package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.epoint.ZtbCommon.ZtbCommonDao;
import com.epoint.toolUtil.ComFunction;
import com.epoint.toolUtil.ComboxItem;

*//**
 * 系统参数设置
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月16日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 *//*
public class SystemParameterConfiguration extends JPanel
{

    *//**
     * 
     *//*
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private MainFrame mainframe;
    private SysName sysName;
    private CAUtil cautil;
    private PDFUtil pdfutil;
    private JLabel lab1e1;
    private JTextField field1;
    private JComboBox<ComboxItem> box1;
    private JButton btn1;
    private JTabbedPane tab;

    public SystemParameterConfiguration(MainFrame mainframe) {
        this.mainframe = mainframe;
        init();
        LoadList();
    }

    public void init() {
        this.setLayout(null);
        lab1e1 = new JLabel("SQL字符串:");
        field1 = new JTextField();
        box1 = new JComboBox<ComboxItem>();
        tab = new JTabbedPane();
        btn1 = new JButton("校验");

        lab1e1.setBounds(5, 20, 80, 25);
        field1.setBounds(100, 20, 630, 25);
        box1.setBounds(750, 20, 140, 25);
        btn1.setBounds(5, 50, 80, 25);

        lab1e1.setFont(new Font("微软雅黑", 0, 12));
        lab1e1.setForeground(Color.BLACK);
        field1.setFont(new Font("微软雅黑", 0, 12));
        field1.setForeground(Color.BLACK);
        box1.setFont(new Font("微软雅黑", 0, 12));
        box1.setForeground(Color.BLACK);
        btn1.setFont(new Font("微软雅黑", 0, 12));
        btn1.setForeground(Color.BLACK);

        this.add(lab1e1);
        this.add(field1);
        this.add(box1);
        this.add(btn1);
        this.add(tab);

        btn1.addActionListener((e) -> checkSQL());

        this.setVisible(true);
    }

    public void LoadList() {
        box1.removeAllItems();
        box1.addItem(new ComboxItem("1", "MYSQL"));
        box1.addItem(new ComboxItem("2", "Oracle"));
        box1.addItem(new ComboxItem("3", "SQLServer"));
        sysName = new SysName(field1.getText(), box1.getSelectedItem().toString().trim());
        cautil = new CAUtil(field1.getText(), box1.getSelectedItem().toString().trim());
        pdfutil = new PDFUtil(field1.getText(), box1.getSelectedItem().toString().trim());
        tab.removeAll();
        tab.add("系统名称", sysName);
        tab.add("CA类型", cautil);
        tab.add("PDF类型", pdfutil);
        tab.setFont(new Font("微软雅黑", 0, 14));
        tab.setBounds(0, 100, 1000, 700);
    }

    public void checkSQL() {
        String connstr = field1.getText();
        try {
            ZtbCommonDao db = new ComFunction().getService(box1.getSelectedItem().toString().trim(), connstr);
            if (db == null) {
            }
            else {
            }
        }
        catch (Exception e) {
            e.getLocalizedMessage().toString();
        }
        LoadList();
    }

    public JTextField getField1() {
        return field1;
    }

    public void setField1(JTextField field1) {
        this.field1 = field1;
    }

    public JComboBox<ComboxItem> getBox1() {
        return box1;
    }

    public void setBox1(JComboBox<ComboxItem> box1) {
        this.box1 = box1;
    }
}
*/