package com.nfmedia.sequence;

/**
 * Description
 * <p>  顺序表
 * Author rabbit.
 * Datetime 2017/3/15.
 */
public class SequenceList<T> {

    private int s_length;       // 顺序表的长度
    private int s_capacity;     // 顺序表的容量
    private T[] sequenceList;   // 用数组来存放顺序链表元素

    @SuppressWarnings("unchecked")
    public SequenceList(int s_capacity) {
        this.s_capacity = s_capacity;
        s_length = 0;
        sequenceList = (T[]) new Object[s_capacity];
    }

    /**
     * 顺序表的长度
     *
     * @return
     */
    public int listSize() {
        return this.s_length;
    }

    /**
     * 检查顺序表是否为空
     *
     * @return
     */
    public boolean isListEmpty() {
        return 0 == s_length;
    }

    /**
     * 检查顺序表是否已满
     *
     * @return
     */
    public boolean isListFull() {
        return s_length == s_capacity;
    }

    /**
     * 判断某元素是否存在前驱
     *
     * @param elem
     * @return
     */
    public boolean isListPrev(T elem) {
        int locate = locateElem(elem);
        return locate != -1 && locate != 0;
    }

    /**
     * 判断某元素是否存在后继
     *
     * @param elem
     * @return
     */
    public boolean isListNext(T elem) {
        int locate = locateElem(elem);
        return locate != -1 && locate != s_length - 1;
    }

    /**
     * 获取指定元素
     *
     * @param pos
     * @return
     */
    public T getElem(int pos) {
        if (pos < 0 || pos > s_length) {
            return null;
        }
        return sequenceList[pos];
    }

    /**
     * 获取第一个满足e的数据元素的位置
     *
     * @param elem
     * @return
     */
    public int locateElem(T elem) {
        int res = -1;
        for (int k = 0; k < s_length; k++) {
            if (sequenceList[k] == elem) {
                res = k;
                break;
            }
        }
        return res;
    }

    /**
     * 遍历顺序表
     */
    public void listTraverse() {
        for (int index = 0; index < s_length; index++) {
            System.out.println(sequenceList[index]);
        }
    }

    /**
     * 获取某位置元素的前驱
     *
     * @return
     */
    public T getPrevElement(T elem) {
        if (!isListPrev(elem)) {
            return null;
        }
        int locate = locateElem(elem);
        return sequenceList[locate - 1];
    }

    /**
     * 获取某位置元素的后继
     *
     * @param elem
     * @return
     */
    public T getNextElement(T elem) {
        if (!isListNext(elem)) {
            return null;
        }
        int locate = locateElem(elem);
        return sequenceList[locate + 1];
    }

    /**
     * 在指定顺序表位置插入元素
     *
     * @param pos
     * @param elem
     */
    public void insertList(int pos, T elem) throws Exception {
        if (isListFull()) {
            System.out.println("当前链表已满，无法插入元素");
            throw new Exception("链表已满");
        }

        if (pos < 0 || pos > s_length) {
            System.out.println("插入位置不符合");
            throw new Exception("插入位置不符合");
        }

        // 从链表尾部循环，将数据向后移动
        for (int k = s_length - 1; k >= pos; k--) {
            sequenceList[k + 1] = sequenceList[k];
        }
        // 插入元素，链表长度增加
        sequenceList[pos] = elem;
        s_length++;
    }

    /**
     * 删除指定位置的元素
     *
     * @param pos
     */
    public T listDelete(int pos) throws Exception {
        T pop = sequenceList[pos];
        if (isListEmpty()) {
            System.out.println("链表为空，无法删除");
            throw new Exception("链表为空");
        }
        for (int k = pos; k < s_length; k++) {
            sequenceList[k] = sequenceList[k + 1];
        }
        s_length--;
        return pop;
    }

    /**
     * 清空顺序表
     */
    public void cleanList() {
        s_length = 0;
    }

    /**
     * 销毁顺序表
     */
    public void destroyList() {
        sequenceList = null;
    }

}
