package Lesson5;

/**
 * AboutObjectOriented
 */
class AboutObjectOriented {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("05 オブジェクト指向の概念");

        AboutObjectOriented aboutObjectOriented = new AboutObjectOriented();

        // 1. カプセル化
        // → 関係あるものをひとまとめにする。
        // 関係するデータをまとめ、そのデータを使う処理をまとめる。
        // Ex. 「自動車」といわれれば、ハンドル、エンジン、ブレーキなどがあるとわかる。
        // ハンドル、エンジン、ブレーキなどがあると言われれば、自動車であるとわかる。

        // 2. カプセル化
        Employee emp1 = aboutObjectOriented.new Employee(12, "aaa");
        System.out.println("emp1.getName(); => " + emp1.getName());
        System.out.println("emp1.getEmployeeNo(); => " + emp1.getEmployeeNo());
        emp1.greet();

        // 7. ポリモーフィズム
        System.out.println("7. ポリモーフィズム");
        A a = aboutObjectOriented.new B();
        a.test();

        // 8. 抽象化
        Parent parent1 = aboutObjectOriented.new Child();
        // parent1.test("aaa"); // NG
        parent1.test();
        // サブクラスを抽象化してスーパークラスの型として扱った場合、スーパークラスの定義とは共通しないサブクラス独自のメソッドは無視される。
        // サブクラス独自の定義 ＝ オーバーロード(異なるシグニチャのメソッドをサブクラスで定義)

        Child parent2 = aboutObjectOriented.new Child();
        parent2.test("aaa"); // OK

        // 10,11. 情報隠蔽(データ隠蔽とは別もの)
        // → 抽象化によって切り離した部分は公開し、それ以外の部分はすべて隠蔽する、という設計原則のこと。
        // (公開すべきものとすべきないものを分ける)

        // 公開すべきものはインターフェースとして定義する
        // 公開するメソッドもインターフェースに集める

        // 公開すべきないものは、パッケージ化してpublic以外の修飾子を適切に付与する

        // 12. インターフェース
        // ・実装を持たないメソッド、定数のみ宣言可能
        // ・インスタンス化不可(実装がないため)
        // ・クラスの型を表すもの

        // 14. has-a
        class B14 {
            // any
        }

        class A14 {
            private B14 b14; // ← A has-a B Aクラスは、B型のフィールドを持つ
            // 例：自動車 has-a エンジン. 自動車クラスはエンジン型のフィールドを持つ.
        }
    }

    // 15. is-a
    // 分類関係を表す
    // 例：自動車クラスは乗り物クラスである.
    // サブクラス is-a スーパークラス
    // 実装クラス is-a インターフェース
    // 下記の場合、
    // B is-a A
    // C is-a B
    // C is-a A
    // D is-a A
    interface A15 {
        void methodA15();
    }

    abstract class B15 implements A15 {
        void methodB15() {
            System.out.println("B15 method");
        };
    }

    class C15 extends B15 {
        @Override
        public void methodA15() {
            System.out.println("methodA15 in B15");
        }
    }

    class D15 implements A15 {
        @Override
        public void methodA15() {
            System.out.println("methodA15 in D15");

        }

        void methodD15() {
            System.out.println("D15 method");
        }

    }

    // 2. カプセル化
    public class Employee {
        private int employeeNo;
        private String name;

        public Employee(int employeeNo, String name) {
            this.employeeNo = employeeNo;
            this.name = name;
        }

        public int getEmployeeNo() {
            return employeeNo;
        }

        public String getName() {
            return this.name;
        }

        // 上記データを必要とするメソッドもクラスにまとめる
        public void greet() {
            System.out.println("Hi, I'm " + name);

        }

    }

    // 7. ポリモーフィズム
    public class A {
        public void test() {
            System.out.println("A");
        }
    }

    public class B extends A {
        public void test() {
            System.out.println("B");
            // Aのtestメソッドをオーバーライド(同じシグニチャで上書き)
            // シグニチャ：メソッド名、引数の型、引数の数がすべて同じ
        }
    }

    // 8. 抽象化
    public class Parent {
        public void test() {
            System.out.println("Parent");
        }
    }

    public class Child extends Parent {
        public void test(String str) {
            System.out.println("Child: " + str);
        }
    }

}
