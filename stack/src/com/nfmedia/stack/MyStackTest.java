package com.nfmedia.stack;

/**
 * Description
 * <p>
 * Author rabbit.
 * Datetime 2017/3/8.
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Student> myStack = new MyStack<>(10);
        System.out.println("############## 插入元素 #################");
        myStack.pushStack(new Student("jack", "jack@nfmedia.com", 14));
        myStack.pushStack(new Student("lucy", "lucy@nfmedia.com", 26));
        myStack.pushStack(new Student("kobe", "kobe@nfmedia.com", 33));
        System.out.println("###############正序输出##############");
        myStack.statckTraverse(true);

        System.out.println("################删除元素###############");
        myStack.popStack();
        myStack.popStack();

        System.out.println("################逆序输出###############");
        myStack.statckTraverse(false);

        System.out.println("################清除栈###############");
        myStack.cleanStack();
        myStack.statckTraverse(true);

        System.out.println("################销毁栈###############");
        myStack.destoryStatck();
        myStack.statckTraverse(true);
    }

}
