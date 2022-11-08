package req_bac_sequential; 

import eventb_prelude.BRelation;
import eventb_prelude.Pair;

public class add_uses_relation{
	/*@ spec_public */ private reqbacm3 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public add_uses_relation(reqbacm3 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_resources().has(r) && machine.get_views().has(v) && !machine.get_uses().has(new Pair<Integer,Integer>(r,v))); */
	public /*@ pure */ boolean guard_add_uses_relation( Integer r, Integer v) {
		return (machine.get_resources().has(r) && machine.get_views().has(v) && !machine.get_uses().has(new Pair<Integer,Integer>(r,v)));
	}

	/*@ public normal_behavior
		requires guard_add_uses_relation(r,v);
		assignable machine.uses;
		ensures guard_add_uses_relation(r,v) &&  machine.get_uses().equals(\old((machine.get_uses().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(r,v)))))); 
	 also
		requires !guard_add_uses_relation(r,v);
		assignable \nothing;
		ensures true; */
	public void run_add_uses_relation( Integer r, Integer v){
		if(guard_add_uses_relation(r,v)) {
			BRelation<Integer,Integer> uses_tmp = machine.get_uses();
			machine.set_uses((uses_tmp.union(new BRelation(new Pair(r,v)))));
			System.out.println("add_uses_relation executed r: " + r + " v: " + v + " ");
		}
	}

}
