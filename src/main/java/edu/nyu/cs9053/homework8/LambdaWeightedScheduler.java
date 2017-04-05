package edu.nyu.cs9053.homework8;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class LambdaWeightedScheduler{
	private final ArrayList<WeightedJob> jobsList;

	public LambdaWeightedScheduler(){
		jobsList=new ArrayList<>();
	}

	public void addJob(WeightedJob weightedjob){
		jobsList.add(weightedjob);
	}

	public ArrayList<WeightedJob> getOrderedJobaList(){
		jobsList.sort(new Comparator<WeightedJob>() {
            @Override
            public int compare(WeightedJob job1, WeightedJob job2) {
                return job1.getFinishTime() - job2.getFinishTime();
            }
        });
		return jobsList;
	}

	public void printSchedule(Collection<WeightedJob> jobsListtoPrint){
		Iterator<WeightedJob> iterator=jobsListtoPrint.iterator();
		WeightedJob weightedjob;
		System.out.println("WeightedJobsSchedule:");
		while(iterator.hasNext()){
			weightedjob=iterator.next();
			System.out.println("JobName:"+weightedjob.getJobName()+" Start time:"+weightedjob.getStartTime()+
				" End time:"+weightedjob.getFinishTime()+" Weight:"+weightedjob.getWeight());
		}
	}

	public ArrayList<WeightedJob> scheduledJobsinweights(){
        if(jobsList.size()==0){
            throw new IllegalArgumentException("The job list is currently empty!");
        }
		getOrderedJobaList();
		int opt[] = new int[jobsList.size()];
		int index[]=new int[jobsList.size()];
		ArrayList<WeightedJob> scheduledJobsList=new ArrayList<>();
		opt[0] = jobsList.get(0).getWeight();
		index[0] = -1;
        for(int i=1; i < jobsList.size(); i++){
            opt[i] = Math.max(jobsList.get(i).getWeight(), opt[i-1]);
            index[i]=-1;
            for(int j=i-1; j >=0; j--){
                if(jobsList.get(j).getFinishTime() <= jobsList.get(i).getStartTime()){
                    opt[i] = Math.max(opt[i],jobsList.get(i).getWeight() + opt[j]);
                    index[i]=j;
                    break;
                }
            }
        }
        int i=jobsList.size()-1;
        int optI=0;
        do{
        	if(i==0){
        		scheduledJobsList.add(jobsList.get(0));
        		break;
        	}
        	if(index[i]==-1) optI=0;
        	else optI=opt[index[i]];
        	if(jobsList.get(i).getWeight()+optI>opt[i-1]){
        		scheduledJobsList.add(jobsList.get(i));
        		i=index[i];
        	}
        	else i--;
		}while(i!=-1);
        return scheduledJobsList;
	}
}