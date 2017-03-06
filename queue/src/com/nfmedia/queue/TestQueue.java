package com.nfmedia.queue;

/**
 * Description
 * <p>
 * Author rabbit.
 * Datetime 2017/3/6.
 */
public class TestQueue {
    public static void main(String[] args) {

        CircleQueue<Student> circleQueue = new CircleQueue<>(4);
        System.out.println("########################## 插入元素 ####################################");
        circleQueue.EnQueue(new Student("jack", "jack@nfmedia.com", 12));
        circleQueue.EnQueue(new Student("lucy", "lucy@nfmedia.com", 23));
        circleQueue.EnQueue(new Student("alice", "alice@nfmedia.com", 35));
        circleQueue.EnQueue(new Student("rose", "rose@nfmedia.com", 45));
        circleQueue.QueueTraverse();

        System.out.println();
        System.out.println("########################## 删除元素 ####################################");
        circleQueue.DelQueue();
        circleQueue.DelQueue();
        circleQueue.QueueTraverse();

        System.out.println();
        System.out.println("########################## 插入元素 ####################################");
        circleQueue.EnQueue(new Student("brown", "brown@nfmedia.com", 18));
        circleQueue.EnQueue(new Student("tiffany", "tiffany@nfmedia.com", 27));
        circleQueue.QueueTraverse();
    }
}
