package utils;

import pojos.GMIBankCustomerPojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadText {
    public static List<String> readCustomerSSNList(String filePath) {

        //BufferedReader-->Text dosyalarını okuyan java da kullanılan bir method
        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                GMIBankCustomerPojo customer = new GMIBankCustomerPojo();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(customer.getSsn());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> readCustomerEmailList(String filePath) {

        List<String> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                GMIBankCustomerPojo customer = new GMIBankCustomerPojo();
                customer.setEmail(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(customer.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }
}
