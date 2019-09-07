package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener helpButtonListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,HelpActivity.class);
            Bundle b = new Bundle();
            EditText myEditText = (EditText)findViewById(R.id.editText1);
            b.putString("helpString",myEditText.getText().toString());
            intent.putExtras(b);
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.mainActivityTextView);
        textView.setText(R.string.test_untuk_update_view);

        Button helpBtn = (Button)findViewById(R.id.helpButton);
        helpBtn.setOnClickListener(helpButtonListener);

        Button layoutBtn = (Button)findViewById(R.id.layoutButton);

        Button appBtn = (Button)findViewById(R.id.appButton);

        appBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(i);
            }
        });

        layoutBtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent i = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(i);
        }
        });

        Button myBtn = (Button)findViewById(R.id.button1);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText myEditText = (EditText)findViewById(R.id.editText1);
                Log.d("ProteinTracker",myEditText.getText().toString());
            }
        });
        if(savedInstanceState != null){
            Log.d("ProteinTracker",savedInstanceState.getString("abc"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("abc","test");
        super.onSaveInstanceState(outState);
    }
}
