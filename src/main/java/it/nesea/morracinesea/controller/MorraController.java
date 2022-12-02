package it.nesea.morracinesea.controller;

import it.nesea.morracinesea.service.GiocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/morra-cinesea")
public class MorraController {
    @Autowired
    GiocoService giocoService;

    @GetMapping("/gioca")
    public String home(Model model) {
        model.addAttribute("mossa", new MorraCineseForm());
        model.addAttribute("esito", new EsitoGioco());
        return "index";
    }

    @PostMapping("/gioca")
    public String gioca(@ModelAttribute MorraCineseForm morraCineseForm, Model model) {
        EsitoGioco esitoGioco = giocoService.giocaPartita(morraCineseForm.getMossa());
        model.addAttribute("esito", esitoGioco);
        model.addAttribute("mossa", new MorraCineseForm());
        return "index";
    }



}
