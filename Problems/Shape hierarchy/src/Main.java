import java.util.Map;

abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    private final double lengthOne;
    private final double lengthTwo;
    private final double lengthThree;

    public Triangle(final double lengthOne, final double lengthTwo, final double lengthThree) {
        this.lengthOne = lengthOne;
        this.lengthTwo = lengthTwo;
        this.lengthThree = lengthThree;
    }

    @Override
    double getPerimeter() {
        return lengthOne + lengthTwo + lengthThree;
    }

    @Override
    double getArea() {
        final double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - lengthOne) * (semiPerimeter - lengthTwo) * (semiPerimeter - lengthThree));
    }
}

class Rectangle extends Shape {

    private final double lengthOne;
    private final double lengthTwo;

    public Rectangle(double lengthOne, double lengthTwo) {
        this.lengthOne = lengthOne;
        this.lengthTwo = lengthTwo;
    }

    @Override
    double getPerimeter() {
        return (lengthOne + lengthTwo) * 2;
    }

    @Override
    double getArea() {
        return lengthOne * lengthTwo;
    }
}

class Circle extends Shape {

    private final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return Math.PI * (radius * 2);
    }

    @Override
    double getArea() {
        return Math.PI * (Math.pow(radius, 2));
    }
}