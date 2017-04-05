
package edu.nyu.cs9053.homework8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.util.Comparator;

public class LambdaScheduler{
	private final ArrayList<Job> jobsList;
	
	public LambdaScheduler(){
		jobsList=new ArrayList<>();
	}

	public void addJob(Job job){
		jobsList.add(job);
	}

	public ArrayList<Job> getAllJobList(){
		return jobsList;
	}

	public ArrayList<Job> getScheduledJobs(){
		ArrayList<Job> scheduledJobsList=new ArrayList<>();
		if(jobsList.size()==0){
            throw new IllegalArgumentException("The job list is currently empty!");
        }
        jobsList.sort(new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return job1.getFinishTime() - job2.getFinishTime();
            }
        });
		int lastJobEndTime=Integer.MIN_VALUE;
		for(Job job : jobsList){
            if(job.getStartTime() >= lastJobEndTime){
                scheduledJobsList.add(job);
                lastJobEndTime = job.getFinishTime();
            }
        }
		return scheduledJobsList;
	}

	public void printSchedule(Collection<Job> jobsListtoPrint){
		Iterator<Job> iterator=jobsListtoPrint.iterator();
		Job job;
		System.out.println("JobsSchedule:");
		while(iterator.hasNext()){
			job=iterator.next();
			System.out.println("JobName:"+job.getJobName()+" Start time:"+job.getStartTime()+
				" End time:"+job.getFinishTime());
		}
	}


}