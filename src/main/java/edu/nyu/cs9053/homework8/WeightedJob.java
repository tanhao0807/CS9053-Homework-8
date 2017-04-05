package edu.nyu.cs9053.homework8;
public class WeightedJob extends AbstractJob{
	private final int weight;
	
	public WeightedJob(String jobName,int startTime,int finishTime,int weight){
		super(jobName,startTime, finishTime);
		this.weight=weight;
	}

	public int getWeight(){
		return weight;
	}
}