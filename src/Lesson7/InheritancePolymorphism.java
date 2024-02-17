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

    }
}
