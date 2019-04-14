// Ali katlabi
//
// OT9IO5
//
// 2nd assignments_Pebble
//
// 2018/11/19 02:55:09
//
// This solution was submitted and prepared by Ali katlabi, OT9IO5 for the
// 2nd assignments_Pebble assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

package pebbles;





import javax.swing.JButton;

import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JOptionPane;





/**

 *

 * @author Ali pc

 */

public class GUIBoard {

    

    private final JButton spot[][];

    private final TurnCounter turn;

    private final JLabel turnLabel;

    private final JPanel boardPanel;

    private final int BOARD_SIZE;

    private  int clicks=0;

    private int points[];

    private JOptionPane JOptionPane;

    private GUIframe mainFrame;

    

    public GUIBoard(int BOARD_SIZE,GUIframe _mainFrame){

       

        this.BOARD_SIZE=BOARD_SIZE;

        points= new int[4];

        this.mainFrame=_mainFrame;

        turn=new TurnCounter(BOARD_SIZE);

        spot = new JButton[BOARD_SIZE][BOARD_SIZE];

        

        JOptionPane=new JOptionPane();

      

        

        turnLabel=new JLabel("White's Turn");

        

        boardPanel = new JPanel();

        boardPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));

                

        for(int i=0;i<BOARD_SIZE;i++)

        {

            for(int j=0;j<BOARD_SIZE;j++)

            {
                spot[i][j] = new JButton();
                
                spot[i][j].addActionListener(new ButtonListener(i,j));

                boardPanel.add(spot[i][j]);
                
                if(i==0)

                {
                    spot[i][j].setBackground(Color.BLACK);

                }

                if(i==BOARD_SIZE-1){
                    
                    spot[i][j].setBackground(Color.WHITE);

                }

                if(i!=0&&i!=BOARD_SIZE-1){

                spot[i][j].setBackground(Color.lightGray);

                } 

            } 

        }

    }

    

    /**

     * check if the game is over and show message of the winner 

     */

    public void checkGame(){

        boolean tie=false;

        boolean newGame=false;

        int blacks=0;

        int whites=0;

        for(int i=0;i<BOARD_SIZE;i++){

            for(int j=0;j<BOARD_SIZE;j++){

                            if(spot[i][j].getBackground()==Color.WHITE){whites++;}

                            if(spot[i][j].getBackground()==Color.BLACK){blacks++;}

                        }

                    }

        if(turn.isOver())
        {
            
            if(blacks==whites)
            {
                tie=true; 
            }
            
            newGame=true;
            
        }
        else
        { 
            if(whites==0||blacks==0)
            {
                newGame=true;
            }
        }

        if(newGame){

            if(tie){

                    JOptionPane.showMessageDialog(mainFrame,"It is a tie !");
            }

            else{

                   JOptionPane.showMessageDialog(mainFrame,blacks>whites?"Black is the winner !":"White is the winner !");
            }

            mainFrame.dispose();
            
            GUIframe Start = new GUIframe(3);
        }

    }

    /**

     * 

     * @return JPanel that contain the buttons 

     */

    public JPanel getBoardPanel(){return boardPanel;}

    

   

    class ButtonListener implements ActionListener {

        int x;

        int y;

        public ButtonListener(int x,int y){

            this.x=x;

            this.y=y;
        }
        
        @Override

        public void actionPerformed(ActionEvent evt) {

           

            boolean realizeTurn= turn.isBlackTurn()&&spot[x][y].getBackground()==Color.BLACK

                                ||turn.isWhiteTurn()&&spot[x][y].getBackground()==Color.WHITE;

       

            clicks++;

            turnLabel.setText((turn.isWhiteTurn()?"White's Turn":"Black's Turn"));

                                                   

            if(realizeTurn&&(clicks%2==1)){
                
                        points[0]=x;

                        points[1]=y;
                        
                        turnLabel.setText((turn.isWhiteTurn()?"White's Turn":"Black's Turn")+" Move it one step");
            }
            else
            {
                if((clicks%2==0)&&realizeTurn){
                    
                clicks--;
                
                turnLabel.setText(
                        
                        (turn.isWhiteTurn()?"White's Turn":"Black's Turn")
                        +" .Can't stay in place or push your own pebble "
                        + " .move it one step ");
           
                }
            }
            if((clicks%2==0)){
                
                        points[2]=x;
                        points[3]=y;
                        
                        int nextX=      points[2];

                        int nextY=      points[3];

                        int X=          points[0];

                        int Y=          points[1];

                boolean isAdjacent =      (nextX==X+1&&nextY==Y)

                                        ||(nextX==X-1&&nextY==Y)

                                        ||(nextX==X&&nextY==Y+1)

                                        ||(nextX==X&&nextY==Y-1);

                

                boolean isSameButtonClicked =(nextX!=X)&&(nextY!=Y);
                

                boolean notBoard            =spot[X][Y].getBackground()!=Color.lightGray;
                
                
                boolean differentColor      = spot[nextX][nextY].getBackground()!= spot[X][Y].getBackground();

                

                if( isAdjacent   &&     differentColor  &&   !isSameButtonClicked  && notBoard )

                {
                                 boolean moved=move(X,Y,nextX,nextY);

                                    if(moved){
                                    
                                        turn.increas();
                                        
                                        turnLabel.setText(

                                            (turn.isWhiteTurn()?"White's Turn":"Black's Turn")+

                                            (clicks==0?"  choose pepple":""));
                                    }
                                    if(!moved)
                                    {
                                        
                                        turnLabel.setText(

                                            (turn.isWhiteTurn()?"White's Turn":"Black's Turn")+

                                            " . Can't push your own pebble");
                                    }

                                    checkGame();
                                    
                }

                else{
                    
                    turnLabel.setText(
                            
                                        (turn.isWhiteTurn()?"White's Turn":"Black's Turn")+
                                    
                                        (turn.isWhiteTurn()?" .Choose again form Whites":" .Choose again form Blacks"));
                    

                    clicks=0;
                }
            }

            else{

                clicks=clicks>2?0:-1;

            } 

        }

        

        /**

         * takes the coordinate of a Pebble and the coordinate of the position to move it to 

         * @param x position x of clicked button for the first click 

         * @param y position x of clicked button for the first click

         * @param nextX position x to move to

         * @param nextY position y to move to

         */

        public boolean move(int x,int y , int nextX,int nextY){
            
       Color ownColor;

       Color boardColor = Color.lightGray;

        byte adjacent=0;
        
        boolean noMove = false;

       if(spot[x][y].getBackground()!=boardColor){//we cant move a board squar

       if(turn.isBlackTurn()){
           
      
           ownColor=Color.BLACK;

       }
       else if(turn.isWhiteTurn()){
           
      
           ownColor=Color.WHITE;
       }
       else{
           
           ownColor=boardColor;
      
       }
       
       if(nextX<x)
       {

                    for(int i=x-1;i>=0;i--)
                    {

                        if(spot[i][y].getBackground()!=boardColor){
                            
                            adjacent++;
                        }
                        else
                        {
                            break; 
                        }
                        
                        
                        if(spot[0][y].getBackground()==ownColor&&adjacent>x-2){
                            noMove=true;
                            break;
                             
                        }
                    }
                    if(!noMove)
                    {
                        
                    for(int i=x-adjacent;i<=x;i++)
                    {

                        if(i-1<0) {

                            spot[i][y].setBackground(boardColor); 
                        }

                        else{

                            spot[i-1][y].setBackground(spot[i][y].getBackground());

                            spot[i][y].setBackground(boardColor);

                                 }

                    }
                    
                    }

       }

        if(nextY<y)
        { 

                    for(int i=y-1;i>=0;i--)
                    {
                        

                        if(spot[x][i].getBackground()!=boardColor){
                       
                            adjacent++;
                        }
                        else
                        {
                            break;
                        }
                        
                        
                       if(spot[x][0].getBackground()==ownColor&&adjacent>y-2)
                       {
                            
                            noMove=true;
                            break;
                       }
                    }

                   
                    if(!noMove)
                    {
                    

                    for(int i=y-adjacent;i<=y;i++)
                    {

                        if(i-1<0){

                            spot[x][i].setBackground(boardColor);

                        }

                        else{

                       

                        spot[x][i-1].setBackground(spot[x][i].getBackground());

                        spot[x][i].setBackground(boardColor);

                        }
                    }
                    }
        }

       if(nextX>x)

                {

                    for(int i=x+1;i<=BOARD_SIZE-1;i++){

                        if(spot[i][y].getBackground()!=boardColor)
                        {
                            adjacent++;
                        }
                        else
                        {
                        
                            break;
                        }
                        
                        if(spot[BOARD_SIZE-1][y].getBackground()==ownColor&&adjacent>BOARD_SIZE-x-3){
                            
                            noMove=true;
                            break;
                        }

                        }

                    
                    if(!noMove){
                        
                    for(int i=x+adjacent;i>=x;i--){

                        if(i+1>=BOARD_SIZE){

                            

                                spot[i][y].setBackground(boardColor);

                        }

                        else{

                                spot[i+1][y].setBackground(spot[i][y].getBackground());

                                spot[i][y].setBackground(boardColor);



                        }
                    }
                    
                    }
                    
                }

      

       if(nextY>y){

                    for(int i=y+1;i<=BOARD_SIZE-1;i++){

                        if(spot[x][i].getBackground()!=boardColor){
                            
                            adjacent++;
                        }else{

                            break;
                        }
                        
                        
                        if(spot[x][BOARD_SIZE-1].getBackground()==ownColor&&adjacent>BOARD_SIZE-y-3){
                            
                            noMove=true;
                            break;
                        }

                        } 
                    
                    if(!noMove)
                    {
                        
                    for(int i=y+adjacent;i>=y;i--){

                        if(i+1>=BOARD_SIZE){

                            spot[x][i].setBackground(boardColor);

                        }

                        else{
                            
                            spot[x][i+1].setBackground(spot[x][i].getBackground());

                            spot[x][i].setBackground(boardColor);

                        }
                    }
                    
                }
            }
       
       }
      
       
       return !noMove;

       }

    }

    /**

     * 

     * @return JLabel that show the turn to be put on the frame

     */

     public JLabel getTurnLabel(){

        return turnLabel;

    }

     

   }
