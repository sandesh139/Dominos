
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Name : Sandesh Timilsina
 * Date : 9/13/2019
 * MainClass extends Application Class
 * this class uses javafx to create the gui for the game
 * this class creates the gameManager objects and has access to all other classes methods to use.
 */

public class MainClass extends Application {

    /**initiating the object of the GameManager class */
    private GameManager game1 = new GameManager();

    /**initiating the list which holds the getTilePane object for human dominos*/
    private List<getTilePane> listOfHuman = new ArrayList<>();

    /**initiating the list which holds the getTilePane object for the board game*/
    private List<getTilePane> listOfBoard = new ArrayList<>();

    /**initiating the left button which allows user to keep dominos in the left side */
    private Button left = new Button("Left");

    /**initiating the right button which allows user to keep dominos in the right side of the board */
    private Button right = new Button ("Right");

    /**initiating the rotate button which allows user to rotate the dominos */
    private Button rotate = new Button("Rotate");

    /**initiating the confirm button which allows user to confirm the placement of dominos*/
    private Button confirm = new Button("Confirm");

    /**initiating the button which allows the user to pick up dominos from boneyard */
    private Button pickFromBoneYard = new Button("Pick from Boneyard");

    /**initiating the pane in which dominos are displayed */
    private Pane root = new Pane();

    /**initiating the boolean winner which is set to true if there is a winner */
    private boolean winner = false;

    /**initiating the Score object which will decide the winner and count score */
    private Score scoreCounter = new Score();

    /**initiating the alert object to display when there is a winning in the game */
    private Alert dialogue = new Alert(Alert.AlertType.INFORMATION);

    /**initiating the boneYard label to display the number of dominos left in the boneyard */
    private Label boneYard = new Label();

    /**initiating the computerDominos label to display the number of dominos with the Computer */
    private Label computerDominos = new Label();



    /**
     * main method of the class
     * @param args
     */

    public static void main(String[] args) {
        launch(args);
    }


    /**
     *  start method invoked from the JavaFX Application
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Dominos Game");           //giving the title to the stage.
        primaryStage.setScene(new Scene(GetStackPane()));
        primaryStage.show();
    }



    /**
     * GetStackPane returning parent which will have all nodes of the figure
     * @return
     */

    private Parent GetStackPane() {

        root.setPrefSize(1500, 800);         //setting the size of the pane
        game1.setUpDominos();                                   //setting up the dominos in the backend of the program

        game1.human1.printPlayerOne();                        //this prints the dominos of the player in the console

        boneYard.setFont(new Font(40));            //this sets the font of the boneYard label to 40
        boneYard.setTranslateX(200);                  //this sets up the location of the label in the root pane
        boneYard.setTranslateY(500);


        computerDominos.setFont(new Font(40));       //this sets the font of the computer dominos  label to 40
        computerDominos.setTranslateX(200);              //this sets up the location of the label in the root pane
        computerDominos.setTranslateY(600);

        for (int i = 0; i < 10; i++) {
            listOfHuman.add(new getTilePane());   //this sets up the 10 maximum tiles  place for human dominos display
        }


        for (int i = 0; i<30; i++ ){                  //this sets up the 30 maximum tiles place for the board.
            listOfBoard.add(new getTilePane());
            getTilePane aTile = listOfBoard.get(i);
            aTile.rec.setStrokeWidth(5);               //this sets the width of the tile border



            /**here we set the image added to board while creating the tile to be null */
            aTile.iv0L.setImage(null);
            aTile.iv1L.setImage(null);
            aTile.iv2L.setImage(null);
            aTile.iv3L.setImage(null);
            aTile.iv4L.setImage(null);
            aTile.iv5L.setImage(null);
            aTile.iv6L.setImage(null);


            aTile.iv0R.setImage(null);
            aTile.iv1R.setImage(null);
            aTile.iv2R.setImage(null);
            aTile.iv3R.setImage(null);
            aTile.iv4R.setImage(null);
            aTile.iv5R.setImage(null);
            aTile.iv6R.setImage(null);

        }





        /** we set the image added to human tile to be null */
        int row = 0;
        int col = 0;
        for (int i = 0; i < listOfHuman.size(); i++) {
            getTilePane aTile = listOfHuman.get(i);
            aTile.iv0L.setImage(null);
            aTile.iv1L.setImage(null);
            aTile.iv2L.setImage(null);
            aTile.iv3L.setImage(null);
            aTile.iv4L.setImage(null);
            aTile.iv5L.setImage(null);
            aTile.iv6L.setImage(null);
            aTile.iv0R.setImage(null);
            aTile.iv1R.setImage(null);
            aTile.iv2R.setImage(null);
            aTile.iv3R.setImage(null);
            aTile.iv4R.setImage(null);
            aTile.iv5R.setImage(null);
            aTile.iv6R.setImage(null);
            aTile.rec.setStrokeWidth(5);


            if(i <7){
                aTile.iv0L.setImage(null);
                aTile.iv1L.setImage(null);
                aTile.iv2L.setImage(null);
                aTile.iv3L.setImage(null);
                aTile.iv4L.setImage(null);
                aTile.iv5L.setImage(null);
                aTile.iv6L.setImage(null);


                aTile.iv0R.setImage(null);
                aTile.iv1R.setImage(null);
                aTile.iv2R.setImage(null);
                aTile.iv3R.setImage(null);
                aTile.iv4R.setImage(null);
                aTile.iv5R.setImage(null);
                aTile.iv6R.setImage(null);


                /** we only set up the image which matches the corresponding dots of the dominos. */
               if(game1.human1.playerOneDomino.get(i).getX()==0) {
                   aTile.iv0L.setImage(aTile.image0);
                   aTile.setAlignment(aTile.iv0L, Pos.CENTER_LEFT);
               }

                if(game1.human1.playerOneDomino.get(i).getX()==1) {
                    aTile.iv1L.setImage(aTile.image1);
                    aTile.setAlignment(aTile.iv1L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==2) {
                    aTile.iv2L.setImage(aTile.image2);
                    aTile.setAlignment(aTile.iv2L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==3) {
                    aTile.iv3L.setImage(aTile.image3);
                    aTile.setAlignment(aTile.iv3L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==4) {
                    aTile.iv4L.setImage(aTile.image4);
                    aTile.setAlignment(aTile.iv4L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==5) {
                    aTile.iv5L.setImage(aTile.image5);
                    aTile.setAlignment(aTile.iv5L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==6) {
                    aTile.iv6L.setImage(aTile.image6);
                    aTile.setAlignment(aTile.iv6L, Pos.CENTER_LEFT);
                }




                if(game1.human1.playerOneDomino.get(i).getY()==0) {
                    aTile.iv0R.setImage(aTile.image0);
                    aTile.setAlignment(aTile.iv0R, Pos.CENTER_RIGHT);
                }

                if(game1.human1.playerOneDomino.get(i).getY()==1) {
                    aTile.iv1R.setImage(aTile.image1);
                    aTile.setAlignment(aTile.iv1R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==2) {
                    aTile.iv2R.setImage(aTile.image2);
                    aTile.setAlignment(aTile.iv2R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==3) {
                    aTile.iv3R.setImage(aTile.image3);
                    aTile.setAlignment(aTile.iv3R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==4) {
                    aTile.iv4R.setImage(aTile.image4);
                    aTile.setAlignment(aTile.iv4R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==5) {
                    aTile.iv5R.setImage(aTile.image5);
                    aTile.setAlignment(aTile.iv5R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==6) {
                    aTile.iv6R.setImage(aTile.image6);
                    aTile.setAlignment(aTile.iv6R, Pos.CENTER_RIGHT);
                }





            }
            aTile.setTranslateX(80*col);

            root.getChildren().add(aTile);      //tile is added to the root
            col++;
        }


        /**the position of the buttons are set up in the give x and y coordinates of the plane */
        left.setTranslateX(1000);
        left.setTranslateY(300);
        right.setTranslateX(1000);
        right.setTranslateY(350);
        rotate.setTranslateX(1000);
        rotate.setTranslateY(400);
        confirm.setTranslateX(1000);
        confirm.setTranslateY(450);
        pickFromBoneYard.setTranslateX(1000);
        pickFromBoneYard.setTranslateY(600);

        dialogue.setTitle("Game Ends");


        /**all nodes are added to the root pane */
        root.getChildren().addAll(left,right,rotate,confirm,pickFromBoneYard,boneYard,computerDominos);


        row = 100;
        col = 0;
        int count = 0;


        /**the position of tiles for the board game  are installed in zigzag ways such that
         * each tile has next neigbor in the opposite row*/
        for (int i =0; i< listOfBoard.size(); i++){
            getTilePane aTile = listOfBoard.get(i);
            aTile.setTranslateX(48*col);
            aTile.setTranslateY(row+85*count);

            count++;
            count = count%2;     //each tile has next neigbor in the opposite row
            root.getChildren().add(aTile);
            col++;

        }

        /*setting up the label name with the current number of dominos presented */
        boneYard.setText("Boneyard has " + game1.allElements.size()+" dominos.");
        computerDominos.setText("Computer has " + game1.player2.playerTwoDomino.size()+" dominos");


        /**in every mouse click the boneyard and computerDomino labels are updated. Also, in every click game is
         * is checked if there is a winner */
        root.setOnMouseClicked(event -> {
            boneYard.setText("Boneyard has " + game1.allElements.size()+" dominos.");
            computerDominos.setText("Computer has " + game1.player2.playerTwoDomino.size()+" dominos");


            /*given if condition checks if there is inifinite loop for just one player and if there is, it omits. */
            if(!winner) {
                if(!game1.hasLegalMove(game1.human1)&& game1.allElements.size()==0){
                    game1.playerOne = false;
                    game1.updateBoard();
                }
                if(!game1.hasLegalMove(game1.player2)&& game1.allElements.size()==0){
                    game1.playerOne =true;
                    game1.updateBoard();
                }
                game1.updateBoard();
            }

            /*given condition checks if there is a winner. If there is, game ends */
            if(scoreCounter.findWinner(game1.human1,game1.player2,game1.allElements,game1.gameBoard)) {
                dialogue.setContentText(scoreCounter.countScore());
                dialogue.show();
                winner =true;
            }
        });






        return root;
    }


    /**
     * inner class which extends StackPane and is responsible to create each tile and provide the properties to the tile
     */
    private class getTilePane extends StackPane {
        Rectangle rec = new Rectangle(80, 80);   //this is size of each tile



        //following lines of codes gets the image from the resource directory and provides the image to the tile

        Image image0 = new Image("file:resources/dice0.png",44,
                60,false,true);
        ImageView iv0L= new ImageView(image0);
        ImageView iv0R= new ImageView(image0);

        Image image1= new Image("file:resources/dice1.png",44,
                60,false,true);
        ImageView iv1L= new ImageView(image1);
        ImageView iv1R= new ImageView(image1);

        Image image2= new Image("file:resources/dice2.png",44,
                60,false,true);
        ImageView iv2L= new ImageView(image2);
        ImageView iv2R= new ImageView(image2);

        Image image3= new Image("file:resources/dice3.png",44,
                60,false,true);
        ImageView iv3L= new ImageView(image3);
        ImageView iv3R= new ImageView(image3);

        Image image4= new Image("file:resources/dice4.png",44,
                60,false,true);
        ImageView iv4L= new ImageView(image4);
        ImageView iv4R= new ImageView(image4);


        Image image5= new Image("file:resources/dice5.png",44,
                60,false,true);
        ImageView iv5L= new ImageView(image5);
        ImageView iv5R= new ImageView(image5);

        Image image6= new Image("file:resources/dice6.png",44,
                60,false,true);
        ImageView iv6L= new ImageView(image6);
        ImageView iv6R= new ImageView(image6);






        /** the constructor to provide properties to the tiles. */

        public getTilePane() {
            rec.setStroke(Color.BLUE);
            rec.setFill(null);

            /*adding all image to the tile so any image can be displayed to represent the corresponding dominos */
            getChildren().addAll(rec, iv0L, iv1L, iv2L, iv3L, iv4L, iv5L, iv6L, iv0R, iv1R, iv2R, iv3R,
             iv4R, iv5R, iv6R);

                setOnMouseClicked(this::handleTile);
        }


        /**
         * this method is called when there is a click in the created tile
         * @param mouseEvent
         */
        private void handleTile(MouseEvent mouseEvent) {


            int count = 0;
            rec.setStrokeWidth(8);


            /*this loop gives the location of the tile clicked in the human dominos collection*/
            for(int i = 0; i<listOfHuman.size();i++){

                if (this.equals(listOfHuman.get(i))){
                    count =i;
                    break;
                }
            }



            game1.human1.setLocation(count);    //setting up the location



            left.setOnAction(new EventHandler<ActionEvent>() {


                /**
                 * this method is called when there is click on left button
                 * this sets up the left input for the humans play so the dominos is placed in the left end of the board
                 * @param event
                 */
                @Override
                public void handle(ActionEvent event) {
                    game1.human1.setLeft();
                    game1.human1.right =false;
                }
            });



            right.setOnAction(new EventHandler<ActionEvent>() {
                /**
                 * this method is called when there is click on right button
                 * this sets up the right input for the humans play so the dominos is placed in right end of the board
                 * @param event
                 */
                @Override
                public void handle(ActionEvent event) { game1.human1.setRight();
                }
            });


            rotate.setOnAction(new EventHandler<ActionEvent>() {
                /**
                 * this method is called when there is click on rotate button
                 * the dominos the human selected is rotated if this button is clicked
                 * @param event
                 */
                @Override
                public void handle(ActionEvent event) {
                    game1.human1.setRotate();


                }
            });

            confirm.setOnAction(new EventHandler<ActionEvent>() {
                /**
                 * this method is called when there is click on confirm button
                 * @param event
                 */
                @Override
                public void handle(ActionEvent event) {
                    rec.setStrokeWidth(5);
                    updateBoard();
                    //this condition just checks if there is a winner or not
                    if(scoreCounter.findWinner(game1.human1,game1.player2,game1.allElements,game1.gameBoard)) {
                        dialogue.setContentText(scoreCounter.countScore());
                        dialogue.show();
                        winner =true;
                    }
                }
            });


            pickFromBoneYard.setOnAction(new EventHandler<ActionEvent>() {
                /**
                 * this method is called when there is click on pick from boneyard button
                 * @param event
                 */
                @Override
                public void handle(ActionEvent event) {
                    if(!winner) {
                        if(game1.allElements.size()!=0) {
                            game1.updateBoard();
                            updateBoard();
                            boneYard.setText("Boneyard has " + game1.allElements.size() + " dominos.");
                            computerDominos.setText("Computer has " + game1.player2.playerTwoDomino.size() + " dominos");
                        }
                    }
                }
            });



        }


        /**
         * this method updates the tiles displayed
         */
        private void updateBoard() {
            boneYard.setText("Boneyard has " + game1.allElements.size()+" dominos.");
            computerDominos.setText("Computer has " + game1.player2.playerTwoDomino.size()+" dominos");


            /*given if condition checks if there is a winner. If there is, game ends with a dialogue */
            if(scoreCounter.findWinner(game1.human1,game1.player2,game1.allElements,game1.gameBoard)){
                dialogue.setContentText(scoreCounter.countScore());
                dialogue.show();
                winner = true;
            }


            /*this condition prevents from game stopping when a player does not have any move */
            if(!winner) {
                if(!game1.hasLegalMove(game1.human1)&& game1.allElements.size()==0){
                    game1.playerOne = false;
                    game1.updateBoard();
                }
                if(!game1.hasLegalMove(game1.player2)&& game1.allElements.size()==0){
                    game1.playerOne =true;
                    game1.updateBoard();
                }
                game1.updateBoard();
            }

            game1.human1.printPlayerOne();      //this is for debug purpose which prints the human board in console.


            //following lines of code sets the button to the default mode.
            game1.human1.rotate =false;
            game1.human1.left =false;
            game1.human1.right =false;


            //following lines of codes clear up the human dominos display
            for(int i =0; i<listOfHuman.size();i++){
                listOfHuman.get(i).iv0L.setImage(null);
                listOfHuman.get(i).iv1L.setImage(null);
                listOfHuman.get(i).iv2L.setImage(null);
                listOfHuman.get(i).iv3L.setImage(null);
                listOfHuman.get(i).iv4L.setImage(null);
                listOfHuman.get(i).iv5L.setImage(null);
                listOfHuman.get(i).iv6L.setImage(null);

                listOfHuman.get(i).iv0R.setImage(null);
                listOfHuman.get(i).iv1R.setImage(null);
                listOfHuman.get(i).iv2R.setImage(null);
                listOfHuman.get(i).iv3R.setImage(null);
                listOfHuman.get(i).iv4R.setImage(null);
                listOfHuman.get(i).iv5R.setImage(null);
                listOfHuman.get(i).iv6R.setImage(null);


            }


            //following codes sets up the new display for the updated human board
            for(int i =0; i<game1.human1.playerOneDomino.size();i++){
                if(game1.human1.playerOneDomino.get(i).getX()==0) {
                    listOfHuman.get(i).iv0L.setImage(image0);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv0L, Pos.CENTER_LEFT);
                }

                if(game1.human1.playerOneDomino.get(i).getX()==1) {
                    listOfHuman.get(i).iv1L.setImage(image1);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv1L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==2) {
                    listOfHuman.get(i).iv2L.setImage(image2);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv2L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==3) {
                    listOfHuman.get(i).iv3L.setImage(image3);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv3L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==4) {
                    listOfHuman.get(i).iv4L.setImage(image4);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv4L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==5) {
                    listOfHuman.get(i).iv5L.setImage(image5);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv5L, Pos.CENTER_LEFT);
                }
                if(game1.human1.playerOneDomino.get(i).getX()==6) {
                    listOfHuman.get(i).iv6L.setImage(image6);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv6L, Pos.CENTER_LEFT);
                }




                if(game1.human1.playerOneDomino.get(i).getY()==0) {
                    listOfHuman.get(i).iv0R.setImage(image0);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv0R, Pos.CENTER_RIGHT);
                }

                if(game1.human1.playerOneDomino.get(i).getY()==1) {
                    listOfHuman.get(i).iv1R.setImage(image1);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv1R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==2) {
                    listOfHuman.get(i).iv2R.setImage(image2);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv2R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==3) {
                    listOfHuman.get(i).iv3R.setImage(image3);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv3R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==4) {
                    listOfHuman.get(i).iv4R.setImage(image4);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv4R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==5) {
                    listOfHuman.get(i).iv5R.setImage(image5);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv5R, Pos.CENTER_RIGHT);
                }
                if(game1.human1.playerOneDomino.get(i).getY()==6) {
                    listOfHuman.get(i).iv6R.setImage(image6);
                    listOfHuman.get(i).setAlignment(listOfHuman.get(i).iv6R, Pos.CENTER_RIGHT);
                }


            }


            //following line of code clears up the images from the board game
            for(int i = 0; i<listOfBoard.size();i++){
                listOfBoard.get(i).iv0L.setImage(null);
                listOfBoard.get(i).iv1L.setImage(null);
                listOfBoard.get(i).iv2L.setImage(null);
                listOfBoard.get(i).iv3L.setImage(null);
                listOfBoard.get(i).iv4L.setImage(null);
                listOfBoard.get(i).iv5L.setImage(null);
                listOfBoard.get(i).iv6L.setImage(null);

                listOfBoard.get(i).iv0R.setImage(null);
                listOfBoard.get(i).iv1R.setImage(null);
                listOfBoard.get(i).iv2R.setImage(null);
                listOfBoard.get(i).iv3R.setImage(null);
                listOfBoard.get(i).iv4R.setImage(null);
                listOfBoard.get(i).iv5R.setImage(null);
                listOfBoard.get(i).iv6R.setImage(null);

            }
            int j = 0;

            //following line of code sets up the updated board with updated images
            for(int i = (game1.counterLeft%2); i<game1.gameBoard.size()+(game1.counterLeft%2);i++){


                if(game1.gameBoard.get(j).getX()==0) {
                    listOfBoard.get(i).iv0L.setImage(image0);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv0L, Pos.CENTER_LEFT);
                }
                if(game1.gameBoard.get(j).getX()==1) {
                    listOfBoard.get(i).iv1L.setImage(image1);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv1L, Pos.CENTER_LEFT);
                }
                if(game1.gameBoard.get(j).getX()==2) {
                    listOfBoard.get(i).iv2L.setImage(image2);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv2L, Pos.CENTER_LEFT);
                }
                if(game1.gameBoard.get(j).getX()==3) {
                    listOfBoard.get(i).iv3L.setImage(image3);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv3L, Pos.CENTER_LEFT);
                }
                if(game1.gameBoard.get(j).getX()==4) {
                    listOfBoard.get(i).iv4L.setImage(image4);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv4L, Pos.CENTER_LEFT);
                }
                if(game1.gameBoard.get(j).getX()==5) {
                    listOfBoard.get(i).iv5L.setImage(image5);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv5L, Pos.CENTER_LEFT);
                }
                if(game1.gameBoard.get(j).getX()==6) {
                    listOfBoard.get(i).iv6L.setImage(image6);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv6L, Pos.CENTER_LEFT);
                }



                if(game1.gameBoard.get(j).getY()==0) {
                    listOfBoard.get(i).iv0R.setImage(image0);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv0R, Pos.CENTER_RIGHT);
                }
                if(game1.gameBoard.get(j).getY()==1) {
                    listOfBoard.get(i).iv1R.setImage(image1);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv1R, Pos.CENTER_RIGHT);
                }
                if(game1.gameBoard.get(j).getY()==2) {
                    listOfBoard.get(i).iv2R.setImage(image2);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv2R, Pos.CENTER_RIGHT);
                }
                if(game1.gameBoard.get(j).getY()==3) {
                    listOfBoard.get(i).iv3R.setImage(image3);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv3R, Pos.CENTER_RIGHT);
                }
                if(game1.gameBoard.get(j).getY()==4) {
                    listOfBoard.get(i).iv4R.setImage(image4);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv4R, Pos.CENTER_RIGHT);
                }
                if(game1.gameBoard.get(j).getY()==5) {
                    listOfBoard.get(i).iv5R.setImage(image5);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv5R, Pos.CENTER_RIGHT);
                }
                if(game1.gameBoard.get(j).getY()==6) {
                    listOfBoard.get(i).iv6R.setImage(image6);
                    listOfBoard.get(i).setAlignment(listOfBoard.get(i).iv6R, Pos.CENTER_RIGHT);
                }
                j++;

            }




            /*if there is no winner, then in computers turn gui is updated by following lines of code */
            if(!winner) {
                if (!game1.playerOne) {
                    updateBoard();
                }
            }



            /*following condition updates the game manager and gui when player grabs dominos from the boneyard.*/
            if(game1.playerOne){
                if(game1.isPlayer1NeedFromBoneYardGui){
                    if(!winner) {
                        game1.updateBoard();
                        updateBoard();
                    }
                    game1.isPlayer1NeedFromBoneYardGui =false;
                } else {
                    game1.isPlayer1NeedFromBoneYardGui =false;
                }
            }



            //this code switches the turn to computer if the human doesnot have any move.
            if(!game1.hasLegalMove(game1.human1) && game1.allElements.size()==0){
                game1.playerOne = false;
            }

            //this code switched the turn to human if the computer doesnot have any move.
            if(!game1.hasLegalMove(game1.player2)&& game1.allElements.size()==0){
                game1.playerOne =true;
            }

            //this condition meets if the computer needs dominos from boneyard and then game is updated
            if(game1.isPlayer2NeedFromBoneYardGui){
                if(!winner) {
                    game1.updateBoard();
                }

                //this condition just checks if there is a winner or not
                if(scoreCounter.findWinner(game1.human1,game1.player2,game1.allElements,game1.gameBoard)) {
                    dialogue.setContentText(scoreCounter.countScore());
                    dialogue.show();
                    winner =true;
                }



                //if there is no winner, update the gui board
                if(!winner) {
                    updateBoard();
                }
                game1.isPlayer2NeedFromBoneYardGui =false;
            } else {
                game1.isPlayer2NeedFromBoneYardGui =false;
            }
            //this condition just checks if there is a winner or not
            if(scoreCounter.findWinner(game1.human1,game1.player2,game1.allElements,game1.gameBoard)) {
                dialogue.setContentText(scoreCounter.countScore());
                dialogue.show();
                winner =true;
            }


            //following lines of code updates the leftover number of dominos with computer and boneyard
            boneYard.setText("Boneyard has " + game1.allElements.size()+" dominos.");
            computerDominos.setText("Computer has " + game1.player2.playerTwoDomino.size()+" dominos");

        }



    }
}