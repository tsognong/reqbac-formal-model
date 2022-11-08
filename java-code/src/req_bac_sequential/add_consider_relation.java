package req_bac_sequential; 

import eventb_prelude.BRelation;
import eventb_prelude.Pair;

public class add_consider_relation{
	/*@ spec_public */ private reqbacm3 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public add_consider_relation(reqbacm3 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_actions().has(o) && machine.get_activities().has(a) && !machine.get_consider().has(new Pair<Integer,Integer>(o,a))); */
	public /*@ pure */ boolean guard_add_consider_relation( Integer a, Integer o) {
		return (machine.get_actions().has(o) && machine.get_activities().has(a) && !machine.get_consider().has(new Pair<Integer,Integer>(o,a)));
	}

	/*@ public normal_behavior
		requires guard_add_consider_relation(a,o);
		assignable machine.consider;
		ensures guard_add_consider_relation(a,o) &&  machine.get_consider().equals(\old((machine.get_consider().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(o,a)))))); 
	 also
		requires !guard_add_consider_relation(a,o);
		assignable \nothing;
		ensures true; */
	public void run_add_consider_relation( Integer a, Integer o){
		if(guard_add_consider_relation(a,o)) {
			BRelation<Integer,Integer> consider_tmp = machine.get_consider();

			machine.set_consider((consider_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(o,a)))));

			System.out.println("add_consider_relation executed a: " + a + " o: " + o + " ");
		}
	}

}
