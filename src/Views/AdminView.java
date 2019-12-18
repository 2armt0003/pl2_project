/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author abanob kamal
 */
public class AdminView extends JFrame {
     JPanel panel1= new JPanel();
    JPanel panel2= new JPanel();
    JMenu m1=new JMenu("Main Menu");
    JButton b1=new JButton("User Module");
    JButton b2=new JButton("Room Module");
    JButton b3=new JButton("Service Module");
    JButton b4=new JButton("Back");
    JMenuBar mb1 = new JMenuBar();
    JLabel title = new JLabel("Admin View");
       public AdminView(){
        this.setTitle("Main Frame");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.add(panel1);
        this.add(panel2);
        this.setLayout(null);
        panel1.setBackground(Color.black);
        panel1.setBounds(0, 0, 1000,200);
        panel2.setBounds(0, 200, 1000, 400);
        panel2.setBackground(Color.WHITE);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel1.add(title);
        Font f = new Font("serif", Font.BOLD, 70 );
        title.setForeground(Color.WHITE);
        title.setFont(f);
        title.setBounds(300,50,400,70);
        m1.add(b1); //user module
        m1.add(b2); //room module
        m1.add(b3); //service module
        mb1.add(m1);
        mb1.setBounds(0, 0, 1000, 100);
        mb1.setBackground(Color.LIGHT_GRAY);
        panel2.add(mb1);
        Font t = new Font("serif", Font.BOLD, 30 );
        m1.setFont(t);
        m1.setForeground(Color.BLACK);
        panel1.add(b4); //back
        b4.setBounds(20, 20, 100, 40);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
               UserModule_main u =  new UserModule_main();
               u.setVisible(true);
               
            }
            
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
              RoomManagment_main r =   new RoomManagment_main(); // error 3shan mfesh library eldate 3ndy ahtsht8l 3ndk
              r.setVisible(true);
               
            }
            
        });
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
                dispose(); 
                ServiceModule s = new ServiceModule();
                s.setVisible(true);
            }
            
        });
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
             Login_Screen l =    new Login_Screen();
             l.setVisible(true);
                 
            }
            
        });
        
        
    }
    
}
