package com.tokio.model;



public class Heroi extends Personagem{

    public Heroi(String nome, int puntiVita, int resistenzaArmatura) {
        super(nome, puntiVita, resistenzaArmatura);
    }

    @Override
    public int ataque() {
        int dado1 = (int) (Math.random() * 101);
        int dado2 = (int) (Math.random() * 101);
        return Math.max(dado1, dado2);//viene preso il valore maggiore tra i due dadi
    }




}
