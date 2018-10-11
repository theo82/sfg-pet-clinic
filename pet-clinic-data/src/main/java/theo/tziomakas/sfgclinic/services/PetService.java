package theo.tziomakas.sfgclinic.services;

import theo.tziomakas.sfgclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
