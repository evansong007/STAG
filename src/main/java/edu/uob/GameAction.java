package edu.uob;

import java.util.ArrayList;

public class GameAction
{
    private String trigger;
    private ArrayList<String> subjects;
    private ArrayList<String> consumed;
    private ArrayList<String> produced;

    private String narration;


    public GameAction(){
        subjects = new ArrayList<>();
        consumed = new ArrayList<>();
        produced = new ArrayList<>();
    }

    public void setTrigger(String trigger){this.trigger = trigger;}

    public void addSubject(String item){
        subjects.add(item);
    }

    public void addConsumed(String item){
        consumed.add(item);
    }

    public void addProduced(String item){
        produced.add(item);
    }

    public void setNarration(String narration){this.narration = narration;}

    public String getTrigger(){
        return this.trigger;
    }
}
