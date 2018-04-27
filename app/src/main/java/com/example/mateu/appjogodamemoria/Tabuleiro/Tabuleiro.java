package com.example.mateu.appjogodamemoria.Tabuleiro;

import com.example.mateu.appjogodamemoria.R;

import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {

    private final int TAM_TABULEIRO = 30;

    private final int [] IMAGENS = {
            R.drawable.et, R.drawable.goku, R.drawable.vampiro,
            R.drawable.pena, R.drawable.teken3
    };

    private Random random;

    private ArrayList<Integer> listTabuleiro;

    private Integer imagensTabuleiro [];

    public int imgPadrao = R.drawable.lampada;

    public Tabuleiro() {

        random = new Random();

        imagensTabuleiro = new Integer[TAM_TABULEIRO];

        iniciaPosicaesListTabuleiro();

    }

    private void iniciaPosicaesListTabuleiro(){

        listTabuleiro = new ArrayList<Integer>();

        for (int i = 0; i < TAM_TABULEIRO; i++) {
            listTabuleiro.add(i);
        }

    }

    public void iniciarTabuleiro(){

        for(int figura : IMAGENS){

            for(int i = 0; i < 6; i++) {

                int posicao = gerarPosicaoRandomica();

                imagensTabuleiro[posicao] = figura;


            }

        }

    }

    private int gerarPosicaoRandomica() {

        int posicao = random.nextInt(listTabuleiro.size());

        posicao = listTabuleiro.remove(posicao);

        return posicao;
    }

    public int getImagem(int posicao){

        return imagensTabuleiro[posicao];

    }


}
