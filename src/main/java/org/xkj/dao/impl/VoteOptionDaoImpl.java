package org.xkj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xkj.dao.IVoteOptionDao;
import org.xkj.entity.VoteOption;
import org.xkj.util.DBUtil;

public class VoteOptionDaoImpl implements IVoteOptionDao {

	public void addVoteOptions(List<VoteOption> voteOptions) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
//		conn.setAutoCommit(false);
		String sql = "insert into tb_voteoption values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(VoteOption voteOption:voteOptions) {
				pstmt.setInt(1, voteOption.getVoteOptionID());
				pstmt.setInt(2, voteOption.getVoteID());
				pstmt.setString(3, voteOption.getVoteOptionName());
				pstmt.setInt(4, voteOption.getTicketNum());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<VoteOption> findVoteOptionByVoteID(int voteID) {
		List<VoteOption> voteOptions = new ArrayList<VoteOption>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tb_voteoption where voteID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VoteOption voteOption = new VoteOption();
				
				voteOption.setVoteOptionID(rs.getInt(1));
				voteOption.setVoteID(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
				
				voteOptions.add(voteOption);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return voteOptions;
	}

	public void updateVoteOption(VoteOption voteOption) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update tb_voteOption set ticketNum=? where voteOptionID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteOption.getTicketNum());
			pstmt.setInt(2, voteOption.getVoteOptionID());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
		
	}

	public void addVoteOption(VoteOption voteOption) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into tb_voteoption values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteOption.getVoteOptionID());
			pstmt.setInt(2, voteOption.getVoteID());
			pstmt.setString(3, voteOption.getVoteOptionName());
			pstmt.setInt(4, voteOption.getTicketNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
		
	}

	public VoteOption findVoteOptionByID(int voteOptionID) {
		VoteOption voteOption = null;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tb_voteOption where voteOptionID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteOptionID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				voteOption = new VoteOption();
				
				voteOption.setVoteOptionID(rs.getInt(1));
				voteOption.setVoteID(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return voteOption;
	}

}
