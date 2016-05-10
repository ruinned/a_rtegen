/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl;

import java.util.Collection;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.DisabledInMode;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExcludeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExecutableEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExecutableStartOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Executable Start Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.ExecutableStartOperationImpl#getStartExecutable <em>Start Executable</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.ExecutableStartOperationImpl#getRieaExcludeOperation <em>Riea Exclude Operation</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.ExecutableStartOperationImpl#getDisabledInMode <em>Disabled In Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExecutableStartOperationImpl extends OperationImpl implements ExecutableStartOperation {
	/**
	 * The cached value of the '{@link #getStartExecutable() <em>Start Executable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartExecutable()
	 * @generated
	 * @ordered
	 */
	protected ExecutableEntity startExecutable;

	/**
	 * The cached value of the '{@link #getRieaExcludeOperation() <em>Riea Exclude Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRieaExcludeOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<ExcludeOperation> rieaExcludeOperation;

	/**
	 * The cached value of the '{@link #getDisabledInMode() <em>Disabled In Mode</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisabledInMode()
	 * @generated
	 * @ordered
	 */
	protected EList<DisabledInMode> disabledInMode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutableStartOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModulePackage.Literals.EXECUTABLE_START_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutableEntity getStartExecutable() {
		if (startExecutable != null && ((EObject)startExecutable).eIsProxy()) {
			InternalEObject oldStartExecutable = (InternalEObject)startExecutable;
			startExecutable = (ExecutableEntity)eResolveProxy(oldStartExecutable);
			if (startExecutable != oldStartExecutable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModulePackage.EXECUTABLE_START_OPERATION__START_EXECUTABLE, oldStartExecutable, startExecutable));
			}
		}
		return startExecutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutableEntity basicGetStartExecutable() {
		return startExecutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartExecutable(ExecutableEntity newStartExecutable) {
		ExecutableEntity oldStartExecutable = startExecutable;
		startExecutable = newStartExecutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.EXECUTABLE_START_OPERATION__START_EXECUTABLE, oldStartExecutable, startExecutable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExcludeOperation> getRieaExcludeOperation() {
		if (rieaExcludeOperation == null) {
			rieaExcludeOperation = new EObjectContainmentEList<ExcludeOperation>(ExcludeOperation.class, this, ModulePackage.EXECUTABLE_START_OPERATION__RIEA_EXCLUDE_OPERATION);
		}
		return rieaExcludeOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DisabledInMode> getDisabledInMode() {
		if (disabledInMode == null) {
			disabledInMode = new EObjectContainmentEList<DisabledInMode>(DisabledInMode.class, this, ModulePackage.EXECUTABLE_START_OPERATION__DISABLED_IN_MODE);
		}
		return disabledInMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModulePackage.EXECUTABLE_START_OPERATION__RIEA_EXCLUDE_OPERATION:
				return ((InternalEList<?>)getRieaExcludeOperation()).basicRemove(otherEnd, msgs);
			case ModulePackage.EXECUTABLE_START_OPERATION__DISABLED_IN_MODE:
				return ((InternalEList<?>)getDisabledInMode()).basicRemove(otherEnd, msgs);
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
			case ModulePackage.EXECUTABLE_START_OPERATION__START_EXECUTABLE:
				if (resolve) return getStartExecutable();
				return basicGetStartExecutable();
			case ModulePackage.EXECUTABLE_START_OPERATION__RIEA_EXCLUDE_OPERATION:
				return getRieaExcludeOperation();
			case ModulePackage.EXECUTABLE_START_OPERATION__DISABLED_IN_MODE:
				return getDisabledInMode();
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
			case ModulePackage.EXECUTABLE_START_OPERATION__START_EXECUTABLE:
				setStartExecutable((ExecutableEntity)newValue);
				return;
			case ModulePackage.EXECUTABLE_START_OPERATION__RIEA_EXCLUDE_OPERATION:
				getRieaExcludeOperation().clear();
				getRieaExcludeOperation().addAll((Collection<? extends ExcludeOperation>)newValue);
				return;
			case ModulePackage.EXECUTABLE_START_OPERATION__DISABLED_IN_MODE:
				getDisabledInMode().clear();
				getDisabledInMode().addAll((Collection<? extends DisabledInMode>)newValue);
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
			case ModulePackage.EXECUTABLE_START_OPERATION__START_EXECUTABLE:
				setStartExecutable((ExecutableEntity)null);
				return;
			case ModulePackage.EXECUTABLE_START_OPERATION__RIEA_EXCLUDE_OPERATION:
				getRieaExcludeOperation().clear();
				return;
			case ModulePackage.EXECUTABLE_START_OPERATION__DISABLED_IN_MODE:
				getDisabledInMode().clear();
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
			case ModulePackage.EXECUTABLE_START_OPERATION__START_EXECUTABLE:
				return startExecutable != null;
			case ModulePackage.EXECUTABLE_START_OPERATION__RIEA_EXCLUDE_OPERATION:
				return rieaExcludeOperation != null && !rieaExcludeOperation.isEmpty();
			case ModulePackage.EXECUTABLE_START_OPERATION__DISABLED_IN_MODE:
				return disabledInMode != null && !disabledInMode.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExecutableStartOperationImpl