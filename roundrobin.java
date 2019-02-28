import java.util.ArrayList;
import java.util.Collections;

public class roundrobin {
	ArrayList<String> processesname; 
	ArrayList<Integer> ArrivalTime; 
	ArrayList<Integer> BurstTime;
	int ContextSwitch;
	ArrayList<String> Order = new ArrayList<String>();
	ArrayList<Integer> WaitingTime;
	ArrayList<Integer> turnaroundtime;
	double averagewaitingtime;
	double averageturnaroundtime;
	int processesnumber;
	int quantumtime;

	
	
	roundrobin(int quantumtime,int ContextSwitch,ArrayList<Integer> ArrivalTime,ArrayList<Integer> BurstTime,ArrayList<String> processesname){
		this.quantumtime = quantumtime;
		this.processesname = processesname; 
		this.ArrivalTime = ArrivalTime;
		this.BurstTime = BurstTime;
		this.ContextSwitch = ContextSwitch;
		processesnumber = ArrivalTime.size();
		WaitingTime = new ArrayList<Integer>(Collections.nCopies(processesnumber, 0));
		turnaroundtime = new ArrayList<Integer>(Collections.nCopies(processesnumber, 0));
	}
	
	public void doroundrobin(){
		int time = ArrivalTime.get(0);
		int activeprocessindex = 0;
		String activeprocess = processesname.get(0); 
		int nextarrivaltime = ArrivalTime.get(1);
		boolean avail = true;
		int responsetime = ArrivalTime.get(0);
		int nextprocessidx = 1;
		int remainingtime;
		ArrayList<Integer> remainingtimelist = new ArrayList<Integer>(BurstTime);
		ArrayList<Integer> waitingqueueindex = new ArrayList<Integer>(); 
		ArrayList<Integer> waitingqueueremainingtime = new ArrayList<Integer>(); 
	    while(true) {
	    	if(checkzeros(remainingtimelist)) {
	    		break;
	    	} 
	    	
	    	// if process arrived
    		for(int i=0;i<processesnumber;i++) {
    			if(activeprocessindex == i) {
    				continue;
    			}
    			if(ArrivalTime.get(i) == time) {
    				waitingqueueindex.add(i);
    				waitingqueueremainingtime.add(BurstTime.get(i));
    			}
    		}
    		///////
    		
	    	//if process has finshed 
	    	if(remainingtimelist.get(activeprocessindex) == 0) {
	    		if(!waitingqueueindex.isEmpty()) {
	    			
	    			//get one from waiting queue
	    			activeprocessindex = waitingqueueindex.get(0);
	    		    remainingtime = waitingqueueremainingtime.get(0);
	    		    waitingqueueindex.remove(0);
	    		    waitingqueueremainingtime.remove(0);
	    		    
	    		    //add context switch time
	    			if(ArrivalTime.get(activeprocessindex)!=time) {
	    			WaitingTime.set(activeprocessindex,WaitingTime.get(activeprocessindex)+ContextSwitch);
	    			}
	    		    
	    		    responsetime = time;
	    		}
	    		// if it is empty here i am just gonna wait till a process came 
	    		else {
	    			activeprocessindex = -1;
	    		}
	    	}
	    	/////////////
	    	
	    	//if quantumtime has finished
	    	if(quantumtime <= time - responsetime) {
	    		if(!waitingqueueindex.isEmpty()) {
	    			//add the current
	    			waitingqueueindex.add(activeprocessindex);
	    			waitingqueueremainingtime.add(remainingtimelist.get(activeprocessindex));
	    			
	    			//add context switch
	    			WaitingTime.set(activeprocessindex,WaitingTime.get(activeprocessindex)+ContextSwitch);

	    			
	    			//get one from waiting queue
	    			activeprocessindex = waitingqueueindex.get(0);
	    		    remainingtime = waitingqueueremainingtime.get(0);
	    		    waitingqueueindex.remove(0);
	    		    waitingqueueremainingtime.remove(0);
	    		    
	    		    //add context switch time
	    			if(ArrivalTime.get(activeprocessindex)!=time) {
	    			WaitingTime.set(activeprocessindex,WaitingTime.get(activeprocessindex)+ContextSwitch);
	    			}
	    		    
	    		    
	    		    
	    		    responsetime = time; 
	    		    
	    		}
	    		//if it is not empty i just will let the current finish
	    		
	    	}
	    	
	    	//get order of arr
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
	        	 //System.out.println(processesname.get(activeprocessindex));
	        	 for(int i=0;i<processesnumber;i++) {
	        		 if((ArrivalTime.get(i) <= time) && (i!=activeprocessindex) && (remainingtimelist.get(i)!=0)) {
	        			 //System.out.print(i);
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
	

}
