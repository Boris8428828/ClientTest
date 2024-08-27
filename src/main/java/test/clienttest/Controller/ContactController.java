package test.clienttest.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.clienttest.DTO.ContactDTO;
import test.clienttest.Entity.ContactEntity;
import test.clienttest.Service.ContactServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContactController {
    ContactServiceImpl contactService;

    @PostMapping
    public ResponseEntity<ContactEntity> addContact(@RequestBody @Validated ContactDTO contactDTO) {
        return ResponseEntity.ok(contactService.addContact(contactDTO));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ContactDTO>> getContactsByClientId(@PathVariable Long clientId) {

        return ResponseEntity.ok(contactService.getContactsByClientId(clientId));
    }

    @GetMapping("/client/{clientId}/{contactType}")
    public ResponseEntity<List<ContactDTO>> getContactsByClientIdAndType(
            @PathVariable Long clientId, @PathVariable String contactType) {
        return ResponseEntity.ok(contactService.getContactsByClientIdAndType(clientId, contactType));
    }
}

