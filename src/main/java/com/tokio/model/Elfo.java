package com.tokio.model;

public class Elfo extends Heroi{

    public Elfo(String nome, int puntiVita, int resistenzaArmatura) {
        super(nome, puntiVita, resistenzaArmatura);
    }

    @Override
    public int attacco() {
        int potenzaAttacco = super.attacco();
        // Bonus contro Orchi
        return potenzaAttacco + 10;
    }

}
