package com.tokio.model;

public class Hobbit extends Heroi{

    public Hobbit(String nome, int puntosVida, int resistênciaarmadura) {
        super(nome, puntosVida, resistênciaarmadura);
    }

    @Override
    public int ataque() {// 5 pontos menos de ataque
        int poderdeAtaque = super.ataque();
        return poderdeAtaque - 5;
    }
}
