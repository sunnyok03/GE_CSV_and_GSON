package org.bridgelabz.opencsvandgson;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CSVToJSON {
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/java/org/bridgelabz/opencsvandgson/users.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "src/main/java/org/bridgelabz/opencsvandgson/users.json";

    public static void readFromCSVAndWriteToJSON(){
        try {
            Reader reader = new BufferedReader(new FileReader(Paths.get(SAMPLE_CSV_FILE_PATH).toFile()));
            CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();

            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();

            BufferedReader br = new BufferedReader(new FileReader(Paths.get(SAMPLE_JSON_FILE_PATH).toFile()));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
