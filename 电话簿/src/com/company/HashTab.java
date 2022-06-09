package com.company;

public class HashTab{
    private final ContactLinkedList[] contactLink;
    private final int size = 37;

    public HashTab() {
        contactLink = new ContactLinkedList[size];
        for (int i = 0; i <size; i++) {
            contactLink[i] = new ContactLinkedList();
        }
    }

    public int hashFun(String name) {
        return map(name) % 27;
    }

    public int hashFun1(String phone) {
        return ((int)phone.charAt(0)-48)%10+27;
    }
    //添加
    public void add1(Contact contact) {
        int con = hashFun1(contact.phone);
        contactLink[con].add(contact);
    }

    //添加
    public void add(Contact contact) {
        int con = hashFun(contact.name);
        contactLink[con].add(contact);
    }

    //删除
    public void remove(String name) {
        int con = hashFun(name);
        contactLink[con].remove(name);
    }

    //删除
    public void remove1(String phone) {
        int con = hashFun1(phone);
        contactLink[con].remove1(phone);
    }

    //查找
    public Contact findcontactname(String name) {
        int con = hashFun(name);
        Contact contact = contactLink[con].findContact(name);
        if (contact != null) {
            System.out.println("找到");
            return contact;
        } else {
            //未找到
            return null;
        }
    }
    //查找
    public Contact findcontactphone(String phone) {
        int con = hashFun1(phone);
        Contact contact = contactLink[con].findContact1(phone);
        if (contact != null) {
            System.out.println("找到");
            return contact;
        } else {
            //未找到
            System.out.println("未找到");
            return null;
        }
    }

    //返回链表
    public ContactLinkedList[] hashtab() {
        return contactLink;
    }

    public int map(String name) {
        String c = chineseinital.getFirstLetter(name);
        if ((c.charAt(0) >= 'A' && c.charAt(0) <= 'Z') || (c.charAt(0) >= 'a' && c.charAt(0) <= 'z')) {
            c = c.toLowerCase();
            return (int) c.charAt(0) - 97;
        } else return 26;
    }


    public void ALS() {
        double j=0,k=0,n=0,m=0;
        for (int i = 0; i < 27; i++) {
            j=contactLink[i].ALS();
            n=n+j;
            j=((j+1)*j)/2;
            k=k+j;
        }
        k=k/n;
        m=n/27;
        System.out.println("姓名哈希表查找成功的平均查找长度："+k);
        System.out.println("姓名哈希表查找不成功的平均查找长度："+m);
    }


    public void ALS1() {
        double j=0,k=0,n=0,m=0;
        for (int i =27; i < 37; i++) {
            j=contactLink[i].ALS();
            n=n+j;
            j=((j+1)*j)/2;
            k=k+j;
        }
        k=k/n;
        m=n/10;
        System.out.println("电话哈希表查找成功的平均查找长度："+k);
        System.out.println("电话哈希表查找不成功的平均查找长度："+m);
    }
    //显示全部
    public void show(){
        for (int i=0;i<size;i++){
            if(i==27) System.out.println("--------------------");
            if (i==0) System.out.println("姓名哈希表");
            if(i==27) System.out.println("号码哈希表");
            System.out.println("链"+i+"---->");
            contactLink[i].show();
        }
    }
}




