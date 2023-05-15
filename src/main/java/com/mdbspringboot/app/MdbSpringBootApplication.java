package com.mdbspringboot.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mdbspringboot.model.Resource;
import com.mdbspringboot.model.User;
import com.mdbspringboot.repo.ResourceRepository;
import com.mdbspringboot.repo.UserRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.mdbspringboot")
@ComponentScan(basePackages = {"com.mdbspringboot.repo", "com.mdbspringboot.model","com.mdbspringboot.web"})

public class MdbSpringBootApplication implements CommandLineRunner{
    
    
	@Autowired
    UserRepository userRepo;

	@Autowired
    ResourceRepository resourceRepo;
    
    public static void main(String[] args) {
		
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

	public void run(String... args) {
		/*System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");
        createGroceryItems();
        System.out.println("\n----------------SHOW ALL GROCERY ITEMS---------------------------\n");
        showAllGroceryItems();*/

		createUsers();
		getAllUsers();
		getUser("u1");

		createResources();

	}	
	//     public Resource(String id, String name, String type, String default_access, String status) {

	private void createResources() {
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus imperdiet, nulla et dictum interdum, nisi lorem egestas odio, vitae scelerisque enim ligula venenatis dolor.";

		//app
		resourceRepo.save( new Resource("r1", "ADMIN_PORTAL", "APP", "private","active"));
		resourceRepo.save (new Resource("r2", "PHYSICAN_PORTAL", "APP", "public","active"));
		resourceRepo.save( new Resource("r3", "FACILITY_PORTAL", "APP", "public","active"));

		//facility menu
		resourceRepo.save( new Resource("r4", "app-contracts", "FACILITY_MENU", "private","active"));
		resourceRepo.save( new Resource("r5", "app-reports", "FACILITY_MENU", "public","active"));
		resourceRepo.save( new Resource("r6", "app-education", "FACILITY_MENU", "public","active"));
		resourceRepo.save( new Resource("r7", "app-chatbot", "FACILITY_MENU", "public","active"));


		//education 
		Resource r1 = new Resource("r8", "facilitybinder", "FACILITY_EDUCATION", "public","active");
		Resource r2 = new Resource("r9", "optum101", "FACILITY_EDUCATION", "public","active");
		Resource r3 = new Resource("r10", "onepager", "FACILITY_EDUCATION", "public","active");

		Resource.Metadata m1 = r1.new Metadata("Binder","https://www.africau.edu/images/default/sample.pdf", description);
		ArrayList<Resource.Metadata> theList1 = new ArrayList<Resource.Metadata>();
		theList1.add(m1);
		r1.setMetadata(theList1);

		Resource.Metadata m2 = r2.new Metadata("Introduction to Optum","https://www.africau.edu/images/default/sample.pdf", description);
		ArrayList<Resource.Metadata> theList2 = new ArrayList<Resource.Metadata>();
		theList2.add(m2);
		r2.setMetadata(theList2);

		Resource.Metadata m3 = r3.new Metadata("One pager 1","https://www.africau.edu/images/default/sample.pdf", description);
		Resource.Metadata m4 = r3.new Metadata("One pager 2","https://www.africau.edu/images/default/sample.pdf", description);
		Resource.Metadata m5 = r3.new Metadata("One pager 3","https://www.africau.edu/images/default/sample.pdf", description);
		Resource.Metadata m6 = r3.new Metadata("One pager 4","https://www.africau.edu/images/default/sample.pdf", description);
		ArrayList<Resource.Metadata> theList3 = new ArrayList<Resource.Metadata>();
		theList3.add(m3);theList3.add(m4);theList3.add(m5);theList3.add(m6);
		r3.setMetadata(theList3);


		resourceRepo.save(r1);
		resourceRepo.save(r2);
		resourceRepo.save(r3);

		
	}

	private void getUser(String id) {
		userRepo.findAll(id).forEach(item -> System.out.println(item));
	}

	void createUsers(){
		System.out.println("Data creation started...");

		//Katrina
		User u1 = new User("0071001", "Katrina user");
		User.Role r1 = u1.new Role("r2","1234567", "MPIN", "MN", "St.Jude senior living");
		ArrayList<User.Role> theList = new ArrayList<User.Role>();
		theList.add(r1);
		u1.setRoles(theList);
		userRepo.save(u1);

		//Adam
		User u2 = new User("1081901", "Adam admin");
		User.Role r2 = u2.new Role("r1","1234567", "MPIN", "MN", "St.Jude senior living");
		ArrayList<User.Role> theList2 = new ArrayList<User.Role>();
		theList2.add(r2);
		u2.setRoles(theList2);


		u2.setResource(List.of(new Resource("r1", "ADMIN_PORTAL", "APP", "","active")));
		//u2.getResource().add( new Resource("r4", "app-contracts", "FACILITY_MENU", "private","active"));
		userRepo.save(u2);

	}

	public void getAllUsers() {
         
		userRepo.findAll().forEach(item -> System.out.println(item));
	}

	
	

}