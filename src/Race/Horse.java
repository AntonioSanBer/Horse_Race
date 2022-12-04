package Race;

import java.util.Observable;

public class Horse extends Observable implements Runnable {
    private String name;


    public Horse(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int length = 0;
        int randomNumber;

        try {
            while (length < 100) {
                randomNumber = RandomNumber(1, 15);
                System.out.println("Race.Horse " + name + " increments " + randomNumber);
                length += randomNumber;

                this.setChanged();
                this.notifyObservers(length);
                this.clearChanged();

                Thread.sleep(1000);
            }

        } catch (InterruptedException ex) {
            System.out.println("Thread stopped");
        }
    }

    public static int RandomNumber(int min, int max) {

        return (int) Math.floor(Math.random() * (max - min + 1) + (min));
    }

    public String getName() {
    return name;
    }
}
