package com.spring.source.study.generics;

interface Performs {
    void sit();

    void speak();
}

class Dogs implements Performs {

    @Override
    public void sit() {
        System.out.println("[dog sits]");
    }

    @Override
    public void speak() {
        System.out.println("[dog speak]");
    }
}

class Cat implements Performs {

    @Override
    public void sit() {
        System.out.println("[cat sits]");
    }

    @Override
    public void speak() {
        System.out.println("[cat speak]");
    }
}

class Communicate {

}

public class DogsAndRobots {

    public static void main(String[] args) {

    }
}
