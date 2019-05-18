package org.xkj.service.impl;

import java.util.List;

import org.xkj.dao.IChannelDao;
import org.xkj.dao.impl.ChannelDaoImpl;
import org.xkj.entity.Channel;
import org.xkj.service.IChannelService;

public class ChannelServcieImpl implements IChannelService{
	private IChannelDao channelDao;
	
	public ChannelServcieImpl() {
		channelDao = new ChannelDaoImpl();
	}
	
	public void addChannel(Channel channel) {
		channelDao.addChannel(channel);
	}

	public List<Channel> findAllChannel() {
		return channelDao.findAllChannel();
	}

	public void deleteChannelById(int channelID) {
		channelDao.deleteChannelById(channelID);
	}
	
}
