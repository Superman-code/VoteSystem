package org.xkj.action;

import java.util.List;
import java.util.Map;

import org.xkj.entity.Channel;
import org.xkj.service.IChannelService;
import org.xkj.service.impl.ChannelServcieImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindAllChannelAction extends ActionSupport{
	
	public String addVote() {
		IChannelService channelService = new ChannelServcieImpl();
		
		List<Channel> channels = channelService.findAllChannel();
		
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		request.put("channels", channels);
		
		return "addVote";
	}
	
	public String manageChannel() {
		IChannelService channelService = new ChannelServcieImpl();
		
		List<Channel> channels = channelService.findAllChannel();
		
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		request.put("channels", channels);
		
		return "manageChannel";
	}
	
	public String index() {
		IChannelService channelService = new ChannelServcieImpl();
		
		List<Channel> channels = channelService.findAllChannel();
		
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
		
		session.put("channels", channels);
		
		return "index";
	}
}
