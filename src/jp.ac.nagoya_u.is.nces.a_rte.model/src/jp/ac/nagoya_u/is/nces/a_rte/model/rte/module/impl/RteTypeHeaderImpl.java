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
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl;

import java.util.Collection;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Constant;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteTypeHeader;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rte Type Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.RteTypeHeaderImpl#getRteType <em>Rte Type</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.RteTypeHeaderImpl#getRteTypeConstant <em>Rte Type Constant</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.impl.RteTypeHeaderImpl#getProvidesSignalGroupTransmission <em>Provides Signal Group Transmission</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RteTypeHeaderImpl extends HeaderFileImpl implements RteTypeHeader {
	/**
	 * The cached value of the '{@link #getRteType() <em>Rte Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRteType()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> rteType;
	/**
	 * The cached value of the '{@link #getRteTypeConstant() <em>Rte Type Constant</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRteTypeConstant()
	 * @generated
	 * @ordered
	 */
	protected EList<Constant> rteTypeConstant;
	/**
	 * The default value of the '{@link #getProvidesSignalGroupTransmission() <em>Provides Signal Group Transmission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidesSignalGroupTransmission()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean PROVIDES_SIGNAL_GROUP_TRANSMISSION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getProvidesSignalGroupTransmission() <em>Provides Signal Group Transmission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidesSignalGroupTransmission()
	 * @generated
	 * @ordered
	 */
	protected Boolean providesSignalGroupTransmission = PROVIDES_SIGNAL_GROUP_TRANSMISSION_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteTypeHeaderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModulePackage.Literals.RTE_TYPE_HEADER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getRteType() {
		if (rteType == null) {
			rteType = new EObjectResolvingEList<Type>(Type.class, this, ModulePackage.RTE_TYPE_HEADER__RTE_TYPE);
		}
		return rteType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constant> getRteTypeConstant() {
		if (rteTypeConstant == null) {
			rteTypeConstant = new EObjectResolvingEList<Constant>(Constant.class, this, ModulePackage.RTE_TYPE_HEADER__RTE_TYPE_CONSTANT);
		}
		return rteTypeConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getProvidesSignalGroupTransmission() {
		return providesSignalGroupTransmission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidesSignalGroupTransmission(Boolean newProvidesSignalGroupTransmission) {
		Boolean oldProvidesSignalGroupTransmission = providesSignalGroupTransmission;
		providesSignalGroupTransmission = newProvidesSignalGroupTransmission;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.RTE_TYPE_HEADER__PROVIDES_SIGNAL_GROUP_TRANSMISSION, oldProvidesSignalGroupTransmission, providesSignalGroupTransmission));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModulePackage.RTE_TYPE_HEADER__RTE_TYPE:
				return getRteType();
			case ModulePackage.RTE_TYPE_HEADER__RTE_TYPE_CONSTANT:
				return getRteTypeConstant();
			case ModulePackage.RTE_TYPE_HEADER__PROVIDES_SIGNAL_GROUP_TRANSMISSION:
				return getProvidesSignalGroupTransmission();
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
			case ModulePackage.RTE_TYPE_HEADER__RTE_TYPE:
				getRteType().clear();
				getRteType().addAll((Collection<? extends Type>)newValue);
				return;
			case ModulePackage.RTE_TYPE_HEADER__RTE_TYPE_CONSTANT:
				getRteTypeConstant().clear();
				getRteTypeConstant().addAll((Collection<? extends Constant>)newValue);
				return;
			case ModulePackage.RTE_TYPE_HEADER__PROVIDES_SIGNAL_GROUP_TRANSMISSION:
				setProvidesSignalGroupTransmission((Boolean)newValue);
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
			case ModulePackage.RTE_TYPE_HEADER__RTE_TYPE:
				getRteType().clear();
				return;
			case ModulePackage.RTE_TYPE_HEADER__RTE_TYPE_CONSTANT:
				getRteTypeConstant().clear();
				return;
			case ModulePackage.RTE_TYPE_HEADER__PROVIDES_SIGNAL_GROUP_TRANSMISSION:
				setProvidesSignalGroupTransmission(PROVIDES_SIGNAL_GROUP_TRANSMISSION_EDEFAULT);
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
			case ModulePackage.RTE_TYPE_HEADER__RTE_TYPE:
				return rteType != null && !rteType.isEmpty();
			case ModulePackage.RTE_TYPE_HEADER__RTE_TYPE_CONSTANT:
				return rteTypeConstant != null && !rteTypeConstant.isEmpty();
			case ModulePackage.RTE_TYPE_HEADER__PROVIDES_SIGNAL_GROUP_TRANSMISSION:
				return PROVIDES_SIGNAL_GROUP_TRANSMISSION_EDEFAULT == null ? providesSignalGroupTransmission != null : !PROVIDES_SIGNAL_GROUP_TRANSMISSION_EDEFAULT.equals(providesSignalGroupTransmission);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (providesSignalGroupTransmission: "); //$NON-NLS-1$
		result.append(providesSignalGroupTransmission);
		result.append(')');
		return result.toString();
	}

} //RteTypeHeaderImpl
