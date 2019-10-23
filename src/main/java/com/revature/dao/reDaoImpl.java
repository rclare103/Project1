package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class reDaoImpl implements reDao {
	/*
	 * reimbursement Dao
	 * table Reimbursements:
	 * 1. rID serial primary key,
	 * 2. userID integer references Users(userID),
	 * 3. eventType varchar not null,
	 * 4. eventDate date not null,
	 * 5. eventTime time not null,
	 * 6. location varchar not null,
	 * 7. description varchar not null,
	 * 8. cost numeric not null,
	 * 9. gradingFormat varchar not null,
	 * 10. justification varchar not null,
	 * 11. submissionDate date not null,
	 * 12. submissionTime Time not null,
	 * 13. dsStatus varchar not null,
	 * 14. dhStatus varchar not null,
	 * 15. bcStatus varchar not null
	 */
	
	private static Connection conn = ConnectionFactory.getConnection();
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Reimbursement getReimbursement(int rID) {
		String sql = "select * from Reimbursements where rID = ?";
		PreparedStatement stmt;
		Reimbursement re = new Reimbursement();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				re.setrID(rs.getInt(1));
				re.setUserID(rs.getInt(2));
				re.setEventType(rs.getString(3));
				re.setEventDate(rs.getDate(4).toLocalDate());
				re.setEventTime(rs.getTime(5).toLocalTime());
				re.setLocation(rs.getString(6));
				re.setDescription(rs.getString(7));
				re.setCost(rs.getDouble(8));
				re.setGradingFormat(rs.getString(9));
				re.setJustification(rs.getString(10));
				re.setSubmissionDate(rs.getDate(11).toLocalDate());
				re.setSubmissionTime(rs.getTime(12).toLocalTime());
				re.setDsStatus(rs.getString(13));
				re.setDhStatus(rs.getString(14));
				re.setBcStatus(rs.getString(15));
				re.setMessage(rs.getString(16));
				re.setFinalGrade(rs.getString(17));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public void createReimbursement(Reimbursement re) {
		String sql = "insert into Reimbursements ( userID, eventType, eventDate, eventTime, location, "
				+ "description, cost, gradingFormat, justification, submissionDate, "
				+ "submissionTime, dsStatus, dhStatus, bcStatus, message, finalGrade) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, re.getUserID());
			stmt.setString(2,  re.getEventType());
			stmt.setDate(3, Date.valueOf(re.getEventDate()));
			stmt.setTime(4, Time.valueOf(re.getEventTime()));
			stmt.setString(5,  re.getLocation());
			stmt.setString(6, re.getDescription());
			stmt.setDouble(7, re.getCost());
			stmt.setString(8, re.getGradingFormat());
			stmt.setString(9, re.getJustification());
			stmt.setDate(10, Date.valueOf(re.getSubmissionDate()));
			stmt.setTime(11, Time.valueOf(re.getSubmissionTime()));
			stmt.setString(12, re.getDsStatus());
			stmt.setString(13, re.getDhStatus());
			stmt.setString(14, re.getBcStatus());
			stmt.setString(15,  re.getMessage());
			stmt.setString(16, re.getFinalGrade());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		String sql = "select * from Reimbursements";
		List<Reimbursement> reList = new ArrayList<>();
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Reimbursement re = new Reimbursement();
				re.setrID(rs.getInt(1));
				re.setUserID(rs.getInt(2));
				re.setEventType(rs.getString(3));
				re.setEventDate(rs.getDate(4).toLocalDate());
				re.setEventTime(rs.getTime(5).toLocalTime());
				re.setLocation(rs.getString(6));
				re.setDescription(rs.getString(7));
				re.setCost(rs.getDouble(8));
				re.setGradingFormat(rs.getString(9));
				re.setJustification(rs.getString(10));
				re.setSubmissionDate(rs.getDate(11).toLocalDate());
				re.setSubmissionTime(rs.getTime(12).toLocalTime());
				re.setDsStatus(rs.getString(13));
				re.setDhStatus(rs.getString(14));
				re.setBcStatus(rs.getString(15));
				re.setMessage(rs.getString(16));
				re.setFinalGrade(rs.getString(17));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return reList;
	}

	@Override
	public void updateReimbursement(Reimbursement re) {
		String sql = "update Reimbursements " 
				+ "set userID = ?, eventType = ?, eventDate = ?, eventTime = ?, location = ?, description = ?, "
				+ "cost = ?, grading Format = ?, justification = ?, submissionDate = ?, "
				+ "submissionTime = ?, dsStatus = ?, dhStatus = ?, bcStatus = ?, message = ?, finalGrade = ? "
				+ "where rID = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);			
			stmt.setInt(1, re.getUserID());
			stmt.setString(2, re.getEventType());
			stmt.setDate(3, Date.valueOf(re.getEventDate()));
			stmt.setTime(4, Time.valueOf(re.getEventTime()));
			stmt.setString(5,  re.getLocation());
			stmt.setString(6, re.getDescription());
			stmt.setDouble(7, re.getCost());
			stmt.setString(8, re.getGradingFormat());
			stmt.setString(9, re.getJustification());
			stmt.setDate(10, Date.valueOf(re.getSubmissionDate()));
			stmt.setTime(11, Time.valueOf(re.getSubmissionTime()));
			stmt.setString(12, re.getDsStatus());
			stmt.setString(13, re.getDhStatus());
			stmt.setString(14, re.getBcStatus());
			stmt.setInt(15, re.getrID());
			stmt.setString(16,  re.getMessage());
			stmt.setString(17,  re.getFinalGrade());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteReimbursement(Reimbursement re) {
		String sql = "delete from Reimbursements where rID = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, re.getrID());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getReimbursementByUser(User user) {
		int userID = user.getUserID();
		String sql = "select * from Reimbursements where userID = ?";
		List<Reimbursement> reList = new ArrayList<>();
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Reimbursement re = new Reimbursement();
				re.setrID(rs.getInt(1));
				re.setUserID(rs.getInt(2));
				re.setEventType(rs.getString(3));
				re.setEventDate(rs.getDate(4).toLocalDate());
				re.setEventTime(rs.getTime(5).toLocalTime());
				re.setLocation(rs.getString(6));
				re.setDescription(rs.getString(7));
				re.setCost(rs.getDouble(8));
				re.setGradingFormat(rs.getString(9));
				re.setJustification(rs.getString(10));
				re.setSubmissionDate(rs.getDate(11).toLocalDate());
				re.setSubmissionTime(rs.getTime(12).toLocalTime());
				re.setDsStatus(rs.getString(13));
				re.setDhStatus(rs.getString(14));
				re.setBcStatus(rs.getString(15));
				re.setMessage(rs.getString(16));
				re.setFinalGrade(rs.getString(17));
				reList.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return reList;
	}

}
