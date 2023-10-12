package CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class P2CompanyRoster {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> roster = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            Employee employee;

            if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (input.length == 5) {
                if (input[4].contains("@")) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else {
                String email = input[4];
                int age = Integer.parseInt(input[5]);

                employee = new Employee(name, salary, position, department, email, age);
            }

            roster.add(employee);

        }

        Map.Entry<String, List<Employee>> highestPaidDep = roster.stream().collect(Collectors
                        .groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    double e1AvgSalary = e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    double e2AvgSalary = e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();

                    return Double.compare(e2AvgSalary, e1AvgSalary);
                })
                .findFirst()
                .orElse(null);

        System.out.printf("Highest Average Salary: %s%n", highestPaidDep.getKey());
        highestPaidDep.getValue().stream()
                .sorted((e1, e2) -> {
                    return Double.compare(e2.getSalary(), e1.getSalary());
                })
                .forEach(System.out::println);


    }
}
