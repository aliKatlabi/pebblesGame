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



import java.awt.Event;

import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import javax.swing.JMenuBar;

import javax.swing.JMenu;

import javax.swing.JMenuItem;

import javax.swing.KeyStroke;



/**

 *

 * @author Ali pc

 */





public class MenuBar extends JMenuBar{

    

    

    public MenuBar(GUIframe frame){

        

        JMenu gameMenu = new JMenu("Start Game");

        JMenu BoardSize=new JMenu("Board Size");

        

        gameMenu.add(BoardSize);

        gameMenu.setMnemonic('G');

        BoardSize.setMnemonic('B');

        

    

        gameMenu.addSeparator();

        

        JMenuItem small = new JMenuItem( new AbstractAction(){

                    @Override

                    public void actionPerformed(ActionEvent e){

                        frame.dispose();

                        GUIframe Start = new GUIframe(3); }

        });

        

        small.setText(" 3 X 3 ");

        small.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));

        

        JMenuItem medium = new JMenuItem(new AbstractAction(){

                    @Override

                    public void actionPerformed(ActionEvent e){

                        frame.dispose();

                        GUIframe Start = new GUIframe(4);

                }   

        });

        medium.setText(" 4 X 4 ");

        medium.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK));

        

        JMenuItem larg = new JMenuItem(new AbstractAction(){

                    @Override

                    public void actionPerformed(ActionEvent e){

                        frame.dispose();

                        GUIframe Start = new GUIframe(6);

                }

        });

        larg.setText(" 6 X 6 ");

        larg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
        
        JMenuItem Exit = new JMenuItem( new AbstractAction(){

                    @Override

                    public void actionPerformed(ActionEvent e){

                        System.exit(0); }

        });

         Exit.setText("Exit");

        gameMenu.add(Exit);

        

        BoardSize.add(small);

        

        BoardSize.add(medium);

        

        BoardSize.add(larg);

        

        add(gameMenu);

        

    }
    
}



   



