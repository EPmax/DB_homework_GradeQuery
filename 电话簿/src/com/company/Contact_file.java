package com.company;

import java.io.*;
import java.util.Random;

public class Contact_file {
    File file;
    Contact_file(){
        file=new File("info.txt");
        if(file.exists()){
            System.out.println("文件已经存在");
        }
        else{
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void file_read(HashTab hashTab) throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(file));
        String line;
        while((line=reader.readLine())!=null){
            String[] s=line.split(" ");
            Contact contact=new Contact(s[0],s[1],s[2]);
            hashTab.add(contact);
            hashTab.add1(contact);
        }
    }
    void file_write(HashTab hashTab) throws IOException {
        File file1=new File("info.txt");
        FileWriter writer=new FileWriter(file);
        for(int i=0;i<27;i++){
            if(hashTab.hashtab()[i].getHead()!=null){
                Contact temp= hashTab.hashtab()[i].getHead();
                while (true){
                    writer.write(temp.name+" "+temp.phone+" "+temp.address+"\n");
                    if(temp.next==null){
                        temp=null;
                        break;
                    }
                    temp=temp.next;
                }
            }
        }
        writer.flush();
        writer.close();
    }
//    void fildfsafd() throws IOException {
//        File file1=new File("adsd.txt");
//        FileWriter writer=new FileWriter(file1);
//        String[] s={"李","张","王","陈","唐","范","张","蒋","田","姚","房","赵"};
//        String[]s1={"一","二","三","四","五","六","七","八","九","明","大","晓",};
//        for(int i=0;i<12;i++){
//            for(int j=0;j<12;j++){
//                writer.write(s[i]+s1[j]+" "+(new Random()).nextInt(100000)+" "+"大连");
//            }
//        }
//        writer.flush();
//        writer.close();
//    }

}