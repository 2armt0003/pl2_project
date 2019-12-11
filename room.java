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
public class room implements ActionListener { 
    JLabel numberjlabel,typejlabel,servicejlabel;
    JButton addbutton,deletebutton,clearbutton,ubdatebutton,showrooms;
    JComboBox servicejcombobox,typejcombobox;
     JTextField numberjtextfield;
     JTable table;
     JScrollPane p;
      DefaultTableModel modle;
   public  room () {
        JFrame r = new JFrame ("room");
        
        numberjlabel = new JLabel ("number :");
        numberjlabel.setBounds(30, 55,100,50);
        
        numberjtextfield = new JTextField ();
        numberjtextfield.setBounds(100, 70,200, 30);
        
        typejlabel = new JLabel ("type");
        typejlabel.setBounds(30, 160, 100, 50);
        
        String type[]={"sigle","double","triple"};        
        typejcombobox =new JComboBox(type);
        typejcombobox.setBounds(100, 173, 200, 30);
        
        servicejlabel = new JLabel ("service");
        servicejlabel .setBounds(30, 273, 100, 50);
        
        String service[]={"Hous keeping", "Room service ", "Dry clean"};        
        servicejcombobox =new JComboBox(service);
        servicejcombobox.setBounds(100, 286, 200, 30);
        
        addbutton = new JButton ("add");
        addbutton.setBounds(25, 400, 100, 30);
        
        ubdatebutton = new JButton ("ubdate");
        ubdatebutton.setBounds(145, 400, 100, 30);
        
        deletebutton = new JButton ("delete");
        deletebutton.setBounds(268, 400, 100, 30);
        
        clearbutton = new JButton ("clear");
        clearbutton.setBounds(70, 450, 120, 40);
        
        showrooms = new JButton ("Show Rooms");
        showrooms.setBounds(200, 450, 120,40);
    
      
       
       String colums[] = {"NUmber", "Type", "Date In","Date out","Service","Customer Name"};     
         String data[][] = {                           };
       modle = new DefaultTableModel(data, colums);
        
         table = new JTable (modle);
        table.setBounds(450, 50, 700, 600);
        
       
        p = new JScrollPane (table);
        p.setBounds(430,50,650, 650);
       
       
        r.add(p);
        r.add(numberjlabel);
        r.add(numberjtextfield);
        r.add(typejlabel);
        r.add(typejcombobox);
        r.add(servicejcombobox);
        r.add(addbutton);
        r.add(deletebutton);
        r.add(ubdatebutton);
        r.add(clearbutton);
        r.add(servicejlabel);
        r.add(showrooms);
        
        showrooms.addActionListener(this);
        addbutton.addActionListener(this);
        deletebutton.addActionListener(this);
        ubdatebutton.addActionListener(this);
        clearbutton.addActionListener(this);
        
        r.setSize(1200 , 800);    
        r.setLayout(null);    
        r.setVisible(true);
        r.setLocation(500, 100);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Room r1 = new Room ();
       if (e.getSource()== addbutton){
         
           r1.setNumber(numberjtextfield.getText());
           r1.setServices(servicejcombobox.getSelectedItem().toString());
           r1.setType(typejcombobox.getSelectedItem().toString());
           addRoom(r1);
        }
         
       
        
       // add
        if (e.getSource()== deletebutton ){
            
               deletRoom(r1);
       }
   
        // delete
        if (e.getSource() == ubdatebutton){
             
                r1.setNumber(numberjtextfield.getText());
                r1.setServices(servicejcombobox.getSelectedItem().toString());
                r1.setType(typejcombobox.getSelectedItem().toString());
               
                Room_Data_Functions.updateRoom(r1);
    
      }
     if (e.getSource() == showrooms){
               modle.setNumRows(0);
              ArrayList<String> allData = new ArrayList<>();
              allData = Room_Data_Functions.getAllData();
              String [] values;
              for(String line : allData){
                values = line.split(",");
                
                
                modle.addRow(values);
     }
     }
     if (e.getSource() == clearbutton){
        numberjtextfield.setText(" ");
        
     }
     if (e.getSource() == table){
     
       int i = table.getSelectedRow();
                numberjtextfield.setText(modle.getValueAt(i, 0).toString());
              
     
     
     }
   } 

    }
    
