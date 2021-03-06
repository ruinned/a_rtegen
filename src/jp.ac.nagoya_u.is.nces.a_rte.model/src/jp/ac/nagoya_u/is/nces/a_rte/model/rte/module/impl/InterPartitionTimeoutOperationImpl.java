/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl;

import java.util.Collection;

import jp.ac.nagoya_u.is.nces.a_rte.model.ExtendedEObjectImpl;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExcludeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.InterPartitionTimeoutOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferVariableSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inter Partition Timeout Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.InterPartitionTimeoutOperationImpl#getTimeoutVariable <em>Timeout Variable</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.InterPartitionTimeoutOperationImpl#getExcludeOperation <em>Exclude Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterPartitionTimeoutOperationImpl extends ExtendedEObjectImpl implements InterPartitionTimeoutOperation {
	/**
	 * The cached value of the '{@link #getTimeoutVariable() <em>Timeout Variable</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeoutVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<RteBufferVariableSet> timeoutVariable;

	/**
	 * The cached value of the '{@link #getExcludeOperation() <em>Exclude Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludeOperation()
	 * @generated
	 * @ordered
	 */
	protected ExcludeOperation excludeOperation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterPartitionTimeoutOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModulePackage.Literals.INTER_PARTITION_TIMEOUT_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RteBufferVariableSet> getTimeoutVariable() {
		if (timeoutVariable == null) {
			timeoutVariable = new EObjectResolvingEList<RteBufferVariableSet>(RteBufferVariableSet.class, this, ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__TIMEOUT_VARIABLE);
		}
		return timeoutVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcludeOperation getExcludeOperation() {
		return excludeOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExcludeOperation(ExcludeOperation newExcludeOperation, NotificationChain msgs) {
		ExcludeOperation oldExcludeOperation = excludeOperation;
		excludeOperation = newExcludeOperation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION, oldExcludeOperation, newExcludeOperation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExcludeOperation(ExcludeOperation newExcludeOperation) {
		if (newExcludeOperation != excludeOperation) {
			NotificationChain msgs = null;
			if (excludeOperation != null)
				msgs = ((InternalEObject)excludeOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION, null, msgs);
			if (newExcludeOperation != null)
				msgs = ((InternalEObject)newExcludeOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION, null, msgs);
			msgs = basicSetExcludeOperation(newExcludeOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION, newExcludeOperation, newExcludeOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION:
				return basicSetExcludeOperation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__TIMEOUT_VARIABLE:
				return getTimeoutVariable();
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION:
				return getExcludeOperation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__TIMEOUT_VARIABLE:
				getTimeoutVariable().clear();
				getTimeoutVariable().addAll((Collection<? extends RteBufferVariableSet>)newValue);
				return;
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION:
				setExcludeOperation((ExcludeOperation)newValue);
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
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__TIMEOUT_VARIABLE:
				getTimeoutVariable().clear();
				return;
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION:
				setExcludeOperation((ExcludeOperation)null);
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
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__TIMEOUT_VARIABLE:
				return timeoutVariable != null && !timeoutVariable.isEmpty();
			case ModulePackage.INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION:
				return excludeOperation != null;
		}
		return super.eIsSet(featureID);
	}

} //InterPartitionTimeoutOperationImpl
