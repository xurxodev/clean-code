package com.xurxodev.robotpatternexample.NoRobot;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.xurxodev.robotpatternexample.LoginActivity;
import com.xurxodev.robotpatternexample.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginFeature {

    String demo_username = "demo@xurxodev.com";
    String demo_password = "demo";

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void should_show_invalid_credentials_message() {

        onView(withId(R.id.input_email))
                .perform(typeText("wrong@email.com"), closeSoftKeyboard());

        onView(withId(R.id.input_password))
                .perform(typeText("wrong_password"), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        LoginActivity activity = activityTestRule.getActivity();
        onView(withText(R.string.invalid_credentials_message)).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    @Test
    public void should_enable_login_button_if_insert_username_password() {

        onView(withId(R.id.input_email))
                .perform(typeText(demo_username), closeSoftKeyboard());

        onView(withId(R.id.input_password))
                .perform(typeText(demo_password), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).check(matches(isEnabled()));
    }

    @Test
    public void should_not_enable_login_button_if_insert_only_username() {

        onView(withId(R.id.input_email))
                .perform(typeText(demo_username), closeSoftKeyboard());


        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())));
    }

}
