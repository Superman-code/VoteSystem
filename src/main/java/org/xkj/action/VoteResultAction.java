package org.xkj.action;

import org.jfree.chart.JFreeChart;
import org.xkj.util.JFreeChartUtil;

import com.opensymphony.xwork2.ActionSupport;

public class VoteResultAction extends ActionSupport {
	private JFreeChart chart;
	private int voteID;

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	@Override
	public String execute() throws Exception {
		this.chart = JFreeChartUtil.createChart(voteID);
		return super.execute();
	}
}
