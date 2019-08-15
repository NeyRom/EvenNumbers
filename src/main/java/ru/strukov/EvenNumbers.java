package ru.strukov;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Roman Strukov on 15.08.2019.
 */

public class EvenNumbers {
//    public static void main(String[] args) {
//        int[] numbers = getEvenNumbers("34;45;52352;323;32;43;44;680;51;80");
//        for (int num : numbers) {
//            System.out.println(num);
//        }
//    }

    public static int[] getEvenNumbers(String row) {
        ArrayList<Integer> numbers = new ArrayList<>();
        try (StringReader reader = new StringReader(row)) {
            int i;
            char character;
            int number = 0;
            while ((i = reader.read()) != -1) {
                character = (char) i;
                if (character == ';') {
                    if (number % 2 == 0) {
                        numbers.add(number);
                    }
                    number = 0;
                } else {
                    if (number != 0) {
                        number = number * 10 + Character.getNumericValue(character);
                    } else {
                        number = Character.getNumericValue(character);
                    }
                }
            }
            if (number % 2 == 0) {
                numbers.add(number);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return numbers.stream().sorted().mapToInt(i -> i).toArray();
    }
}
