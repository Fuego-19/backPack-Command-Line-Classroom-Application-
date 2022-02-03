package com.company2;

public class Instructor {
    private String Iname;


    Instructor(String Iname){
        this.Iname = Iname;
    }
    public void gradeAss(int idxOfStu,int idxOfAss,int marksScored){
        Main.getStudents().get(idxOfStu).updateMarks(idxOfAss,marksScored);
        Instructor i1 = new Instructor(this.Iname);
        Main.getStudents().get(idxOfStu).updateGradedBy(idxOfAss,i1);
    }

    public String getIname(){
        return this.Iname;
    }
}
