package com.spring.source.study.generics;

interface GenericsGetter<T extends GenericsGetter<T>> {
    T get();
}

interface Getter extends GenericsGetter<Getter> {

}

public class GenericsAndReturnTypes {
    public static void main(String[] args) {
    }
}
