package theo.tziomakas.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import theo.tziomakas.sfgpetclinic.model.Pet;
import theo.tziomakas.sfgpetclinic.model.Vet;
import theo.tziomakas.sfgpetclinic.repositories.VetRepository;
import theo.tziomakas.sfgpetclinic.services.PetService;
import theo.tziomakas.sfgpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<>();

        vetRepository.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
         vetRepository.delete(object);
    }

    @Override
    public void deleteId(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
