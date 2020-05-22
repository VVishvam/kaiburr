package com.vishvam.KaiburrRest.repository;

import com.vishvam.KaiburrRest.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServerRepository extends MongoRepository<Server,String> {

    List<Server> findByName(String name);
}
