public class Job {
    double salary;
    String position;
    double taxRate;

    public Job(double salary, String position, double taxRate) {

        this.salary = salary;
        this.position = position;
        this.taxRate = taxRate;

        System.out.println("A new job was created successfully.");

    }

}