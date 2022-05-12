package edu.uob;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PLEASE READ:
// The tests in this file will fail by default for a template skeleton, your job is to pass them
// and maybe write some more, read up on how to write tests at
// https://junit.org/junit5/docs/current/user-guide/#writing-tests
final class BasicCommandTests {

  private GameServer server;

  // Make a new server for every @Test (i.e. this method runs before every @Test test case)
  @BeforeEach
  void setup() {
      File entitiesFile = Paths.get("config/basic-entities.dot").toAbsolutePath().toFile();
      File actionsFile = Paths.get("config/basic-actions.xml").toAbsolutePath().toFile();
      server = new GameServer(entitiesFile, actionsFile);
  }

  // Test to spawn a new server and send a simple "look" command
  @Test
  void testLookingAroundStartLocation(){
    String response = server.handleCommand("player 1: look").toLowerCase();

    assertTrue(response.contains("empty room"), "Did not see description of room in response to look");
    assertTrue(response.contains("magic potion"), "Did not see description of artifacts in response to look");
    assertTrue(response.contains("wooden trapdoor"), "Did not see description of furniture in response to look");
  }

  // Add more unit tests or integration tests here.
  @Test
  void testInventory(){
    String response = server.handleCommand("haha: look").toLowerCase();
    System.out.println(response);
    String response1 = server.handleCommand("haha:get potion").toLowerCase();
    System.out.println(response1);
    String response2 = server.handleCommand("haha:goto forest").toLowerCase();
    System.out.println(response2);
    String response3 = server.handleCommand("haha:get key").toLowerCase();
    System.out.println(response3);
    String response4 = server.handleCommand("haha:goto cabin").toLowerCase();
    System.out.println(response4);
    String hello = server.handleCommand("haha:drop key").toLowerCase();
    System.out.println(hello);
    String response5 = server.handleCommand("haha:open key").toLowerCase();
    System.out.println(response5);
    String response6 = server.handleCommand("haha:goto cellar").toLowerCase();
    System.out.println(response6);
    String response7 = server.handleCommand("haha:hit elf").toLowerCase();
    System.out.println(response7);
    String response8 = server.handleCommand("haha:look").toLowerCase();
    System.out.println(response8);
    String response9 = server.handleCommand("haha:inv").toLowerCase();
    System.out.println(response9);
    String response10 = server.handleCommand("haha:goto cabin").toLowerCase();
    System.out.println(response10);
  }

  @Test
  void testBasicCommand(){
    //test goto command
    String word2 = server.handleCommand("Song:goto forest").toLowerCase();
    assertTrue(word2.contains("forest"));
    //test get command
    server.handleCommand("Song:get key");
    String word3 = server.handleCommand("Song:inv").toLowerCase();
    assertTrue(word3.contains("key"));
    //test look command
    String word4 = server.handleCommand("Song:look").toLowerCase();
    assertFalse(word4.contains("key"));
    //test inventory command
    String word5 = server.handleCommand("Song:inventory").toLowerCase();
    assertTrue(word5.contains("key"));
    //test drop command
    server.handleCommand("Song:drop key");
    String word6 = server.handleCommand("Song:look ").toLowerCase();
    assertTrue(word6.contains("key"));
    String word7 = server.handleCommand("Song:inv ").toLowerCase();
    assertFalse(word7.contains("key"));
  }

  @Test
  void testValidCommand(){
    //test empty command
    String word = server.handleCommand("").toLowerCase();
    assertTrue(word.contains("warning"));
    //test no username
    String word1 = server.handleCommand("goto cellar").toLowerCase();
    assertTrue(word1.contains("warning"));
    //test too many trigger
    String word2 = server.handleCommand("look and goto forest").toLowerCase();
    assertTrue(word2.contains("warning"));

    //test Too subject
    server.handleCommand("Song:goto forest");
    server.handleCommand("Song:get key");
    //test goto
    server.handleCommand("Song:goto cabin");
    server.handleCommand("Song:drop key");
    //test get 2 subject
    String word3 = server.handleCommand("get key and potion").toLowerCase();
    assertTrue(word3.contains("warning"));
    //test drop 2 subject
    server.handleCommand("Song:get potion");
    server.handleCommand("Song:get key");
    String word4 = server.handleCommand("drop key and potion").toLowerCase();
    assertTrue(word4.contains("warning"));
    //test goto 2 location
    server.handleCommand("Song:open key");
    String word5 = server.handleCommand("goto forest and cellar").toLowerCase();
    assertTrue(word5.contains("warning"));
  }
}
