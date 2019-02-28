import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SJF {
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
	
	SJF(ArrayList<Integer> ArrivalTime,ArrayList<Integer> BurstTime,int ContextSwitch,ArrayList<String> processesname){
		this.processesname = processesname; 
		this.ArrivalTime = ArrivalTime;
		this.BurstTime = BurstTime;
		this.ContextSwitch = ContextSwitch;
		processesnumber = ArrivalTime.size();
		WaitingTime = new ArrayList<Integer>(Collections.nCopies(processesnumber, 0));
		turnaroundtime = new ArrayList<Integer>(Collections.nCopies(processesnumber, 0));
		
	}
	
	public void DoSJF(){
		
		int time = ArrivalTime.get(0);
		int activeprocessindex = 0;
		String activeprocess = processesname.get(0); 
		int nextarrivaltime = ArrivalTime.get(1);
		boolean avail = true;
		int nextprocessidx = 1;
		int responsetime = ArrivalTime.get(0);
		int remainingtime;
		ArrayList<Integer> remainingtimelist = new ArrayList<Integer>(BurstTime);
		ArrayList<Integer> waitingqueueindex = new ArrayList<Integer>(); 
		ArrayList<Integer> waitingqueueremainingtime = new ArrayList<Integer>(); 
		while(true){
			/*if(activeprocess.equals("p3")) {
				break;
			}*/
			if(checkzeros(remainingtimelist)) {
				break;
			}
			//1 is finished
       	    remainingtime = remainingtimelist.get(activeprocessindex); 
       	    if(remainingtime == 0) {
       	    	int idxinqueue = waitingqueueindex.indexOf(activeprocessindex);
       	    	if(idxinqueue!=-1) {
       	    	waitingqueueindex.remove(idxinqueue);
       	    	waitingqueueremainingtime.remove(idxinqueue);
       	    	}
       	    	if(time == nextarrivaltime) {
       	    	 if(waitingqueueindex.size()!=0) {
            		 int minimumidx = getminidx(waitingqueueremainingtime);
               		 ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(BurstTime.get(nextprocessidx),waitingqueueremainingtime.get(minimumidx)));
            		 int minimumtimeidx = getminidx(temp);
            		  if(minimumtimeidx==0){
            			 activeprocessindex = nextprocessidx;
                		 activeprocess = processesname.get(activeprocessindex);
                         //here i don't mention the case if there is no next arrival time 
                		 if(ArrivalTime.size()<=activeprocessindex+1) {
                			 nextarrivaltime = -1;
                		 }
                		 else {
                		 nextarrivaltime = ArrivalTime.get(activeprocessindex+1);
                		 nextprocessidx = activeprocessindex+1;
                		 }
                		 responsetime = time;
            		 }
            		 else if(minimumtimeidx==1) {
                		 waitingqueueindex.add(nextprocessidx);
                    	 waitingqueueremainingtime.add(BurstTime.get(nextprocessidx));  
                    	 
                         //here i don't mention the case if there is no next arrival time 
                		 if(ArrivalTime.size()<=activeprocessindex+2) {
                			 nextarrivaltime = -1;
                		 }
                		 else {		 
                		 nextarrivaltime = ArrivalTime.get(activeprocessindex+2);
                		 nextprocessidx = activeprocessindex+2;
                		 }
            			

                		 activeprocessindex =  waitingqueueindex.get(minimumidx);
                		 activeprocess = processesname.get(activeprocessindex);

                		 responsetime = time;
                		 
            		 }
            	 }
       	    	 else { //waiting queue is zero 
       	 		 activeprocessindex++;
        		 activeprocess = processesname.get(activeprocessindex);
                 //here i don't mention the case if there is no next arrival time 
        		 if(ArrivalTime.size()<=activeprocessindex+1) {
        			 nextarrivaltime = -1;
        		 }else {
        		 nextarrivaltime = ArrivalTime.get(activeprocessindex+1);
        		 nextprocessidx = activeprocessindex+1;
        		 }
        		 responsetime = time;
       	    	 }
       	    		
       	    	}
       	    	else {
       	    		//just take shortest from the queue 
       	    		if(waitingqueueremainingtime.isEmpty()) {
       	    			time++;
       	    			continue;
       	    		}
       	    		else {
                        //here i don't mention the case if there is no next arrival time 
               		 if(ArrivalTime.size()<=activeprocessindex+1) {
            			 nextarrivaltime = -1;
            		 }
               		 else {
               		nextarrivaltime = ArrivalTime.get(activeprocessindex+1);
           		 nextprocessidx = activeprocessindex+1;
               		 }
       	    		responsetime = time;
           		    int minimumidx = getminidx(waitingqueueremainingtime);
           		    activeprocessindex = waitingqueueindex.get(minimumidx);
           		    
           		    //i stop here
           		    activeprocess = processesname.get(activeprocessindex);
           		    
       	    		}
           		    
           		     

       	    	}
       	    	
       	    	
       	    }

			
			//2 a process has arrived 
       	    else if(time == nextarrivaltime){
            	 remainingtime = remainingtimelist.get(activeprocessindex); 
            	 //2.1 waiting queue is existed 
            	 if(waitingqueueindex.size()!=0) {
            		 int minimumidx = getminidx(waitingqueueremainingtime);
               		 ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(remainingtime,BurstTime.get(nextprocessidx),waitingqueueremainingtime.get(minimumidx)));
            		 int minimumtimeidx = getminidx(temp);
            		 if(minimumtimeidx==0) {
            			 waitingqueueindex.add(nextprocessidx);
                		 waitingqueueremainingtime.add(BurstTime.get(nextprocessidx));   
                         //here i don't mention the case if there is no next arrival time 
                		 if(ArrivalTime.size()<=activeprocessindex+2) {
                			 nextarrivaltime = -1;
                		 }
                		 else {
                		 nextarrivaltime = ArrivalTime.get(activeprocessindex+2);
                		 nextprocessidx = activeprocessindex+2;

                		 }
                		 }
            		 else if(minimumtimeidx==1){
            			 activeprocessindex++;
                		 activeprocess = processesname.get(activeprocessindex);
                         //here i don't mention the case if there is no next arrival time 
                		 if(ArrivalTime.size()<=activeprocessindex+1) {
                			 nextarrivaltime = -1;
                		 }
                		 else {
                		 nextarrivaltime = ArrivalTime.get(activeprocessindex+1);
                		 nextprocessidx = activeprocessindex+1;

                		 }
                		 responsetime = time;
                		 waitingqueueindex.add(activeprocessindex-1);
                		 waitingqueueremainingtime.add(remainingtime); 
            		 }
            		 else if(minimumtimeidx==2) {
                         //here i don't mention the case if there is no next arrival time 
                		 if(ArrivalTime.size()<=activeprocessindex+2) {
                			 nextarrivaltime = -1;
                		 }
                		 else {
                		 nextarrivaltime = ArrivalTime.get(activeprocessindex+2);
                		 nextprocessidx = activeprocessindex+2;

                		 }
            			 waitingqueueindex.add(activeprocessindex+1);
                		 waitingqueueremainingtime.add(BurstTime.get(activeprocessindex+1));   
                		 
                 		 waitingqueueindex.add(activeprocessindex);
                		 waitingqueueremainingtime.add(remainingtime); 

                		 activeprocessindex =  waitingqueueindex.get(minimumidx);
                		 activeprocess = processesname.get(activeprocessindex);

                		 responsetime = time;
                		 
            		 }
            		 //printarrint(waitingqueueindex);
            		 //printarrint(waitingqueueremainingtime);
            	 }
            	 //2.2 waiting queue is not existed 
            	 else {
  
            	 if(BurstTime.get(activeprocessindex+1)<remainingtime){
            		 activeprocessindex++;
            		 activeprocess = processesname.get(activeprocessindex);
                     //here i don't mention the case if there is no next arrival time 
            		 if(ArrivalTime.size()<=activeprocessindex+1) {
            			 nextarrivaltime = -1;
            		 }
            		 else {
            		 nextarrivaltime = ArrivalTime.get(activeprocessindex+1);
            		 nextprocessidx = activeprocessindex+1;

            		 }
            		 responsetime = time;
            		 waitingqueueindex.add(activeprocessindex-1);
            		 waitingqueueremainingtime.add(remainingtime); 
            	 }
            	 else {
            		 waitingqueueindex.add(activeprocessindex+1);
            		 waitingqueueremainingtime.add(BurstTime.get(activeprocessindex+1));
            	 }	 
            	 }
             }
             
             //3 process in the waiting queue has less remaining time
       	    else if(waitingqueueindex.size()!=0) {
            	 remainingtime = remainingtimelist.get(activeprocessindex); 
        		 int minimumidx = getminidx(waitingqueueremainingtime);
        		 if(waitingqueueremainingtime.get(minimumidx)<remainingtime) {
        			 waitingqueueindex.add(activeprocessindex);
            		 waitingqueueremainingtime.add(remainingtime); 

            		 activeprocessindex =  waitingqueueindex.get(minimumidx);
            		 activeprocess = processesname.get(activeprocessindex);

            		 responsetime = time;	 
        		 }
  
        	 }

             
             //4 nothing has happened 
        	 
        	 remainingtimelist.set(activeprocessindex,remainingtimelist.get(activeprocessindex)-1);
        	 if(Order.isEmpty()) {
			 Order.add(activeprocess);
        	 }
        	 else {
        		 if(!Order.get(Order.size()-1).equals(activeprocess)) {
        			 Order.add(activeprocess);
        		 }
        	 }
        	 //System.out.println(activeprocess);
        	 for(int i=0;i<processesnumber;i++) {
        		 if((ArrivalTime.get(i) <= time) && (i!=activeprocessindex) && (remainingtimelist.get(i)!=0)) {
        			 //System.out.print(i);
        			 WaitingTime.set(i, WaitingTime.get(i)+1);
        		 }
        	 }
        	 time++;
		}
	}
	
	public void DoSJF1() {
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
	
	public int getminidx(ArrayList<Integer> a){
		int min = 0;
		for(int i=0;i<a.size();i++) {
			if(a.get(i)<a.get(min)){
				min = i;
			}
		}
		return min;
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
