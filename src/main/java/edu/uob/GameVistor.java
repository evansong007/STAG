package edu.uob;

import edu.uob.entity.*;

import java.lang.Character;
import java.util.ArrayList;

public abstract class GameVistor {
    GameModel model;

    String currentPlayer;

    GameAction action;


    public GameVistor(GameModel model,String currentPlayer,GameAction action){
        this.model = model;
        this.currentPlayer = currentPlayer;
        this.action = action;
    }

    public abstract void interactWithEntity(GameEntity gameEntity);

    public abstract void interactWithArtefact(Artefact artefact);

    public abstract void interactWithCharacter(Character character);

    public abstract void interactWithFurniture(Furniture furniture);

    public abstract void interactWithLocation(Location location);

    public abstract void interactWithPlayer(Player player);

}
