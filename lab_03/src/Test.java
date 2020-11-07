import java.util.ArrayList;
import java.util.List;

public class Test {
    private static pan pan;
    private static final int SAVAGE = 15;
    private static final int PORTION = 10;
    private static List<savage> savageList;
    private static chef chef;

    public Test() {
        savageList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Test test = new Test();
        pan = new pan(PORTION);

        for (int i = 0; i < SAVAGE; i++) {
            savageList.add(new savage(pan));
        }

        for (int j = 0; j < SAVAGE; j++) {
            savageList.get(j).start();
            System.out.println();
        }

        chef = new chef(pan);
        chef.start();
    }
}
