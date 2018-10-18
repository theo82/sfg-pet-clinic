package theo.tziomakas.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import theo.tziomakas.sfgpetclinic.model.Pet;
import theo.tziomakas.sfgpetclinic.model.PetType;
import theo.tziomakas.sfgpetclinic.services.CrudService;
import theo.tziomakas.sfgpetclinic.services.PetService;
import theo.tziomakas.sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long>
                                implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteId(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return findById(id);
    }
}
