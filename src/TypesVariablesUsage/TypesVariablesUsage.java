package TypesVariablesUsage;

public class TypesVariablesUsage {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("02 データ宣言と使用");

        // 1.プリミティブ
        // byte, short, int, long, float, double, char, boolean
        String str = "テスト";
        // char chr1 = "テスト"; // Type mismatch: cannot convert from String to char
        char chr2 = 't';
        // char chr3 = "a"; // Type mismatch: cannot convert from String to char

        // 2.参照型
        // データ型---プリミティブ型
        // |---参照型‐‐‐オブジェクト型
        // |---配列型
        // |---列挙型
        // String, Date, []配列

        // 3.整数、浮動小数点数
        // 整数: byte, short, int, long
        // 浮動: double, float
        int int1 = 1;
        float flt1 = int1;
        double double1 = 1;
        char chr3 = '「';
        char chr4 = 12458;
        int int2 = (int) chr3;
        System.out.println(int2);
        System.out.println(chr4);

        // 6.変数の宣言
        int number, Number;
        boolean bol1;
        // bool bol1; // NG

        // 7.宣言方法
        byte number2 = 127;
        // String 1str; // 先頭数字NG
        String $str;
        String _str;

        // 8.boolean
        boolean bol2 = false;
        // boolean bol3 = 0; // NG

        // 9.数値
        byte num1 = 127;
        short num2 = num1; // 暗黙

        int num3 = 9999;
        // byte num4 = num3; // NG
        byte num4 = (byte) num3;
        System.out.println(num3);
        System.out.println(num4);

        float num5 = 5;
        System.out.println(num5); // [5.0]

        // 9.charの宣言
        // char c1 = "t"; NG
        char c2 = 't';
        char c3 = '\u1F1C';
        char c4 = 97;

        // 10.String の宣言
        // String str1 = 'A'; // NG
        String str2 = "A";

        // 11.定数の宣言
        final int num6 = 10;
        final int num7;
        num7 = 11;
        // num7 = 12; // NG

        // 17.配列の宣言
        int[] ary1 = new int[3];
        // int[] ary2 = new int[]; // NG
        // int() ary3 = new int[3];
        // int[3] ary4 = new int[];
        ary1[0] = 1;
        // プリミティブ型配列、オブジェクト型配列

        int[] ary5 = { 1, 2, 6 };

        // 18.配列の初期化
        System.out.println("18.配列の初期化");
        int[] ary6 = new int[3];
        for (int i : ary6) {
            System.out.println(i);
            // 初期値はすべて0になる
        }

        // 19.配列の要素数
        System.out.println(ary6.length);

        // 21.配列の添字
        // System.out.println(ary6[4]); //実行時エラーとなる(文法上は問題ないため)
    }

    // 14.インスタンス変数
    public class Document {
        private String name; // インスタンス変数(インスタンスフィールド、フィールド)
        // → インスタンスを生成するごとに変数が作られる。つまり、インスタンスごとに異なる数値を代入できる。
    }

    // 15.static
    public class Item {
        static final int int3 = 1;
        static private String name1 = "aaa";
        private static String name2 = "bbb";
        public String name3;
        // static変数、クラス変数、staticフィールド
        // クラス領域に作られるため、インスタンス間で共有される

    }

    public class ItemTest {

        public static void test() {
            System.out.println("14, 15");

            TypesVariablesUsage tvu = new TypesVariablesUsage(); // まずは外部クラスのインスタンス化
            TypesVariablesUsage.Item item1 = tvu.new Item(); // 次に内部クラスのインスタンス化
            TypesVariablesUsage.Item item2 = tvu.new Item();
            System.out.println("item1.name2");
            System.out.println(item1.name2);
            System.out.println(item1.name3);
            item1.name2 = "ccc";
            item1.name3 = "ddd";
            System.out.println("item1.name2: " + item1.name2); // name2はstatic変数
            System.out.println("item2.name2: " + item2.name2);
            System.out.println("item1.name3: " + item1.name3); // name3はインスタンス変数
            System.out.println("item2.name3: " + item2.name3);

        }

    }

}
