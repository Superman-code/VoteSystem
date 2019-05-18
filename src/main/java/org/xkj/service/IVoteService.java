package org.xkj.service;

import java.util.List;

import org.xkj.entity.Vote;
import org.xkj.util.Page;

public interface IVoteService {
	public void addVote(Vote vote);
	public Vote findVoteByName(String voteName);
	public List<Vote> findAllVote(Page page);
	public int findAllCount();
	public void deleteVoteByVoteID(int voteID);
	public int findVoteCountByChannelID(int channelID);
	public List<Vote> findVoteByChannelID(int channelID, Page page);
	public Vote findVoteByID(int voteID);
}
