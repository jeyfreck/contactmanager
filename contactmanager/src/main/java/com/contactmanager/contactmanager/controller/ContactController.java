package com.contactmanager.contactmanager.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactmanager.contactmanager.service.ContactService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.contactmanager.contactmanager.entity.Contact;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Contact> getContactById(@PathVariable Long id) {
        return contactService.getContactById(id).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.createContact(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Contact updated = contactService.updateContact(id, contact);
        if(updated != null){return ResponseEntity.ok(updated);}
        else{return ResponseEntity.notFound().build();}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id){
        contactService.deletedContact(id);
        return ResponseEntity.noContent().build();
    }
    
}
