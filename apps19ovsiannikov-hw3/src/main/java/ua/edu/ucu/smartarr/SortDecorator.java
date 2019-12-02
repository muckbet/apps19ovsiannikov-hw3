package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private MyComparator mc;
    private Object[] parent_arr;

    public SortDecorator(SmartArray smartArray, MyComparator mc) {
        super(smartArray);
        this.mc = mc;
        parent_arr = Arrays.copyOf(smartArray.toArray(), smartArray.size());
    }

    @Override
    public Object[] toArray() {
        Object[] changed_arr = Arrays.stream(smartArray.toArray()).sorted(mc::compare).toArray();
        if (Arrays.equals(parent_arr, changed_arr)) {
            return smartArray.toArray();
        }
        return changed_arr;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + "> SortDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
