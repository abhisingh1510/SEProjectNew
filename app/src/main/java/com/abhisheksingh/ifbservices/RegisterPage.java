package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
public class RegisterPage extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName,editUsername,editPassword,rePassword;
    String editStatus,pass,repass;
    Button btnRegister;
    Spinner spinnerStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        myDb=new DatabaseHelper(this,"ADMIN_LOGIN",null,1);
        editName=(EditText)findViewById(R.id.name_text);
        editUsername=(EditText)findViewById(R.id.username_text);
        editPassword=(EditText)findViewById(R.id.password_text);
        rePassword=(EditText)findViewById(R.id.re_password_text);
        btnRegister=(Button)findViewById(R.id.register_now_btn);
        spinnerStatus=(Spinner)findViewById(R.id.user_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_select, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerStatus.setAdapter(adapter);

        spinnerStatus.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        String editStatus=(String)spinnerStatus.getSelectedItem().toString();
        addData();
    }

    public void addData(){
        btnRegister.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (editPassword.getText().toString().equals(rePassword.getText().toString())) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editUsername.getText().toString(),
                                editPassword.getText().toString(),
                                editStatus);
                        if (isInserted == true)
                            Toast.makeText(RegisterPage.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegisterPage.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterPage.this, FirstPage.class));
                    }
                    else
                        Toast.makeText(RegisterPage.this, "Password Do Not Match", Toast.LENGTH_LONG).show();
                }
            }

        );
    }
}
