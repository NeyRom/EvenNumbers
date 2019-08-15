package ru.strukov;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Roman Strukov on 15.08.2019.
 */

class EvenNumbers {

    @SuppressWarnings("WeakerAccess")
    public int[] getEvenNumbers(String row) {
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
