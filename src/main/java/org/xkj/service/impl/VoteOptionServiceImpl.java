package org.xkj.service.impl;

import java.util.List;

import org.xkj.dao.IVoteOptionDao;
import org.xkj.dao.impl.VoteOptionDaoImpl;
import org.xkj.entity.VoteOption;
import org.xkj.service.IVoteOptionService;

public class VoteOptionServiceImpl implements IVoteOptionService{
	private IVoteOptionDao voteOptionDao;
	
	public VoteOptionServiceImpl() {
		voteOptionDao = new VoteOptionDaoImpl();
	}
	
	public void addVoteOptions(List<VoteOption> voteOptions) {
		voteOptionDao.addVoteOptions(voteOptions);
	}

	public List<VoteOption> findVoteOptionByVoteID(int voteID) {
		return voteOptionDao.findVoteOptionByVoteID(voteID);
	}

	public void updateVoteOption(VoteOption voteOption) {
		voteOptionDao.updateVoteOption(voteOption);
	}

	public void addVoteOption(VoteOption voteOption) {
		voteOptionDao.addVoteOption(voteOption);
	}

	public VoteOption findVoteOptionByID(int voteOptionID) {
		return voteOptionDao.findVoteOptionByID(voteOptionID);
	}

}
