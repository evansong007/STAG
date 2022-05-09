package edu.uob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

final class ParseCommandTests{


    @BeforeEach
    void setParser(){
        GameTokenizer tokenizer;
    }


    @Test
    void testRegularCommand(){
        //test white space
        String test1 = "song : open the door with key";
        String test2 = "song: open the door with key";
        String test3 = "song:open the door with key";
        String test4 = "song :open the door with key";
        //



    }
}


