package org.bridgelabz.opencsvandgson;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReadAndParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/java/org/bridgelabz/opencsvandgson/users.csv";

    public static void read() {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while(csvUserIterator.hasNext()){
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name :" + csvUser.getName());
                System.out.println("Email :" + csvUser.getEmail());
                System.out.println("PhoneNo :" + csvUser.getPhoneNo());
                System.out.println("Country :" + csvUser.getCountry());
                System.out.println("==============================");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
