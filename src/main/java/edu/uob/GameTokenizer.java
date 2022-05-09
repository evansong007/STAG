package edu.uob;

import edu.uob.entity.Player;

import java.util.ArrayList;
import java.util.Set;

public class GameTokenizer {
    private String[] command;
    private String playerName;

    public GameTokenizer(String command) {
        this.playerName = command.split(":",2)[0];
        this.command = command.split(":",2)[1].toLowerCase().trim().split(" ");
    }


    public Player getPlayer(){
        return new Player(playerName,"A student of Bristol");
    }


    public ArrayList<String> getActions(Set<String> triggers){
        ArrayList<String> actions = new ArrayList<>();
        for (String word:command) {
            if(triggers.contains(word)){
                actions.add(word);
            }
        }
        return actions;
    }

    public ArrayList<String> getSubjects(Set<String> subjects){
        ArrayList<String> entities = new ArrayList<>();
        for (String word:command) {
            if(subjects.contains(word)){
                entities.add(word);
            }
        }
        return entities;
    }
}
