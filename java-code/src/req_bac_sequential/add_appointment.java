package req_bac_sequential;

import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.ID;
import eventb_prelude.Pair;

public class add_appointment {
	/* @ spec_public */ private reqbacm3 machine; // reference to the machine

	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 * this.machine == m;
	 */
	public add_appointment(reqbacm3 m) {
		this.machine = m;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * <==> (machine.get_employees().has(e) && machine.get_admin_units().has(au) &&
	 * machine.get_organizations().has(o) && !machine.get_appoints().has(new
	 * Pair<Integer,Integer>(e,au)) && (((machine.get_appoints().union(new
	 * BRelation<Integer,Integer>(new
	 * Pair<Integer,Integer>(e,au)))).compose(machine.get_units_hierarchies().
	 * compose((machine.get_appoints().union(new BRelation<Integer,Integer>(new
	 * Pair<Integer,Integer>(e,au)))).inverse()))).intersection((new
	 * ID()))).equals(BSet.EMPTY) &&
	 * ((machine.get_employs().compose(machine.get_units_hierarchies().compose((
	 * machine.get_appoints().union(new BRelation<Integer,Integer>(new
	 * Pair<Integer,Integer>(e,au)))).inverse()))).intersection((new
	 * ID()))).equals(BSet.EMPTY));
	 */
	public /* @ pure */ boolean guard_add_appointment(Integer e, Integer o, Integer au) {
		System.err.println("Appoints.......: "+machine.get_appoints().imagePairSet());
		return (machine.get_employees().has(e) && machine.get_admin_units().has(au)
				&& machine.get_organizations().has(o) && !machine.get_appoints().has(new Pair<Integer, Integer>(e, au))
				&& (((machine.get_appoints().union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(e, au))))
						.compose(machine.get_units_hierarchies()
								.compose((machine.get_appoints()
										.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(e, au))))
										.inverse())))
						.intersection((new ID()))).equals(BSet.EMPTY)
				&& ((machine.get_employs().compose(machine.get_units_hierarchies()
						.compose((machine.get_appoints()
								.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(e, au)))).inverse())))
						.intersection((new ID()))).equals(BSet.EMPTY)
				
				&& ! machine.appointement_has_violations(machine.get_appoints().elementImage(e), au)
			);
	}

	/*
	 * @ public normal_behavior requires guard_add_appointment(e,o,au); assignable
	 * machine.appoints; ensures guard_add_appointment(e,o,au) &&
	 * machine.get_appoints().equals(\old((machine.get_appoints().union(new
	 * BRelation<Integer,Integer>(new Pair<Integer,Integer>(e,au)))))); also
	 * requires !guard_add_appointment(e,o,au); assignable \nothing; ensures true;
	 */
	public void run_add_appointment(Integer e, Integer o, Integer au) {
		if (guard_add_appointment(e, o, au)) {
			BRelation<Integer, Integer> appoints_tmp = machine.get_appoints();

			machine.set_appoints(
					(appoints_tmp.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(e, au)))));

			System.out.println("add_appointment executed e: " + e + " o: " + o + " au: " + au + " ");
		}
	}

}
