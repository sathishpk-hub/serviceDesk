package com.energia.ticket.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//primary key auto generated
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pbmDesc")
	private String pbmDesc;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="status")
	private String status;
	
	//@CreatedDate
	//@Column(name="createdDate")
	//@Temporal(TemporalType.TIMESTAMP)
	//private Date createdDate;
	
	//@LastModifiedDate
	//@Column(name="updatedDate")
	//@Temporal(TemporalType.TIMESTAMP)
	//private Date updatedDate;
	
	@CreationTimestamp
	@Column(updatable= false)
    private Date createDateTime;
 
    @UpdateTimestamp
    private Date updateDateTime;
	
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Ticket(Long id, String name, String email, String pbmDesc, String priority, String status,
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



	public Date getCreateDateTime() {
		return createDateTime;
	}



	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}



	public Date getUpdateDateTime() {
		return updateDateTime;
	}



	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}


}
