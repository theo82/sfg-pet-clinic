package theo.tziomakas.sfgpetclinic.services.map;


import org.springframework.stereotype.Service;
import theo.tziomakas.sfgpetclinic.model.Visit;
import theo.tziomakas.sfgpetclinic.services.VisitService;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteId(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {

        if(visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){

            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
