package P4CarSalesman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Engine engine;
        List<Engine> engines = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if (tokens.length == 4) {
                engine = new Engine(model, power, Integer.parseInt(tokens[2]), tokens[3]);
            } else if (tokens.length == 3) {
                char firstChar = tokens[2].charAt(0);

                if (firstChar < 58) {
                    engine = new Engine(model, power, Integer.parseInt(tokens[2]));
                } else {
                    engine = new Engine(model, power, tokens[2]);
                }
            } else {
                engine = new Engine(model, power);
            }

            engines.add(engine);

        }

        n = Integer.parseInt(scanner.nextLine());

        Car car;
        List<Car> cars = new LinkedList<>();


        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            String model = line[0];
            String engineType = line[1];
            Engine currentEngine = null;

            if (line.length == 4) {
                int weight = Integer.parseInt(line[2]);
                String color = line[3];

                currentEngine = checkForEngine(engines, engineType, currentEngine);

                car = new Car(model, currentEngine, weight, color);
            } else if (line.length == 3) {
                char firstChar = line[2].charAt(0);

                if (firstChar < 58) {
                    int weight = Integer.parseInt(line[2]);

                    currentEngine = checkForEngine(engines, engineType, currentEngine);

                    car = new Car(model, currentEngine, weight);
                } else {
                    String color = line[2];

                    currentEngine = checkForEngine(engines, engineType, currentEngine);

                    car = new Car(model, currentEngine, color);
                }
            } else {

                currentEngine = checkForEngine(engines, engineType, currentEngine);

                car = new Car(model, currentEngine);
            }

            cars.add(car);
        }

        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i));
        }
    }

    private static Engine checkForEngine(List<Engine> engines, String engineType, Engine currentEngine) {
        for (int i = 0; i < engines.size(); i++) {
            if (engines.get(i).getModel().equals(engineType)) {
                currentEngine = engines.get(i);
            }
        }
        return currentEngine;
    }
}
