package theo.tziomakas.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import theo.tziomakas.sfgpetclinic.model.Owner;
import theo.tziomakas.sfgpetclinic.services.OwnerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"","/","/index.html","/index"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";

    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){

        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if(results.isEmpty()){
            result.rejectValue("lastName","notFound", "not found");
            return "owners/findOwners";
        }else if(results.size() == 1){
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        }else{
            model.addAttribute("selections",results);
            return "owners/ownersList";
        }

    }


    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){

        if(result.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }else{
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model){
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId){
        if(result.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }else{
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

}
