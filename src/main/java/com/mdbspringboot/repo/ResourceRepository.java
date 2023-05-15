package com.mdbspringboot.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mdbspringboot.model.Resource;

public interface ResourceRepository extends MongoRepository<Resource, String> {
    
    @Query(value="{type:'?0',default_access:'?1'}")
    List<Resource> findByType(String type, String default_access);

    @Query(value="{default_access:'?0'}")
    List<Resource> findAll(String default_access);

    @Query(value="{name:'?0'}")
    Resource findByName(String name);

 
    public long count();

}