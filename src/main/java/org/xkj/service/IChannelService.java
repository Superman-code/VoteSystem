package org.xkj.service;

import java.util.List;

import org.xkj.entity.Channel;

public interface IChannelService {
	public void addChannel(Channel channel);
	public List<Channel> findAllChannel();
	public void deleteChannelById(int channelID);
}
