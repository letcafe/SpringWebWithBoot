package com.spring.source.study.generics.ocean;//: generics/FactoryConstraint.java

interface FactoryI<T> {
    T create(T name);
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create(x);
    }
    // ...
}

class IntegerFactory implements FactoryI<Integer> {
    public Integer create(Integer name) {
        return new Integer(0);
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        public Widget create(Widget name) {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
} ///:~
