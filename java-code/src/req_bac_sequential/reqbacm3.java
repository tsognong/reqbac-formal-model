package req_bac_sequential;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Util.Utilities;
import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.Enumerated;
import eventb_prelude.Pair;

public class reqbacm3 {
	private static final Integer max_integer = Utilities.max_integer;
	private static final Integer min_integer = Utilities.min_integer;

	// add_consider_relation evt_add_consider_relation = new
	// add_consider_relation(this);
	// add_defines_relation evt_add_defines_relation = new
	// add_defines_relation(this);
	emit_request evt_emit_request = new emit_request(this);

	treat_request evt_treat_request = new treat_request(this);
	// add_uses_relation evt_add_uses_relation = new add_uses_relation(this);
	// add_admin_permission evt_add_admin_permission = new
	// add_admin_permission(this);
	// add_operational_permissions evt_add_operational_permissions = new
	// add_operational_permissions(this);

	/****** Set definitions ******/
	// @ public static constraint UNIT.equals(\old(UNIT));
	public static final BSet<Integer> UNIT = new Enumerated(min_integer, max_integer);

	// @ public static constraint EMPLOYEE.equals(\old(EMPLOYEE));
	public static final BSet<Integer> EMPLOYEE = new Enumerated(min_integer, max_integer);

	// @ public static constraint ORGANIZATION.equals(\old(ORGANIZATION));
	public static final BSet<Integer> ORGANIZATION = new Enumerated(min_integer, max_integer);

	// @ public static constraint ACTION.equals(\old(ACTION));
	public static final BSet<Integer> ACTION = new Enumerated(min_integer, max_integer);

	// @ public static constraint
	// COMBINING_ALGORITHM.equals(\old(COMBINING_ALGORITHM));
	public static final BSet<Integer> COMBINING_ALGORITHM = new Enumerated(min_integer, max_integer);

	// @ public static constraint DECISION.equals(\old(DECISION));
	public static final BSet<Integer> DECISION = new Enumerated(min_integer, max_integer);

	// @ public static constraint lhd.equals(\old(lhd));
	public static final Integer lhd = 1;

	// @ public static constraint undecided.equals(\old(undecided));
	public static final Integer undecided = 1;

	// @ public static constraint mhd.equals(\old(mhd));
	public static final Integer mhd = 2;

	// @ public static constraint rejected.equals(\old(rejected));
	public static final Integer rejected = 3;

	// @ public static constraint validated.equals(\old(validated));
	public static final Integer validated = 2;

	add_consider_relation evt_add_consider_relation = new add_consider_relation(this);
	add_defines_relation evt_add_defines_relation = new add_defines_relation(this);
	add_uses_relation evt_add_uses_relation = new add_uses_relation(this);
	add_admin_permission evt_add_admin_permission = new add_admin_permission(this);
	add_operational_permissions evt_add_operational_permissions = new add_operational_permissions(this);

	evaluate_decision_with_lhd evt_evaluate_decision_with_lhd = new evaluate_decision_with_lhd(this);
	evaluate_decision_with_mhd evt_evaluate_decision_with_mhd = new evaluate_decision_with_mhd(this);
	// @ public static constraint ACTIVITY.equals(\old(ACTIVITY));
	public static final BSet<Integer> ACTIVITY = new Enumerated(min_integer, max_integer);

	// @ public static constraint MODE.equals(\old(MODE));
	public static final BSet<Integer> MODE = new BSet<Integer>(1, 2);

	// @ public static constraint CONTEXT.equals(\old(CONTEXT));
	public static final BSet<Integer> CONTEXT = new Enumerated(min_integer, max_integer);

	// @ public static constraint VIEW.equals(\old(VIEW));
	public static final BSet<Integer> VIEW = new Enumerated(min_integer, max_integer);

	// @ public static constraint RESOURCE.equals(\old(RESOURCE));
	public static final BSet<Integer> RESOURCE = new Enumerated(min_integer, max_integer);

	/****** Constant definitions ******/
	// @ public static constraint root_unit.equals(\old(root_unit));
	public static final Integer root_unit = 1;

	// @ public static constraint OPERATIONAL_UNIT.equals(\old(OPERATIONAL_UNIT));
	public static final BSet<Integer> OPERATIONAL_UNIT = new Enumerated(min_integer, max_integer);

	// @ public static constraint
	// ADMINISTRATIVE_UNIT.equals(\old(ADMINISTRATIVE_UNIT));
	public static final BSet<Integer> ADMINISTRATIVE_UNIT = new Enumerated(min_integer, max_integer);

	// @ public static constraint realtime.equals(\old(realtime));
	public static final Integer realtime = 1;

	// @ public static constraint deferredtime.equals(\old(deferredtime));
	public static final Integer deferredtime = 2;

	/****** Axiom definitions ******/
	/* @ public static invariant ORGANIZATION.finite(); */
	/* @ public static invariant UNIT.finite(); */
	/* @ public static invariant EMPLOYEE.finite(); */
	/*
	 * @ public static invariant
	 * BSet.partition(UNIT,ADMINISTRATIVE_UNIT,OPERATIONAL_UNIT);
	 */
	/* @ public static invariant ADMINISTRATIVE_UNIT.has(root_unit); */
	/* @ public static invariant RESOURCE.finite(); */
	/* @ public static invariant VIEW.finite(); */
	/* @ public static invariant ACTION.finite(); */
	/* @ public static invariant ACTIVITY.finite(); */
	/* @ public static invariant CONTEXT.finite(); */
	/*
	 * @ public static invariant BSet.partition(MODE,new BSet<Integer>(realtime),new
	 * BSet<Integer>(deferredtime));
	 */

	/****** Axiom definitions ******/
	/* @ public static invariant ORGANIZATION.finite(); */
	/* @ public static invariant UNIT.finite(); */
	/* @ public static invariant EMPLOYEE.finite(); */
	/*
	 * @ public static invariant
	 * BSet.partition(UNIT,ADMINISTRATIVE_UNIT,OPERATIONAL_UNIT);
	 */
	/* @ public static invariant ADMINISTRATIVE_UNIT.has(root_unit); */
	/* @ public static invariant RESOURCE.finite(); */
	/* @ public static invariant VIEW.finite(); */
	/* @ public static invariant ACTION.finite(); */
	/* @ public static invariant ACTIVITY.finite(); */
	/* @ public static invariant CONTEXT.finite(); */
	/*
	 * @ public static invariant BSet.partition(MODE,new BSet<Integer>(realtime),new
	 * BSet<Integer>(deferredtime));
	 */
	/*
	 * @ public static invariant BSet.partition(DECISION,new
	 * BSet<Integer>(validated),new BSet<Integer>(rejected),new
	 * BSet<Integer>(undecided));
	 */
	/*
	 * @ public static invariant BSet.partition(COMBINING_ALGORITHM,new
	 * BSet<Integer>(lhd),new BSet<Integer>(mhd));
	 */

	/****** Variable definitions ******/
	/* @ spec_public */ private BRelation<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> treated_requests;

	/* @ spec_public */ private Boolean can_treat;

	/* @ spec_public */ private BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> final_decisions;

	/* @ spec_public */ private BRelation<Integer, Integer> units_hierarchies;

	/* @ spec_public */ private Integer mode;

	/* @ spec_public */ private BSet<Integer> units;

	/* @ spec_public */ private BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> administrative_permissions;

	/* @ spec_public */ private BSet<Integer> activities;

	/* @ spec_public */ private BSet<Integer> admin_units;

	/* @ spec_public */ private BRelation<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>> defines;

	/* @ spec_public */ private BSet<Integer> actions;

	/* @ spec_public */ private Integer algo;

	/* @ spec_public */ private Boolean can_emit;

	/* @ spec_public */ private BSet<Integer> employees;

	/* @ spec_public */ private BRelation<Integer, Integer> employs;

	/* @ spec_public */ private BRelation<Integer, Integer> consider;

	/* @ spec_public */ private BSet<Integer> organizations;

	/* @ spec_public */ private BRelation<Integer, Integer> uses;

	/* @ spec_public */ private BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> emitted_requests;

	/* @ spec_public */ private BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer> operational_permissions;

	/* @ spec_public */ private BSet<Integer> views;

	/* @ spec_public */ private Integer decision;

	/* @ spec_public */ private BSet<Integer> contexts;

	/* @ spec_public */ private BRelation<Integer, Integer> appoints;

	/* @ spec_public */ private BSet<Integer> resources;

	/* @ spec_public */ private BSet<Integer> operational_units;

	/****** Invariant definition ******/
	/*
	 * @ public invariant organizations.isSubset(ORGANIZATION) &&
	 * units.isSubset(UNIT) && employees.isSubset(EMPLOYEE) &&
	 * admin_units.isSubset(ADMINISTRATIVE_UNIT) &&
	 * operational_units.isSubset(OPERATIONAL_UNIT) &&
	 * BSet.partition(units,admin_units,operational_units) &&
	 * units_hierarchies.domain().equals(units.difference(new
	 * BSet<Integer>(root_unit))) && units_hierarchies.range().equals(admin_units)
	 * && units_hierarchies.isaFunction() && BRelation.cross(units.difference(new
	 * BSet<Integer>(root_unit)),admin_units).has(units_hierarchies) &&
	 * (units_hierarchies.intersection((new ID()))).equals(BSet.EMPTY) &&
	 * (units_hierarchies.intersection(units_hierarchies.inverse())).equals(BSet.
	 * EMPTY) && ((cls.apply(units_hierarchies).isProperSubset(units_hierarchies))
	 * ==> (units_hierarchies.equals(BSet.EMPTY))) &&
	 * employs.domain().isSubset(employees) &&
	 * employs.range().isSubset(operational_units) &&
	 * BRelation.cross(employees,operational_units).has(employs) &&
	 * appoints.domain().isSubset(employees) &&
	 * appoints.range().isSubset(admin_units) &&
	 * BRelation.cross(employees,admin_units).has(appoints) &&
	 * ((employs.compose(units_hierarchies.compose(appoints.inverse()))).
	 * intersection((new ID()))).equals(BSet.EMPTY) &&
	 * ((appoints.compose(units_hierarchies.compose(appoints.inverse()))).
	 * intersection((new ID()))).equals(BSet.EMPTY) &&
	 * uses.domain().isSubset(resources) && uses.range().isSubset(views) &&
	 * BRelation.cross(resources,views).has(uses) && actions.isSubset(ACTION) &&
	 * activities.isSubset(ACTIVITY) && consider.domain().isSubset(actions) &&
	 * consider.range().isSubset(activities) &&
	 * BRelation.cross(actions,activities).has(consider) &&
	 * contexts.isSubset(CONTEXT) &&
	 * ((BRelation.cross(BRelation.cross(BRelation.cross(employees,resources),
	 * actions),((contexts).pow()))).pow()).has(defines) &&
	 * ((BRelation.cross(BRelation.cross(BRelation.cross(BRelation.cross(units,
	 * activities),views),((contexts).pow())),MODE)).pow()).has(
	 * operational_permissions) &&
	 * ((BRelation.cross(BRelation.cross(BRelation.cross(BRelation.cross(BRelation.
	 * cross(admin_units,units),activities),views),((contexts).pow())),MODE)).pow())
	 * .has(administrative_permissions) && (\forall Integer u; (\forall Integer au;
	 * (\forall Integer v; (\forall Integer a; (\forall BSet<Integer> c; (\forall
	 * Integer m;((administrative_permissions.has(new
	 * Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,
	 * Integer>(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(au,u),a),v),c),m))) ==> (units_hierarchies.has(new
	 * Pair<Integer,Integer>(u,au)) && (\exists BSet<Integer> c1; (\exists Integer
	 * m1;operational_permissions.has(new
	 * Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(new
	 * Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new
	 * Pair<Pair<Integer,Integer>,Integer>(new
	 * Pair<Integer,Integer>(u,a),v),c1),m1)))))))))))) &&
	 * BOOL.instance.has(can_emit) && BOOL.instance.has(can_treat) &&
	 * ((BRelation.cross(BRelation.cross(BRelation.cross(BRelation.cross(NAT1.
	 * instance,employees),actions),resources),((contexts).pow()))).pow()).has(
	 * emitted_requests) &&
	 * treated_requests.domain().isSubset(BRelation.cross(BRelation.cross(BRelation.
	 * cross(NAT1.instance,employees),emitted_requests),((contexts).pow()))) &&
	 * treated_requests.range().isSubset(DECISION) && treated_requests.isaFunction()
	 * &&
	 * BRelation.cross(BRelation.cross(BRelation.cross(BRelation.cross(NAT1.instance
	 * ,employees),emitted_requests),((contexts).pow())),DECISION).has(
	 * treated_requests) && DECISION.has(decision) &&
	 * final_decisions.domain().isSubset(emitted_requests) &&
	 * final_decisions.range().isSubset(DECISION) && final_decisions.isaFunction()
	 * && BRelation.cross(emitted_requests,DECISION).has(final_decisions) &&
	 * COMBINING_ALGORITHM.has(algo) && MODE.has(mode);
	 */
	/*
	 * @ public invariant_redundantly (\exists Integer u;((units_hierarchies.has(new
	 * Pair<Integer,Integer>(root_unit,u))) ==>
	 * (units_hierarchies.equals(BSet.EMPTY)))) &&
	 * ((units_hierarchies.compose(units_hierarchies)).intersection(
	 * units_hierarchies)).equals(BSet.EMPTY) && (\forall Integer e1; (\forall
	 * Integer e2; (\forall Integer u1; (\forall Integer u2;((appoints.has(new
	 * Pair<Integer,Integer>(e1,u1)) && appoints.has(new
	 * Pair<Integer,Integer>(e2,u2)) && units_hierarchies.has(new
	 * Pair<Integer,Integer>(u1,u2))) ==> (!e1.equals(e2))))))) &&
	 * resources.isSubset(RESOURCE) && views.isSubset(VIEW);
	 */

	/****** Getter and Mutator methods definition ******/
	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.can_treat;
	 */
	public /* @ pure */ Boolean get_can_treat() {
		return this.can_treat;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.can_treat; ensures
	 * this.can_treat == can_treat;
	 */
	public void set_can_treat(Boolean can_treat) {
		this.can_treat = can_treat;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.final_decisions;
	 */
	public /* @ pure */ BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> get_final_decisions() {
		return this.final_decisions;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.final_decisions;
	 * ensures this.final_decisions == final_decisions;
	 */
	public void set_final_decisions(
			BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> final_decisions) {
		this.final_decisions = final_decisions;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.units;
	 */
	public /* @ pure */ BSet<Integer> get_units() {
		return this.units;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.units; ensures
	 * this.units == units;
	 */
	public void set_units(BSet<Integer> units) {
		this.units = units;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.contexts;
	 */
	public /* @ pure */ BSet<Integer> get_contexts() {
		return this.contexts;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.contexts; ensures
	 * this.contexts == contexts;
	 */
	public void set_contexts(BSet<Integer> contexts) {
		this.contexts = contexts;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.operational_permissions;
	 */
	public /* @ pure */ BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer> get_operational_permissions() {
		return this.operational_permissions;
	}

	/*
	 * @ public normal_behavior requires true; assignable
	 * this.operational_permissions; ensures this.operational_permissions ==
	 * operational_permissions;
	 */
	public void set_operational_permissions(
			BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer> operational_permissions) {
		this.operational_permissions = operational_permissions;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.units_hierarchies;
	 */
	public /* @ pure */ BRelation<Integer, Integer> get_units_hierarchies() {
		return this.units_hierarchies;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.units_hierarchies;
	 * ensures this.units_hierarchies == units_hierarchies;
	 */
	public void set_units_hierarchies(BRelation<Integer, Integer> units_hierarchies) {
		this.units_hierarchies = units_hierarchies;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.defines;
	 */
	public /* @ pure */ BRelation<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>> get_defines() {
		return this.defines;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.defines; ensures
	 * this.defines == defines;
	 */
	public void set_defines(BRelation<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>> defines) {
		this.defines = defines;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.mode;
	 */
	public /* @ pure */ Integer get_mode() {
		return this.mode;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.mode; ensures
	 * this.mode == mode;
	 */
	public void set_mode(Integer mode) {
		this.mode = mode;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.can_emit;
	 */
	public /* @ pure */ Boolean get_can_emit() {
		return this.can_emit;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.can_emit; ensures
	 * this.can_emit == can_emit;
	 */
	public void set_can_emit(Boolean can_emit) {
		this.can_emit = can_emit;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.employs; ensures
	 * this.employs == employs;
	 */
	public void set_employs(BRelation<Integer, Integer> employs) {
		this.employs = employs;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.treated_requests;
	 */
	public /* @ pure */ BRelation<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> get_treated_requests() {
		return this.treated_requests;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.treated_requests;
	 * ensures this.treated_requests == treated_requests;
	 */
	public void set_treated_requests(
			BRelation<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> treated_requests) {
		this.treated_requests = treated_requests;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.administrative_permissions;
	 */
	public /* @ pure */ BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> get_administrative_permissions() {
		return this.administrative_permissions;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.decision;
	 */
	public /* @ pure */ Integer get_decision() {
		return this.decision;
	}
	
	public Integer get_decision(Integer reqId) {
		Integer finalDec = 1;		
		for (Pair<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> dec: get_final_decisions()) {
			if(dec.fst().equals(get_emission_request(reqId))) {
				finalDec =  dec.snd();	
				System.out.println("REQUEST HERE....: "+dec+" DEC: "+finalDec);
				break;
			}
		}	
		System.out.println("GET.....DECISION.....: "+finalDec);
		return finalDec;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.decision; ensures
	 * this.decision == decision;
	 */
	public void set_decision(Integer decision) {
		this.decision = decision;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.resources;
	 */
	public /* @ pure */ BSet<Integer> get_resources() {
		return this.resources;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.resources; ensures
	 * this.resources == resources;
	 */
	public void set_resources(BSet<Integer> resources) {
		this.resources = resources;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.appoints;
	 */
	public /* @ pure */ BRelation<Integer, Integer> get_appoints() {
		return this.appoints;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.appoints; ensures
	 * this.appoints == appoints;
	 */
	public void set_appoints(BRelation<Integer, Integer> appoints) {
		this.appoints = appoints;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.emitted_requests;
	 */
	public /* @ pure */ BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> get_emitted_requests() {
		return this.emitted_requests;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.emitted_requests;
	 * ensures this.emitted_requests == emitted_requests;
	 */
	public void set_emitted_requests(
			BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> emitted_requests) {
		this.emitted_requests = emitted_requests;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.algo;
	 */
	public /* @ pure */ Integer get_algo() {
		return this.algo;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.algo; ensures
	 * this.algo == algo;
	 */
	public void set_algo(Integer algo) {
		this.algo = algo;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.operational_units;
	 */
	public /* @ pure */ BSet<Integer> get_operational_units() {
		return this.operational_units;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.operational_units;
	 * ensures this.operational_units == operational_units;
	 */
	public void set_operational_units(BSet<Integer> operational_units) {
		this.operational_units = operational_units;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.activities;
	 */
	public /* @ pure */ BSet<Integer> get_activities() {
		return this.activities;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.activities; ensures
	 * this.activities == activities;
	 */
	public void set_activities(BSet<Integer> activities) {
		this.activities = activities;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.employs;
	 */
	public /* @ pure */ BRelation<Integer, Integer> get_employs() {
		return this.employs;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.organizations;
	 */
	public /* @ pure */ BSet<Integer> get_organizations() {
		return this.organizations;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.organizations;
	 * ensures this.organizations == organizations;
	 */
	public void set_organizations(BSet<Integer> organizations) {
		this.organizations = organizations;
	}

	/*
	 * @ public normal_behavior requires true; assignable
	 * this.administrative_permissions; ensures this.administrative_permissions ==
	 * administrative_permissions;
	 */
	public void set_administrative_permissions(
			BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> administrative_permissions) {
		this.administrative_permissions = administrative_permissions;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.uses;
	 */
	public /* @ pure */ BRelation<Integer, Integer> get_uses() {
		return this.uses;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.uses; ensures
	 * this.uses == uses;
	 */
	public void set_uses(BRelation<Integer, Integer> uses) {
		this.uses = uses;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.admin_units;
	 */
	public /* @ pure */ BSet<Integer> get_admin_units() {
		return this.admin_units;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.admin_units; ensures
	 * this.admin_units == admin_units;
	 */
	public void set_admin_units(BSet<Integer> admin_units) {
		this.admin_units = admin_units;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.consider;
	 */
	public /* @ pure */ BRelation<Integer, Integer> get_consider() {
		return this.consider;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.consider; ensures
	 * this.consider == consider;
	 */
	public void set_consider(BRelation<Integer, Integer> consider) {
		this.consider = consider;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.employees;
	 */
	public /* @ pure */ BSet<Integer> get_employees() {
		return this.employees;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.employees; ensures
	 * this.employees == employees;
	 */
	public void set_employees(BSet<Integer> employees) {
		this.employees = employees;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.actions;
	 */
	public /* @ pure */ BSet<Integer> get_actions() {
		return this.actions;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.actions; ensures
	 * this.actions == actions;
	 */
	public void set_actions(BSet<Integer> actions) {
		this.actions = actions;
	}

	/*
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.views;
	 */
	public /* @ pure */ BSet<Integer> get_views() {
		return this.views;
	}

	/*
	 * @ public normal_behavior requires true; assignable this.views; ensures
	 * this.views == views;
	 */
	public void set_views(BSet<Integer> views) {
		this.views = views;
	}

	add_hierarchy evt_add_hierarchy = new add_hierarchy(this);
	add_appointment evt_add_appointment = new add_appointment(this);
	add_employment evt_add_employment = new add_employment(this);
	private Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>> req;

	public BRelation<Integer, Integer> transitive_closure(BRelation<Integer, Integer> elms) {
		BRelation<Integer, Integer> closure = elms;
		while (true) {
			BRelation<Integer, Integer> new_relations = closure.compose(closure);
			BRelation<Integer, Integer> closure_until_now = closure.union(new_relations);

			if (closure_until_now.equals(closure)) {
				break;
			}
			closure = closure_until_now;
		}
		System.out.println("Closure:" + closure);
		return closure;
	}

	public boolean appointement_has_violations(BSet<Integer> units, Integer au) {
		boolean resp = false;
		for (Integer u : units) {
			if (this.transitive_closure(this.get_units_hierarchies()).has(u, au)) {
				resp = true;
				break;
			}
			if (this.transitive_closure(this.get_units_hierarchies()).inverse().has(u, au)) {
				resp = true;
				break;
			}
		}
		return resp;
	}

	public Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> get_emission_request(
			Integer timeId) {
		Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> emission_req = null;
		for (Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req : get_emitted_requests()) {
			Integer etime = req.fst().fst().fst().fst();
			if (timeId == etime) {
				emission_req = req;
				break;
			}
		}
		return emission_req;
	}

	public Pair<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> get_treatment_request(
			Integer timeId) {
		Pair<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> treament_req = null;
		for (Pair<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> req : get_treated_requests()) {
			Integer etime = req.fst().fst().fst().fst();
			if (timeId == etime) {
				treament_req = req;
				break;
			}
		}
		return treament_req;
	}

	public Integer get_initial_mode(Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> req) {
		Integer emitter = req.fst().fst().fst().snd();
		Integer action = req.fst().fst().snd();
		Integer resource = req.fst().snd();
		BSet<Integer> c = req.snd();

		Integer u = get_employs().apply(emitter);
		Integer a = get_consider().apply(action);
		Integer v = get_uses().apply(resource);

		boolean isPermitted = get_operational_permissions()
				.has(new Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer>(
						new Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>(
								new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(u, a), v), c),
						1));
		if (isPermitted) {
			return MODE.first();
		} else {
			return MODE.last();
		}
	}

	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 */
	public reqbacm3() {
		organizations = new BSet<Integer>();
		units = new BSet<Integer>();
		admin_units = new BSet<Integer>();
		operational_units = new BSet<Integer>();
		units_hierarchies = new BRelation<Integer, Integer>();
		employees = new BSet<Integer>();
		employs = new BRelation<Integer, Integer>();
		appoints = new BRelation<Integer, Integer>();
		resources = new BSet<Integer>();
		views = new BSet<Integer>();
		uses = new BRelation<Integer, Integer>();
		actions = new BSet<Integer>();
		activities = new BSet<Integer>();
		consider = new BRelation<Integer, Integer>();
		contexts = new BSet<Integer>();
		defines = new BRelation<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>();
		operational_permissions = new BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer>();
		administrative_permissions = new BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>();
		final_decisions = new BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer>();
		emitted_requests = new BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>();
        algo = 1;
		treated_requests = new BRelation<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer>();
	}

	public Pair<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> get_last_treatment_decision(
			Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> emreq) {
		Pair<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> treament_req = null;
		Integer lastId = -1;
		for (Pair<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> req : get_treated_requests()) {
			Integer etime = req.fst().fst().fst().fst();

			Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> initial_request = req.fst()
					.fst().snd();
			if (initial_request.equals(emreq)) {
				if (lastId < etime) {
					lastId = etime;
					treament_req = req;
				}
			}

		}
		return treament_req;
	}

	public Integer get_most_recurrent_treatment_decision(
			Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> emreq) {
		List<Integer> times = new ArrayList<Integer>();
		
		for (Pair<Pair<Pair<Pair<Integer, Integer>, Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>>, BSet<Integer>>, Integer> req : get_treated_requests()) {
			Integer etime = req.fst().fst().fst().fst();

			Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>> initial_request = req.fst()
					.fst().snd();
			if (initial_request.equals(emreq)) {
				Integer dec = req.snd();
				times.add(dec);
			}

		}
		
		Map<Integer, Long> counts = times.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		System.out.println("RESULT.........: " + counts);

		Integer res = counts.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
				.get().getKey();
		System.out.println("FINAL DEC....: " + res);
		return res;
	}
	

}