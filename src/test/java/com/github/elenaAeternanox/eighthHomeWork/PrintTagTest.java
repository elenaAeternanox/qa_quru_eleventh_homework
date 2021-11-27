package com.github.elenaAeternanox.eighthHomeWork;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("files_test"), @Tag("registration_page")})
public class PrintTagTest {

    private static final String MESSAGE = "Build includes parameterized tests with ";

    @Test
    void printInfoTest() {
        switch (System.getProperty("tag")) {
            case "ValueSource":
                System.out.println(MESSAGE + "ValueSource");
                break;
            case "CsvSource":
                System.out.println(MESSAGE + " CsvSource");
                break;
            case "MethodSource":
                System.out.println(MESSAGE + " MethodSource");
                break;
            case "EnumSource":
                System.out.println(MESSAGE + " EnumSource");
                break;
            default:
                System.out.println("Oooops, something wrong !");
        }
    }
}
