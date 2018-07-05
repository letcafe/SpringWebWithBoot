package com.spring.source.study.generics;


import com.spring.source.study.Holder;

import java.util.*;

interface interfaceA {

}

interface interfaceB{

}

class Father {

}

class DerivedClass extends Father implements interfaceA, interfaceB {

    public <T extends interfaceA> void getA(T t) {
        System.out.println(t.toString());
    }

    public <T extends interfaceB> void getB(T t) {
        System.out.println(t.toString());
    }
}

public class MyTest {

    MyTest() {

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder<Byte> byteHolder = new Holder<>();
        Holder<Integer> integerHolder = new Holder<>();
        Holder<Long> longHolder = new Holder<>();
        Holder<Float> floatHolder = new Holder<>();
        Holder<Double> doubleHolder = new Holder<>();
        Holder<Boolean> booleanHolder = new Holder<>();
        Holder<Short> shortHolder = new Holder<>();
        Holder<Character> characterHolder = new Holder<>();

        byteHolder.set((byte) 1);
        integerHolder.set(12);
        longHolder.set(12L);
        floatHolder.set(13F);
        doubleHolder.set(13.1);
        booleanHolder.set(true);
        shortHolder.set((short) 12);
        characterHolder.set('c');

        System.out.println(byteHolder.get());
        System.out.println(integerHolder.get());
        System.out.println(longHolder.get());
        System.out.println(floatHolder.get());
        System.out.println(doubleHolder.get());
        System.out.println(booleanHolder.get());
        System.out.println(shortHolder.get());
        System.out.println(characterHolder.get());
    }

    @SuppressWarnings("unchecked")
    public static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getName());
        return t;
    }

    @SuppressWarnings("unchecked")
    public static void getIt(Holder<List<?>> myHolder) {
        myHolder.set(Collections.singletonList("123"));
        Holder<?> holder = new Holder(12);
        System.out.println("[List] = " + myHolder.get());
    }
}

