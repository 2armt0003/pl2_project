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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                    room.getNumber() +","+
                   room.getType() +","+
                   room.getDateIn() +","+
                   room.getDateOut()+","+
                   room.getServices() +","+
                   room.getCustomerName() +","+
                    room.getId());
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
       PrintWriter pw  = null;
      
        String line ;
        String [] values;
       try{
           FileWriter fw = new FileWriter(newfile, true );
           BufferedWriter bf = new BufferedWriter(fw);
           pw = new PrintWriter(bf);
           in = new Scanner(oldfile);
          
           while(in.hasNext()){
                line = in.nextLine();
                values = line.split(",");
           
               if(values[0].equals(room.getNumber())){
                   //هنا الغرفه اللي هتكون جيالي هيكون فيها بينات الغرفه مع الضيف اللي هيضاف  
                   //او بينات الغرفه محذوف منها اسم الضيف اكاني رجعت الغرفه فاضيه تاني 
                  pw.println(
                    room.getNumber() +","+
                   room.getType() +","+
                   room.getDateIn() +","+
                   room.getDateOut()+","+
                   room.getServices() +","+
                   room.getCustomerName()+","+
                    room.getId() );
                }
               else{
                 pw.println(line);
               }
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }finally{
         try{
         pw.flush();
         pw.close();
         in.close();
         oldfile.delete();
         File f = new File(Room_Data_File);
         newfile.renameTo(f);
         System.out.println("he end room update fun ");
         }catch(Exception e){System.out.println(e.getMessage());}
       }
         
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
           
               if(values[0].equals(room.getNumber())){
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
            FileReader f = new FileReader(Room_Data_File);
           in = new Scanner(f);
           while(in.hasNext() && !found){
               line  = in.nextLine();
               values = line.split(",");
               if(values[0].equals(roomNumbr)){
                found = true;
                room.setNumber( values[0]); 
                room.setType(values[1]); 
                room.setDateIn(values[2]);
                room.setDateOut(values[3]);
                room.setServices(values[4]);
                room.setCustomerName(values[5]);
                room.setId(values[6]);
                
                   
               }
           }
           f.close();
           in.close();
           return room;
           
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
   public static ArrayList getAllData(){
       ArrayList<String> allData = new ArrayList<>();
       String line;
       try{
           File f =  new File(Room_Data_File);
           in = new Scanner(f);
           while(in.hasNext()){
               line   = in.nextLine();
               allData.add(line);
           }
          
           in.close();
       }catch(IOException e){
           System.out.println(e.getMessage());
           
       }
       
       return allData;
   }//end fun
   
    
}//end of class
