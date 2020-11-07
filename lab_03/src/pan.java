import java.util.ArrayList;
import java.util.List;

public class pan { // Кастрюля с N-порциями еды
    private List<savage> savages;
    private int N = 0;
    private volatile int portion = 0;

    public pan() {}

    public pan(int portion) {
        this.portion = portion;
        savages = new ArrayList<>();
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public synchronized void cook(int N) throws InterruptedException {
        boolean treat=true;
        while (treat){
            if (portion>0){
                wait();
            }else {
                notifyAll();
                setPortion(N);
                System.out.print(this.getPortion() + " порций уже на подходе\n");
                treat = false;}

        }

    }

    public synchronized void eat() {
            try {
                boolean treat = true;
                while (treat) {
                    if (portion > 0) {
                        notifyAll();
                        portion--;
                        System.out.print(this.getPortion() + "\n");
                        treat = false;
                    } else {
                        wait();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
}
