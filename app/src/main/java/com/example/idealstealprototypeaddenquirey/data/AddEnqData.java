package com.example.idealstealprototypeaddenquirey.data;

import java.io.Serializable;
import java.util.ArrayList;

public class AddEnqData implements Serializable   {

    private String GradeText;
private ArrayList<Measuredata> list;
    public AddEnqData( ) {

    }

    public AddEnqData(String gradeText, ArrayList<Measuredata> list) {
        GradeText = gradeText;
        this.list = list;
    }

    public ArrayList<Measuredata> getList() {
        return list;
    }

    public void setList(ArrayList<Measuredata> list) {
        this.list = list;
    }

    public String getGradeText() {
        return GradeText;
    }

    public void setGradeText(String gradeText) {
        GradeText = gradeText;
    }
}
