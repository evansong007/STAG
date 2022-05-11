package edu.uob.entity;

import edu.uob.GameVistor;

public class Character extends GameEntity{
    public Character(String name, String description) {
        super(name, description);
    }

    @Override
    public void accept(GameVistor vistor) {

    }


}
