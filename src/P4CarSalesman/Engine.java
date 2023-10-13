package P4CarSalesman;

public class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    @Override
    public String toString() {
        String displacementAsString = String.valueOf(displacement);
        if (displacementAsString.equals("0")){
            displacementAsString = "n/a";
        }
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%n", model, power, displacementAsString, efficiency);
    }

    public Engine(String model, int power) {
        this(model, power , 0, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power , displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power , 0, efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        setModel(model);
        setPower(power);
        setDisplacement(displacement);
        setEfficiency(efficiency);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
