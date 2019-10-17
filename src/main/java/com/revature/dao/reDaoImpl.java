package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class reDaoImpl implements reDao {
	/*
	 * reimbursement Dao
	 * table reimbursement:
	 * rID serial primary key,
	 * userID integer references Users(userID),
	 * eventDate date not null,
	 * eventTime time not null,
	 * location varchar not null,
	 * description varchar not null,
	 * cost numeric not null,
	 * gradingFormat varchar not null,
	 * justification varchar not null,
	 * submissionDate date default current_date
	 */
	
	private static Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public Reimbursement getReimbursement(int rID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createReimbursement() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReimbursement(Reimbursement re) {
		// TODO Auto-generated method stub

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
				re.setStatus(rs.getString(11));
				reList.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return reList;
	}

}
