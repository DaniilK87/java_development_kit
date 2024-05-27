package org.example.homework3.Task1;


/**
 * Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
 * Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 * Методы должны возвращать результат своей работы.
 */
public class Calculator {

    public static void main(String[] args) {
        Calculator.sum(2,2.1);
        Calculator.multiply(2,2.1);
        Calculator.divide(2,2.1);
        Calculator.subtract(2,2.1);
    }


    public static <T extends Number> void sum(T firstNumber, T secondNumber) {
        double sum =  firstNumber.doubleValue() + secondNumber.doubleValue();
        System.out.println(sum);
    }

    public static <T extends Number> void multiply(T firstNumber, T secondNumber) {
        double multiply =  firstNumber.doubleValue() * secondNumber.doubleValue();
        System.out.println(multiply);
    }

    public static <T extends Number> void divide(T firstNumber, T secondNumber) {
        double divide =  firstNumber.doubleValue() / secondNumber.doubleValue();
        System.out.println(divide);
    }

    public static <T extends Number> void subtract(T firstNumber, T secondNumber) {
        double subtract =  firstNumber.doubleValue() - secondNumber.doubleValue();
        System.out.println(subtract);
    }


}
