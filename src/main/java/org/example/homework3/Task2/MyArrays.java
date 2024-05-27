package org.example.homework3.Task2;


/**
 * Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и false в противном случае.
 * Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.
 */
public class MyArrays {

    public static void main(String[] args) {
        Integer [] arrayFirst = {1,2,3};
        Double [] arraySecond = {3.1,2.2,1.1};
        boolean result =  MyArrays.compareArrays(arrayFirst,arraySecond);
        System.out.println(result);
    }

    public static <T> boolean compareArrays(T[] arrayFirst, T[] arraySecond) {
        if (arrayFirst.getClass() == arraySecond.getClass() & arrayFirst.length == arraySecond.length) {
            return true;
        } else {
            return false;
        }
    }
}
