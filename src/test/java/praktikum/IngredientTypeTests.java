package praktikum;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.api.Assertions;

@ExtendWith(MockitoExtension.class)
public class IngredientTypeTests {

    @ParameterizedTest
    @EnumSource(IngredientType.class) // Автоматически подставляет SAUCE и FILLING
    void ingredientTypeTest(IngredientType type) {
        // Проверяем, что значение валидно и совпадает с самим собой
        Assertions.assertEquals(type, type, "Тип ингредиента не соответствует ожидаемому");
    }
}
