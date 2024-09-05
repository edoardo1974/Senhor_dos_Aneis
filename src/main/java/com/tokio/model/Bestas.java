package com.tokio.model;

import static com.tokio.util.Dados.rolar;

public class Bestas extends Personagem{


    public Bestas(String nome, int puntiVita, int resistenzaArmatura) {
        super(nome, puntiVita, resistenzaArmatura);
    }

    @Override
    public int attacco() {
        return (int) (Math.random() * 91);
    }

}
