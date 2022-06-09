package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Directory extends JFrame {
    String[] columnhead ={"联系人","电话号码","住址"};
    JTable jTable=new JTable();
    Contact_file contact_file=new Contact_file();
    HashTab hashTab =new HashTab();

    Toolkit toolkit=Toolkit.getDefaultToolkit();
    Directory(){
        Contact_file readfile=new Contact_file();
        try {
            readfile.file_read(hashTab);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bianli();
        hashTab.ALS();
        hashTab.ALS1();
        init();
        setTitle("电话簿");
        setLayout(new FlowLayout());
        setVisible(true);
        setBounds((toolkit.getScreenSize().width-500)/2,(toolkit.getScreenSize().height-600)/2,500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tool=getToolkit();
        Image tubiao=tool.getImage("src/com/company/touxiang.png");
        setIconImage(tubiao);
    }
    void init(){
        JMenuBar jmenubar=new JMenuBar();
        setJMenuBar(jmenubar);
        jmenubar.setLayout(new FlowLayout());
        JButton button1=new JButton("添加");
        JButton button4=new JButton("删除");
        JButton[] blogbutton={new JButton("继续"),new JButton("取消")};
        JDialog dialog=new JDialog(this,"警告",true);
        dialog.setBounds((toolkit.getScreenSize().width-100)/2,
                (toolkit.getScreenSize().height-20)/2,150,120);
        dialog.setLayout(new FlowLayout());
        dialog.getContentPane().add(new JLabel("删除后信息无法恢复"));
        dialog.getContentPane().add(blogbutton[0]);
        dialog.getContentPane().add(blogbutton[1]);
        JDialog dialog1=new JDialog(this,"新建联系人",true);
        JTextField xM=new JTextField(8);
        JTextField hM=new JTextField(8);
        JTextField zZ=new JTextField(8);
        dialog1.setBounds((toolkit.getScreenSize().width-100)/2,
                (toolkit.getScreenSize().height-20)/2,200,180);
        dialog1.setLayout(new FlowLayout());
        Box z_box=Box.createVerticalBox();
        Box box=Box.createHorizontalBox();
        Box box1=Box.createVerticalBox();
        Box box2=Box.createVerticalBox();
        box1.add(new JLabel("联系人姓名："));
        box1.add(new JLabel("联系电话："));
        box1.add(new JLabel("住址："));
        box1.add(Box.createVerticalStrut(10));
        box2.add(xM);
        box2.add(hM);
        box2.add(zZ);
        box2.add(Box.createVerticalStrut(20));
        box.add(box1);
        box.add(box2);
        Box box3=Box.createHorizontalBox();
        box3.add(new JLabel("联系人信息不能为空!!!"));
        z_box.add(box);
        z_box.add(box3);
        dialog1.getContentPane().add(z_box);
        box3.setVisible(false);
        JButton tianjia=new JButton("添加");
        JButton quxiao=new JButton("取消");
        dialog1.getContentPane().add(tianjia);
        dialog1.getContentPane().add(quxiao);
        jmenubar.add(button1);
        jmenubar.add(button4);
        JButton button2=new JButton("查询");
        JTextField textField1,textField2;
        textField1=new JTextField(8);
        textField2=new JTextField(8);
        Box box_jiemian=Box.createVerticalBox();
        Box box_jiemian1=Box.createHorizontalBox();
        Box box_jiemian2=Box.createHorizontalBox();
        box_jiemian1.add(new JScrollPane(jTable));
        box_jiemian2.add(new JLabel("联系人:"));
        box_jiemian2.add(textField1);
        box_jiemian2.add(new JLabel("联系电话:"));
        box_jiemian2.add(textField2);
        box_jiemian2.add(button2);
        box_jiemian.add(box_jiemian1);
        box_jiemian.add(box_jiemian2);
        add(box_jiemian);
        //添加联系人
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog1.setVisible(true);
            }
        });
        tianjia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (xM.getText().length()==0||hM.getText().length()==0||zZ.getText().length()==0){
                    box3.setVisible(true);
                        return;
                }
                Contact contact=new Contact( xM.getText(),hM.getText(),zZ.getText());
                hashTab.add(contact);
                hashTab.add1(contact);
                bianli();
                zZ.setText("");
                hM.setText("");
                xM.setText("");
                try {
                    contact_file.file_write(hashTab);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("添加成功");
                hashTab.show();
                hashTab.ALS();
                hashTab.ALS1();
                box3.setVisible(false);
                dialog1.setVisible(false);
            }
        });
        quxiao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zZ.setText("");
                hM.setText("");
                xM.setText("");
                dialog1.setVisible(false);
            }
        });
        //查找
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact;
                DefaultTableModel model=B_model();
                if(textField1.getText().length()!=0&&textField2.getText().length()==0){
                    contact= hashTab.findcontactname( textField1.getText());
                    if(contact!=null){
                        String[] s1={contact.name,contact.phone,contact.address};
                        model.addRow(s1);
                    }
                    jTable.setModel(model);
                }
               else if(textField2.getText().length()!=0&&textField1.getText().length()==0){
                    contact=hashTab.findcontactphone(textField2.getText());
                    if(contact!=null){
                        String[] s1={contact.name,contact.phone,contact.address};
                        model.addRow(s1);
                    }
                   jTable.setModel(model);
                }
               else if(textField2.getText().length()!=0&&textField1.getText().length()!=0){
                    contact= hashTab.findcontactname( textField1.getText());
                    if(contact!=null){
                        String[] s1={contact.name,contact.phone,contact.address};
                        model.addRow(s1);
                    }
                    else {
                        contact=hashTab.findcontactphone(textField2.getText());
                        if(contact!=null){
                            String[] s1={contact.name,contact.phone,contact.address};
                            model.addRow(s1);
                        }
                    }
                    jTable.setModel(model);
                }



                if(textField2.getText().length()==0&&textField1.getText().length()==0){
                        bianli();
                }

            }
        });


        //删除联系人
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(jTable.getSelectedRow()!=-1){
                        dialog.setVisible(true);
                    }
            }
        });


        blogbutton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);

                DefaultTableModel model=(DefaultTableModel)  jTable.getModel();
                while (true){
                    if(jTable.getSelectedRow()!=-1){
                        hashTab.remove1((String) jTable.getValueAt(jTable.getSelectedRow(),1));
                        hashTab.remove((String) jTable.getValueAt(jTable.getSelectedRow(),0));
                        System.out.println("联系人"+jTable.getValueAt(jTable.getSelectedRow(),0)+"被删除");
                                    model.removeRow(jTable.getSelectedRow());
                    }
                    else  break;
                }
                try {
                    contact_file.file_write(hashTab);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                jTable.setModel(model);
            }
        });


        blogbutton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });


        jTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
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
        void bianli(){
            DefaultTableModel model=B_model();
            for(int i=0;i<27;i++){
                if(hashTab.hashtab()[i].getHead()!=null){
                    Contact temp= hashTab.hashtab()[i].getHead();
                    while (true){
                        model.addRow(new String[]{temp.name,temp.phone,temp.address});
                        if(temp.next==null){
                            temp=null;
                            break;
                        }
                        temp=temp.next;
                    }
                }
            }
            jTable.setModel(model);
        }
}