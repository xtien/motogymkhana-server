/*******************************************************************************
 * Copyright (c) 2015, 2016, 2017, 2018 Christine Karman
 * This project is free software: you can redistribute it and/or modify it under the terms of
 * the Apache License, Version 2.0. You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 *  
 *******************************************************************************/
package eu.motogymkhana.server.dao;

import eu.motogymkhana.server.model.Country;
import eu.motogymkhana.server.model.Password;

public interface PasswordDao {

	boolean checkPasswordHash(Country country, String passwordHash);

	void store(Country country, String hash);
}
