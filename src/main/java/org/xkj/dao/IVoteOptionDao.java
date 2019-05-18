package org.xkj.dao;

import java.util.List;

import org.xkj.entity.VoteOption;

public interface IVoteOptionDao {
	public void addVoteOptions(List<VoteOption> voteOptions);
	public List<VoteOption> findVoteOptionByVoteID(int voteID);
	public void updateVoteOption(VoteOption voteOption);
	public void addVoteOption(VoteOption voteOption);
	public VoteOption findVoteOptionByID(int voteOptionID);
}
