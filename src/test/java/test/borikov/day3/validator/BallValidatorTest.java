package test.borikov.day3.validator;

import com.borikov.day3.validator.BallValidator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallValidatorTest {
    BallValidator ballValidator;

    @BeforeMethod
    public void setUp() {
        ballValidator = new BallValidator();
    }

    @AfterMethod
    public void tearDown() {
        ballValidator = null;
    }

    @DataProvider(name = "isWeightInLimitPositiveData")
    public Object[][] createIsWeightInLimitPositiveData() {
        return new Object[][]{
                {1.},
                {0.1},
                {10}
        };
    }

    @Test(dataProvider = "isWeightInLimitPositiveData")
    public void isWeightInLimitPositiveTest(double number) {
        boolean actual = ballValidator.isWeightInLimit(number);
        assertTrue(actual);
    }

    @DataProvider(name = "isWeightInLimitNegativeData")
    public Object[][] createIsWeightInLimitNegativeData() {
        return new Object[][]{
                {0.01},
                {11},
                {321}
        };
    }

    @Test(dataProvider = "isWeightInLimitNegativeData")
    public void isWeightInLimitNegativeTest(double number) {
        boolean actual = ballValidator.isWeightInLimit(number);
        assertFalse(actual);
    }
}
