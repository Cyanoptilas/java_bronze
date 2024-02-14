package test5_11;

public class SampleFactory {
    public static Sample create() {
        System.out.println("create in SampleFactory");
        return new SampleImpl();
    }

    public static void main(String[] args) {

        SampleImpl aaa = new SampleImpl();
        Sample bbb = SampleFactory.create();
        aaa.hello();
        // bbb.hello();
        System.out.println(aaa);
        System.out.println(bbb);

    }
}
