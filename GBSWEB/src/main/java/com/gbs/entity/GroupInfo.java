/**
 * 
 */
package com.gbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author wb00003
 *
 */
@Entity
@Table(name="GU_GROUP_INFO")
public class GroupInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GU_GROUP_INFO_OID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_GROUP_INFO_SEQ")
	private Long oid;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	@ManyToMany(mappedBy="groups", cascade=CascadeType.REMOVE)
	private Set<UserInfo> users;
	
	@Column(name="create_date")
    @Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Column(name="create_user", length=64)
	private String createUser;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
}
