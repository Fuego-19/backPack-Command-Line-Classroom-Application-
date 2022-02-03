package com.company2;


import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class Main {

    private static ArrayList<slides> slidesList = new ArrayList<slides>();                     //all slides object will be stored here.
    private static ArrayList<lectureVideos> lectureVideosList = new ArrayList<lectureVideos>();       // all lecture videos objects will be stored here.
    private static ArrayList<Instructor> Instructors = new ArrayList<Instructor>();       // all instructors data will be stored here.
    private static ArrayList<student> Students = new ArrayList<student>();                              // all students data will be stored here.
    private static ArrayList<assessmentsInstructor> instructorAss = new ArrayList<assessmentsInstructor>();         //All assessments added by instructor
    private static ArrayList<assessmentsStudent> studentAss = new ArrayList<assessmentsStudent>();                  //All assessments with methods that a student should access.
    private static ArrayList<comment> commentsList = new ArrayList<comment>();

    private static int userId;
    private static int choiceIorS;
    static Scanner scn = new Scanner(System.in);


    private static void instructors() {
        System.out.println("Instructors: ");
        for (int i = 0; i < Instructors.size(); i++) {
            System.out.println(i + " - " + Instructors.get(i).getIname());
        }
    }

    private static void students() {
        System.out.println("Students: ");
        for (int i = 0; i < Students.size(); i++) {
            System.out.println(i + " - " + Students.get(i).getSname());
        }
    }

    private static void instMenu() {
        System.out.println("INSTRUCTOR MENU\n" + "1. Add class material\n" + "2. Add assessments\n" + "3. View lecture materials\n" + "4. View assessments\n" + "5. Grade assessments\n" + "6. Close assessment\n" + "7. View comments\n" + "8. Add comments\n" + "9. Logout\n");
    }

    private static void stuMenu() {
        System.out.println("STUDENT MENU\n" + "1. View lecture materials\n" + "2. View assessments\n" + "3. Submit assessment\n" + "4. View grades\n" + "5. View comments\n" + "6. Add comments\n" + "7. Logout\n");
    }

    static java.util.Date getDate() {
        java.util.Date date = new java.util.Date();
        return date;
    }

    static void setStudentAss(assessmentsStudent ass) {
        studentAss.add(ass);
    }

    static ArrayList<assessmentsStudent> getStudentAss() {
        return studentAss;
    }

    static ArrayList<student> getStudents() {
        return Students;
    }

    static ArrayList<Instructor> getInstructors() {
        return Instructors;
    }

    public static void main(String[] args) throws IOException {
        student S0 = new student("S0");         //Adding required students
        student S1 = new student("S1");
        student S2 = new student("S2");
        Students.add(S0);
        Students.add(S1);
        Students.add(S2);

        Instructor I0 = new Instructor("I0");           // Adding required Instructors
        Instructor I1 = new Instructor("I1");
        Instructors.add(I0);
        Instructors.add(I1);
        while (true) {
            System.out.println("Welcome to Backpack\n" + "1. Enter as instructor\n" + "2. Enter as student\n" + "3. Exit");

            choiceIorS= scn.nextInt();

            if(choiceIorS == 1) {
                instructors();
                System.out.print("Choose id: ");
                userId = scn.nextInt();
                while (true) {
                    System.out.println("Welcome " + Instructors.get(userId).getIname());
                    instMenu();
                    int chs = scn.nextInt();
                    if(chs==1) {addClassMaterial(); }
                    else if(chs==2) {addAssessments();}
                    else if(chs==3) {viewLectureMaterials();}
                    else if(chs==4) {viewAssessments();}
                    else if(chs==5){ gradeAssessments();}
                    else if(chs==6){ closeAssessments();}
                    else if(chs==7){ viewComments();}
                    else if(chs==8){ AddComments();}
                    else{ break; }
                }
            }
            else if(choiceIorS == 2) {
                students();
                System.out.print("Choose id: ");
                userId = scn.nextInt();
                while (true) {
                    System.out.println("Welcome " + Students.get(userId).getSname());
                    stuMenu();
                    int chs = scn.nextInt();

                    if(chs==1){
                        viewLectureMaterials();
                    }
                    else if(chs==2){
                        viewAssessments();
                    }
                    else if(chs==3){
                        submitAssessments();
                    }
                    else if(chs==4){
                        viewGrades();
                    }
                    else if(chs==5){
                        viewComments();
                    }
                    else if(chs==6){
                        AddComments();
                    }
                    else{break;}
                }
            }
            else {
                break;
            }
        }

    }


    // -------- Student FUNCTIONS ---------

    private static void submitAssessments(){

        boolean flag = true;
        System.out.println("Pending assessments ");
        for(int i =0; i<Students.get(userId).getAssignments().size(); i++){
            if(Students.get(userId).getAssignments().get(i).getSubmittedFileName() == null){
                System.out.print("ID: " + i + " ");
                Students.get(userId).getAssignments().get(i).view();
                flag = false;
            }
        }


        if(flag){
            System.out.println("No Pending assignments for now.");
            return;
        }
        System.out.print("Enter ID of assessment: ");
        int aid = scn.nextInt();
        System.out.println("Enter filename of assignment: ");
        String fileName = scn.next();
        if(!(fileName.substring(fileName.length() - 4).equals(".zip"))){
            System.out.println("Invalid extension of file.");
            return;
        }
        Students.get(userId).submitAss(fileName,aid);               //Assignment submitted

    }
    private static void viewGrades(){
        System.out.println("Graded Submissions: ");
        for(int i =0;i<Students.get(userId).getAssignments().size();i++){
            if(Students.get(userId).getMarks(i) != -1){
                System.out.println("Submssion: " + Students.get(userId).getSubmission(i));
                System.out.println("Marks Scored: " + Students.get(userId).getMarks(i));
                System.out.println("Graded By: " + Students.get(userId).getGradedBy(i));
            }
        }

    }

    // ----- Instructor FUNCTIONS -------

    private static void addClassMaterial() throws IOException {
        System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");
        int inp = scn.nextInt();
        if (inp == 1) {
            System.out.print("Enter topic of slides: ");
            scn.nextLine();
            String topic = scn.nextLine();
            System.out.print("Enter number of slides: ");
            int num = scn.nextInt();
            slides sld = new slides(topic, num, userId);
            slidesList.add(sld);
        }
        else {
            System.out.println("Enter topic of video: ");
            scn.nextLine();
            String topic = scn.nextLine();
            System.out.print("\nEnter filename of video: ");
            String fileName = scn.next();
            if (!(fileName.substring(fileName.length() - 4).equals(".mp4"))) {
                System.out.println("Invalid file extension");
                return;
            }
            lectureVideos lect = new lectureVideos(topic, fileName, userId);
            lectureVideosList.add(lect);
        }
    }



    private static void addAssessments()  {

        System.out.println("1. Add Assignment\n" + "2. Add Quiz\n");
        int chs = scn.nextInt();
        if (chs == 1) {
            System.out.print("Enter problem statement: ");
            scn.nextLine();
            String NameOfAss = scn.nextLine();
            System.out.print("Enter max marks: ");
            int maxMarks = scn.nextInt();
            assessmentsInstructor ass = new assessmentsInstructor(NameOfAss, maxMarks);
            instructorAss.add(ass);

            assessmentsStudent s1 = studentAss.get(studentAss.size() - 1);

            for (int s = 0; s < Students.size(); s++) {
                Students.get(s).getAssignments().add(s1);
            }

        }
        else {
            System.out.print("Enter quiz question: ");
            scn.nextLine();
            String question = scn.nextLine();
            assessmentsInstructor quiz = new assessmentsInstructor(question);
            instructorAss.add(quiz);

            assessmentsStudent s1 = studentAss.get(studentAss.size() - 1);
            for (int s = 0; s < Students.size(); s++) {
                Students.get(s).getAssignments().add(s1);
           }

        }
    }


    private static void gradeAssessments() {
        System.out.println("List of assessments");
        viewAssessments();
        System.out.print("Enter ID of assessment to view submissions: ");
        int id = scn.nextInt();
        boolean flag = true;
        for(int i =0; i< Students.size(); i++){
            if(Students.get(i).getSubmission(id) != null && !(Students.get(i).getGradedFlag(id))){
                System.out.println( i + ". " + Students.get(i).getSname());
                flag = false;
            }
        }
        if(flag){
            System.out.println("No submissions made for this assessment");
            return;
        }
        System.out.println("Choose ID from these ungraded submissions");
        int sid = scn.nextInt();
        System.out.println("Submission: ");
        System.out.println("Submission: " + Students.get(sid).getSubmission(id));
        System.out.println("-------------------------------");
        System.out.println("Max Marks: " + instructorAss.get(id).getMaxMarks());
        System.out.print("Marks Scored: ");
        int marksScored = scn.nextInt();
        Instructors.get(userId).gradeAss(sid,id,marksScored);                       //Assignment graded

    }

    private static void closeAssessments() {
        System.out.println("List of Open Assignments: ");
        boolean flag = true;
        for(int i =0; i< instructorAss.size(); i++){
            if(!(instructorAss.get(i).getDeadlineClosed())){
                System.out.print("ID: " + i);
                instructorAss.get(i).view();
                flag = false;
            }
        }
        if(flag){
            System.out.println("There is no open assignment for now. ");
            return;
        }
        System.out.print("Enter id of assignment to close:");
        int aid = scn.nextInt();
        instructorAss.get(aid).closeDeadline();
    }



    // ------- Common FUNCTIONS --------
    private static void viewLectureMaterials() {

        for (int i = 0; i < slidesList.size(); i++) {
            slidesList.get(i).view();
        }
        for (int j = 0; j < lectureVideosList.size(); j++) {
            lectureVideosList.get(j).view();
        }
    }
    private static void viewAssessments() {
        for (int i = 0; i < instructorAss.size(); i++) {
            if (!(instructorAss.get(i).getDeadlineClosed())) {
                System.out.print("ID: " + i);
                instructorAss.get(i).view();
            }
        }
    }
    private static void viewComments() {
        for(int i =0; i< commentsList.size(); i++){
            commentsList.get(i).printComment();
        }
    }

    private static void AddComments() {
        System.out.print("Enter Comment: ");
        scn.nextLine();
        String comt = scn.nextLine();

        if(choiceIorS == 1) {
            comment c1 = new comment(comt, Instructors.get(userId));
            commentsList.add(c1);
        }
        else{
            comment c1 = new comment(comt,Students.get(userId));
            commentsList.add(c1);
        }
    }

}
