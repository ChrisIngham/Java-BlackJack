import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class GamePlay{

    public static void main(String[] args) {
        ArrayList<Player> allPlayers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // start the game by asking the player how many people are playing.
        System.out.println("How many players? ");
        int players = Integer.valueOf(scanner.nextLine());

        // We now create multiple (players value) players
        for (int i = 1; i < players+1; i++) {
            System.out.println("Name of player " + i + ":");
            String name = scanner.nextLine();

            Player player = new Player(name);
            allPlayers.add(player);
        }
        // ask if we are ready to start the game
        System.out.println("Are all the players ready: ");
        for (Player people : allPlayers) {
            people.drawCard();
            people.drawCard();
            System.out.println(people + "?");
            System.out.println(people.printHand());
        }

        for (int i = 0; i < allPlayers.size(); i++){
            while (true){
                System.out.println(allPlayers.get(i).getName() + ", you have: " + allPlayers.get(i).printHand() + "\nDo you want to Hit or Stand? ");
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("stand")){
                    break;
                }
                if (input.equals("hit")) {
                    allPlayers.get(i).drawCard();
                }
            }
        }

    }


}
