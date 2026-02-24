package com.mchekhashvili.rental.repository.customer;

import com.mchekhashvili.rental.model.customer.document.IdentificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, Long> {
}