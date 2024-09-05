package com.tokio.model;

public class Orco extends Bestas{
    public Orco(String nome, int puntiVita, int resistenzaArmatura) {
        super(nome, puntiVita, resistenzaArmatura);
    }

    @Override
    public int attacco() {
        int potenzaAttacco = super.attacco();
        // Riduzione armatura avversario
        return potenzaAttacco;
    }

    public void reduzirarmadura(Personagem avversario) {
        int riduzione = (int) (avversario.getResistenzaArmatura() * 0.1);
        avversario.resistênciaarmadura -= riduzione;
    }

}
