package Lesson7;

public class InheritancePolymorphism {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("07 継承とポリモーフィズム");

        // No.2
        class A2 {
            void methodA() {
                System.out.println("2 methodA");
            }
        }

        class B2 extends A2 {
            void methodB() {
                System.out.println("2 methodB");
            }
        }

        class Sample2 extends B2 {
            void methodSample() {
                System.out.println("2 Sample");

            }
        }
        Sample2 smpl2 = new Sample2();
        smpl2.methodSample(); // OK
        smpl2.methodA(); // OK
        smpl2.methodB(); // OK
        // ---------------------------------------------------------------

        // No.3 スーパークラス、サブクラス、差分3つのインスタンス
        class SuperClass3 {
            private int num;

            public void setNum(int num) {
                this.num = num;
            }
        }

        class SubClass3 extends SuperClass3 {
            private int num; // スーパークラスと同一名称のフィールド

            public int getNum() {
                return this.num;
            }
        }

        SubClass3 subClass3 = new SubClass3();
        subClass3.setNum(33); // スーパークラスのメソッドを呼び出して、スーパークラスのフィールドに値をセット
        System.out.println("subClass3.num: " + subClass3.getNum()); // getNum()はサブクラスのメソッドのためnumはサブクラスのフィールド
        // ---------------------------------------------------------------

        // No.4 継承
        class SuperClass4 {
            private int num4;
            final String str4 = "final4";

            public int method4() {
                return num4;
            }

            public SuperClass4(int num4) {
                this.num4 = num4;
            }
        }

        class SubClass4 extends SuperClass4 {
            // コンストラクタは引き継げない、そもそもクラス名が異なる
            public SubClass4(int num4) {
                super(num4);
            }
        }

        SubClass4 subClass4 = new SubClass4(44);
        System.out.println(subClass4.method4()); // publucなメソッドOK
        System.out.println("subClass4.str4" + subClass4.str4); //
        // System.out.println(subClass4.num4); // privateなインスタンスフィールドNG
        // ---------------------------------------------------------------

        // No.5 継承 コンストラクタ
        class SuperClass5 {
            public SuperClass5() {
                System.out.println("SuperClass5 Constructor");
            }
        }

        class SubClass5 extends SuperClass5 {
            public SubClass5() {
                // super(); // 自動追加
                System.out.println("SubClass5 Constructor");
            }
        }

        SubClass5 subClass5 = new SubClass5();
        // インスタンス作成時に、サブクラスのコンストラクターの先頭行でSuper()が自動で実行される.
        // そのため、サブクラスのインスタンスを作成時は下記の実行順になる.
        // 1. スーパークラスのインスタンス作成+コンストラクター実行
        // 2. 差分クラスのインスタンス作成+コンストラクター実行
        // という順番で処理が行われる.
        // SuperClass5 Constructor
        // SubClass5 Constructor
        // ---------------------------------------------------------------

        // No.6
        class SuperClass6 {
            public SuperClass6(String val) {
                System.out.println("SuperClass6: " + val);
            }
        }

        class SubClass6 extends SuperClass6 {
            public SubClass6() {
                super("aaa"); // コンストラクター引数の数型順が異なる場合、明示的にsuper()を追加しないとコンパイルエラーになる.
            }

            public void test() {
                System.out.println("SubClass6");
            }
        }
        // ---------------------------------------------------------------

        // No.8 継承+コンストラクター
        class SuperClass8 {
            public SuperClass8(String val1) {
                System.out.println("SuperClass8 Constructor val: " + val1);
            }
        }

        class SubClass8 extends SuperClass8 {
            public SubClass8() {
                // super("SubClass8!");
                this("B");
                // コンストラクターを呼び出すのは先頭1行だけ.ここでは2回呼び出そうとしているのでコンパイルエラーになる.
                // super()とthis()を同時につい買うことはできない.
                // ので、下のコンストラクターに
            }

            // ↓ コンストラクターをオーバーロードしている
            public SubClass8(String val2) {
                super("SubClass8!!" + val2);
            }
        }

        new SubClass8();
        // ---------------------------------------------------------------

        // No.10 オーバーライド(再定義)
        class SuperClass10 {
            protected void hello() {
                System.out.println("SuperClass10 hello()");
            }

            public SuperClass10 method1() {
                System.out.println("SuperClass10 method1()");
                SuperClass10 aaa = new SuperClass10();
                return aaa;
            }
        }
        // ↓ オーバーライド(他クラスで再定義)
        class SubClass10 extends SuperClass10 {
            protected void hello() {
                System.out.println("SubClass10 hello");
            }

            // ↓サブクラスの型に変更してオーバーライド可能
            public SubClass10 method1() {
                System.out.println("SubClass10 method1()");
                SubClass10 bbb = new SubClass10();
                return bbb;
            }
            // オーバーライドは、アクセス修飾子を厳しい方に変更するのは不可(Ex.protected → private).
            // ゆるくする方は可能(Ex.無印 → public)
        }

        SuperClass10 superClass10 = new SuperClass10();
        superClass10.hello();
        superClass10.method1();
        SubClass10 subClass10 = new SubClass10();
        subClass10.hello();
        subClass10.method1();
        // ---------------------------------------------------------------

        // No.11 オーバーライドしたときの例外処理
        class SuperClass11 {
            public void method11() throws RuntimeException, IndexOutOfBoundsException {
                System.out.println("SuperClass11 method11A");
            }
        }

        class SubClass11A extends SuperClass10 {
            public void method11() { // ← オーバーライドしたメソッドで例外を発生させる必要なし.throwは無くてもOK.
                System.out.println("SubClass11 method11A");
            }
        }

        class SubClass11B extends SuperClass11 {
            public void method11() throws ArrayIndexOutOfBoundsException { // ← オーバーライドしたメソッドで例外の数を減らすのはOK.
                System.out.println("SubClass11 method11A");
            }
        }

        class SubClass11C extends SuperClass11 {
            public void method11() throws NullPointerException, ArrayIndexOutOfBoundsException {
                // ↑ オーバーライドした例外のサブクラスはOK.
                // RuntimeException.NullPointerException
                // IndexOutOfBoundsException.ArrayIndexOutOfBoundsException
                System.out.println("SubClass11 method11A");
            }
        }

        SuperClass11 superClass11 = new SuperClass11();
        superClass11.method11();
        // ---------------------------------------------------------------

        // No.12
        class SuperClass12 {
            public void method12() {
                System.out.println("SuperClass12 method12()");
            }
        }

        class SubClass12 extends SuperClass12 {
            public void method12() {
                // super(); // ← コンストラクターではないので使えない.
                super.method12();
                System.out.println("SubClass12 method12()");
            }
        }

        SubClass12 subClass12 = new SubClass12();
        subClass12.method12();
        // ---------------------------------------------------------------

        // No.13/14 Interface内フィールド/メソッドの修飾子
        // インターフェースは、「情報隠蔽」のうちの公開する側の情報を記述するのに使う.
        interface interface13A {
            static int test1 = 0;
            final String test2 = "aaa";
            public int test3 = 1;
            // private int test4 = 3; // NG. only public, static & final are permitted

            static void method1() {
                System.out.println("method1()");
            }

            abstract void method2();

            private void method3() {
            };

        }

    }

}
