package com.xurxodev.robotpatternexample;

import static android.text.TextUtils.isEmpty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.input_email)
    EditText emailEditText;

    @BindView(R.id.input_password)
    EditText passwordEditText;

    @BindView(R.id.btn_login)
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initializeCredentials();
        initializeLoginButton();
    }

    private void initializeCredentials() {
        CredentialsTextWatcher credentialsTextWatcher = new CredentialsTextWatcher();
        emailEditText.addTextChangedListener(credentialsTextWatcher);
        passwordEditText.addTextChangedListener(credentialsTextWatcher);
    }

    private void initializeLoginButton() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        if (!validate())
            onLoginSuccess();
        else
            onLoginFailed();
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.equals(getString(R.string.demo_username))) {
            valid = false;
        }

        if (password.equals(getString(R.string.demo_password))) {
            valid = false;
        }

        return valid;
    }

    public void onLoginSuccess() {
        Toast.makeText(getBaseContext(), R.string.login_success_message, Toast.LENGTH_LONG).show();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), getString(R.string.invalid_credentials_message), Toast.LENGTH_LONG).show();
    }

    private  void credentialsChanged() {
        loginButton.setEnabled(
                !isEmpty(emailEditText.getText()) && !isEmpty(passwordEditText.getText()));
    }

    private class CredentialsTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            LoginActivity.this.credentialsChanged();
        }

        @Override
        public void afterTextChanged(Editable s) {}
    }
}
