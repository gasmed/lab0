package ru.spbstu.telematics.java;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


import org.junit.Test;


public class DistributionTest {
    @Test
    public void main() {
        RandomNumberGenerator rng = new RandomNumberGenerator();

        // Задаем параметры нормального распределения
        double mean = 10; // Среднее значение
        double standardDeviation = 1.0; // Стандартное отклонение

        List<Double> list = new ArrayList<>();
        for (double i = mean - 3 * standardDeviation; i <= mean + standardDeviation * 4; i = i + standardDeviation) {
            list.add(i);
        }

        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size() - 1; i++) {
            map.put(list.get(i), 0);
        }

        for (int i = 0; i < 1000000; i++) {
            double rnd = rng.generateRandomNormal(mean, standardDeviation);
            for (int j = 0; j < list.size() - 1; j++) {
                if (rnd > list.get(j) && rnd < list.get(j + 1)) {
                    map.replace(list.get(j), map.get(list.get(j)) + 1);
                }
            }
        }

        System.out.println(map);
        list.remove(mean + standardDeviation * 4);
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i) + "-" + list.get(i + 1) + ": " + map.get(list.get(i)) / 10000 + "%");
        }
    }
}
