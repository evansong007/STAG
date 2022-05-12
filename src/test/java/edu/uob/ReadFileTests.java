package edu.uob;


import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Paths;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ReadFileTests {
    private GameBuilder basicBuilder;
    private GameBuilder extendedBuilder;


    @Test
    void basicactionTest() {
        File entitiesFile = Paths.get("config/basic-entities.dot").toAbsolutePath().toFile();
        File actionsFile = Paths.get("config/basic-actions.xml").toAbsolutePath().toFile();
        basicBuilder = new GameBuilder(entitiesFile,actionsFile);
        basicBuilder.importActions();
        basicBuilder.importEntities();

    }

    @Test
    void extendedActionTest() {
        File extendedEntitiesFile = Paths.get("config/extended-entities.dot").toAbsolutePath().toFile();
        File extendedActionsFile = Paths.get("config/extended-actions.xml").toAbsolutePath().toFile();
        extendedBuilder = new GameBuilder(extendedEntitiesFile,extendedActionsFile);
        extendedBuilder.importActions();
        extendedBuilder.importEntities();
    }

    @Test
    void testExtendedEntity(){
        File extendedEntitiesFile = Paths.get("config/extended-entities.dot").toAbsolutePath().toFile();
        File extendedActionsFile = Paths.get("config/extended-actions.xml").toAbsolutePath().toFile();
        extendedBuilder = new GameBuilder(extendedEntitiesFile,extendedActionsFile);
        extendedBuilder.importActions();
        extendedBuilder.importEntities();
        GameModel model = extendedBuilder.getModel();
        Set<String> subjects = model.getSubjectList();
        for (String subject: subjects) {
            System.out.println(subject);
        }
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

    }

}
