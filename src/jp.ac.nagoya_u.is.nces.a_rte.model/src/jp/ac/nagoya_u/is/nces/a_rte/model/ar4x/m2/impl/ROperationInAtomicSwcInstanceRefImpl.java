/*
 *  TOPPERS/A-RTEGEN
 *      Automotive Runtime Environment Generator
 *
 *  Copyright (C) 2013-2016 by Eiwa System Management, Inc., JAPAN
 *
 *  上記著作権者は，以下の(1)〜(4)の条件を満たす場合に限り，本ソフトウェ
 *  ア（本ソフトウェアを改変したものを含む．以下同じ）を使用・複製・改
 *  変・再配布（以下，利用と呼ぶ）することを無償で許諾する．
 *  (1) 本ソフトウェアをソースコードの形で利用する場合には，上記の著作
 *      権表示，この利用条件および下記の無保証規定が，そのままの形でソー
 *      スコード中に含まれていること．
 *  (2) 本ソフトウェアを，ライブラリ形式など，他のソフトウェア開発に使
 *      用できる形で再配布する場合には，再配布に伴うドキュメント（利用
 *      者マニュアルなど）に，上記の著作権表示，この利用条件および下記
 *      の無保証規定を掲載すること．
 *  (3) 本ソフトウェアを，機器に組み込むなど，他のソフトウェア開発に使
 *      用できない形で再配布する場合には，次のいずれかの条件を満たすこ
 *      と．
 *    (a) 再配布に伴うドキュメント（利用者マニュアルなど）に，上記の著
 *        作権表示，この利用条件および下記の無保証規定を掲載すること．
 *    (b) 再配布の形態を，別に定める方法によって，TOPPERSプロジェクトに
 *        報告すること．
 *  (4) 本ソフトウェアの利用により直接的または間接的に生じるいかなる損
 *      害からも，上記著作権者およびTOPPERSプロジェクトを免責すること．
 *      また，本ソフトウェアのユーザまたはエンドユーザからのいかなる理
 *      由に基づく請求からも，上記著作権者およびTOPPERSプロジェクトを
 *      免責すること．
 *
 *  本ソフトウェアは，AUTOSAR（AUTomotive Open System ARchitecture）仕
 *  様に基づいている．上記の許諾は，AUTOSARの知的財産権を許諾するもので
 *  はない．AUTOSARは，AUTOSAR仕様に基づいたソフトウェアを商用目的で利
 *  用する者に対して，AUTOSARパートナーになることを求めている．
 *
 *  本ソフトウェアは，無保証で提供されているものである．上記著作権者お
 *  よびTOPPERSプロジェクトは，本ソフトウェアに関して，特定の使用目的
 *  に対する適合性も含めて，いかなる保証も行わない．また，本ソフトウェ
 *  アの利用により直接的または間接的に生じたいかなる損害に関しても，そ
 *  の責任を負わない．
 *
 *  $Id $
 */
/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl;

import java.util.Collection;
import java.util.Collections;

import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.ClientServerOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.IInstanceRef;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.M2Package;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.ROperationInAtomicSwcInstanceRef;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.RPortPrototype;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ROperation In Atomic Swc Instance Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl.ROperationInAtomicSwcInstanceRefImpl#getInstanceRef <em>Instance Ref</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl.ROperationInAtomicSwcInstanceRefImpl#getContextRPort <em>Context RPort</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl.ROperationInAtomicSwcInstanceRefImpl#getTargetRequiredOperation <em>Target Required Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ROperationInAtomicSwcInstanceRefImpl extends M2ObjectImpl implements ROperationInAtomicSwcInstanceRef {
	/**
	 * The cached value of the '{@link #getContextRPort() <em>Context RPort</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextRPort()
	 * @generated
	 * @ordered
	 */
	protected RPortPrototype contextRPort;

	/**
	 * The cached value of the '{@link #getTargetRequiredOperation() <em>Target Required Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRequiredOperation()
	 * @generated
	 * @ordered
	 */
	protected ClientServerOperation targetRequiredOperation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ROperationInAtomicSwcInstanceRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return M2Package.Literals.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<String> getInstanceRef() {
		BasicInternalEList<String> instanceRefs = new BasicInternalEList<String>(String.class);
		Collections.addAll(instanceRefs, getContextRPort().getId(), getTargetRequiredOperation().getId());
		return instanceRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RPortPrototype getContextRPort() {
		if (contextRPort != null && ((EObject)contextRPort).eIsProxy()) {
			InternalEObject oldContextRPort = (InternalEObject)contextRPort;
			contextRPort = (RPortPrototype)eResolveProxy(oldContextRPort);
			if (contextRPort != oldContextRPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__CONTEXT_RPORT, oldContextRPort, contextRPort));
			}
		}
		return contextRPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RPortPrototype basicGetContextRPort() {
		return contextRPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextRPort(RPortPrototype newContextRPort) {
		RPortPrototype oldContextRPort = contextRPort;
		contextRPort = newContextRPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__CONTEXT_RPORT, oldContextRPort, contextRPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerOperation getTargetRequiredOperation() {
		if (targetRequiredOperation != null && ((EObject)targetRequiredOperation).eIsProxy()) {
			InternalEObject oldTargetRequiredOperation = (InternalEObject)targetRequiredOperation;
			targetRequiredOperation = (ClientServerOperation)eResolveProxy(oldTargetRequiredOperation);
			if (targetRequiredOperation != oldTargetRequiredOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__TARGET_REQUIRED_OPERATION, oldTargetRequiredOperation, targetRequiredOperation));
			}
		}
		return targetRequiredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerOperation basicGetTargetRequiredOperation() {
		return targetRequiredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRequiredOperation(ClientServerOperation newTargetRequiredOperation) {
		ClientServerOperation oldTargetRequiredOperation = targetRequiredOperation;
		targetRequiredOperation = newTargetRequiredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__TARGET_REQUIRED_OPERATION, oldTargetRequiredOperation, targetRequiredOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__INSTANCE_REF:
				return getInstanceRef();
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__CONTEXT_RPORT:
				if (resolve) return getContextRPort();
				return basicGetContextRPort();
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__TARGET_REQUIRED_OPERATION:
				if (resolve) return getTargetRequiredOperation();
				return basicGetTargetRequiredOperation();
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
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__INSTANCE_REF:
				getInstanceRef().clear();
				getInstanceRef().addAll((Collection<? extends String>)newValue);
				return;
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__CONTEXT_RPORT:
				setContextRPort((RPortPrototype)newValue);
				return;
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__TARGET_REQUIRED_OPERATION:
				setTargetRequiredOperation((ClientServerOperation)newValue);
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
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__INSTANCE_REF:
				getInstanceRef().clear();
				return;
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__CONTEXT_RPORT:
				setContextRPort((RPortPrototype)null);
				return;
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__TARGET_REQUIRED_OPERATION:
				setTargetRequiredOperation((ClientServerOperation)null);
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
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__INSTANCE_REF:
				return !getInstanceRef().isEmpty();
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__CONTEXT_RPORT:
				return contextRPort != null;
			case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__TARGET_REQUIRED_OPERATION:
				return targetRequiredOperation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IInstanceRef.class) {
			switch (derivedFeatureID) {
				case M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__INSTANCE_REF: return M2Package.IINSTANCE_REF__INSTANCE_REF;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IInstanceRef.class) {
			switch (baseFeatureID) {
				case M2Package.IINSTANCE_REF__INSTANCE_REF: return M2Package.ROPERATION_IN_ATOMIC_SWC_INSTANCE_REF__INSTANCE_REF;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ROperationInAtomicSwcInstanceRefImpl
