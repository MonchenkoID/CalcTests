package com.swalffy.github.com.calctests;

interface ICalculator {
    float add(float a, float b);
    float minus(float a, float b);
    float multiply(float a, float b);
    float divide(float a, float b);
    float calculate(float a, float b, Operation op);
}
