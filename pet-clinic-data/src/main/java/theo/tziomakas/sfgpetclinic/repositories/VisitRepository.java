package theo.tziomakas.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import theo.tziomakas.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
