package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BunTests {

    @Test
    void setsNameCorrectly() {
        Bun bun = new Bun("black bun", 100);

        assertEquals("black bun", bun.getName(), "название булочки некорректное");
    }

    @Test
    void setsPriceCorrectly() {
        Bun bun = new Bun("white bun", 200);

        assertEquals(200, bun.getPrice(), "цена булочки некорректная");
    }

    @Test
    void setsNameUnCorrectly() {
        Bun bun = new Bun("red bun", 100);

        assertEquals("black bun", bun.getName(), "название булочки некорректное");
    }

    @Test
    void setsPriceUnCorrectly() {
        Bun bun = new Bun("red bun", 200);

        assertEquals(300, bun.getPrice(), "цена булочки некорректная");
    }

    @Test
    void setsPriceNegative() {
        Bun bun = new Bun("red bun", -300);

        assertEquals(300, bun.getPrice(), "цена булочки некорректная");
    }

    @Test
    void setsNameEmpty() {
        Bun bun = new Bun("", 100);

        assertEquals("black bun", bun.getName(), "название булочки некорректное");
    }
}
