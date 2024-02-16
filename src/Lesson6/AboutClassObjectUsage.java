package Lesson6;

/**
 * AboutClassObjectUsage
 */
public class AboutClassObjectUsage {

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("06 クラス定義とオブジェクトの使用");

        // 15, 16, 17. this() / this.XXX
        class ConfirmThis {
            int count1;

            //
            ConfirmThis() {
                // if(true ){System.out.println("");}
                this(10); // ← 先頭行でのみ使用可能.同シグネチャのコンストラクターを呼び出す.

            }

            ConfirmThis(int count) {
                count1 = count; // このthisはインスタンスそのものを指す.
                // thisを付与しなかった場合、ローカル変数を指すことになる.
                System.out.println(count1);
                count = count; // ← 意味ない
            }
        }
        ConfirmThis aaa = new ConfirmThis();

        // 20.static変数
        // インスタンス化しなくても利用可能な変数
        class ConfirmStatic {
            static int aaa = 1;
            public int bbb = 2;
        }
        System.out.println(ConfirmStatic.aaa);
        // System.out.println(ConfirmStatic.bbb); // ← staticじゃないのでコンパイルエラー
        // Cannot make a static reference to the non-static field ConfirmStatic.bbb

        ConfirmStatic cs1 = new ConfirmStatic();
        ConfirmStatic cs2 = new ConfirmStatic();
        System.out.println("変更前" + cs1.aaa);
        System.out.println("変更前" + cs2.aaa);
        ConfirmStatic.aaa = 3;
        System.out.println("変更後" + cs1.aaa);
        System.out.println("変更後" + cs2.aaa);
        // static変数はインスタンスごとではなく、すべてのインスタンスで共通する値として保持される.

    }
}