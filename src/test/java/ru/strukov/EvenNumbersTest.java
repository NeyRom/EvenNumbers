package ru.strukov;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.Random;

/**
 * Created by Roman Strukov on 15.08.2019.
 */

public class EvenNumbersTest {
    private static EvenNumbers evenNumbers;
    private static String testData;

    @BeforeAll
    static void initTest() {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder builder = new StringBuilder();
        int iteration = random.nextInt(10000);
        for (int i = 0; i < iteration; i++) {
            builder.append(random.nextInt(100000));
            builder.append(";");
        }
        testData = builder.toString();
        evenNumbers = new EvenNumbers();

    }

    @AfterAll
    static void afterTest() {
        evenNumbers = null;
    }


}
