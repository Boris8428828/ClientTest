package test.clienttest.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.clienttest.Entity.ClientEntity;
import test.clienttest.Service.ClientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientController {

    ClientServiceImpl clientService;

    @PostMapping
    public ResponseEntity<ClientEntity> createClient(@RequestParam String name) {
        return ResponseEntity.ok(clientService.createClient(name));
    }

    @GetMapping
    public ResponseEntity<List<ClientEntity>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable Long id) {
        ClientEntity client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }
}

