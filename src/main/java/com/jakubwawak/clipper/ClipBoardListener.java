package com.jakubwawak.clipper;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * @author Matthias Hinz
 * changed for gui by Jakub Wawak
 */
public class ClipBoardListener extends Observable implements Runnable {

    Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();

    private volatile boolean running = true;
    
    Container session_container;
    JList list_object;
    DefaultListModel dlm;
    
    /**
     * Main constructor
     */
    public ClipBoardListener(Container container, JList list_object,DefaultListModel dlm){
        session_container = container;
        this.list_object = list_object;
        this.dlm = dlm;
    }

    /**
     * Function for stop running
     */
    public void terminate() {
        running = false;
    }

    /**
     * Main runnable function of thread
     */
    public void run() {
        // the first output will be when a non-empty text is detected
        String recentContent = "";
        // continuously perform read from clipboard
        while (running) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("INTERRUPTEDEXCEPTION: "+e.toString());
            }
            try {
                // request what kind of data-flavor is supported
                List<DataFlavor> flavors = Arrays.asList(sysClip.getAvailableDataFlavors());
                // this implementation only supports string-flavor
                if (flavors.contains(DataFlavor.stringFlavor)) {
                    String data = (String) sysClip.getData(DataFlavor.stringFlavor);
                    if (!data.equals(recentContent)) {
                        recentContent = data;
                        // adding data to container
                        
                        session_container.add(recentContent);
                        dlm.addElement(session_container.get_last().get_glance());
                        
                        list_object.setModel(dlm);

                        setChanged();
                        notifyObservers(data);
                    }
                }
            } catch (HeadlessException e1) {
                System.out.println("HEADLESSEXCEPTION: "+e1.toString());
            } catch (UnsupportedFlavorException e1) {
                System.out.println("UNSUPPORTEDFLAVOREXCEPTION: "+e1.toString());
            } catch (IOException e1) {
                System.out.println("IOEXCEPTION: "+e1.toString());
            }
        }
    }
}