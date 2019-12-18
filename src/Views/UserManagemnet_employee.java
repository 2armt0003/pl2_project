/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Data_Io.Employee_Data_Functions;
import Data_Io.Employee_Data_Functions;
import Users_info.Employee;
import java.awt.Button;
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
public class UserManagemnet_employee extends JFrame{
    Button back = new Button("Back");
    JFrame frame;
    JPanel nourth , p2 , p3;
    JLabel l1 , l2, l3 , l4 , l5 , l6 ,l7;
    JTextField t1 , t2 , t3 , t4;
    JComboBox c1 , c2 ;
    JButton btn1 , btn2 , btn3 , btn4 , btn5;
    //table 
         String[][] data = { }; 
         String[] columnNames = {"Name", "Phone", "Mail","Age", "Address" , "Work Type","ID" };
         DefaultTableModel model = new DefaultTableModel(data , columnNames);
         JTable t=new JTable (model);
         JScrollPane sp=new JScrollPane(t);
        
    public UserManagemnet_employee(){
        view();
        backbutton();
        deleteEmloyee();
        updateEmployee();
        addemployee();
        clearFun();
        tableClick();
        refreshTable();
        this.setLayout(null);
        this.setSize(1000,800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setVisible(true);
    }
    private void view(){
        nourth= new JPanel();
        p2= new JPanel();
        p3= new JPanel();
        //JPanel nourth
        nourth.setBounds(0,0,980,200);
        nourth.setBorder(BorderFactory.createTitledBorder(""));// to make border areound
        nourth.setBackground(Color.darkGray);
        nourth.setLayout(null);
        JLabel title = new JLabel("User Management");
        JLabel title2 = new JLabel("(Employee page)");
        Font f = new Font("serif", Font.BOLD, 50 );
        Font f2 = new Font("serif", Font.BOLD, 30 );
        title.setForeground(Color.WHITE);
        title.setFont(f);
        title.setBounds(300,50,500,70);
        title2.setForeground(Color.WHITE);
        title2.setFont(f2);
        title2.setBounds(410,100,300,70);
        
        back.setBounds(5,5,30,15);
       
        nourth.add(back);
        nourth.add(title);
        nourth.add(title2);
         
         btn1=new JButton("Add");
         btn2=new JButton("Update");
         btn3=new JButton("Delete");
         btn4=new JButton("Clear");
         btn5=new JButton("Refresh");
         t1=new JTextField();
         t2=new JTextField();
         t3=new JTextField();
         t4=new JTextField();
         l1=new JLabel("Name");
         l2=new JLabel("Phone");
         l3=new JLabel("Mail");
         l4=new JLabel("Age");
         l5=new JLabel("Adress");
         l6=new JLabel("Work Type");
         l7=new JLabel("Employee Management");
         String age[]={"20","21" ,"22","23","24","25","26","27","28","29","30"}; 
         c1=new JComboBox(age);
         String type[]={"Room service","In Kitchen" ,"Dray Clean"};
         c2=new JComboBox(type);
         
         
         
        
         p2.setBounds(5,205,350,540);
         p2.setBackground(Color.darkGray);
         sp.setBounds(0,0,610,500);
         
         
         
         p3.setBounds(365,205,610,540);
         p3.setBackground(Color.LIGHT_GRAY);
       
         p2.setLayout(null);
         p3.setLayout(null);
         l7.setBounds(250,10, 800, 60);
         l7.setFont(new Font("serif",Font.ITALIC,50));
         l7.setForeground(Color.BLUE);
        
         l1.setBounds(30,40,100,50);
         l1.setForeground(Color.WHITE);
         p2.add(l1);
         l2.setBounds(30,90,100,50);
         l2.setForeground(Color.WHITE);
         p2.add(l2);
         l3.setBounds(30,140,100,50);
         l3.setForeground(Color.WHITE);
         p2.add(l3);
         l4.setBounds(30,190,100,50);
         l4.setForeground(Color.WHITE);
         p2.add(l4);
         l5.setBounds(30,240,100,50);
         l5.setForeground(Color.WHITE);
         p2.add(l5);
         l6.setBounds(30,290,100,50);
         l6.setForeground(Color.WHITE);
         p2.add(l6);
         t1.setBounds(80, 50, 200, 25);
         p2.add(t1);
         t2.setBounds(80, 100, 200, 25);
         p2.add(t2);
         t3.setBounds(80, 150, 200, 25);
         p2.add(t3);
         c1.setBounds(80, 200, 200, 25);
         p2.add(c1);
         t4.setBounds(80, 250, 200, 25);
         p2.add(t4);
         c2.setBounds(100, 300, 200, 25);
         p2.add(c2);
         btn1.setBounds(10, 400, 90, 25);
         p2.add(btn1);
         btn2.setBounds(110, 400, 90, 25);
         p2.add(btn2);
         btn3.setBounds(210, 400, 90, 25);
         p2.add(btn3);
         btn4.setBounds(10, 500, 300, 35);
         p2.add(btn4);
         btn5.setBounds(0,500,610,35);
         p3.add(btn5);
      
         p3.add(sp);
         this.add(nourth);
         this.add(p2);
         this.add(p3);

     }
     
         private void  tableClick(){
         t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = t.getSelectedRow();
                t1.setText(t.getValueAt(i, 0).toString());
                t2.setText(t.getValueAt(i, 1).toString());
                t3.setText(t.getValueAt(i, 2).toString());
                t4.setText(t.getValueAt(i, 4).toString());
                c1.setSelectedItem(t.getValueAt(i, 3).toString());
                c2.setSelectedItem(t.getValueAt(i, 5).toString());
                 }
            
         });
         
        
    }
            private void clearFun(){
        btn4.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
                t1.setText("  ");
                t2.setText("  ");
                t3.setText("  ");
                t4.setText("  ");
                c1.setSelectedItem(null);
                c2.setSelectedItem(null);
            }
         
        });
        
    }
            
        Employee emp = new Employee();
      private void addemployee(){
       btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               emp.setName(t1.getText().toString());
               emp.setPhone(t2.getText().toString());
               emp.setMail(t3.getText().toString());
               emp.setAddress(t4.getText().toString());
               emp.setAge(c1.getSelectedItem().toString());
               emp.setWork_type(c2.getSelectedItem().toString());
               Employee_Data_Functions.addEmployee(emp);
            }
         
        });
        
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
      
      
  
  
      Employee tempEmp = new Employee();
    private void updateEmployee(){
     
       btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tempEmp.setName(t1.getText().toString());
                tempEmp.setPhone(t2.getText().toString());
                tempEmp.setMail(t3.getText().toString());
                tempEmp.setAddress(t4.getText().toString());
                tempEmp.setAge(c1.getSelectedItem().toString());
                tempEmp.setWork_type(c2.getSelectedItem().toString());
                Employee_Data_Functions.updateEmployee(tempEmp);
            }       
        });
    }
    
    
    private void deleteEmloyee(){
     
       btn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                emp.setName(t1.getText().toString());
                emp.setPhone(t1.getText().toString());
                emp.setMail(t1.getText().toString());
                emp.setAddress(t1.getText().toString());
                emp.setAge(c1.getSelectedItem().toString());
                emp.setWork_type(c1.getSelectedItem().toString());
                Employee_Data_Functions.deletEmployee(emp);
            }       
        });
    }//end class
    private void refreshTable(){
        btn5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model.setRowCount(0);
                ArrayList<String> allDate = new ArrayList<>();
                allDate = Employee_Data_Functions.getAllData();
                for(String line :allDate){
                    String [] values;
                    values = line.split(",");
                    model.addRow(values);
                    
                }
            }
               
        });
    }
}//end class
