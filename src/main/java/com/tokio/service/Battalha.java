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

    public String comecar() {
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

    private String turnodeCombate() {
        Iterator<Personagem> heroiIterator = heroi.iterator();
        Iterator<Personagem> bestasIterator = bestas.iterator();

        StringBuilder resultouBatalha = new StringBuilder();

        while (heroiIterator.hasNext() && bestasIterator.hasNext()) {
            Personagem hero = heroiIterator.next();
            Personagem beast = bestasIterator.next();

            if (hero instanceof Elfo && beast instanceof Orco) {
                int ataqueHeroielfo = hero.attacco();
                ataqueHeroielfo += 10;
                resultouBatalha.append(imprimirLuta(hero, beast, ataqueHeroielfo));
                resultouBatalha.append(calcolaDanno(hero, beast, ataqueHeroielfo));
            }
            else if(hero instanceof Hobbit && beast instanceof Troll) {
                int ataqueHeroihobbit = hero.attacco();
                ataqueHeroihobbit -= 5;
                resultouBatalha.append(imprimirLuta(hero, beast, ataqueHeroihobbit));
                resultouBatalha.append(calcolaDanno(hero, beast, ataqueHeroihobbit));
            }
            else {
                int ataqueHeroihomem = hero.attacco();
                resultouBatalha.append(imprimirLuta(hero, beast, ataqueHeroihomem));
                resultouBatalha.append(calcolaDanno(hero, beast, ataqueHeroihomem));
            }

            if((beast.isAlive())){
                if (beast instanceof Orco) {
                    ((Orco) beast).reduzirarmadura(hero);
                }
                int ataqueBesta = beast.attacco();
                resultouBatalha.append(imprimirLuta(beast, hero, ataqueBesta));
                resultouBatalha.append(calcolaDanno(beast, hero, ataqueBesta));
            }

            if (!hero.isAlive()) heroiIterator.remove();
            if (!beast.isAlive()) bestasIterator.remove();
        }
        return resultouBatalha.toString();
    }


    private String calcolaDanno(Personagem attaccante, Personagem difensore, int potenzaAttacco) {
        StringBuilder resultouBatalha = new StringBuilder();
        if (potenzaAttacco > difensore.getResistenzaArmatura()) {//se la potenza dell'attacco è maggiore della resistenza dell'armatura del difensore
            int danno = potenzaAttacco - difensore.getResistenzaArmatura();
            difensore.subisciDanno(danno);
            resultouBatalha.append(attaccante.getNome()+" saca " + potenzaAttacco +" e tira "+ danno +" de vida a "+ difensore.getNome()+"\n");
        }
        else {
            resultouBatalha.append(attaccante.getNome()+" saca " + potenzaAttacco +" e non tira vida a "+ difensore.getNome()+"\n");
        }
        return resultouBatalha.toString();
    }


    private String imprimirLuta(Personagem personagem1, Personagem personagem2, int ataque) {
        StringBuilder resultadoBatalha = new StringBuilder();
        resultadoBatalha.append("Luta entre: ").append(personagem1.getNome())
                .append(" ( Vida= ").append(personagem1.getPuntosVida())
                .append(" Armadura= ").append(personagem1.getResistenzaArmatura())
                .append(") e ").append(personagem2.getNome())
                .append(" ( Vida= ").append(personagem2.getPuntosVida())
                .append(" Armadura= ").append(personagem2.getResistenzaArmatura())
                .append(")\n");
        //resultadoBatalha.append("Ataque: ").append(ataque).append("\n");
        return resultadoBatalha.toString();
    }
}



