package com.contactmanager.contactmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contactmanager.contactmanager.entity.Contact;


@Service
public interface  ContactService {
    
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Long id);
    Contact createContact(Contact contact);
    Contact updateContact(Long id, Contact updatedContact);
    void deletedContact(Long id);

}
