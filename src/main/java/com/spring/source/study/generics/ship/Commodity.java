package com.spring.source.study.generics.ship;

import com.spring.source.study.generics.ocean.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Commodity {

    private final int id;
    private String description;

    private double price;

    public Commodity(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    public String toString() {
        return id + ": " + description + " price: $" + price;
    }

    public static Generator<Commodity> generator = new Generator<Commodity>() {
        private Random rand = new Random(47);
        @Override
        public Commodity next() {
            return new Commodity(rand.nextInt(1000), " commodity", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
}

class RepoNum extends ArrayList<Commodity> {

    public RepoNum(int nCommodity) {
        Generators.fill(this, Commodity.generator, nCommodity);
    }
}

class Ship extends ArrayList<RepoNum> {
    public Ship(int nRepo, int nCommodity) {
        for(int i = 0; i < nRepo ; i ++) {
            add(new RepoNum(nCommodity));
        }
    }
}

class ShipTeam extends ArrayList<Ship> {
    public ShipTeam(int nShip, int nRepo, int nCommodity) {
        for(int i = 0; i < nShip; i ++) {
            add(new Ship(nRepo, nCommodity));
        }
    }
}

class MyDemo<Toto, ASOJDHAOS> {

}

class Test {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        for(Ship ship : new ShipTeam(14, 5, 11)) {
            result.append("+++Ship++++++++++++++++++++++\n");
            for(RepoNum repoNum : ship) {
                result.append("+++Repo++++\n");
                for(Commodity commodity : repoNum) {
                    result.append(commodity);
                    result.append('\n');
                }
                result.append("+++Repo++++\n");
            }
            result.append("+++Ship++++++++++++++++++++++\n");
        }
        System.out.println(result.toString());

        System.out.println(Arrays.toString(MyDemo.class.getTypeParameters()));
    }
}