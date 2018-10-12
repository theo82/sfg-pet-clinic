package theo.tziomakas.sfgclinic.services.map;

import theo.tziomakas.sfgclinic.model.Owner;
import theo.tziomakas.sfgclinic.services.CrudService;
import theo.tziomakas.sfgclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
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
        return super.save(object.getId(), object);
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
        return null;
    }
}
