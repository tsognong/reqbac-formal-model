package req_bac_sequential;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import eventb_prelude.BSet;
import eventb_prelude.Pair;

public class Reqbacm0Test {
	private reqbacm3 m3;

	@Before
	public void setUp() throws Exception {
		m3 = new reqbacm3();
		
		BSet<Integer> units_tmp = m3.get_units();
		m3.set_organizations(new BSet<Integer>(1));

		m3.set_admin_units(new BSet<Integer>(1, 2, 3, 4));
		m3.set_operational_units(new BSet<Integer>(5));

		// m0.set_units(units_tmp.union(m0.get_operational_units()).union(m0.get_admin_units()));

		m3.set_units(m3.get_operational_units().union(m3.get_admin_units()));

		m3.set_employees(new BSet<Integer>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		m3.evt_add_hierarchy.run_add_hierarchy(4, 5);
		m3.evt_add_hierarchy.run_add_hierarchy(3, 4);
		m3.evt_add_hierarchy.run_add_hierarchy(2, 3);
		m3.evt_add_hierarchy.run_add_hierarchy(1, 2);


		m3.evt_add_appointment.run_add_appointment(1, 1, 1);
		m3.evt_add_appointment.run_add_appointment(2, 1, 2);
		m3.evt_add_appointment.run_add_appointment(3, 1, 3);
		m3.evt_add_appointment.run_add_appointment(4, 1, 4);

		m3.evt_add_employment.run_add_employment(5, 1, 5);
		m3.evt_add_employment.run_add_employment(6, 1, 5);
		m3.evt_add_employment.run_add_employment(7, 1, 5);
		m3.evt_add_employment.run_add_employment(8, 1, 5);
		m3.evt_add_employment.run_add_employment(9, 1, 5);
		m3.evt_add_employment.run_add_employment(10, 1, 5);

		// activities and actions
		m3.set_actions(new BSet<Integer>(1, 2, 3));
		m3.set_activities(new BSet<Integer>(1, 2, 3));
		// resources and views
		m3.set_resources(new BSet<Integer>(1, 2));
		m3.set_views(new BSet<Integer>(1, 2));
		// contexts
		m3.set_contexts(new BSet<Integer>(1, 2, 3, 4, 5));
		// considers
		m3.evt_add_consider_relation.run_add_consider_relation(1, 1);
		m3.evt_add_consider_relation.run_add_consider_relation(2, 2);
		m3.evt_add_consider_relation.run_add_consider_relation(3, 3);
		// uses
		m3.evt_add_uses_relation.run_add_uses_relation(1, 1);
		m3.evt_add_uses_relation.run_add_uses_relation(2, 2);
		
		// defines
		m3.evt_add_defines_relation.run_add_defines_relation(1, new BSet<Integer>(1, 2, 3), 1, 1);
		m3.evt_add_defines_relation.run_add_defines_relation(1, new BSet<Integer>(1, 2), 2, 1);

		m3.evt_add_defines_relation.run_add_defines_relation(1, new BSet<Integer>(1, 2), 3, 1);

		m3.evt_add_defines_relation.run_add_defines_relation(1, new BSet<Integer>(1, 2), 4, 1);
		
		m3.evt_add_defines_relation.run_add_defines_relation(1, new BSet<Integer>(1, 2), 5, 1);

		m3.evt_add_defines_relation.run_add_defines_relation(1, new BSet<Integer>(1, 2), 6, 1);
		
		m3.evt_add_defines_relation.run_add_defines_relation(1, new BSet<Integer>(1, 2), 7, 1);
		
		m3.evt_add_defines_relation.run_add_defines_relation(2, new BSet<Integer>(2), 8, 2);
		
		m3.evt_add_defines_relation.run_add_defines_relation(2, new BSet<Integer>(2), 2, 2);
		
		m3.evt_add_defines_relation.run_add_defines_relation(3, new BSet<Integer>(2), 9, 2);
		
		m3.evt_add_defines_relation.run_add_defines_relation(3, new BSet<Integer>(2), 10, 2);

		m3.evt_add_defines_relation.run_add_defines_relation(3, new BSet<Integer>(2), 2, 2);
		// operational permissions
		m3.evt_add_operational_permissions.run_add_operational_permissions(1, new BSet<Integer>(1, 2), 2, 5, 1);
		m3.evt_add_operational_permissions.run_add_operational_permissions(2, new BSet<Integer>(2), 2, 5, 2);
		m3.evt_add_operational_permissions.run_add_operational_permissions(3, new BSet<Integer>(2), 2, 5, 2);

		m3.evt_add_admin_permission.run_add_admin_permission(1, new BSet<Integer>(1, 2, 3), 1, 1, 5, 1);
		
		m3.evt_add_admin_permission.run_add_admin_permission(1, new BSet<Integer>(1, 2), 2, 2, 5, 1);
		m3.evt_add_admin_permission.run_add_admin_permission(1, new BSet<Integer>(1, 2), 2, 3, 5, 1);
		m3.evt_add_admin_permission.run_add_admin_permission(1, new BSet<Integer>(1, 2), 2, 4, 5, 1);
		
		m3.evt_add_admin_permission.run_add_admin_permission(2, new BSet<Integer>(2), 1, 2, 5, 2);
		
		m3.evt_add_admin_permission.run_add_admin_permission(3, new BSet<Integer>(2), 1, 2, 5, 2);
	}

	@Test
	@Order(1)

	public void test_add_hierarchy() {
		assertEquals(m3.get_units_hierarchies().size(), 4);
		assertEquals(m3.transitive_closure(m3.get_units_hierarchies()).size(), 10);
	}

	@Test
	@Order(2)
	public void test_add_appointment() {
		 assertEquals(m3.get_appoints().size(), 4);		 
	}

	@Test
	@Order(3)
	public void test_add_employement() {
		assertEquals(m3.get_employs().size(), 6);	
	}

	@Test
	public void test_add_consider_relation() {
		assertEquals(m3.get_consider().size(), 3);	
	}



	@Test
	public void test_add_uses_relation() {
		
		assertEquals(m3.get_uses().size(), 2);
		
	}

	@Test
	public void test_add_defines_relation() {
		
		assertEquals(m3.get_defines().size(), 12);
	}

	@Test
	public void test_add_operational_permissions() {
		assertEquals(m3.get_operational_permissions().size(), 3);
	}

	@Test
	
	public void test_add_administrative_permissions() {
		assertEquals(m3.get_administrative_permissions().size(), 6);
	}

	@Test
	public void test_emit_request() {
		assertFalse(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1, 2), 1, 1, 1));
		assertFalse(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1), 2, 1, 2));
		assertFalse(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1), 3, 1, 3));
		assertFalse(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1,2), 4, 1, 4));
		
		assertTrue(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1, 2), 5, 1, 1));
		m3.evt_emit_request.run_emit_request(1, new BSet<Integer>(1, 2), 5, 1, 1);
		assertEquals(m3.get_emitted_requests().size(), 1);
		
		assertTrue(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1, 2), 6, 1, 1));
		assertFalse(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1,5), 7, 1, 1));
		assertFalse(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1,2), 8, 1, 1));
		assertFalse(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(5), 9, 1, 1));
		assertFalse(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1, 2), 10, 1, 1));
		
		
		
		
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 1, 2, 12));
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 2, 2, 13));
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 3, 2, 14));
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 9, 4, 15));
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 5, 2, 16));
		
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 6, 2, 12));
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 7, 2, 13));
		assertTrue(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 8, 2, 14));
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 9, 9, 15));
		assertFalse(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 10, 2, 16));
		
		
		
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 1, 2, 20));
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 2, 2, 13));
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 3, 2, 14));
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 9, 4, 15));
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 5, 2, 16));
		
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 6, 2, 12));
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 7, 2, 13));
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 8, 2, 14));
		assertFalse(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 9, 9, 15));
		assertTrue(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 10, 2, 16));
	}

	@Test
	public void test_treat_request() {		
		
		assertTrue(m3.evt_emit_request.guard_emit_request(1, new BSet<Integer>(1, 2), 5, 1, 6));
		m3.evt_emit_request.run_emit_request(1, new BSet<Integer>(1, 2), 5, 1, 6);
		assertEquals(m3.get_emitted_requests().size(), 1);
		
		assertTrue(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2), 2, 4, 7, 6));
		m3.evt_treat_request.run_treat_request_lite(new BSet<Integer>(1, 2), 2, 4, 7, 6);
		assertEquals(m3.get_treated_requests().size(), 1);
		
		assertTrue(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2), 3, 3, 8, 6));
		m3.evt_treat_request.run_treat_request_lite(new BSet<Integer>(1, 2), 3, 3, 8, 6);
		assertEquals(m3.get_treated_requests().size(), 2);
		
		assertTrue(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2), 3, 2, 9, 6));
		m3.evt_treat_request.run_treat_request_lite(new BSet<Integer>(1, 2), 3, 2, 9, 6);
		assertEquals(m3.get_treated_requests().size(), 3);
		
		assertTrue(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2, 3), 3, 1, 10, 6));
		m3.evt_treat_request.run_treat_request_lite(new BSet<Integer>(1, 2, 3), 3, 1, 10, 6);
		assertEquals(m3.get_treated_requests().size(), 4);

		m3.evt_evaluate_decision_with_mhd.run_evaluate_decision_with_mhd_lite(6);

		//m3.evt_evaluate_decision_with_lhd.run_evaluate_decision_with_lhd_lite(6);
		
		assertEquals(m3.get_decision(6).intValue(), 3);
		
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2, 3), 2, 5, 11, 6));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2, 3), 2, 6, 11, 6));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2, 3), 2, 7, 11, 6));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2, 3), 2, 8, 11, 6));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2, 3), 2, 9, 11, 6));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(1, 2, 3), 2, 10, 11, 6));
		
		assertTrue(m3.evt_emit_request.guard_emit_request(2, new BSet<Integer>(2), 8, 2, 12));
		m3.evt_emit_request.run_emit_request(2, new BSet<Integer>(2), 8, 2, 12);
		assertEquals(m3.get_emitted_requests().size(), 2);
		
		
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 1, 19, 12));
		assertTrue(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 2, 20, 12));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 3, 21, 12));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 4, 22, 12));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 5, 23, 12));
		
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 5, 13, 12));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 6, 14, 12));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 7, 15, 12));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 8, 16, 12));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 9, 17, 12));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 10, 18, 12));
		
		
		assertTrue(m3.evt_emit_request.guard_emit_request(3, new BSet<Integer>(2), 10, 2, 50));
		m3.evt_emit_request.run_emit_request(3, new BSet<Integer>(2), 10, 2, 50);
		assertEquals(m3.get_emitted_requests().size(), 3);
		
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 1, 51, 50));
		assertTrue(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 2, 51, 50));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 3, 51, 50));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 4, 51, 50));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 5, 51, 50));
		
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 5, 51, 50));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 6, 51, 50));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 7, 51, 50));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 8, 51, 50));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 9, 51, 50));
		assertFalse(m3.evt_treat_request.guard_treat_request_lite(new BSet<Integer>(2), 2, 10, 51, 50));
	}

}
