package lab01.tdd;

public class SelectStrategyFactory {

    public SelectStrategy even(){
        return new SelectEvenStrategy();
    }

    public SelectStrategy multipleOf(int number){
        return new SelectMultipleOfStrategy(number);
    }

    public SelectStrategy equalsOf(int number) {
        return new SelectEqualsStrategy(number);
    }
}
