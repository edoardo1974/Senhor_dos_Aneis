package com.tokio.model;

public class Hobbit extends Heroi{

    public Hobbit(String nome, int puntiVita, int resistenzaArmatura) {
        super(nome, puntiVita, resistenzaArmatura);
    }

    @Override
    public int attacco() {
        int potenzaAttacco = super.attacco();
        // Penalità contro Troll
        return potenzaAttacco - 5;
    }
}
