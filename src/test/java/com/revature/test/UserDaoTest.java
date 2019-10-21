package com.revature.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.postgresql.core.BaseStatement;

import com.revature.dao.UserDaoImpl;
import com.revature.dao.reDaoImpl;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class UserDaoTest {
	
	private reDaoImpl reDao = new reDaoImpl();
	private UserDaoImpl userDao = new UserDaoImpl();
	
	User user;
	Reimbursement re;
	
	@Mock
	private Connection conn;
	
	@Spy
	private BaseStatement stmt = (BaseStatement) ConnectionFactory.getConnection().createStatement();
	
	public UserDaoTest() throws SQLException {
		super();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		ConnectionFactory.getConnection().createStatement().executeUpdate("truncate table Users");


	}

	@Before
	public void setUp() throws Exception {
		
		when(conn.createStatement()).thenReturn(stmt);
		
		user = new User();
		
		userDao.setConn(conn);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
		
		user.setUsername("Test");
		user.setPassword("Test");
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setSupervisor(0);
		user.setDepartmentHead(0);
		user.setRole("Test");
		user.setAvailableReimbursement(1000.0);
		
		userDao.createUser(user);
		
		try {
			Mockito.verify(stmt).executeUpdate("insert into Users (username, password, firstname, lastname, "
					+ "supervisor, departmentHead, role, availableReimbursement) "
					+ "values ('Test', 'Test', 'Test', 'Test', '0', '0', 'Test', '1000.0')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
