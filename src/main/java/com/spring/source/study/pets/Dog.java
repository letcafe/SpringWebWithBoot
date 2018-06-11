//: typeinfo/pets/Dog.java
package com.spring.source.study.pets;

public class Dog extends Pet {
  public Dog(String name) { super(name); }
  public Dog() { super(); }

  @Override
  public String toString() {
    return "Dog{" +
            "name='" + name + '\'' +
            '}';
  }
} ///:~
