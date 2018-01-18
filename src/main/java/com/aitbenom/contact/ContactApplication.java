package com.aitbenom.contact;

import com.aitbenom.contact.DAO.ContactRepository;
import com.aitbenom.contact.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		DateFormat df = new SimpleDateFormat(("dd/MM/yyyy"));
	contactRepository.save ( new Contact("ait benaissa", "omar",df.parse("13/04/1991"),"omar.benaissa@outlook.com", "0664941132", "test"));
	contactRepository.save ( new Contact("Rhallab", "Chaimae",df.parse("13/04/1991"),"omar.benaissa@outlook.com", "0664941132", "test"));
	contactRepository.save ( new Contact("Lamnini", "ilias",df.parse("13/04/1991"),"omar.benaissa@outlook.com", "0664941132", "test"));
	contactRepository.findAll().forEach(
			c->{
				System.out.println(c.getNom());
			}
	);
	}
}
