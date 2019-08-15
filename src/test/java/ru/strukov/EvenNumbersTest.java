package ru.strukov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Roman Strukov on 15.08.2019.
 */

class EvenNumbersTest {
    private EvenNumbers evenNumbers;
    private String testData;

    @BeforeEach
    void setUp() {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder builder = new StringBuilder();
        int iteration = random.nextInt(150000) + 2;
        for (int i = 0; i < iteration; i++) {
            int number = random.nextInt(90000) + 2;
            builder.append(number);
            builder.append(";");
        }
        builder.deleteCharAt(builder.length() - 1);
        testData = builder.toString();
        evenNumbers = new EvenNumbers();
    }

    @Test
    void getEvenNumberTest() {
        int[] numbers = evenNumbers.getEvenNumbers(testData);
        int expected = 0;
        for (int num : numbers) {
            int actual = num % 2;
            Assertions.assertEquals(expected, actual);
        }
        int[] numbersCopy = Arrays.copyOfRange(numbers, 0, numbers.length);
        Arrays.sort(numbersCopy);
        Assertions.assertArrayEquals(numbersCopy, numbers);
    }

    @AfterEach
    void tearDown() {
        evenNumbers = null;
    }
}
