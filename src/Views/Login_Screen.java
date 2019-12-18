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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


/**
 *
 * @author abanob kamal
 */
public class Login_Screen extends JFrame {
   
    JButton loginButtom = new JButton("login");
    JTextField userName_TF = new JTextField();
    JPasswordField password_PF = new JPasswordField();
    
    public Login_Screen() throws HeadlessException {
        Login_panal();
        loginFun();
        this.setLayout(null);
        this.setSize(400,500);
        this.setTitle("login page ");
        this.setLocationRelativeTo(null);//make program in the center of screen 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       // this.setVisible(true);
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
        loginButtom.setBounds(100, 200, 100, 25);
       
        
        //adding
        j.setBorder(BorderFactory.createTitledBorder("Add User"));// to make border areound
        j.add(label1);
        j.add(label2);
        j.add(userName_TF);
        j.add(password_PF);
        j.add(loginButtom);
        this.add(j);
    }
    private void next(){
        this.setVisible(false);
    }
    String TF1,TF2;
    private void loginFun(){
        loginButtom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == loginButtom ){
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
                next();
                AdminView main = new AdminView();
                main.setVisible(true);
                
                
            }
            else if(Receptionest.ReceptionestLogin(r) == true){
                next();
                UserModule_main u= new UserModule_main();
                u.setVisible(true);
               
               
            }
            
            }   
        }    
        });        
    }     
      
    
   
}//end class

