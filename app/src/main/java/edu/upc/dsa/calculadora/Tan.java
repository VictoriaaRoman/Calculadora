package edu.upc.dsa.calculadora;

public class Tan implements Operation{
    @Override
    public double operation(double a, double b) {
        double res = Math.tan(a);
        if(b == 0)//0 = rad
            return Math.toRadians(res);
        else
            return Math.toDegrees(res);
    }
}
