package com.company2;

public class assessmentsStudent implements AssessmentInterface {
    private String assName;                    //name of assignment
    private int maxMarks = 1;                 //maximum marks
    private String quizQ = null;              //Quiz Question



   /* These variables will only be used by the object of student class */
    private String submittedFileName = null;         //Submitted file
    private int marksScored = -1;
    private Instructor gradedBy;
    private boolean gradedFlag = false;             //Flag to check if the assignment is graded or not.
    /*   ---------   */


    assessmentsStudent(String name, int maxMarks){
        this.maxMarks = maxMarks;
        this.assName = name;
    }

    // Method Overloading
    assessmentsStudent(String quizQ){
        this.quizQ = quizQ;
    }

    @Override
    public void view(){
        if(quizQ == null){
            viewS();
        }
        else{
            viewQ();
        }
    }
    public void viewS(){
        System.out.println(" Assignment: " + this.assName + " Max Marks: " + this.maxMarks + "\n----------------");
    }
    public void viewQ(){
        System.out.println(" Question: " + this.quizQ + "\n----------------");
    }

    public String getAssName(){
        return this.assName;
    }
    public void submitAssignment(String ass){
        this.submittedFileName = ass;
    }
    public String getSubmittedFileName(){
        return this.submittedFileName;
    }
    public int getMarksScored(){
        return this.marksScored;
    }

    public void setMarksScored(int marks){
        this.marksScored = marks;
        this.gradedFlag = true;
    }

    public void setGradedBy(Instructor I){
        this.gradedBy = I;
    }
    public String getGradedBy(){
        return gradedBy.getIname();
    }
    public boolean getGradedFlag(){
        return this.gradedFlag;
    }
}