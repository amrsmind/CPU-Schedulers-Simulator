import java.util.ArrayList;
import java.util.Collections;

public class npPriority {

	ArrayList<String> processesname; 
	ArrayList<Integer> ArrivalTime; 
	ArrayList<Integer> BurstTime;
	ArrayList<Integer> priorities; 
	ArrayList<String> Order = new ArrayList<String>();
	ArrayList<Integer> WaitingTime;
	ArrayList<Integer> turnaroundtime;
	double averagewaitingtime;
	double averageturnaroundtime;
	int processesnumber;
	int quantumtime;
	
	npPriority(int quantumtime,ArrayList<Integer> ArrivalTime,ArrayList<Integer> BurstTime,ArrayList<String> processesname,ArrayList<Integer> priorities){
		this.quantumtime = quantumtime;
		this.processesname = processesname; 
		this.ArrivalTime = ArrivalTime;
		this.BurstTime = BurstTime;
		this.priorities = priorities;
		processesnumber = ArrivalTime.size();
		WaitingTime = new ArrayList<Integer>(Collections.nCopies(processesnumber, 0));
		turnaroundtime = new ArrayList<Integer>(Collections.nCopies(processesnumber, 0));
	}
	
	public void doFCFS(){
		int time = ArrivalTime.get(0);
		int activeprocessindex = -1;
		String activeprocess = processesname.get(0); 
		int nextarrivaltime = ArrivalTime.get(1);
		boolean avail = true;
		int responsetime = ArrivalTime.get(0);
		int nextprocessidx = 1;
		int remainingtime = BurstTime.get(0);
		ArrayList<Integer> remainingtimelist = new ArrayList<Integer>(BurstTime);
		ArrayList<Integer> waitingqueueindex = new ArrayList<Integer>(); 
		ArrayList<Integer> waitingqueueremainingtime = new ArrayList<Integer>(); 
		ArrayList<Integer> waitingqueuepriority = new ArrayList<Integer>(); 
		while(true){
			// check if there's no more processes 
			if(checkzeros(remainingtimelist)) {
				break;
			}
			
			// if a process arrived
    		for(int i=0;i<processesnumber;i++) {
    			if(activeprocessindex == i) {
    				continue;
    			}
    			if(ArrivalTime.get(i) == time) {
    				waitingqueueindex.add(i);
    				waitingqueueremainingtime.add(BurstTime.get(i));
    				waitingqueuepriority.add(priorities.get(i));
    			}
    		}
    		///////
    		
    		//if the process has finished 
    		if(activeprocessindex!=-1) {
    		if(remainingtimelist.get(activeprocessindex)==0) {
    			avail = true;
    			activeprocessindex = -1;
    		}
    		}
    		
    		//if there is no process ongoing 
    		if(avail){
    			if(!waitingqueueindex.isEmpty()) {
    				int minindexpriority = getminidx(waitingqueuepriority);
    				activeprocessindex = waitingqueueindex.get(minindexpriority);
    				remainingtime = waitingqueueremainingtime.get(minindexpriority);
    				
    				
    				waitingqueueindex.remove(minindexpriority);
    				waitingqueueremainingtime.remove(minindexpriority);
    				waitingqueuepriority.remove(minindexpriority);
    				
    				avail = false;
    			}
    			else {
    				activeprocessindex = -1;
    			}
    		}
    		
    		///////////////////
    		if(activeprocessindex!=-1) {
		    	if(Order.isEmpty()) {
					 Order.add(processesname.get(activeprocessindex));
		        	 }
		        	 else {
		        		 if(!Order.get(Order.size()-1).equals(processesname.get(activeprocessindex))) {
		        			 Order.add(processesname.get(activeprocessindex));
		        		 }
		        	 }
		    	}
		        	 for(int i=0;i<processesnumber;i++) {
		        		 if((ArrivalTime.get(i) <= time) && (i!=activeprocessindex) && (remainingtimelist.get(i)!=0)) {
		        			 WaitingTime.set(i, WaitingTime.get(i)+1);
		        		 }
		        	 }
		        	 
		        	 
		 	    if(activeprocessindex!=-1) { 	 
		    	remainingtimelist.set(activeprocessindex, remainingtimelist.get(activeprocessindex)-1);
		 	    	}
		    	time++;
		}
		
		for(int i=0;i<processesnumber;i++) {
			turnaroundtime.set(i, WaitingTime.get(i)+BurstTime.get(i));
		}
		int waitingsum=0;
		int turnaroundtimesum = 0;
		for(int i=0;i<processesnumber;i++) {
		      waitingsum+=WaitingTime.get(i);
		      turnaroundtimesum+=turnaroundtime.get(i);
		}
		averagewaitingtime = (double)waitingsum/(double)processesnumber;
		averageturnaroundtime = (double)turnaroundtimesum/(double)processesnumber;

	}
	
	boolean checkzeros(ArrayList<Integer> a) {
		for(int i:a) {
			if(i!=0) {
				return false;
			}
		}
		return true;
	}
	public void printarrstr(ArrayList<String> a) {
		for(int i=0;i<a.size();i++) {
			System.out.print(a.get(i) + "   ");
		}
		System.out.println();
	}
	public void printarrint(ArrayList<Integer> a) {
		for(int i=0;i<a.size();i++) {
			System.out.print(a.get(i) + "   ");
		}
		System.out.println();
	}
	
	public int getminidx(ArrayList<Integer> a){
		int min = 0;
		for(int i=0;i<a.size();i++) {
			if(a.get(i)<a.get(min)){
				min = i;
			}
		}
		return min;
	}
}
