package org.bridgelabz.opencsvandgson;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/java/org/bridgelabz/opencsvandgson/users.csv";
    public static void readInStringArray(){
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[]  nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                System.out.println("Name: " + nextRecord[0]);
                System.out.println("Email: " + nextRecord[1]);
                System.out.println("Phone: " + nextRecord[2]);
                System.out.println("Country: " + nextRecord[3]);
                System.out.println("=====================================");
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readAllAtOnce(){

        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            List<String[]> records = csvReader.readAll();
            for(String[] record : records){
                System.out.println("Name :" + record[0]);
                System.out.println("Email :" + record[1]);
                System.out.println("Phone :" + record[2]);
                System.out.println("Country :" + record[3]);
                System.out.println("===========================");
            }
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
