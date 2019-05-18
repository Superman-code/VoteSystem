package org.xkj.dao;

import java.util.List;

import org.xkj.entity.Channel;

public interface IChannelDao {
	public void addChannel(Channel channel);
	public List<Channel> findAllChannel();
	public void deleteChannelById(int channelID);
}
