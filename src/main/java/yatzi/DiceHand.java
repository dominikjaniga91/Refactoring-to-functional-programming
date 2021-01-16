package yatzi;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DiceHand implements Iterable<Integer> {

    private final int[] dice;

    public DiceHand(int d1, int d2, int d3, int d4, int d5) {
        this.dice = new int[]{d1, d2, d3, d4, d5};
    }

    public Integer sumValues(int value) {
        return stream()
                .filter(i -> i == value)
                .reduce(0, Integer::sum);
    }

    @Override
    public Iterator<Integer> iterator() {
        return stream().iterator();
    }

    Stream<Integer> stream() {
        return IntStream.of(dice).boxed();
    }
}
