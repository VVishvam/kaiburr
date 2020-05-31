package com.vishvam.KaiburrRest.controller;

import com.vishvam.KaiburrRest.model.Server;
import com.vishvam.KaiburrRest.repository.ServerRepository;
import com.vishvam.KaiburrRest.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Server> getServerById(@PathVariable("id") String id){
        System.out.println("Fetching by id");
        Optional<Server> s = serverService.findById(id);
        return s.map(server -> new ResponseEntity<>(server, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<Server>> getServerByName(@PathVariable("name") String name){
        System.out.println("Fetching by name");
        List<Server> servers = serverService.findByName(name);
        if(!servers.isEmpty()){
            return new ResponseEntity<>(servers, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<Server>> getServers(){
        System.out.println("Fetching all servers for you");
        List<Server> s = serverService.findAll();
        if(!s.isEmpty()){
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<String> putServer(@RequestBody Server server){
        serverService.save(server);
        return new ResponseEntity<>("Saved",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServer(@PathVariable("id") String id){
        if(serverService.findById(id).isPresent()){
            serverService.deleteById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }

        return new ResponseEntity<>("Id not found: "+id,HttpStatus.NOT_FOUND);
    }


}
