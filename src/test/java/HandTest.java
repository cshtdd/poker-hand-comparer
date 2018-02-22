import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {
    @Test(expected = IllegalArgumentException.class)
    public void failsWhenNull(){
        Hand.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenEmpty(){
        Hand.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenLessThanFiveCards(){
        Hand.parse("2D 3D 4D 5D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenMoreThanFiveCards(){
        Hand.parse("3D 3D 4D 5D 6D 7D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenCardTooShort(){
        Hand.parse("D 2D 3D 4D 5D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenCardTooLong(){
        Hand.parse("10D 2D 3D 4D 5D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenInvalidClub(){
        Hand.parse("2C 3D 4H 5S 6I");
    }

    @Test
    public void buildsHand(){
        assertEquals("2D 3D 4D 5D 6D", Hand.parse("2D 3D 4D 5D 6D").toString());
        assertEquals("2D 3D 4S 5H 6D", Hand.parse("2d 3D 4S 5h 6D").toString());
        assertEquals("2C 2D 2H 2S 6D", Hand.parse("2c 2d 2h 2s 6D").toString());
    }
}