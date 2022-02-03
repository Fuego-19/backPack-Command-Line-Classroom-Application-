package com.company2;
import java.util.*;
import java.util.ArrayList;

public class student {
    private String Sname;
    private static ArrayList<assessmentsStudent> Assignments = new ArrayList<assessmentsStudent>();      // This is a Arraylist of all assignments and it will be created for each object of student.

    student(String Sname){
        this.Sname = Sname;
    }

    public void setAssignments(assessmentsStudent s1){
        Assignments.add(s1);
    }

    public String getSname(){
        return this.Sname;
    }
    public void submitAss(String assfileName, int idxOfAss){
        Assignments.get(idxOfAss).submitAssignment(assfileName);
    }

    public String getSubmission(int idxOfAss){
        return Assignments.get(idxOfAss).getSubmittedFileName();
    }

    public int getMarks(int idxOfAss){
        return Assignments.get(idxOfAss).getMarksScored();
    }

    public void updateMarks(int idxOfAss,int marks){
        Assignments.get(idxOfAss).setMarksScored(marks);
    }
    public void updateGradedBy(int idxOfAss, Instructor I ){
        Assignments.get(idxOfAss).setGradedBy(I);                       // method to set graded by instructor
    }

    public String getGradedBy(int idxOfAss){
        return Assignments.get(idxOfAss).getGradedBy();
    }
    public boolean getGradedFlag(int idxOfAss){
        return Assignments.get(idxOfAss).getGradedFlag();
    }

    public void printAss(int idxOfAss){
        Assignments.get(idxOfAss).view();
    }
    public ArrayList<assessmentsStudent> getAssignments(){
        return this.Assignments;
    }
    public void changeAssignment(ArrayList<assessmentsStudent> temp){
        this.Assignments = temp;
    }
}
