package theo.tziomakas.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import theo.tziomakas.sfgpetclinic.model.Speciality;
import theo.tziomakas.sfgpetclinic.services.SpecialityService;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long>
        implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteId(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
