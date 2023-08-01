package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Role_to_Unit{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Role_to_Unit(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_RiO1().has(r) && machine.UNIT.has(u) && !machine.get_UR1().has(new Pair<Integer,Pair<Integer,Integer>>(u,r)) &&  (\forall Integer role;  (\forall Integer org;((r.equals(new Pair<Integer,Integer>(role,org))) ==> (((!machine.get_OU1().image(new BSet<Integer>(u)).equals(BSet.EMPTY)) ==> (machine.get_OU1().apply(u).equals(org)))))))); */
	public /*@ pure */ boolean guard_Assign_Role_to_Unit( Pair<Integer,Integer> r, Integer u) {
		return (machine.get_RiO1().has(r) && machine.UNIT.has(u) && !machine.get_UR1().has(new Pair<Integer,Pair<Integer,Integer>>(u,r)) && true);
	}

	/*@ public normal_behavior
		requires guard_Assign_Role_to_Unit(r,u);
		assignable machine.UR1;
		ensures guard_Assign_Role_to_Unit(r,u) &&  machine.get_UR1().equals(\old((machine.get_UR1().union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(u,r)))))); 
	 also
		requires !guard_Assign_Role_to_Unit(r,u);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Role_to_Unit( Pair<Integer,Integer> r, Integer u){
		if(guard_Assign_Role_to_Unit(r,u)) {
			BRelation<Integer,Pair<Integer,Integer>> UR1_tmp = machine.get_UR1();

			machine.set_UR1((UR1_tmp.union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(u,r)))));

			System.out.println("Assign_Role_to_Unit executed r: " + r + " u: " + u + " ");
		}
	}

}
