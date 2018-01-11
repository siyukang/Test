package com.free.sims.domain;

import java.util.Date;

/**
 * @author liuzeke
 * @version 1.0
 */
public class User {

	private Long id;

	private String username;

	private String password;

	private String name;

	private Byte sex;

	private Byte belongClass;

	private String phoneNo;

	private String parentPhoneNo;

	private String linkPhoneNo;

	private String relation;

	private String recruitPhoneNo;

	private String belongMarketing;

	private String familyDetailAddress;

	private String detailAddress;

	private Date createdDate;

	private Date updatedDate;

	private String remarks;

	private Byte accountNonExpired;

	private Byte accountNonLocked;

	private Byte credentialsNonExpired;

	private Byte enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Byte getBelongClass() {
		return belongClass;
	}

	public void setBelongClass(Byte belongClass) {
		this.belongClass = belongClass;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getParentPhoneNo() {
		return parentPhoneNo;
	}

	public void setParentPhoneNo(String parentPhoneNo) {
		this.parentPhoneNo = parentPhoneNo;
	}

	public String getLinkPhoneNo() {
		return linkPhoneNo;
	}

	public void setLinkPhoneNo(String linkPhoneNo) {
		this.linkPhoneNo = linkPhoneNo;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getRecruitPhoneNo() {
		return recruitPhoneNo;
	}

	public void setRecruitPhoneNo(String recruitPhoneNo) {
		this.recruitPhoneNo = recruitPhoneNo;
	}

	public String getBelongMarketing() {
		return belongMarketing;
	}

	public void setBelongMarketing(String belongMarketing) {
		this.belongMarketing = belongMarketing;
	}

	public String getFamilyDetailAddress() {
		return familyDetailAddress;
	}

	public void setFamilyDetailAddress(String familyDetailAddress) {
		this.familyDetailAddress = familyDetailAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Byte getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Byte accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Byte getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Byte accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Byte getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Byte credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}
}
