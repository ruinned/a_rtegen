/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.tests;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModeMachineInstance;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mode Machine Instance</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModeMachineInstanceTest extends ModuleReferrableTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModeMachineInstanceTest.class);
	}

	/**
	 * Constructs a new Mode Machine Instance test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeMachineInstanceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Mode Machine Instance test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ModeMachineInstance getFixture() {
		return (ModeMachineInstance)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModuleFactory.eINSTANCE.createModeMachineInstance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ModeMachineInstanceTest
