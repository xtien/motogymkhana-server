/*******************************************************************************
 * Copyright (c) 2015, 2016, 2017, 2018 Christine Karman
 * This project is free software: you can redistribute it and/or modify it under the terms of
 * the Apache License, Version 2.0. You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 *  
 *******************************************************************************/
package eu.motogymkhana.server.guice;

import org.apache.http.client.HttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;

import eu.motogymkhana.server.conversion.ConvertRegistration;
import eu.motogymkhana.server.conversion.impl.ConvertRegistrationImpl;
import eu.motogymkhana.server.dao.PasswordDao;
import eu.motogymkhana.server.dao.RegistrationDao;
import eu.motogymkhana.server.dao.RiderAuthDao;
import eu.motogymkhana.server.dao.RiderDao;
import eu.motogymkhana.server.dao.RoundDao;
import eu.motogymkhana.server.dao.SettingsDao;
import eu.motogymkhana.server.dao.TimesDao;
import eu.motogymkhana.server.dao.impl.PasswordDaoImpl;
import eu.motogymkhana.server.dao.impl.RegistrationDaoImpl;
import eu.motogymkhana.server.dao.impl.RiderAuthDaoImpl;
import eu.motogymkhana.server.dao.impl.RiderDaoImpl;
import eu.motogymkhana.server.dao.impl.RoundDaoImpl;
import eu.motogymkhana.server.dao.impl.SettingsDaoImpl;
import eu.motogymkhana.server.dao.impl.TimesDaoImpl;
import eu.motogymkhana.server.http.HttpClientProvider;
import eu.motogymkhana.server.http.MyHttpClient;
import eu.motogymkhana.server.http.UrlHelper;
import eu.motogymkhana.server.http.impl.MyHttpClientImpl;
import eu.motogymkhana.server.http.impl.UrlHelperImpl;
import eu.motogymkhana.server.jackson.ObjectMapperProvider;
import eu.motogymkhana.server.password.PasswordManager;
import eu.motogymkhana.server.password.impl.PasswordManagerImpl;
import eu.motogymkhana.server.persist.MyEntityManager;
import eu.motogymkhana.server.persist.MyEntityManagerImpl;
import eu.motogymkhana.server.round.RoundManager;
import eu.motogymkhana.server.round.impl.RoundManagerImpl;
import eu.motogymkhana.server.text.TextManager;
import eu.motogymkhana.server.text.impl.TextManagerImpl;

/**
 * 
 * @author christine
 * 
 */
public class GymkhanaModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(RoundDao.class).to(RoundDaoImpl.class);
		bind(TimesDao.class).to(TimesDaoImpl.class);
		bind(RiderDao.class).to(RiderDaoImpl.class);
		bind(PasswordDao.class).to(PasswordDaoImpl.class);
		bind(SettingsDao.class).to(SettingsDaoImpl.class);
		bind(RiderAuthDao.class).to(RiderAuthDaoImpl.class);
		bind(RegistrationDao.class).to(RegistrationDaoImpl.class);
		
		bind(TextManager.class).to(TextManagerImpl.class);
		bind(RoundManager.class).to(RoundManagerImpl.class);
	
		bind(HttpClient.class).toProvider(HttpClientProvider.class);
		bind(MyHttpClient.class).to(MyHttpClientImpl.class);
		bind(UrlHelper.class).to(UrlHelperImpl.class);
		
		bind(ObjectMapper.class).toProvider(ObjectMapperProvider.class);

		bind(PasswordManager.class).to(PasswordManagerImpl.class);
		
		bind(ConvertRegistration.class).to(ConvertRegistrationImpl.class);
		
		bind(MyEntityManager.class).to(MyEntityManagerImpl.class);
		
		//bind(ApplicationManager.class).to(ApplicationManagerImpl.class);

		// inject logger
		// (http://code.google.com/p/google-guice/wiki/CustomInjections)
		bindListener(Matchers.any(), new LogTypeListener());
	}

	static Matcher<TypeLiteral<?>> type(final Matcher<? super Class> matcher) {
		return new AbstractMatcher<TypeLiteral<?>>() {
			public boolean matches(TypeLiteral<?> literal) {
				return matcher.matches(literal.getRawType());
			}
		};
	}
}
