package theo.tziomakas.sfgpetclinic.services;

import theo.tziomakas.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>  {

    Owner findLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
