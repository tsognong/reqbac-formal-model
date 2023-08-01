package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Approval_Deadline{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Approval_Deadline(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.PERMISSION.has(p) && NAT.instance.has(d) && !machine.get_PDA().has(new Pair<Integer,Integer>(p,d))); */
	public /*@ pure */ boolean guard_Assign_Approval_Deadline( Integer d, Integer p) {
		return (machine.PERMISSION.has(p) && NAT.instance.has(d) && !machine.get_PDA().has(new Pair<Integer,Integer>(p,d)));
	}

	/*@ public normal_behavior
		requires guard_Assign_Approval_Deadline(d,p);
		assignable machine.PDA;
		ensures guard_Assign_Approval_Deadline(d,p) &&  machine.get_PDA().equals(\old((machine.get_PDA().override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(p,d)))))); 
	 also
		requires !guard_Assign_Approval_Deadline(d,p);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Approval_Deadline( Integer d, Integer p){
		if(guard_Assign_Approval_Deadline(d,p)) {
			BRelation<Integer,Integer> PDA_tmp = machine.get_PDA();

			machine.set_PDA((PDA_tmp.override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(p,d)))));

			System.out.println("Assign_Approval_Deadline executed d: " + d + " p: " + p + " ");
		}
	}

}
