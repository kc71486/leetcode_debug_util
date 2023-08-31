package util;
import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private int cur;
    private final int end;
    private final int step;
    public Range(int start, int end, int step) {
        this.cur = start;
        this.end = end;
        this.step = step;
    }
    public Range(int start, int end) {
        this.cur = start;
        this.end = end;
        this.step = 1;
    }
    public Range(int end) {
        this.cur = 0;
        this.end = end;
        this.step = 1;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new RangeIter();
    }
    private class RangeIter implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return (step >= 0) ? (cur < end) : (cur > end);
        }
        @Override
        public Integer next() {
            int ret = cur;
            cur += step;
            return ret;
        }
    }
    
}
