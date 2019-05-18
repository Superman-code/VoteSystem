package org.xkj.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xkj.entity.Vote;
import org.xkj.entity.VoteOption;
import org.xkj.entity.VoteResult;
import org.xkj.service.IVoteOptionService;
import org.xkj.service.IVoteService;
import org.xkj.service.impl.VoteOptionServiceImpl;
import org.xkj.service.impl.VoteServiceImpl;
import org.xkj.util.Page;
import org.xkj.util.PageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowVoteAction extends ActionSupport {
	private int currentPage;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String execute() throws Exception {
		if(currentPage == 0) {
			currentPage = 1;
		}
		
		ActionContext actionContext = ActionContext.getContext();
		
		Map<String, Object> request = (Map<String, Object>) actionContext.get("request");
		
		IVoteService voteService = new VoteServiceImpl();
		
		Page page = new Page();
		page = PageUtil.createPage(5, voteService.findAllCount(), currentPage);
		
		List<Vote> votes = voteService.findAllVote(page);
		
		List<VoteResult> voteResults = new ArrayList<VoteResult>();
		
		IVoteOptionService voteOptionService = new VoteOptionServiceImpl();
		for(Vote vote:votes) {
			List<VoteOption> voteOptions = voteOptionService.findVoteOptionByVoteID(vote.getVoteID());
			
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);
			voteResult.setVoteOptions(voteOptions);
			
			voteResults.add(voteResult);
		}
		request.put("voteResults", voteResults);
		request.put("page", page);
		return this.SUCCESS;
	}
}
