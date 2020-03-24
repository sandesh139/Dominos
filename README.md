# Dominos Game
Author -Sandesh Timilsina

# How to play
You have two options to run the program:

 - Important NOTES FOR GUI JAR
I spent more than decent amount of time changing my code for making the gui jar.I talked
to the TAs and Mrs. Brooke for making the jar file. But, we could not figure that up in the
lab. So I was told in the lab by Mrs Brooke to inculde this note in README file for not loosing
the points for jar file.

 - can run the dominos_console.jar for java 10 version or console_8JDK.jar for java 8 version file
by executing it from command line.

For the console version, you will be asked to provide the location of the domino you want
to play. 0 is the first location, 1 is the second and so on. Then, you will be asked to
provide the side left or right. You can type r or right for right and l or left for left.
Then, you will be asked with rotate confirmation. If you want to rotate the domino, you can.
After this your domino will be placed to the board if it is allowed. If not allowed, you have
to redo the process again. You will be auto-picked from boneyard until you get the matching
domino peice. 0 is the wild card that can be matched to any next dots.


 - can run the MainClass inside the src directory to compile and run the game.

For GUI version,he game is played by mouse-clicking on the watermelon-dominos. For the first
domino, you can just click on the domino on the top row and confirm button. The domino is then
removed from the top row human dominos and is placed on to the board. Then computer will make
a move from his own collection of domino. Then, you choose either side of your any domino that
match with the left dots of left end board or with right dots of right end domino. If you dont
find a matching domino, you click on pick from boneyard button on the bottom right.
After you get the domino from boneyard, you should click on the domino that matches. But,
If you were not provided with the domino from boneyard, it means, you already have a matching
domino. Once you select the matching domino, you will hit left or right for adding side and rotate
for rotation of the dots in the selected domino. Then, you can click confirm and play next move
in the same way just explained.

# Score
Score is only counted when there is a winner. Score is calculated as the difference between
the total dots each player has. The player with lower dots wins the game.

# Game Logic
The Classes in the game are MainClass, GameManager, PlayerOne, PlayerTwo, Score, and Node.
Each classes are commented clearly to get the idea what each class does in the game. So, the
logic for this game is MainClass holds the GUI ability and obtains the processed information
from GameManager. Then, MainClass updates the GUI based on the arraylist dominos of and
linkedlist of the board. GameManger gets the input from MainClass from human player and checks
if the selected domino is allowed move in the game or not. Legal move is determined based on the
comparision between the dots in the human domino and the dots of the either side of board. If those
dots matches then, move is allowed. 0 is the wild card that can be matched to any next dots.

# Algorithm
For checking if the move is allowed in the game, there is a check for each domino of the corresponding
player with the end dots of the board. After this check the domino is placed and the linkedlist of the
gameboard and corresponding player's arraylist.

# Bugs in the program
There are some bugs in the game. Main bug is at the end. In some play, there is a error in the program that
when bonyard is left empty and a player has one card left and other has multiple playing cards, then turn gets
stopped at that players turn without playing the allowed dominos. And, in some play the game says out of index
error just before the end of game.
 


