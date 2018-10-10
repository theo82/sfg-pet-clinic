package theo.tziomakas.sfgclinic.services;

import theo.tziomakas.sfgclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();

}
