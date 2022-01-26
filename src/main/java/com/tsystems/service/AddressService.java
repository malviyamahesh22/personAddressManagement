package com.tsystems.service;

import com.tsystems.Exception.NoDataFoundException;
import com.tsystems.data.Address;
import com.tsystems.data.Person;
import com.tsystems.data.PersonInfo;
import com.tsystems.entity.AddressEntity;
import com.tsystems.entity.PersonEntity;
import com.tsystems.gateway.AddressGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahesh on 26-01-2022.
 */

@Service
public class AddressService {

    @Autowired
    AddressGateway addressGateway;

    public PersonInfo getAddressOfPerson(Integer id) {
        PersonInfo personInfo = new PersonInfo();
        Person person = new Person();
        Address address = new Address();
        PersonEntity personEntity = addressGateway.getPersonInfo(id);
        AddressEntity addressEntity = addressGateway.getAddressInfo(id);

        if (personEntity != null) {
            person.setFirstName(personEntity.getFirstName());
            person.setLastName(personEntity.getLastName());
            person.setPersonId(personEntity.getId());

            if (addressEntity != null ) {
                address.setAddress1(addressEntity.getAddress1());
                address.setAddress2(addressEntity.getAddress2());
                address.setCity(addressEntity.getCity());
                address.setCountry(addressEntity.getCountry());
                address.setPincode(addressEntity.getPincode());
                address.setState(addressEntity.getState());
            }
        } else {
            throw new NoDataFoundException("Person not found for ID " + id);
        }

        personInfo.setPerson(person);
        personInfo.setAddress(address);

        return personInfo;
    }

    public List<PersonInfo> getAllPersonInfo() {
        List<PersonInfo> personInfoList = new ArrayList<>();
        List<PersonEntity> personEntityList = addressGateway.getAllPerson();
        List<AddressEntity> addressEntityList = addressGateway.getAllAddress();

        for (PersonEntity personEntity :  personEntityList) {
            for (AddressEntity addressEntity : addressEntityList) {
                if (personEntity.getId() == addressEntity.getId()) {
                    PersonInfo personInfo = new PersonInfo();
                    Person person = new Person();
                    Address address = new Address();
                    person.setPersonId(personEntity.getId());
                    person.setFirstName(personEntity.getFirstName());
                    person.setLastName(personEntity.getLastName());

                    address.setAddress1(addressEntity.getAddress1());
                    address.setAddress2(addressEntity.getAddress2());
                    address.setCity(addressEntity.getCity());
                    address.setCountry(addressEntity.getCountry());
                    address.setPincode(addressEntity.getPincode());
                    address.setState(addressEntity.getState());

                    personInfo.setPerson(person);
                    personInfo.setAddress(address);
                    personInfoList.add(personInfo);
                }
            }
        }

        return personInfoList;
    }

    public void addAddressPersonInfo(PersonInfo personInfo) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(personInfo.getPerson().getFirstName());
        personEntity.setLastName(personInfo.getPerson().getLastName());

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress1(personInfo.getAddress().getAddress1());
        addressEntity.setAddress2(personInfo.getAddress().getAddress2());
        addressEntity.setCity(personInfo.getAddress().getCity());
        addressEntity.setCountry(personInfo.getAddress().getCountry());
        addressEntity.setPincode(personInfo.getAddress().getPincode());
        addressEntity.setState(personInfo.getAddress().getState());

        addressGateway.addPersonInfo(personEntity);
        addressGateway.addAddressInfo(addressEntity);
    }

    public void updateAddressPersonInfo(Integer personId, PersonInfo personInfo) {

        PersonEntity personEntity = addressGateway.getPersonInfo(personId);
        AddressEntity addressEntity = addressGateway.getAddressInfo(personId);

        personEntity.setFirstName(personInfo.getPerson().getFirstName());
        personEntity.setLastName(personInfo.getPerson().getLastName());
        personEntity.setId(personId);

        addressEntity.setAddress1(personInfo.getAddress().getAddress1());
        addressEntity.setAddress2(personInfo.getAddress().getAddress2());
        addressEntity.setCity(personInfo.getAddress().getCity());
        addressEntity.setCountry(personInfo.getAddress().getCountry());
        addressEntity.setPincode(personInfo.getAddress().getPincode());
        addressEntity.setState(personInfo.getAddress().getState());
        addressEntity.setId(personId);

        addressGateway.updatePersonInfo(personEntity);
        addressGateway.updateAddressInfo(addressEntity);
    }

    public void deleteAddressPersonInfo(Integer personId) {

        addressGateway.deletePersonInfo(personId);
        addressGateway.deleteAddressInfo(personId);
    }

}
