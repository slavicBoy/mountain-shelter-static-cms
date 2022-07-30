package com.example.mountainsheltercms.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contact")
class Controller {

    @Autowired
    private ContactRepository contactRepository;

    @PutMapping("/{id}")
    @Transactional
    public Contact editContact(@PathVariable Long id, @RequestBody Contact contact) {
        final var contactDB = contactRepository.getById(id);


        contactDB.setAddress(contact.getAddress());
        contactDB.setEmail(contact.getEmail());
        contactDB.setPhoneNumber(contact.getPhoneNumber());
        contactDB.setPaymentAccount(contact.getPaymentAccount());

        return contactDB;
    }

    @GetMapping()
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }


}
