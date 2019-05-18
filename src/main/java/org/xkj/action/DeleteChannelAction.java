package org.xkj.action;

import org.xkj.service.IChannelService;
import org.xkj.service.impl.ChannelServcieImpl;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteChannelAction extends ActionSupport {
	private int channelID;

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	@Override
	public String execute() throws Exception {
		IChannelService channelService = new ChannelServcieImpl();
		
		channelService.deleteChannelById(channelID);
		
		return this.SUCCESS;
	}
}
