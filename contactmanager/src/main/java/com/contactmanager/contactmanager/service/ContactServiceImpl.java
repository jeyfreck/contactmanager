package com.contactmanager.contactmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactmanager.contactmanager.entity.Contact;
import com.contactmanager.contactmanager.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Long id){
        return contactRepository.findById(id);
    }

    @Override
    public Contact createContact(Contact contact){
        return contactRepository.save(contact);
    }

    @Override
public Contact updateContact(Long id, Contact updatedContact) {
    return contactRepository.findById(id).map(contact -> {
        contact.setName(updatedContact.getName());
        contact.setEmail(updatedContact.getEmail());
        contact.setPhone(updatedContact.getPhone());
        return contactRepository.save(contact);
    }).orElse(null);
   }

   @Override
   public void deletedContact(Long id){
    contactRepository.deleteById(id);
   }
}
