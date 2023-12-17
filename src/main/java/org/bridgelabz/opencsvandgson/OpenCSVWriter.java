package org.bridgelabz.opencsvandgson;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCSVWriter {
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/java/org/bridgelabz/opencsvandgson/users.csv";

    public static void writeInCSV() {
        try (Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH))) {
            StatefulBeanToCsv<Object> beanToCsv = new StatefulBeanToCsvBuilder<>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

            CSVUser csvUser = new CSVUser("new user", "newUser@gmai.com", "9292929292", "India");

            beanToCsv.write(csvUser);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }
}
