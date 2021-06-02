/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.clipper;

import java.util.ArrayList;

/**
 *Function for storing data
 * @author jakubwawak
 */
public class Container {
    
    public ArrayList<Snippet> container_list;
    public int size;
    
    /**
     * Main constructor
     */
    public Container(){
        container_list = new ArrayList<>();
        size = 0;
    }
    
    /**
     * Function for adding data to the container
     * @param data 
     */
    public void add(String data){
        container_list.add(new Snippet(data));
        size = container_list.size();
    }
    
    /**
     * Function for getting object from container
     * @param index
     * @return Snippet
     */
    public Snippet get(int index){
        return container_list.get(index);
    }
    
    /**
     * Function for getting last object from container
     * @return Snippet
     */
    public Snippet get_last(){
        return container_list.get(container_list.size()-1);
    }
    
}
