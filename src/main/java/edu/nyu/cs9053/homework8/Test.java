package edu.nyu.cs9053.homework8;
import java.util.ArrayList;
public class Test{
	public static void main(String[] args) {
		LambdaScheduler a=new LambdaScheduler();
		a.addJob(new Job("Job1",10,40));
		a.addJob(new Job("Job2",50,80));
		a.addJob(new Job("Job3",90,100));
		a.addJob(new Job("Job4",110,130));
		a.addJob(new Job("Job5",30,60));
		a.addJob(new Job("Job6",70,95));
		a.addJob(new Job("Job7",96,115));
		a.printSchedule(a.getScheduledJobs());
		LambdaWeightedScheduler b=new LambdaWeightedScheduler();
		b.addJob(new WeightedJob("Job1",10,40,3));
		b.addJob(new WeightedJob("Job2",50,80,5));
		b.addJob(new WeightedJob("Job3",30,60,6));
		b.addJob(new WeightedJob("Job4",70,95,7));
		b.addJob(new WeightedJob("Job5",96,115,10));
		b.addJob(new WeightedJob("Job6",90,100,6));
		b.addJob(new WeightedJob("Job7",110,130,5));
		b.addJob(new WeightedJob("Job8",1,5,20));
		b.addJob(new WeightedJob("Job9",2,3,5));
		b.addJob(new WeightedJob("Job10",3,4,8));
		b.addJob(new WeightedJob("Job11",1,3,5));
		b.addJob(new WeightedJob("Job12",4,8,15));
		b.addJob(new WeightedJob("Job13",3,6,5));
		b.addJob(new WeightedJob("Job14",6,10,7));
		b.addJob(new WeightedJob("Job15",8,9,10));
		b.addJob(new WeightedJob("Job16",10,13,6));
		b.addJob(new WeightedJob("Job17",11,13,5));
		b.printSchedule(b.scheduledJobsinweights());
	}
}
