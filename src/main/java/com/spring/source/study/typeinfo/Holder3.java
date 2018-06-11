package com.spring.source.study.typeinfo;//: generics/Holder3.java

import com.spring.source.study.pets.Cat;
import com.spring.source.study.pets.Dog;
import com.spring.source.study.pets.Pet;

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<>(new Pet());
        System.out.println(h3.get().getClass());
        h3.set(new Dog());
        System.out.println(h3.get().getClass());
        System.out.println("***");

        Holder<Pet> holder = new Holder<>(new Dog(), new Cat(), new Dog());
        System.out.println(holder);
        // h3.set("Not an Automobile"); // Error
        // h3.set(1); // Error
    }
} ///:~

class Holder<T> {
    private T a;
    private T b;
    private T c;

    public Holder(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Holder{" +
                "a.getClass.toString()=" + a.getClass().toString() +
                ", b.getClass.toString()=" + b.getClass().toString() +
                ", c.getClass.toString()=" + c.getClass().toString() +
                '}';
    }
}
