package com.nfmedia.sequence;

/**
 * Description
 * <p> 顺序表测试用例
 * Author rabbit.
 * Datetime 2017/3/15.
 */
public class TestSequenceList {
    public static void main(String[] args) throws Exception {
        SequenceList<Student> sequenceList = new SequenceList<>(10);

        Student jack = new Student("jack", "jack@nfmedia.com", 11);
        Student lucy = new Student("lucy", "lucy@nfmedia.com", 21);
        Student lily = new Student("lily", "lily@nfmedia.com", 31);
        Student rose = new Student("rose", "rose@nfmedia.com", 41);
        Student mike = new Student("mike", "mike@nfmedia.com", 51);
        Student david = new Student("david", "david@nfmedia.com", 61);
        Student brown = new Student("brown", "brown@nfmedia.com", 71);
        Student noone = new Student("noone", "brown@nfmedia.com", 11111);

        sequenceList.insertList(0, jack);
        sequenceList.insertList(1, lucy);
        sequenceList.insertList(2, lily);
        sequenceList.insertList(3, rose);
        sequenceList.insertList(4, mike);
        sequenceList.insertList(5, david);
        sequenceList.insertList(6, brown);

        Student pop = sequenceList.listDelete(0);

        System.out.println("删除的元素是：" + pop);
        System.out.println("线性表当前元素个数为：" + sequenceList.listSize());
        System.out.println("链表第一个元素为：" + sequenceList.getElem(0));
        System.out.println("查找链表中元素是mike的位置：" + sequenceList.locateElem(mike));
        System.out.println("查找链表中元素是noone的位置：" + sequenceList.locateElem(noone));

        if (sequenceList.isListPrev(noone)) {
            System.out.println("元素noone的前驱元素是：" + sequenceList.getPrevElement(noone));
        } else {
            System.out.println("元素noone没有前驱元素");
        }

        if (sequenceList.isListNext(rose)) {
            System.out.println("元素rose的后继元素是：" + sequenceList.getNextElement(rose));
        } else {
            System.out.println("没有后继元素");
        }

        //sequenceList.cleanList();
        //sequenceList.destroyList();
        sequenceList.listTraverse();
    }
}
