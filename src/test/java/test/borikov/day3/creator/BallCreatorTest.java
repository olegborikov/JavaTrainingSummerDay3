package test.borikov.day3.creator;

import com.borikov.day3.creator.BallCreator;
import com.borikov.day3.entity.Ball;
import com.borikov.day3.enumtype.Color;
import com.borikov.day3.enumtype.Size;
import com.borikov.day3.exception.IncorrectDataException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallCreatorTest {
    BallCreator ballCreator;

    @BeforeMethod
    public void setUp() {
        ballCreator = new BallCreator();
    }

    @AfterMethod
    public void tearDown() {
        ballCreator = null;
    }

    @DataProvider(name = "createBallPositiveData")
    public Object[][] createBallPositiveData() {
        return new Object[][]{
                {Color.BLACK, Size.S, 5, new Ball(Color.BLACK, Size.S, 5)},
                {Color.YELLOW, Size.XL, 0.1, new Ball(Color.YELLOW, Size.XL, 0.1)},
                {Color.WHITE, Size.M, 10, new Ball(Color.WHITE, Size.M, 10)},
        };
    }

    @Test(dataProvider = "createBallPositiveData")
    public void createBallPositiveTest(Color ballColor,
                                       Size ballSize, double weight, Ball expected) {
        try {
            Ball actual = ballCreator.createBall(ballColor, ballSize, weight);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "createBallNegativeData")
    public Object[][] createBallNegativeData() {
        return new Object[][]{
                {Color.RED, Size.XXS, 9.1, new Ball(Color.BLACK, Size.S, 5)},
                {Color.BLUE, Size.L, 7, new Ball(Color.YELLOW, Size.XL, 0.1)},
                {Color.BROWN, Size.XXL, 1.9, new Ball(Color.WHITE, Size.M, 10)}
        };
    }

    @Test(dataProvider = "createBallNegativeData")
    public void createBallNegativeTest(Color ballColor,
                                       Size ballSize, double weight, Ball expected) {
        try {
            Ball actual = ballCreator.createBall(ballColor, ballSize, weight);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "createBallExceptionData")
    public Object[][] createBallExceptionData() {
        return new Object[][]{
                {null, Size.XXS, 9.1},
                {Color.RED, null, 9.1},
                {Color.RED, Size.XXS, 0}
        };
    }

    @Test(dataProvider = "createBallExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void createBallExceptionTest(
            Color ballColor, Size ballSize,
            double weight) throws IncorrectDataException {
        ballCreator.createBall(ballColor, ballSize, weight);
    }
}
