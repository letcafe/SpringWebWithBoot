package com.spring.source.study.collections;

public class StringTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class up = Class.forName("com.spring.source.study.collections.Demo2");
        for(Class inter : up.getInterfaces()) {
            System.out.println(inter.getName());
        }
        Demo1 demo1 = (Demo1) up.getSuperclass().newInstance();
        demo1.getIt();
    }

}

interface interface1 { }
interface interface2 { }
interface interface3 { }

class Demo1 {
    String myStr;

    static {
        System.out.println("Demo1");
    }

    public Demo1() {

    }

    public Demo1(String str) {
        this.myStr = str;
    }

    public void getIt() {
        System.out.println("Demo1.getIt() = " + myStr);
    }
}

class Demo2 extends Demo1 implements interface1, interface2, interface3{
    static {
        System.out.println("Demo2");
    }

    public Demo2(String str) {
        super(str);
    }
}
