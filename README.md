# pebbles Game

Game description:
It is a two-player game , the winner is one who drop the most of other opponent’s pebbles of the edge.
If there is still pebbles on the field the winner is the one holding more pebbles .Ali Katlabi OT9IO5
description of each methods

(for learning purposes) 

GUIBoard class includes :

-ButtonListener class which include :

-public void move ( Int x , int y , int nextX , int nextY) : is the main algorithm to move pebbles

based on coordinates from first buttons clicked to determine which pebble we want to move

and the second button which is the movement direction
-implement the ActionListener which use the actionPerformed method to select the pebble for

first click and move it to the chosen location based on wide range of movement shields (logical
conditions) .
-public void checkGame() : to check the state of the game and it will notify and start new
game .

-JPanel getBoardPanel() : return JPanel that contain the buttons .

-JLabel getTurnLabel() : return JLabel that show the turn to be put on the frame .

TurnCounter class :
-int getCounter() : return the turn counter .

-void increas() : increases the turn counter .

-Boolean isWhiteTurn() : checks if it is White 's turn .

-Boolean isBlackTurn() : checks if it is Black 's turn .

-Boolean isOver() : checks if the the number of turns allowed is reached .

Also there is MenuBar class and the GUIframe class …
