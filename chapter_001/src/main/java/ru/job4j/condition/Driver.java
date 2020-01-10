package ru.job4j.condition;

public class Driver {
    private char license = 'N';
    // private - озночает, что я могу менять license только внутри этого класса

    public void passExamOn(char category) {
        this.license = category;
    }
    // this - обращение к переменной внутри класса

    public boolean hasLicense() {
        return this.license == 'A' || this.license == 'B' || this.license == 'C';
    }

    public boolean canDrive(char category) {
        return this.license == category;
    }
}
