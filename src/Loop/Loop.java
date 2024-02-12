package Loop;

public class Loop {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("04 Loop文");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println("LOOP1");
            }
        }

        for (int i = 0; i < 3; i++) {
            int j = 0;
            do {
                j++;
                System.out.println("LOOP2");
            } while (j < i);
        }

        for (int i = 0; i > 3; i++) {
            System.out.println("LOOP3");
        }
    }
}
