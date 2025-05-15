package com.example.library_managment_system;
import java.util.*;
import java.util.Scanner.*;

public class Student extends User{

    private String studentClass;

    public Student( int userId, String userName, String studentClass ){
        super(userId, userName);

        this.studentClass=studentClass;
    }

}
