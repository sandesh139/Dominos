/**
 * Node class provides the storage and representation of dominos.
 * it has getter and setter methods.
 * setter methods are called from gui to update the interaction of user to game.
 * getters methods are called from GameManager to get the game updated.
 */
public class Node {

    /*initiating a private integer variable x */
    private int x;

    /*initiating a private integer variable y */
    private int y;

    /**constructor
     * when object point is created we assign parameter passed to global variable */
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * this method returns the x value of the node
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * this method returns the y - value of the node
     * @return
     */
    public int getY() {
        return y;
    }


    /**
     * this method is called to set the x- component of the node
     * @param x
     */
    public void setX (int x){
        this.x = x;
    }

    /**
     * this method is called to set the y-component of the node
     * @param y
     */
    public void setY (int y){
        this.y = y;
    }

}