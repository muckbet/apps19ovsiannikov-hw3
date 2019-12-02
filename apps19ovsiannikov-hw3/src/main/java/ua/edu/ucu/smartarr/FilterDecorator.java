package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate pd;
    private Object[] parent_arr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pd) {
        super(smartArray);
        this.pd = pd;
        parent_arr = Arrays.copyOf(smartArray.toArray(), smartArray.size());
    }

    @Override
    public Object[] toArray() {
        Object[] changed_arr = Arrays.stream(smartArray.toArray()).filter(pd::test).toArray();
        if (Arrays.equals(parent_arr, changed_arr)) {
            return smartArray.toArray();
        }
        return changed_arr;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + "> Filtered Array ";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
