package ru.hse.lupuleac;

public class CovariantReturnTypeExample {
    class Shape {}
    class Circle extends Shape {}

    class ShapeFactory {
        public Shape newShape() {
            return new Shape();
        }
    }

    class CircleFactory extends ShapeFactory {
        public Circle newShape() {
            return new Circle();
        }
    }

    class SuperClass {
        SuperClass get() {
            System.out.println("SuperClass");
            return this;
        }
    }

    public class SubClass extends SuperClass {
        SubClass get() {
            System.out.println("SubClass");
            return this;
        }
    }

    public void example() {
        SuperClass tester = new SubClass();
        tester.get();
    }
}
