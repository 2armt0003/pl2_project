/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Data_Io.Customer_Data_Functions;
import Users_info.Customer;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abanob kamal
 */
public class UserManagment_customer extends JFrame{
       //jlabales
    JLabel name  = new JLabel("Name");
    JLabel phone = new JLabel("Phone");
    JLabel mail = new JLabel("Mail");
    JLabel nationalty = new JLabel("Nationalty");
    JLabel gender = new JLabel("Genter");
    
    
    //jtext fields
    JTextField name_TF = new JTextField();
    JTextField phone_TF = new JTextField();
    JTextField mail_TF = new JTextField("Mail");
    //spinner
    String [] nationalty_spinner = {"single", "double"};
    SpinnerListModel sl1 = new SpinnerListModel(nationalty_spinner);
    JSpinner nationalty_list = new JSpinner(sl1);
    
    
    
 
    
    //bottoms
    JButton update = new JButton("update");
    JButton clear = new JButton("clear");
    JButton refresh = new JButton("refresh");
    
    //table 
         String colums[] = {"NUmber", "Type", "Date In","Date out","Service","Customer Name"};     
         String data[][] = {                           };
        DefaultTableModel modle = new DefaultTableModel(data, colums);
        JTable table = new JTable(modle);
        JScrollPane sp=new JScrollPane(table);
       
    //radio bottum
        JRadioButton radioButton_1 = new JRadioButton("Red",true);
        JRadioButton radioButton_2 = new JRadioButton("Blue");
        ButtonGroup group = new ButtonGroup();                   
        
       
       
    public UserManagment_customer() throws HeadlessException{
        
          view();
        
    
        this.setLayout(null);
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);//make program in the center of screen
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false); 
    }
        
    private void view(){
       
      
        //Jpanel
        JPanel nourth = new JPanel();
        JPanel West = new JPanel();
        JPanel center = new JPanel();
        
        //JPanel nourth
        nourth.setBounds(0,0,980,200);
        nourth.setBorder(BorderFactory.createTitledBorder(""));// to make border areound
        nourth.setBackground(Color.darkGray);
        nourth.setLayout(null);
        JLabel title = new JLabel("Room Management");
        JLabel title2 = new JLabel("(customer page)");
        Font f = new Font("serif", Font.BOLD, 50 );
        Font f2 = new Font("serif", Font.BOLD, 30 );
        title.setForeground(Color.WHITE);
        title.setFont(f);
        title.setBounds(300,50,500,70);
        title2.setForeground(Color.WHITE);
        title2.setFont(f2);
        title2.setBounds(410,100,300,70);
        nourth.add(title);
        nourth.add(title2);
        
        //Jpanel west
        West.setBounds(5,205,350,540);
        West.setBorder(BorderFactory.createTitledBorder(""));// to make border areound
        West.setLayout(null);
        West.setBackground(Color.LIGHT_GRAY);
        
        name.setBounds(10,10,130,25);
         name_TF.setBounds(140,10,130,25);
        phone.setBounds(10,50,130,25);
         phone_TF.setBounds(140,50,130,25);
        mail.setBounds(10,90,130,25);
         mail_TF.setBounds(140,90,130,25);
      
        update.setBounds(10,250,270,25);
        clear.setBounds(10,280,270,25);
        West.add(name);
         West.add(name_TF);
        West.add(phone);
         West.add(phone_TF);
        West.add(mail);
         West.add(mail_TF); 
        West.add(nationalty);
         West.add(nationalty_list);
        group.add(radioButton_1);                             
        group.add(radioButton_2); 
        
        West.add(update);
        West.add(clear);
        //**************************************************
        
        
        //JPanel center
        center.setBounds(365,205,610,540);
        center.setBorder(BorderFactory.createTitledBorder(""));// to make border areound
        center.setLayout(null);
        sp.setBounds(0,0,610,500);
         
        center.add(sp);
        
        refresh.setBounds(0,500,610,35);
        center.add(refresh);
        //**************************************************
        //Jframe format
         this.add(West);
        this.add(center);
        this.add(nourth);
        
       
    }  
       
   
}//end class
