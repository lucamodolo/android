package com.example.studente.trovaparola;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity{

    TextView selezione;
    String parola="casa";
    int conta;
    int trovate = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        selezione = (EditText) findViewById(R.id.editText);
        selezione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selezione.setText("");
            }
        });
    }

    public void seleziona(View v) {
        if(selezione.getText().toString().equals(""))return;
        int i = v.getId();
        char letteraScelta = selezione.getText().toString().charAt(0);
        switch (i){
            case R.id.b00:
                if(letteraScelta == parola.charAt(0)){
                    Button b = (Button) findViewById(R.id.b00);
                    b.setText(letteraScelta + "");
                    trovate++;
                    b.setEnabled(false);
                }
                break;
            case R.id.b01:
                if(letteraScelta == parola.charAt(1)){
                    Button b = (Button) findViewById(R.id.b01);
                    b.setText(letteraScelta + "");
                    trovate++;
                    b.setEnabled(false);                }
                break;
            case R.id.b02:
                if(letteraScelta == parola.charAt(2)){
                    Button b = (Button) findViewById(R.id.b02);
                    b.setText(letteraScelta + "");
                    trovate++;
                    b.setEnabled(false);
                }
                break;
            case R.id.b03:
                if(letteraScelta == parola.charAt(3)){
                    Button b = (Button) findViewById(R.id.b03);
                    b.setText(letteraScelta + "");
                    trovate++;
                    b.setEnabled(false);
                }
                break;
        }

        if (trovate == 4) {
            Intent intent = new Intent();

            intent.putExtra("vittoria", "vinto");

            GameActivity.this.setResult(RESULT_OK, intent);

            GameActivity.this.finish();
        }
    }

}
