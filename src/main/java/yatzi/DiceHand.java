package yatzi;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class DiceHand implements Iterable<Integer> {

    private final int[] dice;

    public DiceHand(int d1, int d2, int d3, int d4, int d5) {
        this.dice = new int[]{d1, d2, d3, d4, d5};
    }

    public int sumValues(int value) {
        return stream().filter(i -> i == value)
                .reduce(0, Integer::sum);
    }

    public int sumValues() {
        return stream().reduce(0, Integer::sum);
    }

    public int sumOfDistinctValues() {
        return stream().distinct().reduce(0, Integer::sum);
    }

    @Override
    public Iterator<Integer> iterator() {
        return stream().iterator();
    }

    Stream<Integer> stream() {
        return IntStream.of(dice).boxed();
    }

    public Map<Integer, Long> getFrequencyMap() {
        return stream().collect(groupingBy(identity(), counting()));
    }
}
