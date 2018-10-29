package theo.tziomakas.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import theo.tziomakas.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String name);

}
