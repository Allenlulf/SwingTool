/*package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.epoint.ZtbCommon.ZtbCommonDao;
import com.epoint.toolUtil.ComFunction;

public class CAUtil extends JPanel
{

    *//**
     * 
     *//*
    private static final long serialVersionUID = 1L;

    private String sqlurl;

    private String sqltype;

    private JLabel lab1e1;

    public static JTextField field1;

    private JButton btn1;

    public CAUtil(String sqlurl, String sqltype) {
        this.sqlurl = sqlurl;
        this.sqltype = sqltype;
        init();
        LoadList();
    }

    public void init() {
        this.setLayout(null);

        lab1e1 = new JLabel("CA名称:");
        field1 = new JTextField();
        btn1 = new JButton("保存");

        lab1e1.setBounds(5, 20, 80, 25);
        field1.setBounds(100, 20, 300, 25);
        btn1.setBounds(5, 50, 80, 25);

        lab1e1.setFont(new Font("微软雅黑", 0, 12));
        lab1e1.setForeground(Color.BLACK);
        field1.setFont(new Font("微软雅黑", 0, 12));
        field1.setForeground(Color.BLACK);
        btn1.setFont(new Font("微软雅黑", 0, 12));
        btn1.setForeground(Color.BLACK);

        this.add(lab1e1);
        this.add(field1);
        this.add(btn1);

        btn1.addActionListener((e) -> save());

        this.setVisible(true);
    }

    public void LoadList() {
        try {
            ZtbCommonDao db = new ComFunction().getService(sqltype, sqlurl);
            String sql = "select CONFIGVALUE from frame_config where configname='Bid_CA类型'";
            field1.setText(db.queryString(sql));
        }
        catch (Exception e) {
            field1.setText(null);
            e.getMessage().toString();
        }
    }

    public void save() {
        try {
            ZtbCommonDao db = new ComFunction().getService(sqltype, sqlurl);
            String sql = "update frame_config set CONFIGVALUE='" + field1.getText() + "' where configname='Bid_CA类型'";
            db.execute(sql);
        }
        catch (Exception e) {
            e.getMessage().toString();
        }

    }
}
*/