package com.swalffy.github.com.calctests;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RoboelectricActivityTest {
    private ActivityController<MainActivity> controller;

    @Before
    public void init(){
        controller = Robolectric.buildActivity(MainActivity.class);
        controller.create();
        controller.start();
        controller.resume();
    }

    @Test
    public void testMainActivity(){
        final MainActivity activity = controller.get();
        final View multiplyButton = activity.findViewById(R.id.multiply_button);
        final EditText inputEditText = (EditText)activity.findViewById(R.id.input_editText);
        final TextView resultTextView = (TextView)activity.findViewById(R.id.result_textView);

        assertEquals(multiplyButton.isEnabled(), false); //Check if button is not enabled
        inputEditText.setText(String.valueOf(1.0f));
        assertEquals(multiplyButton.isEnabled(), true); //Check if button is enabled
        multiplyButton.performClick();
        inputEditText.setText(String.valueOf(2.0f));
        multiplyButton.performClick();
        assertEquals(resultTextView.getText(),"2.00"); //Check multiply result

        final ICalculator mockedCalculator = mock(Calculator.class);
        final float a = 6f;
        final float b = 3f;
        when(mockedCalculator.divide(a,b)).thenReturn(a/b);
        assertEquals(a/b,mockedCalculator.divide(a,b)); //Check division using mock

        final ICalculator spyCalculator = spy(new Calculator());
        doReturn(a-b).when(spyCalculator).minus(a,b);
        assertEquals(a-b,spyCalculator.minus(a,b)); //Check minus using spy
    }

    @After
    public void destroy(){

    }
}
