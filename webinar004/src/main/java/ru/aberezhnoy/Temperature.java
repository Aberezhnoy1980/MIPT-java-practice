package ru.aberezhnoy;

import javax.print.AttributeException;
import java.util.ArrayList;
import java.util.Arrays;

public class Temperature {
    /*
    Реализуйте метод, который принимает массив со значениями температуры пациентов.
Метод должен:
    вывести значения
    подсчитать среднюю температру
    подсчитать количество здоровых пациентов
    * */
    public static void main(String[] args) {
        double[] array = {37.5, 36.9, 38.2, 33.5, 32.2};
        System.out.println(getReport(array));

    }

    public static String getReport(double[] temperatureData) {
        /*TODO Формат вывода:
           Температуры пациентов: 37,5 36,9 38,2 33,5 32,2
           Средняя температура: 35,67
           Количество здоровых: 1
         */
        float sum = 0;
        int healthy = 0;
        for (double t : temperatureData) {
            sum += t;
            if (t < 37 && t > 36) healthy++;
        }
        float avgTemp = sum / temperatureData.length;

        return String.format("Температуры пациентов: %s\n Средняя температура: %s\n Количество здоровых: %d", Arrays.toString(temperatureData), avgTemp, healthy);
    }
}
