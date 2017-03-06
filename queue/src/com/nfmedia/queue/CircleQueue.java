package com.nfmedia.queue;

/**
 * 环形队列
 */
public class CircleQueue<T> {
    private int c_queueLength;      // 队列长度
    private int c_queueCapacity;    // 队列容量大小
    private int c_head;             // 队列头指针
    private int c_tail;             // 队列尾指针
    private T[] queueList;          // 定义一个数组队列

    /**
     * 判断队列是否为空
     */
    public boolean isQueueEmtpy() {
        return c_queueLength == 0;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isQueueFull() {
        return c_queueLength == c_queueCapacity;
    }

    /**
     * 增加一个元素进入队列
     */
    public void EnQueue(T t) {
        if (isQueueFull()) {
            System.out.println("插入当前元素：" + t + "失败，队列已满，请扩充队列或移除队列元素");
        } else {
            queueList[c_tail] = t;                      // 给元素赋值
            c_tail = (c_tail + 1) % c_queueCapacity;    // 队列尾指针移动
            c_queueLength++;                            // 队列元素+1
        }
    }

    /**
     * 从队列中删除一个元素，并返回这个元素
     */
    public T DelQueue() {
        if (isQueueEmtpy()) {
            System.out.println("队列为空，不能进行删除元素操作");
            return null;
        } else {
            T res = queueList[c_head];                  // 将要删除的元素保存
            queueList[c_head] = null;                   // 将删除的元素置为null
            c_head = (c_head + 1) % c_queueCapacity;    // 队列头指针移动
            c_queueLength--;                            // 队列元素-1
            return res;
        }
    }

    /**
     * 清空队列
     */
    public void CleanQueue() {
        c_head = 0;
        c_tail = 0;
        c_queueLength = 0;
    }

    /**
     * 遍历整个队列元素
     */
    public void QueueTraverse() {
        for (int i = c_head; i < c_queueLength + c_head; i++) {
            System.out.println(queueList[i % c_queueCapacity]);
        }
    }

    /**
     * 返回队列的元素个数
     */
    public int realSize() {
        return c_queueLength;
    }

    /**
     * 环形队列初始化
     * 如果不使用注解，编译器无法通过编译
     */
    @SuppressWarnings("unchecked")
    public CircleQueue(int capacity) {
        this.c_queueCapacity = capacity;
        this.queueList = (T[]) new Object[(capacity < 0 ? 4 : capacity)];
        this.CleanQueue();
    }

    /**
     * 销毁队列
     */
    public void DestoryQueue() {
        queueList = null;   // 变量不在被引用后，会由JVM自动回收垃圾
    }

}