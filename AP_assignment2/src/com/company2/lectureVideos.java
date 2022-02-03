package com.company2;

public class lectureVideos implements lectureMaterial {
    private String topic;
    private String fileName;
    private Instructor inst;

    lectureVideos(String topic, String fileName, int userId){
        this.fileName = fileName;
        this.topic = topic;
        this.inst = Main.getInstructors().get(userId);
    }
    @Override
    public void view(){
        System.out.println("Title of Video: " + this.topic);
        System.out.println("Video file: " + this.fileName);
        System.out.println("Date of upload: " + Main.getDate());
        System.out.println("Uploaded by: " + this.inst.getIname() + "\n");
    }

}
