package com.example.covid19;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilCovid extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_covid);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView status = (TextView)findViewById(R.id.status);

        hasil.setText("Total Ya      : " + MainActivity.benar+"" +
                      "\nTotal Tidak : " + MainActivity.salah);
        status.setText("Resiko "+MainActivity.status);


        }



    public void ulangi(View View){
        finish();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }


}
