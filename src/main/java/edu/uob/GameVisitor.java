package edu.uob;

import edu.uob.entity.*;
import edu.uob.entity.Character;

public abstract class GameVisitor {
    GameModel model;

    String currentPlayer;

    GameAction action;


    public GameVisitor(GameModel model, String currentPlayer, GameAction action) {
        this.model = model;
        this.currentPlayer = currentPlayer;
        this.action = action;
    }


    public abstract void interactWithEntity(Artefact artefact);

    public abstract void interactWithEntity(Character character);

    public abstract void interactWithEntity(Furniture furniture);

    public abstract void interactWithEntity(Location location);

    public abstract void interactWithEntity(Player player);

}
