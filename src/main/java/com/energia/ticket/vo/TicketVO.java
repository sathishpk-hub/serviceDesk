package com.energia.ticket.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;

import org.hibernate.annotations.UpdateTimestamp;

public class TicketVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//primary key auto generated
	private Long id;
	private String name;
	private String email;
	private String pbmDesc;
	private String priority;
	private String status;
	//private Date createdDate;
	//private Date updatedDate;
	
	private Date createDateTime;
    private Date updateDateTime;
	
	public TicketVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TicketVO(Long id, String name, String email, String pbmDesc, String priority, String status,
			Date createDateTime, Date updateDateTime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pbmDesc = pbmDesc;
		this.priority = priority;
		this.status = status;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPbmDesc() {
		return pbmDesc;
	}
	public void setPbmDesc(String pbmDesc) {
		this.pbmDesc = pbmDesc;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}



	public Date getCreateDateTime() {
		return createDateTime;
	}



	public void setCreateDateTime(Date createdDate) {
		this.createDateTime = createdDate;
	}



	public Date getUpdateDateTime() {
		return updateDateTime;
	}



	public void setUpdateDateTime(Date updatedDate) {
		this.updateDateTime = updatedDate;
	}
	
	
	
	
	
	

}
