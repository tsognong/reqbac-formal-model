package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Define_Security_Rule{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Define_Security_Rule(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> (machine.get_RiO1().has(rio) && machine.get_AiO().has(aio) && machine.get_ViO().has(vio) && machine.get_CiO().has(cio) && machine.COR.has(cor) && machine.PERMISSION.has(perm) &&  (\forall Integer a;  (\forall Integer v;  (\forall Integer c;  (\forall Integer org1;  (\forall Integer org2;  (\forall Integer org3;((aio.equals(new Pair<Integer,Integer>(a,org1)) && vio.equals(new Pair<Integer,Integer>(v,org2)) && cio.equals(new Pair<Integer,Integer>(c,org3))) ==> (org1.equals(org2) && org2.equals(org3))))))))) && !machine.get_PRA1().domain().has(perm) && !machine.get_PAA1().domain().has(perm) && !machine.get_PVA1().domain().has(perm) && !machine.get_PCA1().domain().has(perm) && !machine.get_PCxA1().domain().has(perm) &&  (\forall Integer r;  (\forall Integer org;((cio.equals(new Pair<Integer,Integer>(r,org))) ==> ( (\forall Integer u1;  (\forall Integer p1;  (\forall Integer d1;  (\forall Integer org1;((machine.get_CA1().has(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u1),p1),d1)) && machine.get_OU1().apply(u1).equals(org1)) ==> (org1.equals(org)))))))))))); */
	public /*@ pure */ boolean guard_Define_Security_Rule( Integer perm, Pair<Integer,Integer> aio, Integer cor, Pair<Integer,Integer> cio, Pair<Integer,Integer> rio, Pair<Integer,Integer> vio) {
		return (machine.get_RiO1().has(rio) && machine.get_AiO().has(aio) && machine.get_ViO().has(vio) && machine.get_CiO().has(cio) && machine.COR.has(cor) && machine.PERMISSION.has(perm) && true && !machine.get_PRA1().domain().has(perm) && !machine.get_PAA1().domain().has(perm) && !machine.get_PVA1().domain().has(perm) && !machine.get_PCA1().domain().has(perm) && !machine.get_PCxA1().domain().has(perm) && true);
	}

	/*@ public normal_behavior
		requires guard_Define_Security_Rule(perm,aio,cor,cio,rio,vio);
		assignable machine.PRA1, machine.PAA1, machine.PVA1, machine.PCA1, machine.PCxA1, machine.PDA;
		ensures guard_Define_Security_Rule(perm,aio,cor,cio,rio,vio) &&  machine.get_PRA1().equals(\old((machine.get_PRA1().union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(perm,rio)))))) &&  machine.get_PAA1().equals(\old((machine.get_PAA1().union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(perm,aio)))))) &&  machine.get_PVA1().equals(\old((machine.get_PVA1().union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(perm,vio)))))) &&  machine.get_PCA1().equals(\old((machine.get_PCA1().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(perm,cor)))))) &&  machine.get_PCxA1().equals(\old((machine.get_PCxA1().union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(perm,cio)))))) &&  machine.get_PDA().equals(\old((machine.get_PDA().union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(perm,machine.GLOBAL_DEADLINE)))))); 
	 also
		requires !guard_Define_Security_Rule(perm,aio,cor,cio,rio,vio);
		assignable \nothing;
		ensures true; */
	public void run_Define_Security_Rule( Integer perm, Pair<Integer,Integer> aio, Integer cor, Pair<Integer,Integer> cio, Pair<Integer,Integer> rio, Pair<Integer,Integer> vio){
		if(guard_Define_Security_Rule(perm,aio,cor,cio,rio,vio)) {
			BRelation<Integer,Pair<Integer,Integer>> PRA1_tmp = machine.get_PRA1();
			BRelation<Integer,Pair<Integer,Integer>> PAA1_tmp = machine.get_PAA1();
			BRelation<Integer,Pair<Integer,Integer>> PVA1_tmp = machine.get_PVA1();
			BRelation<Integer,Integer> PCA1_tmp = machine.get_PCA1();
			BRelation<Integer,Pair<Integer,Integer>> PCxA1_tmp = machine.get_PCxA1();
			BRelation<Integer,Integer> PDA_tmp = machine.get_PDA();

			machine.set_PRA1((PRA1_tmp.union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(perm,rio)))));
			machine.set_PAA1((PAA1_tmp.union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(perm,aio)))));
			machine.set_PVA1((PVA1_tmp.union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(perm,vio)))));
			machine.set_PCA1((PCA1_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(perm,cor)))));
			machine.set_PCxA1((PCxA1_tmp.union(new BRelation<Integer,Pair<Integer,Integer>>(new Pair<Integer,Pair<Integer,Integer>>(perm,cio)))));
			machine.set_PDA((PDA_tmp.union(new BRelation<Integer,Integer>(new Pair<Integer,Integer>(perm,machine.GLOBAL_DEADLINE)))));

			System.out.println("Define_Security_Rule executed perm: " + perm + " aio: " + aio + " cor: " + cor + " cio: " + cio + " rio: " + rio + " vio: " + vio + " ");
		}
	}

}
