package com.swalffy.github.com.calctests;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

public class CalculatorAndroidTest {

    private final ActivityTestRule<MainActivity> activity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testActivityRun(){
        activity.launchActivity(new Intent());
        ViewInteraction plusButton = onView(withId(R.id.plus_button));
        plusButton.check(matches(not(isEnabled()))); //Check if button is not enabled
        onView(withId(R.id.input_editText)).perform(typeText("1"));
        plusButton.check(matches(isEnabled())); //Check if button become enabled
        plusButton.perform(click());
        onView(withId(R.id.input_editText)).perform(typeText("2"));
        plusButton.perform(click());
        onView(withId(R.id.result_textView)).check(matches(withText("3.00"))); //Check calculating result
    }
}
