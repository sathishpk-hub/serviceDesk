package com.energia.ticket;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.energia.ticket.config.ServiceDeskApplication;
import com.energia.ticket.service.TicketServiceIntf;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceDeskApplication.class)
@AutoConfigureMockMvc
public class ServiceDeskApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private TicketServiceIntf ticketServiceIntf;

		//get list of tickets (note: initially it will be null or 0 tickets)
		@Test
		public void getTicketList() throws Exception {
	      String uri = "/serviceDesk";
	      
	      MvcResult mvcResult = this.mockMvc.perform(get("/serviceDesk/tickets")).andReturn();
	      
	      String productResObject = mvcResult.getResponse().getContentAsString();
	      
	      String viewNameFromResponse = mvcResult.getModelAndView().getViewName();
	        
	      System.out.println("product result Object = "+productResObject);
	        
	      System.out.println("product result View Name = "+viewNameFromResponse);
	       
	      
	      //compare API using mock
	      assertEquals("listTickets", viewNameFromResponse);
	      
		/*
		 * int status = mvcResult.getResponse().getStatus();
		 * System.out.println("status = "+status); assertEquals(200, status); String
		 * content = mvcResult.getResponse().getContentAsString();
		 */
	     
	   }
		

}
