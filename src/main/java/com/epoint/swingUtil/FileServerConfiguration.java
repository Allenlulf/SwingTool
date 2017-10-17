package com.epoint.swingUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.epoint.action.Configuration;
import com.epoint.service.PanelService;
import com.epoint.toolUtil.ComboxItem;

/**
 * 文件服务器配置
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月14日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FileServerConfiguration extends JPanel implements PanelService
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private MainFrame mainframe;
    private JLabel lab1e1, lable2, lab1e3, lable4, lable5, lable6, lable7;
    private JTextField field2, field3, field4;
    private JComboBox<ComboxItem> box1;
    private static Map<String, String> ztbmap;

    public FileServerConfiguration(MainFrame mainframe) {
        this.mainframe = mainframe;
        init();
    }

    public void init() {
        this.setLayout(null);
        lab1e1 = new JLabel("ZTBFileStorageType  :");
        lable2 = new JLabel("ZTBFileStoragePath  :");
        lab1e3 = new JLabel("EpointMisTempFileType  :");
        lable4 = new JLabel("EpointMisTempPath  :");
        lable5 = new JLabel();
        lable6 = new JLabel();
        lable7 = new JLabel();
        field2 = new JTextField();
        field3 = new JTextField();
        field4 = new JTextField();
        box1 = new JComboBox<ComboxItem>();

        lab1e1.setBounds(5, 10, 150, 25);
        lable2.setBounds(5, 45, 150, 25);
        lab1e3.setBounds(5, 80, 180, 25);
        lable4.setBounds(5, 115, 150, 25);
        lable5.setBounds(5, 145, 700, 25);
        lable6.setBounds(5, 175, 700, 25);
        lable7.setBounds(5, 205, 700, 25);
        box1.setBounds(190, 10, 80, 25);
        field2.setBounds(190, 45, 500, 25);
        field3.setBounds(190, 80, 80, 25);
        field4.setBounds(190, 115, 500, 25);

        lab1e1.setFont(new Font("微软雅黑", 0, 14));
        lab1e1.setForeground(Color.BLACK);
        lable2.setFont(new Font("微软雅黑", 0, 14));
        lable2.setForeground(Color.BLACK);
        lab1e3.setFont(new Font("微软雅黑", 0, 14));
        lab1e3.setForeground(Color.BLACK);
        lable4.setFont(new Font("微软雅黑", 0, 14));
        lable4.setForeground(Color.BLACK);
        lable5.setFont(new Font("微软雅黑", 0, 14));
        lable5.setForeground(Color.RED);
        lable6.setFont(new Font("微软雅黑", 0, 14));
        lable6.setForeground(Color.RED);
        lable7.setFont(new Font("微软雅黑", 0, 14));
        lable7.setForeground(Color.RED);
        box1.setFont(new Font("微软雅黑", 0, 14));
        box1.setForeground(Color.darkGray);
        field2.setFont(new Font("微软雅黑", 0, 14));
        field2.setForeground(Color.darkGray);
        field3.setFont(new Font("微软雅黑", 0, 14));
        field3.setForeground(Color.darkGray);
        field4.setFont(new Font("微软雅黑", 0, 14));
        field4.setForeground(Color.darkGray);

        this.add(lab1e1);
        this.add(lable2);
        this.add(lab1e3);
        this.add(lable4);
        this.add(lable5);
        this.add(lable6);
        this.add(lable7);
        this.add(box1);
        this.add(field2);
        this.add(field3);
        this.add(field4);

        box1.addItem(new ComboxItem("1", "File"));
        box1.addItem(new ComboxItem("2", "SAMBA"));
        box1.addItem(new ComboxItem("3", "DB"));
        box1.addItem(new ComboxItem("4", "OSS"));
        box1.addItem(new ComboxItem("5", "NFS"));

        box1.addItemListener((e) -> boxListener(e));

        this.setVisible(true);
    }

    private void boxListener(ItemEvent e) {
        @SuppressWarnings("unchecked")
        JComboBox<String> b = (JComboBox<String>) e.getSource();
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (b.getSelectedItem().toString().equals("File")) {
                lable5.setText("【File模式】 ZTBFileStoragePath示例：AttachStorage");
                lable6.setText("EpointMisTempPath示例：EpointMisTempFile");
                lable7.setText("");
            }
            else if (b.getSelectedItem().toString().equals("SAMBA")) {
                lable5.setText("【SAMBA模式】 ZTBFileStoragePath示例：@@//192.168.200.141/AttachStorage2");
                lable6.setText("EpointMisTempPath示例：EpointMisTempFile");
                lable7.setText("");
            }
            else if (b.getSelectedItem().toString().equals("DB")) {
                lable5.setText("【DB模式】 参数无需配置");
                lable6.setText("");
                lable7.setText("");
            }
            else if (b.getSelectedItem().toString().equals("OSS")) {
                lable5.setText("【OSS模式】 ZTBFileStoragePath示例：http://172.29.146.3;z0e49YYcPUcB4Jew;a49emBnOl2NL7CYnS76");
                lable6.setText("BNKEXjrcCtq;epointnx20160923");
                lable7.setText("EpointMisTempPath示例：EpointMisTempFile");
            }
            else {
                lable5.setText("【NFS模式】 ZTBFileStoragePath示例：192.168.202.11@/home/nfs/AttachStorage/");
                lable6.setText("EpointMisTempPath示例：192.168.202.11@/home/nfs/EpointMisTempFile/");
                lable7.setText("");
            }
        }
    }

    public void LoadData() {
        ztbmap = mainframe.getMap("ztb.properties");
        try {
            try {
                field2.setText(ztbmap.get("ZTBFileStoragePath"));
                field3.setText(ztbmap.get("EpointMisTempFileType"));
                if ("TPPingBiao".equals(MainFrame.getNameConfigure().getBox1Text()))
                    field4.setText(ztbmap.get("EpointMisTempPath"));
                else {
                    field4.setText(ztbmap.get("EpointMisTempFilePath"));
                }
                switch (ztbmap.get("ZTBFileStorageType")) {
                    case "File":
                        box1.setSelectedIndex(0);
                        lable5.setText("File模式 ZTBFileStoragePath示例：AttachStorage");
                        lable6.setText("EpointMisTempPath示例：EpointMisTempFile");
                        lable7.setText("");
                        break;
                    case "SAMBA":
                        box1.setSelectedIndex(1);
                        lable5.setText("SAMBA模式 ZTBFileStoragePath示例：@@//192.168.200.141/AttachStorage2");
                        lable6.setText("EpointMisTempPath示例：EpointMisTempFile");
                        lable7.setText("");
                        break;
                    case "DB":
                        box1.setSelectedIndex(2);
                        lable5.setText("DB模式 参数无需配置");
                        lable6.setText("");
                        lable7.setText("");
                        break;
                    case "OSS":
                        box1.setSelectedIndex(3);
                        lable5.setText(
                                "OSS模式 ZTBFileStoragePath示例：http://172.29.146.3;z0e49YYcPUcB4Jew;a49emBnOl2NL7CYnS76");
                        lable6.setText("BNKEXjrcCtq;epointnx20160923");
                        lable7.setText("EpointMisTempPath示例：EpointMisTempFile");
                        break;
                    case "NFS":
                        box1.setSelectedIndex(4);
                        lable5.setText("NFS模式 ZTBFileStoragePath示例：192.168.202.11@/home/nfs/AttachStorage/");
                        lable6.setText("EpointMisTempPath示例：192.168.202.11@/home/nfs/EpointMisTempFile/");
                        lable7.setText("");
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e) {
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SaveData(Configuration configuration) {
        mainframe.getMap("ztb.properties").put("ZTBFileStorageType", box1.getSelectedItem().toString());
        mainframe.getMap("ztb.properties").put("ZTBFileStoragePath", field2.getText().toString());
        mainframe.getMap("ztb.properties").put("EpointMisTempFileType", field3.getText().toString());
        if ("TPPingBiao".equals(MainFrame.getNameConfigure().getBox1Text()))
            mainframe.getMap("ztb.properties").put("EpointMisTempPath", field4.getText().toString());
        else {
            mainframe.getMap("ztb.properties").put("EpointMisTempFilePath", field4.getText().toString());
        }
        
    }

    public JComboBox<ComboxItem> getBox1() {
        return box1;
    }

    public void setBox1(JComboBox<ComboxItem> box1) {
        this.box1 = box1;
    }
}
