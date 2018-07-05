package com.spring.source.study.generics.ocean;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.reflect.Array.newInstance;

public class Father<T> {
    private T element;

    public void setT(T arg) {
        element = arg;
    }

    public T getT() {
        return element;
    }
}

class TestClass1<T> extends Father<T> {

}

class TestClass2 extends Father {

}


class OtherInterface<XXX, BVBB省点钱爱仕达> {

    static Class<String> t;

    @SuppressWarnings("unckecked")
    public static void main(String[] args) throws ClassNotFoundException {
        List<String> a = new ArrayList<>();
        List<String> b = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        System.out.println(a instanceof List);
        System.out.println(a instanceof ArrayList);
        System.out.println(a instanceof LinkedList);
        System.out.println(a instanceof Queue);
        System.out.println("+++");
        System.out.println(b instanceof List);
        System.out.println(b instanceof ArrayList);
        System.out.println(b instanceof LinkedList);
        System.out.println(b instanceof Queue);
        System.out.println("+++");
        t.isInstance(a);
    }
}