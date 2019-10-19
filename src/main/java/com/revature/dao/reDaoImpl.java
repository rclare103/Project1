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
	 * 3. eventDate date not null,
	 * 4. eventTime time not null,
	 * 5. location varchar not null,
	 * 6. description varchar not null,
	 * 7. cost numeric not null,
	 * 8. gradingFormat varchar not null,
	 * 9. justification varchar not null,
	 * 10. submissionDate date not null,
	 * 11. submissionTime Time not null,
	 * 12. dsStatus varchar not null,
	 * 13. dhStatus varchar not null,
	 * 14. bcStatus varchar not null
	 */
	
	private static Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public Reimbursement getReimbursement(int rID) {
		String sql = "select * from Reimbursements where rID = ?";
		PreparedStatement stmt;
		Reimbursement re = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				re.setrID(rs.getInt(1));
				re.setUserID(rs.getInt(2));
				re.setEventDate(rs.getDate(3).toLocalDate());
				re.setEventTime(rs.getTime(4).toLocalTime());
				re.setLocation(rs.getString(5));
				re.setDescription(rs.getString(6));
				re.setCost(rs.getDouble(7));
				re.setGradingFormat(rs.getString(8));
				re.setJustification(rs.getString(9));
				re.setSubmissionDate(rs.getDate(10).toLocalDate());
				re.setSubmissionTime(rs.getTime(11).toLocalTime());
				re.setDsStatus(rs.getString(12));
				re.setDhStatus(rs.getString(13));
				re.setBcStatus(rs.getString(14));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public void createReimbursement(Reimbursement re) {
		String sql = "insert into Reimbursements (rID, userID, eventDate, eventTime, location, "
				+ "description, cost, gradingFormat, justification, submissionDate, "
				+ "submissionTime, dsStatus, dhStatus, bcStatus) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, re.getrID());
			stmt.setInt(2, re.getUserID());
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
				re.setEventDate(rs.getDate(3).toLocalDate());
				re.setEventTime(rs.getTime(4).toLocalTime());
				re.setLocation(rs.getString(5));
				re.setDescription(rs.getString(6));
				re.setCost(rs.getDouble(7));
				re.setGradingFormat(rs.getString(8));
				re.setJustification(rs.getString(9));
				re.setSubmissionDate(rs.getDate(10).toLocalDate());
				re.setSubmissionTime(rs.getTime(11).toLocalTime());
				re.setDsStatus(rs.getString(12));
				re.setDhStatus(rs.getString(13));
				re.setBcStatus(rs.getString(14));
				reList.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return reList;
	}

	@Override
	public void updateReimbursement(Reimbursement re) {
		String sql = "update Reimbursements " 
				+ "set userID = ?, eventDate = ?, eventTime = ?, location = ?, description = ?, "
				+ "cost = ?, grading Format = ?, justification = ?, submissionDate = ?, "
				+ "submissionTime = ?, dsStatus = ?, dhStatus = ?, bcStatus = ? "
				+ "where rID = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);			
			stmt.setInt(1, re.getUserID());
			stmt.setDate(2, Date.valueOf(re.getEventDate()));
			stmt.setTime(3, Time.valueOf(re.getEventTime()));
			stmt.setString(4,  re.getLocation());
			stmt.setString(5, re.getDescription());
			stmt.setDouble(6, re.getCost());
			stmt.setString(7, re.getGradingFormat());
			stmt.setString(8, re.getJustification());
			stmt.setDate(9, Date.valueOf(re.getSubmissionDate()));
			stmt.setTime(10, Time.valueOf(re.getSubmissionTime()));
			stmt.setString(11, re.getDsStatus());
			stmt.setString(12, re.getDhStatus());
			stmt.setString(13, re.getBcStatus());
			stmt.setInt(14, re.getrID());
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
				re.setEventDate(rs.getDate(3).toLocalDate());
				re.setEventTime(rs.getTime(4).toLocalTime());
				re.setLocation(rs.getString(5));
				re.setDescription(rs.getString(6));
				re.setCost(rs.getDouble(7));
				re.setGradingFormat(rs.getString(8));
				re.setJustification(rs.getString(9));
				re.setSubmissionDate(rs.getDate(10).toLocalDate());
				re.setSubmissionTime(rs.getTime(11).toLocalTime());
				re.setDsStatus(rs.getString(12));
				re.setDhStatus(rs.getString(13));
				re.setBcStatus(rs.getString(14));
				reList.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return reList;
	}

}
