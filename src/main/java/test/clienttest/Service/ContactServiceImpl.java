package test.clienttest.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import test.clienttest.DTO.ContactDTO;
import test.clienttest.Entity.ClientEntity;
import test.clienttest.Entity.ContactEntity;
import test.clienttest.Repository.ClientRepository;
import test.clienttest.Repository.ContactRepository;
import test.clienttest.Service.impl.ContactService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContactServiceImpl implements ContactService {

    ContactRepository contactRepository;
    ClientRepository clientRepository;
    ModelMapper modelMapper;
    ;

    @Override
    public ContactEntity addContact(ContactDTO contactDTO) {
        ContactEntity contact = convertToEntity(contactDTO);
        ClientEntity client = clientRepository.findById(contactDTO.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));

        contact.setClient(client);

        return contactRepository.save(contact);
    }

    @Override
    public List<ContactDTO> getContactsByClientId(Long clientId) {
        List<ContactEntity> contactEntities = contactRepository.findByClientId(clientId);
        return contactEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDTO> getContactsByClientIdAndType(Long clientId, String contactType) {
        List<ContactEntity> contactEntities = contactRepository.findByClientIdAndContactType(clientId, contactType);
        return contactEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ContactEntity convertToEntity(ContactDTO mailingDTO) {
        return modelMapper.map(mailingDTO, ContactEntity.class);
    }

    private ContactDTO convertToDTO(ContactEntity contactEntity) {
        ContactDTO dto = new ContactDTO();
        dto.setId(contactEntity.getId());
        dto.setContactType(contactEntity.getContactType());
        dto.setContactValue(contactEntity.getContactValue());
        dto.setClientId(contactEntity.getClient().getId());
        return dto;
    }
}


