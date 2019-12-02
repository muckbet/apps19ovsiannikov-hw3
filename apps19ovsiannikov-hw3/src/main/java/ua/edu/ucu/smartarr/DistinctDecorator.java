package ua.edu.ucu.smartarr;

import java.util.*;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    private Object[] parent_arr;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        parent_arr = Arrays.copyOf(smartArray.toArray(), smartArray.size());
    }

    @Override
    public Object[] toArray() {
        Object[] changed_arr = Arrays.stream(smartArray.toArray()).distinct().toArray();
        if (Arrays.equals(parent_arr, changed_arr)) {
            return smartArray.toArray();
        }
        return changed_arr;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + "> DistinctDecorator";
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }
}
