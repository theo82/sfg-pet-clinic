package theo.tziomakas.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import theo.tziomakas.sfgpetclinic.services.VetService;

import javax.jws.WebParam;

@Controller
public class VetController {

    VetService vetService;


    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index.html","vets/index"})
    public String listVets(Model model){

        model.addAttribute("vets",vetService.findAll());

        return "vets/index";
    }
}
