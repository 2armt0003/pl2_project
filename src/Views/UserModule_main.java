/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.UserModule_room;


import javafx.scene.paint.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author nourmaher
 */
public class UserModule_main extends JFrame implements ActionListener  {
   JLabel receptionmanagment;    
  JButton clintbutton,employeebutton,roombutton ;
  Button back = new Button("Back");
 
    public UserModule_main (){
   
       
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
        
         back.setBounds(5,5,30,15);
         back.addActionListener(this);
         this.add(back);
         
         
        this.add(employeebutton);
        this.add(clintbutton);
        this.add(roombutton);
        this.add(receptionmanagment);
        
         
        
              this.setSize(800 , 800);    
              this.setLayout(null);    
             // this.setVisible(true);    
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setLocation(500, 100);
    
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==roombutton){
          this.setVisible(false);
         UserModule_room r = new UserModule_room();
          r.setVisible(true);
         
      }
      if (e.getSource()==clintbutton){
          this.setVisible(false);
          UserManagment_customer c = new UserManagment_customer();
          c.setVisible(true);
          
            
      }
      if (e.getSource()==employeebutton){
          this.setVisible(false);
          UserManagemnet_employee em = new UserManagemnet_employee();
          em.setVisible(true);

      }
      if(e.getSource() == back){
          this.setVisible(false);
          AdminView a = new AdminView();
          a.setVisible(true);
      }
    }
}
