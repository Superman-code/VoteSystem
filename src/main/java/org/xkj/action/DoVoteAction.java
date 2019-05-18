package org.xkj.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.xkj.entity.Vote;
import org.xkj.entity.VoteOption;
import org.xkj.service.IVoteOptionService;
import org.xkj.service.IVoteService;
import org.xkj.service.impl.VoteOptionServiceImpl;
import org.xkj.service.impl.VoteServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DoVoteAction extends ActionSupport {
	private int voteID;
	private int voteOptionID;
	private String voteOptionName;

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	public int getVoteOptionID() {
		return voteOptionID;
	}

	public void setVoteOptionID(int voteOptionID) {
		this.voteOptionID = voteOptionID;
	}

	public String getVoteOptionName() {
		return voteOptionName;
	}

	public void setVoteOptionName(String voteOptionName) {
		this.voteOptionName = voteOptionName;
	}

	@Override
	public String execute() throws Exception {
		IVoteOptionService voteOptionService = new VoteOptionServiceImpl();
		
		//目的是根据voteID取出对应的投票信息，
		//再拿到名称，当重名的时候显示给前台
		IVoteService voteService = new VoteServiceImpl();
		
		/*
		 * 获取request域，可以让后面添加error信息
		 */
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		//判断用户是否能进行投票，取出cookies
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		
		for(Cookie cookie:cookies) {
			//如果用户已经投票，就在request里放入一个error
			if(cookie.getValue().equals(String.valueOf(voteID))) {
				Vote vote = voteService.findVoteByID(voteID);
				request.put("error", "您今天已经投过&nbsp;\""+vote.getVoteName()+"\"&nbsp;啦，请明天再来吧！");
				return this.INPUT;	//跳到错误页面
			}
		}
		
		if(voteOptionID == 0) {		//如果等于0表示其他选项，增加投票选项
			VoteOption voteOption = new VoteOption();
			
			voteOption.setVoteID(voteID);
			if("".equals(voteOptionName)) {
				request.put("error", "假如您选择其他选项，投票选项名不能为空！");
				return this.INPUT;
			}
			
			/*
			 * 还需要检查新增的投票选项名是否和数据库已有的投票选项是否重名
			 * 假如重名将重新的选项票数加1
			 */
			List<VoteOption> voteOptions = voteOptionService.findVoteOptionByVoteID(voteID);
			for(VoteOption vo:voteOptions) {
				if(voteOptionName.equals(vo.getVoteOptionName())) {
					int ticketNum = vo.getTicketNum();
					vo.setTicketNum(ticketNum+1);
					voteOptionService.updateVoteOption(voteOption);
					
					Cookie cookie = new Cookie("hasVote"+this.voteID, String.valueOf(voteID));
					cookie.setMaxAge(24*60*60);
					ServletActionContext.getResponse().addCookie(cookie);
					return this.SUCCESS;
				}
			}
			
			voteOption.setVoteOptionName(voteOptionName);
			/*
			 * 新的投票选项票数应该是从1开始，因为投票人已经投过一次了
			 */
			voteOption.setTicketNum(1);
			
			voteOptionService.addVoteOption(voteOption);
			
			Cookie cookie = new Cookie("hasVote"+this.voteID, String.valueOf(voteID));
			cookie.setMaxAge(24*60*60);
			ServletActionContext.getResponse().addCookie(cookie);
		} else {
			VoteOption voteOption = voteOptionService.findVoteOptionByID(voteOptionID);
			
			int ticketNum = voteOption.getTicketNum();
			
			voteOption.setTicketNum(ticketNum + 1);
			
			voteOptionService.updateVoteOption(voteOption);
			/*
			 * 更新完成后，添加cookie，防止重复投票
			 * cookie的默认maxAge为-1，即关闭浏览器cookie就失效了，且maxAge的时间单位是秒
			 * 设置maxAge为24小时，即第二天才能投票
			 */
			Cookie cookie = new Cookie("hasVote"+this.voteID, String.valueOf(voteID));
			cookie.setMaxAge(24*60*60);
			ServletActionContext.getResponse().addCookie(cookie);
		}
		return super.execute();
	}
}
