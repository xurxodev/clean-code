package com.xurxodev.robotpatternexample.Robot;

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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import android.app.Activity;

import com.xurxodev.robotpatternexample.R;

public class LoginRobot {

    private Activity activity;

    public LoginRobot(Activity activity){
        this.activity = activity;
    }

    public LoginRobot typeEmail(String email){
        onView(withId(R.id.input_email))
                .perform(typeText(email), closeSoftKeyboard());
        return this;
    }

    public LoginRobot typePassword(String password){
        onView(withId(R.id.input_password))
                .perform(typeText(password), closeSoftKeyboard());
        return this;
    }

    public LoginRobot doLogin(){
        onView(withId(R.id.btn_login)).perform(click());
        return this;
    }

    public LoginRobot verifySuccessMessage(){
        onView(withText(R.string.invalid_credentials_message)).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
        return this;
    }

    public LoginRobot verifyLoginIsEnabled(){
        onView(withId(R.id.btn_login)).check(matches(isEnabled()));
        return this;
    }

    public LoginRobot verifyLoginIsNotEnabled(){
        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())));
        return this;
    }
}
