package com.company2;

import java.io.IOException;

public class slides implements lectureMaterial{
    private int slidesNum;              //Number of slides
    private String topic;
    private String[] content;
    private Instructor inst;

    slides(String topic, int num,int userId) throws IOException {
        this.topic = topic;
        this.slidesNum = num;;
        this.content = new String[num];
        this.inst = Main.getInstructors().get(userId);
        setContent();
    }
    public void setContent()  {
        for(int i =1; i<=this.slidesNum; i++){
            System.out.print("Content of slide " + i + ": ");
            Main.scn.nextLine();
            String temp = Main.scn.nextLine();
            this.content[i-1] = temp;
        }
    }

    @Override
    public void view(){
        System.out.println("Title: " + this.topic);

        for(int i =1; i<this.slidesNum; i++){
            System.out.println("Slide " + i + ": " + this.content[i-1]);
        }
        System.out.println("Number of slides: " + this.slidesNum);
        System.out.println("Date of upload: " + Main.getDate());
        System.out.println("Uploaded by: " + this.inst.getIname() + "\n");
    }


}
