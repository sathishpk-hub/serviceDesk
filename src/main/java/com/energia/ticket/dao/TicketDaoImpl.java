package com.energia.ticket.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.energia.ticket.entity.Ticket;
import com.energia.ticket.repository.ProductRepository;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDaoIntf {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	@Transactional
	public void addTicket(Ticket ticket) {
		
		/*
		 * if(ticket.getId()!=null) { if(!productRepository.existsById(ticket.getId()))
		 * { productRepository.save(ticket); } }else {
		 */
			productRepository.save(ticket);
		//}
		
	}

	@Override
	public List<Ticket> listTickets() {
		return (List<Ticket>) productRepository.findAll();
	}

	@Override
	public Ticket getTicket(Long ticketId) {
		return productRepository.findById(ticketId).get();
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		productRepository.deleteById(ticket.getId());
		
	}

	@Override
	public List<Ticket> search(String keyword) {
		return productRepository.search(keyword);
	}
	
	/*
	 * @Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.email LIKE '%' || :keyword || '%'"
			+ " OR c.address LIKE '%' || :keyword || '%'")
	public List<Ticket> search(@Param("keyword") String keyword);
	 */

}
