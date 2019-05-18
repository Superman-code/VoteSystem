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

public class GetVoteInfoAction extends ActionSupport {
	private int channelID;

	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/*
	 * 此字段为静态字段，目的就是为了实现页面算法时不用重复提交channelID
	 */
	private static int saveChannelID;

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	@Override
	public String execute() throws Exception {
		/*
		 * 假如saveChannelID为0即第一次访问这个类 
		 * 或者saveChannelID不等于channelID,且channelID不为0(假如不加这个判断，每次点页面的话，也会进入判断)即用户访问了别的频道
		 * 就将saveChannelID更新一次
		 */
		if (saveChannelID == 0 || (saveChannelID != channelID && channelID != 0)) {
			saveChannelID = channelID;
		}
		
		/*
		 *假如currentPage为0，就默认为第一页
		 */
		if(currentPage == 0) {
			currentPage = 1;
		}

		IVoteService voteService = new VoteServiceImpl();
		
		/*
		 * 将每页显示记录写死为3个投票
		 */
		Page page = PageUtil.createPage(3, voteService.findVoteCountByChannelID(saveChannelID), currentPage);

		List<Vote> votes = voteService.findVoteByChannelID(saveChannelID, page);

		IVoteOptionService voteOptionService = new VoteOptionServiceImpl();

		/*
		 * 获取指定频道的所有vote后，再根据voteID查询vote下的所有选项并通过voteResult组装在一起
		 * 通过request域传递到前台，且voteResult必须是List， 因为一个频道可能有多个投票
		 */
		List<VoteResult> voteResults = new ArrayList<VoteResult>();

		for (Vote vote : votes) {
			List<VoteOption> voteOptions = voteOptionService.findVoteOptionByVoteID(vote.getVoteID());

			VoteResult voteResult = new VoteResult();

			voteResult.setVote(vote);
			voteResult.setVoteOptions(voteOptions);

			voteResults.add(voteResult);
		}

		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");

		request.put("voteResults", voteResults);
		request.put("page", page);

		return this.SUCCESS;
	}
}
