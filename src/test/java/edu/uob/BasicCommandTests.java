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
    String response = server.handleCommand("player : look").toLowerCase();

    assertTrue(response.contains("empty room"), "Did not see description of room in response to look");
    assertTrue(response.contains("magic potion"), "Did not see description of artifacts in response to look");
    assertTrue(response.contains("wooden trapdoor"), "Did not see description of furniture in response to look");
  }

  // Add more unit tests or integration tests here.
  @Test
  void testInventory(){
//    String response = server.handleCommand("haha: look").toLowerCase();
//    System.out.println(response);
//    String response1 = server.handleCommand("haha:get potion").toLowerCase();
//    System.out.println(response1);
//    String response2 = server.handleCommand("haha:goto forest").toLowerCase();
//    System.out.println(response2);
//    String response3 = server.handleCommand("haha:get key").toLowerCase();
//    System.out.println(response3);
//    String response4 = server.handleCommand("haha:goto cabin").toLowerCase();
//    System.out.println(response4);
//    String hello = server.handleCommand("haha:drop key").toLowerCase();
//    System.out.println(hello);
//    String response5 = server.handleCommand("haha:open key").toLowerCase();
//    System.out.println(response5);
//    String response6 = server.handleCommand("haha:goto cellar").toLowerCase();
//    System.out.println(response6);
//    String response7 = server.handleCommand("haha:hit elf").toLowerCase();
//    System.out.println(response7);
//    String response8 = server.handleCommand("haha:look").toLowerCase();
//    System.out.println(response8);
//    String response9 = server.handleCommand("haha:inv").toLowerCase();
//    System.out.println(response9);
//    String response10 = server.handleCommand("haha:goto cabin").toLowerCase();
//    System.out.println(response10);
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
    String word8 = server.handleCommand("Song:health ").toLowerCase();
    assertTrue(word8.contains("3"));
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
    String word2 = server.handleCommand("Song:look and goto forest").toLowerCase();
    assertTrue(word2.contains("warning"));
    //test goto somewhere you can not go
    String word6 = server.handleCommand("Song: goto cellar").toLowerCase();
    assertTrue(word6.contains("warning"));
    //test get something not in current location
    String word7 = server.handleCommand("Song: get key").toLowerCase();
    assertTrue(word7.contains("warning"));
    //test get something not artifact
    String word8 = server.handleCommand("Song: get trapdoor").toLowerCase();
    assertTrue(word8.contains("warning"));
    //test drop something not in you inventory
    String word9 = server.handleCommand("Song: drop trapdoor").toLowerCase();
    assertTrue(word9.contains("warning"));


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

  @Test
  void testMultiplePlayer(){
    //test multiple user can see each other
    server.handleCommand("song:look");
    String word1 = server.handleCommand("wang:look").toLowerCase();
    assertTrue(word1.contains("song"));
    String word2 = server.handleCommand("li:look").toLowerCase();
    assertTrue(word2.contains("wang"));
    String word3 = server.handleCommand("song:look").toLowerCase();
    assertTrue(word3.contains("li"));

    //test one player get something ,other can not see this thing again
    String word4 = server.handleCommand("wang:get potion").toLowerCase();
    assertTrue(word4.contains("potion"));
    String word5 = server.handleCommand("li:look").toLowerCase();
    assertFalse(word5.contains("potion"));
    String word6 = server.handleCommand("song:look").toLowerCase();
    assertFalse(word6.contains("potion"));

    //test one player goto somewhere ,other can not see him again
    String word7 = server.handleCommand("wang:drop potion").toLowerCase();
    assertTrue(word7.contains("potion"));
    String word8 = server.handleCommand("li:look").toLowerCase();
    assertTrue(word8.contains("potion"));
    String word9 = server.handleCommand("song:look").toLowerCase();
    assertTrue(word9.contains("potion"));

    //test player dead
    server.handleCommand("song:get potion");
    server.handleCommand("song:goto forest");
    server.handleCommand("song:get key");
    server.handleCommand("song:goto cabin");
    server.handleCommand("song:open key");
    server.handleCommand("song:goto cellar");
    server.handleCommand("song:hit elf");
    server.handleCommand("wang:goto cellar");
    String word14 = server.handleCommand("li:look").toLowerCase();
    assertFalse(word14.contains("song"));
    server.handleCommand("song:hit elf");
//    server.handleCommand("song:drink potion");
//    server.handleCommand("song:hit elf");
    String word10 = server.handleCommand("song:health").toLowerCase();
    assertTrue(word10.contains("1"));
    String word11 = server.handleCommand("song:hit elf").toLowerCase();
    System.out.println(word11);
    assertTrue(word11.contains("dead"));
    String word12 = server.handleCommand("wang:look").toLowerCase();
    assertFalse(word12.contains("song"));
    assertTrue(word12.contains("potion"));
    String word13 = server.handleCommand("li:look").toLowerCase();
    assertTrue(word13.contains("song"));

  }
}
