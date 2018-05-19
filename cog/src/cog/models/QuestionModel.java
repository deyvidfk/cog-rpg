/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cog.models;

import java.util.List;

/**
 *
 * @author deyvid.fasouza
 */
public class QuestionModel {
    String narrative;

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getResolutionId() {
        return resolutionId;
    }

    public void setResolutionId(int resolutionId) {
        this.resolutionId = resolutionId;
    }

    public List<ResolutionModel> getResolutionOption() {
        return resolutionOption;
    }

    public void setResolutionOption(List<ResolutionModel> resolutionOption) {
        this.resolutionOption = resolutionOption;
    }
    private  int id; 
    private String text;
    private int resolutionId;    
    private List<ResolutionModel> resolutionOption;
}
