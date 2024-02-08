package ru.spbstu.telematics.java;

public class Main {
    public static void main(String[] args) {
        // Задаем параметры нормального распределения
        double mean = 10; // Среднее значение
        double standardDeviation = 1.0; // Стандартное отклонение
        // Генерируем случайное число с нормальным распределением
        RandomNumberGenerator generator = new RandomNumberGenerator();
        double randomValue = generator.generateRandomNormal(mean, standardDeviation);

        System.out.println("\nСлучайное число с нормальным распределением: " + randomValue);
    }
}
class RandomNumberGenerator {
    public double generateRandomNormal(double mean, double standardDeviation) {
        double x1 = Math.random();
        double x2 = Math.random();

        double z0 = Math.sqrt(-2.0 * Math.log(x1)) * Math.cos(2.0 * Math.PI * x2);

        return mean + standardDeviation * z0;
    }
}
