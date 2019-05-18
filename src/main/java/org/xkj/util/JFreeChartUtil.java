package org.xkj.util;

import java.awt.Font;
import java.util.List;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.xkj.entity.Vote;
import org.xkj.entity.VoteOption;
import org.xkj.service.IVoteOptionService;
import org.xkj.service.IVoteService;
import org.xkj.service.impl.VoteOptionServiceImpl;
import org.xkj.service.impl.VoteServiceImpl;

public class JFreeChartUtil {
	public static JFreeChart createChart(int voteID) {
		/*
		 * DefaultPieDataset 一般用作饼图
		 * DefaultCategoryDataset 用作柱状图，折线图
		 * TimeSeriesCollection 时间序列图
		 */
		IVoteService voteService = new VoteServiceImpl();
		
		IVoteOptionService voteOptionService = new VoteOptionServiceImpl();
		
		/*
		 * voteService根据投票ID得到vote
		 */
		Vote vote = voteService.findVoteByID(voteID);
		
		/*
		 * 这里需要获得投票名称，一会用作柱状图的表头
		 */
		String voteName = vote.getVoteName();
		
		/*
		 * 再根据投票ID获得所有投票选项
		 */
		List<VoteOption> voteOptions = voteOptionService.findVoteOptionByVoteID(voteID);
		
		/*
		 * 创建数据源
		 */
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		
		for(VoteOption voteOption:voteOptions) {
			//设置数据源
			dcd.setValue(voteOption.getTicketNum(), "", voteOption.getVoteOptionName());
		}
		
		//创建主题样式,为了处理图标中中文乱码问题,必须在生成图表之前设置
		StandardChartTheme sct = new StandardChartTheme("CN");
		
		//设置标题字体
		sct.setExtraLargeFont(new Font("宋体", Font.BOLD, 20));
		
		//设置轴向字体
		sct.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));
		
		//设置图例字体
		sct.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));
		
		//应用主题样式
		ChartFactory.setChartTheme(sct);
		
		/*
		 * title  - 图表标题（允许为null）。
			categoryAxisLabel  - 类别轴的标签（允许为null）。
			valueAxisLabel  - 值轴的标签（允许为null）。
			dataset  - 图表的数据集（允许为null）。
			orientation  - 绘图方向（水平或垂直）（不允许为null）。
			legend  - 一个标志，指定是否需要图例。
			tooltips - 配置图表以生成工具提示？
			urls  - 配置图表以生成URL？
		 */
		JFreeChart chart = ChartFactory.createBarChart3D(
				voteName, 
				"投票选项", 
				"投票数", 
				dcd, 
				PlotOrientation.VERTICAL,
				false, 
				true, 
				false);
		
		chart.setBackgroundPaint(ChartColor.WHITE);
		
		//数据轴线类
		NumberAxis numberAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
		//想要设置数据轴的刻度，须把自动设置关掉
		numberAxis.setAutoTickUnitSelection(false);
		//设置数据刻度的长度，类型为double
		double unit = 1d;
		NumberTickUnit ntu = new NumberTickUnit(unit);
		
		numberAxis.setTickUnit(ntu);
		
		return chart;
	}
}
