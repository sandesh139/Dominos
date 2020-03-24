import java.util.ArrayList;

/**
 * PlayerTwo class helps to get the Computer object
 * it has only printiing method for debugging purposes
 */
public class PlayerTwo{

    /*playerTwoDomino is the arraylist which holds the dominos of the compute */
    public ArrayList<Node> playerTwoDomino = new ArrayList<>();


    /**
     * this method is called to see if the gui version  is showing the right play of  dominos as printed in console
     */
    public void printPlayerTwo(){

        System.out.print("Computer has "+ playerTwoDomino.size()+ " dominos\n");
        for (int i = 0; i<playerTwoDomino.size(); i++) {
            System.out.print(" [" + playerTwoDomino.get(i).getX() + "|" + playerTwoDomino.get(i).getY()
                    + "]");

        }

    }
}
