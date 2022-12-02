package it.nesea.morracinesea.controller;

import it.nesea.morracinesea.service.GiocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorraRestController {

    @Autowired
    GiocoService giocoService;

    @GetMapping("/gioca/{mossa}")
    public EsitoGioco gioca(@PathVariable String mossa){
        return giocoService.giocaPartita(mossa);
    }
}
