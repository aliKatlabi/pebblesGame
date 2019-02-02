/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pebbles;

/**
 *
 * @author Ali pc
 */
public class TurnCounter {
    
    private static int counter;
    private final int limit;
    /**
     * 
     * @param SIZE 
     */
    public TurnCounter(int SIZE){
        counter=0;
        limit=5*SIZE;
    }
    /**
     * 
     * @return the turn counter
     */
    public int getCounter(){
        return counter;
    }
    /**
     * increases the turn counter
     */
    public void increas(){
       counter++;
    }
    /**
     * checks if it is white 's turn
     * @return true if it is white 's turn
     */
    public Boolean isWhiteTurn(){
        return counter%2==0;
    }
    /**
     *checks if it is Black 's turn
     * @return true if it is Black 's turn
     */
     public Boolean isBlackTurn(){
        return counter%2==1;
    }
     /**
      * checks if the the number of turns allowed is reached
      * @return true if the number of turns allowed is reached
      */
    
    public Boolean isOver(){
        return counter==limit;
    }
}
