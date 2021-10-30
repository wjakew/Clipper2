/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.clipper;

import java.util.Date;

/**
 *Object for storing data from clipboard
 * @author jakubwawak
 */
public class Snippet {
    
    /**
     * Amount of characters in x axis
     */
    static final int X_SIZE = 40;
    
    public String raw_data;
    public Classifier classifier;
    public String note;
    public Date obj_time;
    
    
    /**
     * Constructor
     * @param data 
     */
    public Snippet(String data){
        raw_data = data;
        classifier = new Classifier(this);
        note = "";
        obj_time = new Date();
    }
    
    
    /**
     * Function for getting glance
     * @return String 
     */
    public String get_glance(){
        if (raw_data.length() > X_SIZE-3){
            return raw_data.substring(0, X_SIZE)+"...";
        }
        return raw_data;
    }
    
    /**
     * Function for coping snippet ti clipboard
     * @return String
     */
    public String snippet_clip(){
        String data = "CLIP2-DATA\n";
        
        data = data+raw_data + "\n--------\n";
        data = data+note+"\n";
        data = data+classifier.CLASS_CODE+"\n";
        data = data+obj_time.toString()+"\nEND.";
        
        return data;
    }
}
