package com.example.feedback;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignupTest_Activity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_test_);
        init();
        handler = new Handler(){
            public void handleMessage(Message msg)
            {
                switch (msg.what)
                {
                    case 111: //means Sign Up successfully and go to login page
                        Intent intent = new Intent(SignupTest_Activity.this, LoginTest_Activity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        break;
                    case 110: //Sign Up failed.
                        Toast.makeText(SignupTest_Activity.this, "The email address is already occupied. Please try another one.", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        };
        AllFunctions.getObject().setHandler(handler);
    }

    private void init()
    {
        TextView textView_Login = findViewById(R.id.textView_login_insignup);
        textView_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupTest_Activity.this, LoginTest_Activity.class);
                startActivity(intent);
            }
        });
    }

    public void signup(View view)
    {
        EditText editText_FirstName = findViewById(R.id.editText_firstName_insignup);
        EditText editText_MiddleName = findViewById(R.id.editText_middleName_insignup);
        EditText editText_LastName = findViewById(R.id.editText_lastname_insignup);
        EditText editText_email = findViewById(R.id.editText_email_insignup);
        EditText editText_password = findViewById(R.id.editText_password_insignup);
        EditText editText_passwordConfirm = findViewById(R.id.editText_confirmPassword_insignup);
        String firstName = editText_FirstName.getText().toString();
        String middleName = editText_MiddleName.getText().toString();
        String lastName = editText_LastName.getText().toString();
        String email = editText_email.getText().toString();
        String password = editText_password.getText().toString();
        String passwordConfirm = editText_passwordConfirm.getText().toString();
        AllFunctions allFunctions = AllFunctions.getObject();
        allFunctions.register(firstName,middleName,lastName,email,password);
    }
}
