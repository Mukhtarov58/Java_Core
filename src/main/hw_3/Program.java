package main.hw_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<BaseWorker> workerList = new ArrayList<>();
        workerList.add(new Worker("Bob", 1200));
        workerList.add(new Worker("Jon", 500));
        workerList.add(new Worker("Max", 2000));
        workerList.add(new Freelancer("Mary", 25, 20.5));
        workerList.add(new Freelancer("Anna", 15, 13.2));
        workerList.add(new Freelancer("Ben", 36, 20.5));

        Collections.sort(workerList);
        System.out.println("Sorted by name:");
        printWorkerList(workerList);
    }


public static void printWorkerList(List<BaseWorker> workerList) {
    for (BaseWorker baseWorker : workerList) {
        System.out.println("Employee: " + baseWorker.getName());
        System.out.println("Payment: $" + baseWorker.calculatePayment());
        System.out.println("Monthly Salary: $" + baseWorker.calculateMonthlySalary());
        System.out.println("--------------");
    }
}
}