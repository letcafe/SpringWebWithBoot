package dbTest;

interface Cycle {

    void ride();

}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {

    @Override
    public void ride() {
        System.out.println("uni");
    }


    static void rideCycle(CycleFactory factory) {
        Cycle cycle = factory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
        rideCycle(new TricycleFactory());
    }
}

class UnicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle {

    @Override
    public void ride() {
        System.out.println("Bi");
    }
}

class BicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {

    @Override
    public void ride() {
        System.out.println("Tri");
    }
}

class TricycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}