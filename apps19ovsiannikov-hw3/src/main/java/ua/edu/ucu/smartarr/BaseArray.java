package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] arr;

    public BaseArray(Object[] arr1) {
        this.arr = arr1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, arr.length);
    }

    @Override
    public String operationDescription() {
        return "> This is Base Array ";
    }

    @Override
    public int size() {
        return arr.length;
    }

    public void setValue(int i) {
        arr[i] = 0;
    }
}
