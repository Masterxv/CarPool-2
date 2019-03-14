package com.example.ukeje.carpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppDatabase {

    public void testDb() {
          try {
              Connection con = DriverManager.getConnection("jdbc:mysql://192.168.43.19/cab99","ukeje","ukeje");
              //PreparedStatement ps = con.prepareStatement("CREATE DATABASE databasename");
              //int result = ps.executeUpdate();
              System.out.println("Success");

              System.out.println("Creating statement...");
              Statement stmt = con.createStatement();
              String sql;
              sql = "SELECT username FROM passenger";
              ResultSet rs = stmt.executeQuery(sql);

              while(rs.next()){
                  //Retrieve by column name
                  //int id  = rs.getInt("id");
                  //int age = rs.getInt("age");
                  String username = rs.getString("username");
                  //String last = rs.getString("last");

                  //Display values
                  //System.out.print("ID: " + id);
                  //System.out.print(", Age: " + age);
                  //usernameArray.add(username);
                  System.out.println("USERNAME: " + username);
                  //if(usernameArray.contains("ola")){
                  //    System.out.println("True");
                  //}
                  //else{
                  //    System.out.println("False");
                  //}

                  //System.out.println(", Last: " + last);
              }
              //STEP 6: Clean-up environment
              rs.close();
              stmt.close();
              con.close();

          } catch (Exception e) {
              e.printStackTrace();
          }
      }
    }

