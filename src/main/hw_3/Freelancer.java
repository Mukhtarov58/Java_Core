package main.hw_3;

public class Freelancer extends BaseWorker{
    private double hourlyRate;

    public Freelancer(String name, int hoursWorked, double hourlyRate) {
        super(name, hoursWorked);
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }
    @Override
    public double calculatePayment() {
        return getHoursWorked() * hourlyRate;
    }
}
