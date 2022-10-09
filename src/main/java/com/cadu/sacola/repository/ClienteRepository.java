package com.cadu.sacola.repository;

import com.cadu.sacola.model.Cliente;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaAttributeConverter<Cliente, Long> {
}
