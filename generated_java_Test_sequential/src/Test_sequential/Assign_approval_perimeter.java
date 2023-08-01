package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_approval_perimeter{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_approval_perimeter(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (!machine.get_PDistA().has(new Pair<Integer,Integer>(perm,dist)) && NAT.instance.has(dist)); */
	public /*@ pure */ boolean guard_Assign_approval_perimeter( Integer perm, Integer dist) {
		return (!machine.get_PDistA().has(new Pair<Integer,Integer>(perm,dist)) && NAT.instance.has(dist));
	}

	/*@ public normal_behavior
		requires guard_Assign_approval_perimeter(perm,dist);
		assignable machine.PDistA;
		ensures guard_Assign_approval_perimeter(perm,dist) &&  machine.get_PDistA().equals(\old((machine.get_PDistA().override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(perm,dist)))))); 
	 also
		requires !guard_Assign_approval_perimeter(perm,dist);
		assignable \nothing;
		ensures true; */
	public void run_Assign_approval_perimeter( Integer perm, Integer dist){
		if(guard_Assign_approval_perimeter(perm,dist)) {
			BRelation<Integer,Integer> PDistA_tmp = machine.get_PDistA();

			machine.set_PDistA((PDistA_tmp.override(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(perm,dist)))));

			System.out.println("Assign_approval_perimeter executed perm: " + perm + " dist: " + dist + " ");
		}
	}

}
