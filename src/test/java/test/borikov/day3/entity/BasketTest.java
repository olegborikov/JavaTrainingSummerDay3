package test.borikov.day3.entity;

import com.borikov.day3.entity.Ball;
import com.borikov.day3.entity.Basket;
import com.borikov.day3.enumtype.Color;
import com.borikov.day3.enumtype.Size;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketTest {
    @DataProvider(name = "addPositiveData")
    public Object[][] createAddPositiveData() {
        return new Object[][]{
                {new Basket(20), new Ball(Color.BLACK, Size.S, 1)},
                {new Basket(30), new Ball(Color.GREY, Size.M, 2.5)},
                {new Basket(5), new Ball(Color.YELLOW, Size.XS, 10)},
        };
    }

    @Test(dataProvider = "addPositiveData")
    public void addPositiveTest(Basket basket, Ball ball) {
        boolean actual = basket.add(ball);
        assertTrue(actual);
    }

    @DataProvider(name = "addNegativeData")
    public Object[][] createAddNegativeData() {
        return new Object[][]{
                {new Basket(100), null},
                {new Basket(20), new Ball(Color.GREY, Size.XL, 2.5)},
                {new Basket(25), new Ball(Color.GREY, Size.XXL, 3.7)}
        };
    }

    @Test(dataProvider = "addNegativeData")
    public void addNegativeTest(Basket basket, Ball ball) {
        boolean actual = basket.add(ball);
        assertFalse(actual);
    }

    @DataProvider(name = "calculateBusyCapacityPositiveData")
    public Object[][] creatCalculateBusyCapacityPositiveData() {
        return new Object[][]{
                {new Basket(100) {{
                    add(new Ball(Color.RED, Size.XXS, 1));
                    add(new Ball(Color.BLUE, Size.XS, 2));
                    add(new Ball(Color.GREEN, Size.S, 3));
                    add(new Ball(Color.GOLD, Size.M, 4));
                }}, 31},
                {new Basket(15) {{
                    add(new Ball(Color.GOLD, Size.M, 4));
                }}, 15},
                {new Basket(100) {{
                    add(new Ball(Color.GREY, Size.XXL, 7));
                    add(new Ball(Color.GREY, Size.L, 8));
                    add(new Ball(Color.GREY, Size.M, 9));
                }}, 65},
        };
    }

    @Test(dataProvider = "calculateBusyCapacityPositiveData")
    public void calculateBusyCapacityPositiveTest(Basket basket, double expected) {
        double actual = basket.calculateBusyCapacity();
        assertEquals(actual, expected);
    }

    @DataProvider(name = "calculateBusyCapacityNegativeData")
    public Object[][] creatCalculateBusyCapacityNegativeData() {
        return new Object[][]{
                {new Basket(100) {{
                    add(new Ball(Color.RED, Size.XXS, 1));
                }}, 12},
                {new Basket(15) {{
                    add(new Ball(Color.GOLD, Size.M, 4));
                }}, 32},
                {new Basket(100) {{
                    add(new Ball(Color.GREY, Size.XXL, 7));
                    add(new Ball(Color.GREY, Size.L, 8));
                    add(new Ball(Color.GREY, Size.M, 9));
                }}, 14},
        };
    }

    @Test(dataProvider = "calculateBusyCapacityNegativeData")
    public void calculateBusyCapacityNegativeTest(Basket basket, double expected) {
        double actual = basket.calculateBusyCapacity();
        assertNotEquals(actual, expected);
    }
}
