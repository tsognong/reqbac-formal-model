package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Resource_to_View{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Resource_to_View(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.RESOURCE.has(r) && machine.get_ViO1().has(vio) && !machine.get_RV1().has(new Pair<Integer,Pair<Integer,Integer>>(r,vio))); */
	public /*@ pure */ boolean guard_Assign_Resource_to_View( Integer r, Pair<Integer,Integer> vio) {
		return (machine.RESOURCE.has(r) && machine.get_ViO1().has(vio) && !machine.get_RV1().has(new Pair<Integer,Pair<Integer,Integer>>(r,vio)));
	}

	/*@ public normal_behavior
		requires guard_Assign_Resource_to_View(r,vio);
		assignable machine.RV1;
		ensures guard_Assign_Resource_to_View(r,vio) &&  machine.get_RV1().equals(\old((machine.get_RV1().union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(r,vio)))))); 
	 also
		requires !guard_Assign_Resource_to_View(r,vio);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Resource_to_View( Integer r, Pair<Integer,Integer> vio){
		if(guard_Assign_Resource_to_View(r,vio)) {
			BRelation<Integer,Pair<Integer,Integer>> RV1_tmp = machine.get_RV1();

			machine.set_RV1((RV1_tmp.union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(r,vio)))));

			System.out.println("Assign_Resource_to_View executed r: " + r + " vio: " + vio + " ");
		}
	}

}
