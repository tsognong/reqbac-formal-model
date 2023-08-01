package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_View_to_Organization{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_View_to_Organization(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.VIEW.has(v) && machine.ORG.has(org) && !machine.get_ViO1().has(new Pair<Integer,Integer>(v,org)) && !machine.get_RV1().range().has(new Pair<Integer,Integer>(v,org)) && !machine.get_AV1().range().has(new Pair<Integer,Integer>(v,org))); */
	public /*@ pure */ boolean guard_Assign_View_to_Organization( Integer org, Integer v) {
		return (machine.VIEW.has(v) && machine.ORG.has(org) && !machine.get_ViO1().has(new Pair<Integer,Integer>(v,org)) && !machine.get_RV1().range().has(new Pair<Integer,Integer>(v,org)) && !machine.get_AV1().range().has(new Pair<Integer,Integer>(v,org)));
	}

	/*@ public normal_behavior
		requires guard_Assign_View_to_Organization(org,v);
		assignable machine.ViO1;
		ensures guard_Assign_View_to_Organization(org,v) &&  machine.get_ViO1().equals(\old((machine.get_ViO1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(v,org)))))); 
	 also
		requires !guard_Assign_View_to_Organization(org,v);
		assignable \nothing;
		ensures true; */
	public void run_Assign_View_to_Organization( Integer org, Integer v){
		if(guard_Assign_View_to_Organization(org,v)) {
			BRelation<Integer,Integer> ViO1_tmp = machine.get_ViO1();

			machine.set_ViO1((ViO1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(v,org)))));

			System.out.println("Assign_View_to_Organization executed org: " + org + " v: " + v + " ");
		}
	}

}
