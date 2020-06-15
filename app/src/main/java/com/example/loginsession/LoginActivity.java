package com.example.loginsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameText;
    private EditText passwordText;
    private TextView errorText;
    private SessionManager  session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new SessionManager(this);
        usernameText = (EditText) findViewById(R.id.textUsername);
        passwordText = (EditText) findViewById(R.id.textPassword);
        errorText = (TextView) findViewById(R.id.labelError);
        usernameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                noError();
            }
        });
        passwordText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                noError();
            }
        });
    }

    private void navigateToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void login(View view) {
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        //dummy login data
        if(username.equals("iceman") && password.equals("12345678")){
            session.session_start(username);
            navigateToHome();
        } else {
            passwordText.setText("");
            errorText.setText(R.string.login_failed);
        }
    }

    public void noError() {
        errorText.setText("");
    }
}