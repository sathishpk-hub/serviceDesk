package com.energia.ticket.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.energia.ticket.entity.Ticket;

@Repository
public interface ProductRepository extends JpaRepository<Ticket, Long> {
	
	@Query(value = "SELECT t FROM Ticket t WHERE t.name LIKE '%' || :keyword || '%'"
			+ " OR t.email LIKE '%' || :keyword || '%' "
			+ " OR t.pbmDesc LIKE '%' || :keyword || '%'"
			+ " OR t.priority LIKE '%' || :keyword || '%'")
	public List<Ticket> search(@Param("keyword") String keyword);

}
