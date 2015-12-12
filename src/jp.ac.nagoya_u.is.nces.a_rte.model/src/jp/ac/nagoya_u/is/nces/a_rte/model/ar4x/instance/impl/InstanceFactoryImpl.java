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
package jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.instance.impl;

import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.instance.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InstanceFactoryImpl extends EFactoryImpl implements InstanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InstanceFactory init() {
		try {
			InstanceFactory theInstanceFactory = (InstanceFactory)EPackage.Registry.INSTANCE.getEFactory(InstancePackage.eNS_URI);
			if (theInstanceFactory != null) {
				return theInstanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case InstancePackage.PORT_INSTANCE_IN_COMPOSITION: return (EObject)createPortInstanceInComposition();
			case InstancePackage.VARIABLE_DATA_INSTANCE_IN_COMPOSITION: return (EObject)createVariableDataInstanceInComposition();
			case InstancePackage.PVARIABLE_DATA_INSTANCE_IN_SWC: return (EObject)createPVariableDataInstanceInSwc();
			case InstancePackage.RVARIABLE_DATA_INSTANCE_IN_SWC: return (EObject)createRVariableDataInstanceInSwc();
			case InstancePackage.ASSEMBLY_DATA_INSTANCE_CONNECTOR: return (EObject)createAssemblyDataInstanceConnector();
			case InstancePackage.DELEGATION_DATA_INSTANCE_CONNECTOR: return (EObject)createDelegationDataInstanceConnector();
			case InstancePackage.ROPERATION_INSTANCE_IN_SWC: return (EObject)createROperationInstanceInSwc();
			case InstancePackage.POPERATION_INSTANCE_IN_SWC: return (EObject)createPOperationInstanceInSwc();
			case InstancePackage.OPERATION_INSTANCE_IN_COMPOSITION: return (EObject)createOperationInstanceInComposition();
			case InstancePackage.ASSEMBLY_OPERATION_INSTANCE_CONNECTOR: return (EObject)createAssemblyOperationInstanceConnector();
			case InstancePackage.SW_COMPONENT_INSTANCE_IN_SYSTEM: return (EObject)createSwComponentInstanceInSystem();
			case InstancePackage.INSTANCE_ROOT: return (EObject)createInstanceRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortInstanceInComposition createPortInstanceInComposition() {
		PortInstanceInCompositionImpl portInstanceInComposition = new PortInstanceInCompositionImpl();
		return portInstanceInComposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDataInstanceInComposition createVariableDataInstanceInComposition() {
		VariableDataInstanceInCompositionImpl variableDataInstanceInComposition = new VariableDataInstanceInCompositionImpl();
		return variableDataInstanceInComposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PVariableDataInstanceInSwc createPVariableDataInstanceInSwc() {
		PVariableDataInstanceInSwcImpl pVariableDataInstanceInSwc = new PVariableDataInstanceInSwcImpl();
		return pVariableDataInstanceInSwc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RVariableDataInstanceInSwc createRVariableDataInstanceInSwc() {
		RVariableDataInstanceInSwcImpl rVariableDataInstanceInSwc = new RVariableDataInstanceInSwcImpl();
		return rVariableDataInstanceInSwc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyDataInstanceConnector createAssemblyDataInstanceConnector() {
		AssemblyDataInstanceConnectorImpl assemblyDataInstanceConnector = new AssemblyDataInstanceConnectorImpl();
		return assemblyDataInstanceConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelegationDataInstanceConnector createDelegationDataInstanceConnector() {
		DelegationDataInstanceConnectorImpl delegationDataInstanceConnector = new DelegationDataInstanceConnectorImpl();
		return delegationDataInstanceConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ROperationInstanceInSwc createROperationInstanceInSwc() {
		ROperationInstanceInSwcImpl rOperationInstanceInSwc = new ROperationInstanceInSwcImpl();
		return rOperationInstanceInSwc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public POperationInstanceInSwc createPOperationInstanceInSwc() {
		POperationInstanceInSwcImpl pOperationInstanceInSwc = new POperationInstanceInSwcImpl();
		return pOperationInstanceInSwc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationInstanceInComposition createOperationInstanceInComposition() {
		OperationInstanceInCompositionImpl operationInstanceInComposition = new OperationInstanceInCompositionImpl();
		return operationInstanceInComposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyOperationInstanceConnector createAssemblyOperationInstanceConnector() {
		AssemblyOperationInstanceConnectorImpl assemblyOperationInstanceConnector = new AssemblyOperationInstanceConnectorImpl();
		return assemblyOperationInstanceConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwComponentInstanceInSystem createSwComponentInstanceInSystem() {
		SwComponentInstanceInSystemImpl swComponentInstanceInSystem = new SwComponentInstanceInSystemImpl();
		return swComponentInstanceInSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceRoot createInstanceRoot() {
		InstanceRootImpl instanceRoot = new InstanceRootImpl();
		return instanceRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePackage getInstancePackage() {
		return (InstancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InstancePackage getPackage() {
		return InstancePackage.eINSTANCE;
	}

} //InstanceFactoryImpl