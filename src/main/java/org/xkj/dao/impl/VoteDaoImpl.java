package org.xkj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xkj.dao.IVoteDao;
import org.xkj.entity.Vote;
import org.xkj.util.DBUtil;
import org.xkj.util.Page;

public class VoteDaoImpl implements IVoteDao {

	public void addVote(Vote vote) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into tb_vote values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vote.getVoteID());
			pstmt.setString(2, vote.getVoteName());
			pstmt.setInt(3, vote.getChannelID());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
	}

	public Vote findVoteByName(String voteName) {
		Vote vote = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tb_vote where voteName=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, voteName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vote = new Vote();
				
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		return vote;
	}

	public List<Vote> findAllVote(Page page) {
		List<Vote> votes = new ArrayList<Vote>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tb_vote limit ?,?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vote vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				
				votes.add(vote);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		return votes;
	}

	public int findAllCount() {
		int totalCount = 0;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from tb_vote";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		return totalCount;
	}

	public void deleteVoteByVoteID(int voteID) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from tb_vote where voteID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteID);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
	}

	public int findVoteCountByChannelID(int channelID) {
		int totalCount = 0;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from tb_vote where channelID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, channelID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return totalCount;
	}

	public List<Vote> findVoteByChannelID(int channelID, Page page) {
		List<Vote> votes = new ArrayList<Vote>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tb_vote where channelID=? limit ?,?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, channelID);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vote vote = new Vote();
				
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				
				votes.add(vote);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return votes;
	}

	public Vote findVoteByID(int voteID) {
		Vote vote = null;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tb_vote where voteID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vote = new Vote();
				
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return vote;
	}

}
