package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_activity_to_Organization{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_activity_to_Organization(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.ACTIVITY.has(a) && machine.ORG.has(org) && !machine.get_AiO1().has(new Pair<Integer,Integer>(a,org)) && !machine.get_AA1().range().has(new Pair<Integer,Integer>(a,org))); */
	public /*@ pure */ boolean guard_Assign_activity_to_Organization( Integer a, Integer org) {
		return (machine.ACTIVITY.has(a) && machine.ORG.has(org) && !machine.get_AiO1().has(new Pair<Integer,Integer>(a,org)) && !machine.get_AA1().range().has(new Pair<Integer,Integer>(a,org)));
	}

	/*@ public normal_behavior
		requires guard_Assign_activity_to_Organization(a,org);
		assignable machine.AiO1;
		ensures guard_Assign_activity_to_Organization(a,org) &&  machine.get_AiO1().equals(\old((machine.get_AiO1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(a,org)))))); 
	 also
		requires !guard_Assign_activity_to_Organization(a,org);
		assignable \nothing;
		ensures true; */
	public void run_Assign_activity_to_Organization( Integer a, Integer org){
		if(guard_Assign_activity_to_Organization(a,org)) {
			BRelation<Integer,Integer> AiO1_tmp = machine.get_AiO1();

			machine.set_AiO1((AiO1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(a,org)))));

			System.out.println("Assign_activity_to_Organization executed a: " + a + " org: " + org + " ");
		}
	}

}
