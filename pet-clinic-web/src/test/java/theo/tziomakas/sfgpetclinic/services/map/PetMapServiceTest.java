package theo.tziomakas.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theo.tziomakas.sfgpetclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PetMapServiceTest {

    private PetServiceMap petServiceMap;

    private final Long petId = 1L;

    @BeforeEach
    void setUp(){

        petServiceMap = new PetServiceMap();

        petServiceMap.save(Pet.builder().id(petId).build());

    }

    @Test
    void findAll(){

        Set<Pet> petSet = petServiceMap.findAll();

        assertEquals(1, petSet.size());

    }

    @Test
    void findByIdExistingId(){

        Pet pet = petServiceMap.findById(petId);

        assertEquals(petId, pet.getId());

    }

    @Test
    void findByIdNotExistingId(){
        Pet pet = petServiceMap.findById(5L);

        assertNull(pet);
    }

    @Test
    void findByIdNullId(){
        Pet pet = petServiceMap.findById(null);

        assertNull(pet);
    }

    @Test
    void saveExistingId(){
        Long id = 2L;

        Pet pet2 = Pet.builder().id(id).build();

        Pet savePet = petServiceMap.save(pet2);

        assertEquals(id, savePet.getId());
    }
}
