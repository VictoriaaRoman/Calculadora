package edu.upc.dsa.calculadora;

public class Product implements Operation{
    @Override
    public double operation(double a, double b) {
        return a*b;
    }
}
