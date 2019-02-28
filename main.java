import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
	/////////////SJF	
		
     
	/* ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3","p4"));
     ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,2,4,5));
     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(7,4,1,4));
     
     ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3","p4"));
     ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,0,0,0));
     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(8,4,9,5));
     
     newSJF sjf = new newSJF(2,AT,BT,PN,BT);
     sjf.DoSJF();
     sjf.printarrstr(sjf.Order);
     sjf.printarrint(sjf.WaitingTime);
     */
     
     //////////RR
    /* ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3"));
     ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,0,0));
     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(24,3,3));
		
		ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3","p4"));
	     ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,0,0,0));
	     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(53,17,68,24));
		
		
     
     roundrobin rr = new roundrobin(20,AT,BT,0,PN);
     rr.doroundrobin();
     rr.printarrstr(rr.Order);
     rr.printarrint(rr.WaitingTime);
     rr.printarrint(rr.turnaroundtime);
     System.out.println(rr.averagewaitingtime);
     System.out.println(rr.averageturnaroundtime);*/
		
		//spriority 
		
		/*
		 * ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3","p4","p5"));
	     ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,0,0,0,1));
	     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(10,1,2,1,5));
	     ArrayList<Integer> p = new ArrayList<Integer>(Arrays.asList(3,1,4,5,2));
		
	     ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3","p4"));
	     ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,2,4,5));
	     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(7,4,1,4));*/
	     
	     /*
	      *
	     spriority pr = new spriority(2,0,AT,BT,PN,p);
	     pr.Dopriority();
	     pr.printarrstr(pr.Order);
	     pr.printarrint(pr.WaitingTime);
	     pr.printarrint(pr.turnaroundtime);
	     System.out.println(pr.averagewaitingtime);
	     System.out.println(pr.averageturnaroundtime);
	     */
	     
		
	     /*
	      * ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,0,0));
	     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(24,3,3));
	     ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3"));
	     
         FCFS fcfs = new FCFS(0,AT,BT,PN);
         fcfs.doFCFS();
         fcfs.printarrstr(fcfs.Order);
         fcfs.printarrint(fcfs.WaitingTime);
         fcfs.printarrint(fcfs.turnaroundtime);
	     System.out.println(fcfs.averagewaitingtime);
	     System.out.println(fcfs.averageturnaroundtime);
	     */
		
		/*ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
	     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(10,1,2,1,5));
	     ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3","p4","p5"));
	     ArrayList<Integer> p = new ArrayList<Integer>(Arrays.asList(3,1,4,5,2));
	     
        npPriority npp = new npPriority(0,AT,BT,PN,p);
        npp.doFCFS();
        npp.printarrstr(npp.Order);
        npp.printarrint(npp.WaitingTime);
        npp.printarrint(npp.turnaroundtime);
	     System.out.println(npp.averagewaitingtime);
	     System.out.println(npp.averageturnaroundtime);
	     
		*/
		
	     /*ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,2,5,15));
	     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(17,6,11,4));
		 ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2","p3","p4"));
	     ArrayList<Integer> p = new ArrayList<Integer>(Arrays.asList(4,7,3,6));
	     ArrayList<Integer> q = new ArrayList<Integer>(Arrays.asList(7,9,4,6));*/
	     
	     /*ArrayList<Integer> AT = new ArrayList<Integer>(Arrays.asList(0,2));
	     ArrayList<Integer> BT = new ArrayList<Integer>(Arrays.asList(17,6));
		 ArrayList<String> PN = new ArrayList<String>(Arrays.asList("p1","p2"));
	     ArrayList<Integer> p = new ArrayList<Integer>(Arrays.asList(4,7));
	     ArrayList<Integer> q = new ArrayList<Integer>(Arrays.asList(7,9));*/
	     
	     /*AG ag = new AG(AT,BT,PN,p,q);
	     ag.doAG();
	        ag.printarrstr(ag.Order);
	        ag.printarrint(ag.WaitingTime);
	        ag.printarrint(ag.turnaroundtime);
		     System.out.println(ag.averagewaitingtime);
		     System.out.println(ag.averageturnaroundtime);
		     ag.printtable(ag.quantumhistory);*/
	     while(true) {
	     System.out.println("Choose a Schedule");
	     System.out.println("1.	preemptive Shortest- Job  First (SJF) Scheduling  with context switching ");
	     System.out.println("2.	Round Robin (RR) with context switching");
	     System.out.println("3.	preemptive  Priority Scheduling with starvation solution");
	     System.out.println("4.	AG  Scheduling ");
	     int contextswitch; 
	     
	     Scanner in = new Scanner(System.in); 
	     Scanner instr = new Scanner(System.in);
	     int schedulenum = in.nextInt();
	     if(schedulenum== 1) {
	    	 System.out.println("Enter context switch");
	    	 in = new Scanner(System.in);
	    	 contextswitch = in.nextInt();
		     System.out.println("arrival time : ");
		     instr = new Scanner(System.in);
	    	 String ATstr = instr.nextLine();
		     System.out.println("Burst time : ");
		     instr = new Scanner(System.in);
	    	 String BTstr = instr.nextLine();
		     System.out.println("process names : ");
		     instr = new Scanner(System.in);
	    	 String PNstr = instr.nextLine();
	    	 
	    	 
	    	 String ATarr[] = ATstr.split(" ");
	    	 String BTarr[] = BTstr.split(" ");
	    	 String PNarr[] = PNstr.split(" ");
	    	 
	         ArrayList<String> PN = new ArrayList<String>();
	         ArrayList<Integer> AT = new ArrayList<Integer>();
	         ArrayList<Integer> BT = new ArrayList<Integer>();
	    	 
	    	 for(int i=0;i<ATarr.length;i++) {
	    		 PN.add(PNarr[i]);
	    		 AT.add(Integer.parseInt(ATarr[i]));
	    		 BT.add(Integer.parseInt(BTarr[i])); 
	    	 }


	    	 newSJF sjf = new newSJF(contextswitch,AT,BT,PN,BT);
	    	 sjf.DoSJF();
		        System.out.println("Order  : ");sjf.printarrstr(sjf.Order);
		        System.out.println();
		        System.out.println("WaitingTime  : ");sjf.printarrint(sjf.WaitingTime);
		        System.out.println();
		        System.out.println("turnaroundtime  : ");sjf.printarrint(sjf.turnaroundtime);
		        System.out.println();
		        System.out.println("averageWaitingTime  : ");System.out.println(sjf.averagewaitingtime);
		        System.out.println();
		        System.out.println("averageturnaroundtime  : ");System.out.println(sjf.averageturnaroundtime);
	     }
	     else if(schedulenum== 2) {
	    	 System.out.println("Enter quantum time");
	    	 in = new Scanner(System.in);
	    	 int quantumtime = in.nextInt();
	    	 System.out.println("Enter context switch");
	    	 in = new Scanner(System.in);
	    	 contextswitch = in.nextInt();
		     System.out.println("arrival time : ");
		     instr = new Scanner(System.in);
	    	 String ATstr = instr.nextLine();
		     System.out.println("Burst time : ");
		     instr = new Scanner(System.in);
	    	 String BTstr = instr.nextLine();
		     System.out.println("process names : ");
		     instr = new Scanner(System.in);
	    	 String PNstr = instr.nextLine();
	    	 
	    	 
	    	 String ATarr[] = ATstr.split(" ");
	    	 String BTarr[] = BTstr.split(" ");
	    	 String PNarr[] = PNstr.split(" ");
	    	 
	         ArrayList<String> PN = new ArrayList<String>();
	         ArrayList<Integer> AT = new ArrayList<Integer>();
	         ArrayList<Integer> BT = new ArrayList<Integer>();
	    	 
	    	 for(int i=0;i<ATarr.length;i++) {
	    		 PN.add(PNarr[i]);
	    		 AT.add(Integer.parseInt(ATarr[i]));
	    		 BT.add(Integer.parseInt(BTarr[i])); 
	    	 }


	    	 roundrobin rr = new roundrobin(quantumtime,contextswitch,AT,BT,PN);
	    	 rr.doroundrobin();
		        System.out.println("Order  : ");rr.printarrstr(rr.Order);
		        System.out.println();
		        System.out.println("WaitingTime  : ");rr.printarrint(rr.WaitingTime);
		        System.out.println();
		        System.out.println("turnaroundtime  : ");rr.printarrint(rr.turnaroundtime);
		        System.out.println();
		        System.out.println("averageWaitingTime  : ");System.out.println(rr.averagewaitingtime);
		        System.out.println();
		        System.out.println("averageturnaroundtime  : ");System.out.println(rr.averageturnaroundtime);
	     }
	     else if(schedulenum== 3) {
	    	 System.out.println("Enter aging score");
	    	 in = new Scanner(System.in);
	    	 int agingscore = in.nextInt();
		     System.out.println("arrival time : ");
		     instr = new Scanner(System.in);
	    	 String ATstr = instr.nextLine();
		     System.out.println("Burst time : ");
		     instr = new Scanner(System.in);
	    	 String BTstr = instr.nextLine();
		     System.out.println("process names : ");
		     instr = new Scanner(System.in);
	    	 String PNstr = instr.nextLine();
		     System.out.println("priorities : ");
		     instr = new Scanner(System.in);
	    	 String Pstr = instr.nextLine();
	    	 
	    	 
	    	 String ATarr[] = ATstr.split(" ");
	    	 String BTarr[] = BTstr.split(" ");
	    	 String PNarr[] = PNstr.split(" ");
	    	 String Parr[] = Pstr.split(" ");
	    	 
	         ArrayList<String> PN = new ArrayList<String>();
	         ArrayList<Integer> AT = new ArrayList<Integer>();
	         ArrayList<Integer> BT = new ArrayList<Integer>();
	         ArrayList<Integer> P = new ArrayList<Integer>();

	         
	    	 
	    	 for(int i=0;i<ATarr.length;i++) {
	    		 PN.add(PNarr[i]);
	    		 AT.add(Integer.parseInt(ATarr[i]));
	    		 BT.add(Integer.parseInt(BTarr[i])); 
	    		 P.add(Integer.parseInt(Parr[i]));
	    	 }


	    	 spriority sprio = new spriority(agingscore,AT,BT,PN,P);
	    	 sprio.Dopriority();
		        System.out.println("Order  : ");sprio.printarrstr(sprio.Order);
		        System.out.println();
		        System.out.println("WaitingTime  : ");sprio.printarrint(sprio.WaitingTime);
		        System.out.println();
		        System.out.println("turnaroundtime  : ");sprio.printarrint(sprio.turnaroundtime);
		        System.out.println();
		        System.out.println("averageWaitingTime  : ");System.out.println(sprio.averagewaitingtime);
		        System.out.println();
		        System.out.println("averageturnaroundtime  : ");System.out.println(sprio.averageturnaroundtime);
	     }
	     else if(schedulenum== 4) {

		     System.out.println("arrival time : ");
		     instr = new Scanner(System.in);
	    	 String ATstr = instr.nextLine();
		     System.out.println("Burst time : ");
		     instr = new Scanner(System.in);
	    	 String BTstr = instr.nextLine();
		     System.out.println("process names : ");
		     instr = new Scanner(System.in);
	    	 String PNstr = instr.nextLine();
		     System.out.println("priorities : ");
		     instr = new Scanner(System.in);
	    	 String Pstr = instr.nextLine();
		     System.out.println("quantum time : ");
		     instr = new Scanner(System.in);
	    	 String Qstr = instr.nextLine();
	    	 
	    	 
	    	 
	    	 String ATarr[] = ATstr.split(" ");
	    	 String BTarr[] = BTstr.split(" ");
	    	 String PNarr[] = PNstr.split(" ");
	    	 String Parr[] = Pstr.split(" ");
	    	 String Qarr[] = Qstr.split(" ");

	    	 
	         ArrayList<String> PN = new ArrayList<String>();
	         ArrayList<Integer> AT = new ArrayList<Integer>();
	         ArrayList<Integer> BT = new ArrayList<Integer>();
	         ArrayList<Integer> P = new ArrayList<Integer>();
	         ArrayList<Integer> Q = new ArrayList<Integer>();


	         
	    	 
	    	 for(int i=0;i<ATarr.length;i++) {
	    		 PN.add(PNarr[i]);
	    		 AT.add(Integer.parseInt(ATarr[i]));
	    		 BT.add(Integer.parseInt(BTarr[i])); 
	    		 P.add(Integer.parseInt(Parr[i]));
	    		 Q.add(Integer.parseInt(Qarr[i]));	 
	    	 }

                AG ag = new AG(AT,BT,PN,P,Q);
                ag.doAG();
		        System.out.println("Order  : ");ag.printarrstr(ag.Order);
		        System.out.println();
		        System.out.println("WaitingTime  : ");ag.printarrint(ag.WaitingTime);
		        System.out.println();
		        System.out.println("turnaroundtime  : ");ag.printarrint(ag.turnaroundtime);
		        System.out.println();
		        System.out.println("averageWaitingTime  : ");System.out.println(ag.averagewaitingtime);
		        System.out.println();
		        System.out.println("averageturnaroundtime  : ");System.out.println(ag.averageturnaroundtime);
		        System.out.println();
		        ag.printtable(ag.quantumhistory);
	     }
	     else {
	    	 System.out.println("wrong number");
	     }
	     System.out.println();
	     //close while true
	     }
     
     
     
	}

}	
