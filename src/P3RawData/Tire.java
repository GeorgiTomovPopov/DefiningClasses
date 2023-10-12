package P3RawData;

public class Tire {

    private double pressure;
    private int age;

    public Tire(double pressure, int tireAge) {
        setPressure(pressure);
        setAge(tireAge);
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
