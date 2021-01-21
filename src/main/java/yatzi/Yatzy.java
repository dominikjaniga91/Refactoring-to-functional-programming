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
    public static int smallStraight1(DiceHand diceHand) {

        Set<Integer> set = diceHand.stream().collect(toSet());
        if(Set.of(1,2,3,4,5).equals(set)) {
            return 15;
        }
        return 0;
    }

    // Victor refactor
    public static int smallStraight(DiceHand diceHand) {

        List<Integer> sorted = diceHand.stream().sorted().collect(toList());
        if(Arrays.asList(1,2,3,4,5).equals(sorted)) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(DiceHand diceHand) {
        Set<Integer> set = diceHand.stream().collect(toSet());
        if(Set.of(2,3,4,5,6).equals(set)) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(DiceHand diceHand) {

        Map<Integer, Long> collect = diceHand.getFrequencyMap();
        boolean twoAndThreeOfKind = collect.values().stream()
                .allMatch(v -> v == 2 || v == 3);

        return twoAndThreeOfKind ? diceHand.sumValues() : 0;
    }
}

