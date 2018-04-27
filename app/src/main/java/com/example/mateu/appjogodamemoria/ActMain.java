package com.example.mateu.appjogodamemoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mateu.appjogodamemoria.Tabuleiro.Tabuleiro;

import java.util.Objects;

public class ActMain extends AppCompatActivity {

    private GridLayout grid;

    private Tabuleiro tabuleiro;

    private TextView txtPlacar;

    private int posicaoImgViradas [];

    private int contaClick;

    private int placar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        grid = (GridLayout) findViewById(R.id.gridLTabuleiro);

        inicializar();

    }

    private void inicializar(){

        tabuleiro = new Tabuleiro();

        tabuleiro.iniciarTabuleiro();

        posicaoImgViradas = new int [2];

        contaClick = 0;

        txtPlacar = (TextView) findViewById(R.id.txtPlacar);

        txtPlacar.setText(String.valueOf(contaClick));

        this.iniciarGrid();

    }

    public void trocaImagem(View v) {

        ImageView imgView = (ImageView) v;

        int posicao = Integer.parseInt(imgView.getTag().toString());

        imgView.setImageResource(tabuleiro.getImagem(posicao));

        posicaoImgViradas[contaClick] = posicao;

        txtPlacar.setText(String.valueOf(placar));

        contaClick++;

        if (contaClick > 1) {

            boolean acertou = tabuleiro.getImagem(posicaoImgViradas[0]) == tabuleiro.getImagem(posicaoImgViradas[1]);

            if (!acertou) {

                android.os.SystemClock.sleep(500);

                for (int i = 0; i < posicaoImgViradas.length; i++) {

                    ImageView img = (ImageView) grid.getChildAt(posicaoImgViradas[i]);

                    img.setImageResource(tabuleiro.imgPadrao);

                }

            }else{
                placar += contaClick;
            }

            contaClick = 0;

        }

    }

    public void jogarNovamente(View v) {

        this.inicializar();

    }

    public void sair(View view) {

        this.finish();

    }

    private void iniciarGrid(){

        for(int i = 0; i < grid.getChildCount(); i++){

            ImageView img = (ImageView) grid.getChildAt(i);

            img.setImageResource(tabuleiro.imgPadrao);

            img.setTag(i);

        }

    }

}
