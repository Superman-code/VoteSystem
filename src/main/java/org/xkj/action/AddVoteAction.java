package org.xkj.action;

import java.util.ArrayList;
import java.util.List;

import org.xkj.entity.Vote;
import org.xkj.entity.VoteOption;
import org.xkj.service.IVoteOptionService;
import org.xkj.service.IVoteService;
import org.xkj.service.impl.VoteOptionServiceImpl;
import org.xkj.service.impl.VoteServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class AddVoteAction extends ActionSupport {
	private int channel;
	private String voteName;
	private String[] voteOption;

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	public String[] getVoteOption() {
		return voteOption;
	}

	public void setVoteOption(String[] voteOption) {
		this.voteOption = voteOption;
	}

	@Override
	public String execute() throws Exception {
		IVoteService voteService = new VoteServiceImpl();

		Vote vote = new Vote();
		vote.setVoteName(voteName);
		vote.setChannelID(channel);

		voteService.addVote(vote);

		int voteID = voteService.findVoteByName(voteName).getVoteID();
		
		List<VoteOption> voteOptions = new ArrayList<VoteOption>();
		for (String voteOptionName : voteOption) {
			VoteOption option = new VoteOption();
			option.setVoteID(voteID);
			option.setVoteOptionName(voteOptionName);
			option.setTicketNum(0);
			
			voteOptions.add(option);
		}
		
		IVoteOptionService voteOptionService = new VoteOptionServiceImpl();
		
		voteOptionService.addVoteOptions(voteOptions);

		return this.SUCCESS;
	}
}
