/*******************************************************************************
 * Copyright (c) 2015, 2016, 2017, 2018 Christine Karman
 * This project is free software: you can redistribute it and/or modify it under the terms of
 * the Apache License, Version 2.0. You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 *  
 *******************************************************************************/
package eu.motogymkhana.server;

import java.util.concurrent.TimeUnit;

public class ServerConstants {

	public static final String HTTPS = "https://";
	public static final String HTTP = "http://";
	public static final String UPDATE_RIDER = "/updateRider/";
	public static final String UPDATE_TIMES = "/updateTimes/";
	public static final String UPDATE_TEXT = "/updateText/";
	public static final String DELETE_RIDER = "/deleteRider/";
	public static final String GET_RIDERS = "/getRiders/";
	public static final String GET_ALL_RIDERS = "/getAllRiders/";
	public static final String UPLOAD_RIDERS = "/uploadRiders/";
	public static final String UPDATE_RIDERS = "/updateRiders/";
	public static final String UPLOAD_ROUNDS = "/uploadRounds/";
	public static final String GET_ROUNDS = "/getRounds/";
	public static final String CHECK_PASSWORD = "/pw/";
	public static final String UPDATE_SETTINGS = "/updateSettings/";
	public static final String GET_SETTINGS = "/getSettings/";

	public static final String UI_GET_RIDERS = "/ui/getRiders/";
	public static final String UI_GET_ROUNDS = "/ui/getRounds/";
	public static final String UI_GET_SETTINGS = "/ui/getSettings/";
	public static final String UI_SEND_TOKEN = "/ui/sendToken/";
	public static final String UI_REGISTER_RIDER = "/ui/registerRider/";
	public static final String UI_SIGNIN_RIDER = "/ui/signinRider/";
	public static final String UI_GET_RIDER = "/ui/getRider/";
	public static final String UI_UPDATE_RIDER = "/ui/updateRider/";

	public static final String MOTOGYMKHANA = "/motogymkhana";

	public static final TimeUnit RONALD_DOWNLOAD_TIMEUNIT = TimeUnit.SECONDS;

	public static String digestAlgorithm = "SHA-256";
}
