package com.tsystems.gateway;

import com.tsystems.entity.AddressEntity;
import com.tsystems.entity.PersonEntity;
import com.tsystems.repository.AddressRepo;
import com.tsystems.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mahesh on 26-01-2022.
 */

@Component
public class AddressGateway {

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    PersonRepo personRepo;

    public PersonEntity getPersonInfo(Integer id) {
        Optional<PersonEntity> personEntityOptional = personRepo.findById(id);
        PersonEntity personEntity = personEntityOptional.isPresent() ? personEntityOptional.get() : null;
        return personEntity;
    }

    public List<PersonEntity> getAllPerson() {
        List<PersonEntity> personEntityList = personRepo.findAll();
        return personEntityList;
    }

    public AddressEntity getAddressInfo(Integer id) {
        Optional<AddressEntity> addressEntityOptional = addressRepo.findById(id);
        AddressEntity addressEntity = addressEntityOptional.isPresent() ? addressEntityOptional.get() : null;
        return addressEntity;
    }

    public List<AddressEntity> getAllAddress() {
        List<AddressEntity> addressEntityList = addressRepo.findAll();
        return addressEntityList;
    }

    public void addPersonInfo(PersonEntity personEntity) {
        Integer personId = personRepo.getMaxPersonId();
        personEntity.setId(personId+1);
        personRepo.save(personEntity);
    }

    public void addAddressInfo(AddressEntity addressEntity) {
        Integer personId = personRepo.getMaxPersonId();
        addressEntity.setId(personId);
        addressRepo.save(addressEntity);
    }

    public void updatePersonInfo(PersonEntity personEntity) {
        personRepo.save(personEntity);
    }

    public void updateAddressInfo(AddressEntity addressEntity) {
        addressRepo.save(addressEntity);
    }

    public void deletePersonInfo(Integer id) {
        personRepo.deleteById(id);
    }

    public void deleteAddressInfo(Integer id) {
        addressRepo.deleteById(id);
    }

}
