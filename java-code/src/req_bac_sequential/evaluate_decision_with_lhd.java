package req_bac_sequential;

import eventb_prelude.*;
import Util.Utilities;

public class evaluate_decision_with_lhd {
	/* @ spec_public */ private reqbacm3 machine; // reference to the machine

	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 * this.machine == m;
	 */
	public evaluate_decision_with_lhd(reqbacm3 m) {
		this.machine = m;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * <==> (machine.get_emitted_requests().has(req) &&
	 * machine.get_algo().equals(machine.lhd));
	 */
	public /* @ pure */ boolean guard_evaluate_decision_with_lhd(
			Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req) {
		return (machine.get_emitted_requests().has(req) && (machine.get_algo().equals(machine.lhd) || true));
	}

	/*
	 * @ public normal_behavior requires guard_evaluate_decision_with_lhd(req);
	 * assignable machine.final_decisions; ensures
	 * guard_evaluate_decision_with_lhd(req) &&
	 * machine.get_final_decisions().equals(\old((machine.get_final_decisions().
	 * union(new
	 * BRelation<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer
	 * >>,Integer>(new
	 * Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,
	 * Integer>(req,machine.get_decision())))))); also requires
	 * !guard_evaluate_decision_with_lhd(req); assignable \nothing; ensures true;
	 */
	public void run_evaluate_decision_with_lhd(
			Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req) {
		if (guard_evaluate_decision_with_lhd(req)) {
			BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> final_decisions_tmp = machine
					.get_final_decisions();
			Integer decision = machine.get_last_treatment_decision(req).snd();
			machine.set_final_decisions((final_decisions_tmp.override(
					new BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
							new Pair<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>(
									req, decision)))));

			System.out.println("evaluate_decision_with_lhd executed req: " + req + " Decision: " + decision);
		}
	}

	public void run_evaluate_decision_with_lhd_lite(Integer reqId) {

		Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req = machine
				.get_emission_request(reqId);

		run_evaluate_decision_with_lhd(req);
	}

}
