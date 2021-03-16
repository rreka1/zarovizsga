package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class Work implements Comparable<Work> {

    private final String employeeName;
    private final int hours;
    private final LocalDate day;

    public Work(String employeeName, int hours, LocalDate day) {
        this.employeeName = employeeName;
        this.hours = hours;
        this.day = day;
    }

    @Override
    public int compareTo(Work o) {
        return this.hours - o.hours;
    }

    @Override
    public String toString() {
        return employeeName + ": " + day;
    }
}
