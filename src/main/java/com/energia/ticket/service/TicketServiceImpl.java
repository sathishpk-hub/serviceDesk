package com.energia.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.energia.ticket.dao.TicketDaoIntf;
import com.energia.ticket.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketServiceIntf {

	@Autowired
	private TicketDaoIntf ticketDaoIntf;
	
	@Override
	public void addTicket(Ticket ticket) {
		ticketDaoIntf.addTicket(ticket);
		
	}

	@Override
	public List<Ticket> listTickets() {
		return ticketDaoIntf.listTickets();
	}

	@Override
	public Ticket getTicket(Long ticketId) {
		return ticketDaoIntf.getTicket(ticketId);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		ticketDaoIntf.deleteTicket(ticket);
		
	}

	@Override
	public List<Ticket> search(String keyword) {
		return ticketDaoIntf.search(keyword);
	}

}
