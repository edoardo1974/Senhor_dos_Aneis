package com.tokio.service;
import com.tokio.model.*;
import java.util.Iterator;
import java.util.List;

public class Battalha {

    private List<Personagem> heroi;
    private List<Personagem> bestas;
    int turno = 0;

    public Battalha(List<Personagem> heroi, List<Personagem> bestas) {
        this.heroi = heroi;
        this.bestas = bestas;
    }

    public String comecar() {//Ciclo que inicia a batalha
        StringBuilder resultouBatalha = new StringBuilder();

        while (!heroi.isEmpty() && !bestas.isEmpty()) {
            turno ++;
            resultouBatalha.append("------------Turno: " + turno+"\n");
            resultouBatalha.append(turnodeCombate());
        }
        if (heroi.isEmpty()) {
            resultouBatalha.append("Os Bestas venceram!!\n");
        } else {
            resultouBatalha.append("Os Heróis venceram!!\n");
        }
        return resultouBatalha.toString();
    }

    private String turnodeCombate() {//Turno de combate quem decide que guerreiros enfrentar
        Iterator<Personagem> heroiIterator = heroi.iterator();
        Iterator<Personagem> bestasIterator = bestas.iterator();

        StringBuilder resultouBatalha = new StringBuilder();

        while (heroiIterator.hasNext() && bestasIterator.hasNext()) {
            Personagem hero = heroiIterator.next();
            Personagem beast = bestasIterator.next();

            if (hero instanceof Elfo && beast instanceof Orco) {
                int ataqueHeroielfo = hero.ataque();
                ataqueHeroielfo += 10;
                resultouBatalha.append(imprimirLuta(hero, beast, ataqueHeroielfo));
                resultouBatalha.append(calcularDano(hero, beast, ataqueHeroielfo));
            }
            else if(hero instanceof Hobbit && beast instanceof Troll) {
                int ataqueHeroihobbit = hero.ataque();
                ataqueHeroihobbit -= 5;
                resultouBatalha.append(imprimirLuta(hero, beast, ataqueHeroihobbit));
                resultouBatalha.append(calcularDano(hero, beast, ataqueHeroihobbit));
            }
            else {
                int ataqueHeroihomem = hero.ataque();
                resultouBatalha.append(imprimirLuta(hero, beast, ataqueHeroihomem));
                resultouBatalha.append(calcularDano(hero, beast, ataqueHeroihomem));
            }

            if((beast.isAlive())){
                if (beast instanceof Orco) {
                    ((Orco) beast).reduzirarmadura(hero);
                }
                int ataqueBesta = beast.ataque();
                resultouBatalha.append(imprimirLuta(beast, hero, ataqueBesta));
                resultouBatalha.append(calcularDano(beast, hero, ataqueBesta));
            }

            if (!hero.isAlive()) heroiIterator.remove();//Se o herói morrer, ele é removido da lista
            if (!beast.isAlive()) bestasIterator.remove();
        }
        return resultouBatalha.toString();
    }



    private String calcularDano(Personagem atacante, Personagem defensor, int poderdeataque) {//Calcula o dano causado pelo ataque
        StringBuilder resultouBatalha = new StringBuilder();
        if (poderdeataque > defensor.getResistênciaarmadura()) {//se o poder do ataque for superior à resistência da armadura do defensor.
            int danno = poderdeataque - defensor.getResistênciaarmadura();
            defensor.sofrerdano(danno);
            resultouBatalha.append(atacante.getNome()+" saca " + poderdeataque +" e tira "+ danno +" de vida a "+ defensor.getNome()+"\n");
        }
        else {
            resultouBatalha.append(atacante.getNome()+" saca " + poderdeataque +" e non tira vida a "+ defensor.getNome()+"\n");
        }
        return resultouBatalha.toString();
    }


    private String imprimirLuta(Personagem personagem1, Personagem personagem2, int ataque) {//Imprime a luta
        StringBuilder resultadoBatalha = new StringBuilder();
        resultadoBatalha.append("Luta entre: ").append(personagem1.getNome())
                .append(" ( Vida= ").append(personagem1.getPuntosVida())
                .append(" Armadura= ").append(personagem1.getResistênciaarmadura())
                .append(") e ").append(personagem2.getNome())
                .append(" ( Vida= ").append(personagem2.getPuntosVida())
                .append(" Armadura= ").append(personagem2.getResistênciaarmadura())
                .append(")\n");
        return resultadoBatalha.toString();
    }
}



