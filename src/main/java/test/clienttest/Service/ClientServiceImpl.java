package test.clienttest.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import test.clienttest.Entity.ClientEntity;
import test.clienttest.Repository.ClientRepository;
import test.clienttest.Service.impl.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientEntity createClient(String name) {
        ClientEntity client = new ClientEntity();
        client.setName(name);
        return clientRepository.save(client);
    }

    @Override
    public ClientEntity getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Клиент с ID " + id + " не найден"));
    }

    @Override
    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }
}
