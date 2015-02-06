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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.NamedEntityGraph;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.NamedAttributeNode;

/**
 * @author wb00003
 *
 */
@Entity
//@NamedEntityGraph(name = "UserInfo.groups",
//attributeNodes = @NamedAttributeNode("groups"))
@Table(name = "GU_USER_INFO")
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = -5266564534073009336L;
	
	@Id
	@Column(name="GU_USER_INFO_OID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_USER_INFO_SEQ")
	private Long oid;
	@Column(name="user_id", length=64)
	private String userId;
	@Column(name="", length=255)
	private String pwd;
	@Column(length=1024)
	private String email;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="GU_USER_GROUP",
		joinColumns=@JoinColumn(name="GU_USER_INFO_OID", referencedColumnName="GU_USER_INFO_OID"),
		inverseJoinColumns=
		            @JoinColumn(name="GU_GROUP_INFO_OID", referencedColumnName="GU_GROUP_INFO_OID")
	)
	private Set<GroupInfo> groups;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<GroupInfo> getGroups() {
		return groups;
	}
	public void setGroups(Set<GroupInfo> groups) {
		this.groups = groups;
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
