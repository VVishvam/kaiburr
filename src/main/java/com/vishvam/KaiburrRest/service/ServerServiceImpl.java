package com.vishvam.KaiburrRest.service;

import com.vishvam.KaiburrRest.model.Server;
import com.vishvam.KaiburrRest.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerServiceImpl implements ServerService{

    private final ServerRepository serverRepository;

    public ServerServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public List<Server> findByName(String name) {
        return serverRepository.findByName(name);
    }

    @Override
    public Optional<Server> findById(String id) {
        return serverRepository.findById(id);
    }

    @Override
    public List<Server> findAll() {
        return serverRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        serverRepository.deleteById(id);
    }

    @Override
    public void save(Server s) {
        serverRepository.save(s);
    }
}
