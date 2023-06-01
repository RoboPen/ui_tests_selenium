package com.automationexercise.dataproviders;

import com.automationexercise.dataproviders.dtos.UserRegistrationFormDto;
import com.automationexercise.pageobjects.enums.Title;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class UserRegistrationProvider {
    public static CSVReader readRegistrationData() throws FileNotFoundException {
        return new CSVReaderBuilder(new FileReader("src/test/resources/data/registration-test.csv")).
                withSkipLines(1).
                build();
    }

    @DataProvider(name = "registrationData")
    public static Object[][] getRegistrationData() throws IOException, CsvException {
        return readRegistrationData().readAll().stream().map(data-> {
            UserRegistrationFormDto csvObject= new UserRegistrationFormDto();
            csvObject.setTitle(Title.valueOf(data[0]));
            csvObject.setName(data[1]);
            csvObject.setPassword(data[2]);
            csvObject.setBirthDate(LocalDate.parse(data[3]));
            csvObject.setFirstName(data[4]);
            csvObject.setLastName(data[5]);
            csvObject.setEmail(data[6]);
            csvObject.setMobileNumber(data[7]);
            csvObject.setAddress(data[8]);
            csvObject.setCity(data[9]);
            csvObject.setState(data[10]);
            csvObject.setZipcode(data[11]);
            csvObject.setCountry(data[12]);
            return new Object[]{ csvObject };
        }).toArray(Object[][]::new);
    }
}
