package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editLocation,editActivity;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDb = new DatabaseHelper(this);

        editLocation = (EditText)findViewById(R.id.editLocation);
        editActivity = (EditText)findViewById(R.id.editActivity);
        btnAddData = (Button)findViewById(R.id.buttonSend);

        AddData();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editLocation.getText().toString(),
                                editActivity.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(Main2Activity.this,"Successful",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main2Activity.this,"System Error",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void call_login(View view){

        startActivity(new Intent(Main2Activity.this, LoginActivity.class));

    }

    public void call_msg(View view){

        startActivity(new Intent(Main2Activity.this, Notifications.class));

    }

}
