package test.clienttest.Service.impl;

import test.clienttest.DTO.ContactDTO;
import test.clienttest.Entity.ContactEntity;

import java.util.List;

public interface ContactService {
    ContactEntity addContact(ContactDTO contactDTO);
    List<ContactDTO> getContactsByClientId(Long clientId);
    List<ContactDTO> getContactsByClientIdAndType(Long clientId, String contactType);
}

