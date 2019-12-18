/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import Data_Io.Customer_Data_Functions;
import Data_Io.Room_Data_Functions;
import Users_info.Customer;
import Users_info.Room;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abanob kamal
 */
public class RoomManagment_bill extends JFrame implements ActionListener{
    //buttom 
    Button back = new Button("Back");

    JLabel l1 , l2,
        l3  =new JLabel("Billing Management");;
    JTextField t1 ,t2;
    JButton btn1 , btn2 ;
    //table
    String[][] data ={};
    String[] columnNames = { "ID","Customer Name", "THE Bill","Room Number"};
    DefaultTableModel modle = new DefaultTableModel(data, columnNames);
    JTable t=new JTable (modle);
    JScrollPane sp=new JScrollPane(t);
    public RoomManagment_bill(){
        view();
        refresh();
        tableClick();
        CheckOut();
        this.setLayout(null);
         this.setSize(1000, 800);
         
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         this.setResizable(false);
         this.setLocationRelativeTo(null);
        // this.setVisible(true);
       
    }//end constractor
    
    private void view(){
        // panel nourth
        JPanel nourth= new JPanel();
         nourth.setBounds(0, 0, 980, 200);
         nourth.setBackground(Color.GRAY);
         nourth.setLayout(null);
         nourth.add(l3);
         back.setBounds(5,5,30,15);
         back.addActionListener(this);
         nourth.add(back);
        //*******************************
        
        // panel west
        JPanel West= new JPanel();
         btn1=new JButton("Check Out");
         btn2=new JButton("Refresh"); 
         West.setLayout(null);
         West.setBounds(5,205,350,540);
         West.setBackground(Color.darkGray);
       
          t1=new JTextField();
         t2=new JTextField();
         l1=new JLabel("Customer Name");
         l2=new JLabel(" Bill  ");
        
         l3.setBounds(300,10, 800, 60);
         l3.setFont(new Font("serif",Font.ITALIC,50));
         l3.setForeground(Color.BLUE);
        
         l1.setBounds(40,40,100,50);
         l1.setForeground(Color.WHITE);
      
         l2.setBounds(40,140,100,50);
         l2.setForeground(Color.WHITE);
         
         t1.setBounds(60, 90, 230, 25);
         
         t2.setBounds(60, 180, 230, 25);
         
         btn1.setBounds(60, 300, 230, 35);
         btn1.setText("Chick Out");
         West.add(l1);
         West.add(l2);
         West.add(t1);
         West.add(t2);
         West.add(btn1);
        //******************************* 
        
        //panel center
        JPanel center = new JPanel();
         center.setBounds(365,205,610,540);
        center.setBorder(BorderFactory.createTitledBorder(""));// to make border areound
        center.setLayout(null);
        sp.setBounds(0,0,610,500);
         
        center.add(sp);
        
        btn2.setBounds(0,500,610,35);
        center.add(btn2);
   
          
         //******************************* 
        
        
        
         
        
        
         this.add(nourth);
         this.add(West);
         this.add(center);
     }
    private void  refresh(){
       btn2. addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               modle.setRowCount(0);
               ArrayList<String> data = new ArrayList<>();
              data = Room_Data_Functions.getAllData();
              String [] values;
              
              for(String line : data){
                  System.out.println(line);
                  System.out.println("counter");
                values = line.split(",");
               if(values[2].equals("null") ||values[3].equals("null") || values[5].equals("....")){
                   continue;
               }else{
               String [] dateIn_split = values[2].split("/");
               String [] dateOut_split = values[3].split("/");
             
               int dateIn = 0;//Integer.parseInt(dateIn_split[1]);
               int dateOut =0;// Integer.parseInt(dateOut_split[1]);
               int days = dateOut -dateIn;
               String [] tableValues = {" ",values[5],Integer.toString(days*20),values[0]};
                modle.addRow(tableValues);
                }
              }
           }
           
       });
    }//end fun
    private void  tableClick(){
         t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = t.getSelectedRow();
                t1.setText(modle.getValueAt(i, 1).toString());
                t2.setText(modle.getValueAt(i, 2).toString());
                 }
            
         });
        
    }//end fun
     private void  CheckOut(){
         btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = t.getSelectedRow();
                
                Customer c = new Customer();
                c.setName(t1.getText());
                Customer_Data_Functions.deletCustomer(c);
                Room tempRoom;
                String  rnumber = modle.getValueAt(i, 3).toString();
                tempRoom =  Room_Data_Functions.findRoom(rnumber);
                tempRoom.setCustomerName("....");
                System.out.println(tempRoom.getNumber());
                Room_Data_Functions.updateRoom(tempRoom);
                
                //conform checkout
                String  infoMessage = "you have been checked out";
                JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                 t1.setText("  ");
                t2.setText("  ");
            
           }
         });
    }//end fun

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            this.setVisible(false);
            RoomManagment_main r = new RoomManagment_main();
            r.setVisible(true);
        }
    }
   
    
}//end class
