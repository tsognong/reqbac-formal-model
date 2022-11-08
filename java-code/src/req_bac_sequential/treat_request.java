package req_bac_sequential;

import eventb_prelude.*;
import Util.Utilities;

public class treat_request {
	/* @ spec_public */ private reqbacm3 machine; // reference to the machine

	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 * this.machine == m;
	 */
	public treat_request(reqbacm3 m) {
		this.machine = m;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * <==> (machine.get_employees().has(e) && c.isSubset(machine.get_contexts()) &&
	 * NAT1.instance.has(t) && machine.get_emitted_requests().has(req) &&
	 * machine.DECISION.has(d));
	 */
	public /* @ pure */ boolean guard_treat_request(BSet<Integer> c, Integer d, Integer e, Integer t,
			Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req) {
		System.out.println("........Mode......: "+machine.get_initial_mode(req));
				
		Integer emitter = req.fst().fst().fst().snd();
		Integer action = req.fst().fst().snd();
		Integer resource = req.fst().snd();
		BSet<Integer> econtexts = req.snd();
		Integer etime = req.fst().fst().fst().fst();
		
		System.out.println("EMPLOYEE FANTOME IIC.....: "+emitter);

		Integer u = machine.get_employs().apply(emitter);
		Integer au = machine.get_appoints().apply(e);
		Integer a = machine.get_consider().apply(action);
		Integer v = machine.get_uses().apply(resource);
		System.out.println("TIME.....: "+t + "IS CONTEXT DEFINED.....: "+(c.equals(BSet.EMPTY) || machine.get_defines()
						.has(new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
								new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(e, resource),
										action),
								c))));
		System.out.println("HIERARCHY......: "+machine.transitive_closure(machine.get_units_hierarchies()).has(u, au));
		System.out.println("TIME.....:"+ t  + "...ADMIN PERM..........: "+machine.get_administrative_permissions().has(
				new Pair<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
						new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>(
								new Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>(
										new Pair<Pair<Integer, Integer>, Integer>(
												new Pair<Integer, Integer>(au, u), a),
										v),
								c),
						1)));
		
	System.out.println("CONDITION.............: "+(machine.get_emitted_requests().has(req) && machine.get_initial_mode(req).equals(machine.MODE.last()) && machine.DECISION.has(d) && etime < t));

		return (machine.get_employees().has(e) && c.isSubset(machine.get_contexts()) && NAT1.instance.has(t)
				&& machine.get_emitted_requests().has(req) && machine.get_initial_mode(req).equals(machine.MODE.last()) && machine.DECISION.has(d) && etime < t
				&& (c.equals(BSet.EMPTY) || machine.get_defines()
						.has(new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
								new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(e, resource),
										action),
								c)))

				&&   au!= null &&
				machine.transitive_closure(machine.get_units_hierarchies()).has(u, au)

				&& (machine.get_administrative_permissions().has(
						new Pair<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
								new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>(
										new Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>(
												new Pair<Pair<Integer, Integer>, Integer>(
														new Pair<Integer, Integer>(au, u), a),
												v),
										c),
								1)

				) || machine.get_administrative_permissions().has(
						new Pair<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
								new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>(
										new Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>(
												new Pair<Pair<Integer, Integer>, Integer>(
														new Pair<Integer, Integer>(au, u), a),
												v),
										c),
								2)

				))

		);
	}

	public /* @ pure */ boolean guard_treat_request_lite(BSet<Integer> c, Integer d, Integer e, Integer t,
			Integer reqId) { 
		
		Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req = machine.get_emission_request(reqId);
		System.out.println("INITIAL REQUEST.....: "+req);
		System.out.println("EMPLOYEE FANTOME.....: "+e);
		return guard_treat_request(c, d, e, t,req);
				
	}

	/*
	 * @ public normal_behavior requires guard_treat_request(c,d,e,t,req);
	 * assignable machine.can_treat, machine.treated_requests,
	 * machine.final_decisions; ensures guard_treat_request(c,d,e,t,req) &&
	 * machine.get_can_treat() == \old(true) &&
	 * machine.get_treated_requests().equals(\old((machine.get_treated_requests().
	 * union(new
	 * BRelation<Pair<Pair<Pair<Integer,Integer>,Pair<Pair<Pair<Pair<Integer,Integer
	 * >,Integer>,Integer>,BSet<Integer>>>,BSet<Integer>>,Integer>(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Pair<Pair<Pair<Pair<Integer,Integer>,
	 * Integer>,Integer>,BSet<Integer>>>,BSet<Integer>>,Integer>(new
	 * Pair<Pair<Pair<Integer,Integer>,Pair<Pair<Pair<Pair<Integer,Integer>,Integer>
	 * ,Integer>,BSet<Integer>>>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,
	 * Integer>,BSet<Integer>>>(new Pair<Integer,Integer>(t,e),req),c),d)))))) &&
	 * machine.get_final_decisions().equals(\old((machine.get_final_decisions().
	 * union(new
	 * BRelation<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer
	 * >>,Integer>(new
	 * Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,
	 * Integer>(req,machine.get_decision())))))); also requires
	 * !guard_treat_request(c,d,e,t,req); assignable \nothing; ensures true;
	 */
	public void run_treat_request(BSet<Integer> c, Integer d, Integer e, Integer t,
			Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req) {
		Integer emitter = req.fst().fst().fst().snd();
		Integer action = req.fst().fst().snd();
		Integer resource = req.fst().snd();
		BSet<Integer> econtexts = req.snd();
		Integer etime = req.fst().fst().fst().fst();

		Integer u = machine.get_employs().apply(emitter);
		Integer au = machine.get_appoints().apply(e);
		Integer a = machine.get_consider().apply(action);
		Integer v = machine.get_uses().apply(resource);
		
		if (guard_treat_request(c, d, e, t, req)) {
			BRelation<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> treated_requests_tmp = machine
					.get_treated_requests();
			BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> final_decisions_tmp = machine
					.get_final_decisions();

			machine.set_can_treat(true);
			machine.set_treated_requests((treated_requests_tmp.union(
					new BRelation<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer>(
							
							new Pair<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer>(
									new Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>(
											new Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>(
													new Pair<Integer, Integer>(t, e), req),
											c),
									d)
							))));
			boolean isPermitted = machine.get_administrative_permissions().has(
					new Pair<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
							new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>(
									new Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>(
											new Pair<Pair<Integer, Integer>, Integer>(
													new Pair<Integer, Integer>(u, au), a),
											v),
									c),
							1));
			if (isPermitted) {
				machine.set_mode(1);
			} else {
				machine.set_mode(2);
			}
			
			if (machine.get_mode() == 1) {
				//machine.set_final_decisions((final_decisions_tmp.override(
				//		new BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
				//				new Pair<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
				//						req, d)))));
			} 
				
			System.out.println(
					"treat_request executed c: " + c + " d: " + d + " e: " + e + " t: " + t + " req: " + req + " ");
		}
	}
		
	public void run_treat_request_lite(BSet<Integer> c, Integer d, Integer e, Integer t,Integer reqId) {
		Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req = machine.get_emission_request(reqId);
		System.out.println("Request....: "+req);
		run_treat_request(c, d, e, t, req);
	}

}
