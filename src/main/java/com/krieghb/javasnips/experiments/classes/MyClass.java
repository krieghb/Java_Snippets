package com.krieghb.javasnips.experiments.classes;

/**
 * Created by krido02 on 1/3/2017.
 *
 */
public class MyClass {

    private int int1;
    private int int2;

    public MyClass(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }


    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClass myClass = (MyClass) o;

        if (int1 != myClass.int1) return false;
        return int2 == myClass.int2;
    }

    @Override
    public int hashCode() {
        int result = int1;
        result = 31 * result + int2;
        return result;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "int1=" + int1 +
                ", int2=" + int2 +
                '}';
    }
}
