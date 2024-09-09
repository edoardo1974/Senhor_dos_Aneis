package com.tokio.model;

public class Orco extends Bestas{
    public Orco(String nome, int puntosVida, int resistênciaarmadura) {
        super(nome, puntosVida, resistênciaarmadura);
    }

    @Override
    public int ataque() {// 5 pontos mais de ataque
        int poderdeAtaque = super.ataque();
        return poderdeAtaque;
    }

    public void reduzirarmadura(Personagem adversário) {
        int redução = (int) (adversário.getResistênciaarmadura() * 0.1);
        adversário.resistênciaarmadura -= redução;
    }

}
