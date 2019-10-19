import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.util.ReimbursementCalculatorImpl;

public class ReimbursementCalculatorTest {

	private ReimbursementCalculatorImpl reCalc;
	private Reimbursement re;
	private User user;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		reCalc = new ReimbursementCalculatorImpl();
		re = new Reimbursement();
		user = new User();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void universityCourseTest() {
		re.setEventType("university course");
		re.setCost(1000.0);
		assertEquals("this should cost 800", new Double(800), (Double) reCalc.getReimbursementCost(re));
	}
	
	@Test
	public void upperCaseTest() {
		re.setEventType("unIveRsiTy cOurse");
		re.setCost(1000.0);
		assertEquals("this should cost 800", new Double(800), (Double) reCalc.getReimbursementCost(re));
	}
	
	@Test
	public void seminarTest() {
		re.setEventType("seminar");
		re.setCost(1000.0);
		assertEquals("this should cost 600", new Double(600), (Double) reCalc.getReimbursementCost(re));
	}
	
	@Test
	public void certPrepTest() {
		re.setEventType("certification preparation class");
		re.setCost(1000.0);
		assertEquals("this should cost 750", new Double(750), (Double) reCalc.getReimbursementCost(re));
	}
	
	@Test
	public void certTest() {
		re.setEventType("certification");
		re.setCost(1000.0);
		assertEquals("this should cost 1000", new Double(1000), (Double) reCalc.getReimbursementCost(re));
	}
	
	@Test
	public void techTrainingTest() {
		re.setEventType("technical training");
		re.setCost(1000.0);
		assertEquals("this should cost 900", new Double(900), (Double) reCalc.getReimbursementCost(re));
	}
	
	@Test
	public void otherTest() {
		re.setEventType("other");
		re.setCost(1000.0);
		assertEquals("this should cost 300", new Double(300), (Double) reCalc.getReimbursementCost(re));
	}
	
	@Test
	public void testAvailableReimbursement() {
		Reimbursement re1 = new Reimbursement();
		re1.setEventType("university course");
		re1.setCost(1000);
		re1.setBcStatus("approved");
		re1.setDhStatus("approved");
		re1.setDsStatus("approved");
		List<Reimbursement> reList = new ArrayList<Reimbursement>();
		reList.add(re1);
		user.setReimbursements(reList);
		assertEquals("Available reimbursement should be 200", new Double(200), (Double) reCalc.getAvailableReimbursement(user));
	}
	
	@Test
	public void testMultipleReimbursement() {
		Reimbursement re1 = new Reimbursement();
		re1.setEventType("university course");
		re1.setCost(500);
		re1.setBcStatus("approved");
		re1.setDhStatus("approved");
		re1.setDsStatus("approved");
		Reimbursement re2 = new Reimbursement();
		re2.setEventType("certification");
		re2.setCost(500);
		re2.setBcStatus("approved");
		re2.setDhStatus("approved");
		re2.setDsStatus("approved");
		List<Reimbursement> reList = new ArrayList<Reimbursement>();
		reList.add(re1);
		reList.add(re2);
		user.setReimbursements(reList);
		assertEquals("Available reimbursement should be 100", new Double(100), (Double) reCalc.getAvailableReimbursement(user));
	}
}
