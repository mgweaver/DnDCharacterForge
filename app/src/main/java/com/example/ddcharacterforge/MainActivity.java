package com.example.ddcharacterforge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hi from Mason :)
        //Hi Mason.
        // HIIIIIi
    }

    public void creationButton(View view){
        Intent intent = new Intent(this, CreationActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra("message", message);
        startActivity(intent);
    }

    public void selectButton(View view){
        Intent intent = new Intent(this, Sheet.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra("message", message);
        startActivity(intent);
    }


}
