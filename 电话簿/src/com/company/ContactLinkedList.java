package com.company;

public  class ContactLinkedList {
    private Contact head = null;


    //添加
    public void add(Contact contact) {
        if (head == null) {
            head = new Contact(contact.name,contact.phone,contact.address);
            return;
        }
        Contact temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next =new Contact(contact.name,contact.phone,contact.address);
    }

    //删除
    public void remove1(String phone) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Contact temp = head;
        while (true) {
            if (temp.phone .equals(phone)) {
                head = head.next;
                break;
            }
            if (temp.next.phone .equals(phone)) {
                temp.next = temp.next.next;
                break;
            }
            if (temp.next == null) {
                return;
            }
            temp = temp.next;
        }
    }

    //删除
    public void remove(String name) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Contact temp = head;
        while (true) {
            if (temp.name .equals(name)) {
                head = head.next;
                break;
            }
            if (temp.next.name.equals(name)) {
                temp.next = temp.next.next;
                break;
            }
            if (temp.next == null) {
                return;
            }
            temp = temp.next;
        }

    }

    //查找
    public Contact findContact1(String phone) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Contact temp = head;
        while (true) {
            if (temp.phone.equals(phone)) {
                break;
            }
            if (temp.next == null) {
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }

    //查找
    public Contact findContact(String name) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Contact temp = head;
        while (true) {
            if (temp.name.equals(name)) {
                break;
            }
            if (temp.next == null) {
                temp = null;
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }

    public Contact getHead() {
        return head;
    }

    //平均查找长度
    double ALS() {
        if (head == null) {
            return 0;
        }
        double i=0;
        Contact temp = head;
        while (temp!=null) {
            i=i+1;
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        return i;
    }

    //显示所有
    void show() {
        if (head == null) {
            System.out.println("此链为空");
            return;
        }
        Contact temp = head;
        while (temp!=null) {
            if (temp.next == null) {
                System.out.printf("姓名：%s\t电话：%s\t住址:%s----->",temp.name,temp.phone,temp.address);
                break;
            }
            System.out.printf("姓名：%s\t电话：%s\t住址：%s----->",temp.name,temp.phone,temp.address);
            temp = temp.next;
        }
        System.out.println();
        return;
    }
}

