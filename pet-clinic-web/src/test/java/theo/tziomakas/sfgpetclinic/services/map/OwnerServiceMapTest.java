package theo.tziomakas.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theo.tziomakas.sfgpetclinic.model.Owner;
import theo.tziomakas.sfgpetclinic.services.PetService;
import theo.tziomakas.sfgpetclinic.services.PetTypeService;
import theo.tziomakas.sfgpetclinic.services.springdatajpa.PetTypeSDJpaService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "Theo";

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1,ownerSet.size());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
    }

    @Test
    void deleteId() {

        ownerServiceMap.deleteId(ownerId);

        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {

        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findLastName() {
        Owner theo = ownerServiceMap.findLastName(lastName);

        assertNotNull(theo);

        assertEquals(ownerId, theo.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerServiceMap.findLastName("foo");

        assertNull(smith);
    }
}