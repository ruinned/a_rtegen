/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferNonqueuedReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferVariableSet;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rte Buffer Nonqueued Read Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.RteBufferNonqueuedReadOperationImpl#getAccessVariable <em>Access Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RteBufferNonqueuedReadOperationImpl extends ReadOperationImpl implements RteBufferNonqueuedReadOperation {
	/**
	 * The cached value of the '{@link #getAccessVariable() <em>Access Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessVariable()
	 * @generated
	 * @ordered
	 */
	protected RteBufferVariableSet accessVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteBufferNonqueuedReadOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModulePackage.Literals.RTE_BUFFER_NONQUEUED_READ_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RteBufferVariableSet getAccessVariable() {
		if (accessVariable != null && ((EObject)accessVariable).eIsProxy()) {
			InternalEObject oldAccessVariable = (InternalEObject)accessVariable;
			accessVariable = (RteBufferVariableSet)eResolveProxy(oldAccessVariable);
			if (accessVariable != oldAccessVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModulePackage.RTE_BUFFER_NONQUEUED_READ_OPERATION__ACCESS_VARIABLE, oldAccessVariable, accessVariable));
			}
		}
		return accessVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RteBufferVariableSet basicGetAccessVariable() {
		return accessVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessVariable(RteBufferVariableSet newAccessVariable) {
		RteBufferVariableSet oldAccessVariable = accessVariable;
		accessVariable = newAccessVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.RTE_BUFFER_NONQUEUED_READ_OPERATION__ACCESS_VARIABLE, oldAccessVariable, accessVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModulePackage.RTE_BUFFER_NONQUEUED_READ_OPERATION__ACCESS_VARIABLE:
				if (resolve) return getAccessVariable();
				return basicGetAccessVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModulePackage.RTE_BUFFER_NONQUEUED_READ_OPERATION__ACCESS_VARIABLE:
				setAccessVariable((RteBufferVariableSet)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModulePackage.RTE_BUFFER_NONQUEUED_READ_OPERATION__ACCESS_VARIABLE:
				setAccessVariable((RteBufferVariableSet)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModulePackage.RTE_BUFFER_NONQUEUED_READ_OPERATION__ACCESS_VARIABLE:
				return accessVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //RteBufferNonqueuedReadOperationImpl
