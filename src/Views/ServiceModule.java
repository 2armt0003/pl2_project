/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Data_Io.Room_Data_Functions;
import Data_Io.Service_Data_Functions;
import Users_info.Service;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abanob kamal
 */
public class ServiceModule extends JFrame{
    
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    
    JLabel L1 = new JLabel ("SERVICE MANAGMENT"); 
    JLabel L2 = new JLabel ("Name"); 
    JLabel L3 = new JLabel ("Type"); 
    JLabel L4 = new JLabel ("Description"); 
    
    JTextField T1 = new JTextField(50);
    
    String type[]= {"For all", "Private"};
    JComboBox  cb1 = new  JComboBox(type) ;
    
    JTextArea A1 =new JTextArea();
    
   JButton bt1 = new JButton("Add");
   JButton bt2 = new JButton("Update");
   JButton bt3 = new JButton("Delete");
   JButton bt4 = new JButton("Clear");
   JButton bt5 = new JButton("Refresh");
   JButton bt6 = new JButton("Back");
   
   String columns[]={"Name","Type","Description"}; 
    String data[][]={ };
    DefaultTableModel model = new DefaultTableModel(data, columns);
     JTable table = new JTable(model);
       
    JScrollPane sp =new JScrollPane (table);
    
    Font f = new Font("serif", Font.BOLD, 50 );
   
             
    public ServiceModule() {
        
        
  
    
    p1.setBounds(0,0,1000,150);
    p1.setBackground(Color.DARK_GRAY);
    p1.setLayout(null);
    p1.add(L1);
    p1.add(bt6);
    L1.setFont(f);
    L1.setBounds(200,40,600,70);
    L1.setForeground(Color.WHITE);
    bt6.setBounds(20,20,100,40);   
    
    p2.setBounds(0,150,400,650);
    p2.setBackground(Color.GRAY);
    p2.setLayout(null);
    p2.add(L2);
    p2.add(T1);
    p2.add(L3);
    p2.add(cb1);
    p2.add(L4);
    p2.add(A1);
    p2.add(bt1);
    p2.add(bt2);
    p2.add(bt3);
    p2.add(bt4);
    L2.setBounds(30,50,60,40);
    T1.setBounds(100,60,150,25);  
    L3.setBounds(30,120,60,40);
    cb1.setBounds(100,135,150,25);
    L4.setBounds(30,190,80,40);
    A1.setBounds(60,230,250,90);
    bt1.setBounds(30,380,100,40);
    bt2.setBounds(150,380,100,40);
    bt3.setBounds(270,380,100,40);
    bt4.setBounds(100,460,200,40);
    
    p3.setBounds(400,150,600,650);
    p3.setBackground(Color.LIGHT_GRAY);
    p3.setLayout(null);
    p3.add(sp);
    p3.add(bt5);
    sp.setBounds(0,0,600,560);
    bt5.setBounds(120,565,300,40);
          
    tableClick();
    addservice();
    updateService();
    deleteService();
    refreshTable();
    backbutton();
    clearFun();
    this.add(p1);
    this.add(p2);
    this.add(p3); 
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1000,800); 
  
     //this.setVisible(true);
    this.setResizable(false);
  
    this.setLocationRelativeTo(null);
    }
    
    
    
      private void  tableClick(){
         table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              int i = table.getSelectedRow();
               T1.setText(model.getValueAt(i, 0).toString());
                cb1.setSelectedItem(model.getValueAt(i, 1).toString());
                A1.setText(model.getValueAt(i, 2).toString());
                 }
            
         });
   
      } 
      
      
      
        Service service = new Service();
      private void addservice(){
       bt1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               service.setName(T1.getText().toString());
               service.setType(cb1.getSelectedItem().toString());
               service.setDiscription(A1.getText().toString());
               Service_Data_Functions.addService(service);
                System.out.println("is herer ");
            }
         
        });
        
    }
      
      
  
  
      Service tempservice = new Service();
    private void updateService(){
     
       bt2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                
                tempservice.setName(T1.getText().toString());
                tempservice.setType(cb1.getSelectedItem().toString());
                tempservice.setDiscription(A1.getText().toString());
                Service_Data_Functions.updateService(tempservice);
            }       
        });
    }
    
    
    private void deleteService(){
     
       bt3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                service.setName(T1.getText().toString());
                service.setType(cb1.getSelectedItem().toString());
                service.setDiscription(A1.getText().toString());
                Service_Data_Functions.deletService(service);
            }       
        });
    }
    
    

  private void clearFun(){
       bt4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               T1.setText("  ");
               cb1.setSelectedItem(null);
               A1.setText("  ");
               
            }
         
        });
        
    }
   private void refreshTable(){
        bt5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              model.setNumRows(0);
              ArrayList<String> allData = new ArrayList<>();
              allData = Service_Data_Functions.getAllData();
              String [] values;
              for(String line : allData){
                values = line.split(",");
                
                model.addRow(values);
              }
            }
            
        });
        
    }//end fun
    private void backbutton(){
        bt6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                AdminView main = new AdminView();
                main.setVisible(true);
            }
            

        });
    }
    
}//end class
