package com.spring.source.study.generics;

import com.spring.source.study.generics.pets.Cat;
import com.spring.source.study.generics.pets.Dog;
import com.spring.source.study.generics.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckList {

    @SuppressWarnings("unchecked")
    private static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1);
        List<Dog> dog2 = Collections.checkedList(dogs1, Dog.class);
        try {
            oldStyleMethod(dog2);
        } catch (ClassCastException ex) {
            ex.printStackTrace(System.out);
        }

        List<Pet> pets = Collections.checkedList(new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        System.out.println("[Dog added]");
        pets.add(new Cat());
        System.out.println("[Cat added]");
    }


}
