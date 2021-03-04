package lab01.tdd;

public class SelectEvenStrategy implements SelectStrategy{

    @Override
    public boolean apply(int number) {
        return number % 2 == 0;
    }
}
