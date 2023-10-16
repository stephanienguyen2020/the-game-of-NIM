import java.util.Random;

public class Computer {
    private int mode;
    private int choice;
    private Random random;

    /**
     * Constructor to create a Computer instance with a specified mode.
     *
     * @param m The mode of the Computer (1 for stupid mode, 2 for smart mode).
     */
    public Computer(int m) {
        mode = m;
        choice = -1;
        random = new Random();
    }

    /**
     * Method to execute one move of a Computer player.
     *
     * @param marblesLeft The number of marbles currently in the pile.
     */
    public void move(int marblesLeft) {
        switch (mode) {
            case 2:
                // Smart mode: The computer takes enough marbles to make the size of the pile
                // a power of 2 minus 1, i.e., 3, 7, 15, 31, 63.
                // Determine the appropriate power of 2 (smallest possible value to satisfy
                // the above criterion).
                int power = 0;
                if (marblesLeft >= 64) {
                    power = 6;
                } else if (marblesLeft >= 32) {
                    power = 5;
                } else if (marblesLeft >= 16) {
                    power = 4;
                } else if (marblesLeft >= 8) {
                    power = 3;
                } else if (marblesLeft > 4) {
                    power = 2;
                } else if (marblesLeft >= 2) {
                    power = 1;
                } else {
                    power = 0;
                }
                // Check if the current size of the pile is already 1 less than a power of 2:
                // If not, proceed with smart mode, i.e., make the size of the pile
                // one less than a power of 2.
                if (marblesLeft + 1 != (int) (Math.pow(2, (power + 1)))) {
                    choice = marblesLeft - (int) (Math.pow(2, power)) + 1;
                }
                break;
            case 1:
                // Stupid mode: The computer takes a random legal value (between 1 and n/2)
                // whenever it has a turn.
                if (marblesLeft == 1) {
                    choice = 1;
                } else {
                    choice = 1 + random.nextInt(marblesLeft / 2);
                }
                break;
        }
    }

    /**
     * Method to access the choice of the Computer player.
     *
     * @return The number of marbles the Computer player took.
     */
    public int getChoice() {
        return choice;
    }
}
