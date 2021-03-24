package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WorkHours {

    public String minWork(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            return findMin(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private String findMin(List<String> lines) {
        int min = Integer.MAX_VALUE;
        String result = null;
        for (String line : lines) {
            String[] parts = line.split(",");
            String name = parts[0];
            int hour = Integer.parseInt(parts[1]);
            String date = parts[2];
            if (min > hour) {
                min = hour;
                result = name + ": " + date;
            }
        }
        return result;
    }
}
