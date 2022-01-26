package com.tsystems.controller;

import com.tsystems.data.PersonInfo;
import com.tsystems.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mahesh on 24-01-2022.
 */

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/personInfo")
    public PersonInfo getAddressOfPerson(@RequestParam("personId") Integer personId){
        PersonInfo personInfo = addressService.getAddressOfPerson(personId);
        return personInfo;
    }

    @GetMapping("/allPersonInfo")
    public List<PersonInfo> getAllPersonInfo(){
        List<PersonInfo> personInfo = addressService.getAllPersonInfo();
        return personInfo;
    }


    @PostMapping("/personInfo")
    public String addAddressPersonInfo(@RequestBody PersonInfo personInfo) {
        addressService.addAddressPersonInfo(personInfo);
        return "Person Address details has been saved successfully!!";
    }

    @PutMapping("/updatePersonInfo")
    public String updateAddressPersonInfo(@RequestParam("personId") Integer personId, @RequestBody PersonInfo personInfo) {
        addressService.updateAddressPersonInfo(personId, personInfo);
        return "Person Address details has been updated successfully!!";
    }

    @DeleteMapping("/deletePersonInfo")
    public String deleteAddressPersonInfo(@RequestParam("personId") Integer personId) {
        addressService.deleteAddressPersonInfo(personId);
        return "Person Address details has been deleted successfully!!";
    }
}
