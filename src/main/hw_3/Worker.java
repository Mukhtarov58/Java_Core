package main.hw_3;

public class Worker extends BaseWorker {
    private double fixedSalary;

    public Worker(String name, double fixedSalary) {
        super(name, 0);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateMonthlySalary() {
        return fixedSalary;
    }
    public double calculatePayment(){
        return fixedSalary;
    }
}
