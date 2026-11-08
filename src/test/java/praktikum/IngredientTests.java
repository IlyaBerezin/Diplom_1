package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTests {

    @Test
    void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

        assertEquals(IngredientType.SAUCE, ingredient.getType(), "Тип ингредиента некорректный");
    }

    @Test
    void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300);

        assertEquals("sausage", ingredient.getName(), "Название ингредиента некорректное");
    }

    @Test
    void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);

        assertEquals(200, ingredient.getPrice(), "Цена ингредиента некорректная");
    }

    @Test
    void getTypeUnCorrectlyTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "hot sauce", 100);

        assertEquals(IngredientType.SAUCE, ingredient.getType(), "Тип ингредиента некорректный");
    }

    @Test
    void getNameUnCorrectlyTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "hot sauce", 300);

        assertEquals("sausage", ingredient.getName(), "Название ингредиента некорректное");
    }

    @Test
    void getPriceUnCorrectlyTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 300);

        assertEquals(200, ingredient.getPrice(), "Цена ингредиента некорректная");
    }


}
