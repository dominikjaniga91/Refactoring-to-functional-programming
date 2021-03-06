package yatzi;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test(dataProvider = "chanceDice")
    public void shouldReturnSumOfDice_whenPlayerThrowChance(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.chance(diceHand);


        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] chanceDice() {
        return new Object[][] {
                {8 ,new DiceHand(1, 2, 1, 3, 1)},
                {15,new DiceHand(5, 4, 3, 2, 1)},
                {14,new DiceHand(1, 3, 3, 2, 5)},
                {18,new DiceHand(1, 2, 3, 6, 6)},
                {14,new DiceHand(2, 3, 1, 4, 4)},
                {21,new DiceHand(6, 1, 6, 2, 6)},
        };
    }

    @Test(dataProvider = "yatzyDice")
    public void shouldReturn50_whenPlayerThrowYatzy(DiceHand diceHand) {
        //given
        int expected = 50;

        //when
        int actual = Yatzy.yatzy(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[] yatzyDice() {
        return new Object[] {
                new DiceHand(1, 1, 1, 1, 1),
                new DiceHand(2, 2, 2, 2, 2),
                new DiceHand(3, 3, 3, 3, 3),
                new DiceHand(4, 4, 4, 4, 4),
                new DiceHand(5, 5, 5, 5, 5),
                new DiceHand(6, 6, 6, 6, 6),
        };
    }

    @Test(dataProvider = "noYatzyDice")
    public void shouldReturnZero_whenPlayerDontThrowYatzy(DiceHand diceHand) {
        //give
        int expected = 0;

        //when
        int actual = Yatzy.yatzy(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[] noYatzyDice() {
        return new Object[] {
                new DiceHand(1, 2, 1, 1, 1),
                new DiceHand(2, 2, 3, 2, 2),
                new DiceHand(3, 3, 4, 3, 3),
                new DiceHand(4, 5, 4, 4, 4),
                new DiceHand(5, 5, 6, 5, 5),
                new DiceHand(6, 6, 6, 1, 6),
        };
    }

    @Test(dataProvider = "onesDice")
    public void shouldReturnSumOfOnes(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.ones(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] onesDice() {
        return new Object[][] {
                {1 ,new DiceHand(1, 2, 3, 4, 5)},
                {2 ,new DiceHand(1, 2, 1, 4, 5)},
                {0 ,new DiceHand(6, 2, 2, 4, 5)},
                {4 ,new DiceHand(1, 2, 1, 1, 1)},
        };
    }

    @Test(dataProvider = "twosDice")
    public void shouldReturnSumOfTwos(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.twos(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] twosDice() {
        return new Object[][] {
                {4 ,new DiceHand(1, 2, 3, 2, 6)},
                {10,new DiceHand(2, 2, 2, 2, 2)},
                {6 ,new DiceHand(2, 2, 1, 2, 3)},
        };
    }

    @Test(dataProvider = "threesDice")
    public void shouldReturnSumOfThrees(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.threes(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] threesDice() {
        return new Object[][] {
                {6 ,new DiceHand(1, 2, 3, 2, 3)},
                {12 ,new DiceHand(2, 3, 3, 3, 3)},
                {9 ,new DiceHand(2, 3, 1, 3, 3)},
        };
    }

    @Test(dataProvider = "foursDice")
    public void shouldReturnSumOfFours(int expected, DiceHand diceHand) {
       //when
        int actual = Yatzy.fours(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] foursDice() {
        return new Object[][] {
                {12,new DiceHand(4,4,4,5,5)},
                {8, new DiceHand(4,4,5,5,5)},
                {4, new DiceHand(4,5,5,5,5)},
        };
    }

    @Test(dataProvider = "fivesDice")
    public void shouldReturnSumOfFives(int expected, DiceHand diceHand) {
        //when
        int actual = Yatzy.fives(diceHand);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] fivesDice() {
        return new Object[][] {
                {10 , new DiceHand(1, 5, 2, 5, 6)},
                {15, new DiceHand(4, 5, 6, 5, 5)},
                {20, new DiceHand(5, 3, 5, 5, 5)},
        };
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
