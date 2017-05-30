package com.example.studente.trovaparola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button b;
    TextView tv;
    private static final int code=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);
        et = (EditText) findViewById(R.id.insertName);
        tv= (TextView) findViewById(R.id.textView);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = et.getText().toString();
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                i.putExtra("name", playerName);
                startActivityForResult(i,code);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == code) {
            if (resultCode == RESULT_OK) {

                String v=data.getStringExtra("vittoria");

                if (v.equals("vinto")){
                    tv.setTextColor(getResources().getColor(R.color.green));

                }else{
                    tv.setTextColor(getResources().getColor(R.color.red));
                }
                tv.setText(v);
                Toast.makeText(this, v,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
