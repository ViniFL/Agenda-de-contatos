package com.vinicius.schedule.controllers;

import com.vinicius.schedule.entities.Contacts;
import com.vinicius.schedule.repositories.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/contacts")
public class ContactsController {

    @Autowired
    private ContactsRepository contactsRepository;

    @GetMapping
    public ResponseEntity<List<Contacts>> getAllContacts() {
        List<Contacts> contactsList = contactsRepository.findAll();
        return ResponseEntity.ok(contactsList);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Contacts> newContact(@RequestBody Contacts contacts) {
        Contacts newContact = contactsRepository.save(contacts);
        return ResponseEntity.status(HttpStatus.CREATED).body(newContact);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable Long id) {
        Optional<Contacts> contactOptional = contactsRepository.findById(id);
        if (contactOptional.isPresent()) {
            Contacts contact = contactOptional.get();
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeContact(@PathVariable Long id) {
        Optional<Contacts> contactOptional = contactsRepository.findById(id);
        if (contactOptional.isPresent()) {
            contactsRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
