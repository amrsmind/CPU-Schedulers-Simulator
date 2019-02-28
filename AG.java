import java.util.ArrayList;
import java.util.Collections;

public class AG {
	ArrayList<String> processesname; 
	ArrayList<Integer> ArrivalTime; 
	ArrayList<Integer> BurstTime;
	ArrayList<Integer> priorities; 
	ArrayList<Integer> quantumtimelist;
	ArrayList<String> Order = new ArrayList<String>();
	ArrayList<Integer> WaitingTime;
	ArrayList<ArrayList<Integer>> quantumhistory;
	ArrayList<Integer> turnaroundtime;
	double averagewaitingtime;
	double averageturnaroundtime;
	int processesnumber;
	
	AG(ArrayList<Integer> ArrivalTime,ArrayList<Integer> BurstTime,ArrayList<String> processesname,ArrayList<Integer> priorities,ArrayList<Integer> quantumtimelist){
		this.processesname = processesname; 
		this.ArrivalTime = ArrivalTime;
		this.BurstTime = BurstTime;
		this.priorities = priorities;
		processesnumber = ArrivalTime.size();
		WaitingTime = new ArrayList<Integer>(Collections.nCopies(processesnumber, 0));
		turnaroundtime = new ArrayList<Integer>(Collections.nCopies(processesnumber, 0));
		this.quantumtimelist = quantumtimelist;
		quantumhistory = new ArrayList<ArrayList<Integer>>(processesnumber);
		for(int i=0;i<processesnumber;i++) {
			quantumhistory.add(new ArrayList<Integer>());
		}
	}
	
	
	
	public void doAG(){
		int time = ArrivalTime.get(0);
		int activeprocessindex = -1;
		int nextarrivaltime = ArrivalTime.get(1);
		boolean avail1 = true;
		boolean avail2 = true;
		boolean avail3 = true;
		int responsetime = ArrivalTime.get(0);
		int nextprocessidx = 1;
		int remainingtime = BurstTime.get(0);
		int token = 1;
		ArrayList<Integer> remainingtimelist = new ArrayList<Integer>(BurstTime);
		ArrayList<Integer> waitingqueueindex = new ArrayList<Integer>(); 
		ArrayList<Integer> waitingqueueremainingtime = new ArrayList<Integer>(); 
		ArrayList<Integer> waitingqueuepriority = new ArrayList<Integer>(); 
		ArrayList<Integer> remainingquantumtime =  new ArrayList<Integer>(quantumtimelist);

		ArrayList<Integer> q1remainingtimelist = new ArrayList<Integer>();
		ArrayList<Integer> q1waitingqueueindex = new ArrayList<Integer>(); 
		ArrayList<Integer> q1waitingqueuepriority = new ArrayList<Integer>(); 
		ArrayList<Integer> q1remainingquantumtime =  new ArrayList<Integer>();
		
		ArrayList<Integer> q2remainingtimelist = new ArrayList<Integer>();
		ArrayList<Integer> q2waitingqueueindex = new ArrayList<Integer>(); 
		ArrayList<Integer> q2waitingqueuepriority = new ArrayList<Integer>(); 
		ArrayList<Integer> q2remainingquantumtime =  new ArrayList<Integer>();
		
		ArrayList<Integer> q3remainingtimelist = new ArrayList<Integer>();
		ArrayList<Integer> q3waitingqueueindex = new ArrayList<Integer>(); 
		ArrayList<Integer> q3waitingqueuepriority = new ArrayList<Integer>(); 
		ArrayList<Integer> q3remainingquantumtime =  new ArrayList<Integer>();
		
		int remainintime=0;
		int prior=0;
		int remainingquantum=0;
		
		int activeidxq1 = 0;
		int activeidxq2 = 0;
		int activeidxq3 = 0;
		
		while(true) {

			if(activeprocessindex!=-1) {
				/*System.out.println("time : " + time);
			System.out.println("active now at first loop : "+ activeprocessindex + " ,  " +processesname.get(activeprocessindex));
			System.out.println("avail1 : " + avail1);
			System.out.println("avail2 : " + avail2);
			System.out.println("avai13 : " + avail3);*/
			}
			//check if all remainingbursttime is finished
			if(checkzeros(remainingtimelist)){
				break;
			}
			
			//check if this process at second queue
    		if(activeprocessindex!=-1) {
    		if(0.5*quantumtimelist.get(activeprocessindex)>=quantumtimelist.get(activeprocessindex)-remainingquantum && quantumtimelist.get(activeprocessindex)-remainingquantum > 0.25*quantumtimelist.get(activeprocessindex) && (avail1  == false)) {
    			    //int i = q1waitingqueueindex.indexOf(activeprocessindex);
     			    q2remainingtimelist.add(remainingtime);
    				q2waitingqueueindex.add(activeprocessindex);
    				q2waitingqueuepriority.add(prior);
    				//update quantum 
    				quantumtimelist.set(activeprocessindex,quantumtimelist.get(activeprocessindex)+2);
    				//save it in history 
    				quantumhistory.get(activeprocessindex).add(quantumtimelist.get(activeprocessindex));
    				//
    				q2remainingquantumtime.add(quantumtimelist.get(activeprocessindex));
    				activeprocessindex = -1;
    				avail1 = true;
    				//System.out.println("q2");
    		}
    		}

    		
    		//check if this process at third queue
    		if(activeprocessindex!=-1) {
    		if(0.5*quantumtimelist.get(activeprocessindex)<quantumtimelist.get(activeprocessindex)-remainingquantum &&(avail2) == false) {
 			    
    			q3remainingtimelist.add(remainingtime);
				q3waitingqueueindex.add(activeprocessindex);
				q3waitingqueuepriority.add(prior);
				//update quantum
				quantumtimelist.set(activeprocessindex,quantumtimelist.get(activeprocessindex)+(quantumtimelist.get(activeprocessindex)/2) );
				//save it in history 
				quantumhistory.get(activeprocessindex).add(quantumtimelist.get(activeprocessindex));
				//
				q3remainingquantumtime.add(quantumtimelist.get(activeprocessindex));
				
				avail2 = true;
				
				activeprocessindex = -1;
				
				//System.out.println("q3");
    			
    		//if quantum time about to get to negative
    		}
    		}
    		///////////////////////////////////////////
			
			
			// if a process arrived
    		for(int i=0;i<processesnumber;i++) {
    			if(activeprocessindex == i) {
    				continue;
    			}
    			if(ArrivalTime.get(i) == time) {
    				q1remainingtimelist.add(BurstTime.get(i));
    				q1waitingqueueindex.add(i);
    				q1waitingqueuepriority.add(priorities.get(i));
    				q1remainingquantumtime.add(quantumtimelist.get(i));	
    			}
    		}
    		
    		//check in everyqueue
    		//q1
    		if(!q1waitingqueueindex.isEmpty() || avail1 == false) {
    			token = 1;
    			//check if there is any process working on another queue and save it 
    			//check q2 
    			if(avail2 == false) {
    				q2remainingtimelist.add(remainingtime);
    				q2waitingqueueindex.add(activeprocessindex);
    				q2waitingqueuepriority.add(prior);
    				q2remainingquantumtime.add(remainingquantum);	
    				
    				avail2 = true;
    			}
    			//
    			//check q3 
    			if(avail3 == false){
        			q3remainingtimelist.add(remainingtime);
    				q3waitingqueueindex.add(activeprocessindex);
    				q3waitingqueuepriority.add(prior);
    				//update quantum 
    				quantumtimelist.set(activeprocessindex, quantumtimelist.get(activeprocessindex)+remainingquantum);
    				//save update history 
    				quantumhistory.get(activeprocessindex).add(quantumtimelist.get(activeprocessindex));
    				//
    				q3remainingquantumtime.add(quantumtimelist.get(activeprocessindex));
    				
    				avail3 = true;
    			}
    			//
    			
    			//
    		}
    		else {
    			if(!q2waitingqueueindex.isEmpty() || avail2 == false) {
    				token = 2;
        			//check if there is any process working on another queue and save it 
        			//check q3 
        			if(avail3 == false){
            			q3remainingtimelist.add(remainingtime);
        				q3waitingqueueindex.add(activeprocessindex);
        				q3waitingqueuepriority.add(prior);
        				quantumtimelist.set(activeprocessindex, quantumtimelist.get(activeprocessindex)+remainingquantum);
        				//save update history 
        				quantumhistory.get(activeprocessindex).add(quantumtimelist.get(activeprocessindex));
        				//
        				q3remainingquantumtime.add(quantumtimelist.get(activeprocessindex));
        				
        				avail3 = true;
        			}
        			//
    			}
    			else {
    				if(!q3waitingqueueindex.isEmpty() || avail3 == false) {
    					token = 3;
    				}
    				else {
    					token = 0;   //?????
    				}
    			}
    		}	
    		
    		//System.out.println("token : " + token);
    		    		
    		if(token == 1) {
    			//if the process has finished 
    			if(activeprocessindex!=-1) {
    	    		if(remainingtime==0) {
    	    			avail1 = true;
    	    			activeprocessindex = -1;
    	    		}
    	    		}
    			
    			
                //get one from q1
        		//if there is no process ongoing 
        		if(avail1){
        			if(!q1waitingqueueindex.isEmpty()) {
        				remainingtime = q1remainingtimelist.get(0);
        				activeprocessindex = q1waitingqueueindex.get(0);
        				prior = q1waitingqueuepriority.get(0);
        				remainingquantum = q1remainingquantumtime.get(0);	
        				
        				q1remainingtimelist.remove(0);
        				q1waitingqueueindex.remove(0);
        				q1waitingqueuepriority.remove(0);
        				q1remainingquantumtime.remove(0);		
        				
        				avail1 = false;
        			}
        			else {
        				//activeprocessindex = -1
        			}
        		}
        		
        		///////////////////
    			
    		}
    		
    		if(token == 2) {
    			
    			//if the process has finished 
				//System.out.println("remaining time : "  + remainingtime);
        		if(activeprocessindex!=-1){
        		if(remainingtime==0) {
        			avail2 = true;
        			activeprocessindex = -1;
        		}
        		}
        		
        		//if there is no process ongoing 
        		if(avail2){
        			if(!q2waitingqueueindex.isEmpty()) {
        				int minindexpriority = getminidx(q2waitingqueuepriority);
            			
        				activeprocessindex = q2waitingqueueindex.get(minindexpriority);
        				//System.out.println("inside q2 : "  + activeprocessindex);
            			remainingtime = q2remainingtimelist.get(minindexpriority);
            			prior = q2waitingqueuepriority.get(minindexpriority);
        				remainingquantum = q2remainingquantumtime.get(minindexpriority);	
        				//System.out.println("remainingtime : " + remainingtime);
        				//System.out.println("remainingQtime : " + remainingquantum);


            			
        				q2remainingtimelist.remove(minindexpriority);
        				q2waitingqueueindex.remove(minindexpriority);
        				q2waitingqueuepriority.remove(minindexpriority);
        				q2remainingquantumtime.remove(minindexpriority);	
        				
        				avail2 = false;
        			}
        			else {
        				//activeprocessindex = -1
        			}
        		}
        		
        		///////////////////
    			//get one from q2
    			
    		}
    		
    		if(token == 3) {
				/////////////////////////////////
				//if process has finshed //or it's ready to get sth
    			//System.out.println("in token 3");
		    	if(remainingtime == 0 || avail3 == true) {
		    		if(!q3waitingqueueindex.isEmpty()) {
		    			
		    			//get one from waiting queue
		    			int idxhpro = getminidx(q3remainingtimelist);
		    			activeprocessindex = q3waitingqueueindex.get(idxhpro);
		    			remainingtime = q3remainingtimelist.get(idxhpro);
		    			prior = q3waitingqueuepriority.get(idxhpro);
						remainingquantum = q3remainingquantumtime.get(idxhpro);	
						
						q3remainingtimelist.remove(idxhpro);
						q3waitingqueueindex.remove(idxhpro);
						q3waitingqueuepriority.remove(idxhpro);
						q3remainingquantumtime.remove(idxhpro);	
						
						avail3 = false;
		    		    
		    		}
		    		// if it is empty here i am just gonna wait till a process came 
		    		else {
		    			activeprocessindex = -1;
		    			avail3 = true;
		    		}
		    	}
		    	//if there's still remaining time
		    	else {
		    		avail3 = false;
		    	}
		    	
		    	/////////////
		    	
		    	//there's a process has a higher priority 
	    		if(activeprocessindex!=-1) {
		    	if(!q3waitingqueueindex.isEmpty()) {
	    			
	    			//get one from waiting queue
	    			int idxhpro1 = getminidx(q3remainingtimelist);
	    			//current vs waitingqueue
	    			if(priorities.get(activeprocessindex)>q3waitingqueuepriority.get(idxhpro1)) {
	    			int minidx = q3waitingqueueindex.get(idxhpro1);
	    				    			
	    			//add the curr to waiting queue 
    				q3remainingtimelist.add(remainingtime);
    				q3waitingqueueindex.add(activeprocessindex);
    				q3waitingqueuepriority.add(prior);
    				q3remainingquantumtime.add(remainingquantum);	
	    			
	    			activeprocessindex = minidx;
	    				    			
	    			//delete it from waiting queue
					q3remainingtimelist.remove(idxhpro1);
					q3waitingqueueindex.remove(idxhpro1);
					q3waitingqueuepriority.remove(idxhpro1);
					q3remainingquantumtime.remove(idxhpro1);	
					
					avail3 = false;
	    			}
	    		    
	    		}
				//////////////////////////////////
    		}
	    	//close if token == 3 	
		    	
	    		}

	    		
	    		//////modify the 4 variables 
		        if(activeprocessindex!=-1) { 	 
		    		//System.out.println("final acitve : "+activeprocessindex);
	   	            remainingtime--;
	   	            remainingquantum--;
	   	            remainingtimelist.set(activeprocessindex, remainingtimelist.get(activeprocessindex)-1);
		    	}
		        //////////////////////////////////////
		       
				
				//////
	///////////////////
				////get data 
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
		        	 
		    	time++;
    		}
    		
    		///////check if this process at first queue
    		/*if(0.25*quantumtimelist.get(activeprocessindex)>=quantumtimelist.get(activeprocessindex)-remainingquantumtime.get(activeprocessindex)) {
                 
    		}
    		*/
    		
			
       	 
    		
    		//////modify the 4 variables 
	        if(activeprocessindex!=-1) { 	 
   	            remainingtime--;
   	            remainingquantum--;
   	            remainingtimelist.set(activeprocessindex, remainingtimelist.get(activeprocessindex)-1);
	    	}
	        //////////////////////////////////////
	        
	        
	        
	        
	        //increment time
			time++;
			
			//////
///////////////////
			////get data 
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
	
	//////get quantum history 
	//////////////////////////////////
	/////////////////////////////////
		}
	
	
	
		boolean checkzeros(ArrayList<Integer> a) {
			if(a.isEmpty()) {
				return false;
			}
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
		
		public void printtable(ArrayList<ArrayList<Integer>> mat) {
			for(int i=0;i<mat.size();i++) {
				System.out.print(processesname.get(i) + " : ");
				for(int j:mat.get(i)) {
					System.out.print(j + "   ");
				}
				System.out.println();
			}
		}
		
		
		
		
		
		
	

}
