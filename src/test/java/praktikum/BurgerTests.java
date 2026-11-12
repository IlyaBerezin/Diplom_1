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
        Ingredient cutlet = Mockito.mock(Ingredient.class);
        Burger burger = new Burger();
        burger.addIngredient(cutlet);
        assertEquals(true, burger.ingredients.contains(cutlet));
    }

    //тест удаления ингредиента
    @Test
    void removeIngredientTest() {
        Ingredient chili_sauce = Mockito.mock(Ingredient.class);
        Ingredient cutlet = Mockito.mock(Ingredient.class);

        Burger burger = new Burger();
        burger.addIngredient(chili_sauce);
        burger.addIngredient(cutlet);
        burger.removeIngredient(0);
        assertEquals(cutlet, burger.ingredients.get(0));
    }

    //тест перемещения ингредиента
    @Test
    void moveIngredientTest() {
        Ingredient chili_sauce = Mockito.mock(Ingredient.class);
        Ingredient cutlet = Mockito.mock(Ingredient.class);
        Ingredient dinosaur = Mockito.mock(Ingredient.class);
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
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Ingredient chili_sauce = Mockito.mock(Ingredient.class);
        Mockito.when(chili_sauce.getPrice()).thenReturn(300f);
        Ingredient cutlet = Mockito.mock(Ingredient.class);
        Mockito.when(cutlet.getPrice()).thenReturn(100f);
        Ingredient dinosaur = Mockito.mock(Ingredient.class);
        Mockito.when(dinosaur.getPrice()).thenReturn(200f);

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
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);

        Ingredient sour_cream = Mockito.mock(Ingredient.class);
        Mockito.when(sour_cream.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sour_cream.getName()).thenReturn("sour cream");
        Mockito.when(sour_cream.getPrice()).thenReturn(200f);

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
