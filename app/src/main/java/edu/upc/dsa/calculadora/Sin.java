package edu.upc.dsa.calculadora;

public class Sin implements Operation{
    @Override
    public double operation(double a, double b) {
        double res = Math.sin(a);
        if(b == 0)//0 = rad
            return Math.toRadians(res);
        else
            return Math.toDegrees(res);
    }
}
