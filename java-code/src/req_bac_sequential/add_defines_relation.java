package req_bac_sequential; 

import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.Pair;

public class add_defines_relation{
	/*@ spec_public */ private reqbacm3 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public add_defines_relation(reqbacm3 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_employees().has(e) && machine.get_resources().has(r) && machine.get_actions().has(a) && c.isSubset(machine.get_contexts()) && !machine.get_defines().has(new Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(e,r),a),c))); */
	public /*@ pure */ boolean guard_add_defines_relation( Integer a, BSet<Integer> c, Integer e, Integer r) {
		return (machine.get_employees().has(e) && machine.get_resources().has(r) && machine.get_actions().has(a) && c.isSubset(machine.get_contexts()) && !machine.get_defines().has(new Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(e,r),a),c)));
	}

	/*@ public normal_behavior
		requires guard_add_defines_relation(a,c,e,r);
		assignable machine.defines;
		ensures guard_add_defines_relation(a,c,e,r) &&  machine.get_defines().equals(\old((machine.get_defines().union(new BRelation<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(e,r),a),c)))))); 
	 also
		requires !guard_add_defines_relation(a,c,e,r);
		assignable \nothing;
		ensures true; */
	public void run_add_defines_relation( Integer a, BSet<Integer> c, Integer e, Integer r){
		if(guard_add_defines_relation(a,c,e,r)) {
			BRelation<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>> defines_tmp = machine.get_defines();

			machine.set_defines((defines_tmp.union(new BRelation<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(e,r),a),c)))));

			System.out.println("add_defines_relation executed a: " + a + " c: " + c + " e: " + e + " r: " + r + " ");
		}
	}

}
