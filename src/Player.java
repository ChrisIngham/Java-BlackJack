import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player extends Card{

    // Need to 'Name' Players
    // Can just default them for now
    private String name;
    private ArrayList<String> hand = new ArrayList<>();

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void drawCard(){
        this.hand.add(randomCard(this));
    }

    public String printHand(){
        String output = "";
        for (String cards : this.hand){
            output = " " + cards;
        }
        return output;
    }
    public String toString(){
        return this.name;
    }

}
