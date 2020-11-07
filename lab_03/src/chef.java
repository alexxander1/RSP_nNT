public class chef extends Thread { // Повар
    pan pan;

    public chef() {}

    public chef(pan pan) {
        this.pan = pan;
    }

    @Override
    public void run() {
        try {
            pan.cook(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
