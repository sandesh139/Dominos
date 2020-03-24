import java.util.ArrayList;
import java.util.Scanner;


/**
 * this class holds the property of the player one
 */
public class PlayerOne {

    /** initiating location which holds the position of selected dominos in guo */
    private int location =0;

    /** initiating the boolean left used to regulate the access for human in placing domino on left end of board */
    public  boolean left = false;

    /** initiating the boolean right used to regulate the access for human in placing domino on right end of board */
    public boolean right = false;

    /** initiating the boolean rotate to regulate the access for human to rotate the domino picked */
    public boolean rotate = false;

    /**initiating the arraylist of nodes to hold the dominos of human */
    public ArrayList<Node> playerOneDomino = new ArrayList<>();

    /**
     * this method is used to print the human dominos in console for debug purposes
     */
    public void printPlayerOne() {
        System.out.println("\n player one dominos given below:");
        for (int i = 0; i < playerOneDomino.size(); i++) {
            System.out.print(" [" + playerOneDomino.get(i).getX() + "|" + playerOneDomino.get(i).getY()
                    + "]");

        }
    }

    /**
     * this method is called from MainClass to set the location of the selected dominos by mouse click
     * @param x
     */
    public void setLocation(int x){
        location = x;
    }

    /**
     * this method is called from GameManager to get the location of the selected dominos by mouse click
     * @return
     */
    public int getLocation(){
        return location;
    }

    /**
     * this method is called from MainClass to set the left position to add dominos on the board.
     */
    public void setLeft(){
        left =true;
        right = false;
    }

    /**
     *  this method is called from MainClass to set the right position to add dominos on the board.
     */
    public void setRight(){
        right = true;
        left = false;
    }

    /**
     * this method is called from MainClass to set the rotation of the dominos before adding to the board
     */
    public void setRotate(){
        rotate = true;
    }

    /**
     * this method is called from the GameManager class to get if the position is right or not
     * @return
     */
    public boolean getRight(){
        return right;
    }

    /**
     * this method is called from the GameManager class to get if the rotation needs to be performed or not
     * @return
     */
    public boolean getRotate(){
        return rotate;
    }

    /**
     * this method is called from the GameManager class to get if the position is left or not
     * @return
     */
    public boolean getLeft(){
        return left;
    }
}

