package test.borikov.day3.creator;

import com.borikov.day3.creator.BasketCreator;
import com.borikov.day3.entity.Ball;
import com.borikov.day3.entity.Basket;
import com.borikov.day3.enumtype.Color;
import com.borikov.day3.enumtype.Size;
import com.borikov.day3.exception.IncorrectDataException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketCreatorTest {
    BasketCreator basketCreator;

    @BeforeClass
    public void setUp() {
        basketCreator = new BasketCreator();
    }

    @AfterClass
    public void tearDown() {
        basketCreator = null;
    }

    @DataProvider(name = "createBasketPositiveData")
    public Object[][] createBasketPositiveData() {
        return new Object[][]{
                {5., new Basket(5)},
                {200, new Basket(200)},
                {1., new Basket(1.)}
        };
    }

    @Test(dataProvider = "createBasketPositiveData")
    public void createBasketPositiveTest(double capacity, Basket expected) {
        try {
            Basket actual = basketCreator.createBasket(capacity);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "createBasketNegativeData")
    public Object[][] createBasketNegativeData() {
        return new Object[][]{
                {5., new Basket(3)},
                {200, new Basket(4)},
                {1., new Basket(8.)}
        };
    }

    @Test(dataProvider = "createBasketNegativeData")
    public void createBasketNegativeTest(double capacity, Basket expected) {
        try {
            Basket actual = basketCreator.createBasket(capacity);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "createBasketExceptionData")
    public Object[][] createBasketExceptionData() {
        return new Object[][]{
                {0},
                {-123},
                {201}
        };
    }

    @Test(dataProvider = "createBasketExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void createBasketExceptionTest(
            double capacity) throws IncorrectDataException {
        basketCreator.createBasket(capacity);
    }

    @Test
    public void createFillUpBasketPositiveTest() {
        Basket expected = new Basket(200);
        expected.add(new Ball(Color.RED, Size.XXS, 1));
        expected.add(new Ball(Color.BLUE, Size.XS, 2));
        expected.add(new Ball(Color.GREEN, Size.S, 3));
        expected.add(new Ball(Color.GOLD, Size.M, 4));
        expected.add(new Ball(Color.ORANGE, Size.L, 5));
        expected.add(new Ball(Color.PURPLE, Size.XL, 6));
        expected.add(new Ball(Color.GREY, Size.XXL, 7));
        expected.add(new Ball(Color.GREY, Size.L, 8));
        expected.add(new Ball(Color.GREY, Size.M, 9));
        Basket actual = basketCreator.createFillUpBasket();
        assertEquals(actual, expected);
    }

    @Test
    public void createFillUpBasketNegativeTest() {
        Basket expected = new Basket(200);
        expected.add(new Ball(Color.RED, Size.XXS, 1));
        Basket actual = basketCreator.createFillUpBasket();
        assertNotEquals(actual, expected);
    }
}
