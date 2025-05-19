package com.example.library_managment_system;

import java.util.*;
import java.sql.*;

public class Connectivty {

    public static Connection con;

    public  static void init() throws Exception{
        String url = "jdbc:mysql://localhost:3306/library_managment_system";
        String username = "root";
        String password = "root";


            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");

    }
        static{
            try{
                init();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    public static int addBook(int bookId, String title, String author, double price) throws Exception {
       String query="insert into book(id,title, author, price) values("+bookId+",'"+title+"','"+author+"',"+price+")";
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows= st.executeUpdate(query);
            return rows;
        }finally {
            if(st!=null){
                st.close();
            }
        }

    }
    public static int updateBook(int bookId, String title, String author, int price) throws SQLException {
        String query = "UPDATE book SET title = '" + title + "', author = '" + author + "', price = " + price + " WHERE id = " + bookId;

        System.out.println(query);
        Statement st=null;

        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;

        }finally {
            if(st!=null){
                st.close();
            }
        }
    }

    public static int deleteBook(int bookId) throws SQLException {
        String query = "DELETE FROM book WHERE id = " + bookId;

        System.out.println(query);
        Statement st=null;

        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;

        }finally {
            if(st!=null){
                st.close();
            }
        }
    }

    //____________________________________________________
    public static void createRecord() throws Exception {
        init();
        Scanner ob=new Scanner(System.in);

        System.out.println("Enter the Book Id :");
        int BI=ob.nextInt();
        System.out.println("Enter the Title :");
        String title=ob.next();
        System.out.println("Enter the Author Name :");
        String author=ob.next();
        System.out.println("Enter Price :");
        int price=ob.nextInt();

        try{
            int row=Connectivty.addBook(BI,title, author,price);
            if(row>=1){
                System.out.println("The Record has been Added");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void readRecord() throws Exception{

        try {
            // 3. Create SQL query
            String sql = "SELECT* FROM book";

            //4. Create Statement and Execute Query
            String url = "jdbc:mysql://localhost:3306/library_managment_system";
            String username = "root";
            String password = "root";


            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 5. Loop through the result
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");

                System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Price: " + price);
            }

            // 6. Close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateBook() throws Exception {
        init();

        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the Update Id");
        int UI=ob.nextInt();
        System.out.println("Enter the Update Title");
        String title=ob.next();
        System.out.println("Enter the Author Update Name :");
        String author=ob.next();
        System.out.println("Enter the Update Price :");
        int price=ob.nextInt();

        try{
            int row=Connectivty.updateBook(UI,title,author,price);
            if(row>=1){
                System.out.println("Record Update Successfully :");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteBook()throws Exception {
        init();
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter your Book Id");
        int id=ob.nextInt();

        try{
            int row=Connectivty.deleteBook(id);
            if(row>=1){
                System.out.println("Record Delete Successfully");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //__________________Main Method___________________
    public static void main(String[] args) throws Exception {

        Scanner ob=new Scanner(System.in);

        System.out.println("1. Create Book \n2. Read Record \n3. Update Book \n4. Delete Book\n Enter Selection :");
        int sel=ob.nextInt();
        if(sel==1){
            createRecord();
        }
        if(sel==2){
        readRecord();
        }
        if(sel==3){
            updateBook();
        }
        if(sel==4){
            deleteBook();
        }

    }




}
