package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Assign_Approver{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Assign_Approver(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> ( (\forall Integer u1;  (\forall Integer p1;  (\forall Integer d1;((machine.get_CA1().has(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u1),p1),d1))) ==> (!u1.equals(u) && machine.get_UH1().has(new Pair<Integer,Integer>(u1,u)) ||  (\exists Integer u2; (\exists Integer p2; (\exists Integer d2;machine.get_CA1().has(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u2),p2),d2)) && machine.get_UH1().has(new Pair<Integer,Integer>(u2,u)))))))))) &&  (\forall Integer u2;  (\forall Integer p2;  (\forall Integer d2;((machine.get_CA1().has(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u2),p2),d2)) && !u.equals(u2)) ==> (((!machine.get_OU1().image(new BSet<Integer>(u)).equals(BSet.EMPTY) && !machine.get_OU1().image(new BSet<Integer>(u2)).equals(BSet.EMPTY)) ==> (machine.get_OU1().apply(u).equals(machine.get_OU1().apply(u2))))))))) && !machine.get_CA1().has(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u),p),d)) && NAT.instance.has(d) && NAT.instance.has(p)); */
	public /*@ pure */ boolean guard_Assign_Approver( Integer d, Integer cor, Integer p, Integer u) {
		return (true && true && !machine.get_CA1().has(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u),p),d)) && NAT.instance.has(d) && NAT.instance.has(p));
	}

	/*@ public normal_behavior
		requires guard_Assign_Approver(d,cor,p,u);
		assignable machine.CA1;
		ensures guard_Assign_Approver(d,cor,p,u) &&  machine.get_CA1().equals(\old((machine.get_CA1().union(new BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u),p),d)))))); 
	 also
		requires !guard_Assign_Approver(d,cor,p,u);
		assignable \nothing;
		ensures true; */
	public void run_Assign_Approver( Integer d, Integer cor, Integer p, Integer u){
		if(guard_Assign_Approver(d,cor,p,u)) {
			BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer> CA1_tmp = machine.get_CA1();

			machine.set_CA1((CA1_tmp.union(new BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u),p),d)))));

			System.out.println("Assign_Approver executed d: " + d + " cor: " + cor + " p: " + p + " u: " + u + " ");
		}
	}

}
