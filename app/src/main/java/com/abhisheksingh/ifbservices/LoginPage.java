package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    Button Login,Register;
    EditText username,password,valid_w;
    String username_admin="sep",password_admin="1234";
    ProgressBar pbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username=(EditText)findViewById(R.id.text_username);
        password=(EditText)findViewById(R.id.text_password);
        Login=(Button) findViewById(R.id.login_btn);
        Register=(Button)findViewById(R.id.register_btn);
        pbar=(ProgressBar)findViewById(R.id.progressBar);
        pbar.setVisibility(View.INVISIBLE);
        valid_w=(EditText)findViewById(R.id.valid_up_text);
        valid_w.setVisibility(View.INVISIBLE);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view)
            {
                if(username_admin.equals(username.getText().toString()) && password_admin.equals(password.getText().toString()))
                {
                    startActivity(new Intent(LoginPage.this,AdministratorPage.class));
                    Toast.makeText(LoginPage.this,"Welcome",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(LoginPage.this,"Incorrect Username or Password",Toast.LENGTH_LONG).show();
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(LoginPage.this, RegisterPage.class));
            }
        });

    }
}
