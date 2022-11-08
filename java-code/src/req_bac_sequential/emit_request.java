package req_bac_sequential;

import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.NAT1;
import eventb_prelude.Pair;

public class emit_request {
	/* @ spec_public */ private reqbacm3 machine; // reference to the machine

	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 * this.machine == m;
	 */
	public emit_request(reqbacm3 m) {
		this.machine = m;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * <==> (machine.get_employees().has(e) && machine.get_actions().has(a) &&
	 * machine.get_resources().has(r) && c.isSubset(machine.get_contexts()) &&
	 * NAT1.instance.has(t) && c.equals(BSet.EMPTY) || machine.get_defines().has(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(e,r),a),c)) &&
	 * machine.get_employs().domain().has(e) && machine.get_uses().domain().has(r)
	 * && machine.get_consider().domain().has(a) && (\exists Integer
	 * m;machine.get_operational_permissions().has(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(machine.get_employs().apply(e),machine.get_consider().
	 * apply(a)),machine.get_uses().apply(r)),c),m))));
	 */
	public /* @ pure */ boolean guard_emit_request(Integer a, BSet<Integer> c, Integer e, Integer r, Integer t) {
		System.out.println("VALUES....: " + machine.get_employs().apply(e) + ": " + machine.get_consider().apply(a)
				+ ": " + machine.get_uses().apply(r) + ": " + c);

		return (machine.get_employees().has(e) && machine.get_actions().has(a) && machine.get_resources().has(r)
				&& (c.isSubset(machine.get_contexts()) && NAT1.instance.has(t) && c.equals(BSet.EMPTY) || machine
						.get_defines()
						.has(new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
								new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(e, r), a), c)))
				&& machine.get_employs().domain().has(e) && machine.get_uses().domain().has(r)
				&& machine.get_consider().domain().has(a)
				&& (machine
						.get_operational_permissions().has(
								new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer>(
										new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
												new Pair<Pair<Integer, Integer>, Integer>(
														new Pair<Integer, Integer>(machine.get_employs().apply(e),
																machine.get_consider().apply(a)),
														machine.get_uses().apply(r)),
												c),
										1))
						|| machine.get_operational_permissions()
								.has(new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer>(
										new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
												new Pair<Pair<Integer, Integer>, Integer>(
														new Pair<Integer, Integer>(machine.get_employs().apply(e),
																machine.get_consider().apply(a)),
														machine.get_uses().apply(r)),
												c),
										2))

				)

		);
	}

	/*
	 * @ public normal_behavior requires guard_emit_request(a,c,e,r,t); assignable
	 * machine.can_emit, machine.mode, machine.emitted_requests, machine.decision,
	 * machine.final_decisions; ensures guard_emit_request(a,c,e,r,t) &&
	 * machine.get_can_emit() == \old(true) && (\exists Integer mode_localVar; new
	 * Best<Integer>(new JMLObjectSet {Integer m | (\exists Integer e;
	 * (machine.MODE.has(m) && machine.get_operational_permissions().has(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,ERROR>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(machine.get_employs().apply(e),machine.get_consider().
	 * apply(a)),machine.get_uses().apply(r)),c),m)));
	 * e.equals(m))}).has(mode_localVar); machine.get_mode().equals(mode_localVar))
	 * &&
	 * machine.get_emitted_requests().equals(\old((machine.get_emitted_requests().
	 * union(new
	 * BRelation<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(
	 * new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(t,e),a),r),c)))))) && (\exists Integer
	 * decision_localVar; (new Best<Integer>(new JMLObjectSet {Integer m | (\exists
	 * Integer e; (m.equals(machine.get_mode()) && m.equals(machine.realtime));
	 * e.equals(machine.validated))}).union(new Best<Integer>(new JMLObjectSet
	 * {Integer m | (\exists Integer e; (m.equals(machine.get_mode()) &&
	 * m.equals(machine.deferredtime));
	 * e.equals(machine.undecided))}))).has(decision_localVar);
	 * machine.get_decision().equals(decision_localVar)) &&
	 * machine.get_final_decisions().equals(\old((machine.get_final_decisions().
	 * union(new
	 * BRelation<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer
	 * >>,Integer>(new
	 * Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,
	 * Integer>(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(t,e),a),r),c),machine.get_decision())))))); also
	 * requires !guard_emit_request(a,c,e,r,t); assignable \nothing; ensures true;
	 */
	public void run_emit_request(Integer a, BSet<Integer> c, Integer e, Integer r, Integer t) {
		if (guard_emit_request(a, c, e, r, t)) {
			boolean isPermitted = machine
					.get_operational_permissions().has(
							new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer>(
									new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
											new Pair<Pair<Integer, Integer>, Integer>(
													new Pair<Integer, Integer>(machine.get_employs().apply(e),
															machine.get_consider().apply(a)),
													machine.get_uses().apply(r)),
											c),
									1));
			if (isPermitted) {
				machine.set_mode(1);
			} else {
				machine.set_mode(2);
			}

			BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> emitted_requests_tmp = machine
					.get_emitted_requests();
			Integer decision;
			if (machine.get_mode() == 1) {
				decision = 2;
			} else {
				decision = 1;
			}
			BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> final_decisions_tmp = machine
					.get_final_decisions();

			machine.set_can_emit(true);
			machine.set_emitted_requests((emitted_requests_tmp
					.union(new BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>(
							new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>(
									new Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>(
											new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(t, e),
													a),
											r),
									c)))));

			machine.set_final_decisions(machine.get_final_decisions().union(
					new BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
							new Pair<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
									new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>(
											new Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>(
													new Pair<Pair<Integer, Integer>, Integer>(
															new Pair<Integer, Integer>(t, e), a),
													r),
											c),
									decision))));

			System.out
					.println("emit_request executed a: " + a + " c: " + c + " e: " + e + " r: " + r + " t: " + t + " ");
		}
	}

}
