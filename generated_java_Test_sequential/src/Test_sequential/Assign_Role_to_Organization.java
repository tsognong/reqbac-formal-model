package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Role_to_Organization{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Role_to_Organization(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.ROLE.has(r) && machine.ORG.has(org) && !machine.get_RiO1().has(new Pair<Integer,Integer>(r,org))); */
	public /*@ pure */ boolean guard_Assign_Role_to_Organization( Integer org, Integer r) {
		return (machine.ROLE.has(r) && machine.ORG.has(org) && !machine.get_RiO1().has(new Pair<Integer,Integer>(r,org)));
	}

	/*@ public normal_behavior
		requires guard_Assign_Role_to_Organization(org,r);
		assignable machine.RiO1;
		ensures guard_Assign_Role_to_Organization(org,r) &&  machine.get_RiO1().equals(\old((machine.get_RiO1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(r,org)))))); 
	 also
		requires !guard_Assign_Role_to_Organization(org,r);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Role_to_Organization( Integer org, Integer r){
		if(guard_Assign_Role_to_Organization(org,r)) {
			BRelation<Integer,Integer> RiO1_tmp = machine.get_RiO1();

			machine.set_RiO1((RiO1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(r,org)))));

			System.out.println("Assign_Role_to_Organization executed org: " + org + " r: " + r + " ");
		}
	}

}
