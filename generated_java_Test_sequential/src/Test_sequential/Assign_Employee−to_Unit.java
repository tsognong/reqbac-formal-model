package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Employee?to_Unit{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Employee?to_Unit(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (!machine.get_EA1().has(new Pair<Integer,Integer>(e,u)) &&  (\forall Integer u1;((machine.get_EA1().has(new Pair<Integer,Integer>(e,u1))) ==> (!machine.get_UH1().has(new Pair<Integer,Integer>(u,u1)) && !machine.get_UH1().has(new Pair<Integer,Integer>(u1,u)))))); */
	public /*@ pure */ boolean guard_Assign_Employee?to_Unit( Integer e, Integer u) {
		return (!machine.get_EA1().has(new Pair<Integer,Integer>(e,u)) && true);
	}

	/*@ public normal_behavior
		requires guard_Assign_Employee?to_Unit(e,u);
		assignable machine.EA1;
		ensures guard_Assign_Employee?to_Unit(e,u) &&  machine.get_EA1().equals(\old((machine.get_EA1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(e,u)))))); 
	 also
		requires !guard_Assign_Employee?to_Unit(e,u);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Employee?to_Unit( Integer e, Integer u){
		if(guard_Assign_Employee?to_Unit(e,u)) {
			BRelation<Integer,Integer> EA1_tmp = machine.get_EA1();

			machine.set_EA1((EA1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(e,u)))));

			System.out.println("Assign_Employee?to_Unit executed e: " + e + " u: " + u + " ");
		}
	}

}
