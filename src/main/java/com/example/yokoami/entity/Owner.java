package com.example.yokoami.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "owner")
public class Owner implements Serializable {
	@Id
	@Column(name = "id")
	@NotNull(message="IDの入力は必須です")
	private Integer id;
	
	@Column(name = "name")
	@NotNull(message="氏名の入力は必須です")
	private String name;
	
	@Column(name = "address")
	@NotNull(message="住所の入力は必須です")
	private String address;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "email")
	private String email;

	public Owner() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Owner(Integer id, String name, String address, String tel, String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}