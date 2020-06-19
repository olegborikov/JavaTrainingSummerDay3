package test.borikov.day3.service;

import com.borikov.day3.creator.BasketCreator;
import com.borikov.day3.entity.Ball;
import com.borikov.day3.entity.Basket;
import com.borikov.day3.enumtype.Color;
import com.borikov.day3.enumtype.Size;
import com.borikov.day3.exception.IncorrectDataException;
import com.borikov.day3.service.BasketService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketServiceTest {
    BasketService basketService;

    @BeforeMethod
    public void setUp() {
        basketService = new BasketService();
    }

    @AfterMethod
    public void tearDown() {
        basketService = null;
    }

    @DataProvider(name = "countBallsByColorPositiveData")
    public Object[][] createCountBallsByColorPositiveData() {
        return new Object[][]{
                {new BasketCreator().createFillUpBasket(), Color.GREY, 3},
                {new BasketCreator().createFillUpBasket(), Color.GREEN, 1},
                {new BasketCreator().createFillUpBasket(), Color.YELLOW, 0},
        };
    }

    @Test(dataProvider = "countBallsByColorPositiveData")
    public void countBallsByColorPositiveTest(Basket basket, Color color, int expected) {
        try {
            int actual = basketService.countBallsByColor(basket, color);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "countBallsByColorNegativeData")
    public Object[][] createCountBallsByColorNegativeData() {
        return new Object[][]{
                {new BasketCreator().createFillUpBasket(), Color.GREY, 2},
                {new BasketCreator().createFillUpBasket(), Color.GREEN, 4},
                {new BasketCreator().createFillUpBasket(), Color.YELLOW, 1},
        };
    }

    @Test(dataProvider = "countBallsByColorNegativeData")
    public void countBallsByColorNegativeTest(Basket basket, Color color, int expected) {
        try {
            int actual = basketService.countBallsByColor(basket, color);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "countBallsByColorExceptionData")
    public Object[][] createCountBallsByColorExceptionData() {
        return new Object[][]{
                {null, Color.GREY},
                {new BasketCreator().createFillUpBasket(), null},
                {null, null},
        };
    }

    @Test(dataProvider = "countBallsByColorExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void countBallsByColorExceptionTest(
            Basket basket, Color color) throws IncorrectDataException {
        basketService.countBallsByColor(basket, color);
    }

    @DataProvider(name = "calculateBallsWeightPositiveData")
    public Object[][] createCalculateBallsWeightPositiveData() {
        return new Object[][]{
                {new BasketCreator().createFillUpBasket(), 45},
                {new Basket(200) {{
                    add(new Ball(Color.RED, Size.XXS, 1));
                    add(new Ball(Color.BLUE, Size.XS, 2));
                    add(new Ball(Color.GREEN, Size.S, 3));
                    add(new Ball(Color.GOLD, Size.M, 4));
                }}, 10},
                {new Basket(200) {{
                    add(new Ball(Color.ORANGE, Size.L, 5));
                    add(new Ball(Color.PURPLE, Size.XL, 6));
                    add(new Ball(Color.GREY, Size.XXL, 7));
                    add(new Ball(Color.GREY, Size.L, 8));
                    add(new Ball(Color.GREY, Size.M, 9));
                }}, 35}
        };
    }

    @Test(dataProvider = "calculateBallsWeightPositiveData")
    public void calculateBallsWeightPositiveTest(Basket basket, double expected) {
        try {
            double actual = basketService.calculateBallsWeight(basket);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "calculateBallsWeightNegativeData")
    public Object[][] createCalculateBallsWeightNegativeData() {
        return new Object[][]{
                {new BasketCreator().createFillUpBasket(), 13},
                {new Basket(200) {{
                    add(new Ball(Color.RED, Size.XXS, 1));
                    add(new Ball(Color.BLUE, Size.XS, 2));
                    add(new Ball(Color.GREEN, Size.S, 3));
                    add(new Ball(Color.GOLD, Size.M, 4));
                }}, 31},
                {new Basket(200) {{
                    add(new Ball(Color.ORANGE, Size.L, 5));
                    add(new Ball(Color.PURPLE, Size.XL, 6));
                    add(new Ball(Color.GREY, Size.XXL, 7));
                    add(new Ball(Color.GREY, Size.L, 8));
                    add(new Ball(Color.GREY, Size.M, 9));
                }}, 2}
        };
    }

    @Test(dataProvider = "calculateBallsWeightNegativeData")
    public void calculateBallsWeightNegativeTest(Basket basket, double expected) {
        try {
            double actual = basketService.calculateBallsWeight(basket);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void calculateBallsWeightExceptionTest() throws IncorrectDataException {
        Basket basket = null;
        basketService.calculateBallsWeight(basket);
    }
}
