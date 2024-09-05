package com.tokio.model;

public abstract class Personagem {
    protected String nome;
    protected int puntosVida;
    protected int resistênciaarmadura;

    public Personagem(String nome, int puntosVida, int resistênciaarmadura) {
        this.nome = nome;
        this.puntosVida = puntosVida;
        this.resistênciaarmadura = resistênciaarmadura;
    }

    public boolean isAlive() {
        return puntosVida > 0;
    }

    public abstract int attacco();

    public void subisciDanno(int danno) {
        puntosVida -= danno;
        if (puntosVida < 0) puntosVida = 0;  // La vita non può andare sotto zero
    }

    public int getResistenzaArmatura() {
        return resistênciaarmadura;
    }

    @Override
    public String toString() {
        return
                "Tipo: "+ getClass().getSimpleName() +
                ", nome='" + getNome() + '\'' +
                ", puntosVida=" + getPuntosVida() +
                ", resistênciaarmadura=" + getResistênciaarmadura();
    }

    public String getNome() {
        return nome;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getResistênciaarmadura() {
        return resistênciaarmadura;
    }
}
