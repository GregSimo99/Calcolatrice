package com.example.studente.calcolatrice;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nAttuale;
    private Button Calcola;
    private int n1,n2;
    private String operazione,s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nAttuale=findViewById(R.id.nAttuale);
        Calcola=findViewById(R.id.btnCalcola);
    }

    public void numberClick(View v){
        s+=((Button)v).getText();
        nAttuale.setText(""+Integer.parseInt(s)); //per evitare 001 --> 1
    }

    public void operationClick(View v){
        s="";
        n1=Integer.parseInt(nAttuale.getText().toString());
        operazione=((Button)v).getText().toString();
        nAttuale.setText("0");
        Calcola.setEnabled(true);
    }

    public void calcolaIntent(View v){
        final Intent intent=new Intent(this,RisultatoActivity.class);
        intent.putExtra("n1",n1);
        intent.putExtra("n2",Integer.parseInt(nAttuale.getText().toString()));
        intent.putExtra("operazione",operazione);
        Log.i("numero", "text: "+Integer.parseInt(nAttuale.getText().toString()));
        startActivity(intent);
    }
}
