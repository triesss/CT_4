package coverage;

public class Pair {
    int indexFirst;
    int indexSecond;
    int column;

    public Pair(int indexFirst, int indexSecond, int column) {
        this.indexFirst = indexFirst;
        this.indexSecond = indexSecond;
        this.column = column;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair pair) {
            return this.column == pair.column;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.column;
    }
}
