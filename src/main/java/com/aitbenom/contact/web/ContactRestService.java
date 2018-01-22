package com.aitbenom.contact.web;

import com.aitbenom.contact.DAO.ContactRepository;
import com.aitbenom.contact.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactRestService {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts(){

        return contactRepository.findAll();
    }
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable Long id){
        return  contactRepository.findOne(id);
    }



    @RequestMapping(value = "/chercherContacts", method = RequestMethod.GET)
    public Page<Contact> chercher(
          @RequestParam(name = "mc", defaultValue = "") String mc,
          @RequestParam(name = "page", defaultValue = "0") int  page,
          @RequestParam(name = "size", defaultValue = "5") int size)
               {
return  contactRepository.chercher("%"+mc+"%",new PageRequest(page, size));
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    public Contact saveContact(@PathVariable Long id,@RequestBody Contact contact){
   contact.setId(id);
        return  contactRepository.save(contact);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact saveContact(@RequestBody Contact contact){
        return  contactRepository.save(contact);
    }


    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public boolean deleteetContact(@PathVariable Long id){
       contactRepository.delete(id);
       return true;
    }

    
}
