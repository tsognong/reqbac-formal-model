package req_bac_sequential;

import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.Pair;

public class add_hierarchy {
	/* @ spec_public */ private reqbacm3 machine; // reference to the machine

	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 * this.machine == m;
	 */
	public add_hierarchy(reqbacm3 m) {
		this.machine = m;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * <==> (machine.get_admin_units().has(au) && machine.get_units().has(u) &&
	 * !u.equals(au) && !u.equals(machine.root_unit) &&
	 * !machine.get_units_hierarchies().has(new Pair<Integer,Integer>(au,u)) &&
	 * !machine.cls.apply((machine.get_units_hierarchies().union(new
	 * BRelation<Integer,Integer>(new
	 * Pair<Integer,Integer>(u,au))))).isSubset((machine.get_units_hierarchies().
	 * union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u,au))))) &&
	 * !( (\exists Integer u1;machine.get_units_hierarchies().has(new
	 * Pair<Integer,Integer>(u1,u)))) && !( (\exists Integer
	 * u1;machine.get_units_hierarchies().has(new Pair<Integer,Integer>(u,u1)))) &&
	 * !( (\exists Integer e;machine.get_employs().has(new
	 * Pair<Integer,Integer>(e,u)) || machine.get_appoints().has(new
	 * Pair<Integer,Integer>(e,u)) && machine.get_appoints().has(new
	 * Pair<Integer,Integer>(e,au)))));
	 */
	public /* @ pure */ boolean guard_add_hierarchy(Integer au, Integer u) {
		System.out.println("APPLY U " + u + " apply: " + machine.get_units_hierarchies().apply(u) + " ");
		return (machine.get_admin_units().has(au) && machine.get_units().has(u) && !u.equals(au)
				&& !u.equals(reqbacm3.root_unit)
				&& !machine.get_units_hierarchies().has(new Pair<Integer, Integer>(au, u))
				&& !machine.get_units_hierarchies().has(new Pair<Integer, Integer>(u, au))
				&& (((machine.get_units_hierarchies()
						.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(u, au))))
						.compose((machine.get_units_hierarchies()
								.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(u, au))))))
						.intersection((machine.get_units_hierarchies()
								.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(u, au))))))
						.equals(BSet.EMPTY)
				&& (((machine.get_units_hierarchies()
						.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(u, au))))
						.compose((machine.get_units_hierarchies()
								.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(u, au))))))
						.inverse()
						.intersection((machine.get_units_hierarchies()
								.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(u, au))))))
						.equals(BSet.EMPTY)

				&& machine.get_units_hierarchies().apply(u) == null
				&& !machine.transitive_closure(machine.get_units_hierarchies()).has(new Pair<Integer, Integer>(u, au))
				&& !machine.transitive_closure(machine.get_units_hierarchies()).inverse()
						.has(new Pair<Integer, Integer>(u, au))

		);
	}

	public BRelation<Integer, Integer> transitive_closure(BRelation<Integer, Integer> elms) {
		BRelation<Integer, Integer> closure = elms;
		while (true) {
			BRelation<Integer, Integer> new_relations = closure.compose(closure);
			BRelation<Integer, Integer> closure_until_now = closure.union(new_relations);
			System.out.println("Closure until now: " + closure_until_now);
			if (closure_until_now.equals(closure)) {
				System.out.println("Closure until now: " + closure_until_now);
				break;
			}
			closure = closure_until_now;
		}
		return closure;
	}

	/*
	 * @ public normal_behavior requires guard_add_hierarchy(au,u); assignable
	 * machine.units_hierarchies; ensures guard_add_hierarchy(au,u) &&
	 * machine.get_units_hierarchies().equals(\old((machine.get_units_hierarchies().
	 * union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(u,au))))));
	 * also requires !guard_add_hierarchy(au,u); assignable \nothing; ensures true;
	 */
	public void run_add_hierarchy(Integer au, Integer u) {
		if (guard_add_hierarchy(au, u)) {
			BRelation<Integer, Integer> units_hierarchies_tmp = machine.get_units_hierarchies();

			machine.set_units_hierarchies(
					(units_hierarchies_tmp.union(new BRelation<Integer, Integer>(new Pair<Integer, Integer>(u, au)))));

			System.out.println("add_hierarchy executed au: " + au + " u: " + u + " ");
		}
	}

}
