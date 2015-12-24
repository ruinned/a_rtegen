/*
 *  TOPPERS/A-RTEGEN
 *      Automotive Runtime Environment Generator
 *
 *  Copyright (C) 2013-2015 by Eiwa System Management, Inc., JAPAN
 *
 *  �嵭����Ԥϡ��ʲ���(1)��(4)�ξ������������˸¤ꡤ�ܥ��եȥ���
 *  �����ܥ��եȥ���������Ѥ�����Τ�ޤࡥ�ʲ�Ʊ���ˤ���ѡ�ʣ������
 *  �ѡ������ۡʰʲ������ѤȸƤ֡ˤ��뤳�Ȥ�̵���ǵ������롥
 *  (1) �ܥ��եȥ������򥽡��������ɤη������Ѥ�����ˤϡ��嵭������
 *      ��ɽ�����������Ѿ�浪��Ӳ�����̵�ݾڵ��꤬�����Τޤޤη��ǥ���
 *      ����������˴ޤޤ�Ƥ��뤳�ȡ�
 *  (2) �ܥ��եȥ������򡤥饤�֥������ʤɡ�¾�Υ��եȥ�������ȯ�˻�
 *      �ѤǤ�����Ǻ����ۤ�����ˤϡ������ۤ�ȼ���ɥ�����ȡ�����
 *      �ԥޥ˥奢��ʤɡˤˡ��嵭�����ɽ�����������Ѿ�浪��Ӳ���
 *      ��̵�ݾڵ����Ǻܤ��뤳�ȡ�
 *  (3) �ܥ��եȥ������򡤵�����Ȥ߹���ʤɡ�¾�Υ��եȥ�������ȯ�˻�
 *      �ѤǤ��ʤ����Ǻ����ۤ�����ˤϡ����Τ����줫�ξ�����������
 *      �ȡ�
 *    (a) �����ۤ�ȼ���ɥ�����ȡ����Ѽԥޥ˥奢��ʤɡˤˡ��嵭����
 *        �ɽ�����������Ѿ�浪��Ӳ�����̵�ݾڵ����Ǻܤ��뤳�ȡ�
 *    (b) �����ۤη��֤��̤�������ˡ�ˤ�äơ�TOPPERS�ץ��������Ȥ�
 *        ��𤹤뤳�ȡ�
 *  (4) �ܥ��եȥ����������Ѥˤ��ľ��Ū�ޤ��ϴ���Ū�������뤤���ʤ�»
 *      ������⡤�嵭����Ԥ����TOPPERS�ץ��������Ȥ����դ��뤳�ȡ�
 *      �ޤ����ܥ��եȥ������Υ桼���ޤ��ϥ���ɥ桼������Τ����ʤ���
 *      ͳ�˴�Ť����ᤫ��⡤�嵭����Ԥ����TOPPERS�ץ��������Ȥ�
 *      ���դ��뤳�ȡ�
 *
 *  �ܥ��եȥ������ϡ�AUTOSAR��AUTomotive Open System ARchitecture�˻�
 *  �ͤ˴�Ť��Ƥ��롥�嵭�ε����ϡ�AUTOSAR����Ū�⻺������������Τ�
 *  �Ϥʤ���AUTOSAR�ϡ�AUTOSAR���ͤ˴�Ť������եȥ�����������Ū����
 *  �Ѥ���Ԥ��Ф��ơ�AUTOSAR�ѡ��ȥʡ��ˤʤ뤳�Ȥ���Ƥ��롥
 *
 *  �ܥ��եȥ������ϡ�̵�ݾڤ��󶡤���Ƥ����ΤǤ��롥�嵭����Ԥ�
 *  ���TOPPERS�ץ��������Ȥϡ��ܥ��եȥ������˴ؤ��ơ�����λ�����Ū
 *  ���Ф���Ŭ������ޤ�ơ������ʤ��ݾڤ�Ԥ�ʤ����ޤ����ܥ��եȥ���
 *  �������Ѥˤ��ľ��Ū�ޤ��ϴ���Ū�������������ʤ�»���˴ؤ��Ƥ⡤��
 *  ����Ǥ�����ʤ���
 *
 *  $Id $
 */
/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.ImplementationDataType;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.ImplementationDataTypeElement;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.M2Package;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.SwBaseType;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl.ImplementationDataTypeImpl#getSubElement <em>Sub Element</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl.ImplementationDataTypeImpl#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl.ImplementationDataTypeImpl#getSwAlignment <em>Sw Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementationDataTypeImpl extends AutosarDataTypeImpl implements ImplementationDataType {
	/**
	 * The cached value of the '{@link #getSubElement() <em>Sub Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubElement()
	 * @generated
	 * @ordered
	 */
	protected EList<ImplementationDataTypeElement> subElement;

	/**
	 * The cached setting delegate for the '{@link #getBaseType() <em>Base Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseType()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate BASE_TYPE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE__BASE_TYPE).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getSwAlignment() <em>Sw Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwAlignment()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate SW_ALIGNMENT__ESETTING_DELEGATE = ((EStructuralFeature.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE__SW_ALIGNMENT).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return M2Package.Literals.IMPLEMENTATION_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwBaseType getBaseType() {
		return (SwBaseType)BASE_TYPE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSwAlignment() {
		return (String)SW_ALIGNMENT__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImplementationDataTypeElement> getSubElement() {
		if (subElement == null) {
			subElement = new EObjectContainmentEList<ImplementationDataTypeElement>(ImplementationDataTypeElement.class, this, M2Package.IMPLEMENTATION_DATA_TYPE__SUB_ELEMENT);
		}
		return subElement;
	}

	/**
	 * The cached invocation delegate for the '{@link #getLeafImplementationDataType() <em>Get Leaf Implementation Data Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeafImplementationDataType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate GET_LEAF_IMPLEMENTATION_DATA_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE___GET_LEAF_IMPLEMENTATION_DATA_TYPE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationDataType getLeafImplementationDataType() {
		try {
			return (ImplementationDataType)GET_LEAF_IMPLEMENTATION_DATA_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isPrimitiveType() <em>Is Primitive Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PRIMITIVE_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE___IS_PRIMITIVE_TYPE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrimitiveType() {
		try {
			return (Boolean)IS_PRIMITIVE_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isPointerType() <em>Is Pointer Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPointerType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_POINTER_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE___IS_POINTER_TYPE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPointerType() {
		try {
			return (Boolean)IS_POINTER_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isArrayType() <em>Is Array Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArrayType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ARRAY_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE___IS_ARRAY_TYPE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isArrayType() {
		try {
			return (Boolean)IS_ARRAY_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isStructType() <em>Is Struct Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStructType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_STRUCT_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE___IS_STRUCT_TYPE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStructType() {
		try {
			return (Boolean)IS_STRUCT_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isUnionType() <em>Is Union Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnionType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_UNION_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE___IS_UNION_TYPE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnionType() {
		try {
			return (Boolean)IS_UNION_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isRedefinitionType() <em>Is Redefinition Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRedefinitionType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_REDEFINITION_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE___IS_REDEFINITION_TYPE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRedefinitionType() {
		try {
			return (Boolean)IS_REDEFINITION_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isComplexType() <em>Is Complex Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplexType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_COMPLEX_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)M2Package.Literals.IMPLEMENTATION_DATA_TYPE___IS_COMPLEX_TYPE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComplexType() {
		try {
			return (Boolean)IS_COMPLEX_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case M2Package.IMPLEMENTATION_DATA_TYPE__SUB_ELEMENT:
				return ((InternalEList<?>)getSubElement()).basicRemove(otherEnd, msgs);
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
			case M2Package.IMPLEMENTATION_DATA_TYPE__SUB_ELEMENT:
				return getSubElement();
			case M2Package.IMPLEMENTATION_DATA_TYPE__BASE_TYPE:
				return getBaseType();
			case M2Package.IMPLEMENTATION_DATA_TYPE__SW_ALIGNMENT:
				return getSwAlignment();
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
			case M2Package.IMPLEMENTATION_DATA_TYPE__SUB_ELEMENT:
				getSubElement().clear();
				getSubElement().addAll((Collection<? extends ImplementationDataTypeElement>)newValue);
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
			case M2Package.IMPLEMENTATION_DATA_TYPE__SUB_ELEMENT:
				getSubElement().clear();
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
			case M2Package.IMPLEMENTATION_DATA_TYPE__SUB_ELEMENT:
				return subElement != null && !subElement.isEmpty();
			case M2Package.IMPLEMENTATION_DATA_TYPE__BASE_TYPE:
				return BASE_TYPE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case M2Package.IMPLEMENTATION_DATA_TYPE__SW_ALIGNMENT:
				return SW_ALIGNMENT__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case M2Package.IMPLEMENTATION_DATA_TYPE___GET_LEAF_IMPLEMENTATION_DATA_TYPE:
				return getLeafImplementationDataType();
			case M2Package.IMPLEMENTATION_DATA_TYPE___IS_PRIMITIVE_TYPE:
				return isPrimitiveType();
			case M2Package.IMPLEMENTATION_DATA_TYPE___IS_POINTER_TYPE:
				return isPointerType();
			case M2Package.IMPLEMENTATION_DATA_TYPE___IS_ARRAY_TYPE:
				return isArrayType();
			case M2Package.IMPLEMENTATION_DATA_TYPE___IS_STRUCT_TYPE:
				return isStructType();
			case M2Package.IMPLEMENTATION_DATA_TYPE___IS_UNION_TYPE:
				return isUnionType();
			case M2Package.IMPLEMENTATION_DATA_TYPE___IS_REDEFINITION_TYPE:
				return isRedefinitionType();
			case M2Package.IMPLEMENTATION_DATA_TYPE___IS_COMPLEX_TYPE:
				return isComplexType();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ImplementationDataTypeImpl