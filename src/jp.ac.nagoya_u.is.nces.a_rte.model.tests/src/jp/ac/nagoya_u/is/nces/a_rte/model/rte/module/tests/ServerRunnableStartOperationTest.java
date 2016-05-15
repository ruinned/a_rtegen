/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.tests;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleFactory;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ServerRunnableStartOperation;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Server Runnable Start Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ServerRunnableStartOperation#getStartServerRunnable() <em>Start Server Runnable</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ServerRunnableStartOperationTest extends ExecutableStartOperationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ServerRunnableStartOperationTest.class);
	}

	/**
	 * Constructs a new Server Runnable Start Operation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerRunnableStartOperationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Server Runnable Start Operation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ServerRunnableStartOperation getFixture() {
		return (ServerRunnableStartOperation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModuleFactory.eINSTANCE.createServerRunnableStartOperation());
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

	/**
	 * Tests the '{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ServerRunnableStartOperation#getStartServerRunnable() <em>Start Server Runnable</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ServerRunnableStartOperation#getStartServerRunnable()
	 * @generated
	 */
	public void testGetStartServerRunnable() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //ServerRunnableStartOperationTest
