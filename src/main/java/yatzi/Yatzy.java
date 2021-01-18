package yatzi;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Yatzy {

    public static int chance(DiceHand diceHand) {
        return diceHand.stream().mapToInt(i -> i).sum();
    }

    public static int yatzy(DiceHand dice) {
        boolean allTheSame = dice.stream().distinct().count() == 1;
        return allTheSame ? 50 : 0;
    }

    public static int ones(DiceHand diceHand) {
        return diceHand.sumValues(1);
    }

    public static int twos(DiceHand diceHand) {
        return diceHand.sumValues(2);
    }

    public static int threes(DiceHand diceHand) {
        return diceHand.sumValues(3);
    }

    public static int fours(DiceHand diceHand) {
        return diceHand.sumValues(4);
    }

    public static int fives(DiceHand diceHand) {
        return diceHand.sumValues(5);
    }

    public static int sixes(DiceHand diceHand) {
        return diceHand.sumValues(6);
    }

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int _5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    public static int score_pair(DiceHand diceHand) {

        Map<Integer, Long> collect = diceHand.getFrequencyMap();

        OptionalInt dieMax = collect.entrySet().stream()
                .filter(e -> e.getValue() >= 2)
                .mapToInt(Map.Entry::getKey).max();

        return dieMax.orElse(0) * 2;
    }

    public static int two_pair(DiceHand diceHand) {

        Map<Integer, Long> counts = diceHand.getFrequencyMap();

        List<Integer> twoDiceOrMore = counts.entrySet().stream()
                .filter(e -> e.getValue() >= 2).map(Map.Entry::getKey)
                .collect(toList());

        if (twoDiceOrMore.size() != 2) {
            return 0;
        }
        return twoDiceOrMore.stream().mapToInt(Integer::intValue).sum() * 2;
    }

    public static int four_of_a_kind(DiceHand diceHand) {

        Map<Integer, Long> counts = diceHand.getFrequencyMap();
        int die = getDieFrequency(counts, 4);
        return die * 4;
    }

    public static int three_of_a_kind(DiceHand diceHand) {

        Map<Integer, Long> counts = diceHand.getFrequencyMap();
        int die = getDieFrequency(counts, 3);
        return die * 3;
    }

    private static Integer getDieFrequency(Map<Integer, Long> counts, int frequency) {
        return counts.entrySet().stream()
                .filter(e -> e.getValue() >= frequency)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    // my refactor
    public static int smallStraight(DiceHand diceHand) {

        Set<Integer> set = diceHand.stream().collect(toSet());
        int sumOfDice = set.stream().reduce(0, Integer::sum);
        return sumOfDice == 15 ? 15 : 0;
    }

    // my refactor
    public static int smallStraightWithDistinct(DiceHand diceHand) {
        int sumOfDice = diceHand.stream().distinct().reduce(0, Integer::sum);
        return sumOfDice == 15 ? 15 : 0;
    }

    // Victor refactor
    public static int smallStraightVictor(DiceHand diceHand) {

        List<Integer> sorted = diceHand.stream().sorted().collect(toList());
        if(Arrays.asList(1,2,3,4,5).equals(sorted)) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



