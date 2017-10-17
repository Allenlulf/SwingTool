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

/**
 * 集群配置【仅TPBidder】
 * 
 * @作者 lulf
 * @version [版本号, 2017年10月10日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ColonyConfiguration extends JPanel implements PanelService
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private MainFrame mainframe;
    private JCheckBox JCheckBox;
    private static Map<String, String> quartzmap;

    public ColonyConfiguration(MainFrame mainframe) {
        this.mainframe = mainframe;
        init();
    }

    public void init() {
        this.setLayout(null);
        JCheckBox = new JCheckBox("是否启动定时任务");
        JCheckBox.setBounds(5, 10, 300, 25);
        JCheckBox.setFont(new Font("微软雅黑", 0, 14));
        JCheckBox.setForeground(Color.BLACK);
        this.add(JCheckBox);
        this.setVisible(true);
    }

    @Override
    public void LoadData() {
        quartzmap = mainframe.getMap("quartz_data.xml");
        if ("<!--".equals(quartzmap.get("TaskEnable1")) && "-->".equals(quartzmap.get("TaskEnable2")))
            JCheckBox.setSelected(false);
        else {
            JCheckBox.setSelected(true);
        }
    }

    @Override
    public void SaveData(Configuration configuration) {
        if (JCheckBox.isSelected()) {
            mainframe.getMap("quartz_data.xml").put("TaskEnable1", "");
            mainframe.getMap("quartz_data.xml").put("TaskEnable2", "");
        }
        else {
            mainframe.getMap("quartz_data.xml").put("TaskEnable1", "<!--");
            mainframe.getMap("quartz_data.xml").put("TaskEnable2", "-->");
        }
    }
}
