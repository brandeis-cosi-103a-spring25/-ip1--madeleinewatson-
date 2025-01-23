package edu.brandeis.cosi103a.ip1;
import java.util.Random;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void testRollDie() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int roll = App.rollDie(random);
            assertTrue( "Roll should be between 1 and 6, but was: " + roll, roll >= 1 && roll <= 6);
        }
    }
    @Test
    public void testPlayTurnNoReroll() {
        String input = "no\n"; // Player chooses not to reroll
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Random random = new Random();
        int roll = App.playTurn(new Scanner(System.in), random);

        assertTrue( "Final roll should be between 1 and 6, but was: " + roll, roll >= 1 && roll <= 6);
    }

   
}
