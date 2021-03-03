package allexamples;

public class TestInheritance {


    public class One {

        public void print() {
            System.out.println("I am from A");
        }
    }

    public class Three extends One {

        public void print() {
            System.out.println("I am from B");
        }
    }

    public class C extends Three {

        public void print() {
            System.out.println("I am from C");
        }
    }

    public class Five extends Three {

        public void print() {
            System.out.println("I am from D");
        }
    }

    void test(){
        Three three = new Five();
        three.print();
    }



    public static void main(String[] args) {
        TestInheritance t = new TestInheritance();
        t.test();


    }
}
