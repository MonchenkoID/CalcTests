package com.swalffy.github.com.calctests;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RoboelectricActivityTest {
    private ActivityController<MainActivity> controller;

    @Before
    public void init(){
        controller = Robolectric.buildActivity(MainActivity.class);
    }

    @Test
    public void testMainActivity(){
        controller.create();
        controller.start();
        controller.resume();
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
    }

    @After
    public void destroy(){

    }
}
