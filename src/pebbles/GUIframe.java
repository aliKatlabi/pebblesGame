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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pebbles;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Ali pc
 */
public class GUIframe extends JFrame {
    
    private final MenuBar menuBar;
    private final GUIBoard board;
    
    public GUIframe(int BOARD_SIZE){
        /*menubar*/
        menuBar = new MenuBar(this);
        board =new GUIBoard(BOARD_SIZE,this);
     
        setJMenuBar(menuBar);
        
        setTitle("Pebble Game");
        setSize(500,500);
         
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        getContentPane().add(board.getBoardPanel(),BorderLayout.CENTER);
        getContentPane().add(board.getTurnLabel(), BorderLayout.SOUTH);
        
        
        setVisible(true);
       
}
        
}

    
    
