package theo.tziomakas.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import theo.tziomakas.sfgpetclinic.model.Speciality;
import theo.tziomakas.sfgpetclinic.model.Vet;
import theo.tziomakas.sfgpetclinic.services.SpecialityService;
import theo.tziomakas.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long>
                            implements VetService {

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    private final SpecialityService specialityService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
         super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialitySet().size() > 0){
            object.getSpecialitySet().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }



        return super.save(object);
    }

    @Override
    public void deleteId(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
