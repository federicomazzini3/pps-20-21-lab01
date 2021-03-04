package lab01.tdd;

public class SelectEqualsStrategy implements SelectStrategy{
    private final int number;

    public SelectEqualsStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean apply(int element) {
        return number == element;
    }
}
