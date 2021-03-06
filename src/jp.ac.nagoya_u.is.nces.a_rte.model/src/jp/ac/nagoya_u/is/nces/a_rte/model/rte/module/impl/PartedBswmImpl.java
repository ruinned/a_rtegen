/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl;

import java.util.Collection;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.BswMemoryMapping;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.BswSchedulableEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Bswm;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModeMachineInstance;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.PartedBswm;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Partition;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmApi;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parted Bswm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.PartedBswmImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.PartedBswmImpl#getBswm <em>Bswm</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.PartedBswmImpl#getBswMemoryMapping <em>Bsw Memory Mapping</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.PartedBswmImpl#getDependentBswSchedulableEntity <em>Dependent Bsw Schedulable Entity</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.PartedBswmImpl#getModeMachineInstance <em>Mode Machine Instance</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.PartedBswmImpl#getSchmApi <em>Schm Api</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartedBswmImpl extends LogicalCompartmentImpl implements PartedBswm {
	/**
	 * The cached value of the '{@link #getBswm() <em>Bswm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBswm()
	 * @generated
	 * @ordered
	 */
	protected Bswm bswm;

	/**
	 * The cached value of the '{@link #getBswMemoryMapping() <em>Bsw Memory Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBswMemoryMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<BswMemoryMapping> bswMemoryMapping;

	/**
	 * The cached value of the '{@link #getDependentBswSchedulableEntity() <em>Dependent Bsw Schedulable Entity</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependentBswSchedulableEntity()
	 * @generated
	 * @ordered
	 */
	protected EList<BswSchedulableEntity> dependentBswSchedulableEntity;

	/**
	 * The cached value of the '{@link #getModeMachineInstance() <em>Mode Machine Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeMachineInstance()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeMachineInstance> modeMachineInstance;

	/**
	 * The cached value of the '{@link #getSchmApi() <em>Schm Api</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchmApi()
	 * @generated
	 * @ordered
	 */
	protected EList<SchmApi> schmApi;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartedBswmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModulePackage.Literals.PARTED_BSWM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partition getParent() {
		if (eContainerFeatureID() != ModulePackage.PARTED_BSWM__PARENT) return null;
		return (Partition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Partition newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, ModulePackage.PARTED_BSWM__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Partition newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != ModulePackage.PARTED_BSWM__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, ModulePackage.PARTITION__PARTED_BSWM, Partition.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.PARTED_BSWM__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bswm getBswm() {
		if (bswm != null && ((EObject)bswm).eIsProxy()) {
			InternalEObject oldBswm = (InternalEObject)bswm;
			bswm = (Bswm)eResolveProxy(oldBswm);
			if (bswm != oldBswm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModulePackage.PARTED_BSWM__BSWM, oldBswm, bswm));
			}
		}
		return bswm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bswm basicGetBswm() {
		return bswm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBswm(Bswm newBswm, NotificationChain msgs) {
		Bswm oldBswm = bswm;
		bswm = newBswm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModulePackage.PARTED_BSWM__BSWM, oldBswm, newBswm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBswm(Bswm newBswm) {
		if (newBswm != bswm) {
			NotificationChain msgs = null;
			if (bswm != null)
				msgs = ((InternalEObject)bswm).eInverseRemove(this, ModulePackage.BSWM__PARTED_BSWM, Bswm.class, msgs);
			if (newBswm != null)
				msgs = ((InternalEObject)newBswm).eInverseAdd(this, ModulePackage.BSWM__PARTED_BSWM, Bswm.class, msgs);
			msgs = basicSetBswm(newBswm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.PARTED_BSWM__BSWM, newBswm, newBswm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BswMemoryMapping> getBswMemoryMapping() {
		if (bswMemoryMapping == null) {
			bswMemoryMapping = new EObjectContainmentEList<BswMemoryMapping>(BswMemoryMapping.class, this, ModulePackage.PARTED_BSWM__BSW_MEMORY_MAPPING);
		}
		return bswMemoryMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BswSchedulableEntity> getDependentBswSchedulableEntity() {
		if (dependentBswSchedulableEntity == null) {
			dependentBswSchedulableEntity = new EObjectContainmentWithInverseEList<BswSchedulableEntity>(BswSchedulableEntity.class, this, ModulePackage.PARTED_BSWM__DEPENDENT_BSW_SCHEDULABLE_ENTITY, ModulePackage.BSW_SCHEDULABLE_ENTITY__PARENT_PARTED_BSWM);
		}
		return dependentBswSchedulableEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeMachineInstance> getModeMachineInstance() {
		if (modeMachineInstance == null) {
			modeMachineInstance = new EObjectContainmentEList<ModeMachineInstance>(ModeMachineInstance.class, this, ModulePackage.PARTED_BSWM__MODE_MACHINE_INSTANCE);
		}
		return modeMachineInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchmApi> getSchmApi() {
		if (schmApi == null) {
			schmApi = new EObjectContainmentWithInverseEList<SchmApi>(SchmApi.class, this, ModulePackage.PARTED_BSWM__SCHM_API, ModulePackage.SCHM_API__PARENT);
		}
		return schmApi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModulePackage.PARTED_BSWM__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Partition)otherEnd, msgs);
			case ModulePackage.PARTED_BSWM__BSWM:
				if (bswm != null)
					msgs = ((InternalEObject)bswm).eInverseRemove(this, ModulePackage.BSWM__PARTED_BSWM, Bswm.class, msgs);
				return basicSetBswm((Bswm)otherEnd, msgs);
			case ModulePackage.PARTED_BSWM__DEPENDENT_BSW_SCHEDULABLE_ENTITY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependentBswSchedulableEntity()).basicAdd(otherEnd, msgs);
			case ModulePackage.PARTED_BSWM__SCHM_API:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSchmApi()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModulePackage.PARTED_BSWM__PARENT:
				return basicSetParent(null, msgs);
			case ModulePackage.PARTED_BSWM__BSWM:
				return basicSetBswm(null, msgs);
			case ModulePackage.PARTED_BSWM__BSW_MEMORY_MAPPING:
				return ((InternalEList<?>)getBswMemoryMapping()).basicRemove(otherEnd, msgs);
			case ModulePackage.PARTED_BSWM__DEPENDENT_BSW_SCHEDULABLE_ENTITY:
				return ((InternalEList<?>)getDependentBswSchedulableEntity()).basicRemove(otherEnd, msgs);
			case ModulePackage.PARTED_BSWM__MODE_MACHINE_INSTANCE:
				return ((InternalEList<?>)getModeMachineInstance()).basicRemove(otherEnd, msgs);
			case ModulePackage.PARTED_BSWM__SCHM_API:
				return ((InternalEList<?>)getSchmApi()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModulePackage.PARTED_BSWM__PARENT:
				return eInternalContainer().eInverseRemove(this, ModulePackage.PARTITION__PARTED_BSWM, Partition.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModulePackage.PARTED_BSWM__PARENT:
				return getParent();
			case ModulePackage.PARTED_BSWM__BSWM:
				if (resolve) return getBswm();
				return basicGetBswm();
			case ModulePackage.PARTED_BSWM__BSW_MEMORY_MAPPING:
				return getBswMemoryMapping();
			case ModulePackage.PARTED_BSWM__DEPENDENT_BSW_SCHEDULABLE_ENTITY:
				return getDependentBswSchedulableEntity();
			case ModulePackage.PARTED_BSWM__MODE_MACHINE_INSTANCE:
				return getModeMachineInstance();
			case ModulePackage.PARTED_BSWM__SCHM_API:
				return getSchmApi();
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
			case ModulePackage.PARTED_BSWM__PARENT:
				setParent((Partition)newValue);
				return;
			case ModulePackage.PARTED_BSWM__BSWM:
				setBswm((Bswm)newValue);
				return;
			case ModulePackage.PARTED_BSWM__BSW_MEMORY_MAPPING:
				getBswMemoryMapping().clear();
				getBswMemoryMapping().addAll((Collection<? extends BswMemoryMapping>)newValue);
				return;
			case ModulePackage.PARTED_BSWM__DEPENDENT_BSW_SCHEDULABLE_ENTITY:
				getDependentBswSchedulableEntity().clear();
				getDependentBswSchedulableEntity().addAll((Collection<? extends BswSchedulableEntity>)newValue);
				return;
			case ModulePackage.PARTED_BSWM__MODE_MACHINE_INSTANCE:
				getModeMachineInstance().clear();
				getModeMachineInstance().addAll((Collection<? extends ModeMachineInstance>)newValue);
				return;
			case ModulePackage.PARTED_BSWM__SCHM_API:
				getSchmApi().clear();
				getSchmApi().addAll((Collection<? extends SchmApi>)newValue);
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
			case ModulePackage.PARTED_BSWM__PARENT:
				setParent((Partition)null);
				return;
			case ModulePackage.PARTED_BSWM__BSWM:
				setBswm((Bswm)null);
				return;
			case ModulePackage.PARTED_BSWM__BSW_MEMORY_MAPPING:
				getBswMemoryMapping().clear();
				return;
			case ModulePackage.PARTED_BSWM__DEPENDENT_BSW_SCHEDULABLE_ENTITY:
				getDependentBswSchedulableEntity().clear();
				return;
			case ModulePackage.PARTED_BSWM__MODE_MACHINE_INSTANCE:
				getModeMachineInstance().clear();
				return;
			case ModulePackage.PARTED_BSWM__SCHM_API:
				getSchmApi().clear();
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
			case ModulePackage.PARTED_BSWM__PARENT:
				return getParent() != null;
			case ModulePackage.PARTED_BSWM__BSWM:
				return bswm != null;
			case ModulePackage.PARTED_BSWM__BSW_MEMORY_MAPPING:
				return bswMemoryMapping != null && !bswMemoryMapping.isEmpty();
			case ModulePackage.PARTED_BSWM__DEPENDENT_BSW_SCHEDULABLE_ENTITY:
				return dependentBswSchedulableEntity != null && !dependentBswSchedulableEntity.isEmpty();
			case ModulePackage.PARTED_BSWM__MODE_MACHINE_INSTANCE:
				return modeMachineInstance != null && !modeMachineInstance.isEmpty();
			case ModulePackage.PARTED_BSWM__SCHM_API:
				return schmApi != null && !schmApi.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PartedBswmImpl
