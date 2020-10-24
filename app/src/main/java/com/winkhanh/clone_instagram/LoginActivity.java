package com.winkhanh.clone_instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG="LoginActivity";
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() !=null) goToMainActivity();

        etPassword = findViewById(R.id.etPassword);
        etUserName = findViewById(R.id.etUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUserName.getText().toString();
                String password=etPassword.getText().toString();
                loginWithUserNameAndPassword(username,password);
            }
        });
    }

    private void loginWithUserNameAndPassword(String username, String password) {
        Log.d(TAG,username+" "+password);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null){
                    Log.e(TAG,"Issue with login",e);
                    return;
                }
                goToMainActivity();
            }
        });
    }

    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}