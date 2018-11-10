package theo.tziomakas.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import theo.tziomakas.sfgpetclinic.model.Owner;
import theo.tziomakas.sfgpetclinic.model.Pet;
import theo.tziomakas.sfgpetclinic.model.PetType;
import theo.tziomakas.sfgpetclinic.services.OwnerService;
import theo.tziomakas.sfgpetclinic.services.PetService;
import theo.tziomakas.sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            if(object.getPets()!=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }else{
                        throw new RuntimeException("Pet type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public void deleteId(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
