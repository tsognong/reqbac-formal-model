package req_bac_sequential;

import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.Pair;

public class add_operational_permissions {
	/* @ spec_public */ private reqbacm3 machine; // reference to the machine

	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 * this.machine == m;
	 */
	public add_operational_permissions(reqbacm3 m) {
		this.machine = m;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * <==> (machine.get_units().has(u) && machine.get_views().has(v) &&
	 * machine.get_activities().has(a) && c.isSubset(machine.get_contexts()) &&
	 * machine.MODE.has(m) && !machine.get_operational_permissions().has(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(u,a),v),c),m))
	 * && (\forall Integer u1; (\forall Integer au1; (\forall Integer v1; (\forall
	 * Integer a1; (\forall BSet<Integer> c1; (\forall Integer
	 * m1;((machine.get_administrative_permissions().has(new
	 * Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,
	 * Integer>(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(au1,u1),a1),v1),c1),m1))) ==>
	 * (machine.get_units_hierarchies().has(new Pair<Integer,Integer>(u1,au1)) &&
	 * (\exists BSet<Integer> c2; (\exists Integer
	 * m2;(machine.get_operational_permissions().union(new
	 * BRelation<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(
	 * new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(u,a),v),c),m)))).has(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(u1,a1),v1),c2),m2)))))))))))));
	 */
	public /* @ pure */ boolean guard_add_operational_permissions(Integer a, BSet<Integer> c, Integer m, Integer u,
			Integer v) {
		return (machine.get_units().has(u) && machine.get_views().has(v) && machine.get_activities().has(a)
				&& c.isSubset(machine.get_contexts()) && machine.MODE.has(m)
				&& !machine.get_operational_permissions()
						.has(new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer>(
								new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
										new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(u, a), v),
										c),
								m))
				&& true);
	}

	/*
	 * @ public normal_behavior requires
	 * guard_add_operational_permissions(a,c,m,u,v); assignable
	 * machine.operational_permissions; ensures
	 * guard_add_operational_permissions(a,c,m,u,v) &&
	 * machine.get_operational_permissions().equals(\old((machine.
	 * get_operational_permissions().union(new
	 * BRelation<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(
	 * new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(u,a),v),c),m)))))); also requires
	 * !guard_add_operational_permissions(a,c,m,u,v); assignable \nothing; ensures
	 * true;
	 */
	public void run_add_operational_permissions(Integer a, BSet<Integer> c, Integer m, Integer u, Integer v) {
		if (guard_add_operational_permissions(a, c, m, u, v)) {
			BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer> operational_permissions_tmp = machine
					.get_operational_permissions();

			machine.set_operational_permissions((operational_permissions_tmp
					.union(new BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer>(
							new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer>(
									new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
											new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(u, a),
													v),
											c),
									m)))));

			System.out.println("add_operational_permissions executed a: " + a + " c: " + c + " m: " + m + " u: " + u
					+ " v: " + v + " ");
		}
	}

}
