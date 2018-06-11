package dbTest;//: exceptions/Human.java
// Catching exception hierarchies.

class Annoyance extends RuntimeException {}
class Sneeze extends Annoyance {}

public class Human {
  public static void main(String[] args) {
    // Catch the exact type:
    try {
      throw new RuntimeException();
    } catch(Sneeze s) {
      System.out.println("Caught Sneeze");
    } catch(Annoyance a) {
      System.out.println("Caught Annoyance");
    } catch(RuntimeException a) {
      System.out.println("Caught RuntimeException");
    }
    // Catch the base type:
    try {
      throw new Sneeze();
    } catch(Annoyance a) {
      System.out.println("Caught Annoyance");
    }  catch(RuntimeException a) {
      System.out.println("Caught RuntimeException");
    }
  }
} /* Output:
Caught Sneeze
Caught Annoyance
*///:~
