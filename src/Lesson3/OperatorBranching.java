package Lesson3;

public class OperatorBranching {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("03 演算子と分岐文");

        // 1. Division
        System.out.println(5 / 2); // 2
        System.out.println(5.0 / 2); // 2.5

        // 10.インクリメントデクリメント演算子
        int a = 2;
        int b = 5;
        System.out.println(a++); // 後置インクリメント 後で実行
        System.out.println(a);
        System.out.println(++b); // 前置インクリメント 前もって実行
        System.out.println(b);
        int c = 10, d = 5;
        System.out.println(c++ + --d); // 10 + 4 = 14 c++はprint処理後に実行される
        System.out.println(c + d); // 11 + 4 = 15

        // 19.switch文の式
        double dbl19 = 1.5;
        switch (b) {
            // case 1.5: // double, floatはNG
            // System.out.println(b);
            // break;

            case 1:
                System.out.println(b);
                break;

            default:
                break;
        }

    }

}
