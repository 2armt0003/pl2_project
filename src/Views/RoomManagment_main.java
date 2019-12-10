/*`k
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Data_Io.Room_Data_Functions;
import Users_info.Room;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abanob kamal
 */
public class RoomManagment_main extends JFrame{

   
    
    //jlabales
    JLabel number = new JLabel("Nunber");
    JLabel Customer_name = new JLabel("Customer Name");
    JLabel type = new JLabel("Type");
    JLabel service = new JLabel("Service");
    JLabel data_in = new JLabel("Data In");
    JLabel data_out = new JLabel("Data Out");
    
    //jtext fields
    JTextField number_TF = new JTextField();
    JTextField Customer_name_TF = new JTextField();
    
    //spinner
    String [] types = {"single", "double"};
    SpinnerListModel sl1 = new SpinnerListModel(types);
    JSpinner type_list = new JSpinner(sl1);
    
    String [] services = {"Hous keeping", "Room service ", "Dry clean"};
    SpinnerListModel sl2 = new SpinnerListModel(services);
    JSpinner services_list = new JSpinner(sl2);
    
    //data 
    datechooser.beans.DateChooserCombo Date_in = new datechooser.beans.DateChooserCombo();
    datechooser.beans.DateChooserCombo Date_out = new datechooser.beans.DateChooserCombo();
    SimpleDateFormat DateFormat = new SimpleDateFormat("ddd/MMM/YYY");
    
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
        
    public RoomManagment_main() throws HeadlessException {
        view();
        tableClick();
        clearFun();
        updataRoom();
        refreshTable();
         
        this.setLayout(null);
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);//make program in the center of screen
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
       
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
        Font f = new Font("serif", Font.BOLD, 50 );
        title.setForeground(Color.WHITE);
        title.setFont(f);
        title.setBounds(300,50,500,70);
        nourth.add(title);
        
        //Jpanel west
        West.setBounds(5,205,350,540);
        West.setBorder(BorderFactory.createTitledBorder(""));// to make border areound
        West.setLayout(null);
        West.setBackground(Color.LIGHT_GRAY);
        
        number.setBounds(10,10,130,25);
         number_TF.setBounds(140,10,130,25);
        Customer_name.setBounds(10,50,130,25);
         Customer_name_TF.setBounds(140,50,130,25);
        type.setBounds(10,90,130,25);
         type_list.setBounds(140,90,130,25);
        service.setBounds(10,130,130,25);
         services_list.setBounds(140,130,130,25);
        Date_in.setBounds(10,170,130,25);
        Date_out.setBounds(10,210,130,25);
        update.setBounds(10,250,270,25);
        clear.setBounds(10,280,270,25);
        West.add(number);
         West.add(number_TF);
        West.add(Customer_name);
         West.add(Customer_name_TF);
        West.add(type);
         West.add(type_list);
        West.add(service);
        West.add(services_list);
        West.add(Date_in);
        West.add(Date_out);
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
    private void  tableClick(){
         table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                number_TF.setText(modle.getValueAt(i, 0).toString());
                Customer_name_TF.setText(modle.getValueAt(i, 5).toString());
                 }
            
         });
        
    }//end fun
    Room tempRoom = new Room();
    private void updataRoom(){
     
        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                
                tempRoom.setNumber(number_TF.getText().toString());
                tempRoom.setCustomerName(Customer_name_TF.getText().toString());
                tempRoom.setType(type_list.getValue().toString());
                tempRoom.setServices(services_list.getValue().toString());
                tempRoom.setDateIn(Date_in.getText().toString());
                tempRoom.setDateOut(Date_out.getText().toString());
                Room_Data_Functions.updateRoom(tempRoom);
            }       
        });
    }//end fun
    
    
    private void clearFun(){
        clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                number_TF.setText("  ");
                Customer_name_TF.setText("  ");
            }
         
        });
        
    }//end fun
    private void refreshTable(){
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
