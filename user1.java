/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;



import javafx.scene.paint.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author nourmaher
 */
public class user1 implements ActionListener  {
   JLabel receptionmanagment;    
  JButton clintbutton,employeebutton,roombutton;
  JFrame f ;
    public user1 (){
   
         f = new JFrame ("Receptian Managment");
          receptionmanagment = new JLabel("Receptian Managment");
          receptionmanagment.setFont(new Font("Courier New", Font.ITALIC, 50));
          receptionmanagment.setBounds(120, 50, 600, 200);
         clintbutton =new JButton("Clint");
        clintbutton.setBounds(350, 300, 100, 50);
         clintbutton.addActionListener(this);
        
         employeebutton =new JButton("Employee");   
         employeebutton.setBounds(200, 300, 100, 50);
         employeebutton.addActionListener(this);
        roombutton=new JButton("Room");  
        roombutton.setBounds(500, 300, 100, 50);
        roombutton.addActionListener(this);
        
        
        f.add(employeebutton);
        f.add(clintbutton);
        f.add(roombutton);
        f.add(receptionmanagment);
        
         
        
              f.setSize(800 , 800);    
              f.setLayout(null);    
              f.setVisible(true);    
              f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              f.setLocation(500, 100);
    
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==roombutton){
          f.setVisible(false);
          room r1 = new room();
      }
      if (e.getSource()==clintbutton){
          f.setVisible(false);
            
      }
      if (e.getSource()==employeebutton){
          f.setVisible(false);

      }
    }
}
