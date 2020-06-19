package test.borikov.day3.validator;

import com.borikov.day3.validator.BasketValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketValidatorTest {
    BasketValidator basketValidator;

    @BeforeClass
    public void setUp() {
        basketValidator = new BasketValidator();
    }

    @AfterClass
    public void tierDown() {
        basketValidator = null;
    }

    @DataProvider(name = "isCapacityInLimitPositiveData")
    public Object[][] createIsCapacityInLimitPositiveData() {
        return new Object[][]{
                {1.},
                {200},
                {100.}
        };
    }

    @Test(dataProvider = "isCapacityInLimitPositiveData")
    public void isCapacityInLimitPositiveTest(double number) {
        boolean actual = basketValidator.isCapacityInLimit(number);
        assertTrue(actual);
    }

    @DataProvider(name = "isCapacityInLimitNegativeData")
    public Object[][] createIsCapacityInLimitNegativeData() {
        return new Object[][]{
                {0.},
                {201},
                {1234.}
        };
    }

    @Test(dataProvider = "isCapacityInLimitNegativeData")
    public void isCapacityInLimitNegativeTest(double number) {
        boolean actual = basketValidator.isCapacityInLimit(number);
        assertFalse(actual);
    }
}
