package com.company2;


public class comment{
    private String comment;
    private java.util.Date time;
    private student stu;
    private Instructor ins;


    comment(String comment, student stu){
        this.comment = comment;
        this.stu = stu;
        this.time = Main.getDate();
    }

    //Method Overloading

    comment(String comment, Instructor ins){
        this.comment = comment;
        this.ins = ins;
        this.time = Main.getDate();
    }


    public void printComment(){
        if(stu == null){
            System.out.println(this.comment + "-" + ins.getIname());
            System.out.println(time);
        }
        else{
            System.out.println(this.comment + "-" + stu.getSname());
            System.out.println(time);
        }


    }
}

