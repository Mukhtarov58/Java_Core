package main.hw_3;

public abstract class BaseWorker implements Comparable<BaseWorker>{
    protected String name;

    protected int hoursWorked;

    public String getName() {
        return name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public BaseWorker(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    public abstract double calculateMonthlySalary();

    public double calculatePayment() {
        return 0;
    }
    @Override
    public int compareTo(BaseWorker otherWorker) {
        return this.getName().compareTo(otherWorker.getName());
    }
}
