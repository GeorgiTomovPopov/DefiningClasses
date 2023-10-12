package P3RawData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new LinkedList();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String type = tokens[4];
            double pressure1 = Double.parseDouble(tokens[5]);
            int age1 = Integer.parseInt((tokens[6]));
            double pressure2 = Double.parseDouble(tokens[7]);
            int age2 = Integer.parseInt((tokens[8]));
            double pressure3 = Double.parseDouble(tokens[9]);
            int age3 = Integer.parseInt((tokens[10]));
            double pressure4 = Double.parseDouble(tokens[11]);
            int age4 = Integer.parseInt((tokens[12]));

            Car car = new Car(model, speed, power, weight, type, pressure1, age1, pressure2, age2, pressure3, age3, pressure4, age4);

            cars.add(car);
        }

        String condition = scanner.nextLine();
        List<Car> filteredList = new LinkedList<>();

        switch (condition) {
            case "fragile":
                filteredList = cars.stream()
                        .filter(car -> car.getCargo().getType().equals("fragile") && (car.getTire1().getPressure() < 1 || car.getTire2().getPressure() < 1 || car.getTire3().getPressure() < 1 || car.getTire4().getPressure() < 1))
                        .collect(Collectors.toList());
                break;
            case "flamable":
                filteredList = cars.stream()
                        .filter(car -> car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250)
                        .collect(Collectors.toList());
                break;
        }

        filteredList.forEach(car -> System.out.println(car.getModel()));
    }
}
