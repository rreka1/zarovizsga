package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(file))) {
            String line;
            List<Work> works = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                works.add(new Work(parts[0], Integer.parseInt(parts[1]), LocalDate.parse(parts[2])));
            }
            Collections.sort(works);
            return works.get(0).toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }
}
