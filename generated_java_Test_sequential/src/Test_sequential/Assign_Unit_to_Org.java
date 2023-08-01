package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Unit_to_Org{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Unit_to_Org(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (!machine.get_OU1().has(new Pair<Integer,Integer>(u,org)) && !machine.get_OU1().domain().has(u) &&  (\forall Integer org1;  (\forall Integer role;((machine.get_UR1().has(new Pair<Integer,Pair<Integer,Integer>>(u,new Pair<Integer,Integer>(role,org1)))) ==> (org.equals(org1)))))); */
	public /*@ pure */ boolean guard_Assign_Unit_to_Org( Integer org, Integer u) {
		return (!machine.get_OU1().has(new Pair<Integer,Integer>(u,org)) && !machine.get_OU1().domain().has(u) && true);
	}

	/*@ public normal_behavior
		requires guard_Assign_Unit_to_Org(org,u);
		assignable machine.OU1;
		ensures guard_Assign_Unit_to_Org(org,u) &&  machine.get_OU1().equals(\old((machine.get_OU1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u,org)))))); 
	 also
		requires !guard_Assign_Unit_to_Org(org,u);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Unit_to_Org( Integer org, Integer u){
		if(guard_Assign_Unit_to_Org(org,u)) {
			BRelation<Integer,Integer> OU1_tmp = machine.get_OU1();

			machine.set_OU1((OU1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u,org)))));

			System.out.println("Assign_Unit_to_Org executed org: " + org + " u: " + u + " ");
		}
	}

}
