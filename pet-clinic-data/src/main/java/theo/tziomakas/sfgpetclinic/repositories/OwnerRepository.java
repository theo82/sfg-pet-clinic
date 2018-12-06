package theo.tziomakas.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import theo.tziomakas.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String name);

    List<Owner> findAllByLastNameLike(String lastName);


}
