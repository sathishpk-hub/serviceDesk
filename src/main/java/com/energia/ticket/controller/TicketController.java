package com.energia.ticket.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.energia.ticket.entity.Ticket;
import com.energia.ticket.service.TicketServiceIntf;
import com.energia.ticket.vo.TicketVO;

@Controller
@RequestMapping(value = "serviceDesk")
@ComponentScan( basePackages = { "com.energia.ticket", "org.springframework.jms" ," org.springframework.jms.core","org.hibernate"} )
public class TicketController {
	
	@Autowired
	private TicketServiceIntf ticketServiceIntf;
	
	@RequestMapping(value="/tickets", method = RequestMethod.GET)
	public ModelAndView listTickets() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Ticket> listTickets = ticketServiceIntf.listTickets();
		List<TicketVO> ticketVOList = getTicketVOList(listTickets);
		model.put("listTickets",  ticketVOList);
		return new ModelAndView("listTickets", model);
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  TicketVO ticketVO,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Ticket> listTickets = ticketServiceIntf.listTickets();
		List<TicketVO> ticketVOList = getTicketVOList(listTickets);
		model.put("listTickets",  ticketVOList);
		return new ModelAndView("addOrEdit", model);
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") TicketVO ticketVO, 
			BindingResult result) {
		Ticket ticket = getTicketByVO(ticketVO);
		ticketServiceIntf.addTicket(ticket);
		return new ModelAndView("redirect:/serviceDesk/tickets");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  TicketVO ticketVO,
			BindingResult result) {
		
		Ticket ticket = getTicketByVO(ticketVO);
		ticketServiceIntf.deleteTicket(ticket);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ticket", null);
		
		List<Ticket> listTickets = ticketServiceIntf.listTickets();
		List<TicketVO> ticketVOList = getTicketVOList(listTickets);
		model.put("listTickets",  ticketVOList);
		
		return new ModelAndView("listTickets", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")   TicketVO ticketVO,
			BindingResult result) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		Long ticketId=ticketVO.getId();
		Ticket ticket = ticketServiceIntf.getTicket(ticketId);
		TicketVO ticketVO1 = getTicketVOByTicket(ticket);
		model.put("ticket", ticketVO1);
		
		List<Ticket> listTickets = ticketServiceIntf.listTickets();
		List<TicketVO> ticketVOList = getTicketVOList(listTickets);
		model.put("listTickets",  ticketVOList);
		return new ModelAndView("addOrEdit", model);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam String keyword) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		List<Ticket> listTickets = ticketServiceIntf.search(keyword);
		List<TicketVO> ticketVOList = getTicketVOList(listTickets);
		model.put("listTickets",  ticketVOList);
		
		return new ModelAndView("listTickets", model);
	}	
	
	
	
	private List<TicketVO> getTicketVOList(List<Ticket> listTickets){
		List<TicketVO> ticketVOList = null;
		
		if(listTickets != null && !listTickets.isEmpty()){
			ticketVOList = new ArrayList<TicketVO>();
			TicketVO ticketVO = null;
			
			for(Ticket ticket : listTickets){
				ticketVO = new TicketVO();
				
				ticketVO.setId(ticket.getId());
				ticketVO.setName(ticket.getName());
				ticketVO.setEmail(ticket.getEmail());
				ticketVO.setPbmDesc(ticket.getPbmDesc());
				ticketVO.setPriority(ticket.getPriority());
				ticketVO.setStatus(ticket.getStatus());
				ticketVO.setCreateDateTime(ticket.getCreateDateTime());
				ticketVO.setUpdateDateTime(ticket.getUpdateDateTime());
				
				//Date createdDate = Date.from(ticket.getCreateDateTime().atZone(ZoneId.systemDefault()).toInstant());
				//Date updatedDate= Date.from(ticket.getUpdateDateTime().atZone(ZoneId.systemDefault()).toInstant());
				
				//ticketVO.setCreateDateTime(createdDate);
				//ticketVO.setUpdateDateTime(updatedDate);
		        
				ticketVOList.add(ticketVO);
			}
		}
		return ticketVOList;
	}
	
	
	private Ticket getTicketByVO(TicketVO ticketVO){
		Ticket ticket = new Ticket();
		ticket.setId(ticketVO.getId());
		ticket.setName(ticketVO.getName());
		ticket.setEmail(ticketVO.getEmail());
		ticket.setPbmDesc(ticketVO.getPbmDesc());
		ticket.setPriority(ticketVO.getPriority());
		ticket.setStatus(ticketVO.getStatus());
		ticket.setCreateDateTime(ticketVO.getCreateDateTime());
		ticket.setUpdateDateTime(ticketVO.getUpdateDateTime());

		//add ticket 
		/*
		 * if(ticketVO.getId()!=null) { LocalDateTime createdDateTime =
		 * ticketVO.getCreateDateTime().toInstant().atZone(ZoneId.systemDefault()).
		 * toLocalDateTime(); LocalDateTime updatedDateTime =
		 * ticketVO.getCreateDateTime().toInstant().atZone(ZoneId.systemDefault()).
		 * toLocalDateTime();
		 * 
		 * ticket.setCreateDateTime(createdDateTime);
		 * ticket.setUpdateDateTime(updatedDateTime); }else {
		 * ticket.setCreateDateTime(LocalDateTime.now());
		 * ticket.setUpdateDateTime(LocalDateTime.now()); }
		 */
		
		ticketVO.setId(null);
		return ticket;
	}
	
	
	private TicketVO getTicketVOByTicket(Ticket ticket){
		TicketVO ticketVO = new TicketVO();
		ticketVO.setId(ticket.getId());
		ticketVO.setName(ticket.getName());
		ticketVO.setEmail(ticket.getEmail());
		ticketVO.setPbmDesc(ticket.getPbmDesc());
		ticketVO.setPriority(ticket.getPriority());
		ticketVO.setStatus(ticket.getStatus());
		ticketVO.setCreateDateTime(ticket.getCreateDateTime());
		ticketVO.setUpdateDateTime(ticket.getUpdateDateTime());
		//Date createdDate = Date.from(ticket.getCreateDateTime().atZone(ZoneId.systemDefault()).toInstant());
		//Date updatedDate= Date.from(ticket.getUpdateDateTime().atZone(ZoneId.systemDefault()).toInstant());
		
		//ticketVO.setCreateDateTime(createdDate);
		//ticketVO.setUpdateDateTime(updatedDate);
		
		return ticketVO;
	}
	
	
	

}
