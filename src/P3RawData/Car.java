package P3RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;

    public Car(String model, int speed, int power, int weight, String type, double pressure1, int age1, double pressure2, int age2, double pressure3, int age3, double pressure4, int age4) {
        setModel(model);
        setEngine(speed, power);
        setCargo(weight, type);
        setTire1(pressure1, age1);
        setTire2(pressure2, age2);
        setTire3(pressure3, age3);
        setTire4(pressure4, age4);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(int speed, int power) {
        this.engine = new Engine(speed, power);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(int weight, String type) {
        this.cargo = new Cargo(weight, type);
    }

    public Tire getTire1() {
        return tire1;
    }

    public void setTire1(double pressure1, int age1) {
        this.tire1 = new Tire(pressure1, age1);
    }

    public Tire getTire2() {
        return tire2;
    }

    public void setTire2(double pressure2, int age2) {
        this.tire2 = new Tire(pressure2, age2);
    }

    public Tire getTire3() {
        return tire3;
    }

    public void setTire3(double pressure3, int age3) {
        this.tire3 = new Tire(pressure3, age3);
    }

    public Tire getTire4() {
        return tire4;
    }

    public void setTire4(double pressure4, int age4) {
        this.tire4 = new Tire(pressure4, age4);
    }
}
