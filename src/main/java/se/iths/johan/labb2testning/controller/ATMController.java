package se.iths.johan.labb2testning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.johan.labb2testning.service.ATMService;

@Controller
@RequestMapping("/atm")
public class ATMController {

    private final ATMService atmService;

    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping
    public String balance(Model model) {
        model.addAttribute("balance", atmService.getBalance());
        return "atm";

    }

}
