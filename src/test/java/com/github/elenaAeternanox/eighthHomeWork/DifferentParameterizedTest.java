package com.github.elenaAeternanox.eighthHomeWork;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DifferentParameterizedTest extends TestBase{

    @Tag("ValueSource")
    @ValueSource(strings = {"Alex Kotov", "Elena Grach", "Andrew Balkonov", "Irina Bagrova"})
    @DisplayName("Print customer's names")
    @ParameterizedTest(name = "Print {0}")
    void printCustomersNames(String customerName) {
        System.out.println("Customer:  " + customerName);
        assertFalse(customerName.isEmpty());
    }

    @Tag("CsvSource")
    @CsvSource(value = {
            "Alex|Kotov|30|Moscow",
            "Elena|Grach|43|Samara",
            "Andrew|Balkonov|29|Izevsk",
    },
            delimiter = '|')
    @DisplayName("Print customer's info")
    @ParameterizedTest(name = "Print customers info: {0}")
    void printCustomersInfo(String name, String surname, int age, String city) {
        System.out.println("            Customer:");
        System.out.println("Name: " + name + " " + surname);
        System.out.println("Age: " + age);
        System.out.println("Living city: " + city);
        assertTrue(age > 3);
    }

    static Stream<Arguments> printInfoAboutOnePurchase() {
        return Stream.of(
                Arguments.of("Alex", "Kotov", 30, "Moscow", List.of("milk", "sugar"), 234.5, 67895),
                Arguments.of("Elena", "Grach", 43, "Samara", List.of("cheese", "chocolate"), 354.2, 78945.3),
                Arguments.of("Andrew", "Balkonov", 29, "Izevsk", List.of("meat", "juice"), 563, 89456)
        );
    }

    @Tag("MethodSource")
    @MethodSource
    @DisplayName("Print info about one purchase in a market and check the percentage of salary")
    @ParameterizedTest(name = "Customers info: {0}, {1}, {2}, {3}. The list of goods: {4}. The sum of one purchase {5}. The salary {6}")
    void printInfoAboutOnePurchase(String name, String surname, int age, String city, List<String> goods, double sum, double salary) {
        double percentageFromSalary = sum * 100 / salary;

        System.out.println("            Info about one purchase:");
        System.out.println("Customer's ame: " + name + " " + surname);
        System.out.println("Age: " + age);
        System.out.println("Living city: " + city);
        System.out.println("List of goods: " + goods);
        System.out.println("Sum of the purchase: " + sum);
        System.out.println("The percentage from a salary: " + String.format("%.2f", percentageFromSalary));

        assertTrue(percentageFromSalary <= 100);
        assertTrue(percentageFromSalary > 0);
    }

    @Tag("EnumSource")
    @EnumSource(GoodsList.class)
    @DisplayName("Print good's info")
    @ParameterizedTest(name = "Print {0}")
    void printGoodsInfo(GoodsList goodsList) {
        System.out.println("      GOOD:");
        System.out.println("Title: " + goodsList.getTitle());
        System.out.println("Price: " + goodsList.getPrice());

        assertTrue(goodsList.getPrice() > 0);
    }

}
