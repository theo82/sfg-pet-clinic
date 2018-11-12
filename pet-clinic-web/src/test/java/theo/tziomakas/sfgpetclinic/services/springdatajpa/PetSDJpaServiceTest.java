package theo.tziomakas.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import theo.tziomakas.sfgpetclinic.model.Pet;
import theo.tziomakas.sfgpetclinic.repositories.PetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetSDJpaService service;

    Pet returnedPet;

    @BeforeEach
    void setUp() {

        returnedPet = Pet.builder().id(1L).build();

    }

    @Test
    void findAll() {

        Set<Pet> returnedPetOwner = new HashSet<>();
        returnedPetOwner.add(Pet.builder().id(1L).build());
        returnedPetOwner.add(Pet.builder().id(1L).build());

        when(petRepository.findAll()).thenReturn(returnedPetOwner);

        Set<Pet> pets = service.findAll();
        assertNotNull(pets);
        assertEquals(2,pets.size());

    }

    @Test
    void findById() {

        when(petRepository.findById(anyLong())).thenReturn(Optional.of(returnedPet));

        Pet pet = service.findById(1L);

        assertNotNull(pet);

    }

    @Test
    void save() {

        Pet petToSave = Pet.builder().id(1L).build();

        when(petRepository.save(any())).thenReturn(petToSave);

        Pet savedPet = service.save(petToSave);

        assertNotNull(savedPet);

        verify(petRepository).save(any());
    }

    @Test
    void delete() {

        service.delete(returnedPet);

        verify(petRepository,times(1)).delete(any());
    }

    @Test
    void deleteId() {

        service.deleteId(1L);

        verify(petRepository, times(1)).deleteById(anyLong());

    }
}