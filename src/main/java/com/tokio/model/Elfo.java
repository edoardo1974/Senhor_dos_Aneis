package com.tokio.model;

public class Elfo extends Heroi{

    public Elfo(String nome, int puntosVida, int resistênciaarmadura) {
        super(nome, puntosVida, resistênciaarmadura);
    }

    @Override
    public int ataque() {
        int poderdeAtaque = super.ataque();
        return poderdeAtaque + 10;
    }
}
