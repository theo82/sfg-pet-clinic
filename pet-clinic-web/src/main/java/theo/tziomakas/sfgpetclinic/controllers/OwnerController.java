package theo.tziomakas.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {


    @RequestMapping({"","/","/index.html","/index"})
    public String listOwners(){
        return "owners/index";
    }

}
