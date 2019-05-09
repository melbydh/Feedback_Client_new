package com.example.feedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginTest_Activity extends AppCompatActivity {

    AllFunctions allFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test_);
        init();
    }

    private void init()
    {
        allFunctions = AllFunctions.getObject();
        TextView textView_signup = (TextView)findViewById(R.id.textView_signup_inlogin);
        textView_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginTest_Activity.this, SignupTest_Activity.class);
                startActivity(intent);
            }
        });
    }

    public void login(View view)
    {
        EditText editText_email = findViewById(R.id.editText_email_inlogin);
        EditText editText_password = findViewById(R.id.editText_password_inlogin);
        String email = editText_email.getText().toString();
        String password = editText_password.getText().toString();
        allFunctions.login(email, password);
        Intent intent = new Intent(this, Assessment_Preparation_Activity.class);
        startActivity(intent);
    }
}