/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Io;

import Users_info.Customer;
import Users_info.Room;
import static Data_Io.Customer_Data_Functions.addCustomer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author abanob kamal
 */
public class Room_Data_Functions {
    
     private static Scanner in ;
     public static String tempRoom = "tempRoom.txt";
     public static String Room_Data_File = "RoomData.txt";

    
     public static void addRoom(Room room){
       try{
           //انا هنا باخداسم الملف اللي هيتفتح علشان مره هخزن في الموقت و مره في الاساسي
           FileWriter fw = new FileWriter(Room_Data_File, true );
           BufferedWriter bf = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bf);
           pw.println(
                    room.number +","+
                   room.type +","+
                   room.discription +","+
                   room.services +","+
                   room.customerName );
           pw.flush();
           pw.close();
            
           
       }catch(Exception e){
           
       }
    }//fun end 
     
     
    //هنا الداله دي مره هنستخدمها مع النموذج الاول اني غير حاجه معينه في الغرفه 
    //و برضو هستخمع النموذج التاني اني هعدل سطر معين مع الضيف اللي اضاف علي الغرفه او اللي اتحزف من الغرفه 
    public static void updateRoom(Room room){
       File newfile = new File(tempRoom);
       File oldfile = new File(Room_Data_File);
       
        Room temp_room_obj = new Room();
        String line ;
        String [] values;
       try{
           FileWriter fw = new FileWriter(newfile, true );
           BufferedWriter bf = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bf);
           in = new Scanner(oldfile);
          
           while(in.hasNext()){
                line = in.nextLine();
                values = line.split(",");
           
               if(values[0].equals(room.number)){
                   //هنا الغرفه اللي هتكون جيالي هيكون فيها بينات الغرفه مع الضيف اللي هيضاف  
                   //او بينات الغرفه محذوف منها اسم الضيف اكاني رجعت الغرفه فاضيه تاني 
                  pw.println(
                    room.number +","+
                   room.type +","+
                   room.discription +","+
                   room.services +","+
                   room.customerName );
                }
               else{
                 pw.println(line);
                  
               }
                
               
           }
         pw.close();
           
       }catch(Exception e){
       
       }
       in.close();
       oldfile.delete();
       File f = new File(Room_Data_File);
       newfile.renameTo(f);
   }//fun end 
     
     
    
    public static void deletRoom(Room room ){
       
        File newfile = new File(tempRoom);
       File oldfile = new File(Room_Data_File);
       
         Room temp_room_obj = new Room();
        String line ;
        String [] values;
       try{
           FileWriter fw = new FileWriter(newfile, true );
           BufferedWriter bf = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bf);
           in = new Scanner(oldfile);
          
           while(in.hasNext()){
                line = in.nextLine();
                values = line.split(",");
           
               if(values[0].equals(room.number)){
                }
               else{
                 pw.println(line);
                  
                }
                
               
           }
         pw.close();
           
       }catch(Exception e){
       
       }
       in.close();
       oldfile.delete();
       File f = new File(Room_Data_File);
       newfile.renameTo(f);
   }//end fun 
    
    
    //هنا انا بستخدمها مع اضافه غرفه للضيف  
    public static Room findRoom(String roomNumbr){
       Room room  = new Room();
       boolean found  = false ;
       String line  ;
       String [] values;
       try{
           in = new Scanner(new File(Room_Data_File));
           while(in.hasNext() && !found){
               line  = in.nextLine();
               values = line.split(",");
               if(values[0].equals(roomNumbr)){
                found = true;
                room.number  = values[0] ;
                room.type  = values[1];
                room.discription  = values[2];
                room.services  = values[3];
                room.customerName = values[4];
                return room;
                   
               }
           }
           in.close();
           
           
       }catch(Exception e){
       
       }
     
       return null;
   }//fun end 
     
     
   public static ArrayList roomsFilter(String notbusy, String type, String services){
      ArrayList<String>  records = new ArrayList<String>();
      boolean flag_line = false;//هنا انا عملت فلاج علشان ماضفش نفس السطر كذا مره 
      String line ;
      String [] values;
      try{
          in = new Scanner(Room_Data_File);
          while(in.hasNext()){
              line = in.nextLine();
              values = line.split(",");
              if(notbusy != null){
                  if(values[4].equals("....")){
                      if(flag_line==false){
                         records.add(line);
                      }
                  }
              }
              if(type != null){
                  if(values[1].equals(type)){
                      if(flag_line==false){
                         records.add(line);
                      }
                  }
              }
              if(services != null){
                  if(values[3].equals(services)){
                      if(flag_line==false){
                         records.add(line);
                      }
                  }
              }
              
              
          }
          
      }catch(Exception e){
          
      }
       
       return records;
   }//end of fun
    
}//end of class
