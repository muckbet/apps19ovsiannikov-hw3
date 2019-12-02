package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private MyFunction mf;
    private Object[] parent_arr;

    public MapDecorator(SmartArray smartArray, MyFunction mf) {
        super(smartArray);
        this.mf = mf;
        parent_arr = Arrays.copyOf(smartArray.toArray(), smartArray.size());
    }

    @Override
    public Object[] toArray() {
        Object[] changed_arr = Arrays.stream(smartArray.toArray()).map(mf::apply).toArray();
        if (Arrays.equals(parent_arr, changed_arr)) {
            return smartArray.toArray();
        }
        return changed_arr;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + "> Map Decorator ";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
