/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Users_info.Admin;
import Users_info.Receptionest;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author abanob kamal
 */
public class Login_Screen extends JFrame {
    action a = new action();
    JButton b = new JButton("login");
    JTextField userName_TF = new JTextField();
    JPasswordField password_PF = new JPasswordField();
    
    public Login_Screen() throws HeadlessException {
        Login_panal();
        this.setLayout(null);
        this.setSize(400,500);
        this.setTitle("login page ");
        this.setLocationRelativeTo(null);//make program in the center of screen 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    void Login_panal(){
        JPanel j = new JPanel();
        j.setBounds(40, 70, 300, 300);
        j.setLayout(null);
        //labels
        JLabel label1 = new JLabel("User Name");
        JLabel label2 = new JLabel("Password");
        label1.setBounds(30,50,100,25);
        label2.setBounds(30,100,100,25);
        
        //text fileds
        
        userName_TF.setBounds(130,50,150,25);
        password_PF.setBounds(130,100,150,25);
        
        //bottom
        b.setBounds(100, 200, 100, 25);
        b.addActionListener(a);
        
        //adding
        j.setBorder(BorderFactory.createTitledBorder("Add User"));// to make border areound
        j.add(label1);
        j.add(label2);
        j.add(userName_TF);
        j.add(password_PF);
        j.add(b);
        this.add(j);
    }
    private class action implements ActionListener{
        String TF1,TF2;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b ){
            TF1 = userName_TF.getText();
            TF2 = password_PF.getText();
            //objects
            Admin ad = new Admin();
            ad.setName(TF1);
            ad.setPassword(TF2);
            
            Receptionest r= new Receptionest();
            r.setName(TF1);
            r.setPassword(TF2);
            
            if(Admin.AdminLogin(ad) == true){
                System.out.println("hollo admin " + ad.getName());
            }
            else if(Receptionest.ReceptionestLogin(r) == true){
                System.out.println("hollow receptionest");
            }
                
            
        }
    } 
    } //end action class
}//end class

