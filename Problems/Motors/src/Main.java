import java.util.Scanner;

/* Product - Motor */
abstract class Motor {

    String model;
    long power;

    public Motor(String model, long power) {
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return "motor={model:" + model + ",power:" + power + "}";
    }
}

class PneumaticMotor extends Motor {
    public PneumaticMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Pneumatic " + super.toString();
    }
}

class HydraulicMotor extends Motor {
    public HydraulicMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Hydraulic " + super.toString();
    }
}

class ElectricMotor extends Motor {
    public ElectricMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Electric " + super.toString();
    }
}

class WarpDrive extends Motor {
    public WarpDrive(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Warp " + super.toString();
    }
}

class MotorFactory {

    /**
     * It returns an initialized motor according to the specified type by the first character:
     * 'P' or 'p' - pneumatic, 'H' or 'h' - hydraulic, 'E' or 'e' - electric, 'W' or 'w' - warp.
     */
    public static Motor make(char type, String model, long power) {
        if ("p".equalsIgnoreCase(Character.toString(type))) {
            return new PneumaticMotor(model, power);

        } else if ("h".equalsIgnoreCase(Character.toString(type))) {
            return new HydraulicMotor(model, power);

        } else if ("e".equalsIgnoreCase(Character.toString(type))) {
            return new ElectricMotor(model, power);

        } else if ("w".equalsIgnoreCase(Character.toString(type))){
            return new WarpDrive(model, power);

        } else {
            return  null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final char type = scanner.next().charAt(0);     
        final String model = scanner.next();
        final long power = scanner.nextLong();
        Motor motor = MotorFactory.make(type, model, power);
        scanner.close();
       System.out.println(motor);
    }
}