/*******************************************************************************
 * Copyright (c) 2015, 2016, 2017, 2018 Christine Karman
 * This project is free software: you can redistribute it and/or modify it under the terms of
 * the Apache License, Version 2.0. You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 *  
 *******************************************************************************/
package eu.motogymkhana.server.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "rider_auth")
public class RiderAuth {

	public static final String EMAIL = "email";
	public static final String PW_HASH = "pw_hash";
	public static final String COUNTRY = "country";
	public static final String RIDER = "rider";
	public static final String TOKEN = "token";
	private static final String TIMESTAMP = "timestamp";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int _id;

	@Column(name = EMAIL)
	private String email;

	@Column(name = PW_HASH)
	private String passwordHash;

	@Column(name = COUNTRY)
	private Country country;

	@Column(name = TOKEN)
	private String token;

	@Column(name = TIMESTAMP)
	private long timeStamp;

	@JsonProperty(RIDER)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Rider> riders = new HashSet<Rider>();

	public RiderAuth() {
		timeStamp = System.currentTimeMillis();
	}

	public RiderAuth(String email, String token) {
		this.email = email;
		this.token = token;
		timeStamp = System.currentTimeMillis();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
		timeStamp = System.currentTimeMillis();
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String hash) {
		this.passwordHash = hash;
	}

	public void removeToken() {
		this.token = null;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public boolean hasToken() {
		return token != null;
	}

	public boolean hasPassword() {
		return passwordHash !=null;
	}
}
