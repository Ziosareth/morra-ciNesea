package it.nesea.morracinesea.service;

import it.nesea.morracinesea.controller.EsitoGioco;
import it.nesea.morracinesea.entity.StatisticheEntity;
import it.nesea.morracinesea.repository.StatisticheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GiocoService {

    public static final String VINCE_IL_PC = "Vince il PC";
    public static final String VINCE_IL_GIOCATORE = "vince il Giocatore";

    @Autowired
    StatisticheRepository statisticheRepository;

    public EsitoGioco giocaPartita(String mossa) {
        EsitoGioco esitoGioco = new EsitoGioco();
        if (mossa.equalsIgnoreCase("forbice") || mossa.equalsIgnoreCase("sasso") || mossa.equalsIgnoreCase("carta")) {
            String mossaPc = mossaComputer();
            esitoGioco.setMossaGiocatore(mossa);
            esitoGioco.setMossaComputer(mossaPc);
            String verificaVincitore = verificaVincitore(mossa, mossaPc);
            esitoGioco.setEsito(verificaVincitore);
            Optional<StatisticheEntity> optStat = statisticheRepository.findById(1L);
            StatisticheEntity newStat;
            if (optStat.isPresent()){
                //update
                StatisticheEntity oldStat = optStat.get();
                if (esitoGioco.getEsito().equals(VINCE_IL_GIOCATORE))
                    oldStat.setPartiteVinte(oldStat.getPartiteVinte()+1);
                else
                    oldStat.setPartitePerse(oldStat.getPartitePerse()+1);
                oldStat.setTotalePartite(oldStat.getTotalePartite()+1);
                newStat = statisticheRepository.save(oldStat);
            }
            else {
                //salva nuova statistica
                StatisticheEntity statisticheEntity = esitoGioco.getEsito().equals(VINCE_IL_GIOCATORE) ? new StatisticheEntity(1L, 1L, 0L, 1L) : new StatisticheEntity(1L, 1L, 1L, 0L);
                newStat = statisticheRepository.save(statisticheEntity);
            }
            esitoGioco.setStatistiche(newStat);
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
            case "sasso" -> (mossaPC.equals("carta")) ? VINCE_IL_PC : VINCE_IL_GIOCATORE;
            case "carta" -> (mossaPC.equals("forbice")) ? VINCE_IL_PC : VINCE_IL_GIOCATORE;
            case "forbice" -> (mossaPC.equals("sasso")) ? VINCE_IL_PC : VINCE_IL_GIOCATORE;
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
