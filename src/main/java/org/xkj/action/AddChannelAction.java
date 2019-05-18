package org.xkj.action;

import org.xkj.entity.Channel;
import org.xkj.service.IChannelService;
import org.xkj.service.impl.ChannelServcieImpl;

import com.opensymphony.xwork2.ActionSupport;

public class AddChannelAction extends ActionSupport {
	private String channelName;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	@Override
	public String execute() throws Exception {
		IChannelService channelService = new ChannelServcieImpl();
		
		Channel channel = new Channel();
		
		channel.setChannelName(channelName);
		
		channelService.addChannel(channel);
		
		return this.SUCCESS;
	}
}
