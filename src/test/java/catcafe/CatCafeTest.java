package catcafe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for CatCafe.
 */
class CatCafeTest {
    private CatCafe cafe;

    @BeforeEach
    void setUp() {
        cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
        cafe.addCat(new FelineOverLord("Gwenapurr Esmeralda", 3));
        cafe.addCat(new FelineOverLord("Morticia", 3));
        cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));
    }

    /**
     * Test if a cat can be found by name when it exists in the cafe.
     */
    @Test
    void testGetCatByNameExists() {
        Optional<FelineOverLord> cat = cafe.getCatByName("Morticia");
        assertTrue(cat.isPresent(), "Cat should be found");
        assertEquals("Morticia", cat.get().name(), "Cat's name should be Morticia");
    }

    /**
     * Test if a cat is not found by name when it does not exist in the cafe.
     */
    @Test
    void testGetCatByNameNotExists() {
        Optional<FelineOverLord> cat = cafe.getCatByName("Nonexistent");
        assertFalse(cat.isPresent(), "Cat should not be found");
    }

    /**
     * Test if a cat is not found by name when the name is null.
     */
    @Test
    void testGetCatByNameNull() {
        Optional<FelineOverLord> cat = cafe.getCatByName(null);
        assertFalse(cat.isPresent(), "Cat should not be found");
    }

    /**
     * Test if a cat can be found by weight within a valid range.
     */
    @Test
    void testGetCatByWeightInRange() {
        Optional<FelineOverLord> cat = cafe.getCatByWeight(3, 4);
        assertTrue(cat.isPresent(), "Cat should be found");
        assertEquals(3, cat.get().weight(), "Cat's weight should be within range");
    }

    /**
     * Test if a cat is not found by weight when no cats are within the given range.
     */
    @Test
    void testGetCatByWeightOutOfRange() {
        Optional<FelineOverLord> cat = cafe.getCatByWeight(6, 10);
        assertFalse(cat.isPresent(), "Cat should not be found");
    }

    /**
     * Test if a cat is not found by weight when the minimum weight is negative.
     */
    @Test
    void testGetCatByWeightNegative() {
        Optional<FelineOverLord> cat = cafe.getCatByWeight(-1, 4);
        assertFalse(cat.isPresent(), "Cat should not be found");
    }

    /**
     * Test if a cat is not found by weight when the weight range is invalid.
     */
    @Test
    void testGetCatByWeightInvalidRange() {
        Optional<FelineOverLord> cat = cafe.getCatByWeight(5, 3);
        assertFalse(cat.isPresent(), "Cat should not be found");
    }

    /**
     * Test if a new cat can be added to the cafe.
     */
    @Test
    void testAddCat() {
        cafe.addCat(new FelineOverLord("New Cat", 4));
        Optional<FelineOverLord> cat = cafe.getCatByName("New Cat");
        assertTrue(cat.isPresent(), "New cat should be found");
        assertEquals("New Cat", cat.get().name(), "Cat's name should be New Cat");
    }

    /**
     * Test the count of cats in the cafe.
     */
    @Test
    void testCatCount() {
        assertEquals(4, cafe.getCatCount(), "There should be 4 cats");
        cafe.addCat(new FelineOverLord("Another Cat", 2));
        assertEquals(5, cafe.getCatCount(), "There should be 5 cats");
    }

    /**
     * Test if a visitor can be accepted by the cafe.
     */
    @Test
    void testAcceptVisitor() {
        String result = cafe.accept(new SimpleTreeVisitor());
        assertNotNull(result, "Visitor should return a result");
    }
}
