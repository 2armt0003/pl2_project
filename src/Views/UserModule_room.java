/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import Users_info.*;
import Data_Io.*;
import static Data_Io.Room_Data_Functions.addRoom;
import static Data_Io.Room_Data_Functions.deletRoom;
import static Data_Io.Room_Data_Functions.tempRoom;
import static Data_Io.Room_Data_Functions.updateRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author nourmaher
 */
public class UserModule_room extends JFrame  { 
    //labels
    JLabel numberjlabel,typejlabel,servicejlabel;
    
    //buttoms
    JButton addbutton,deletebutton,clearbutton,updatebutton;
    JButton    refresh = new JButton();
    
    //combobox
    JComboBox servicejcombobox,typejcombobox;
    
    //textfiled
    JTextField numberjtextfield;
   
    //table 
    String colums[] = {"NUmber", "Type", "Date In","Date out","Service","Customer Name"};     
    String [] []data;
    DefaultTableModel   modle = new DefaultTableModel(data, colums);
    JTable table = new JTable (modle);
    JScrollPane sp = new JScrollPane(table);
   public  UserModule_room () {
    
        view();
        refrshTable();
        updataRoom();
        add_Room();
        deletfun();
        clear();
        table_Click();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000 , 800);    
        this.setLayout(null);    
        this.setVisible(true);
        this.setLocation(500, 100);
        
        
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
        JLabel title2 = new JLabel("(room page)");
        Font f = new Font("serif", Font.BOLD, 50 );
        title.setForeground(Color.WHITE);
        title.setFont(f);
        title2.setForeground(Color.WHITE);
        title.setBounds(300,50,500,70);
        title2.setFont(f);
        title2.setBounds(365,100,400,70);
        nourth.add(title);
        nourth.add(title2);
        //*******************************
        
        //Jpanel west
        West.setBounds(5,205,350,540);
        West.setBorder(BorderFactory.createTitledBorder(""));// to make border areound
        West.setLayout(null);
        West.setBackground(Color.LIGHT_GRAY);
        numberjlabel = new JLabel ("number :");
        numberjlabel.setBounds(10,100,130,25);
        
        numberjtextfield = new JTextField ();
        numberjtextfield.setBounds(140,100,130,25);
        
        typejlabel = new JLabel ("type");
        typejlabel.setBounds(10,200,130,25);
        
        String type[]={"sigle","double","triple"};        
        typejcombobox =new JComboBox(type);
        typejcombobox.setBounds(140,200,130,25);
        
        servicejlabel = new JLabel ("service");
        servicejlabel .setBounds(10,300,130,25);
        
        String service[]={"Hous keeping", "Room service ", "Dry clean"};        
        servicejcombobox =new JComboBox(service);
        servicejcombobox.setBounds(140,300,130,25);
        
        addbutton = new JButton ("add");
        addbutton.setBounds(10,470,100,25);
        
        updatebutton = new JButton ("ubdate");
        updatebutton.setBounds(120,470,100,25);
        
        deletebutton = new JButton ("delete");
        deletebutton.setBounds(230, 470, 100, 25);
        
        clearbutton = new JButton ("clear");
        clearbutton.setBounds(10, 500, 320, 35);
        
         
        West.add(numberjlabel);
        West.add(numberjtextfield);
        West.add(typejlabel);
        West.add(typejcombobox);
        West.add(servicejcombobox);
        West.add(addbutton);
        West.add(deletebutton);
        West.add(updatebutton);
        West.add(clearbutton);
        West.add(servicejlabel);

        //*******************************
        
        //JPanel center
        center.setBounds(365,205,610,540);
        center.setBorder(BorderFactory.createTitledBorder(""));// to make border areound
        center.setLayout(null);
        sp.setBounds(0,0,610,500);
        center.add(sp);
        refresh.setText("Refresh");
        refresh.setBounds(0,500,610,35);
        center.add(refresh);
        //**************************************************
        //Jframe format
        this.add(West);
        this.add(center);
        this.add(nourth);
        
       
    }
    private void  table_Click(){
         table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                System.out.println(i);
                numberjtextfield.setText(modle.getValueAt(i, 0).toString());
                 }
            
         });
        
    }//end fun
     private void updataRoom(){
        Room temp_Room = new Room();
        updatebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                
                temp_Room.setNumber(numberjtextfield.getText().toString());
               
                temp_Room.setType(typejcombobox.getSelectedItem().toString());
                temp_Room.setServices(servicejcombobox.getSelectedItem().toString());
               
           
                Room_Data_Functions.updateRoom(temp_Room);
            }       
        });
    }//end fun
    
    private void deletfun(){
        Room temp_Room = new Room();
        deletebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                temp_Room.setNumber(numberjtextfield.getText().toString());
                Room_Data_Functions.deletRoom(temp_Room);
            }
         
        });
    }//end fun
     private void add_Room(){
        Room temp_Room = new Room();
        addbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                System.out.println("he in addroom");
                temp_Room.setNumber(numberjtextfield.getText().toString());
               
                temp_Room.setType(typejcombobox.getSelectedItem().toString());
                temp_Room.setServices(servicejcombobox.getSelectedItem().toString());
               
           
                Room_Data_Functions.addRoom(temp_Room);
            }       
        });
    }//end fun
    private void clear(){
        clearbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numberjtextfield.setText("  ");
              
            }
         
        });
        
    }//end fun
    
    private void refrshTable(){
        refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
              modle.setNumRows(0);
              ArrayList<String> allData = new ArrayList<>();
              allData = Room_Data_Functions.getAllData();
              String [] values;
              for(String line : allData){
                values = line.split(",");
                
                modle.addRow(values);
            }
            
         }
        });
    }//end fun

   
}//end class
    
