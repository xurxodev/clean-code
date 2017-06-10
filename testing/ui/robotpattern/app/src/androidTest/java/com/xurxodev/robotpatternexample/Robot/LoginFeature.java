package com.xurxodev.robotpatternexample.Robot;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.xurxodev.robotpatternexample.LoginActivity;

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

        LoginRobot loginRobot = new LoginRobot(activityTestRule.getActivity());

        loginRobot
                .typeEmail("wrong@email.com")
                .typePassword("wrong_password")
                .doLogin()
                .verifySuccessMessage();
    }

    @Test
    public void should_enable_login_button_if_insert_username_password() {

        LoginRobot loginRobot = new LoginRobot(activityTestRule.getActivity());

        loginRobot
                .typeEmail(demo_username)
                .typePassword(demo_password)
                .verifyLoginIsEnabled();
    }

    @Test
    public void should_not_enable_login_button_if_insert_only_username() {

        LoginRobot loginRobot = new LoginRobot(activityTestRule.getActivity());

        loginRobot
                .typeEmail(demo_username)
                .verifyLoginIsNotEnabled();
    }

}
