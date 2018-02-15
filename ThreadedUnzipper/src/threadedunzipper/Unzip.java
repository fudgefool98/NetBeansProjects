/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedunzipper;

import java.io.File;
import java.io.FilenameFilter;
import javafx.application.Platform;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
/**
 *
 * @author Professor Wergeles
 */
public class Unzip extends Thread {
    private File sourceDirectory;
    private File destinationDirectory;
    private File[] files;   
    public Boolean stop = false;
    
    public Unzip(File sourceDirectory, File destinationDirectory) {
        this.sourceDirectory = sourceDirectory;
        this.destinationDirectory = destinationDirectory;
        
        
    }
    
    public int getNumFiles() {
        if (files == null) {
            return 0;
        }
        return files.length;
    }
    
    public File[] getFiles() {
        return this.files;
    }
    
    @Override
    public void run() {
        String destinationDirectoryPath = destinationDirectory.getPath();
        int numComplete = 0;
        System.out.println("Threads1: " + Thread.activeCount()); 
        for (File file : files) {
            if (stop) { 
                doNotify(calculatePercent(numComplete, files.length), UnzipState.INTERRUPTED, "Unzip operation interrupted.");
                break;
            }

            doNotify(calculatePercent(numComplete, files.length), UnzipState.RUNNING, "Extracting " + file.getPath() + " to " + destinationDirectoryPath);

            
        }
        doNotify(calculatePercent(numComplete, files.length), UnzipState.ENDED, "Unzip ended.");
    }
    
    public void end() {
        stop = true;
    }
    
    private double calculatePercent(int count, int total) {
        if (total == 0) return 0;
        return (double)count / (double)total;
    }
    
    public void setOnNotification(Notification notification){
        this.notification = notification;
    }
    
    private void doNotify(double percentComplete, UnzipState state, String message) {
        if(notification!= null){
            Platform.runLater(()->{
                notification.handle(percentComplete,state,message);
            });
        }
        
    }
    
    
    
}
