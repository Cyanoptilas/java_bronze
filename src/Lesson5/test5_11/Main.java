package Lesson5.test5_11;

public class Main {
    public static void main(String[] args) {
        Sample s1 = SampleFactory.create();
        s1.hello();
        // s1.hello2(); // The method hello2() is undefined for the type Sample

        Sample s2 = new SampleImpl(); // ← SampleImplコンストラクターがpublicではない場合、同一パッケージのときインスタンス作成できる。
        s2.hello();
    }
}
