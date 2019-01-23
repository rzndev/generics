package ru.rzn.sbt.javaschool.lesson6.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMapImp<T> implements CountMap<T> {
    private Map<T, Integer> data;

    CountMapImp() {
        data = new HashMap<>();
    }

    @Override
    public void add(T o) {
        if (null == o) throw new NullPointerException();
        if (data.containsKey(o)) {
            data.put(o, data.get(o) + 1);
        } else {
            data.put(o, 1);
        }
    }

    @Override
    public int getCount(T o) {
        if (o == null) throw new NullPointerException();
        if (data.containsKey(o)) {
            return data.get(o);
        }
        return 0;
    }

    @Override
    public int remove(T o) {
        if (null == o) throw new NullPointerException();
        int counts = getCount(o);
        if (counts > 1) {
            data.put(o, counts - 1);
        } else if (counts == 1) {
            data.remove(o);
        }
        return counts;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void addAll(CountMap source) {
        if (null == source) throw new NullPointerException();
       Map<T, Integer> s = source.toMap();
       for(T item : s.keySet()) {
           int counts = getCount(item);
           data.put(item, s.get(item) + counts);
       }
    }

    @Override
    public Map toMap() {
        return data;
    }

    @Override
    public void toMap(Map destination) {
        if (null == destination) throw new NullPointerException();
        if (destination == this.data) return;
        destination.clear();
        destination.putAll(data);
    }
}
