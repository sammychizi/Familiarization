/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package getfamiliar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;


/**
 *
 * @author Samantha
 */
public class GetFamiliar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Code that connects the java program to the database
        String url = "jdbc:mysql://localhost:3306/bighitvideo";
        String username = "root";
        String password = "";
       
     try{
        Connection connection = DriverManager.getConnection(url, username, password);
        
        System.out.println("Connected to database");
        
        /*create a method that fetches customer accounts 
        and returns the response in an array*/
        
       //Gets customer account from database
       Statement text = connection.createStatement();
       ResultSet result = text.executeQuery("Select accountId, firstName, lastName from customer");
        
       //Create ArrayList t store records
       ArrayList<String> account = new ArrayList<String>();
       
       //Add records
       if(result.next()){
           while(result.next()){
               String record = result.getString("accountId") + ": " + result.getString("firstName") + " " + result.getString("lastName") + " \n";
               
               account.add(record);
           }
       }
       else{
           System.out.println("Records not found");
       }
       connection.close();
       
       System.out.println("Accounts: \n" + account);
       
     }
     
     
     catch ( SQLException e){
        System.out.println("Oops, error!");
        e.printStackTrace();
     }
     
     //Method that gets accounts and videos rented
     try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =  DriverManager.getConnection(url, username, password);
        
            Statement text = connection.createStatement();
            ResultSet result = text.executeQuery("select accountId, videoId from previousrental order by accountId");
            
            System.out.println("The customer accouts and videos rented");
            while(result.next()){
                System.out.println("Customer Account: " + result.getString("accountId") + ", rented videos, videoId:  " + result.getString("videoId") );
            }
            
        }
        catch (Exception e) {

            System.out.println(e);

        }
   }
    
    
   /*//Method to return customer accounts and list of videos rented
    static void videoList(){
        
       
    }*/
    
}

