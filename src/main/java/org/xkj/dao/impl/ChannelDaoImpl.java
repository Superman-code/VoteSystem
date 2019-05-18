package org.xkj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xkj.dao.IChannelDao;
import org.xkj.entity.Channel;
import org.xkj.util.DBUtil;

public class ChannelDaoImpl implements IChannelDao{

	public void addChannel(Channel channel) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into tb_channel values(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, channel.getChannelID());
			pstmt.setString(2, channel.getChannelName());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
	}

	public List<Channel> findAllChannel() {
		List<Channel> channels = new ArrayList<Channel>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tb_channel order by channelID asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Channel channel = new Channel();
				
				channel.setChannelID(rs.getInt(1));
				channel.setChannelName(rs.getString(2));
				
				channels.add(channel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return channels;
	}

	public void deleteChannelById(int channelID) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from tb_channel where channelID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, channelID);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
	}

}
