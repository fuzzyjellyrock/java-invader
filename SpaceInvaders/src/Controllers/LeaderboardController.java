/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Leaderboard;
import Models.Player;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fuzzyrock
 */
public class LeaderboardController {
    
    Leaderboard st;
    
    /**
     * Initializes class by loading a Leaderboard object file into the controller,
     * if the object file does not exists, it creates a new Leaderboard object.
     */
    public LeaderboardController() {
        loadScoreTable();
        if (this.st == null){
            System.out.println("Creating new Leaderboard.");
            this.st = new Leaderboard();
        }
    }
    
    /**
     * If the leaderboard is not empty, it gets highest score from Leaderboard, and then casts the value to a String type.
     * @return highest score as a String type.
     */
    public String getHighScore(){
        String text = "0";
        if (!this.st.isListEmpty()){
            text = String.valueOf(this.st.getHighScore());
        }
        return text;
    }
    
    /**
     * Updates a table with rows that contain the player's name, level and score.
     * 
     * @param table table to be filled with player's scores.
     */
    public void updateLeaderboardTable(DefaultTableModel table){
        for(Player current : this.st.getScores()){
            String row[] = new String[table.getColumnCount()];
            row[0] = current.getName();
            row[1] = String.valueOf(current.getScore());
            row[2] = String.valueOf(current.getLvl());

            table.addRow(row);
        }
    }
    
    /**
     * Adds a new player to the leaderboard and saves it in the computer disk.
     * 
     * @param player the new player that will be added to the leaderboard.
     */
    public void addNewScore(Player player){
        this.st.addNewScore(player);
        saveScores();
    }
    
    /**
     * Checks if leaderboard list is empty.
     * 
     * @return True if list is empty, or False if there is at least one player.
     */
    public boolean isEmpty(){
        return this.st.isListEmpty();
    }
    
    /**
     * Debug method that gets a String object with the leaderboard players list.
     * 
     * @return a String containing the leaderboard players.
     */
    public String leaderbordToString(){
        return this.st.toString();
    }
    
    /**
     * Loads the leaderboard.obj containing a Leaderboard object file into the controller.
     */
    public void loadScoreTable(){
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("leaderboard.obj"));
            this.st = (Leaderboard) input.readObject();
            input.close();
        } catch (IOException e) {
            System.out.println("leaderboard.obj was not found.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception.");
        }
    }
    
    /**
     * Saves the leaderboard object in the computer disk.
     */
    public void saveScores(){
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("leaderboard.obj"));
            output.writeObject(this.st);
            output.close();
            System.out.println("Scores saved.");
        } catch (IOException e) {
            System.out.println("WARNING. Cannot save scores.");
        }
    }
}
