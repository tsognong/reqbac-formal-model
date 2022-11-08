package req_bac_sequential;

import eventb_prelude.BRelation;
import eventb_prelude.Pair;

public class add_employment {
	/* @ spec_public */ private reqbacm3 machine; // reference to the machine

	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 * this.machine == m;
	 */
	public add_employment(reqbacm3 m) {
		this.machine = m;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * <==> (machine.get_employees().has(e) &&
	 * machine.get_operational_units().has(u) && machine.get_organizations().has(o)
	 * && !machine.get_employs().has(new Pair<Integer,Integer>(e,u)) && !( (\exists
	 * Integer au;machine.get_appoints().has(new Pair<Integer,Integer>(e,au)) &&
	 * machine.get_units_hierarchies().has(new Pair<Integer,Integer>(u,au)))));
	 */
	public /* @ pure */ boolean guard_add_employment(Integer e, Integer o, Integer u) {
		return (machine.get_employees().has(e) && machine.get_operational_units().has(u)
				&& machine.get_organizations().has(o) && !machine.get_employs().has(new Pair<Integer, Integer>(e, u))
				&& !machine.appointement_has_violations(machine.get_employs().elementImage(e), u));
	}

	/*
	 * @ public normal_behavior requires guard_add_employment(e,o,u); assignable
	 * machine.employs; ensures guard_add_employment(e,o,u) &&
	 * machine.get_employs().equals(\old((machine.get_employs().union(new
	 * BRelation<Integer,Integer>(new Pair<Integer,Integer>(e,u)))))); also requires
	 * !guard_add_employment(e,o,u); assignable \nothing; ensures true;
	 */
	public void run_add_employment(Integer e, Integer o, Integer u) {
		if (guard_add_employment(e, o, u)) {
			BRelation<Integer, Integer> employs_tmp = machine.get_employs();

			machine.set_employs((employs_tmp.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(e, u)))));

			System.out.println("add_employment executed e: " + e + " o: " + o + " u: " + u + " ");
		}
	}

}
