package edu.uob;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class ExtendedCommandTests {
    private GameServer server;

    // Make a new server for every @Test (i.e. this method runs before every @Test test case)
    @BeforeEach
    void setup() {
        File entitiesFile = Paths.get("config/extended-entities.dot").toAbsolutePath().toFile();
        File actionsFile = Paths.get("config/extended-actions.xml").toAbsolutePath().toFile();
        server = new GameServer(entitiesFile, actionsFile);
    }

    @Test
    void testGold() {
        server.handleCommand("song: goto forest");
        server.handleCommand("song: get key");
        server.handleCommand("song: goto cabin");
        server.handleCommand("song: unlock trapdoor");
        server.handleCommand("song: get axe");
        server.handleCommand("song: get coin");
        server.handleCommand("song: goto forest");
        server.handleCommand("song: cut tree");
        server.handleCommand("song: get log");
        server.handleCommand("song: goto cabin");
        server.handleCommand("song: goto cellar");
        server.handleCommand("song: pay elf");
        server.handleCommand("song: get shovel");
        server.handleCommand("song: goto cabin");
        server.handleCommand("song: goto forest");
        server.handleCommand("song: goto riverbank");
        server.handleCommand("song: bridge log");
        server.handleCommand("song: get horn");
        server.handleCommand("song: goto clearing");
        String response = server.handleCommand("song: dig shovel");
        System.out.println(response);
        server.handleCommand("song: get gold");
        String response1 = server.handleCommand("song: look");
        System.out.println(response1);
        assertFalse(response1.contains("gold"));
        String response2 = server.handleCommand("song: inv");
        System.out.println(response1);
        assertTrue(response2.contains("gold"));
    }

    @Test
    void testdig() {
        String[] wolk = {
                "song: goto forest",
                "song: get key",
                "song: goto cabin",
                "song: unlock trapdoor",
                "song: get axe",
                "song: get coin",
                "song: goto cellar",
                "song: pay elf",
                "song: get shovel",
                "song: goto cabin",
                "song: goto forest",
                "song: cut tree",
                "song: goto riverbank",
                "song: bridge log",
                "song: get horn",
                "song: goto clearing",
                "song: dig shovel",
                "song: get hole",
                "song: look",
        };

        for (String command : wolk) {
            System.out.println(server.handleCommand(command));
            System.out.println("-------------------------------------");
        }
    }
}
