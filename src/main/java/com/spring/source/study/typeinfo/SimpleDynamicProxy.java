package com.spring.source.study.typeinfo;//: typeinfo/SimpleDynamicProxy.java

import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    private static int invokeDoTimes = 0;
    private static int invokeDoElseTimes = 0;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object
    invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() +
                ", method: " + method + ", args: " + args);
        if (args != null)
            for (Object arg : args)
                System.out.println("  " + arg);
        switch(method.getName()) {
            case "doSomething":invokeDoTimes ++;break;
            case "somethingElse":invokeDoElseTimes ++;break;
        }
        System.out.println("[proxy] = " + proxy.hashCode());
        return method.invoke(proxied, args);
    }

    static void getInvokeTimes() {
        System.out.format("%-100.100s\n", " + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + ");
        System.out.format("%-49.49s%s", " + [invokeDoTimes] = " + invokeDoTimes, "+");
        System.out.format("%-49.49s%s\n", " [invokeDoElseTimes] = " + invokeDoElseTimes, "+");
        System.out.format("%-100.100s\n", " + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + ");
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
        DynamicProxyHandler.getInvokeTimes();
    }
} /* Output: (95% match)	
doSomething
somethingElse bonobo
**** proxy: class $Proxy0, method: public abstract void Interface.doSomething(), args: null
doSomething
**** proxy: class $Proxy0, method: public abstract void Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
  bonobo
somethingElse bonobo
*///:~
