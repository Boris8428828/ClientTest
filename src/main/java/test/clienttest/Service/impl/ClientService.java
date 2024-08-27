package test.clienttest.Service.impl;

import test.clienttest.Entity.ClientEntity;

import java.util.List;

public interface ClientService {
    ClientEntity createClient(String name);
    ClientEntity getClientById(Long id);
    List<ClientEntity> getAllClients();
}

