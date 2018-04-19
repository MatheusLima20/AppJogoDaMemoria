package com.example.mateu.appjogodamemoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import  android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ActMain extends AppCompatActivity {

    private TextView txtPlacar;

    private final int TAM_TABULEIRO = 30;

    private final int [] IMAGENS = {
            R.drawable.et, R.drawable.goku, R.drawable.vampiro,
            R.drawable.pena, R.drawable.teken3
    };

    private int imagensTabuleiro [];

    private int plarcar;

    private int countClicks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        inicializar();

    }

    private void inicializar(){

        countClicks = 0;

        txtPlacar = (TextView) findViewById(R.id.txtPlacar);

        txtPlacar.setText(String.valueOf(countClicks));

    }

    public void trocaImagem(View v){

        countClicks++;

        txtPlacar.setText(String.valueOf(countClicks));

        if(countClicks <= 2) {

            ImageView imgView = (ImageView) v;

            imgView.setImageResource((R.drawable.et));

        }else{
            // Pausar por 2 segundos

            android.os.SystemClock.sleep(2000);

            countClicks = 0;

        }

    }

    public void jogarNovamente(View v) {

        this.inicializar();

        GridLayout grid = (GridLayout) findViewById(R.id.gridLTabuleiro);

        for(int i = 0; i < grid.getChildCount(); i++){

            ImageView img = (ImageView) grid.getChildAt(i);

            img.setImageResource(R.drawable.lampada);

        }

    }

    public void sair(View view) {

        this.finish();

    }
}
