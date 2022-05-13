package com.company.student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JWindow extends JFrame {
    String[] columnhead={"序号","课程名","成绩"};
    JTable jTable=new JTable();
    DbConn getData=new DbConn();
    Toolkit toolkit=Toolkit.getDefaultToolkit();
    JWindow(){
        init();
        setTitle("学生成绩查询");
        jTable.setModel(B_model());
        setLayout(new FlowLayout());
        setBounds((toolkit.getScreenSize().width-500)/2,(toolkit.getScreenSize().height-600)/2,500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit1=getToolkit();
        setVisible(true);
        Image tubiao=toolkit1.getImage(JWindow.class.getClassLoader().getResource("touxiang.png").getPath());
        setIconImage(tubiao);

    }

    void init(){
        JTextField textField=new JTextField("请输入学号",8);
        JButton button=new JButton("查询");
        JLabel label=new JLabel("xxx");
        Box Z_box =Box.createVerticalBox();
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createVerticalBox();
        box1.add(textField);
        box1.add(new JLabel("    "));
        box1.add(button);
        box2.add(label);
        box2.add(new JLabel("  的成绩明细"));
        box3.add(new JScrollPane(jTable));
        Z_box.add(box1);
        Z_box.add(box2);
        Z_box.add(box3);
        add(Z_box);
        label.setText("xxx");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String number= textField.getText();
                System.out.println(number);
                DefaultTableModel model=B_model();
                model.setDataVector(getData.getDate(number),columnhead);
                jTable.setModel(model);
                label.setText((new DbConn()).getname(number));
            }
        });
    }
    DefaultTableModel B_model(){
        String[][] p=null;
        DefaultTableModel model=new DefaultTableModel(p, columnhead){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return model;
    }
}
