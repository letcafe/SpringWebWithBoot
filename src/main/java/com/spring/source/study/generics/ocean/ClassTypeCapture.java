package com.spring.source.study.generics.ocean;//: generics/ClassTypeCapture.java

import java.util.HashMap;
import java.util.Map;

class Building {

    static int b = 1;
    static int c = 1;


    static {
        System.out.println("b = " + b + ";c = " + c);
    }


}

class House extends Building {
}

public class ClassTypeCapture<T> {
    static Map<String, Class<?>> map = new HashMap<>();

    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    public static Object createNew(String typeName) {
        try {
            return map.get(typeName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T createHouse(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("***");
        Class.forName("com.spring.source.study.generics.ocean.Building");
    }
} /* Output:
true
true
false
true
*///:~
