package theo.tziomakas.sfgpetclinic.services;

import theo.tziomakas.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>  {

    Owner findLastName(String lastName);

}
