package com.abhisheksingh.ifbservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Button Administrator=findViewById(R.id.administrator_login_btn);
        Button Employee=findViewById(R.id.employee_login_btn);
        Button Guest=findViewById(R.id.guest_login_btn);

        Administrator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(FirstPage.this, LoginPage.class));
            }
        });
        Employee.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(FirstPage.this, EmployeePage.class));
            }
        });
        Guest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(FirstPage.this, GuestPage.class));
            }
        });
    }
}
