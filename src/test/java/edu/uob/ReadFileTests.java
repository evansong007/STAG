package edu.uob;


import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Paths;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ReadFileTests {

    @Test
    void testExtendedEntity(){
        File extendedEntitiesFile = Paths.get("config/extended-entities.dot").toAbsolutePath().toFile();
        File extendedActionsFile = Paths.get("config/extended-actions.xml").toAbsolutePath().toFile();
        GameBuilder extendedBuilder = new GameBuilder(extendedEntitiesFile,extendedActionsFile);
        extendedBuilder.importActions();
        extendedBuilder.importEntities();
        GameModel model = extendedBuilder.getModel();
        Set<String> subjects = model.getSubjectList();
        //test read entity form file
        assertTrue(subjects.contains("cabin"));
        assertTrue(subjects.contains("potion"));
        assertTrue(subjects.contains("axe"));
        assertTrue(subjects.contains("coin"));
        assertTrue(subjects.contains("trapdoor"));
        assertTrue(subjects.contains("forest"));
        assertTrue(subjects.contains("key"));
        assertTrue(subjects.contains("tree"));
        assertTrue(subjects.contains("cellar"));
        assertTrue(subjects.contains("elf"));
        assertTrue(subjects.contains("riverbank"));
        assertTrue(subjects.contains("horn"));
        assertTrue(subjects.contains("river"));
        assertTrue(subjects.contains("clearing"));
        assertTrue(subjects.contains("ground"));
        assertTrue(subjects.contains("storeroom"));
        assertTrue(subjects.contains("lumberjack"));
        assertTrue(subjects.contains("log"));
        assertTrue(subjects.contains("shovel"));
        assertTrue(subjects.contains("gold"));
        assertTrue(subjects.contains("hole"));

        //test read trigger form file
        Set<String> triggers = model.getTriggerList();
        assertTrue(triggers.contains("open"));
        assertTrue(triggers.contains("unlock"));
        assertTrue(triggers.contains("chop"));
        assertTrue(triggers.contains("cut"));
        assertTrue(triggers.contains("cutdown"));
        assertTrue(triggers.contains("drink"));
        assertTrue(triggers.contains("fight"));
        assertTrue(triggers.contains("hit"));
        assertTrue(triggers.contains("attack"));
        assertTrue(triggers.contains("pay"));
        assertTrue(triggers.contains("bridge"));
        assertTrue(triggers.contains("dig"));
        assertTrue(triggers.contains("blow"));
    }

}
