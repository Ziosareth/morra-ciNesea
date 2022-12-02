package it.nesea.morracinesea.controller;

import it.nesea.morracinesea.entity.StatisticheEntity;

public class EsitoGioco {
    private String esito;
    private String mossaGiocatore;
    private String mossaComputer;

    private StatisticheEntity statistiche = new StatisticheEntity();

    public EsitoGioco() {
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public String getMossaGiocatore() {
        return mossaGiocatore;
    }

    public void setMossaGiocatore(String mossaGiocatore) {
        this.mossaGiocatore = mossaGiocatore;
    }

    public String getMossaComputer() {
        return mossaComputer;
    }

    public void setMossaComputer(String mossaComputer) {
        this.mossaComputer = mossaComputer;
    }

    public StatisticheEntity getStatistiche() {
        return statistiche;
    }

    public void setStatistiche(StatisticheEntity statistiche) {
        this.statistiche = statistiche;
    }
}
