package com.example.feedback;

import java.util.ArrayList;

public class Mark {

    private ArrayList<Criteria> criteriaList = new ArrayList<Criteria>();
    private ArrayList<Double> markList = new ArrayList<Double>();
    private String comment;

    public String getComment() {

        return comment;
    
    }

    public void setComment(String comment) {

        this.comment = comment;

    }

    public void setCriteriaList(ArrayList<Criteria> criteriaList) {

        this.criteriaList = criteriaList;

    }

    public void setMarkList(ArrayList<Double> markList) {

        this.markList = markList;

    }

    public ArrayList<Criteria> getCriteriaList() {

        return criteriaList;

    }

    public ArrayList<Double> getMarkList() {

        return markList;

    }
}
