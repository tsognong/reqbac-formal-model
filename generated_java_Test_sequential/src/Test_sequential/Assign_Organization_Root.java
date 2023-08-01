package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Organization_Root{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Organization_Root(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.ORG.has(org) && machine.UNIT.has(u) && !machine.get_root1().domain().has(org) && !machine.get_UH1().domain().has(u) && ((machine.get_root1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(org,u)))).range().intersection(machine.get_UH1().domain())).equals(BSet.EMPTY) && machine.get_OU1().has(new Pair<Integer,Integer>(u,org)) && !machine.get_root1().range().has(u) && machine.get_height().image(new BSet<Integer>(u)).equals(BSet.EMPTY)); */
	public /*@ pure */ boolean guard_Assign_Organization_Root( Integer org, Integer u) {
		return (machine.ORG.has(org) && machine.UNIT.has(u) && !machine.get_root1().domain().has(org) && !machine.get_UH1().domain().has(u) && ((machine.get_root1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(org,u)))).range().intersection(machine.get_UH1().domain())).equals(BSet.EMPTY) && machine.get_OU1().has(new Pair<Integer,Integer>(u,org)) && !machine.get_root1().range().has(u) && machine.get_height().image(new BSet<Integer>(u)).equals(BSet.EMPTY));
	}

	/*@ public normal_behavior
		requires guard_Assign_Organization_Root(org,u);
		assignable machine.root1, machine.height;
		ensures guard_Assign_Organization_Root(org,u) &&  machine.get_root1().equals(\old((machine.get_root1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(org,u)))))) &&  machine.get_height().equals(\old((machine.get_height().override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u,0)))))); 
	 also
		requires !guard_Assign_Organization_Root(org,u);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Organization_Root( Integer org, Integer u){
		if(guard_Assign_Organization_Root(org,u)) {
			BRelation<Integer,Integer> root1_tmp = machine.get_root1();
			BRelation<Integer,Integer> height_tmp = machine.get_height();

			machine.set_root1((root1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(org,u)))));
			machine.set_height((height_tmp.override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u,0)))));

			System.out.println("Assign_Organization_Root executed org: " + org + " u: " + u + " ");
		}
	}

}
