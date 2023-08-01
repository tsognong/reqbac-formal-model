package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Action_to_Activity{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Action_to_Activity(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.ACTION.has(a) && machine.get_AiO1().has(aio) && machine.get_ViO1().has(vio) && !machine.get_AA1().has(new Pair<Integer,Pair<Integer,Integer>>(a,aio)) && !machine.get_AV1().has(new Pair<Integer,Pair<Integer,Integer>>(a,vio))); */
	public /*@ pure */ boolean guard_Assign_Action_to_Activity( Integer a, Pair<Integer,Integer> aio, Pair<Integer,Integer> vio) {
		return (machine.ACTION.has(a) && machine.get_AiO1().has(aio) && machine.get_ViO1().has(vio) && !machine.get_AA1().has(new Pair<Integer,Pair<Integer,Integer>>(a,aio)) && !machine.get_AV1().has(new Pair<Integer,Pair<Integer,Integer>>(a,vio)));
	}

	/*@ public normal_behavior
		requires guard_Assign_Action_to_Activity(a,aio,vio);
		assignable machine.AA1, machine.AV1;
		ensures guard_Assign_Action_to_Activity(a,aio,vio) &&  machine.get_AA1().equals(\old((machine.get_AA1().union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(a,aio)))))) &&  machine.get_AV1().equals(\old((machine.get_AV1().union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(a,vio)))))); 
	 also
		requires !guard_Assign_Action_to_Activity(a,aio,vio);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Action_to_Activity( Integer a, Pair<Integer,Integer> aio, Pair<Integer,Integer> vio){
		if(guard_Assign_Action_to_Activity(a,aio,vio)) {
			BRelation<Integer,Pair<Integer,Integer>> AA1_tmp = machine.get_AA1();
			BRelation<Integer,Pair<Integer,Integer>> AV1_tmp = machine.get_AV1();

			machine.set_AA1((AA1_tmp.union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(a,aio)))));
			machine.set_AV1((AV1_tmp.union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(a,vio)))));

			System.out.println("Assign_Action_to_Activity executed a: " + a + " aio: " + aio + " vio: " + vio + " ");
		}
	}

}
