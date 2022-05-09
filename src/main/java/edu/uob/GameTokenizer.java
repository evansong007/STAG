package edu.uob;

import edu.uob.entity.Player;

import java.util.ArrayList;

public class GameTokenizer {
    private String command;
    private String playerName;

    public GameTokenizer(String command) {
        this.playerName = command.split(":",2)[0];
        this.command = command.split(":",2)[1];
    }


    public Player getPlayer(){
        return new Player(playerName,"A student of Bristol");
    }

    public ArrayList<String> getTokens(){
        ArrayList<String> tokens = new ArrayList<>();
        String optimizer = command.toLowerCase().trim();
        String[] words = optimizer.split(" ");
        for (String word:words) {
            tokens.add(word);
        }
        return tokens;
    }

}
