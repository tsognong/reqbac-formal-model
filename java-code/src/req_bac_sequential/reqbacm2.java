package req_bac_sequential;

import Util.Utilities;
import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.Enumerated;
import eventb_prelude.Pair;

public class reqbacm2 {
	private static final Integer max_integer = Utilities.max_integer;
	private static final Integer min_integer = Utilities.min_integer;

	//add_consider_relation evt_add_consider_relation = new add_consider_relation(this);
	//add_defines_relation evt_add_defines_relation = new add_defines_relation(this);
	//add_uses_relation evt_add_uses_relation = new add_uses_relation(this);
	//add_admin_permission evt_add_admin_permission = new add_admin_permission(this);
	//add_operational_permissions evt_add_operational_permissions = new add_operational_permissions(this);

	/****** Set definitions ******/
	// @ public static constraint UNIT.equals(\old(UNIT));
	public static final BSet<Integer> UNIT = new Enumerated(min_integer, max_integer);

	// @ public static constraint EMPLOYEE.equals(\old(EMPLOYEE));
	public static final BSet<Integer> EMPLOYEE = new Enumerated(min_integer, max_integer);

	// @ public static constraint ORGANIZATION.equals(\old(ORGANIZATION));
	public static final BSet<Integer> ORGANIZATION = new Enumerated(min_integer, max_integer);

	// @ public static constraint ACTION.equals(\old(ACTION));
	public static final BSet<Integer> ACTION = new Enumerated(min_integer, max_integer);

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

	/****** Variable definitions ******/
	/* @ spec_public */ private BRelation<Integer, Integer> units_hierarchies;

	/* @ spec_public */ private BSet<Integer> units;

	/* @ spec_public */ private BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> administrative_permissions;

	/* @ spec_public */ private BSet<Integer> activities;

	/* @ spec_public */ private BSet<Integer> admin_units;

	/* @ spec_public */ private BRelation<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>> defines;

	/* @ spec_public */ private BSet<Integer> actions;

	/* @ spec_public */ private BSet<Integer> employees;

	/* @ spec_public */ private BRelation<Integer, Integer> employs;

	/* @ spec_public */ private BRelation<Integer, Integer> consider;

	/* @ spec_public */ private BSet<Integer> organizations;

	/* @ spec_public */ private BRelation<Integer, Integer> uses;

	/* @ spec_public */ private BRelation<Pair<Pair<Pair<Integer, Integer>, Integer>, BSet<Integer>>, Integer> operational_permissions;

	/* @ spec_public */ private BSet<Integer> views;

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
	 * Pair<Integer,Integer>(u,a),v),c1),m1))))))))))));
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
	 * @ public normal_behavior requires true; assignable this.employs; ensures
	 * this.employs == employs;
	 */
	public void set_employs(BRelation<Integer, Integer> employs) {
		this.employs = employs;
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
	 * @ public normal_behavior requires true; assignable \nothing; ensures \result
	 * == this.administrative_permissions;
	 */
	public /* @ pure */ BRelation<Pair<Pair<Pair<Pair<Integer, Integer>, Integer>, Integer>, BSet<Integer>>, Integer> get_administrative_permissions() {
		return this.administrative_permissions;
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

	//add_hierarchy evt_add_hierarchy = new add_hierarchy(this);
	//add_appointment evt_add_appointment = new add_appointment(this);
	//add_employment evt_add_employment = new add_employment(this);

	public BRelation<Integer, Integer> transitive_closure(BRelation<Integer, Integer> elms) {
		BRelation<Integer, Integer> closure = elms;
		while (true) {
			BRelation<Integer, Integer> new_relations = closure.compose(closure);
			BRelation<Integer, Integer> closure_until_now = closure.union(new_relations);

			if (closure_until_now.equals(closure)) {
				System.out.println("Closure until now: " + closure_until_now);
				break;
			}
			closure = closure_until_now;
		}
		return closure;
	}
	
	public boolean appointement_has_violations(BSet<Integer> units, Integer au) {
		boolean resp = false;
		for(Integer u :  units) {
			if(this.transitive_closure(this.get_units_hierarchies()).has(u, au)) {
				resp = true;
				break;
			}
			if(this.transitive_closure(this.get_units_hierarchies()).inverse().has(u, au)) {
				resp = true;
				break;
			}
		}
		return resp;
	}


	/*
	 * @ public normal_behavior requires true; assignable \everything; ensures
	 * organizations.isEmpty() && units.isEmpty() && admin_units.isEmpty() &&
	 * operational_units.isEmpty() && units_hierarchies.isEmpty() &&
	 * employees.isEmpty() && employs.isEmpty() && appoints.isEmpty() &&
	 * resources.isEmpty() && views.isEmpty() && uses.isEmpty() && actions.isEmpty()
	 * && activities.isEmpty() && consider.isEmpty() && contexts.isEmpty() &&
	 * defines.isEmpty() && operational_permissions.isEmpty() &&
	 * administrative_permissions.isEmpty();
	 */
	public reqbacm2() {
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

	}
	
	
}