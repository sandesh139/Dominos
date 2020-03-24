

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


/**
 * class GameManager does the backend of the game.
 * it has methods to setup and regulate the board.
 * it is used by MainClass to get the gui created and updated
 */
public class GameManager {

    /** initializing the gameboard linkedlist which stores nodes of the board */
    public LinkedList<Node> gameBoard = new LinkedList<>();

    /**initiating the allElements Arraylist which stores node of the Arraylist */
    public ArrayList<Node> allElements = new ArrayList<>();

    /**initiating the boolean playerOne which decides whose turn to play the game*/
    public  boolean playerOne = true;

    /**initiating a playerOne as human1 which tracks the human dominos and provides input from human to gameManager*/
    public PlayerOne human1 = new PlayerOne();

    /** initiating a playerTwo object as player2 which tracks the computer dominos */
    public PlayerTwo player2 = new PlayerTwo();

    /**initiating a boolean used to check if computer needs dominos from boneyard . */
    private boolean player2NeedFromBoneYard = true;

    /**inititating a boolean used to check if human player needs dominos from boneyar */
    private boolean player1NeedFromBoneYard = true;

    /**initiating a boolean used to provide information if human needs from boneyard to get the gui Updated */
    public boolean isPlayer1NeedFromBoneYardGui = true;

    /**initiating a boolean used to provide information if computer needs from boneyard to get the gui Updated */
    public  boolean isPlayer2NeedFromBoneYardGui = true;

    /**initiating a counter which adds up when there is move in the left side of board. */
    public int counterLeft = 0;


    /**
     * constructor of the gameManager Class
     */
    public GameManager()
    {

    }


    /**
     * this method is called first to start the logic part of the game.
     * This will provide the random dominos to the boneyard, human and computer.
     */
    public void setUpDominos() {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = count; j < 7; j++) {
                allElements.add(new Node(i, j));
            }
            count++;
        }

        Collections.shuffle(allElements);
        for (int i = 0; i < 7; i++) {
            human1.playerOneDomino.add(allElements.get(i));
            allElements.remove(i);
        }


        for (int i = 0; i < 7; i++) {
            player2.playerTwoDomino.add(allElements.get(i));
            allElements.remove(i);
        }



    }

    /**
     * this method updates the game board.
     * Updating is done only when there is legal move by players which is checked by isLegal method.
     * if there is not any legal move, this  method calls addDominos to allow player to get the dominos from the
     * boneyard
     */

    public void updateBoard(){
        int selection;
        if(playerOne) {
            player1NeedFromBoneYard = true;

            for (int i = 0; i<human1.playerOneDomino.size(); i++){
                if (hasLegalMove(human1.playerOneDomino.get(i))){
                    player1NeedFromBoneYard = false;
                    isPlayer1NeedFromBoneYardGui = false;
                }
            }
            if  (player1NeedFromBoneYard){
                addDominos();
                human1.printPlayerOne();
            }
            if (playerOne) {
                selection = human1.getLocation();    //for player one, input position is obtained from the human1 object
                if (isLegal(human1.playerOneDomino.get(selection))) {
                    human1.playerOneDomino.remove(human1.getLocation());
                    isPlayer2NeedFromBoneYardGui = false;
                    playerOne = false;

                } else {
                    System.out.println("give the valid number");
                }
            }
        } else {
            player2NeedFromBoneYard = true;
            int i ;
            for( i = 0; i<player2.playerTwoDomino.size();i++){
                if(hasLegalMove(player2.playerTwoDomino.get(i))){

                    player2NeedFromBoneYard = false;
                    break;
                }
            }
            if (player2NeedFromBoneYard){
                addDominos();
            }
            if(!playerOne) {
                if (!player2NeedFromBoneYard) {
                    if (isLegal(player2.playerTwoDomino.get(i))) {
                        player2.playerTwoDomino.remove(i);
                        player2.printPlayerTwo();
                    }
                    playerOne = true;
                }
            }
        }

    }


    /**
     * this method is called from updateBoard.
     * this method allows user to grab dominos from the boneyard
     * and if the picked dominos from the bonayard is not sllowed to play, this method is called by itself until
     * player gets the allowed dominos or boneyard gets empty
     */
    public void addDominos() {
        System.out.println("adding dominos \n" );
        if(hasLegalMove(human1) && allElements.size()==0){
            playerOne = false;
        }
        if(hasLegalMove(player2)&& allElements.size()==0){
            playerOne =true;
        }
        if(allElements.size()!=0) {
            if (!hasLegalMove(allElements.get(0))) {
                if (playerOne) {
                    human1.playerOneDomino.add(allElements.get(0));
                    human1.printPlayerOne();
                    System.out.println();

                } else {
                    player2.playerTwoDomino.add(allElements.get(0));
                    player2.printPlayerTwo();
                    System.out.println();
                }
                allElements.remove(0);
                addDominos();
            } else {
                System.out.println("Picked [" + allElements.get(0).getX() + "," + allElements.get(0).getY() +
                        "]\n from boneyard");
                if(playerOne){
                    human1.playerOneDomino.add(allElements.get(0));
                    allElements.remove(0);

                } else {
                    isLegal(allElements.get(0));
                    allElements.remove(0);
                    playerOne = !playerOne;
                }
            }
        }
    }


    /**
     * this medthod takes a domino as a parameter and checks if that domino is allowed to play on the board
     * @param playerDomino
     * @returns true if the provided domino parameter is allowed to play on the board.
     */
    public boolean hasLegalMove(Node playerDomino) {
        boolean ifLegal = false;
        if (gameBoard.size() == 0) {
            ifLegal = true;
        } else {

            if (playerDomino.getY() == gameBoard.getFirst().getX()|| playerDomino.getY() == 0||
                    gameBoard.getFirst().getX()==0) {
                ifLegal = true;
            } else if (playerDomino.getX() == gameBoard.getFirst().getX()|| playerDomino.getX()==0||
                    gameBoard.getLast().getY()==0) {
                ifLegal = true;
            } else if (playerDomino.getX() == gameBoard.getLast().getY() ) {
                ifLegal = true;
            } else if (playerDomino.getY() == gameBoard.getLast().getY()) {
                ifLegal = true;
            }
        }
        return ifLegal;
    }

    /**
     * this method is called to check if human has legal move
     * @param human1
     * @returns true if the human can play dominos otherwise returns false
     */
    public boolean hasLegalMove(PlayerOne human1) {
        boolean ifLegal = false;
        if (gameBoard.size() == 0) {
            ifLegal = true;
        } else {

            for (int i = 0; i < human1.playerOneDomino.size(); i++) {
                if(hasLegalMove(human1.playerOneDomino.get(i))){
                    ifLegal =true;
                }

            }
        }
        return ifLegal;
    }


    /**
     * this method is called to check if computer has legal move
     * @param player2
     * @returns true if the computer has legal move otherwise returns false
     */
    public boolean hasLegalMove(PlayerTwo player2) {
        boolean ifLegal = false;
        if (gameBoard.size() == 0) {
            ifLegal = true;
        } else {

            for (int i = 0; i < player2.playerTwoDomino.size(); i++) {
                if(hasLegalMove(player2.playerTwoDomino.get(i))){
                    ifLegal =true;
                }

            }
        }
        return ifLegal;
    }


    /**
     * this method is called to check if a domino is allowed to place on board.
     * If the provided dominos is allowed, the provided domino is added to the game board.
     * @param playerDomino
     * @returns true if the domino is added to the game board
     */
    public boolean isLegal(Node playerDomino){
        if(hasLegalMove(human1) && allElements.size()==0){
            playerOne = false;
        }
        if(hasLegalMove(player2)&& allElements.size()==0){
            playerOne =true;
        }
        boolean ifLegal =false;
        if(gameBoard.size()==0){
            gameBoard.addFirst(playerDomino);
            ifLegal =true;
        } else {

            if (playerOne) {

                if (human1.getRotate()) {
                    int tempx;
                    tempx = playerDomino.getX();
                    playerDomino.setX(playerDomino.getY());
                    playerDomino.setY(tempx);

                }
            }

            /*given condition checks eligibility of domino in the left side of the board game*/
            if (human1.getLeft()||!playerOne) {
                if (playerDomino.getY() == gameBoard.getFirst().getX()|| playerDomino.getY() == 0||
                        gameBoard.getFirst().getX()==0) {
                    gameBoard.addFirst(playerDomino);
                    counterLeft++;
                    ifLegal = true;

                    /*given condition places the computer domino after the domino ia rotated to match the board end */
                } else if (!playerOne && playerDomino.getX() == gameBoard.getFirst().getX() || playerDomino.getX()==0) {
                    gameBoard.addFirst(playerDomino);
                    counterLeft++;
                    int tempx;
                    int tempy;
                    tempx = gameBoard.getFirst().getX();
                    tempy = gameBoard.getFirst().getY();
                    gameBoard.getFirst().setX(tempy);
                    gameBoard.getFirst().setY(tempx);
                    ifLegal = true;

                    /*given condition checks and places the computer domino */
                } else if (!playerOne && playerDomino.getX() == gameBoard.getLast().getY() || playerDomino.getX()==0||
                        gameBoard.getLast().getY()==0) {
                    gameBoard.addLast(playerDomino);
                    ifLegal = true;

                    /*given condition places the computer domino after the domino ia rotated to match the board end */
                } else if (!playerOne && playerDomino.getY() == gameBoard.getLast().getY() ||playerDomino.getY()==0) {
                    gameBoard.addLast(playerDomino);
                    int tempx = 0;
                    int tempy = 0;
                    tempx = gameBoard.getLast().getX();
                    tempy = gameBoard.getLast().getY();
                    gameBoard.getLast().setX(tempy);
                    gameBoard.getLast().setY(tempx);
                    ifLegal = true;
                }


                /*given condition checks eligibility of domino in the right side of the board game*/
            } else if(human1.getRight()|| !playerOne) {
                if (playerDomino.getX() == gameBoard.getLast().getY() || playerDomino.getX()==0||
                gameBoard.getLast().getY()==0) {
                    gameBoard.addLast(playerDomino);
                    ifLegal = true;

                }

            }
        }



        return ifLegal;

    }


}
