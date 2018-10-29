package theo.tziomakas.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import theo.tziomakas.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
