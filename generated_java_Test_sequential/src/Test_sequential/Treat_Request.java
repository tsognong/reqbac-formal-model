package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Treat_Request{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Treat_Request(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_Access_Requested().has(r) && NAT1.instance.has(t) && new Enumerated(new Integer(0),new Integer(1)).has(dec) &&  (\forall Integer t1;  (\forall Integer s1;  (\forall Integer dec1;((machine.get_Request_Treated().has(new Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>(new Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>(t1,r),s1),dec1))) ==> ((t).compareTo(t1) > 0 && !s1.equals(s)))))) &&  (\forall Integer u;  (\forall Integer u1;  (\forall Integer t1;  (\forall Integer s1;  (\forall Integer dec1;((machine.get_EA().has(new Pair<Integer,Integer>(s,u)) && machine.get_EA().has(new Pair<Integer,Integer>(s1,u1)) && (t1).compareTo(t) < 0 && machine.get_Request_Treated().has(new Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>(new Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>(t1,r),s1),dec1))) ==> (!u.equals(u1)))))))) &&  (\forall Integer e;  (\forall Integer a;  (\forall Integer o;  (\forall Integer t0;  (\forall Integer dist;  (\forall Integer d;  (\forall Integer ac;((r.equals(new Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(t0,e),a),o),d),dist),ac))) ==> (machine.get_PATH().image(new BSet<Integer>(machine.get_EA().apply(e))).has(machine.get_EA().apply(s))))))))))) &&  (\forall Integer e;  (\forall Integer a;  (\forall Integer o;  (\forall Integer t0;  (\forall Integer dist;  (\forall Integer d;  (\forall Integer ac;((r.equals(new Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(t0,e),a),o),d),dist),ac))) ==> ((new Integer(machine.get_height().apply(machine.get_EA().apply(e)) - machine.get_height().apply(machine.get_EA().apply(s)))).compareTo(dist) <= 0))))))))) &&  (\forall Integer e;  (\forall Integer a;  (\forall Integer o;  (\forall Integer t0;  (\forall Integer dist;  (\forall Integer d;  (\forall Integer ac;  (\forall Integer current;((r.equals(new Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(t0,e),a),o),d),dist),ac)) && current.equals(new Integer(new Best<Pair>(new JMLObjectSet {Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer> trInteger t1Integer s1Integer dec1 | (\exists Pair e; (tr.equals(new Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>(new Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>(t1,r),s1),dec1)) && machine.get_Request_Treated().has(tr)); e.equals(tr))}).size()))) ==> ((t).compareTo(new Integer((new BSet<Integer>(t0).union(new Best<Integer>(new JMLObjectSet {Integer t1Integer s1Integer dec1 | (\exists Integer e; (machine.get_Request_Treated().has(new Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>(new Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>(t1,r),s1),dec1))); e.equals(t1))}))).max() + new Integer(new Integer(new Integer(machine.get_height().apply(machine.get_EA().apply(e)) - machine.get_height().apply(machine.get_EA().apply(s))) - current) * d))) <= 0)))))))))) &&  (\forall Integer e;  (\forall Integer a;  (\forall Integer o;  (\forall Integer t0;  (\forall Integer dist;  (\forall Integer d;  (\forall Integer ac;((r.equals(new Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(t0,e),a),o),d),dist),ac))) ==> (machine.isTrue.apply(ac).equals(new Integer(1)))))))))))); */
	public /*@ pure */ boolean guard_Treat_Request( Integer dec, Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> r, Integer s, Integer t) {
		return (machine.get_Access_Requested().has(r) && NAT1.instance.has(t) && new Enumerated(new Integer(0),new Integer(1)).has(dec) && true && true && true && true && true && true);
	}

	/*@ public normal_behavior
		requires guard_Treat_Request(dec,r,s,t);
		assignable machine.Request_Treated, machine.at;
		ensures guard_Treat_Request(dec,r,s,t) &&  machine.get_Request_Treated().equals(\old((machine.get_Request_Treated().union(new BRelation<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>(new Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>(t,r),s),dec)))))) &&  machine.get_at().equals(\old(machine.get_at().difference(new BSet<Integer>(machine.get_time())))); 
	 also
		requires !guard_Treat_Request(dec,r,s,t);
		assignable \nothing;
		ensures true; */
	public void run_Treat_Request( Integer dec, Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> r, Integer s, Integer t){
		if(guard_Treat_Request(dec,r,s,t)) {
			BRelation<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer> Request_Treated_tmp = machine.get_Request_Treated();
			BSet<Integer> at_tmp = machine.get_at();

			machine.set_Request_Treated((Request_Treated_tmp.union(new BRelation<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>(new Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>(t,r),s),dec)))));
			machine.set_at(at_tmp.difference(new BSet<Integer>(machine.get_time())));

			System.out.println("Treat_Request executed dec: " + dec + " r: " + r + " s: " + s + " t: " + t + " ");
		}
	}

}
