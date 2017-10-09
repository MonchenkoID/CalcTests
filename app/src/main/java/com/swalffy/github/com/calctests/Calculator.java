package com.swalffy.github.com.calctests;

public class Calculator implements ICalculationFunctions {

    @Override
    public float add(final float a, final float b) {
        return a + b;
    }

    @Override
    public float minus(final float a, final float b) {
        return a - b;
    }

    @Override
    public float multiply(final float a, final float b) {
        float c = 0.4f;
        return a * b;
    }

    @Override
    public float devide(final float a, final float b) {
        return a / b;
    }

    @Override
    public float calculate(float a, float b, Operation op) {
        switch (op){
            case Plus:
                return add(a, b);
            case Minus:
                return minus(a,b);
            case Multiply:
                return multiply(a,b);
            case Devide:
                return devide(a,b);
        }
        return 0;
    }

}
