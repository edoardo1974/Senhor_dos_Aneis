package com.tokio.model;

import static com.tokio.util.Dados.rolar;

public class Bestas extends Personagem{


    public Bestas(String nome, int puntosVida, int resistênciaarmadura) {
        super(nome, puntosVida, resistênciaarmadura);
    }

    @Override
    public int ataque() {
        return (int) (Math.random() * 91);
    }

}
