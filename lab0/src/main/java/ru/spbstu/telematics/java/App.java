package ru.spbstu.telematics.java;

public class App {
    public static void main(String[] args) {
        // Задаем параметры нормального распределения
        double mean = 10; // Среднее значение
        double standardDeviation = 1.0; // Стандартное отклонение
        // Генерируем случайное число с нормальным распределением
	double randomValue = generateRandomNormal(mean, standardDeviation);

        System.out.println("\nСлучайное число с нормальным распределением: " + randomValue);
    }
    // Метод для генерации случайной величины с нормальным распределением
    public static double generateRandomNormal(double mean, double standardDeviation) {
        // Генерируем пару независимых случайных чисел с равномерным распределением
        double x1 = Math.random();
        double x2 = Math.random();

        // Используем метод Бокса-Мюллера для получения пары независимых случайных чисел
        double z0 = Math.sqrt(-2.0 * Math.log(x1)) * Math.cos(2.0 * Math.PI * x2);

        // Масштабируем и сдвигаем полученные числа
        return mean + standardDeviation * z0;
    }
}
