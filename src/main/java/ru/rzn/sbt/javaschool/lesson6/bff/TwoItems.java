package ru.rzn.sbt.javaschool.lesson6.bff;

public class TwoItems<T> {
    private T item1;
    private T item2;

    public TwoItems(T item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public T getItem2() {
        return item2;
    }

    public void setItem2(T item2) {
        this.item2 = item2;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (obj == this) return true;
        if (obj.getClass() != getClass()) return false;
        TwoItems o = (TwoItems)obj;
        return ((item1.equals(o.item1) && item2.equals(o.item2)) || (item1.equals(o.item2) && item2.equals(o.item1)));
    }

    @Override
    public int hashCode() {
        return item1.hashCode() + item2.hashCode();
    }
}
