package edu.uob;

import java.util.HashMap;
import java.util.HashSet;

public class GameModel {
    private HashMap<String, HashSet<GameAction>> actionMap;

    public GameModel(){
        this.actionMap = new HashMap<>();
    }

    public void addAction(GameAction action){
        if(actionMap.containsKey(action.getTrigger())){
            actionMap.get(action.getTrigger()).add(action);
        }else {
            HashSet<GameAction> actionHashSet = new HashSet<>();
            actionHashSet.add(action);
            actionMap.put(action.getTrigger(),actionHashSet);
        }
    }

    public HashMap<String,HashSet<GameAction>> getActionMap(){
        return actionMap;
    }
}
