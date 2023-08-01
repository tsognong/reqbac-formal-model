package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Context_to_Organization{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Context_to_Organization(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.ORG.has(org) && machine.CONTEXT.has(c) && !machine.get_CiO1().has(new Pair<Integer,Integer>(c,org))); */
	public /*@ pure */ boolean guard_Assign_Context_to_Organization( Integer c, Integer org) {
		return (machine.ORG.has(org) && machine.CONTEXT.has(c) && !machine.get_CiO1().has(new Pair<Integer,Integer>(c,org)));
	}

	/*@ public normal_behavior
		requires guard_Assign_Context_to_Organization(c,org);
		assignable machine.CiO1;
		ensures guard_Assign_Context_to_Organization(c,org) &&  machine.get_CiO1().equals(\old((machine.get_CiO1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(c,org)))))); 
	 also
		requires !guard_Assign_Context_to_Organization(c,org);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Context_to_Organization( Integer c, Integer org){
		if(guard_Assign_Context_to_Organization(c,org)) {
			BRelation<Integer,Integer> CiO1_tmp = machine.get_CiO1();

			machine.set_CiO1((CiO1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(c,org)))));

			System.out.println("Assign_Context_to_Organization executed c: " + c + " org: " + org + " ");
		}
	}

}
