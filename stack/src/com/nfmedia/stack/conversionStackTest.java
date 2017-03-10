package com.nfmedia.stack;

/**
 * Description
 * <p>
 * Author rabbit.
 * Datetime 2017/3/11.
 */
public class conversionStackTest {
    public static void main(String[] args) {

        int N = 53448;
        final String sort = "0123456789ABCDEF";
        MyStack<Character> myStack = new MyStack<>(30);

        while (N != 0) {
            int mod = N % Hex.HEXADECIMAL.getNum();
            myStack.pushStack(sort.charAt(mod));
            N = N / Hex.HEXADECIMAL.getNum();
        }
        myStack.statckTraverse(true);
        myStack.destoryStatck();
    }
}

/**
 * 自定义枚举类型，带构造函数且拥有属性值的枚举类
 */
enum Hex {

    BINARY(2), OCTONARY(8), HEXADECIMAL(16);

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    Hex(int num) {
        this.num = num;
    }

}
