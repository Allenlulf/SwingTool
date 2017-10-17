package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 系统类别配置
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月11日]
 */
public class SystemConfigure extends JPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private MainFrame mainframe;
    private JLabel lab1e1;

    public SystemConfigure(MainFrame mainframe) {
        this.mainframe = mainframe;
        init();
        LoadList();
    }

    public void init() {
        this.setLayout(null);
        lab1e1 = new JLabel("系统类别配置  :");

        lab1e1.setBounds(5, 20, 100, 25);

        lab1e1.setFont(new Font("微软雅黑", 0, 14));
        lab1e1.setForeground(Color.BLACK);

        this.add(lab1e1);

        this.setVisible(true);

    }

    public void LoadList() {

    }

}
