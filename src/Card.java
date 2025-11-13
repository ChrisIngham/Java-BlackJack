import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Card {

    // this class is used to keep the record of the cards associated with each player
    // assign each player 2 cards
    //
    private List<String> deck = new ArrayList<>();
    private List<String> dealtDeck = new ArrayList<>();


    public Card() {
        this.deck.addAll(Arrays.asList("A_S", "K_S", "Q_S", "J_S", "10_S", "9_S", "8_S", "7_S", "6_S", "5_S", "4_S", "3_S", "2_S",
                "A_H", "K_H", "Q_H", "J_H", "10_H", "9_H", "8_H", "7_H", "6_H", "5_H", "4_H", "3_H", "2_H",
                "A_C", "K_C", "Q_C", "J_C", "10_C", "9_C", "8_C", "7_C", "6_C", "5_C", "4_C", "3_C", "2_C",
                "A_D", "K_D", "Q_D", "J_D", "10_D", "9_D", "8_D", "7_D", "6_D", "5_D", "4_D", "3_D", "2_D"
        ));
        this.dealtDeck = new ArrayList<>();
    }

    public String randomCard(Player name) {
        String randomCard = this.deck.get(new Random().nextInt(deck.size()));
        deck.remove(randomCard);
        dealtDeck.add(randomCard);
        return randomCard;
    }

    public int calculateHand(ArrayList hand) {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            String[] parts = String.valueOf(hand.get(i)).split("_");
            if (parts[0].equals("K") || parts[0].equals("Q") || parts[0].equals("J")) {
                total += 10;
            }
            if (parts[0].equals("A")) {
                if (total + 11 > 21) {
                    total += 1;
                } else {
                    total += 11;
                }
            }
            if (parts[0].matches("-?\\d+(\\.\\d+)?")) {
                total += Integer.valueOf(parts[0]);
            }
        }
        return total;
    }
}

