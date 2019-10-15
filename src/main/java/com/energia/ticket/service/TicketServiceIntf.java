package com.energia.ticket.service;

import java.util.List;

import com.energia.ticket.entity.Ticket;

public interface TicketServiceIntf {
	
	public void addTicket(Ticket ticket);

	public List<Ticket> listTickets();
	
	public Ticket getTicket(Long ticketId);
	
	public void deleteTicket(Ticket ticket);
	
	public List<Ticket> search(String keyword);

}
