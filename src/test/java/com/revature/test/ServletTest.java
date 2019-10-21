package com.revature.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.servlets.LoginServlet;

public class ServletTest {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		when(request.getParameter("username")).thenReturn("TestUser");
		when(request.getParameter("password")).thenReturn("TestPassword");
		new LoginServlet().doPost(request, response);
	}

}
