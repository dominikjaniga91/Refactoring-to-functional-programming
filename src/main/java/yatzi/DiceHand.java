package yatzi;

import java.util.Iterator;
import java.util.stream.IntStream;

public class DiceHand implements Iterable<Integer> {

    private final int[] dice;

    public DiceHand(int d1, int d2, int d3, int d4, int d5) {
        this.dice = new int[]{d1, d2, d3, d4, d5};
    }

    @Override
    public Iterator<Integer> iterator() {
        return IntStream.of(dice).boxed().iterator();
    }
}
