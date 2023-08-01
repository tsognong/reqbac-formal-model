package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Add_Unit_Hierarchy{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Add_Unit_Hierarchy(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.UNIT.has(u1) && machine.UNIT.has(u2) && !machine.get_UH1().domain().has(u1) && !machine.get_UH1().has(new Pair<Integer,Integer>(u1,u2)) && !u1.equals(u2) && !machine.get_UH1().has(new Pair<Integer,Integer>(u2,u1)) && !machine.get_root1().range().has(u1) && machine.get_OU1().image(new BSet<Integer>(u1)).equals(machine.get_OU1().image(new BSet<Integer>(u2))) &&  (\forall Integer e;((machine.get_EA1().has(new Pair<Integer,Integer>(e,u1))) ==> (!machine.get_EA1().has(new Pair<Integer,Integer>(e,u2))))) &&  (\forall Integer e;((machine.get_EA1().has(new Pair<Integer,Integer>(e,u2))) ==> (!machine.get_EA1().has(new Pair<Integer,Integer>(e,u1))))) && !machine.get_height().image(new BSet<Integer>(u2)).equals(BSet.EMPTY) && !machine.get_PATH().image(new BSet<Integer>(u2)).has(u1)); */
	public /*@ pure */ boolean guard_Add_Unit_Hierarchy( Integer u1, Integer u2) {
		return (machine.UNIT.has(u1) && machine.UNIT.has(u2) && !machine.get_UH1().domain().has(u1) && !machine.get_UH1().has(new Pair<Integer,Integer>(u1,u2)) && !u1.equals(u2) && !machine.get_UH1().has(new Pair<Integer,Integer>(u2,u1)) && !machine.get_root1().range().has(u1) && machine.get_OU1().image(new BSet<Integer>(u1)).equals(machine.get_OU1().image(new BSet<Integer>(u2))) && true && true && !machine.get_height().image(new BSet<Integer>(u2)).equals(BSet.EMPTY) && !machine.get_PATH().image(new BSet<Integer>(u2)).has(u1));
	}

	/*@ public normal_behavior
		requires guard_Add_Unit_Hierarchy(u1,u2);
		assignable machine.UH1, machine.height, machine.PATH;
		ensures guard_Add_Unit_Hierarchy(u1,u2) &&  machine.get_UH1().equals(\old((machine.get_UH1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u1,u2)))))) &&  machine.get_height().equals(\old((machine.get_height().override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u1,new Integer(machine.get_height().apply(u2) + 1))))))) &&  machine.get_PATH().equals(\old((machine.get_PATH().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u1,u2)).union(new Best<Integer>(new JMLObjectSet {Integer u3 | (\exists Integer e; (machine.get_PATH().has(new Pair<Integer,ERROR>(u2,u3))); e.equals(new Pair<Integer,ERROR>(u1,u3)))})))))); 
	 also
		requires !guard_Add_Unit_Hierarchy(u1,u2);
		assignable \nothing;
		ensures true; */
	public void run_Add_Unit_Hierarchy( Integer u1, Integer u2){
		if(guard_Add_Unit_Hierarchy(u1,u2)) {
			BRelation<Integer,Integer> UH1_tmp = machine.get_UH1();
			BRelation<Integer,Integer> height_tmp = machine.get_height();
			BRelation<Integer,Integer> PATH_tmp = machine.get_PATH();

			machine.set_UH1((UH1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u1,u2)))));
			machine.set_height((height_tmp.override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u1,new Integer(height_tmp.apply(u2) + 1))))));
			machine.set_PATH(null); // Set Comprehension: feature not supported by EventB2Java

			System.out.println("Add_Unit_Hierarchy executed u1: " + u1 + " u2: " + u2 + " ");
		}
	}

}
