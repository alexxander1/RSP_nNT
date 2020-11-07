public class savage extends Thread { // Дикарь
    private pan pan;

    public savage() {}

    public savage(pan pan) {
        this.pan = pan;
    }

    @Override
    public void run() {
        pan.eat();


    }
}
