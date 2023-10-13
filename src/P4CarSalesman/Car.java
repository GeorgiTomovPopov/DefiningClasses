package P4CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    @Override
    public String toString() {
        String weightAsString = String.valueOf(weight);
        if (weightAsString.equals("0")) {
            weightAsString = "n/a";
        }
        return String.format("%s:%n" + this.engine.toString() + "Weight: %s%nColor: %s%n", model, weightAsString, color);
    }


    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        setModel(model);
        setEngine(engine);
        setWeight(weight);
        setColor(color);
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

    public void setEngine(Engine engine) {


        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
