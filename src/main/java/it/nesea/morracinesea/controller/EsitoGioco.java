package it.nesea.morracinesea.controller;

public class EsitoGioco {
    private String esito;
    private String mossaGiocatore;
    private String mossaComputer;

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
}
