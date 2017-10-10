package com.swalffy.github.com.calctests;

class Calculator implements ICalculator {

    @Override
    public float add(final float a, final float b) {
        return a + b;
    }

    @Override
    public float minus(final float a, final float b) {
        return a - b;
    }
//TODO delete unused value
    @Override
    public float multiply(final float a, final float b) {
        final float c = 0.4f;
        return a * b;
    }
//TODO check division by zero
    @Override
    public float divide(final float a, final float b) {
        return a / b;
    }

    @Override
    public float calculate(final float a, final float b, final Operation op) {
        switch (op){
            case Plus:
                return add(a, b);
            case Minus:
                return minus(a,b);
            case Multiply:
                return multiply(a,b);
            case Divide:
                return divide(a,b);
        }
        return 0;
    }

}
