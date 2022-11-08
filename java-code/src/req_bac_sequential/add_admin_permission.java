package req_bac_sequential; 

import eventb_prelude.BRelation;
import eventb_prelude.BSet;
import eventb_prelude.Pair;

public class add_admin_permission{
	/*@ spec_public */ private reqbacm3 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public add_admin_permission(reqbacm3 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_admin_units().has(au) && machine.get_units().has(u) && machine.get_activities().has(a) && machine.get_views().has(v) && c.isSubset(machine.get_contexts()) && machine.MODE.has(m) && machine.get_units_hierarchies().has(new Pair<Integer,Integer>(u,au)) && !machine.get_administrative_permissions().has(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(au,u),a),v),c),m)) &&  (\exists BSet<Integer> c1; (\exists Integer m1;machine.get_operational_permissions().has(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(u,a),v),c1),m1)))) &&  (\forall Integer u1;  (\forall Integer au1;  (\forall Integer v1;  (\forall Integer a1;  (\forall BSet<Integer> c1;  (\forall Integer m1;(((machine.get_administrative_permissions().union(new BRelation<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(au,u),a),v),c),m)))).has(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(au1,u1),a1),v1),c1),m1))) ==> (machine.get_units_hierarchies().has(new Pair<Integer,Integer>(u1,au1)) &&  (\exists BSet<Integer> c2; (\exists Integer m2;machine.get_operational_permissions().has(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(u1,a1),v1),c2),m2))))))))))))); */
	public /*@ pure */ boolean guard_add_admin_permission( Integer a, BSet<Integer> c, Integer m, Integer au, Integer u, Integer v) {
		return (machine.get_admin_units().has(au) && machine.get_units().has(u) && machine.get_activities().has(a) && machine.get_views().has(v) && c.isSubset(machine.get_contexts()) && machine.MODE.has(m) && machine.transitive_closure(machine.get_units_hierarchies()).has(new Pair<Integer,Integer>(u,au)) && !machine.get_administrative_permissions().has(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(au,u),a),v),c),m)) && true && true);
	}

	/*@ public normal_behavior
		requires guard_add_admin_permission(a,c,m,au,u,v);
		assignable machine.administrative_permissions;
		ensures guard_add_admin_permission(a,c,m,au,u,v) &&  machine.get_administrative_permissions().equals(\old((machine.get_administrative_permissions().union(new BRelation<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(au,u),a),v),c),m)))))); 
	 also
		requires !guard_add_admin_permission(a,c,m,au,u,v);
		assignable \nothing;
		ensures true; */
	public void run_add_admin_permission( Integer a, BSet<Integer> c, Integer m, Integer au, Integer u, Integer v){
		if(guard_add_admin_permission(a,c,m,au,u,v)) {
			BRelation<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer> administrative_permissions_tmp = machine.get_administrative_permissions();

			machine.set_administrative_permissions((administrative_permissions_tmp.union(new BRelation<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(au,u),a),v),c),m)))));

			System.out.println("add_admin_permission executed a: " + a + " c: " + c + " m: " + m + " au: " + au + " u: " + u + " v: " + v + " ");
		}
	}

}
