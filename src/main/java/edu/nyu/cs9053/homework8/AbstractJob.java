package edu.nyu.cs9053.homework8;
public abstract class AbstractJob{
	private final int startTime;
	private final int finishTime;
	private final String jobName;

	public AbstractJob(String jobName,int startTime,int finishTime){
		this.startTime=startTime;
		this.finishTime=finishTime;
		this.jobName=jobName;
	}

	public int getStartTime(){
		return startTime;
	}

	public int getFinishTime(){
		return finishTime;
	}

	public String getJobName(){
		return jobName;
	}
}