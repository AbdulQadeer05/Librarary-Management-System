import com.sun.nio.sctp.SctpSocketOption;
import java.util.*;
import java.util.Scanner.*;
public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssue;


    public void setBookId(int bookId){
        this.bookId=bookId;
    }
    public int getBookId(){
        return bookId;
    }

    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }

    public void setAuthor(String author){
        this.author=author;
    }
    public String getAuthor(){
        return author;
    }

    public void setIsIssue(boolean isIssue){
        this.isIssue=isIssue;
    }
    public boolean getIsIssue(){
        return isIssue;
    }






     Book(int bookId, String title, String author){

        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.isIssue=true;
    }

    public void issueBook(){
        if(isIssue){
            System.out.print("Book Issued"+ bookId + title);
        }else{
            System.out.print("Book Not Issued"+ bookId + title);
        }
    }

    public void returnBook(){
        if(isIssue){
            System.out.print("Book Return");
        }
        else{
            System.out.println("Book Is Not Return");
        }
    }

    public void displayInfo(){
        System.out.println("Book Id "+bookId +"Book Title "+title +"Author "+author);
    }



    Book b=new Book(14,"Java Book"," Sir Bilal");

//    Scanner ob=new Scanner(System.in);
//
//    System.out.println("1. Issue Book \n2. Return Book \n3. Display info \n Enter Selection :");
//
//    int sel=ob.nextInt();
//
//    if(sel==1){
//        b.issueBook();
//    }
//    if(sel==2){
//        b.returnBook();
//    }
//    if(sel==3){
//        b.displayInfo();
//    }



}
