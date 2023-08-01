package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Request_Access{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Request_Access(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.EMPLOYEE.has(e) && machine.ACTION.has(a) && machine.RESOURCE.has(o) && NAT1.instance.has(t) && machine.get_PDistA().range().has(dist) && machine.CONTEXT.has(ac) && NAT.instance.has(d) &&  (\forall Integer e1;  (\forall Integer a1;  (\forall Integer o1;  (\forall Integer t1;  (\forall Integer dl;  (\forall Integer d1;  (\forall Integer ctx;((machine.get_Access_Requested().has(new Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(t1,e1),a1),o1),dl),d1),ctx))) ==> ((t).compareTo(t1) > 0))))))))) &&  (\exists Integer u; (\exists Integer r; (\exists Integer v; (\exists Integer p; (\exists Integer org; (\exists Integer act; (\exists Integer c; (\exists Pair<Integer,Integer> rio; (\exists Pair<Integer,Integer> aio; (\exists Pair<Integer,Integer> vio; (\exists Pair<Integer,Integer> cio; (\exists Pair<Integer,Integer> acio;machine.get_EA().has(new Pair<Integer,Integer>(e,u)) && machine.get_OU().has(new Pair<Integer,Integer>(u,org)) && rio.equals(new Pair<Integer,Integer>(r,org)) && machine.get_RiO().has(rio) && machine.get_UR().has(new Pair<Integer,Pair<Integer,Integer>>(u,rio)) && machine.get_PRA().has(new Pair<Integer,Pair<Integer,Integer>>(p,rio)) && vio.equals(new Pair<Integer,Integer>(v,org)) && machine.get_ViO().has(vio) && machine.get_RV().has(new Pair<Integer,Pair<Integer,Integer>>(o,vio)) && machine.get_PVA().has(new Pair<Integer,Pair<Integer,Integer>>(p,vio)) && aio.equals(new Pair<Integer,Integer>(act,org)) && machine.get_PAA().has(new Pair<Integer,Pair<Integer,Integer>>(p,aio)) && machine.get_AV().has(new Pair<Integer,Pair<Integer,Integer>>(a,vio)) && machine.get_AA().has(new Pair<Integer,Pair<Integer,Integer>>(a,aio)) && cio.equals(new Pair<Integer,Integer>(c,org)) && machine.get_PCxA().has(new Pair<Integer,Pair<Integer,Integer>>(p,cio)) && machine.get_PDistA().has(new Pair<Integer,Integer>(p,dist)) && acio.equals(new Pair<Integer,Integer>(ac,org)) && machine.get_PAcA().has(new Pair<Integer,Pair<Integer,Integer>>(p,acio)) && machine.get_PDA().has(new Pair<Integer,Integer>(p,d)))))))))))))) && machine.get_PDistA().range().has(dist) && (t).compareTo(machine.get_time()) > 0); */
	public /*@ pure */ boolean guard_Request_Access( Integer a, Integer ac, Integer d, Integer e, Integer dist, Integer o, Integer t) {
		return (machine.EMPLOYEE.has(e) && machine.ACTION.has(a) && machine.RESOURCE.has(o) && NAT1.instance.has(t) && machine.get_PDistA().range().has(dist) && machine.CONTEXT.has(ac) && NAT.instance.has(d) && true && true && machine.get_PDistA().range().has(dist) && (t).compareTo(machine.get_time()) > 0);
	}

	/*@ public normal_behavior
		requires guard_Request_Access(a,ac,d,e,dist,o,t);
		assignable machine.Access_Requested, machine.at;
		ensures guard_Request_Access(a,ac,d,e,dist,o,t) &&  machine.get_Access_Requested().equals(\old((machine.get_Access_Requested().union(new BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(t,e),a),o),d),dist),ac)))))) &&  machine.get_at().equals(\old((machine.get_at().union(new BSet<Integer>(t))))); 
	 also
		requires !guard_Request_Access(a,ac,d,e,dist,o,t);
		assignable \nothing;
		ensures true; */
	public void run_Request_Access( Integer a, Integer ac, Integer d, Integer e, Integer dist, Integer o, Integer t){
		if(guard_Request_Access(a,ac,d,e,dist,o,t)) {
			BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Access_Requested_tmp = machine.get_Access_Requested();
			BSet<Integer> at_tmp = machine.get_at();

			machine.set_Access_Requested((Access_Requested_tmp.union(new BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(t,e),a),o),d),dist),ac)))));
			machine.set_at((at_tmp.union(new BSet<Integer>(t))));

			System.out.println("Request_Access executed a: " + a + " ac: " + ac + " d: " + d + " e: " + e + " dist: " + dist + " o: " + o + " t: " + t + " ");
		}
	}

}
