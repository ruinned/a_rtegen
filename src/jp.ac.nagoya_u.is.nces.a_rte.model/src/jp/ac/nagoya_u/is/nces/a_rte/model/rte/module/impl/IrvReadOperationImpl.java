/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExcludeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IrvReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferVariableSet;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Irv Read Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.IrvReadOperationImpl#getAccessVariable <em>Access Variable</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.IrvReadOperationImpl#getReadValueVariable <em>Read Value Variable</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.IrvReadOperationImpl#getExcludeOperation <em>Exclude Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IrvReadOperationImpl extends OperationImpl implements IrvReadOperation {
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
	 * The cached value of the '{@link #getReadValueVariable() <em>Read Value Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadValueVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable readValueVariable;

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
	protected IrvReadOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModulePackage.Literals.IRV_READ_OPERATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModulePackage.IRV_READ_OPERATION__ACCESS_VARIABLE, oldAccessVariable, accessVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.IRV_READ_OPERATION__ACCESS_VARIABLE, oldAccessVariable, accessVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getReadValueVariable() {
		if (readValueVariable != null && ((EObject)readValueVariable).eIsProxy()) {
			InternalEObject oldReadValueVariable = (InternalEObject)readValueVariable;
			readValueVariable = (Variable)eResolveProxy(oldReadValueVariable);
			if (readValueVariable != oldReadValueVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModulePackage.IRV_READ_OPERATION__READ_VALUE_VARIABLE, oldReadValueVariable, readValueVariable));
			}
		}
		return readValueVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetReadValueVariable() {
		return readValueVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadValueVariable(Variable newReadValueVariable) {
		Variable oldReadValueVariable = readValueVariable;
		readValueVariable = newReadValueVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.IRV_READ_OPERATION__READ_VALUE_VARIABLE, oldReadValueVariable, readValueVariable));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION, oldExcludeOperation, newExcludeOperation);
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
				msgs = ((InternalEObject)excludeOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION, null, msgs);
			if (newExcludeOperation != null)
				msgs = ((InternalEObject)newExcludeOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION, null, msgs);
			msgs = basicSetExcludeOperation(newExcludeOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION, newExcludeOperation, newExcludeOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION:
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
			case ModulePackage.IRV_READ_OPERATION__ACCESS_VARIABLE:
				if (resolve) return getAccessVariable();
				return basicGetAccessVariable();
			case ModulePackage.IRV_READ_OPERATION__READ_VALUE_VARIABLE:
				if (resolve) return getReadValueVariable();
				return basicGetReadValueVariable();
			case ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION:
				return getExcludeOperation();
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
			case ModulePackage.IRV_READ_OPERATION__ACCESS_VARIABLE:
				setAccessVariable((RteBufferVariableSet)newValue);
				return;
			case ModulePackage.IRV_READ_OPERATION__READ_VALUE_VARIABLE:
				setReadValueVariable((Variable)newValue);
				return;
			case ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION:
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
			case ModulePackage.IRV_READ_OPERATION__ACCESS_VARIABLE:
				setAccessVariable((RteBufferVariableSet)null);
				return;
			case ModulePackage.IRV_READ_OPERATION__READ_VALUE_VARIABLE:
				setReadValueVariable((Variable)null);
				return;
			case ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION:
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
			case ModulePackage.IRV_READ_OPERATION__ACCESS_VARIABLE:
				return accessVariable != null;
			case ModulePackage.IRV_READ_OPERATION__READ_VALUE_VARIABLE:
				return readValueVariable != null;
			case ModulePackage.IRV_READ_OPERATION__EXCLUDE_OPERATION:
				return excludeOperation != null;
		}
		return super.eIsSet(featureID);
	}

} //IrvReadOperationImpl
