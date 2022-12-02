package it.nesea.morracinesea.service;

import it.nesea.morracinesea.controller.EsitoGioco;
import org.springframework.stereotype.Service;

@Service
public class GiocoService {

    public static final String VINCE_IL_PC = "Vince il PC";
    public static final String VINCE_IL_GIOCATORE = "vince il Giocatore";

    public EsitoGioco giocaPartita(String mossa) {
        EsitoGioco esitoGioco = new EsitoGioco();
        if (mossa.toLowerCase().equals("forbice") || mossa.toLowerCase().equals("sasso") || mossa.toLowerCase().equals("carta")) {
            String mossaPc = mossaComputer();
            esitoGioco.setMossaGiocatore(mossa);
            esitoGioco.setMossaComputer(mossaPc);

            String verificaVincitore = verificaVincitore(mossa, mossaPc);
            esitoGioco.setEsito(verificaVincitore);

        } else {
            esitoGioco.setEsito("riprova");
            esitoGioco.setMossaGiocatore(mossa);
        }
        return esitoGioco;
    }

    private String verificaVincitore(String mossaGiocatore, String mossaPC) {
        if (mossaGiocatore.equals(mossaPC)) {
            return "Hai pareggiato";
        }
        //volete un'altra magia? SIIII-- bula bula  
        return switch (mossaGiocatore) {
            case "sasso" ->
                     (mossaPC.equals("carta")) ? VINCE_IL_PC : VINCE_IL_GIOCATORE;
            case "carta" ->  (mossaPC.equals("forbice")) ? VINCE_IL_PC : VINCE_IL_GIOCATORE;
            case "forbice" ->  (mossaPC.equals("sasso")) ? VINCE_IL_PC : VINCE_IL_GIOCATORE;
            default -> throw new RuntimeException("unsupported operation");
        };
        //ora non mi viene in mente altro per striminzirlo, però c'è altro da sistemare, dopo pranzo
    }//buon pranzo a tutti


    private String mossaComputer() {
        String[] mossePossibili = new String[]{"carta", "forbice", "sasso"};
        int scelta = (int) (Math.random() * 3);
        return mossePossibili[scelta];
    }


}
