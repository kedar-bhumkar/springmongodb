package com.mdbspringboot.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mdbspringboot.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    
    @Query("{name:'?0'}")
    User findUserByName(String name);

    @Query(value="{id:'?0'}")
    List<User> findAll(String id);
    
    public long count();

}