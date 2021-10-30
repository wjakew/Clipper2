/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.clipper;

import org.apache.commons.validator.UrlValidator;

/**
 *Classifier for snippets
 * @author User
 */
public class Classifier {
    
    
    Snippet raw_snippet;
    
    /**
     * CLASS_CODE VALUES:
     * INTERNET_LINK
     * NUMBER
     * EMAIL_ADDRESS
     * CODE 
     * ADDRESS
     * NAME_
     * UNCLASSIFIED
     */
    public String CLASS_CODE;
    public String[] codes;
    
    /**
     * Constructor
     * @param snippet 
     */
    public Classifier(Snippet snippet){
        raw_snippet = snippet;
        CLASS_CODE = "UNCLASSIFIED";
        load_codes();
        classify();
    }
    
    /**
     * Constructor for category window
     */
    public Classifier(){
        load_codes();
    }
            
    /**
     * Function for loading codes
     */
    void load_codes(){
        codes = new String[] {"EMAIL_ADDRESS","NUMBER"};
    }
    
    /**
     * Function for classification
     */
    void classify(){
        if ( validator_EMAIL_ADDRESS() == 1)
            CLASS_CODE = codes[0];
        else if ( validator_NUMBER() == 1){
            CLASS_CODE = codes[1];
        }
        //validator_INTERNET_LINK();
    }
    
    /**
     * Function for validation email address
     * @return Integer
     */
    int validator_EMAIL_ADDRESS(){
        String data = raw_snippet.raw_data;
        if (data.contains("@") && data.contains("."))
            return 1;
        return 0;
    }
    
    /**
     * Function for validation phone number
     * @param snippet
     * @return Integer
     */
    int validator_NUMBER(){
        String data = raw_snippet.raw_data;
        int data_len = data.length();
        if ( data.length() < 14 ){
            for(Character c : data.toCharArray()){
                try {
                    Integer.parseInt(c.toString());
                    data_len--;
                }catch(NumberFormatException e){}
            }
            
            if ( data_len == 0 )
                return 1;
        }
        return 0;
    }
    
    /**
     * Function for validating internet link
     * @return Integer
     */
    int validator_INTERNET_LINK(){
        UrlValidator URLValidator = new UrlValidator();
        
        if ( URLValidator.isValid(raw_snippet.raw_data) ){
            CLASS_CODE = "";
            return 1;
        }
        return 0;
    }
    
    
    
}
