package praktikum;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BurgerTests {

    @Mock
    private Bun bun;

    @Test
    void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.verifyNoInteractions(bun);
    }

    //тест добавления ингредиента
    @Test
    void addIngredientTest() {
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Burger burger = new Burger();
        burger.addIngredient(cutlet);
        assertEquals(true, burger.ingredients.contains(cutlet));
    }

    //тест удаления ингредиента
    @Test
    void removeIngredientTest() {
        Ingredient chili_sauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);

        Burger burger = new Burger();
        burger.addIngredient(chili_sauce);
        burger.addIngredient(cutlet);
        burger.removeIngredient(0);
        assertEquals("cutlet", burger.ingredients.get(0).getName());
    }

    //тест перемещения ингредиента
    @Test
    void moveIngredientTest() {
        Ingredient chili_sauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient dinosaur = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        Burger burger = new Burger();
        burger.addIngredient(chili_sauce);
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);

        burger.moveIngredient(2, 1);
        assertEquals(dinosaur, burger.ingredients.get(1));
        assertEquals(cutlet, burger.ingredients.get(2));
    }
    //тест расчёта цены бургера
    @Test
    void GetPriceTest() {
        Bun bun = new Bun("black bun", 100);
        Ingredient chili_sauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient dinosaur = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(chili_sauce);
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);

        float expectedPrice = 100 * 2 + 300 + 100 + 200;
        assertEquals(expectedPrice, burger.getPrice());
    }
    //тест метода создания чека
    @Test
    void getReceiptTest() {
        Bun bun = new Bun("white bun", 200);
        Ingredient sour_cream = new Ingredient(IngredientType.SAUCE, "sour cream", 200);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sour_cream);

        String expectedReceipt = burger.getReceipt();
        assertTrue(expectedReceipt.contains("white bun"));
        assertTrue(expectedReceipt.contains("sour cream")); // тип в нижнем регистре
        assertTrue(expectedReceipt.contains("Price:"));

        float price = burger.getPrice();
        assertEquals(600, price);
    }




}
