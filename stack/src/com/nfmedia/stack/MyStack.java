package com.nfmedia.stack;

/**
 * Description
 * <p>  带泛型的栈类
 * Author rabbit.
 * Datetime 2017/3/8.
 */
public class MyStack<T> {

    private int stackTop;       // 栈的头指针
    private int statckCapacity; // 栈的容量
    private T[] statckList;     // 栈元素

    /**
     * 判断栈是否为空
     */
    public boolean isStackEmpty() {
        return 0 == stackTop;
    }

    /**
     * 判断栈是否为满
     */
    public boolean isStackFull() {
        return stackTop == statckCapacity;
    }

    /**
     * 清空栈元素
     */
    public void cleanStack() {
        stackTop = 0;
    }

    /**
     * 销毁栈
     */
    public void destoryStatck() {
        statckList = null;
    }

    /**
     * 在栈中添加一个对象
     *
     * @param t 栈对象
     */
    public void pushStack(T t) {
        if (isStackFull()) {
            System.out.println("栈空间已满！");
        } else {
            statckList[stackTop] = t;
            stackTop++;
        }
    }

    /**
     * 从栈中删除一个元素
     */
    public T popStack() {
        if (isStackEmpty()) {
            System.out.println("栈空间不存在元素，不能删除！");
            return null;
        } else {
            stackTop--;
            return statckList[stackTop];
        }
    }

    @SuppressWarnings("unchecked")
    public MyStack(int size) {
        statckCapacity = size;
        stackTop = 0;
        statckList = (T[]) new Object[size < 0 ? 4 : size];
    }

    /**
     * 遍历栈元素
     */
    public void statckTraverse(boolean order) {
        // order为true，表示从栈顶像栈底显示，为false表示从栈底像栈顶方向显示元素
        if (order) {
            for (int i = stackTop - 1; i >= 0; i--) {
                System.out.println(statckList[i]);
            }
        } else {
            for (int i = 0; i < stackTop; i++) {
                System.out.println(statckList[i]);
            }
        }
    }
}
