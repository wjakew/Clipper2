/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.clipper2;

import com.formdev.flatlaf.FlatDarkLaf;
import com.jakubwawak.clipper_gui.main_window;

/**
 *Main object for Clipper2
 * @author jakubwawak
 */
public class Clipper2 {
    
    static final String version = "1.0.0A1";
    static final String build_number = "CLIPPER2-301021REV1";
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        show_header();
        new main_window();
    }
    
    
    static void show_header(){
        String header = "      _ _      ____  \n" +
                        "  ___| (_)_ __|___ \\ \n" +
                        " / __| | | '_ \\ __) |\n" +
                        "| (__| | | |_) / __/ \n" +
                        " \\___|_|_| .__/_____|\n" +
                        "         |_|  ";
        header = header+"by Jakub Wawak "+version;
    }
    
}
