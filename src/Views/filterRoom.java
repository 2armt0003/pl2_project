
package Views;


import Data_Io.Room_Data_Functions;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTDConstants;

public class filterRoom extends JFrame implements ActionListener{
    //buttom 
    Button back = new Button("Back");
    
    //
    JPanel p1 , p2 , p3;
    JButton btn1 , btn2 ;
    //check variable
    boolean notbesy = false,   nearCheckOut = false;
    String roomType = "  " ;
     ArrayList<String> alldata = new ArrayList<>();
    //table 
     String[][] data = {}; 
     String[] columnNames = { "ID", "state","Near Check","Type"};
    DefaultTableModel modle = new DefaultTableModel(data, columnNames);
    JTable   t=new JTable (modle);
    JScrollPane sp=new JScrollPane(t);
    
    JCheckBox C1 = new JCheckBox("Rooms not busy");
    JCheckBox C2 = new JCheckBox("Near checkout");
    JCheckBox C3 = new JCheckBox("Single");
    JCheckBox C4 = new JCheckBox("Double");
    JLabel l1=new JLabel("Room Type:");
    JLabel l2;
    public filterRoom(){
        view();
        clear();
        search();
        this.setLayout(null);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
        
    }
    public void view(){
      
         p1= new JPanel();
         p2= new JPanel();
         p3= new JPanel();
         btn1=new JButton("Search");
         btn2=new JButton("Clear");
        
        
         p1.setBounds(0, 0, 1000, 100);
         p1.setBackground(Color.GRAY);
         p2.setBounds(0, 100, 400, 700);
         p2.setBackground(Color.darkGray);
         p3.setBounds(400, 100, 600, 700);
         p3.setBackground(Color.LIGHT_GRAY);
         p1.setLayout(null);
         p2.setLayout(null);
         p3.setLayout(null);
         C1.setBounds(50, 50, 250, 30);
         p2.add(C1);
         C2.setBounds(50,150,250,30);
         p2.add(C2);
         l1.setBounds(50, 220, 100, 40);
         l1.setForeground(Color.WHITE);
         p2.add(l1);
         C3.setBounds(120,230,180,25);
         p2.add(C3);
         C4.setBounds(120,250,180,25);
         p2.add(C4);
         l2=new JLabel("Filtering Rooms");
         l2.setBounds(320,10, 800, 60);
         l2.setFont(new Font("serif",Font.ITALIC,50));
         l2.setForeground(Color.BLUE);
         p1.add(l2);
         sp.setBounds(0,0,600,700);
         p3.add(sp);
         btn1.setBounds(50, 380, 290, 50);
         p2.add(btn1);
         btn2.setBounds(50, 480, 290, 50);
         p2.add(btn2);
         
         //back button
         back.setBounds(5,5,30,15);
         back.addActionListener(this);
         p1.add(back);
         
         
         this.add(p1);
         this.add(p2);
         this.add(p3);
     }
   
    private void clear(){
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("in clear");
                C1.setSelected(false);
                C2.setSelected(false);
                C3.setSelected(false);
                C4.setSelected(false);
               
                
            }
            
        
        
        });
        
    }//end fun 
   
    private void search(){
       
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modle.setRowCount(0);
              alldata = Room_Data_Functions.roomsFilter(notbesy, roomType, nearCheckOut);
              for(String line : alldata){
                  String [] valuse = line.split(",");
                  modle.addRow(valuse);
              }
                
            }
              });
        
    }//end fun

    @Override
    public void actionPerformed(ActionEvent e) {
        if(C1.isSelected()){
            notbesy = true;
        }
        if(C2.isSelected()){
          nearCheckOut = true ;  
        }
        if(C3.isSelected()){
            roomType = "single" ;
        }else if(C4.isSelected()){
            roomType = "double";
        }
        if(e.getSource() == back){
            this.setVisible(false);
            RoomManagment_main r = new RoomManagment_main();
            r.setVisible(true);
        }
        
        
    }
}//end class
