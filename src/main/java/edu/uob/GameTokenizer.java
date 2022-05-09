package edu.uob;

import edu.uob.entity.Player;

import java.util.ArrayList;

public class GameTokenizer {
    private String command;
    private String playerName;

    private ArrayList<String> actions;

    private ArrayList<String> subjects;


    public GameTokenizer(String command) {
        this.playerName = command.split(":",2)[0];
        this.command = command.split(":",2)[1];
    }


    public Player getPlayer(){
        return new Player(playerName,"A student of Bristol");
    }

    public void setTokens(){
        String optimizer = command.toLowerCase().trim();
        String[] words = optimizer.split(" ");
        for (String word:words) {

        }


    }
}
