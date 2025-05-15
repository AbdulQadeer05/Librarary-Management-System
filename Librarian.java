package com.example.library_managment_system;

import java.util.*;


public class Librarian extends User {


    public Librarian(int userId, String userName) {
        super(userId, userName);
    }

    Scanner ob=new Scanner(System.in);

    public void addBook(){

        System.out.println("How Many Books should i add");
        int add=ob.nextInt();

        if(add==0){
            System.out.println("Dont Add Book");
        }else{
            System.out.println("Add Book Successfully");
        }
    }

    public void removeBook(){

        System.out.println("How Many Books should i remove");
        int remove=ob.nextInt();

        if(remove==0){
            System.out.println("Dont Remove Book");
        }else{
            System.out.println("Remove Book Successfully");
        }
    }

    public void issueBookToUser(){
        System.out.println("How Many books should  issued ton user ? ");
        int issue=ob.nextInt();

        if(issue==0){
            System.out.println("Don't Issue Books");
        }
        else{
            System.out.println(" Done");
        }
    }

    public void returnBookFromUser(){
        System.out.println("How Many Return Books From User ?");
        int ret=ob.nextInt();

        if(ret==0){
            System.out.println("Don't Return Books");
        }
        else{
            System.out.println("Return Done");
        }

    }

    public static void main(String arg[]){

        Librarian l=new Librarian(0,"Qadeer");
        Scanner sc=new Scanner(System.in);

        System.out.println("1.Add Book \n2. Remove Book \n3. Issue Book to User \n4. Return Book Form User \nEnter Selcetion ? ");
        int b=sc.nextInt();
        if(b==1){
            l.addBook();
        }
        if(b==2){
            l.removeBook();
        }
        if(b==3){
            l.issueBookToUser();
        }
        if(b==4){
            l.returnBookFromUser();
        }

    }
}
