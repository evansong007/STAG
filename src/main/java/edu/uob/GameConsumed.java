package edu.uob;

import edu.uob.entity.*;

import java.lang.Character;

public class GameConsumed extends GameVistor{

    public GameConsumed(GameModel model, String currentPlayer, GameAction action) {
        super(model, currentPlayer, action);
    }

    @Override
    public void interactWithEntity(GameEntity gameEntity) {

    }

    @Override
    public void interactWithArtefact(Artefact artefact) {

    }

    @Override
    public void interactWithCharacter(Character character) {

    }

    @Override
    public void interactWithFurniture(Furniture furniture) {

    }

    @Override
    public void interactWithLocation(Location location) {

    }

    @Override
    public void interactWithPlayer(Player player) {

    }
}
