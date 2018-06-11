package com.spring.source.study.collections;//: typeinfo/Shapes.java

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    void rotate(Shape shape) {
        if(shape instanceof Circle) {
            System.out.println("[rotate class(" + shape.getClass().getSimpleName() + ")] = " + shape + " can noooooooooooooot start rotating");
            return;
        }
        System.out.println("[rotate class(" + shape.getClass().getSimpleName() + ")] = " + shape + " can start rotating");
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {

    String getIt() {
        System.out.println("Rhomboid");
        return "Rhomboid";
    }

    @Override
    public String toString() {
        return "Rhomboid";
    }
}

public class Shapes {
    public static void main(String[] args) {
        Shape shape = new Rhomboid();
        Shape square = new Square();
        Shape triangle = new Triangle();
        Shape circle = new Circle();

        shape.rotate(shape);
        square.rotate(square);
        triangle.rotate(triangle);
        circle.rotate(circle);

    }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~
