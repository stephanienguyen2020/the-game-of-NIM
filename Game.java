import java.util.Random;

public class Game {
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    private Random random;

    public Game(int difficulty) {
        // Instantiate computer player with the specified difficulty
        computerPlayer = new Computer(difficulty);
        humanPlayer = new Human();
        // Set the initial size of the pile (between 10 and 100, inclusive)
        random = new Random();
        marbles = 10 + random.nextInt(91);
    }

    /**
     * Method to randomly determine the first player (0 for computer, 1 for human).
     *
     * @return firstPlayer 0 or 1 to determine the first player
     */
    public int determineFirstPlayer() {
        int firstPlayer = random.nextInt(2);
        return firstPlayer;
    }

    /**
     * Method to execute the steps of a Nim Game.
     */
    public void play() {
        int firstPlayer = determineFirstPlayer();
        System.out.println("The pile initially contains " + marbles + " marbles.");
        
        while (marbles > 0) {
            if (firstPlayer == 0) {
                // Computer's turn
                computerPlayer.move(marbles);
                int computerChoice = computerPlayer.getChoice();
                marbles -= computerChoice;
                System.out.println("The computer takes " + computerChoice + " marbles from the pile.");
                System.out.println("There are " + marbles + " marble(s) left.");
                
                if (marbles <= 0) {
                    System.out.println("Congratulations! You win.");
                    break;
                } else {
                    System.out.println("------------------------------");
                }
                
                // Human's turn
                System.out.println("Your turn. You can take between 1 and " + marbles/2 + " marbles.");
                humanPlayer.move();
                int humanChoice = humanPlayer.getChoice();
                marbles -= humanChoice;
                System.out.println("There are " + marbles + " marble(s) left.");
                
                if (marbles <= 0) {
                    System.out.println("You lost! The computer wins.");
                    break;
                } else {
                    System.out.println("------------------------------");
                }
            } else if (firstPlayer == 1) {
                // Human's turn
                System.out.println("Your turn. You can take between 1 and " + marbles/2 + " marbles.");
                humanPlayer.move();
                int humanChoice = humanPlayer.getChoice();
                marbles -= humanChoice;
                System.out.println("There are " + marbles + " marble(s) left.");
                
                if (marbles <= 0) {
                    System.out.println("You lost! The computer wins.");
                    break;
                } else {
                    System.out.println("------------------------------");
                }
                
                // Computer's turn
                computerPlayer.move(marbles);
                int computerChoice = computerPlayer.getChoice();
                marbles -= computerChoice;
                System.out.println("The computer takes " + computerChoice + " marbles from the pile.");
                System.out.println("There are " + marbles + " marble(s) left.");
                
                if (marbles <= 0) {
                    System.out.println("You win!");
                    break;
                } else {
                    System.out.println("------------------------------");
                }
            }
        }
    }
}
