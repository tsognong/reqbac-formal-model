package Test_sequential; 

import eventb_prelude.*;
import Util.Utilities;

public class tick_tock{
	/*@ spec_public */ private m12 machine; // reference to the machine 

	/*@ public normal_behavior
		requires true;
		assignable \everything;
		ensures this.machine == m; */
	public tick_tock(m12 m) {
		this.machine = m;
	}

	/*@ public normal_behavior
		requires true;
 		assignable \nothing;
		ensures \result <==> NAT.instance.has(tm) && (tm).compareTo(machine.get_time()) > 0 && ((!machine.get_at().equals(BSet.EMPTY)) ==> ((tm).compareTo(machine.get_at().min()) <= 0)); */
	public /*@ pure */ boolean guard_tick_tock( Integer tm) {
		return NAT.instance.has(tm) && (tm).compareTo(machine.get_time()) > 0 && BOOL.implication(!machine.get_at().equals(BSet.EMPTY),(tm).compareTo(machine.get_at().min()) <= 0);
	}

	/*@ public normal_behavior
		requires guard_tick_tock(tm);
		assignable machine.time;
		ensures guard_tick_tock(tm) &&  machine.get_time() == \old(tm); 
	 also
		requires !guard_tick_tock(tm);
		assignable \nothing;
		ensures true; */
	public void run_tick_tock( Integer tm){
		if(guard_tick_tock(tm)) {
			Integer time_tmp = machine.get_time();

			machine.set_time(tm);

			System.out.println("tick_tock executed tm: " + tm + " ");
		}
	}

}
