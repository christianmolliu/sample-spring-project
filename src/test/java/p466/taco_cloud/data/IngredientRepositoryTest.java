package p466.taco_cloud.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;
import org.springframework.security.test.context.support.WithMockUser;
import p466.taco_cloud.Ingredient;

@DataJdbcTest
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepo;

    @Test
    @WithMockUser
    public void shouldFindIngredients() {

        Iterable<Ingredient> ingredients =
                ingredientRepo.findAll();

        assertThat(ingredients).isNotEmpty();
    }

    @Test
    @WithMockUser
    public void shouldFindFlourTortillaById() {

        Ingredient ingredient =
                ingredientRepo.findById("FLTO")
                        .orElseThrow();

        assertThat(ingredient.getName())
                .isEqualTo("Flour Tortilla");
    }
}