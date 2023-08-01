package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Execute_Request{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Execute_Request(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_Access_Requested().has(r) && !machine.get_Final_Decision().domain().has(r) && NAT.instance.has(t) &&  (\forall Integer e;  (\forall Integer a;  (\forall Integer o;  (\forall Integer t0;  (\forall Integer dist;  (\forall Integer d;  (\forall Integer total;  (\forall Integer last;  (\forall Integer ac;((r.equals(new Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(t0,e),a),o),d),dist),ac)) && total.equals(new Integer(new Best<Pair>(new JMLObjectSet {Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer> trInteger t1Integer s1Integer dec | (\exists Pair e; (tr.equals(new Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>(new Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>(t1,r),s1),dec)) && machine.get_Request_Treated().has(tr)); e.equals(tr))}).size())) && last.equals((new BSet<Integer>(t0).union(new Best<Integer>(new JMLObjectSet {Integer t1Integer s1Integer dec | (\exists Integer e; (machine.get_Request_Treated().has(new Pair<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>(new Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>(new Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>(t1,r),s1),dec))); e.equals(t1))}))).max())) ==> (dist.equals(total) && t.equals(last) || t.equals(new Integer(last + new Integer(new Integer(dist - total) * d))) && (machine.get_time()).compareTo(t) >= 0)))))))))))); */
	public /*@ pure */ boolean guard_Execute_Request( Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> r, Integer t) {
		return (machine.get_Access_Requested().has(r) && !machine.get_Final_Decision().domain().has(r) && NAT.instance.has(t) && true);
	}

	/*@ public normal_behavior
		requires guard_Execute_Request(r,t);
		assignable machine.Final_Decision, machine.Processing_Time;
		ensures guard_Execute_Request(r,t) &&  machine.get_Final_Decision().equals(\old((machine.get_Final_Decision().override(new BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,BSet<Integer>>(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,BSet<Integer>>(r,(new BSet<Integer>(0).union(new Best<Integer>(new JMLObjectSet {Integer lastInteger sInteger dec | (\exists Integer e; (null.equals(new Best<Integer>(new JMLObjectSet {Integer t1Integer s1Integer dec1 | (\exists Integer e; (machine.get_Request_Treated().has(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,ERROR>,ERROR>,ERROR>(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,ERROR>,ERROR>(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,ERROR>(null,r),null),dec1))); e.equals(null))}).max()) && machine.get_Request_Treated().has(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,ERROR>,ERROR>,ERROR>(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,ERROR>,ERROR>(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,ERROR>(null,r),null),null))); e.equals(dec))}))).max())))))) &&  machine.get_Processing_Time().equals(\old((machine.get_Processing_Time().override(new BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(r,t)))))); 
	 also
		requires !guard_Execute_Request(r,t);
		assignable \nothing;
		ensures true; */
	public void run_Execute_Request( Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> r, Integer t){
		if(guard_Execute_Request(r,t)) {
			BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Final_Decision_tmp = machine.get_Final_Decision();
			BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Processing_Time_tmp = machine.get_Processing_Time();

			machine.set_Final_Decision(null); // Set Comprehension: feature not supported by EventB2Java
			machine.set_Processing_Time((Processing_Time_tmp.override(new BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(r,t)))));

			System.out.println("Execute_Request executed r: " + r + " t: " + t + " ");
		}
	}

}
