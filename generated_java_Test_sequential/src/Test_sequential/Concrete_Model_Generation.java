package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class Concrete_Model_Generation{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public Concrete_Model_Generation(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> true; */
	public /*@ pure */ boolean guard_Concrete_Model_Generation() {
		return true;
	}

	/*@ public normal_behavior
		requires guard_Concrete_Model_Generation();
		assignable machine.CiO, machine.AiO, machine.ViO, machine.AV, machine.AA, machine.RV, machine.root, machine.UH, machine.OU, machine.RiO, machine.UR, machine.EA, machine.PCA, machine.PRA, machine.PAA, machine.PVA, machine.PCxA, machine.CA, machine.PAcA;
		ensures guard_Concrete_Model_Generation() &&  machine.get_CiO().equals(\old(machine.get_CiO1())) &&  machine.get_AiO().equals(\old(machine.get_AiO1())) &&  machine.get_ViO().equals(\old(machine.get_ViO1())) &&  machine.get_AV().equals(\old(machine.get_AV1())) &&  machine.get_AA().equals(\old(machine.get_AA1())) &&  machine.get_RV().equals(\old(machine.get_RV1())) &&  machine.get_root().equals(\old(machine.get_root1())) &&  machine.get_UH().equals(\old(machine.get_UH1())) &&  machine.get_OU().equals(\old(machine.get_OU1())) &&  machine.get_RiO().equals(\old(machine.get_RiO1())) &&  machine.get_UR().equals(\old(machine.get_UR1())) &&  machine.get_EA().equals(\old(machine.get_EA1())) &&  machine.get_PCA().equals(\old(machine.get_PCA1())) &&  machine.get_PRA().equals(\old(machine.get_PRA1())) &&  machine.get_PAA().equals(\old(machine.get_PAA1())) &&  machine.get_PVA().equals(\old(machine.get_PVA1())) &&  machine.get_PCxA().equals(\old(machine.get_PCxA1())) &&  machine.get_CA().equals(\old(machine.get_CA1())) &&  machine.get_PAcA().equals(\old(machine.get_PAcA1())); 
	 also
		requires !guard_Concrete_Model_Generation();
		assignable \nothing;
		ensures true; */
	public void run_Concrete_Model_Generation(){
		if(guard_Concrete_Model_Generation()) {
			BRelation<Integer,Integer> CiO_tmp = machine.get_CiO();
			BRelation<Integer,Integer> AiO_tmp = machine.get_AiO();
			BRelation<Integer,Integer> ViO_tmp = machine.get_ViO();
			BRelation<Integer,Pair<Integer,Integer>> AV_tmp = machine.get_AV();
			BRelation<Integer,Pair<Integer,Integer>> AA_tmp = machine.get_AA();
			BRelation<Integer,Pair<Integer,Integer>> RV_tmp = machine.get_RV();
			BRelation<Integer,Integer> root_tmp = machine.get_root();
			BRelation<Integer,Integer> UH_tmp = machine.get_UH();
			BRelation<Integer,Integer> OU_tmp = machine.get_OU();
			BRelation<Integer,Integer> RiO_tmp = machine.get_RiO();
			BRelation<Integer,Pair<Integer,Integer>> UR_tmp = machine.get_UR();
			BRelation<Integer,Integer> EA_tmp = machine.get_EA();
			BRelation<Integer,Integer> PCA_tmp = machine.get_PCA();
			BRelation<Integer,Pair<Integer,Integer>> PRA_tmp = machine.get_PRA();
			BRelation<Integer,Pair<Integer,Integer>> PAA_tmp = machine.get_PAA();
			BRelation<Integer,Pair<Integer,Integer>> PVA_tmp = machine.get_PVA();
			BRelation<Integer,Pair<Integer,Integer>> PCxA_tmp = machine.get_PCxA();
			BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer> CA_tmp = machine.get_CA();
			BRelation<Integer,Pair<Integer,Integer>> PAcA_tmp = machine.get_PAcA();

			machine.set_CiO(machine.get_CiO1());
			machine.set_AiO(machine.get_AiO1());
			machine.set_ViO(machine.get_ViO1());
			machine.set_AV(machine.get_AV1());
			machine.set_AA(machine.get_AA1());
			machine.set_RV(machine.get_RV1());
			machine.set_root(machine.get_root1());
			machine.set_UH(machine.get_UH1());
			machine.set_OU(machine.get_OU1());
			machine.set_RiO(machine.get_RiO1());
			machine.set_UR(machine.get_UR1());
			machine.set_EA(machine.get_EA1());
			machine.set_PCA(machine.get_PCA1());
			machine.set_PRA(machine.get_PRA1());
			machine.set_PAA(machine.get_PAA1());
			machine.set_PVA(machine.get_PVA1());
			machine.set_PCxA(machine.get_PCxA1());
			machine.set_CA(machine.get_CA1());
			machine.set_PAcA(machine.get_PAcA1());

			System.out.println("Concrete_Model_Generation executed ");
		}
	}

}
