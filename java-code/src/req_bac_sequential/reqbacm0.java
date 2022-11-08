package req_bac_sequential;

import eventb_prelude.*;
import Util.*;
//@ model import org.jmlspecs.models.JMLObjectSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class reqbacm0 {
	private static final Integer max_integer = Utilities.max_integer;
	private static final Integer min_integer = Utilities.min_integer;

	//add_hierarchy evt_add_hierarchy = new add_hierarchy(this);
	//add_appointment evt_add_appointment = new add_appointment(this);
	//add_employment evt_add_employment = new add_employment(this);

	/****** Set definitions ******/
	// @ public static constraint UNIT.equals(\old(UNIT));
	public static final BSet<Integer> UNIT = new Enumerated(min_integer, max_integer);

	// @ public static constraint EMPLOYEE.equals(\old(EMPLOYEE));
	public static final BSet<Integer> EMPLOYEE = new Enumerated(min_integer, max_integer);

	// @ public static constraint ORGANIZATION.equals(\old(ORGANIZATION));
	public static final BSet<Integer> ORGANIZATION = new Enumerated(min_integer, max_integer);

	/****** Constant definitions ******/
	// @ public static constraint root_unit.equals(\old(root_unit));
	public static final Integer root_unit = 1;

	// @ public static constraint OPERATIONAL_UNIT.equals(\old(OPERATIONAL_UNIT));
	public static final BSet<Integer> OPERATIONAL_UNIT = new Enumerated(min_integer, max_integer);

	// @ public static constraint
	// ADMINISTRATIVE_UNIT.equals(\old(ADMINISTRATIVE_UNIT));
	public static final BSet<Integer> ADMINISTRATIVE_UNIT = new Enumerated(min_integer, max_integer);

	/****** Axiom definitions ******/
	/* @ public static invariant ORGANIZATION.finite(); */
	/* @ public static invariant UNIT.finite(); */
	/* @ public static invariant EMPLOYEE.finite(); */
	/*
	 * @ public static invariant
	 * BSet.partition(UNIT,ADMINISTRATIVE_UNIT,OPERATIONAL_UNIT);
	 */
	/* @ public static invariant ADMINISTRATIVE_UNIT.has(root_unit); */

	/****** Variable definitions ******/
	/* @ spec_public */ private BRelation<Integer, Integer> units_hierarchies;

	/* @ spec_public */ private BSet<Integer> units;

	/* @ spec_public */ private BSet<Integer> admin_units;

	/* @ spec_public */ private BSet<Integer> employees;

	/* @ spec_public */ private BRelation<Integer, Integer> employs;

	/* @ spec_public */ private BSet<Integer> organizations;

	/* @ spec_public */ private BRelation<Integer, Integer> appoints;

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
	 * intersection((new ID()))).equals(BSet.EMPTY);
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
	 * Pair<Integer,Integer>(u1,u2))) ==> (!e1.equals(e2)))))));
	 */

	/****** Getter and Mutator methods definition ******/
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
	 * employees.isEmpty() && employs.isEmpty() && appoints.isEmpty();
	 */
	public reqbacm0() {
		organizations = new BSet<Integer>();
		units = new BSet<Integer>();
		admin_units = new BSet<Integer>();
		operational_units = new BSet<Integer>();
		units_hierarchies = new BRelation<Integer, Integer>();
		employees = new BSet<Integer>();
		employs = new BRelation<Integer, Integer>();
		appoints = new BRelation<Integer, Integer>();

	}
}