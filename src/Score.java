import java.util.ArrayList;
import java.util.LinkedList;


/**
 * this class Score is used to decide if there has been a winner
 */
public class Score {

    /**initiating the boolean player1CanMove to hold if there is legal move for human */
    private boolean player1CanMove = false;

    /**initiating the boolean player2CanMove to hold if there is legal move for computer */
    private boolean player2CanMove = false;

    /**initiating the PlayerOne object */
    private PlayerOne human1;

    /**initiating the PlayerTwo object */
    private PlayerTwo player2;

    /**initiating the linkedlist to hold the board dominos */
    private LinkedList<Node> gameBoard;

    /**initiating the arraylist to hold the boneyard dominos */
    private ArrayList<Node> allElements;


    /**
     * this method is called from MainClass to check if there is a winner or not.
     * @param human1
     * @param player2
     * @param allElements
     * @param gameBoard
     * @returns boolean true if the boneyard is empty and either player placed their last dominos or they both take
     * turns without placing the domino
     */
    public boolean findWinner(PlayerOne human1, PlayerTwo player2, ArrayList<Node> allElements, LinkedList<Node> gameBoard) {
        this.gameBoard = gameBoard;
        this.human1 = human1;
        this.player2 = player2;
        this.allElements = allElements;
        boolean winner = false;


        if (allElements.size()==0) {
            for (int i = 0; i < human1.playerOneDomino.size(); i++) {
                if (hasLegalMove(human1.playerOneDomino.get(i))) {
                    player1CanMove = true;
                }
            }
            for (int i = 0; i < player2.playerTwoDomino.size(); i++) {
                if (hasLegalMove(player2.playerTwoDomino.get(i))) {
                    player2CanMove = true;
                }

            }


            if (!player1CanMove && !player2CanMove) {
                winner = true;
            }

            if(human1.playerOneDomino.size()==0||player2.playerTwoDomino.size()==0){
                winner =true;
            }
            player1CanMove =false;
            player2CanMove =false;

        }

        return winner;
    }


    /**
     * this method is called from the above method findWinner to see if there is legal move or not which helps deciding
     * about the existence of winner
     * @param playerDomino
     * @returns boolean if the player has legal dominos with them
     */
    public boolean hasLegalMove(Node playerDomino) {
        boolean ifLegal = false;
        if (gameBoard.size() == 0) {
            ifLegal = true;
        } else {

            if (playerDomino.getY() == gameBoard.getFirst().getX() || playerDomino.getY() == 0 ||
                    gameBoard.getFirst().getX() == 0) {
                ifLegal = true;
            } else if (playerDomino.getX() == gameBoard.getFirst().getX() || playerDomino.getX() == 0 ||
                    gameBoard.getLast().getY() == 0) {
                ifLegal = true;
            } else if (playerDomino.getX() == gameBoard.getLast().getY()) {
                ifLegal = true;
            } else if (playerDomino.getY() == gameBoard.getLast().getY()) {
                ifLegal = true;
            }
        }
        return ifLegal;
    }


    /**
     * this method is called from the MainClass to get the winning score.
     * @returns String with the information of the winning score
     */
    public String countScore() {
        String str ="";
        System.out.println("Game has ended");
        int playerOneCount = 0;
        int playerTwoCount = 0;
        System.out.println("this is size of computer board" + player2.playerTwoDomino.size());
        System.out.println("this is size of boneyard " + allElements.size());
        System.out.println("this is size of human  board " + human1.playerOneDomino.size());
        System.out.println("this is size of game board " + gameBoard.size());
        for (int i = 0; i < human1.playerOneDomino.size(); i++) {
            playerOneCount = playerOneCount + human1.playerOneDomino.get(i).getX() + human1.playerOneDomino.get(i).getX();
        }
        for (int j = 0; j < player2.playerTwoDomino.size(); j++) {
            playerTwoCount = playerTwoCount + player2.playerTwoDomino.get(j).getX() + player2.playerTwoDomino.get(j).getY();
        }

        if (playerOneCount < playerTwoCount) {
           str = "Winner is Human  by " + (playerTwoCount - playerOneCount) + " points";


        } else {
           str = "Winner is Computer  by " + (playerOneCount - playerTwoCount) + " points";

        }

        return str;
    }

}