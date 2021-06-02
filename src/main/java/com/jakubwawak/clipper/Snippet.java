/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.clipper;

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
    
    
    /**
     * Constructor
     * @param data 
     */
    public Snippet(String data){
        raw_data = data;
        classifier = new Classifier(this);
        note = "";
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
    
}
