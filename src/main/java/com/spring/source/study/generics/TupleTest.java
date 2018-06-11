package com.spring.source.study.generics;

public class TupleTest {

    public static void main(String[] args) {
        System.out.println(new SixTuple<>(1,"2", "3", 4, 5.5F, "我才是真正的字符串啊哈哈"));
    }
}

class SixTuple<A, B, C, D ,E, F> {
    public final A a;
    public final B b;
    public final C c;
    public final D d;
    public final E e;
    public final F f;


    public SixTuple(A a, B b, C c, D d, E e, F f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    @Override
    public String toString() {
        return "SixTuple{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                '}';
    }
}
