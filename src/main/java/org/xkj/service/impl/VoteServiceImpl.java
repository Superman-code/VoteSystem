package org.xkj.service.impl;

import java.util.List;

import org.xkj.dao.IVoteDao;
import org.xkj.dao.impl.VoteDaoImpl;
import org.xkj.entity.Vote;
import org.xkj.service.IVoteService;
import org.xkj.util.Page;

public class VoteServiceImpl implements IVoteService{
	private IVoteDao voteDao;
	
	public VoteServiceImpl() {
		voteDao = new VoteDaoImpl();
	}
	
	public void addVote(Vote vote) {
		voteDao.addVote(vote);
	}

	public Vote findVoteByName(String voteName) {
		return voteDao.findVoteByName(voteName);
	}

	public List<Vote> findAllVote(Page page) {
		return voteDao.findAllVote(page);
	}

	public int findAllCount() {
		return voteDao.findAllCount();
	}

	public void deleteVoteByVoteID(int voteID) {
		voteDao.deleteVoteByVoteID(voteID);
	}

	public int findVoteCountByChannelID(int channelID) {
		return voteDao.findVoteCountByChannelID(channelID);
	}

	public List<Vote> findVoteByChannelID(int channelID, Page page) {
		return voteDao.findVoteByChannelID(channelID, page);
	}

	public Vote findVoteByID(int voteID) {
		return voteDao.findVoteByID(voteID);
	}
	
}
