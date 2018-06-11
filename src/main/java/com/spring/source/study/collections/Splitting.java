package com.spring.source.study.collections;//: strings/Splitting.java

import java.util.*;

public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void split(String regex) {
        System.out.println(
                Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextDouble();
        scanner.nextDouble();
        scanner.nextDouble();
        System.out.println("*** " + scanner.nextLine() + " ***");
    }
} /* Output:
[Then,, when, you, have, found, the, shrubbery,, you, must, cut, down, the, mightiest, tree, in, the, forest..., with..., a, herring!]
[Then, when, you, have, found, the, shrubbery, you, must, cut, down, the, mightiest, tree, in, the, forest, with, a, herring]
[The, whe, you have found the shrubbery, you must cut dow, the mightiest tree i, the forest... with... a herring!]
*///:~
