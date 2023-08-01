package Test_sequential;

import eventb_prelude.*;
import Util.*;
//@ model import org.jmlspecs.models.JMLObjectSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class m12{
	private static final Integer max_integer = Utilities.max_integer;
	private static final Integer min_integer = Utilities.min_integer;

	Assign_Employee?to_Unit evt_Assign_Employee?to_Unit = new Assign_Employee?to_Unit(this);
	Concrete_Model_Generation evt_Concrete_Model_Generation = new Concrete_Model_Generation(this);
	Assign_Approval_Deadline evt_Assign_Approval_Deadline = new Assign_Approval_Deadline(this);
	Execute_Request evt_Execute_Request = new Execute_Request(this);
	Assign_View_to_Organization evt_Assign_View_to_Organization = new Assign_View_to_Organization(this);
	Assign_Resource_to_View evt_Assign_Resource_to_View = new Assign_Resource_to_View(this);
	Treat_Request evt_Treat_Request = new Treat_Request(this);
	tick_tock evt_tick_tock = new tick_tock(this);
	Assign_activity_to_Organization evt_Assign_activity_to_Organization = new Assign_activity_to_Organization(this);
	Assign_Context_to_Organization evt_Assign_Context_to_Organization = new Assign_Context_to_Organization(this);
	Assign_Role_to_Unit evt_Assign_Role_to_Unit = new Assign_Role_to_Unit(this);
	Assign_Approver evt_Assign_Approver = new Assign_Approver(this);
	Define_Security_Rule evt_Define_Security_Rule = new Define_Security_Rule(this);
	Assign_Role_to_Organization evt_Assign_Role_to_Organization = new Assign_Role_to_Organization(this);
	Assign_Approval_Context evt_Assign_Approval_Context = new Assign_Approval_Context(this);
	Add_Unit_Hierarchy evt_Add_Unit_Hierarchy = new Add_Unit_Hierarchy(this);
	Assign_Organization_Root evt_Assign_Organization_Root = new Assign_Organization_Root(this);
	Assign_approval_perimeter evt_Assign_approval_perimeter = new Assign_approval_perimeter(this);
	Assign_Action_to_Activity evt_Assign_Action_to_Activity = new Assign_Action_to_Activity(this);
	Request_Access evt_Request_Access = new Request_Access(this);
	Assign_Unit_to_Org evt_Assign_Unit_to_Org = new Assign_Unit_to_Org(this);


	/******Set definitions******/
	//@ public static constraint ROLE.equals(\old(ROLE)); 
	public static final BSet<Integer> ROLE = new Enumerated(min_integer,max_integer);

	//@ public static constraint ACTION.equals(\old(ACTION)); 
	public static final BSet<Integer> ACTION = new Enumerated(min_integer,max_integer);

	//@ public static constraint ACTIVITY.equals(\old(ACTIVITY)); 
	public static final BSet<Integer> ACTIVITY = new Enumerated(min_integer,max_integer);

	//@ public static constraint UNIT.equals(\old(UNIT)); 
	public static final BSet<Integer> UNIT = new Enumerated(min_integer,max_integer);

	//@ public static constraint CONTEXT.equals(\old(CONTEXT)); 
	public static final BSet<Integer> CONTEXT = new Enumerated(min_integer,max_integer);

	//@ public static constraint VIEW.equals(\old(VIEW)); 
	public static final BSet<Integer> VIEW = new Enumerated(min_integer,max_integer);

	//@ public static constraint ORG.equals(\old(ORG)); 
	public static final BSet<Integer> ORG = new Enumerated(min_integer,max_integer);

	//@ public static constraint EMPLOYEE.equals(\old(EMPLOYEE)); 
	public static final BSet<Integer> EMPLOYEE = new Enumerated(min_integer,max_integer);

	//@ public static constraint COR.equals(\old(COR)); 
	public static final BSet<Integer> COR = new Enumerated(min_integer,max_integer);

	//@ public static constraint RESOURCE.equals(\old(RESOURCE)); 
	public static final BSet<Integer> RESOURCE = new Enumerated(min_integer,max_integer);

	//@ public static constraint PERMISSION.equals(\old(PERMISSION)); 
	public static final BSet<Integer> PERMISSION = new Enumerated(min_integer,max_integer);


	/******Constant definitions******/
	//@ public static constraint isTrue.equals(\old(isTrue)); 
	public static final BRelation<Integer,Integer> isTrue = Test_m12.random_isTrue;

	//@ public static constraint POSITION.equals(\old(POSITION)); 
	public static final BSet<Integer> POSITION = Test_m12.random_POSITION;

	//@ public static constraint APPROVER.equals(\old(APPROVER)); 
	public static final BRelation<Pair<Integer,Integer>,Integer> APPROVER = Test_m12.random_APPROVER;

	//@ public static constraint GLOBAL_DEADLINE.equals(\old(GLOBAL_DEADLINE)); 
	public static final Integer GLOBAL_DEADLINE = Test_m12.random_GLOBAL_DEADLINE;

	//@ public static constraint DEADLINE.equals(\old(DEADLINE)); 
	public static final BSet<Integer> DEADLINE = Test_m12.random_DEADLINE;



	/******Axiom definitions******/
	/*@ public static invariant UNIT.finite() && ORG.finite() && ROLE.finite() && EMPLOYEE.finite() && CONTEXT.finite(); */
	/*@ public static invariant PERMISSION.finite(); */
	/*@ public static invariant ACTIVITY.finite() && ACTION.finite() && VIEW.finite() && RESOURCE.finite(); */
	/*@ public static invariant COR.finite(); */
	/*@ public static invariant NAT1.instance.has(GLOBAL_DEADLINE); */
	/*@ public static invariant POSITION.equals(new Enumerated(new Integer(1),new Integer(100))); */
	/*@ public static invariant DEADLINE.equals(NAT.instance); */
	/*@ public static invariant APPROVER.equals(BRelation.cross(BRelation.cross(UNIT,POSITION),DEADLINE)); */
	/*@ public static invariant  isTrue.domain().equals(CONTEXT) && isTrue.range().isSubset(new Enumerated(new Integer(0),new Integer(1))) && isTrue.isaFunction() && BRelation.cross(CONTEXT,new Enumerated(new Integer(0),new Integer(1))).has(isTrue); */
	/*@ public static invariant new Integer(CONTEXT.size()).equals(new Integer(1000)); */


	/******Variable definitions******/
	/*@ spec_public */ private BRelation<Integer,Integer> AiO1;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> AA;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> AV;

	/*@ spec_public */ private BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer> CA;

	/*@ spec_public */ private BRelation<Integer,Integer> CiO;

	/*@ spec_public */ private BRelation<Integer,Integer> EA;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PVA1;

	/*@ spec_public */ private BRelation<Integer,Integer> root;

	/*@ spec_public */ private BRelation<Integer,Integer> RiO;

	/*@ spec_public */ private BRelation<Integer,Integer> CiO1;

	/*@ spec_public */ private BRelation<Integer,Integer> AiO;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> UR1;

	/*@ spec_public */ private BRelation<Integer,Integer> PCA1;

	/*@ spec_public */ private BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Access_Requested;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PRA1;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PAA1;

	/*@ spec_public */ private BRelation<Integer,Integer> OU;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> RV;

	/*@ spec_public */ private BRelation<Integer,Integer> RiO1;

	/*@ spec_public */ private BRelation<Integer,Integer> UH;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> UR;

	/*@ spec_public */ private BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Discarded_Request;

	/*@ spec_public */ private Integer time;

	/*@ spec_public */ private BRelation<Integer,Integer> OU1;

	/*@ spec_public */ private BRelation<Integer,Integer> EA1;

	/*@ spec_public */ private BRelation<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer> Request_Treated;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PCxA1;

	/*@ spec_public */ private BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Processing_Time;

	/*@ spec_public */ private BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer> CA1;

	/*@ spec_public */ private BRelation<Integer,Integer> ViO1;

	/*@ spec_public */ private BRelation<Integer,Integer> PATH;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> AA1;

	/*@ spec_public */ private BSet<Integer> at;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PAA;

	/*@ spec_public */ private BRelation<Integer,Integer> PDistA;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PAcA1;

	/*@ spec_public */ private BRelation<Integer,Integer> PCA;

	/*@ spec_public */ private BRelation<Integer,Integer> PDA;

	/*@ spec_public */ private BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Final_Decision;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PAcA;

	/*@ spec_public */ private BRelation<Integer,Integer> root1;

	/*@ spec_public */ private BRelation<Integer,Integer> height;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> RV1;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PRA;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> AV1;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PVA;

	/*@ spec_public */ private BRelation<Integer,Pair<Integer,Integer>> PCxA;

	/*@ spec_public */ private BRelation<Integer,Integer> ViO;

	/*@ spec_public */ private BRelation<Integer,Integer> UH1;




	/******Invariant definition******/
	/*@ public invariant
		CiO.isSubset(BRelation.cross(CONTEXT,ORG)) &&
		 root.domain().isSubset(ORG) && root.range().isSubset(UNIT) && root.isaFunction() && BRelation.cross(ORG,UNIT).has(root) &&
		 OU.domain().isSubset(UNIT) && OU.range().isSubset(ORG) && OU.isaFunction() && BRelation.cross(UNIT,ORG).has(OU) &&
		AiO.isSubset(BRelation.cross(ACTIVITY,ORG)) &&
		 UH.domain().isSubset(UNIT) && UH.range().isSubset(UNIT) && UH.isaFunction() && BRelation.cross(UNIT,UNIT).has(UH) &&
		ViO.isSubset(BRelation.cross(VIEW,ORG)) &&
		RiO.isSubset(BRelation.cross(ROLE,ORG)) &&
		CA.isSubset(BRelation.cross(BRelation.cross(BRelation.cross(COR,UNIT),POSITION),DEADLINE)) &&
		 PCA.domain().isSubset(PERMISSION) && PCA.range().isSubset(COR) && PCA.isaFunction() && BRelation.cross(PERMISSION,COR).has(PCA) &&
		 PRA.domain().isSubset(PERMISSION) && PRA.range().isSubset(RiO) && PRA.isaFunction() && BRelation.cross(PERMISSION,RiO).has(PRA) &&
		EA.isSubset(BRelation.cross(EMPLOYEE,UNIT)) &&
		UR.isSubset(BRelation.cross(UNIT,RiO)) &&
		 PAA.domain().isSubset(PERMISSION) && PAA.range().isSubset(AiO) && PAA.isaFunction() && BRelation.cross(PERMISSION,AiO).has(PAA) &&
		 PVA.domain().isSubset(PERMISSION) && PVA.range().isSubset(ViO) && PVA.isaFunction() && BRelation.cross(PERMISSION,ViO).has(PVA) &&
		 PCxA.domain().isSubset(PERMISSION) && PCxA.range().isSubset(CiO) && PCxA.isaFunction() && BRelation.cross(PERMISSION,CiO).has(PCxA) &&
		AV.isSubset(BRelation.cross(ACTION,ViO)) &&
		AA.isSubset(BRelation.cross(ACTION,AiO)) &&
		RV.isSubset(BRelation.cross(RESOURCE,ViO)) &&
		 UH1.domain().isSubset(UNIT) && UH1.range().isSubset(UNIT) && UH1.isaFunction() && BRelation.cross(UNIT,UNIT).has(UH1) &&
		(UH1.intersection((new ID()))).equals(BSet.EMPTY) &&
		(UH1.intersection(UH1.inverse())).equals(BSet.EMPTY) &&
		 OU1.domain().isSubset(UNIT) && OU1.range().isSubset(ORG) && OU1.isaFunction() && BRelation.cross(UNIT,ORG).has(OU1) &&
		 root1.domain().isSubset(ORG) && root1.range().isSubset(OU1.domain()) && root1.isaFunction() && BRelation.cross(ORG,OU1.domain()).has(root1) &&
		 (\forall Integer org1;  (\forall Integer org2;  (\forall Integer u;((root1.has(new Pair<Integer,Integer>(org1,u)) && root1.has(new Pair<Integer,Integer>(org2,u))) ==> (org1.equals(org2)))))) &&
		(root1.range().intersection(UH1.domain())).equals(BSet.EMPTY) &&
		 (\forall Integer u;  (\forall Integer org;((root1.has(new Pair<Integer,Integer>(org,u))) ==> (OU1.has(new Pair<Integer,Integer>(u,org)))))) &&
		 (\forall Integer us;  (\forall Integer um;((UH1.has(new Pair<Integer,Integer>(us,um))) ==> (((!OU1.image(new BSet<Integer>(us)).equals(BSet.EMPTY) && !OU1.image(new BSet<Integer>(um)).equals(BSet.EMPTY)) ==> (OU1.apply(us).equals(OU1.apply(um)))))))) &&
		RiO1.isSubset(BRelation.cross(ROLE,ORG)) &&
		UR1.isSubset(BRelation.cross(UNIT,RiO1)) &&
		 (\forall Integer u;  (\forall Integer org;  (\forall Integer role;((UR1.has(new Pair<Integer,Pair<Integer,Integer>>(u,new Pair<Integer,Integer>(role,org)))) ==> (((!OU1.image(new BSet<Integer>(u)).equals(BSet.EMPTY)) ==> (OU1.apply(u).equals(org)))))))) &&
		EA1.isSubset(BRelation.cross(EMPLOYEE,UNIT)) &&
		 (\forall Integer u1;  (\forall Integer u2;  (\forall Integer e;((UH1.has(new Pair<Integer,Integer>(u1,u2)) && EA1.has(new Pair<Integer,Integer>(e,u1))) ==> (!EA1.has(new Pair<Integer,Integer>(e,u2))))))) &&
		CA1.isSubset(BRelation.cross(BRelation.cross(BRelation.cross(COR,UNIT),POSITION),DEADLINE)) &&
		 PRA1.domain().isSubset(PERMISSION) && PRA1.range().isSubset(RiO1) && PRA1.isaFunction() && BRelation.cross(PERMISSION,RiO1).has(PRA1) &&
		 PAA1.domain().isSubset(PERMISSION) && PAA1.range().isSubset(AiO) && PAA1.isaFunction() && BRelation.cross(PERMISSION,AiO).has(PAA1) &&
		 PVA1.domain().isSubset(PERMISSION) && PVA1.range().isSubset(ViO) && PVA1.isaFunction() && BRelation.cross(PERMISSION,ViO).has(PVA1) &&
		 PCA1.domain().isSubset(PERMISSION) && PCA1.range().isSubset(COR) && PCA1.isaFunction() && BRelation.cross(PERMISSION,COR).has(PCA1) &&
		 PCxA1.domain().isSubset(PERMISSION) && PCxA1.range().isSubset(CiO) && PCxA1.isaFunction() && BRelation.cross(PERMISSION,CiO).has(PCxA1) &&
		 (\forall Integer cor;  (\forall Integer u1;  (\forall Integer p1;  (\forall Integer d1;  (\forall Integer u2;  (\forall Integer p2;  (\forall Integer d2;((CA1.has(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u1),p1),d1)) && CA1.has(new Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>(new Pair<Pair<Integer,Integer>,Integer>(new Pair<Integer,Integer>(cor,u2),p2),d2)) && !u1.equals(u2)) ==> (((!OU1.image(new BSet<Integer>(u1)).equals(BSet.EMPTY) && !OU1.image(new BSet<Integer>(u2)).equals(BSet.EMPTY)) ==> (OU1.apply(u1).equals(OU1.apply(u2))))))))))))) &&
		ViO1.isSubset(BRelation.cross(VIEW,ORG)) &&
		RV1.isSubset(BRelation.cross(RESOURCE,ViO1)) &&
		AiO1.isSubset(BRelation.cross(ACTIVITY,ORG)) &&
		AV1.isSubset(BRelation.cross(ACTION,ViO1)) &&
		AA1.isSubset(BRelation.cross(ACTION,AiO1)) &&
		CiO1.isSubset(BRelation.cross(CONTEXT,ORG)) &&
		Access_Requested.isSubset(BRelation.cross(BRelation.cross(BRelation.cross(BRelation.cross(BRelation.cross(BRelation.cross(NAT1.instance,EMPLOYEE),ACTION),RESOURCE),DEADLINE),NAT.instance),CONTEXT)) &&
		 PDistA.domain().isSubset(PERMISSION) && PDistA.range().isSubset(NAT.instance) && PDistA.isaFunction() && BRelation.cross(PERMISSION,NAT.instance).has(PDistA) &&
		 PAcA.domain().isSubset(PERMISSION) && PAcA.range().isSubset(CiO) && PAcA.isaFunction() && BRelation.cross(PERMISSION,CiO).has(PAcA) &&
		Request_Treated.isSubset(BRelation.cross(BRelation.cross(BRelation.cross(NAT1.instance,Access_Requested),EMPLOYEE),new Enumerated(new Integer(0),new Integer(1)))) &&
		NAT.instance.has(time) &&
		at.isSubset(NAT.instance) &&
		((!at.equals(BSet.EMPTY)) ==> ((time).compareTo(at.min()) <= 0)) &&
		 PDA.domain().isSubset(PERMISSION) && PDA.range().isSubset(NAT.instance) && PDA.isaFunction() && BRelation.cross(PERMISSION,NAT.instance).has(PDA) &&
		Discarded_Request.isSubset(Access_Requested) &&
		 height.domain().isSubset(UNIT) && height.range().isSubset(NAT.instance) && height.isaFunction() && BRelation.cross(UNIT,NAT.instance).has(height) &&
		 (\forall Integer u;((root1.range().has(u)) ==> (((!height.image(new BSet<Integer>(u)).equals(BSet.EMPTY)) ==> (height.apply(u).equals(new Integer(0))))))) &&
		 (\forall Integer u;  (\forall Integer v;((UH1.has(new Pair<Integer,Integer>(u,v))) ==> (((!height.image(new BSet<Integer>(u)).equals(BSet.EMPTY) && !height.image(new BSet<Integer>(v)).equals(BSet.EMPTY)) ==> (height.apply(u).equals(new Integer(height.apply(v) + new Integer(1))))))))) &&
		PATH.isSubset(BRelation.cross(UNIT,UNIT)) &&
		 PDistA.domain().isSubset(PERMISSION) && PDistA.range().isSubset(NAT.instance) && PDistA.isaFunction() && BRelation.cross(PERMISSION,NAT.instance).has(PDistA) &&
		 Final_Decision.domain().isSubset(Access_Requested) && Final_Decision.range().isSubset(new Enumerated(new Integer(0),new Integer(1))) && Final_Decision.isaFunction() && BRelation.cross(Access_Requested,new Enumerated(new Integer(0),new Integer(1))).has(Final_Decision) &&
		 Processing_Time.domain().isSubset(Access_Requested) && Processing_Time.range().isSubset(NAT.instance) && Processing_Time.isaFunction() && BRelation.cross(Access_Requested,NAT.instance).has(Processing_Time) &&
		 PAcA1.domain().isSubset(PERMISSION) && PAcA1.range().isSubset(CiO1) && PAcA1.isaFunction() && BRelation.cross(PERMISSION,CiO1).has(PAcA1) &&
		 (\forall Integer u1;  (\forall Integer u2;  (\forall Pair<Integer,Integer> h;((h.equals(new Pair<Integer,Integer>(u1,u2)) && UH1.has(h)) ==> (!PATH.image(new BSet<Integer>(u2)).has(u1)))))); */
	/*@ public invariant_redundantly
	 (\forall Integer u1;  (\forall Integer u2;  (\forall Integer u3;((UH1.has(new Pair<Integer,Integer>(u1,u2)) && UH1.has(new Pair<Integer,Integer>(u1,u3))) ==> (u2.equals(u3)))))); */


	/******Getter and Mutator methods definition******/
	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PATH;*/
	public /*@ pure */ BRelation<Integer,Integer> get_PATH(){
		return this.PATH;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PATH;
	    ensures this.PATH == PATH;*/
	public void set_PATH(BRelation<Integer,Integer> PATH){
		this.PATH = PATH;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.AiO;*/
	public /*@ pure */ BRelation<Integer,Integer> get_AiO(){
		return this.AiO;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.AiO;
	    ensures this.AiO == AiO;*/
	public void set_AiO(BRelation<Integer,Integer> AiO){
		this.AiO = AiO;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.CiO;*/
	public /*@ pure */ BRelation<Integer,Integer> get_CiO(){
		return this.CiO;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.CiO;
	    ensures this.CiO == CiO;*/
	public void set_CiO(BRelation<Integer,Integer> CiO){
		this.CiO = CiO;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.OU1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_OU1(){
		return this.OU1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.OU1;
	    ensures this.OU1 == OU1;*/
	public void set_OU1(BRelation<Integer,Integer> OU1){
		this.OU1 = OU1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.AA1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_AA1(){
		return this.AA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.AA1;
	    ensures this.AA1 == AA1;*/
	public void set_AA1(BRelation<Integer,Pair<Integer,Integer>> AA1){
		this.AA1 = AA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.CA1;*/
	public /*@ pure */ BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer> get_CA1(){
		return this.CA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.CA1;
	    ensures this.CA1 == CA1;*/
	public void set_CA1(BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer> CA1){
		this.CA1 = CA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.UH;*/
	public /*@ pure */ BRelation<Integer,Integer> get_UH(){
		return this.UH;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.UH;
	    ensures this.UH == UH;*/
	public void set_UH(BRelation<Integer,Integer> UH){
		this.UH = UH;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.EA1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_EA1(){
		return this.EA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.EA1;
	    ensures this.EA1 == EA1;*/
	public void set_EA1(BRelation<Integer,Integer> EA1){
		this.EA1 = EA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.AiO1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_AiO1(){
		return this.AiO1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.AiO1;
	    ensures this.AiO1 == AiO1;*/
	public void set_AiO1(BRelation<Integer,Integer> AiO1){
		this.AiO1 = AiO1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.Final_Decision;*/
	public /*@ pure */ BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> get_Final_Decision(){
		return this.Final_Decision;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.Final_Decision;
	    ensures this.Final_Decision == Final_Decision;*/
	public void set_Final_Decision(BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Final_Decision){
		this.Final_Decision = Final_Decision;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PDistA;*/
	public /*@ pure */ BRelation<Integer,Integer> get_PDistA(){
		return this.PDistA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PDistA;
	    ensures this.PDistA == PDistA;*/
	public void set_PDistA(BRelation<Integer,Integer> PDistA){
		this.PDistA = PDistA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.EA;*/
	public /*@ pure */ BRelation<Integer,Integer> get_EA(){
		return this.EA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.EA;
	    ensures this.EA == EA;*/
	public void set_EA(BRelation<Integer,Integer> EA){
		this.EA = EA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.AV1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_AV1(){
		return this.AV1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.AV1;
	    ensures this.AV1 == AV1;*/
	public void set_AV1(BRelation<Integer,Pair<Integer,Integer>> AV1){
		this.AV1 = AV1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.UR;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_UR(){
		return this.UR;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.UR;
	    ensures this.UR == UR;*/
	public void set_UR(BRelation<Integer,Pair<Integer,Integer>> UR){
		this.UR = UR;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.height;*/
	public /*@ pure */ BRelation<Integer,Integer> get_height(){
		return this.height;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.height;
	    ensures this.height == height;*/
	public void set_height(BRelation<Integer,Integer> height){
		this.height = height;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.AA;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_AA(){
		return this.AA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.AA;
	    ensures this.AA == AA;*/
	public void set_AA(BRelation<Integer,Pair<Integer,Integer>> AA){
		this.AA = AA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.Access_Requested;*/
	public /*@ pure */ BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> get_Access_Requested(){
		return this.Access_Requested;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.Access_Requested;
	    ensures this.Access_Requested == Access_Requested;*/
	public void set_Access_Requested(BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Access_Requested){
		this.Access_Requested = Access_Requested;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.Request_Treated;*/
	public /*@ pure */ BRelation<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer> get_Request_Treated(){
		return this.Request_Treated;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.Request_Treated;
	    ensures this.Request_Treated == Request_Treated;*/
	public void set_Request_Treated(BRelation<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer> Request_Treated){
		this.Request_Treated = Request_Treated;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PAcA1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PAcA1(){
		return this.PAcA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PAcA1;
	    ensures this.PAcA1 == PAcA1;*/
	public void set_PAcA1(BRelation<Integer,Pair<Integer,Integer>> PAcA1){
		this.PAcA1 = PAcA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PCA;*/
	public /*@ pure */ BRelation<Integer,Integer> get_PCA(){
		return this.PCA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PCA;
	    ensures this.PCA == PCA;*/
	public void set_PCA(BRelation<Integer,Integer> PCA){
		this.PCA = PCA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PCxA1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PCxA1(){
		return this.PCxA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PCxA1;
	    ensures this.PCxA1 == PCxA1;*/
	public void set_PCxA1(BRelation<Integer,Pair<Integer,Integer>> PCxA1){
		this.PCxA1 = PCxA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PVA1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PVA1(){
		return this.PVA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PVA1;
	    ensures this.PVA1 == PVA1;*/
	public void set_PVA1(BRelation<Integer,Pair<Integer,Integer>> PVA1){
		this.PVA1 = PVA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.at;*/
	public /*@ pure */ BSet<Integer> get_at(){
		return this.at;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.at;
	    ensures this.at == at;*/
	public void set_at(BSet<Integer> at){
		this.at = at;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.AV;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_AV(){
		return this.AV;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.AV;
	    ensures this.AV == AV;*/
	public void set_AV(BRelation<Integer,Pair<Integer,Integer>> AV){
		this.AV = AV;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.UR1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_UR1(){
		return this.UR1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.UR1;
	    ensures this.UR1 == UR1;*/
	public void set_UR1(BRelation<Integer,Pair<Integer,Integer>> UR1){
		this.UR1 = UR1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PRA1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PRA1(){
		return this.PRA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PRA1;
	    ensures this.PRA1 == PRA1;*/
	public void set_PRA1(BRelation<Integer,Pair<Integer,Integer>> PRA1){
		this.PRA1 = PRA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.RV;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_RV(){
		return this.RV;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.RV;
	    ensures this.RV == RV;*/
	public void set_RV(BRelation<Integer,Pair<Integer,Integer>> RV){
		this.RV = RV;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.Processing_Time;*/
	public /*@ pure */ BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> get_Processing_Time(){
		return this.Processing_Time;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.Processing_Time;
	    ensures this.Processing_Time == Processing_Time;*/
	public void set_Processing_Time(BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Processing_Time){
		this.Processing_Time = Processing_Time;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PAcA;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PAcA(){
		return this.PAcA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PAcA;
	    ensures this.PAcA == PAcA;*/
	public void set_PAcA(BRelation<Integer,Pair<Integer,Integer>> PAcA){
		this.PAcA = PAcA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PDA;*/
	public /*@ pure */ BRelation<Integer,Integer> get_PDA(){
		return this.PDA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PDA;
	    ensures this.PDA == PDA;*/
	public void set_PDA(BRelation<Integer,Integer> PDA){
		this.PDA = PDA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.root;*/
	public /*@ pure */ BRelation<Integer,Integer> get_root(){
		return this.root;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.root;
	    ensures this.root == root;*/
	public void set_root(BRelation<Integer,Integer> root){
		this.root = root;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.RiO;*/
	public /*@ pure */ BRelation<Integer,Integer> get_RiO(){
		return this.RiO;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.RiO;
	    ensures this.RiO == RiO;*/
	public void set_RiO(BRelation<Integer,Integer> RiO){
		this.RiO = RiO;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PCxA;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PCxA(){
		return this.PCxA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PCxA;
	    ensures this.PCxA == PCxA;*/
	public void set_PCxA(BRelation<Integer,Pair<Integer,Integer>> PCxA){
		this.PCxA = PCxA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.ViO;*/
	public /*@ pure */ BRelation<Integer,Integer> get_ViO(){
		return this.ViO;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.ViO;
	    ensures this.ViO == ViO;*/
	public void set_ViO(BRelation<Integer,Integer> ViO){
		this.ViO = ViO;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.CA;*/
	public /*@ pure */ BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer> get_CA(){
		return this.CA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.CA;
	    ensures this.CA == CA;*/
	public void set_CA(BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer> CA){
		this.CA = CA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PAA1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PAA1(){
		return this.PAA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PAA1;
	    ensures this.PAA1 == PAA1;*/
	public void set_PAA1(BRelation<Integer,Pair<Integer,Integer>> PAA1){
		this.PAA1 = PAA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PCA1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_PCA1(){
		return this.PCA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PCA1;
	    ensures this.PCA1 == PCA1;*/
	public void set_PCA1(BRelation<Integer,Integer> PCA1){
		this.PCA1 = PCA1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.OU;*/
	public /*@ pure */ BRelation<Integer,Integer> get_OU(){
		return this.OU;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.OU;
	    ensures this.OU == OU;*/
	public void set_OU(BRelation<Integer,Integer> OU){
		this.OU = OU;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.Discarded_Request;*/
	public /*@ pure */ BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> get_Discarded_Request(){
		return this.Discarded_Request;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.Discarded_Request;
	    ensures this.Discarded_Request == Discarded_Request;*/
	public void set_Discarded_Request(BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer> Discarded_Request){
		this.Discarded_Request = Discarded_Request;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.CiO1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_CiO1(){
		return this.CiO1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.CiO1;
	    ensures this.CiO1 == CiO1;*/
	public void set_CiO1(BRelation<Integer,Integer> CiO1){
		this.CiO1 = CiO1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.RV1;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_RV1(){
		return this.RV1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.RV1;
	    ensures this.RV1 == RV1;*/
	public void set_RV1(BRelation<Integer,Pair<Integer,Integer>> RV1){
		this.RV1 = RV1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PAA;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PAA(){
		return this.PAA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PAA;
	    ensures this.PAA == PAA;*/
	public void set_PAA(BRelation<Integer,Pair<Integer,Integer>> PAA){
		this.PAA = PAA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.root1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_root1(){
		return this.root1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.root1;
	    ensures this.root1 == root1;*/
	public void set_root1(BRelation<Integer,Integer> root1){
		this.root1 = root1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PVA;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PVA(){
		return this.PVA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PVA;
	    ensures this.PVA == PVA;*/
	public void set_PVA(BRelation<Integer,Pair<Integer,Integer>> PVA){
		this.PVA = PVA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.time;*/
	public /*@ pure */ Integer get_time(){
		return this.time;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.time;
	    ensures this.time == time;*/
	public void set_time(Integer time){
		this.time = time;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.ViO1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_ViO1(){
		return this.ViO1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.ViO1;
	    ensures this.ViO1 == ViO1;*/
	public void set_ViO1(BRelation<Integer,Integer> ViO1){
		this.ViO1 = ViO1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.PRA;*/
	public /*@ pure */ BRelation<Integer,Pair<Integer,Integer>> get_PRA(){
		return this.PRA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.PRA;
	    ensures this.PRA == PRA;*/
	public void set_PRA(BRelation<Integer,Pair<Integer,Integer>> PRA){
		this.PRA = PRA;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.RiO1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_RiO1(){
		return this.RiO1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.RiO1;
	    ensures this.RiO1 == RiO1;*/
	public void set_RiO1(BRelation<Integer,Integer> RiO1){
		this.RiO1 = RiO1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable \nothing;
	    ensures \result == this.UH1;*/
	public /*@ pure */ BRelation<Integer,Integer> get_UH1(){
		return this.UH1;
	}

	/*@ public normal_behavior
	    requires true;
	    assignable this.UH1;
	    ensures this.UH1 == UH1;*/
	public void set_UH1(BRelation<Integer,Integer> UH1){
		this.UH1 = UH1;
	}



	/*@ public normal_behavior
	    requires true;
	    assignable \everything;
	    ensures
		CiO.isEmpty() &&
		(\exists BRelation<Integer,Integer> root_localVar; BRelation.cross(ORG,UNIT).pow().has(root_localVar); root.equals(root_localVar)) &&
		(\exists BRelation<Integer,Integer> OU_localVar; BRelation.cross(UNIT,ORG).pow().has(OU_localVar); OU.equals(OU_localVar)) &&
		AiO.isEmpty() &&
		(\exists BRelation<Integer,Integer> UH_localVar; BRelation.cross(UNIT,UNIT).pow().has(UH_localVar); UH.equals(UH_localVar)) &&
		ViO.isEmpty() &&
		RiO.isEmpty() &&
		(\exists BRelation<Integer,Integer> PCA_localVar; BRelation.cross(PERMISSION,COR).pow().has(PCA_localVar); PCA.equals(PCA_localVar)) &&
		PRA.isEmpty() &&
		EA.isEmpty() &&
		UR.isEmpty() &&
		PAA.isEmpty() &&
		PVA.isEmpty() &&
		PCxA.isEmpty() &&
		AV.isEmpty() &&
		AA.isEmpty() &&
		RV.isEmpty() &&
		root1.isEmpty() &&
		(\exists BRelation<Integer,Integer> OU1_localVar; BRelation.cross(UNIT,ORG).pow().has(OU1_localVar); OU1.equals(OU1_localVar)) &&
		UH1.isEmpty() &&
		CA.isEmpty() &&
		UR1.isEmpty() &&
		RiO1.isEmpty() &&
		EA1.isEmpty() &&
		CA1.isEmpty() &&
		PRA1.isEmpty() &&
		PAA1.isEmpty() &&
		PVA1.isEmpty() &&
		PCA1.isEmpty() &&
		PCxA1.isEmpty() &&
		ViO1.isEmpty() &&
		RV1.isEmpty() &&
		AiO1.isEmpty() &&
		AV1.isEmpty() &&
		AA1.isEmpty() &&
		CiO1.isEmpty() &&
		Access_Requested.isEmpty() &&
		PDistA.isEmpty() &&
		Request_Treated.isEmpty() &&
		PAcA.isEmpty() &&
		time == 0 &&
		at.isEmpty() &&
		PDA.isEmpty() &&
		Discarded_Request.isEmpty() &&
		height.isEmpty() &&
		PATH.isEmpty() &&
		Final_Decision.isEmpty() &&
		Processing_Time.isEmpty() &&
		PAcA1.isEmpty();*/
	public m12(){
		CiO = new BRelation<Integer,Integer>();
		root = Utilities.someVal(BRelation.cross(ORG,UNIT).pow());
		OU = Utilities.someVal(BRelation.cross(UNIT,ORG).pow());
		AiO = new BRelation<Integer,Integer>();
		UH = Utilities.someVal(BRelation.cross(UNIT,UNIT).pow());
		ViO = new BRelation<Integer,Integer>();
		RiO = new BRelation<Integer,Integer>();
		PCA = Utilities.someVal(BRelation.cross(PERMISSION,COR).pow());
		PRA = new BRelation<Integer,Pair<Integer,Integer>>();
		EA = new BRelation<Integer,Integer>();
		UR = new BRelation<Integer,Pair<Integer,Integer>>();
		PAA = new BRelation<Integer,Pair<Integer,Integer>>();
		PVA = new BRelation<Integer,Pair<Integer,Integer>>();
		PCxA = new BRelation<Integer,Pair<Integer,Integer>>();
		AV = new BRelation<Integer,Pair<Integer,Integer>>();
		AA = new BRelation<Integer,Pair<Integer,Integer>>();
		RV = new BRelation<Integer,Pair<Integer,Integer>>();
		root1 = new BRelation<Integer,Integer>();
		OU1 = Utilities.someVal(BRelation.cross(UNIT,ORG).pow());
		UH1 = new BRelation<Integer,Integer>();
		CA = new BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer>();
		UR1 = new BRelation<Integer,Pair<Integer,Integer>>();
		RiO1 = new BRelation<Integer,Integer>();
		EA1 = new BRelation<Integer,Integer>();
		CA1 = new BRelation<Pair<Pair<Integer,Integer>,Integer>,Integer>();
		PRA1 = new BRelation<Integer,Pair<Integer,Integer>>();
		PAA1 = new BRelation<Integer,Pair<Integer,Integer>>();
		PVA1 = new BRelation<Integer,Pair<Integer,Integer>>();
		PCA1 = new BRelation<Integer,Integer>();
		PCxA1 = new BRelation<Integer,Pair<Integer,Integer>>();
		ViO1 = new BRelation<Integer,Integer>();
		RV1 = new BRelation<Integer,Pair<Integer,Integer>>();
		AiO1 = new BRelation<Integer,Integer>();
		AV1 = new BRelation<Integer,Pair<Integer,Integer>>();
		AA1 = new BRelation<Integer,Pair<Integer,Integer>>();
		CiO1 = new BRelation<Integer,Integer>();
		Access_Requested = new BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>();
		PDistA = new BRelation<Integer,Integer>();
		Request_Treated = new BRelation<Pair<Pair<Integer,Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>>,Integer>,Integer>();
		PAcA = new BRelation<Integer,Pair<Integer,Integer>>();
		time = 0;
		at = new BSet<Integer>();
		PDA = new BRelation<Integer,Integer>();
		Discarded_Request = new BRelation<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>();
		height = new BRelation<Integer,Integer>();
		PATH = new BRelation<Integer,Integer>();
		Final_Decision = new BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>();
		Processing_Time = new BRelation<Pair<Pair<Pair<Pair<Pair<Pair<Integer,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>,Integer>();
		PAcA1 = new BRelation<Integer,Pair<Integer,Integer>>();

	}
}