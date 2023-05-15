package com.mdbspringboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mdbspringboot.model.Resource;
import com.mdbspringboot.model.User;
import com.mdbspringboot.repo.ResourceRepository;
import com.mdbspringboot.repo.UserRepository;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRepo;

    
	@Autowired
    ResourceRepository resourceRepo;

    @GetMapping("/user/{id}")
    User getUser(@PathVariable String id) {
      
      User u = userRepo.findAll(id).get(0);
      List<Resource> resources = resourceRepo.findAll("public");
      System.out.println(resources);
      u.getResource().addAll(resources);
      
      return u;
    }

    @GetMapping("/docs/{docType}")
    Resource getDocs(@PathVariable String docType) {
      
      Resource resource = resourceRepo.findByName(docType);
      System.out.println(resource);
     
      
      return resource;
    }
    
}
