import java.util.Scanner;

public class Human {
    private int choice;
    private Scanner input;

    /**
     * Constructor to create a Human instance.
     */
    public Human() {
        input = new Scanner(System.in);
        choice = -1;
    }

    /**
     * Method to allow the human player to choose the number of marbles to take from the pile.
     */
    public void move() {
        System.out.println("How many marbles would you like to take?");
        choice = input.nextInt();
        
        while (choice <= 0) {
            System.out.print("You must take at least 1 marble. Try again: ");
            choice = input.nextInt();
        }
    }

    /**
     * Method to access the choice made by the human player.
     *
     * @return choice The number of marbles the human player took.
     */
    public int getChoice() {
        return choice;
    }
}
