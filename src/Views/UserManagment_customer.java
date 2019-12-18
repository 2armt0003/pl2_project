/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Data_Io.Customer_Data_Functions;
import Users_info.Customer;
import java.awt.Button;
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
    Button back = new Button("Back");
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
    
    
    
    
 
    
    //bottoms
    JButton Add= new JButton("Add");
    JButton Delete = new JButton("Delete");
    JButton update = new JButton("update");
    JButton clear = new JButton("clear");
    JButton refresh = new JButton("refresh");
    
    //table 
         String colums[] = {"Name", "phone","mail", "nationalty","gender"};     
         String data[][] = {                           };
        DefaultTableModel modle = new DefaultTableModel(data, colums);
        JTable table = new JTable(modle);
        JScrollPane sp=new JScrollPane(table);
       
    //radio bottum
        JRadioButton radioButton_1 = new JRadioButton("Male",true);
        JRadioButton radioButton_2 = new JRadioButton("FeMale");
        ButtonGroup group = new ButtonGroup();                   
     //  JComboBox   
       String s1[] = { "Egyption","forigner" }; 
       JComboBox Nationalty = new JComboBox(s1);    
       
       
    public UserManagment_customer() throws HeadlessException{
        
          view();
        backbutton();
        addCustemr();
        updatCustemr();
        deleteCustemr();
        clearFun();
        refreshTable();
        tableClick();
        this.setLayout(null);
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);//make program in the center of screen
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       // this.setVisible(true);
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
        JLabel title = new JLabel("User Management");
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
        back.setBounds(5,5,30,15);
        nourth.add(back);
        
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
        nationalty.setBounds(10,130,130,25);
        Nationalty.setBounds(140,130,130,25);
        gender.setBounds(10,170,130,25);
        radioButton_1.setBounds(80, 190, 100, 25);
        radioButton_2.setBounds(230, 190, 100, 25);
         
         
        Add.setBounds(10,280,270,25);
        Delete.setBounds(10,310,270,25);
        update.setBounds(10,340,270,25);
        clear.setBounds(10,370,270,25);
        West.add(name);
         West.add(name_TF);
        West.add(phone);
         West.add(phone_TF);
        West.add(mail);
         West.add(mail_TF); 
        West.add(nationalty);
         West.add(Nationalty);
        group.add(radioButton_1);                             
        group.add(radioButton_2); 
        West.add(radioButton_1);                             
        West.add(radioButton_2);
        West.add(Add);
        West.add(Delete);
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
     private void backbutton(){
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                UserModule_main main = new UserModule_main();
                main.setVisible(true);
            }
            

        });
    }
       private void  tableClick(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i =table.getSelectedRow();
                name_TF.setText(modle.getValueAt(i, 0).toString());
                phone_TF.setText(modle.getValueAt(i, 1).toString());
                mail_TF.setText(modle.getValueAt(i, 2).toString());
                 }
            
         });
         }//end fun
        Customer tempCustoemr = new  Customer();
    private void updatCustemr(){
     
       update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                
                tempCustoemr.setName(name_TF.getText().toString());
                tempCustoemr.setPhone(phone_TF.getText().toString());
                tempCustoemr.setMail(mail_TF.getText().toString());
                tempCustoemr.setNationalty(Nationalty.getSelectedItem().toString());
                if(radioButton_1.isSelected()){
                    tempCustoemr.setGender(radioButton_1.getText().toString());
                }
                else{
                   tempCustoemr.setGender(radioButton_2.getText().toString()); 
                }
                
                
               Customer_Data_Functions.updateCustomer(tempCustoemr);
            }       
        });
    }//end fun
      private void deleteCustemr(){
     
      Delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                
                 
              tempCustoemr.setName(name_TF.getText().toString());
                tempCustoemr.setPhone(phone_TF.getText().toString());
                tempCustoemr.setMail(mail_TF.getText().toString());
                tempCustoemr.setNationalty(Nationalty.getSelectedItem().toString());
                if(radioButton_1.isSelected()){
                    tempCustoemr.setGender(radioButton_1.getText().toString());
                }
                else{
                   tempCustoemr.setGender(radioButton_2.getText().toString()); 
                }
                
               
               Customer_Data_Functions.deletCustomer(tempCustoemr);
            }       
        });
    }//end fun*/  
    private void addCustemr(){
     
      Add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                
              tempCustoemr.setName(name_TF.getText().toString());
                tempCustoemr.setPhone(phone_TF.getText().toString());
                tempCustoemr.setMail(mail_TF.getText().toString());
                tempCustoemr.setNationalty(Nationalty.getSelectedItem().toString());
                 if(radioButton_1.isSelected()){
                    tempCustoemr.setGender(radioButton_1.getText().toString());
                }
                else{
                   tempCustoemr.setGender(radioButton_2.getText().toString()); 
                }
                
                
               Customer_Data_Functions.addCustomer(tempCustoemr);
            }       
        });
    }//end fun
        private void clearFun(){
        clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                name_TF.setText("  ");
                phone_TF.setText("  ");
                mail_TF.setText("  ");
              
              
            }
         
        });
        
    }//end fun
          private void refreshTable(){
        refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              modle.setNumRows(0);
              ArrayList<String> allData = new ArrayList<>();
              allData = Customer_Data_Functions.getAllData();
              String [] values;
              for(String line : allData){
                values = line.split(",");
                
                modle.addRow(values);
                   }
            }
               
        });
    }
   
}//end class
