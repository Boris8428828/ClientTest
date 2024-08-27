package test.clienttest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.clienttest.Entity.ContactEntity;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    List<ContactEntity> findByClientId(Long clientId);
    List<ContactEntity> findByClientIdAndContactType(Long clientId, String contactType);
}
