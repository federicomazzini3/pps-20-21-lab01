package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> circularList;
    private int indexCircularList;

    public CircularListImpl() {
        this.circularList = new ArrayList<>();
        this.indexCircularList = -1;
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    private Optional<Integer> getValueOrEmpty() {
        return isEmpty()
                ? Optional.empty()
                : Optional.of(circularList.get(indexCircularList));
    }

    @Override
    public Optional<Integer> next() {
        indexCircularList++;
        if (indexCircularList >= circularList.size())
            indexCircularList = 0;
        return getValueOrEmpty();
    }

    @Override
    public Optional<Integer> previous() {
        indexCircularList--;
        if (indexCircularList < 0)
            indexCircularList = circularList.size() - 1;
        return getValueOrEmpty();
    }

    @Override
    public void reset() {
        this.indexCircularList = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        for(int i = 0; i < circularList.size(); i++){
            if(strategy.apply(this.next().get()))
                return Optional.of(circularList.get(indexCircularList));
        }
        return Optional.empty();
    }
}
