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
        System.out.println("The players are: ");
        for (Player people : allPlayers) {
            System.out.println(people);
            System.out.println(people.printHand());
        }

        // deal hand
        for (Player play : allPlayers){
            play.drawCard();
            play.drawCard();
        }

        // Actual gameplay of hitting and standing
        for (int i = 0; i < allPlayers.size(); i++){
            while (true){
                if (allPlayers.get(i).printTotal() == 21){
                    System.out.println(allPlayers.get(i).getName() + ", you have: " + allPlayers.get(i).printHand());
                    System.out.println("BlackJACK!");
                    break;
                }
                if (allPlayers.get(i).printTotal() > 21){
                    System.out.println(allPlayers.get(i).getName() + ", you have: " + allPlayers.get(i).printHand());
                    System.out.println("You have busted with " + allPlayers.get(i).printTotal());
                    break;
                }

                System.out.println(allPlayers.get(i).getName() + ", you have: " + allPlayers.get(i).printHand() + "\nDo you want to Hit or Stand? ");
                System.out.println("Your total is: " + allPlayers.get(i).printTotal());
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("stand")){
                    break;
                }
                if (input.equals("hit")) {
                    allPlayers.get(i).drawCard();
                }
            }
        }

        // determine winner
        String winner = "";
        for (int i = 0; i < allPlayers.size() -1; i++){
            if (allPlayers.get(i).printTotal() == 21){
                winner = allPlayers.get(i).getName();
                break;
            }
            if (allPlayers.get(i).printTotal() > 21 && allPlayers.get(i+1).printTotal() <=21){
                winner = allPlayers.get(i+1).getName();
            }else if (allPlayers.get(i).printTotal() <= 21 &&  allPlayers.get(i+1).printTotal() > 21){
                winner = allPlayers.get(i).getName();
            }else if(allPlayers.get(i).printTotal() > allPlayers.get(i - 1).printTotal()){
                winner = allPlayers.get(i).getName();
            }else{
                winner = allPlayers.get(i+1).getName();
            }
        }


        System.out.println("Winner is " + winner);

    }


}
