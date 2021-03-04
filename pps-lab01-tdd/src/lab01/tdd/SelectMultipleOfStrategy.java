package lab01.tdd;

public class SelectMultipleOfStrategy implements SelectStrategy{
    private final int number;

    public SelectMultipleOfStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean apply(int element) {
        return element % number == 0;
    }
}
