package com.example.studente.calcolatrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RisultatoActivity extends AppCompatActivity implements View.OnClickListener{
    private int risultato=0;
    private TextView Trisultato;
    private Button torna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultato);
        risultato=0;
        final Intent partenza=getIntent();
        int n1=partenza.getIntExtra("n1",0);
        int n2=partenza.getIntExtra("n2",0);

        switch (partenza.getStringExtra("operazione")){
            case"+":    risultato=n1+n2;
                        break;
            case"-":    risultato=n1-n2;
                        break;
            case"x":    risultato=n1*n2;
                        break;
            case"/":    risultato=n1/n2;
                        break;
        }
        torna=findViewById(R.id.btnTorna);
        torna.setOnClickListener(this);
        Trisultato=findViewById(R.id.risultato);
        Trisultato.setText(""+risultato);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
