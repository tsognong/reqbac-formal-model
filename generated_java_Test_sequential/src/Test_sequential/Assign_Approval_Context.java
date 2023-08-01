package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Approval_Context{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Approval_Context(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (!machine.get_PAcA1().has(new Pair<Integer,Pair<Integer,Integer>>(p,c)) && machine.get_CiO1().has(c)); */
	public /*@ pure */ boolean guard_Assign_Approval_Context( Pair<Integer,Integer> c, Integer p) {
		return (!machine.get_PAcA1().has(new Pair<Integer,Pair<Integer,Integer>>(p,c)) && machine.get_CiO1().has(c));
	}

	/*@ public normal_behavior
		requires guard_Assign_Approval_Context(c,p);
		assignable machine.PAcA1;
		ensures guard_Assign_Approval_Context(c,p) &&  machine.get_PAcA1().equals(\old((machine.get_PAcA1().override(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(p,c)))))); 
	 also
		requires !guard_Assign_Approval_Context(c,p);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Approval_Context( Pair<Integer,Integer> c, Integer p){
		if(guard_Assign_Approval_Context(c,p)) {
			BRelation<Integer,Pair<Integer,Integer>> PAcA1_tmp = machine.get_PAcA1();

			machine.set_PAcA1((PAcA1_tmp.override(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(p,c)))));

			System.out.println("Assign_Approval_Context executed c: " + c + " p: " + p + " ");
		}
	}

}
