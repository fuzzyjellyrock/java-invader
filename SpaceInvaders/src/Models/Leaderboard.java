/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author fuzzyrock
 */
public class Leaderboard implements Serializable {
    final int lim = 8;
    private LinkedList<Player> scores;

    public Leaderboard() {
        this.scores = new LinkedList<>();
    }
    
    /**
     * The list is always sorted in descending order by Player score,
     * it gets the first player in the scores list and returns its score value.
     * 
     * @return highest score in the leaderboard.
     */
    public int getHighScore(){
        return this.scores.getFirst().getScore();
    }
    
    /**
     * Calls scores list's isEmpty() method and returns its value.
     * 
     * @return True if scores list is empty, or else False.
     */
    public boolean isListEmpty(){
        return this.getScores().isEmpty();
    }
    
    /**
     * Sorts the scores list in descending order by Player score using the insertion sort algorithm.
     */
    public void sort(){
        int n = this.getScores().size();
        for (int i = 1; i < n; ++i) {
            Player key = this.getScores().get(i);
            int j = i - 1;

            while (j >= 0 && this.getScores().get(j).getScore() < key.getScore()) {
                this.getScores().set(j+1, this.getScores().get(j));
                j = j - 1;
            }
            this.getScores().set(j+1, key);
        }
    }
    
    /**
     * Creates a copy of a player, adds it to the Leaderboard and sorts the list.
     * 
     * @param player Player that will be added to the Leaderboard.
     */
    public void addNewScore(Player player){
        //Creates a copy named p of the player.
        Player p = new Player(player.getName());
        p.setScore(player.getScore());
        p.setLvl(player.getLvl());
        
        /*
            Checks if the list size is within the limit.
            If the list size is less than the limit, it adds the player and sorts the list.
            Else, if the player's score is greater than the lowest score inside the scores list
            it  adds it to the list, sorts it and deletes the last one with the lowest score.
        */
        if(this.getScores().size() < 8){
            this.getScores().add(p);
            sort();
        } else if (player.getScore() > this.getScores().get(this.lim-1).getScore()) {
            this.getScores().add(p);
            sort();
            this.getScores().removeLast();
        }
    }
    
    /**
     * Debug method that returns a String with the Leaderboard player's info.
     * 
     * @return a String with the Leaderboard player's info.
     */
    @Override
    public String toString(){
        String text = "Leaderboard\n\n";
        
        for(Player current : this.getScores()){
            text += current.toString();
        }
        
        return text;
    }

    /**
     * @return the scores
     */
    public LinkedList<Player> getScores() {
        return scores;
    }
}
