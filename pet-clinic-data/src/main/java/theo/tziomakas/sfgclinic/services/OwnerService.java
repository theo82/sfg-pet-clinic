package theo.tziomakas.sfgclinic.services;

import theo.tziomakas.sfgclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>  {

    Owner findLastName(String lastName);

}
