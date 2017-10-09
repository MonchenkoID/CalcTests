package com.swalffy.github.com.calctests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final ICalculationFunctions mCalculator = new Calculator();
    private EditText mInputEditText;
    private Button mPlusButton;
    private Button mMinusButton;
    private Button mMultiplyButton;
    private Button mDevideButton;
    private TextView mResultTextView;

    private float mMemory;
    private Operation mOperation;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputEditText = (EditText) findViewById(R.id.input_editText);
        mPlusButton = (Button) findViewById(R.id.plus_button);
        mMinusButton = (Button) findViewById(R.id.minus_button);
        mMultiplyButton = (Button) findViewById(R.id.multiply_button);
        mDevideButton = (Button) findViewById(R.id.devide_button);
        mResultTextView = (TextView) findViewById(R.id.result_textView);
        setButtonsAvailability(false);

        mInputEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {
            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                if (s.length() > 0) {
                    setButtonsAvailability(true);
                } else{
                    setButtonsAvailability(false);
                }
            }
        });

        mPlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                onClickFucnt();
                mOperation = Operation.Plus;
            }
        });
        mMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                onClickFucnt();
                mOperation = Operation.Minus;
            }
        });
        mMultiplyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                onClickFucnt();
                mOperation = Operation.Multiply;
            }
        });
        mDevideButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                onClickFucnt();
                mOperation = Operation.Devide;
            }
        });


    }
    private void onClickFucnt() {
        if (mOperation == null) {
            mMemory = Float.parseFloat(mInputEditText.getText().toString());
        } else{
            mMemory = mCalculator.calculate(mMemory, Float.parseFloat(mInputEditText.getText().toString()), mOperation);
        }
        mInputEditText.setText("");
        mResultTextView.setText(String.format("%(.2f", mMemory));
    }

    private void setButtonsAvailability(final boolean value) {
        mPlusButton.setEnabled(value);
        mDevideButton.setEnabled(value);
        mMultiplyButton.setEnabled(value);
        mMinusButton.setEnabled(value);
    }
}
