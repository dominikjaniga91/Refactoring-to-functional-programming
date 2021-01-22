package yatzi;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yatzy.chance(new DiceHand(2,3,4,5,1));

        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance(new DiceHand(3, 3, 4, 5, 1)));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.yatzy(new DiceHand(4,4,4,4,4));
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(new DiceHand(6,6,6,6,6)));
        assertEquals(0, Yatzy.yatzy(new DiceHand(6,6,6,6,3)));
    }

    @Test public void test_1s() {
        assertTrue(Yatzy.ones(new DiceHand(1, 2, 3, 4, 5)) == 1);
        assertEquals(2, Yatzy.ones(new DiceHand(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy.ones(new DiceHand(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy.ones(new DiceHand(1, 2, 1, 1, 1)));
    }

    @Test
    public void test_2s() {
        assertEquals(4, Yatzy.twos(new DiceHand(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(new DiceHand(2, 2, 2, 2, 2)));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.threes(new DiceHand(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(new DiceHand(2, 3, 3, 3, 3)));
    }

    @Test
    public void fours_test()
    {
        assertEquals(12, Yatzy.fours(new DiceHand(4,4,4,5,5)));
        assertEquals(8, Yatzy.fours(new DiceHand(4,4,5,5,5)));
        assertEquals(4, Yatzy.fours(new DiceHand(4,5,5,5,5)));
    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.fives(new DiceHand(4,4,4,5,5)));
        assertEquals(15, Yatzy.fives(new DiceHand(4,4,5,5,5)));
        assertEquals(20, Yatzy.fives(new DiceHand(4,5,5,5,5)));
    }

    @Test(dataProvider = "sixesDice")
    public void shouldReturnSumOfSixes(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.sixes(diceHand);

        // then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] sixesDice() {
        return new Object[][] {
                {6 , new DiceHand(1, 4, 2, 5, 6)},
                {12, new DiceHand(4, 3, 6, 3, 6)},
                {18, new DiceHand(6, 3, 4, 6, 6)},
        };
    }


    @Test(dataProvider = "onePairDice")
    public void shouldReturnSumOfPair_whenPlayerThrowOnePair(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.scorePair(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] onePairDice() {
        return new Object[][] {
                {8 , new DiceHand(3, 3, 3, 4, 4)},
                {12, new DiceHand(1, 1, 6, 2, 6)},
                {6 , new DiceHand(3, 3, 3, 4, 1)},
                {6 , new DiceHand(3, 3, 3, 3, 1)},
                {10, new DiceHand(2, 2, 3, 5, 5)},
                {4 , new DiceHand(2, 2, 2, 1, 1)},
        };
    }

    @Test(dataProvider = "noOnePairDice")
    public void shouldReturnZero_whenPlayerDontThrowPair(DiceHand diceHand) {
        //when
        int actual = Yatzy.scorePair(diceHand);

        //then
        Assert.assertEquals(actual, 0);
    }

    @DataProvider
    private Object[] noOnePairDice() {
        return new Object[]{
                new DiceHand(1, 2, 3, 4, 5),
                new DiceHand(5, 4, 3, 2, 1),
        };
    }

    @Test(dataProvider = "twoPairDice")
    public void shouldReturnSumOfPairs_whenPlayerThrowTwoPair(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.twoPair(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] twoPairDice() {
        return new Object[][] {
                {14, new DiceHand(3, 3, 4, 4, 5)},
                {8 , new DiceHand(1, 1, 2, 3, 3)},
                {16, new DiceHand(3, 3, 3, 5, 5)},
                {10, new DiceHand(3, 3, 2, 2, 1)},
                {6 , new DiceHand(2, 1, 1, 2, 2)},
                {10, new DiceHand(3, 1, 1, 4, 4)},
        };
    }

    @Test(dataProvider = "noTwoPairDice")
    public void shouldReturnZero_whenPlayerDontThrowTwoPair(DiceHand diceHand) {
        //given
        int expected = 0;

        //when
        int actual = Yatzy.twoPair(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[] noTwoPairDice() {
        return new Object[] {
                 new DiceHand(3, 3, 4, 1, 5),
                 new DiceHand(1, 1, 2, 1, 3),
                 new DiceHand(3, 3, 3, 3, 5),
                 new DiceHand(3, 3, 2, 3, 1),
                 new DiceHand(2, 1, 5, 4, 2),
                 new DiceHand(3, 1, 2, 4, 4),
        };
    }

    @Test(dataProvider = "threeOfAKindDice")
    public void three_of_a_kind(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.threeOfAKind(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] threeOfAKindDice() {
        return new Object[][] {
                {9 , new DiceHand(3, 3, 3, 4, 5)},
                {15 , new DiceHand(5, 3, 5, 4, 5)},
                {9 , new DiceHand(3, 3, 3, 3, 5)},
                {9 , new DiceHand(3, 3, 3, 3, 3)},
                {6 , new DiceHand(2, 1, 3, 2, 2)},
                {3 , new DiceHand(3, 2, 1, 1, 1)},
                {12 , new DiceHand(3, 4, 4, 4, 4)},
                {15 , new DiceHand(5, 5, 5, 5, 5)},
        };
    }

    @Test(dataProvider = "fourOfAKindDice")
    public void shouldReturnSumOfDice_whenPlayerThrowFourOfAKind(int expected, DiceHand diceHand) {

        //when
        int actual = Yatzy.fourOfAKind(diceHand);

        //them
        assertEquals(actual, expected);
    }


    @DataProvider
    private Object[][] fourOfAKindDice() {
        return new Object[][]{
                {16 ,new DiceHand(1, 4, 4, 4, 4)},
                {4 ,new DiceHand(1, 2, 1, 1, 1)},
                {8 ,new DiceHand(2, 2, 2, 2, 5)},
                {12 ,new DiceHand(3, 3, 2, 3, 3)},
                {20 ,new DiceHand(5, 3, 5, 5, 5)},
                {24 ,new DiceHand(6, 6, 6, 5, 6)},
        };
    }

    @Test(dataProvider = "smallStraightDice")
    public void shouldReturn15_whenPlayerThrowSmallStraight(DiceHand diceHand) {
        //given
        int expected = 15;

        //when
        int actual = Yatzy.smallStraight(diceHand);

        //then
        assertEquals(expected, actual);
    }


    @DataProvider
    private Object[] smallStraightDice() {
        return new Object[]{
                new DiceHand(1, 2, 3, 4, 5),
                new DiceHand(2, 3, 4, 5, 1),
                new DiceHand(2, 4, 1, 3, 5),
                new DiceHand(4, 5, 2, 1, 3),
                new DiceHand(2, 3, 1, 5, 4),
        };
    }

    @Test(dataProvider = "noSmallStraightDice")
    public void shouldReturnZero_whenPlayerDoNotThrowSmallStraight(DiceHand diceHand) {
        //given
        int expected = 0;

        //when
        int actual = Yatzy.smallStraight(diceHand);

        //then
        assertEquals(expected, actual);
    }


    @DataProvider
    private Object[] noSmallStraightDice() {
        return new Object[]{
                new DiceHand(1, 2, 3, 1, 5),
                new DiceHand(2, 3, 2, 5, 1),
                new DiceHand(2, 4, 1, 1, 5),
                new DiceHand(2, 3, 4, 5, 6),
                new DiceHand(2, 3, 1, 2, 2),
        };
    }

    @Test(dataProvider = "largeStraightDice")
    public void largeStraight(DiceHand diceHand) {
        //when
        int expected = 20;

        //given
        int actual = Yatzy.largeStraight(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[] largeStraightDice() {
        return new Object[]{
                new DiceHand(6, 2, 3, 4, 5),
                new DiceHand(6, 3, 2, 5, 4),
                new DiceHand(2, 4, 6, 3, 5),
                new DiceHand(5, 4, 6, 3, 2),
                new DiceHand(3, 2, 6, 5, 4),
        };
    }

    @Test(dataProvider = "noLargeStraightDice")
    public void shouldReturnZero_whenThereIsNoLargeStraight(DiceHand diceHand) {
        //when
        int expected = 0;

        //given
        int actual = Yatzy.largeStraight(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[] noLargeStraightDice() {
        return new Object[]{
                new DiceHand(6, 1, 3, 4, 5),
                new DiceHand(4, 4, 4, 4, 4),
                new DiceHand(2, 4, 6, 3, 3),
                new DiceHand(5, 4, 6, 3, 6),
                new DiceHand(3, 2, 6, 5, 1),
        };
    }


    @Test(dataProvider = "fullHouseDice")
    public void shouldReturnSumOfDice_whenThereIsFullHouse(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.fullHouse(diceHand);

        //then
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] fullHouseDice() {
        return new Object[][]{
                {18 ,new DiceHand(6, 2, 2, 2, 6)},
                {19 ,new DiceHand(3, 3, 3, 5, 5)},
                {14 ,new DiceHand(1, 1, 4, 4, 4)},
                {8  ,new DiceHand(2, 2, 2, 1, 1)},
        };
    }

    @Test(dataProvider = "noFullHouseDice")
    public void shouldReturnZero_whenThereIsNoFullHouse(DiceHand diceHand) {
        //given
        int expected = 0;

        //when
        int actual = Yatzy.fullHouse(diceHand);

        //then
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    private Object[] noFullHouseDice() {
        return new Object[]{
                new DiceHand(6, 1, 2, 2, 6),
                new DiceHand(3, 3, 3, 3, 3),
                new DiceHand(1, 1, 4, 4, 3),
                new DiceHand(2, 2, 5, 1, 1),
                new DiceHand(1, 2, 3, 4, 5),
        };
    }
}
