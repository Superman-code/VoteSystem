package org.xkj.action;

import org.xkj.service.IVoteService;
import org.xkj.service.impl.VoteServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteVoteAction extends ActionSupport {
	private int voteID;

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	@Override
	public String execute() throws Exception {
		IVoteService voteService = new VoteServiceImpl();
		
		voteService.deleteVoteByVoteID(voteID);
		
		return this.SUCCESS;
	}
}
