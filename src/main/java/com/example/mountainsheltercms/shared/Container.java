package com.example.mountainsheltercms.shared;

import java.util.List;

class Container<T> {
    private List<T> array;

    public List<T> getArray() {
        return array;
    }

    public void setArray(List<T> array) {
        this.array = array;
    }

    public T get(int index) {
        return array.get(index);
    }
}