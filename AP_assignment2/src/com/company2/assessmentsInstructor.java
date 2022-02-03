package com.company2;

public class assessmentsInstructor implements AssessmentInterface {
    private String assName;                   //name of assignment
    private int maxMarks = 1;                 //maximum marks
    private String quizQ = null;              //Quiz Question

    private boolean deadlineClosed = false;   // This will check if the deadline is closed or open

    private assessmentsStudent studAss;       //Association of assessmentStudent



    assessmentsInstructor(String name, int maxMarks){
        this.maxMarks = maxMarks;
        this.assName = name;
        addStuAss();
    }

    // Method Overloading
    assessmentsInstructor(String quizQ){
        this.quizQ = quizQ;
        addStuAss2();
    }
    
    public void addStuAss(){
        this.studAss = new assessmentsStudent(this.assName, this.maxMarks);
        Main.setStudentAss(this.studAss);                   // Adding the object studentAss in the Arraylist of StudentAss in 'Main' class.
    }
    public void addStuAss2(){
        this.studAss = new assessmentsStudent(this.quizQ);
        Main.setStudentAss(this.studAss);                   // Adding the object studentAss in the Arraylist of StudentAss in 'Main' class.
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

    public void closeDeadline(){ this.deadlineClosed = true; }                      // will close the deadline

    public boolean getDeadlineClosed(){
        return this.deadlineClosed;
    }

    public assessmentsStudent getStudAss(){return this.studAss;}

    public int getMaxMarks(){
        return this.maxMarks;
    }




}
