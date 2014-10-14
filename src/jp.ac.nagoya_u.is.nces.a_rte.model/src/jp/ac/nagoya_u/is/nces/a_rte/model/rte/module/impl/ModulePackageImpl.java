/*
 *  TOPPERS/A-RTEGEN
 *      Automotive Runtime Environment Generator
 *
 *  Copyright (C) 2013-2014 by Eiwa System Management, Inc., JAPAN
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

import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.Ar4xPackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.impl.EcucPackageImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.impl.Ar4xPackageImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.instance.InstancePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.instance.impl.InstancePackageImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.M2Package;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.impl.M2PackageImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.RtePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.ex.ExPackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.ex.impl.ExPackageImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.impl.RtePackageImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.interaction.InteractionPackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.interaction.impl.InteractionPackageImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.AllInterruptBlockExcludeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.BlackboxHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.BlackboxType;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.BswMemoryMapping;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.BswMemoryMappingHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.BswSchedulableEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.BswSchedulableEntityGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Bswm;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.CallApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComCallback;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComCallbackGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComInvalidateCallback;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComReceiveCallback;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComReceiveSignalApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComReceiveTimeoutCallback;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComSendProxyOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComSendSignalApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComSendSignalImmediateEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComSendSignalImmediateTaskBody;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComSendSignalPeriodicEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComSendSignalTrustedFunction;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComSendTrustedFunctionParamType;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.NeverReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Constant;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ConstantTypeEnum;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ContextActivationOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Core;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.CycleCountupOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.DirectComSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.DirectExecutableStartOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExcludeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExecutableEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExecutableEntityGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExecutableStartOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.File;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.FilterOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Function;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.FunctionGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.GenerationInfo;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.GlobalVariable;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.GlobalVariableGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.HeaderFile;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.InitializeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.InterPartitionTimeoutOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.InvalidateApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocCommunication;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocEmptyQueueApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocInitializeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocNonqueuedCommunication;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocNonqueuedReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocNonqueuedSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocQueuedCommunication;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocQueuedGroupCommunication;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocQueuedReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocQueuedSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocReadApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocReceiveApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocReceiveGroupApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocSendApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocSendGroupApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.IocWriteApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.LocalVariable;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.LogicalCompartment;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Macro;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.MaskedNewDiffersMaskedOldFilterOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.MaskedNewDiffersXFilterOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.MaskedNewEqualsXFilterOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.MemoryMapping;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleFactory;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleInterlinkHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleInterlinkTypeHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleObject;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleReferrable;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleRoot;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.MulticoreRteStartApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.MulticoreSchmInitApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.NewIsOutsideFilterOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.NewIsWithinFilterOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.StartOffsetCountupOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OneEveryNFilterOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Operation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsEventSetActivationOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsEventSetExecutableTaskBody;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsGetSpinlockApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsInterruptBlockExcludeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsResourceExcludeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsSetEventApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsSpinlockExcludeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsSuspendAllInterruptsApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsTaskActivationExecutableTaskBody;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.OsTaskActivationOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Parameter;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ParameterPassTypeEnum;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.PartedBswm;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Partition;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.PartitionRestartingApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.PartitionTerminatedApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ImmediateProxyComSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.PeriodicProxyComSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.PrimitiveType;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ProxyComSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ReadApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ReceiveApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RestartPartitionApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Rte;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteApiGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteApplicationHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteApplicationTypeHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferInvalidateTrustedFunction;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferNonqueuedReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferNonqueuedSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferQueueType;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferQueuedReadOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferQueuedSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferQueuedVariable;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferWriteTrustedFunction;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteBufferVariableSet;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteCallbackHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteConfigurationHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteCoreStartApiImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteEnterApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteExitApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteInternalHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteLifecycleApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteLifecycleApiGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteLifecycleHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteModule;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteSource;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteStartApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteStopApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteTypeHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteUtilityHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.RteVfbTraceHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmApiGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmCoreInitApiImpl;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmDeinitApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmEnterApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmExitApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmInitApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmLifecycleApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SchmLifecycleApiGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SendApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SignednessEnum;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SinglecoreRteStartApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SinglecoreSchmInitApi;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SourceFile;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Swc;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SwcMemoryMapping;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.SwcMemoryMappingHeader;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.TaskBody;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.TaskBodyGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.TimingTriggeringExecutableStartOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.TrustedFunction;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.TrustedFunctionComSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.TrustedFunctionGroup;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.TrustedFunctionRteBufferInvalidateSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.TrustedFunctionRteBufferWriteSendOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Type;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.UnionMember;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.UnionType;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Value;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Variable;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.VariableInitializeOperation;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.VariableMember;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.WriteApi;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModulePackageImpl extends EPackageImpl implements ModulePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleReferrableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writeApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferNonqueuedSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferNonqueuedReadOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferVariableSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteApplicationHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swcEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteLifecycleHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteApplicationTypeHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteVfbTraceHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteConfigurationHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteCallbackHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteTypeHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidateApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocNonqueuedSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directComSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trustedFunctionComSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass immediateProxyComSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass periodicProxyComSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocNonqueuedReadOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comReadOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocNonqueuedCommunicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocWriteApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocReadApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comSendSignalApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comReceiveSignalApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comReceiveCallbackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comCallbackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comReceiveTimeoutCallbackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comInvalidateCallbackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comSendSignalImmediateEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comSendSignalPeriodicEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maskedNewDiffersMaskedOldFilterOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maskedNewDiffersXFilterOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newIsWithinFilterOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newIsOutsideFilterOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maskedNewEqualsXFilterOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oneEveryNFilterOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteCoreStartApiImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteStopApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headerFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteInternalHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blackboxTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unionMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteUtilityHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blackboxHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferQueueTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comSendTrustedFunctionParamTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass neverReadOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferInvalidateTrustedFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trustedFunctionRteBufferInvalidateSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swcMemoryMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bswMemoryMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalVariableGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteApiGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteLifecycleApiGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskBodyGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bswSchedulableEntityGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comCallbackGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trustedFunctionGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executableEntityGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bswMemoryMappingHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swcMemoryMappingHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generationInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass macroEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmLifecycleApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmEnterApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmExitApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleInterlinkHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmApiGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleInterlinkTypeHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmLifecycleApiGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partedBswmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bswmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmDeinitApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmInitApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singlecoreSchmInitApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multicoreSchmInitApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schmCoreInitApiImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restartPartitionApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionRestartingApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionTerminatedApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteLifecycleApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferQueuedSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferQueuedVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferQueuedReadOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocQueuedCommunicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocReceiveApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocSendApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocQueuedSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocQueuedReadOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executableStartOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executableEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass excludeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allInterruptBlockExcludeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osInterruptBlockExcludeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osSpinlockExcludeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osResourceExcludeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bswSchedulableEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteEnterApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteExitApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osTaskActivationExecutableTaskBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osEventSetExecutableTaskBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osTaskActivationOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osEventSetActivationOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextActivationOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timingTriggeringExecutableStartOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cycleCountupOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startOffsetCountupOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocEmptyQueueApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trustedFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comSendSignalTrustedFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osSetEventApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comSendSignalImmediateTaskBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comSendProxyOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocReceiveGroupApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interPartitionTimeoutOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initializeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableInitializeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocInitializeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osSuspendAllInterruptsApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osGetSpinlockApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multicoreRteStartApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteBufferWriteTrustedFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trustedFunctionRteBufferWriteSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocCommunicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyComSendOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocSendGroupApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iocQueuedGroupCommunicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directExecutableStartOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singlecoreRteStartApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rteStartApiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum parameterPassTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum signednessEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum constantTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType verbatimStringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cIdentifierEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModulePackageImpl() {
		super(eNS_URI, ModuleFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModulePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModulePackage init() {
		if (isInited) return (ModulePackage)EPackage.Registry.INSTANCE.getEPackage(ModulePackage.eNS_URI);

		// Obtain or create and register package
		ModulePackageImpl theModulePackage = (ModulePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModulePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModulePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		RtePackageImpl theRtePackage = (RtePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RtePackage.eNS_URI) instanceof RtePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RtePackage.eNS_URI) : RtePackage.eINSTANCE);
		ExPackageImpl theExPackage = (ExPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExPackage.eNS_URI) instanceof ExPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExPackage.eNS_URI) : ExPackage.eINSTANCE);
		InteractionPackageImpl theInteractionPackage = (InteractionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InteractionPackage.eNS_URI) instanceof InteractionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InteractionPackage.eNS_URI) : InteractionPackage.eINSTANCE);
		Ar4xPackageImpl theAr4xPackage = (Ar4xPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ar4xPackage.eNS_URI) instanceof Ar4xPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ar4xPackage.eNS_URI) : Ar4xPackage.eINSTANCE);
		M2PackageImpl theM2Package = (M2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(M2Package.eNS_URI) instanceof M2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(M2Package.eNS_URI) : M2Package.eINSTANCE);
		EcucPackageImpl theEcucPackage = (EcucPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcucPackage.eNS_URI) instanceof EcucPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcucPackage.eNS_URI) : EcucPackage.eINSTANCE);
		InstancePackageImpl theInstancePackage = (InstancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI) instanceof InstancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI) : InstancePackage.eINSTANCE);

		// Create package meta-data objects
		theModulePackage.createPackageContents();
		theRtePackage.createPackageContents();
		theExPackage.createPackageContents();
		theInteractionPackage.createPackageContents();
		theAr4xPackage.createPackageContents();
		theM2Package.createPackageContents();
		theEcucPackage.createPackageContents();
		theInstancePackage.createPackageContents();

		// Initialize created meta-data
		theModulePackage.initializePackageContents();
		theRtePackage.initializePackageContents();
		theExPackage.initializePackageContents();
		theInteractionPackage.initializePackageContents();
		theAr4xPackage.initializePackageContents();
		theM2Package.initializePackageContents();
		theEcucPackage.initializePackageContents();
		theInstancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModulePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModulePackage.eNS_URI, theModulePackage);
		return theModulePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleObject() {
		return moduleObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleObject_Source() {
		return (EReference)moduleObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleObject_SingleSource() {
		return (EReference)moduleObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleObject_RoleName() {
		return (EAttribute)moduleObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleReferrable() {
		return moduleReferrableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleReferrable_Id() {
		return (EAttribute)moduleReferrableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWriteApi() {
		return writeApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWriteApi_Operation() {
		return (EReference)writeApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWriteApi_DataParam() {
		return (EReference)writeApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSendOperation() {
		return sendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendOperation_SendValue() {
		return (EReference)sendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendOperation_SendStatus() {
		return (EReference)sendOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendOperation_ExcludeOperation() {
		return (EReference)sendOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendOperation_ReturnVariable() {
		return (EReference)sendOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferNonqueuedSendOperation() {
		return rteBufferNonqueuedSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferNonqueuedSendOperation_AccessVariable() {
		return (EReference)rteBufferNonqueuedSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferNonqueuedSendOperation_FilterOperation() {
		return (EReference)rteBufferNonqueuedSendOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferNonqueuedReadOperation() {
		return rteBufferNonqueuedReadOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferNonqueuedReadOperation_AccessVariable() {
		return (EReference)rteBufferNonqueuedReadOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadOperation() {
		return readOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadOperation_InvalidValueConstant() {
		return (EReference)readOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadOperation_ReadValueVariable() {
		return (EReference)readOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadOperation_ReadStatusVariable() {
		return (EReference)readOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadOperation_ExcludeOperation() {
		return (EReference)readOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadApi() {
		return readApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadApi_Operation() {
		return (EReference)readApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadApi_DataParam() {
		return (EReference)readApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferVariableSet() {
		return rteBufferVariableSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferVariableSet_ValueVariable() {
		return (EReference)rteBufferVariableSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferVariableSet_StatusVariable() {
		return (EReference)rteBufferVariableSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteSource() {
		return rteSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_GlobalVariableGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_BswSchedulableEntityGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_RteApiGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_RteLifecycleApiGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_TaskBodyGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_ComCallbackGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_TrustedFunctionGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_SourceMacro() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_SchmLifecycleApiGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteSource_SchmApiGroup() {
		return (EReference)rteSourceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteApi() {
		return rteApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRteApi_ApiMappingName() {
		return (EAttribute)rteApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteApi_ReturnValue() {
		return (EReference)rteApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRteApi_IsConnected() {
		return (EAttribute)rteApiEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteApi_Parent() {
		return (EReference)rteApiEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteModule() {
		return rteModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteCommonSource() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RtePartitionSource() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteApplicationHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteApplicationTypeHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteLifecycleHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteCallbackHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteConfigurationHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteVfbTraceHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteTypeHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteCommonHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RtePartitionHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_RteUtilityHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_DependentHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_BswMemoryMappingHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_SwcMemoryMappingHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_ModuleInterlinkHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteModule_ModuleInterlinkTypeHeader() {
		return (EReference)rteModuleEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalVariable() {
		return globalVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalVariable_InitValueConstant() {
		return (EReference)globalVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalVariable_MemoryMapping() {
		return (EReference)globalVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalVariable_InitAtDefinition() {
		return (EAttribute)globalVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFile() {
		return fileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFile_FileName() {
		return (EAttribute)fileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFile_GenerationInfo() {
		return (EReference)fileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_PassType() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_SymbolName() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_IsAnonymous() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalVariable() {
		return localVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalVariable_InitValueConstant() {
		return (EReference)localVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalVariable_Parent() {
		return (EReference)localVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteApplicationHeader() {
		return rteApplicationHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteApplicationHeader_RteApiGroup() {
		return (EReference)rteApplicationHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteApplicationHeader_Constant() {
		return (EReference)rteApplicationHeaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteApplicationHeader_DependentExecutableEntityGroup() {
		return (EReference)rteApplicationHeaderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_SymbolName() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_ReturnType() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Param() {
		return (EReference)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_LocalVariable() {
		return (EReference)functionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_LocalType() {
		return (EReference)functionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_MemoryMapping() {
		return (EReference)functionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalCompartment() {
		return logicalCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicalCompartment_CompartmentName() {
		return (EAttribute)logicalCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCore() {
		return coreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCore_Partition() {
		return (EReference)coreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCore_RteStartApi() {
		return (EReference)coreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCore_CoreId() {
		return (EAttribute)coreEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCore_IsMasterCore() {
		return (EAttribute)coreEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCore_SchmInitApi() {
		return (EReference)coreEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartition() {
		return partitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartition_IsBswPartition() {
		return (EAttribute)partitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_Parent() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_Swc() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_RteBufferVariableSet() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_FilterOldValueVariable() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_FilterOccurrenceVariable() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_RestartPartitionApi() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_PartitionTerminatedApi() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_PartitionRestartingApi() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_TaskBody() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_RteBufferQueuedVariable() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_RteBufferInitValueConstant() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_EntityStartVariable() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_EntityStartConstant() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_FilterConstant() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_RteBufferSendTrustedFunction() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_OsTrustedMacro() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartition_PartedBswm() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwc() {
		return swcEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_FilterConstant() {
		return (EReference)swcEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_PortArgValueConstant() {
		return (EReference)swcEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_DependentExecutableEntity() {
		return (EReference)swcEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_InvalidValueConstant() {
		return (EReference)swcEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_ImplInitValueConstant() {
		return (EReference)swcEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_SwcMemoryMapping() {
		return (EReference)swcEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_Parent() {
		return (EReference)swcEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_RteApi() {
		return (EReference)swcEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_ApiInitValueConstant() {
		return (EReference)swcEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_ApiApplicationErrorConstant() {
		return (EReference)swcEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_ApiEnumConstant() {
		return (EReference)swcEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwc_ApiUpperLowerLimitConstant() {
		return (EReference)swcEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteHeader() {
		return rteHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteLifecycleHeader() {
		return rteLifecycleHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteLifecycleHeader_RteLifecycleApiGroup() {
		return (EReference)rteLifecycleHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteLifecycleHeader_SchmLifecycleApiGroup() {
		return (EReference)rteLifecycleHeaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteApplicationTypeHeader() {
		return rteApplicationTypeHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteApplicationTypeHeader_Constant() {
		return (EReference)rteApplicationTypeHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteVfbTraceHeader() {
		return rteVfbTraceHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteConfigurationHeader() {
		return rteConfigurationHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteCallbackHeader() {
		return rteCallbackHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteCallbackHeader_ComCallbackGroup() {
		return (EReference)rteCallbackHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteTypeHeader() {
		return rteTypeHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteTypeHeader_RteType() {
		return (EReference)rteTypeHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteTypeHeader_RteTypeConstant() {
		return (EReference)rteTypeHeaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvalidateApi() {
		return invalidateApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvalidateApi_Operation() {
		return (EReference)invalidateApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocNonqueuedSendOperation() {
		return iocNonqueuedSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocNonqueuedSendOperation_AccessApi() {
		return (EReference)iocNonqueuedSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectComSendOperation() {
		return directComSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrustedFunctionComSendOperation() {
		return trustedFunctionComSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrustedFunctionComSendOperation_AccessTrustedFunction() {
		return (EReference)trustedFunctionComSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrustedFunctionComSendOperation_TrustedFunctionParamVariable() {
		return (EReference)trustedFunctionComSendOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImmediateProxyComSendOperation() {
		return immediateProxyComSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImmediateProxyComSendOperation_ActivationApi() {
		return (EReference)immediateProxyComSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeriodicProxyComSendOperation() {
		return periodicProxyComSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocNonqueuedReadOperation() {
		return iocNonqueuedReadOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocNonqueuedReadOperation_AccessApi() {
		return (EReference)iocNonqueuedReadOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComReadOperation() {
		return comReadOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComReadOperation_AccessApi() {
		return (EReference)comReadOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocNonqueuedCommunication() {
		return iocNonqueuedCommunicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocNonqueuedCommunication_WriteApi() {
		return (EReference)iocNonqueuedCommunicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocNonqueuedCommunication_ReadApi() {
		return (EReference)iocNonqueuedCommunicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocNonqueuedCommunication_InitValue() {
		return (EReference)iocNonqueuedCommunicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocWriteApi() {
		return iocWriteApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocWriteApi_Parent() {
		return (EReference)iocWriteApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocReadApi() {
		return iocReadApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComSendSignalApi() {
		return comSendSignalApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComReceiveSignalApi() {
		return comReceiveSignalApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComReceiveCallback() {
		return comReceiveCallbackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComReceiveCallback_Operation() {
		return (EReference)comReceiveCallbackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComReceiveCallback_DataVariable() {
		return (EReference)comReceiveCallbackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComReceiveCallback_AccessApi() {
		return (EReference)comReceiveCallbackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComSendOperation() {
		return comSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComSendOperation_AccessApi() {
		return (EReference)comSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComCallback() {
		return comCallbackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComReceiveTimeoutCallback() {
		return comReceiveTimeoutCallbackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComReceiveTimeoutCallback_Operation() {
		return (EReference)comReceiveTimeoutCallbackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComReceiveTimeoutCallback_DataVariable() {
		return (EReference)comReceiveTimeoutCallbackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComReceiveTimeoutCallback_AccessApi() {
		return (EReference)comReceiveTimeoutCallbackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComInvalidateCallback() {
		return comInvalidateCallbackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComInvalidateCallback_Operation() {
		return (EReference)comInvalidateCallbackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComInvalidateCallback_FilterResultVariable() {
		return (EReference)comInvalidateCallbackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComSendSignalImmediateEntity() {
		return comSendSignalImmediateEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComSendSignalImmediateEntity_Operation() {
		return (EReference)comSendSignalImmediateEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComSendSignalPeriodicEntity() {
		return comSendSignalPeriodicEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComSendSignalPeriodicEntity_Operation() {
		return (EReference)comSendSignalPeriodicEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterOperation() {
		return filterOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterOperation_FilterResultVariable() {
		return (EReference)filterOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaskedNewDiffersMaskedOldFilterOperation() {
		return maskedNewDiffersMaskedOldFilterOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMaskedNewDiffersMaskedOldFilterOperation_OldValueVariable() {
		return (EReference)maskedNewDiffersMaskedOldFilterOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMaskedNewDiffersMaskedOldFilterOperation_Mask() {
		return (EReference)maskedNewDiffersMaskedOldFilterOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaskedNewDiffersXFilterOperation() {
		return maskedNewDiffersXFilterOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMaskedNewDiffersXFilterOperation_Mask() {
		return (EReference)maskedNewDiffersXFilterOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMaskedNewDiffersXFilterOperation_X() {
		return (EReference)maskedNewDiffersXFilterOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewIsWithinFilterOperation() {
		return newIsWithinFilterOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewIsWithinFilterOperation_Min() {
		return (EReference)newIsWithinFilterOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewIsWithinFilterOperation_Max() {
		return (EReference)newIsWithinFilterOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewIsOutsideFilterOperation() {
		return newIsOutsideFilterOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewIsOutsideFilterOperation_Min() {
		return (EReference)newIsOutsideFilterOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewIsOutsideFilterOperation_Max() {
		return (EReference)newIsOutsideFilterOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaskedNewEqualsXFilterOperation() {
		return maskedNewEqualsXFilterOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMaskedNewEqualsXFilterOperation_Mask() {
		return (EReference)maskedNewEqualsXFilterOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMaskedNewEqualsXFilterOperation_X() {
		return (EReference)maskedNewEqualsXFilterOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOneEveryNFilterOperation() {
		return oneEveryNFilterOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOneEveryNFilterOperation_OccurrenceVariable() {
		return (EReference)oneEveryNFilterOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOneEveryNFilterOperation_Period() {
		return (EReference)oneEveryNFilterOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOneEveryNFilterOperation_Offset() {
		return (EReference)oneEveryNFilterOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteCoreStartApiImpl() {
		return rteCoreStartApiImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteCoreStartApiImpl_Operation() {
		return (EReference)rteCoreStartApiImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteCoreStartApiImpl_Parent() {
		return (EReference)rteCoreStartApiImplEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteStopApi() {
		return rteStopApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeaderFile() {
		return headerFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderFile_GuardName() {
		return (EAttribute)headerFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeaderFile_DependentHeaders() {
		return (EReference)headerFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceFile() {
		return sourceFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceFile_DependentHeaders() {
		return (EReference)sourceFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteInternalHeader() {
		return rteInternalHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteInternalHeader_Constant() {
		return (EReference)rteInternalHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteInternalHeader_GlobalVariableGroup() {
		return (EReference)rteInternalHeaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteInternalHeader_TrustedFunctionGroup() {
		return (EReference)rteInternalHeaderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteInternalHeader_BswSchedulableEntityGroup() {
		return (EReference)rteInternalHeaderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteInternalHeader_RteCoreStartApiImpl() {
		return (EReference)rteInternalHeaderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteInternalHeader_DependentExecutableEntityGroup() {
		return (EReference)rteInternalHeaderEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteInternalHeader_SchmCoreInitApiImpl() {
		return (EReference)rteInternalHeaderEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_OriginalTypeSymbolName() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_Signedness() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnionType() {
		return unionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnionType_Member() {
		return (EReference)unionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlackboxType() {
		return blackboxTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnionMember() {
		return unionMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnionMember_MemberName() {
		return (EAttribute)unionMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnionMember_Type() {
		return (EReference)unionMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableMember() {
		return variableMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableMember_Parent() {
		return (EReference)variableMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteUtilityHeader() {
		return rteUtilityHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlackboxHeader() {
		return blackboxHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferQueueType() {
		return rteBufferQueueTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferQueueType_MaxLengthConstant() {
		return (EReference)rteBufferQueueTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferQueueType_ElementType() {
		return (EReference)rteBufferQueueTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComSendTrustedFunctionParamType() {
		return comSendTrustedFunctionParamTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNeverReadOperation() {
		return neverReadOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNeverReadOperation_InitValueConstant() {
		return (EReference)neverReadOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferInvalidateTrustedFunction() {
		return rteBufferInvalidateTrustedFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferInvalidateTrustedFunction_Operation() {
		return (EReference)rteBufferInvalidateTrustedFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrustedFunctionRteBufferInvalidateSendOperation() {
		return trustedFunctionRteBufferInvalidateSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrustedFunctionRteBufferInvalidateSendOperation_AccessTrustedFunction() {
		return (EReference)trustedFunctionRteBufferInvalidateSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryMapping() {
		return memoryMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemoryMapping_Prefix() {
		return (EAttribute)memoryMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemoryMapping_MemorySectionSymbolName() {
		return (EAttribute)memoryMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwcMemoryMapping() {
		return swcMemoryMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBswMemoryMapping() {
		return bswMemoryMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalVariableGroup() {
		return globalVariableGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalVariableGroup_GlobalVariable() {
		return (EReference)globalVariableGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalVariableGroup_MemoryMapping() {
		return (EReference)globalVariableGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionGroup() {
		return functionGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionGroup_MemoryMapping() {
		return (EReference)functionGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionGroup_Function() {
		return (EReference)functionGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteApiGroup() {
		return rteApiGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteApiGroup_RteApi() {
		return (EReference)rteApiGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteLifecycleApiGroup() {
		return rteLifecycleApiGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteLifecycleApiGroup_RteLifecycleApi() {
		return (EReference)rteLifecycleApiGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskBodyGroup() {
		return taskBodyGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskBodyGroup_TaskBody() {
		return (EReference)taskBodyGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBswSchedulableEntityGroup() {
		return bswSchedulableEntityGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBswSchedulableEntityGroup_BswSchedulableEntity() {
		return (EReference)bswSchedulableEntityGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComCallbackGroup() {
		return comCallbackGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComCallbackGroup_ComCallback() {
		return (EReference)comCallbackGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrustedFunctionGroup() {
		return trustedFunctionGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrustedFunctionGroup_TrustedFunction() {
		return (EReference)trustedFunctionGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutableEntityGroup() {
		return executableEntityGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutableEntityGroup_ExecutableEntity() {
		return (EReference)executableEntityGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBswMemoryMappingHeader() {
		return bswMemoryMappingHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBswMemoryMappingHeader_MemoryMapping() {
		return (EReference)bswMemoryMappingHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwcMemoryMappingHeader() {
		return swcMemoryMappingHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwcMemoryMappingHeader_MemoryMapping() {
		return (EReference)swcMemoryMappingHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenerationInfo() {
		return generationInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenerationInfo_GeneratorName() {
		return (EAttribute)generationInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenerationInfo_GeneratorVersion() {
		return (EAttribute)generationInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenerationInfo_GenerationDate() {
		return (EAttribute)generationInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMacro() {
		return macroEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMacro_SymbolName() {
		return (EAttribute)macroEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmApi() {
		return schmApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchmApi_ReturnValue() {
		return (EReference)schmApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchmApi_Parent() {
		return (EReference)schmApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmLifecycleApi() {
		return schmLifecycleApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmEnterApi() {
		return schmEnterApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchmEnterApi_Operation() {
		return (EReference)schmEnterApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmExitApi() {
		return schmExitApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchmExitApi_Operation() {
		return (EReference)schmExitApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleInterlinkHeader() {
		return moduleInterlinkHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleInterlinkHeader_SchmApiGroup() {
		return (EReference)moduleInterlinkHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleInterlinkHeader_DependentExecutableEntityGroup() {
		return (EReference)moduleInterlinkHeaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleInterlinkHeader_Constant() {
		return (EReference)moduleInterlinkHeaderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmApiGroup() {
		return schmApiGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchmApiGroup_SchmApi() {
		return (EReference)schmApiGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleInterlinkTypeHeader() {
		return moduleInterlinkTypeHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleInterlinkTypeHeader_Constant() {
		return (EReference)moduleInterlinkTypeHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmLifecycleApiGroup() {
		return schmLifecycleApiGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchmLifecycleApiGroup_SchmLifecycleApi() {
		return (EReference)schmLifecycleApiGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartedBswm() {
		return partedBswmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartedBswm_Parent() {
		return (EReference)partedBswmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartedBswm_DependentExecutableEntity() {
		return (EReference)partedBswmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartedBswm_SchmApi() {
		return (EReference)partedBswmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartedBswm_BswMemoryMapping() {
		return (EReference)partedBswmEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartedBswm_Bswm() {
		return (EReference)partedBswmEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBswm() {
		return bswmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBswm_PartedBswm() {
		return (EReference)bswmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBswm__GetSinglePartedBswm__Partition() {
		return bswmEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmDeinitApi() {
		return schmDeinitApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmInitApi() {
		return schmInitApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSinglecoreSchmInitApi() {
		return singlecoreSchmInitApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSinglecoreSchmInitApi_Operation() {
		return (EReference)singlecoreSchmInitApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMulticoreSchmInitApi() {
		return multicoreSchmInitApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMulticoreSchmInitApi_CoreInitApiImpl() {
		return (EReference)multicoreSchmInitApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchmCoreInitApiImpl() {
		return schmCoreInitApiImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchmCoreInitApiImpl_Parent() {
		return (EReference)schmCoreInitApiImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchmCoreInitApiImpl_Operation() {
		return (EReference)schmCoreInitApiImplEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestartPartitionApi() {
		return restartPartitionApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestartPartitionApi_EReference0() {
		return (EReference)restartPartitionApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestartPartitionApi_EReference1() {
		return (EReference)restartPartitionApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestartPartitionApi_Operation() {
		return (EReference)restartPartitionApiEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartitionRestartingApi() {
		return partitionRestartingApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartitionRestartingApi_Operation() {
		return (EReference)partitionRestartingApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartitionTerminatedApi() {
		return partitionTerminatedApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartitionTerminatedApi_Operation() {
		return (EReference)partitionTerminatedApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteLifecycleApi() {
		return rteLifecycleApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSendApi() {
		return sendApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendApi_Operation() {
		return (EReference)sendApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendApi_DataParam() {
		return (EReference)sendApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendApi_StatusVariable() {
		return (EReference)sendApiEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendApi_TrustedFunctionParamVariable() {
		return (EReference)sendApiEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendApi_FilterResultVariable() {
		return (EReference)sendApiEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceiveApi() {
		return receiveApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveApi_Operation() {
		return (EReference)receiveApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveApi_DataParam() {
		return (EReference)receiveApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveApi_StatusVariable() {
		return (EReference)receiveApiEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferQueuedSendOperation() {
		return rteBufferQueuedSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferQueuedSendOperation_AccessVariable() {
		return (EReference)rteBufferQueuedSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferQueuedSendOperation_TempReturnVariable() {
		return (EReference)rteBufferQueuedSendOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferQueuedVariable() {
		return rteBufferQueuedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferQueuedVariable_QueueType() {
		return (EReference)rteBufferQueuedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferQueuedReadOperation() {
		return rteBufferQueuedReadOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferQueuedReadOperation_AccessVariable() {
		return (EReference)rteBufferQueuedReadOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocQueuedCommunication() {
		return iocQueuedCommunicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocQueuedCommunication_SendApi() {
		return (EReference)iocQueuedCommunicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocQueuedCommunication_ReceiveApi() {
		return (EReference)iocQueuedCommunicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocQueuedCommunication_IocEmptyQueueApi() {
		return (EReference)iocQueuedCommunicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocReceiveApi() {
		return iocReceiveApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocSendApi() {
		return iocSendApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocQueuedSendOperation() {
		return iocQueuedSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocQueuedSendOperation_AccessApi() {
		return (EReference)iocQueuedSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocQueuedReadOperation() {
		return iocQueuedReadOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocQueuedReadOperation_AccessApi() {
		return (EReference)iocQueuedReadOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallApi() {
		return callApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallApi_Operation() {
		return (EReference)callApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallApi_OperationParam() {
		return (EReference)callApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallApi_PortArgValue() {
		return (EReference)callApiEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallApi_ReturnVariable() {
		return (EReference)callApiEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutableStartOperation() {
		return executableStartOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutableStartOperation_ExcludeOperation() {
		return (EReference)executableStartOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutableStartOperation_StartExecutable() {
		return (EReference)executableStartOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutableEntity() {
		return executableEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutableEntity_RoleParam() {
		return (EReference)executableEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutableEntity_ParentPartedBswm() {
		return (EReference)executableEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExcludeOperation() {
		return excludeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllInterruptBlockExcludeOperation() {
		return allInterruptBlockExcludeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsInterruptBlockExcludeOperation() {
		return osInterruptBlockExcludeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsSpinlockExcludeOperation() {
		return osSpinlockExcludeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsSpinlockExcludeOperation_OsSpinlockId() {
		return (EAttribute)osSpinlockExcludeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsResourceExcludeOperation() {
		return osResourceExcludeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsResourceExcludeOperation_OsResourceId() {
		return (EAttribute)osResourceExcludeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstant() {
		return constantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstant_SymbolName() {
		return (EAttribute)constantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstant_Type() {
		return (EReference)constantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstant_Value() {
		return (EAttribute)constantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstant_ConstantType() {
		return (EAttribute)constantEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBswSchedulableEntity() {
		return bswSchedulableEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteEnterApi() {
		return rteEnterApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteEnterApi_Operation() {
		return (EReference)rteEnterApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteExitApi() {
		return rteExitApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteExitApi_Operation() {
		return (EReference)rteExitApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsTaskActivationExecutableTaskBody() {
		return osTaskActivationExecutableTaskBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOsTaskActivationExecutableTaskBody_Operation() {
		return (EReference)osTaskActivationExecutableTaskBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsEventSetExecutableTaskBody() {
		return osEventSetExecutableTaskBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOsEventSetExecutableTaskBody_Operation() {
		return (EReference)osEventSetExecutableTaskBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsEventSetExecutableTaskBody_OsEventId() {
		return (EAttribute)osEventSetExecutableTaskBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsEventSetExecutableTaskBody_ChecksOsEventId() {
		return (EAttribute)osEventSetExecutableTaskBodyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOsEventSetExecutableTaskBody_EventVariable() {
		return (EReference)osEventSetExecutableTaskBodyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsTaskActivationOperation() {
		return osTaskActivationOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsEventSetActivationOperation() {
		return osEventSetActivationOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsEventSetActivationOperation_ActivationOsEventId() {
		return (EAttribute)osEventSetActivationOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextActivationOperation() {
		return contextActivationOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextActivationOperation_ExecutableStartOperation() {
		return (EReference)contextActivationOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextActivationOperation_CycleCountupOperation() {
		return (EReference)contextActivationOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextActivationOperation_StartOffsetCountupOperation() {
		return (EReference)contextActivationOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimingTriggeringExecutableStartOperation() {
		return timingTriggeringExecutableStartOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimingTriggeringExecutableStartOperation_CyclePeriodConstant() {
		return (EReference)timingTriggeringExecutableStartOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimingTriggeringExecutableStartOperation_CycleOffsetConstant() {
		return (EReference)timingTriggeringExecutableStartOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimingTriggeringExecutableStartOperation_StartOffsetConstant() {
		return (EReference)timingTriggeringExecutableStartOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimingTriggeringExecutableStartOperation_StartOffsetCounterVariable() {
		return (EReference)timingTriggeringExecutableStartOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimingTriggeringExecutableStartOperation_CycleCounterVariable() {
		return (EReference)timingTriggeringExecutableStartOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCycleCountupOperation() {
		return cycleCountupOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCycleCountupOperation_CounterVariable() {
		return (EReference)cycleCountupOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCycleCountupOperation_MaxConstant() {
		return (EReference)cycleCountupOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartOffsetCountupOperation() {
		return startOffsetCountupOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartOffsetCountupOperation_CounterVariable() {
		return (EReference)startOffsetCountupOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartOffsetCountupOperation_MaxConstant() {
		return (EReference)startOffsetCountupOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskBody() {
		return taskBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskBody_OsTaskId() {
		return (EAttribute)taskBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocEmptyQueueApi() {
		return iocEmptyQueueApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComApi() {
		return comApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComApi_ComSignalSymbolName() {
		return (EAttribute)comApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocApi() {
		return iocApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRte() {
		return rteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_Core() {
		return (EReference)rteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_ComCallback() {
		return (EReference)rteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_ComSendSignalPeriodicEntity() {
		return (EReference)rteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_ComSendSignalImmediateEntity() {
		return (EReference)rteEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_ComSendSignalTrustedFunction() {
		return (EReference)rteEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_DependentType() {
		return (EReference)rteEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_RteType() {
		return (EReference)rteEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_DependentOsApi() {
		return (EReference)rteEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_DependentIocCommunication() {
		return (EReference)rteEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_DependentComApi() {
		return (EReference)rteEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_RteStartApi() {
		return (EReference)rteEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_IocInitValueConstant() {
		return (EReference)rteEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_DependentConstant() {
		return (EReference)rteEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_ComSendSignalImmediateTaskBody() {
		return (EReference)rteEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_RteStopApi() {
		return (EReference)rteEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_RteTypeConstant() {
		return (EReference)rteEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_RteMemoryMapping() {
		return (EReference)rteEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_GenerationInfo() {
		return (EReference)rteEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_Bswm() {
		return (EReference)rteEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_SchmInitApi() {
		return (EReference)rteEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRte_SchmDeinitApi() {
		return (EReference)rteEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrustedFunction() {
		return trustedFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrustedFunction_TrustedFunctionIndex() {
		return (EAttribute)trustedFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComSendSignalTrustedFunction() {
		return comSendSignalTrustedFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsSetEventApi() {
		return osSetEventApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsSetEventApi_OsTaskId() {
		return (EAttribute)osSetEventApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsSetEventApi_OsEventId() {
		return (EAttribute)osSetEventApiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsApi() {
		return osApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComSendSignalImmediateTaskBody() {
		return comSendSignalImmediateTaskBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComSendSignalImmediateTaskBody_StartEntity() {
		return (EReference)comSendSignalImmediateTaskBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComSendSignalImmediateTaskBody_OsEventId() {
		return (EAttribute)comSendSignalImmediateTaskBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_SymbolName() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Type() {
		return (EReference)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Member() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComSendProxyOperation() {
		return comSendProxyOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComSendProxyOperation_ReadValueVariable() {
		return (EReference)comSendProxyOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComSendProxyOperation_AccessApi() {
		return (EReference)comSendProxyOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComSendProxyOperation_SignalIdVariable() {
		return (EReference)comSendProxyOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocReceiveGroupApi() {
		return iocReceiveGroupApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleRoot() {
		return moduleRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleRoot_RteModule() {
		return (EReference)moduleRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleRoot_Rte() {
		return (EReference)moduleRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterPartitionTimeoutOperation() {
		return interPartitionTimeoutOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterPartitionTimeoutOperation_TimeoutVariable() {
		return (EReference)interPartitionTimeoutOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterPartitionTimeoutOperation_ExcludeOperation() {
		return (EReference)interPartitionTimeoutOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitializeOperation() {
		return initializeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableInitializeOperation() {
		return variableInitializeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitializeOperation_InitVariable() {
		return (EReference)variableInitializeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitializeOperation_ExcludeOperation() {
		return (EReference)variableInitializeOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocInitializeOperation() {
		return iocInitializeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocInitializeOperation_InitIocApi() {
		return (EReference)iocInitializeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsSuspendAllInterruptsApi() {
		return osSuspendAllInterruptsApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsGetSpinlockApi() {
		return osGetSpinlockApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMulticoreRteStartApi() {
		return multicoreRteStartApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMulticoreRteStartApi_CoreStartApiImpl() {
		return (EReference)multicoreRteStartApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteBufferWriteTrustedFunction() {
		return rteBufferWriteTrustedFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferWriteTrustedFunction_Operation() {
		return (EReference)rteBufferWriteTrustedFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRteBufferWriteTrustedFunction_DataVariable() {
		return (EReference)rteBufferWriteTrustedFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrustedFunctionRteBufferWriteSendOperation() {
		return trustedFunctionRteBufferWriteSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrustedFunctionRteBufferWriteSendOperation_AccessTrustedFunction() {
		return (EReference)trustedFunctionRteBufferWriteSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocCommunication() {
		return iocCommunicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyComSendOperation() {
		return proxyComSendOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyComSendOperation_AccessProxyApi() {
		return (EReference)proxyComSendOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocSendGroupApi() {
		return iocSendGroupApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIocQueuedGroupCommunication() {
		return iocQueuedGroupCommunicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocQueuedGroupCommunication_ReceiveApi() {
		return (EReference)iocQueuedGroupCommunicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIocQueuedGroupCommunication_SendApi() {
		return (EReference)iocQueuedGroupCommunicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectExecutableStartOperation() {
		return directExecutableStartOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSinglecoreRteStartApi() {
		return singlecoreRteStartApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSinglecoreRteStartApi_Operation() {
		return (EReference)singlecoreRteStartApiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRteStartApi() {
		return rteStartApiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParameterPassTypeEnum() {
		return parameterPassTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSignednessEnum() {
		return signednessEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConstantTypeEnum() {
		return constantTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVerbatimString() {
		return verbatimStringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCIdentifier() {
		return cIdentifierEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBoolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInteger() {
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleFactory getModuleFactory() {
		return (ModuleFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		moduleObjectEClass = createEClass(MODULE_OBJECT);
		createEReference(moduleObjectEClass, MODULE_OBJECT__SOURCE);
		createEReference(moduleObjectEClass, MODULE_OBJECT__SINGLE_SOURCE);
		createEAttribute(moduleObjectEClass, MODULE_OBJECT__ROLE_NAME);

		moduleReferrableEClass = createEClass(MODULE_REFERRABLE);
		createEAttribute(moduleReferrableEClass, MODULE_REFERRABLE__ID);

		operationEClass = createEClass(OPERATION);

		writeApiEClass = createEClass(WRITE_API);
		createEReference(writeApiEClass, WRITE_API__OPERATION);
		createEReference(writeApiEClass, WRITE_API__DATA_PARAM);

		sendOperationEClass = createEClass(SEND_OPERATION);
		createEReference(sendOperationEClass, SEND_OPERATION__SEND_VALUE);
		createEReference(sendOperationEClass, SEND_OPERATION__SEND_STATUS);
		createEReference(sendOperationEClass, SEND_OPERATION__EXCLUDE_OPERATION);
		createEReference(sendOperationEClass, SEND_OPERATION__RETURN_VARIABLE);

		rteBufferNonqueuedSendOperationEClass = createEClass(RTE_BUFFER_NONQUEUED_SEND_OPERATION);
		createEReference(rteBufferNonqueuedSendOperationEClass, RTE_BUFFER_NONQUEUED_SEND_OPERATION__ACCESS_VARIABLE);
		createEReference(rteBufferNonqueuedSendOperationEClass, RTE_BUFFER_NONQUEUED_SEND_OPERATION__FILTER_OPERATION);

		rteBufferNonqueuedReadOperationEClass = createEClass(RTE_BUFFER_NONQUEUED_READ_OPERATION);
		createEReference(rteBufferNonqueuedReadOperationEClass, RTE_BUFFER_NONQUEUED_READ_OPERATION__ACCESS_VARIABLE);

		readOperationEClass = createEClass(READ_OPERATION);
		createEReference(readOperationEClass, READ_OPERATION__INVALID_VALUE_CONSTANT);
		createEReference(readOperationEClass, READ_OPERATION__READ_VALUE_VARIABLE);
		createEReference(readOperationEClass, READ_OPERATION__READ_STATUS_VARIABLE);
		createEReference(readOperationEClass, READ_OPERATION__EXCLUDE_OPERATION);

		readApiEClass = createEClass(READ_API);
		createEReference(readApiEClass, READ_API__OPERATION);
		createEReference(readApiEClass, READ_API__DATA_PARAM);

		rteBufferVariableSetEClass = createEClass(RTE_BUFFER_VARIABLE_SET);
		createEReference(rteBufferVariableSetEClass, RTE_BUFFER_VARIABLE_SET__VALUE_VARIABLE);
		createEReference(rteBufferVariableSetEClass, RTE_BUFFER_VARIABLE_SET__STATUS_VARIABLE);

		rteSourceEClass = createEClass(RTE_SOURCE);
		createEReference(rteSourceEClass, RTE_SOURCE__GLOBAL_VARIABLE_GROUP);
		createEReference(rteSourceEClass, RTE_SOURCE__BSW_SCHEDULABLE_ENTITY_GROUP);
		createEReference(rteSourceEClass, RTE_SOURCE__RTE_API_GROUP);
		createEReference(rteSourceEClass, RTE_SOURCE__RTE_LIFECYCLE_API_GROUP);
		createEReference(rteSourceEClass, RTE_SOURCE__TASK_BODY_GROUP);
		createEReference(rteSourceEClass, RTE_SOURCE__COM_CALLBACK_GROUP);
		createEReference(rteSourceEClass, RTE_SOURCE__TRUSTED_FUNCTION_GROUP);
		createEReference(rteSourceEClass, RTE_SOURCE__SOURCE_MACRO);
		createEReference(rteSourceEClass, RTE_SOURCE__SCHM_LIFECYCLE_API_GROUP);
		createEReference(rteSourceEClass, RTE_SOURCE__SCHM_API_GROUP);

		rteApiEClass = createEClass(RTE_API);
		createEAttribute(rteApiEClass, RTE_API__API_MAPPING_NAME);
		createEReference(rteApiEClass, RTE_API__RETURN_VALUE);
		createEAttribute(rteApiEClass, RTE_API__IS_CONNECTED);
		createEReference(rteApiEClass, RTE_API__PARENT);

		rteModuleEClass = createEClass(RTE_MODULE);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_COMMON_SOURCE);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_PARTITION_SOURCE);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_APPLICATION_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_APPLICATION_TYPE_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_LIFECYCLE_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_CALLBACK_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_CONFIGURATION_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_VFB_TRACE_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_TYPE_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_COMMON_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_PARTITION_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__RTE_UTILITY_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__DEPENDENT_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__BSW_MEMORY_MAPPING_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__SWC_MEMORY_MAPPING_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__MODULE_INTERLINK_HEADER);
		createEReference(rteModuleEClass, RTE_MODULE__MODULE_INTERLINK_TYPE_HEADER);

		globalVariableEClass = createEClass(GLOBAL_VARIABLE);
		createEReference(globalVariableEClass, GLOBAL_VARIABLE__INIT_VALUE_CONSTANT);
		createEReference(globalVariableEClass, GLOBAL_VARIABLE__MEMORY_MAPPING);
		createEAttribute(globalVariableEClass, GLOBAL_VARIABLE__INIT_AT_DEFINITION);

		fileEClass = createEClass(FILE);
		createEAttribute(fileEClass, FILE__FILE_NAME);
		createEReference(fileEClass, FILE__GENERATION_INFO);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__PASS_TYPE);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__SYMBOL_NAME);
		createEAttribute(typeEClass, TYPE__IS_ANONYMOUS);

		localVariableEClass = createEClass(LOCAL_VARIABLE);
		createEReference(localVariableEClass, LOCAL_VARIABLE__INIT_VALUE_CONSTANT);
		createEReference(localVariableEClass, LOCAL_VARIABLE__PARENT);

		rteApplicationHeaderEClass = createEClass(RTE_APPLICATION_HEADER);
		createEReference(rteApplicationHeaderEClass, RTE_APPLICATION_HEADER__RTE_API_GROUP);
		createEReference(rteApplicationHeaderEClass, RTE_APPLICATION_HEADER__CONSTANT);
		createEReference(rteApplicationHeaderEClass, RTE_APPLICATION_HEADER__DEPENDENT_EXECUTABLE_ENTITY_GROUP);

		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__RETURN_TYPE);
		createEReference(functionEClass, FUNCTION__PARAM);
		createEReference(functionEClass, FUNCTION__LOCAL_VARIABLE);
		createEReference(functionEClass, FUNCTION__LOCAL_TYPE);
		createEReference(functionEClass, FUNCTION__MEMORY_MAPPING);
		createEAttribute(functionEClass, FUNCTION__SYMBOL_NAME);

		logicalCompartmentEClass = createEClass(LOGICAL_COMPARTMENT);
		createEAttribute(logicalCompartmentEClass, LOGICAL_COMPARTMENT__COMPARTMENT_NAME);

		coreEClass = createEClass(CORE);
		createEReference(coreEClass, CORE__PARTITION);
		createEReference(coreEClass, CORE__RTE_START_API);
		createEAttribute(coreEClass, CORE__CORE_ID);
		createEAttribute(coreEClass, CORE__IS_MASTER_CORE);
		createEReference(coreEClass, CORE__SCHM_INIT_API);

		partitionEClass = createEClass(PARTITION);
		createEAttribute(partitionEClass, PARTITION__IS_BSW_PARTITION);
		createEReference(partitionEClass, PARTITION__PARENT);
		createEReference(partitionEClass, PARTITION__SWC);
		createEReference(partitionEClass, PARTITION__RTE_BUFFER_VARIABLE_SET);
		createEReference(partitionEClass, PARTITION__FILTER_OLD_VALUE_VARIABLE);
		createEReference(partitionEClass, PARTITION__FILTER_OCCURRENCE_VARIABLE);
		createEReference(partitionEClass, PARTITION__RESTART_PARTITION_API);
		createEReference(partitionEClass, PARTITION__PARTITION_TERMINATED_API);
		createEReference(partitionEClass, PARTITION__PARTITION_RESTARTING_API);
		createEReference(partitionEClass, PARTITION__TASK_BODY);
		createEReference(partitionEClass, PARTITION__RTE_BUFFER_QUEUED_VARIABLE);
		createEReference(partitionEClass, PARTITION__RTE_BUFFER_INIT_VALUE_CONSTANT);
		createEReference(partitionEClass, PARTITION__ENTITY_START_VARIABLE);
		createEReference(partitionEClass, PARTITION__ENTITY_START_CONSTANT);
		createEReference(partitionEClass, PARTITION__FILTER_CONSTANT);
		createEReference(partitionEClass, PARTITION__RTE_BUFFER_SEND_TRUSTED_FUNCTION);
		createEReference(partitionEClass, PARTITION__OS_TRUSTED_MACRO);
		createEReference(partitionEClass, PARTITION__PARTED_BSWM);

		swcEClass = createEClass(SWC);
		createEReference(swcEClass, SWC__PARENT);
		createEReference(swcEClass, SWC__RTE_API);
		createEReference(swcEClass, SWC__API_INIT_VALUE_CONSTANT);
		createEReference(swcEClass, SWC__API_APPLICATION_ERROR_CONSTANT);
		createEReference(swcEClass, SWC__API_ENUM_CONSTANT);
		createEReference(swcEClass, SWC__API_UPPER_LOWER_LIMIT_CONSTANT);
		createEReference(swcEClass, SWC__FILTER_CONSTANT);
		createEReference(swcEClass, SWC__PORT_ARG_VALUE_CONSTANT);
		createEReference(swcEClass, SWC__DEPENDENT_EXECUTABLE_ENTITY);
		createEReference(swcEClass, SWC__INVALID_VALUE_CONSTANT);
		createEReference(swcEClass, SWC__IMPL_INIT_VALUE_CONSTANT);
		createEReference(swcEClass, SWC__SWC_MEMORY_MAPPING);

		rteHeaderEClass = createEClass(RTE_HEADER);

		rteLifecycleHeaderEClass = createEClass(RTE_LIFECYCLE_HEADER);
		createEReference(rteLifecycleHeaderEClass, RTE_LIFECYCLE_HEADER__RTE_LIFECYCLE_API_GROUP);
		createEReference(rteLifecycleHeaderEClass, RTE_LIFECYCLE_HEADER__SCHM_LIFECYCLE_API_GROUP);

		rteApplicationTypeHeaderEClass = createEClass(RTE_APPLICATION_TYPE_HEADER);
		createEReference(rteApplicationTypeHeaderEClass, RTE_APPLICATION_TYPE_HEADER__CONSTANT);

		rteVfbTraceHeaderEClass = createEClass(RTE_VFB_TRACE_HEADER);

		rteConfigurationHeaderEClass = createEClass(RTE_CONFIGURATION_HEADER);

		rteCallbackHeaderEClass = createEClass(RTE_CALLBACK_HEADER);
		createEReference(rteCallbackHeaderEClass, RTE_CALLBACK_HEADER__COM_CALLBACK_GROUP);

		rteTypeHeaderEClass = createEClass(RTE_TYPE_HEADER);
		createEReference(rteTypeHeaderEClass, RTE_TYPE_HEADER__RTE_TYPE);
		createEReference(rteTypeHeaderEClass, RTE_TYPE_HEADER__RTE_TYPE_CONSTANT);

		invalidateApiEClass = createEClass(INVALIDATE_API);
		createEReference(invalidateApiEClass, INVALIDATE_API__OPERATION);

		iocNonqueuedSendOperationEClass = createEClass(IOC_NONQUEUED_SEND_OPERATION);
		createEReference(iocNonqueuedSendOperationEClass, IOC_NONQUEUED_SEND_OPERATION__ACCESS_API);

		directComSendOperationEClass = createEClass(DIRECT_COM_SEND_OPERATION);

		trustedFunctionComSendOperationEClass = createEClass(TRUSTED_FUNCTION_COM_SEND_OPERATION);
		createEReference(trustedFunctionComSendOperationEClass, TRUSTED_FUNCTION_COM_SEND_OPERATION__ACCESS_TRUSTED_FUNCTION);
		createEReference(trustedFunctionComSendOperationEClass, TRUSTED_FUNCTION_COM_SEND_OPERATION__TRUSTED_FUNCTION_PARAM_VARIABLE);

		immediateProxyComSendOperationEClass = createEClass(IMMEDIATE_PROXY_COM_SEND_OPERATION);
		createEReference(immediateProxyComSendOperationEClass, IMMEDIATE_PROXY_COM_SEND_OPERATION__ACTIVATION_API);

		periodicProxyComSendOperationEClass = createEClass(PERIODIC_PROXY_COM_SEND_OPERATION);

		iocNonqueuedReadOperationEClass = createEClass(IOC_NONQUEUED_READ_OPERATION);
		createEReference(iocNonqueuedReadOperationEClass, IOC_NONQUEUED_READ_OPERATION__ACCESS_API);

		comReadOperationEClass = createEClass(COM_READ_OPERATION);
		createEReference(comReadOperationEClass, COM_READ_OPERATION__ACCESS_API);

		iocNonqueuedCommunicationEClass = createEClass(IOC_NONQUEUED_COMMUNICATION);
		createEReference(iocNonqueuedCommunicationEClass, IOC_NONQUEUED_COMMUNICATION__WRITE_API);
		createEReference(iocNonqueuedCommunicationEClass, IOC_NONQUEUED_COMMUNICATION__READ_API);
		createEReference(iocNonqueuedCommunicationEClass, IOC_NONQUEUED_COMMUNICATION__INIT_VALUE);

		iocWriteApiEClass = createEClass(IOC_WRITE_API);
		createEReference(iocWriteApiEClass, IOC_WRITE_API__PARENT);

		iocReadApiEClass = createEClass(IOC_READ_API);

		comSendSignalApiEClass = createEClass(COM_SEND_SIGNAL_API);

		comReceiveSignalApiEClass = createEClass(COM_RECEIVE_SIGNAL_API);

		comReceiveCallbackEClass = createEClass(COM_RECEIVE_CALLBACK);
		createEReference(comReceiveCallbackEClass, COM_RECEIVE_CALLBACK__OPERATION);
		createEReference(comReceiveCallbackEClass, COM_RECEIVE_CALLBACK__DATA_VARIABLE);
		createEReference(comReceiveCallbackEClass, COM_RECEIVE_CALLBACK__ACCESS_API);

		comSendOperationEClass = createEClass(COM_SEND_OPERATION);
		createEReference(comSendOperationEClass, COM_SEND_OPERATION__ACCESS_API);

		comCallbackEClass = createEClass(COM_CALLBACK);

		comReceiveTimeoutCallbackEClass = createEClass(COM_RECEIVE_TIMEOUT_CALLBACK);
		createEReference(comReceiveTimeoutCallbackEClass, COM_RECEIVE_TIMEOUT_CALLBACK__OPERATION);
		createEReference(comReceiveTimeoutCallbackEClass, COM_RECEIVE_TIMEOUT_CALLBACK__DATA_VARIABLE);
		createEReference(comReceiveTimeoutCallbackEClass, COM_RECEIVE_TIMEOUT_CALLBACK__ACCESS_API);

		comInvalidateCallbackEClass = createEClass(COM_INVALIDATE_CALLBACK);
		createEReference(comInvalidateCallbackEClass, COM_INVALIDATE_CALLBACK__OPERATION);
		createEReference(comInvalidateCallbackEClass, COM_INVALIDATE_CALLBACK__FILTER_RESULT_VARIABLE);

		comSendSignalImmediateEntityEClass = createEClass(COM_SEND_SIGNAL_IMMEDIATE_ENTITY);
		createEReference(comSendSignalImmediateEntityEClass, COM_SEND_SIGNAL_IMMEDIATE_ENTITY__OPERATION);

		comSendSignalPeriodicEntityEClass = createEClass(COM_SEND_SIGNAL_PERIODIC_ENTITY);
		createEReference(comSendSignalPeriodicEntityEClass, COM_SEND_SIGNAL_PERIODIC_ENTITY__OPERATION);

		filterOperationEClass = createEClass(FILTER_OPERATION);
		createEReference(filterOperationEClass, FILTER_OPERATION__FILTER_RESULT_VARIABLE);

		maskedNewDiffersMaskedOldFilterOperationEClass = createEClass(MASKED_NEW_DIFFERS_MASKED_OLD_FILTER_OPERATION);
		createEReference(maskedNewDiffersMaskedOldFilterOperationEClass, MASKED_NEW_DIFFERS_MASKED_OLD_FILTER_OPERATION__OLD_VALUE_VARIABLE);
		createEReference(maskedNewDiffersMaskedOldFilterOperationEClass, MASKED_NEW_DIFFERS_MASKED_OLD_FILTER_OPERATION__MASK);

		maskedNewDiffersXFilterOperationEClass = createEClass(MASKED_NEW_DIFFERS_XFILTER_OPERATION);
		createEReference(maskedNewDiffersXFilterOperationEClass, MASKED_NEW_DIFFERS_XFILTER_OPERATION__MASK);
		createEReference(maskedNewDiffersXFilterOperationEClass, MASKED_NEW_DIFFERS_XFILTER_OPERATION__X);

		newIsWithinFilterOperationEClass = createEClass(NEW_IS_WITHIN_FILTER_OPERATION);
		createEReference(newIsWithinFilterOperationEClass, NEW_IS_WITHIN_FILTER_OPERATION__MIN);
		createEReference(newIsWithinFilterOperationEClass, NEW_IS_WITHIN_FILTER_OPERATION__MAX);

		newIsOutsideFilterOperationEClass = createEClass(NEW_IS_OUTSIDE_FILTER_OPERATION);
		createEReference(newIsOutsideFilterOperationEClass, NEW_IS_OUTSIDE_FILTER_OPERATION__MIN);
		createEReference(newIsOutsideFilterOperationEClass, NEW_IS_OUTSIDE_FILTER_OPERATION__MAX);

		maskedNewEqualsXFilterOperationEClass = createEClass(MASKED_NEW_EQUALS_XFILTER_OPERATION);
		createEReference(maskedNewEqualsXFilterOperationEClass, MASKED_NEW_EQUALS_XFILTER_OPERATION__MASK);
		createEReference(maskedNewEqualsXFilterOperationEClass, MASKED_NEW_EQUALS_XFILTER_OPERATION__X);

		oneEveryNFilterOperationEClass = createEClass(ONE_EVERY_NFILTER_OPERATION);
		createEReference(oneEveryNFilterOperationEClass, ONE_EVERY_NFILTER_OPERATION__OCCURRENCE_VARIABLE);
		createEReference(oneEveryNFilterOperationEClass, ONE_EVERY_NFILTER_OPERATION__PERIOD);
		createEReference(oneEveryNFilterOperationEClass, ONE_EVERY_NFILTER_OPERATION__OFFSET);

		rteCoreStartApiImplEClass = createEClass(RTE_CORE_START_API_IMPL);
		createEReference(rteCoreStartApiImplEClass, RTE_CORE_START_API_IMPL__OPERATION);
		createEReference(rteCoreStartApiImplEClass, RTE_CORE_START_API_IMPL__PARENT);

		rteStopApiEClass = createEClass(RTE_STOP_API);

		restartPartitionApiEClass = createEClass(RESTART_PARTITION_API);
		createEReference(restartPartitionApiEClass, RESTART_PARTITION_API__EREFERENCE0);
		createEReference(restartPartitionApiEClass, RESTART_PARTITION_API__EREFERENCE1);
		createEReference(restartPartitionApiEClass, RESTART_PARTITION_API__OPERATION);

		partitionRestartingApiEClass = createEClass(PARTITION_RESTARTING_API);
		createEReference(partitionRestartingApiEClass, PARTITION_RESTARTING_API__OPERATION);

		partitionTerminatedApiEClass = createEClass(PARTITION_TERMINATED_API);
		createEReference(partitionTerminatedApiEClass, PARTITION_TERMINATED_API__OPERATION);

		rteLifecycleApiEClass = createEClass(RTE_LIFECYCLE_API);

		sendApiEClass = createEClass(SEND_API);
		createEReference(sendApiEClass, SEND_API__OPERATION);
		createEReference(sendApiEClass, SEND_API__DATA_PARAM);
		createEReference(sendApiEClass, SEND_API__STATUS_VARIABLE);
		createEReference(sendApiEClass, SEND_API__TRUSTED_FUNCTION_PARAM_VARIABLE);
		createEReference(sendApiEClass, SEND_API__FILTER_RESULT_VARIABLE);

		receiveApiEClass = createEClass(RECEIVE_API);
		createEReference(receiveApiEClass, RECEIVE_API__OPERATION);
		createEReference(receiveApiEClass, RECEIVE_API__DATA_PARAM);
		createEReference(receiveApiEClass, RECEIVE_API__STATUS_VARIABLE);

		rteBufferQueuedSendOperationEClass = createEClass(RTE_BUFFER_QUEUED_SEND_OPERATION);
		createEReference(rteBufferQueuedSendOperationEClass, RTE_BUFFER_QUEUED_SEND_OPERATION__ACCESS_VARIABLE);
		createEReference(rteBufferQueuedSendOperationEClass, RTE_BUFFER_QUEUED_SEND_OPERATION__TEMP_RETURN_VARIABLE);

		rteBufferQueuedVariableEClass = createEClass(RTE_BUFFER_QUEUED_VARIABLE);
		createEReference(rteBufferQueuedVariableEClass, RTE_BUFFER_QUEUED_VARIABLE__QUEUE_TYPE);

		rteBufferQueuedReadOperationEClass = createEClass(RTE_BUFFER_QUEUED_READ_OPERATION);
		createEReference(rteBufferQueuedReadOperationEClass, RTE_BUFFER_QUEUED_READ_OPERATION__ACCESS_VARIABLE);

		iocQueuedCommunicationEClass = createEClass(IOC_QUEUED_COMMUNICATION);
		createEReference(iocQueuedCommunicationEClass, IOC_QUEUED_COMMUNICATION__SEND_API);
		createEReference(iocQueuedCommunicationEClass, IOC_QUEUED_COMMUNICATION__RECEIVE_API);
		createEReference(iocQueuedCommunicationEClass, IOC_QUEUED_COMMUNICATION__IOC_EMPTY_QUEUE_API);

		iocReceiveApiEClass = createEClass(IOC_RECEIVE_API);

		iocSendApiEClass = createEClass(IOC_SEND_API);

		iocQueuedSendOperationEClass = createEClass(IOC_QUEUED_SEND_OPERATION);
		createEReference(iocQueuedSendOperationEClass, IOC_QUEUED_SEND_OPERATION__ACCESS_API);

		iocQueuedReadOperationEClass = createEClass(IOC_QUEUED_READ_OPERATION);
		createEReference(iocQueuedReadOperationEClass, IOC_QUEUED_READ_OPERATION__ACCESS_API);

		callApiEClass = createEClass(CALL_API);
		createEReference(callApiEClass, CALL_API__OPERATION);
		createEReference(callApiEClass, CALL_API__OPERATION_PARAM);
		createEReference(callApiEClass, CALL_API__PORT_ARG_VALUE);
		createEReference(callApiEClass, CALL_API__RETURN_VARIABLE);

		executableStartOperationEClass = createEClass(EXECUTABLE_START_OPERATION);
		createEReference(executableStartOperationEClass, EXECUTABLE_START_OPERATION__EXCLUDE_OPERATION);
		createEReference(executableStartOperationEClass, EXECUTABLE_START_OPERATION__START_EXECUTABLE);

		executableEntityEClass = createEClass(EXECUTABLE_ENTITY);
		createEReference(executableEntityEClass, EXECUTABLE_ENTITY__ROLE_PARAM);
		createEReference(executableEntityEClass, EXECUTABLE_ENTITY__PARENT_PARTED_BSWM);

		excludeOperationEClass = createEClass(EXCLUDE_OPERATION);

		allInterruptBlockExcludeOperationEClass = createEClass(ALL_INTERRUPT_BLOCK_EXCLUDE_OPERATION);

		osInterruptBlockExcludeOperationEClass = createEClass(OS_INTERRUPT_BLOCK_EXCLUDE_OPERATION);

		osSpinlockExcludeOperationEClass = createEClass(OS_SPINLOCK_EXCLUDE_OPERATION);
		createEAttribute(osSpinlockExcludeOperationEClass, OS_SPINLOCK_EXCLUDE_OPERATION__OS_SPINLOCK_ID);

		osResourceExcludeOperationEClass = createEClass(OS_RESOURCE_EXCLUDE_OPERATION);
		createEAttribute(osResourceExcludeOperationEClass, OS_RESOURCE_EXCLUDE_OPERATION__OS_RESOURCE_ID);

		constantEClass = createEClass(CONSTANT);
		createEAttribute(constantEClass, CONSTANT__SYMBOL_NAME);
		createEReference(constantEClass, CONSTANT__TYPE);
		createEAttribute(constantEClass, CONSTANT__VALUE);
		createEAttribute(constantEClass, CONSTANT__CONSTANT_TYPE);

		bswSchedulableEntityEClass = createEClass(BSW_SCHEDULABLE_ENTITY);

		rteEnterApiEClass = createEClass(RTE_ENTER_API);
		createEReference(rteEnterApiEClass, RTE_ENTER_API__OPERATION);

		rteExitApiEClass = createEClass(RTE_EXIT_API);
		createEReference(rteExitApiEClass, RTE_EXIT_API__OPERATION);

		osTaskActivationExecutableTaskBodyEClass = createEClass(OS_TASK_ACTIVATION_EXECUTABLE_TASK_BODY);
		createEReference(osTaskActivationExecutableTaskBodyEClass, OS_TASK_ACTIVATION_EXECUTABLE_TASK_BODY__OPERATION);

		osEventSetExecutableTaskBodyEClass = createEClass(OS_EVENT_SET_EXECUTABLE_TASK_BODY);
		createEReference(osEventSetExecutableTaskBodyEClass, OS_EVENT_SET_EXECUTABLE_TASK_BODY__OPERATION);
		createEAttribute(osEventSetExecutableTaskBodyEClass, OS_EVENT_SET_EXECUTABLE_TASK_BODY__OS_EVENT_ID);
		createEAttribute(osEventSetExecutableTaskBodyEClass, OS_EVENT_SET_EXECUTABLE_TASK_BODY__CHECKS_OS_EVENT_ID);
		createEReference(osEventSetExecutableTaskBodyEClass, OS_EVENT_SET_EXECUTABLE_TASK_BODY__EVENT_VARIABLE);

		osTaskActivationOperationEClass = createEClass(OS_TASK_ACTIVATION_OPERATION);

		osEventSetActivationOperationEClass = createEClass(OS_EVENT_SET_ACTIVATION_OPERATION);
		createEAttribute(osEventSetActivationOperationEClass, OS_EVENT_SET_ACTIVATION_OPERATION__ACTIVATION_OS_EVENT_ID);

		contextActivationOperationEClass = createEClass(CONTEXT_ACTIVATION_OPERATION);
		createEReference(contextActivationOperationEClass, CONTEXT_ACTIVATION_OPERATION__EXECUTABLE_START_OPERATION);
		createEReference(contextActivationOperationEClass, CONTEXT_ACTIVATION_OPERATION__CYCLE_COUNTUP_OPERATION);
		createEReference(contextActivationOperationEClass, CONTEXT_ACTIVATION_OPERATION__START_OFFSET_COUNTUP_OPERATION);

		timingTriggeringExecutableStartOperationEClass = createEClass(TIMING_TRIGGERING_EXECUTABLE_START_OPERATION);
		createEReference(timingTriggeringExecutableStartOperationEClass, TIMING_TRIGGERING_EXECUTABLE_START_OPERATION__CYCLE_PERIOD_CONSTANT);
		createEReference(timingTriggeringExecutableStartOperationEClass, TIMING_TRIGGERING_EXECUTABLE_START_OPERATION__CYCLE_OFFSET_CONSTANT);
		createEReference(timingTriggeringExecutableStartOperationEClass, TIMING_TRIGGERING_EXECUTABLE_START_OPERATION__START_OFFSET_CONSTANT);
		createEReference(timingTriggeringExecutableStartOperationEClass, TIMING_TRIGGERING_EXECUTABLE_START_OPERATION__START_OFFSET_COUNTER_VARIABLE);
		createEReference(timingTriggeringExecutableStartOperationEClass, TIMING_TRIGGERING_EXECUTABLE_START_OPERATION__CYCLE_COUNTER_VARIABLE);

		cycleCountupOperationEClass = createEClass(CYCLE_COUNTUP_OPERATION);
		createEReference(cycleCountupOperationEClass, CYCLE_COUNTUP_OPERATION__COUNTER_VARIABLE);
		createEReference(cycleCountupOperationEClass, CYCLE_COUNTUP_OPERATION__MAX_CONSTANT);

		startOffsetCountupOperationEClass = createEClass(START_OFFSET_COUNTUP_OPERATION);
		createEReference(startOffsetCountupOperationEClass, START_OFFSET_COUNTUP_OPERATION__COUNTER_VARIABLE);
		createEReference(startOffsetCountupOperationEClass, START_OFFSET_COUNTUP_OPERATION__MAX_CONSTANT);

		taskBodyEClass = createEClass(TASK_BODY);
		createEAttribute(taskBodyEClass, TASK_BODY__OS_TASK_ID);

		iocEmptyQueueApiEClass = createEClass(IOC_EMPTY_QUEUE_API);

		comApiEClass = createEClass(COM_API);
		createEAttribute(comApiEClass, COM_API__COM_SIGNAL_SYMBOL_NAME);

		iocApiEClass = createEClass(IOC_API);

		rteEClass = createEClass(RTE);
		createEReference(rteEClass, RTE__CORE);
		createEReference(rteEClass, RTE__COM_CALLBACK);
		createEReference(rteEClass, RTE__COM_SEND_SIGNAL_PERIODIC_ENTITY);
		createEReference(rteEClass, RTE__COM_SEND_SIGNAL_IMMEDIATE_ENTITY);
		createEReference(rteEClass, RTE__COM_SEND_SIGNAL_TRUSTED_FUNCTION);
		createEReference(rteEClass, RTE__DEPENDENT_TYPE);
		createEReference(rteEClass, RTE__RTE_TYPE);
		createEReference(rteEClass, RTE__DEPENDENT_OS_API);
		createEReference(rteEClass, RTE__DEPENDENT_IOC_COMMUNICATION);
		createEReference(rteEClass, RTE__DEPENDENT_COM_API);
		createEReference(rteEClass, RTE__RTE_START_API);
		createEReference(rteEClass, RTE__IOC_INIT_VALUE_CONSTANT);
		createEReference(rteEClass, RTE__DEPENDENT_CONSTANT);
		createEReference(rteEClass, RTE__COM_SEND_SIGNAL_IMMEDIATE_TASK_BODY);
		createEReference(rteEClass, RTE__RTE_STOP_API);
		createEReference(rteEClass, RTE__RTE_TYPE_CONSTANT);
		createEReference(rteEClass, RTE__RTE_MEMORY_MAPPING);
		createEReference(rteEClass, RTE__GENERATION_INFO);
		createEReference(rteEClass, RTE__BSWM);
		createEReference(rteEClass, RTE__SCHM_INIT_API);
		createEReference(rteEClass, RTE__SCHM_DEINIT_API);

		valueEClass = createEClass(VALUE);

		trustedFunctionEClass = createEClass(TRUSTED_FUNCTION);
		createEAttribute(trustedFunctionEClass, TRUSTED_FUNCTION__TRUSTED_FUNCTION_INDEX);

		comSendSignalTrustedFunctionEClass = createEClass(COM_SEND_SIGNAL_TRUSTED_FUNCTION);

		osSetEventApiEClass = createEClass(OS_SET_EVENT_API);
		createEAttribute(osSetEventApiEClass, OS_SET_EVENT_API__OS_TASK_ID);
		createEAttribute(osSetEventApiEClass, OS_SET_EVENT_API__OS_EVENT_ID);

		osApiEClass = createEClass(OS_API);

		comSendSignalImmediateTaskBodyEClass = createEClass(COM_SEND_SIGNAL_IMMEDIATE_TASK_BODY);
		createEReference(comSendSignalImmediateTaskBodyEClass, COM_SEND_SIGNAL_IMMEDIATE_TASK_BODY__START_ENTITY);
		createEAttribute(comSendSignalImmediateTaskBodyEClass, COM_SEND_SIGNAL_IMMEDIATE_TASK_BODY__OS_EVENT_ID);

		variableEClass = createEClass(VARIABLE);
		createEReference(variableEClass, VARIABLE__TYPE);
		createEReference(variableEClass, VARIABLE__MEMBER);
		createEAttribute(variableEClass, VARIABLE__SYMBOL_NAME);

		comSendProxyOperationEClass = createEClass(COM_SEND_PROXY_OPERATION);
		createEReference(comSendProxyOperationEClass, COM_SEND_PROXY_OPERATION__READ_VALUE_VARIABLE);
		createEReference(comSendProxyOperationEClass, COM_SEND_PROXY_OPERATION__ACCESS_API);
		createEReference(comSendProxyOperationEClass, COM_SEND_PROXY_OPERATION__SIGNAL_ID_VARIABLE);

		iocReceiveGroupApiEClass = createEClass(IOC_RECEIVE_GROUP_API);

		moduleRootEClass = createEClass(MODULE_ROOT);
		createEReference(moduleRootEClass, MODULE_ROOT__RTE_MODULE);
		createEReference(moduleRootEClass, MODULE_ROOT__RTE);

		interPartitionTimeoutOperationEClass = createEClass(INTER_PARTITION_TIMEOUT_OPERATION);
		createEReference(interPartitionTimeoutOperationEClass, INTER_PARTITION_TIMEOUT_OPERATION__TIMEOUT_VARIABLE);
		createEReference(interPartitionTimeoutOperationEClass, INTER_PARTITION_TIMEOUT_OPERATION__EXCLUDE_OPERATION);

		initializeOperationEClass = createEClass(INITIALIZE_OPERATION);

		variableInitializeOperationEClass = createEClass(VARIABLE_INITIALIZE_OPERATION);
		createEReference(variableInitializeOperationEClass, VARIABLE_INITIALIZE_OPERATION__INIT_VARIABLE);
		createEReference(variableInitializeOperationEClass, VARIABLE_INITIALIZE_OPERATION__EXCLUDE_OPERATION);

		iocInitializeOperationEClass = createEClass(IOC_INITIALIZE_OPERATION);
		createEReference(iocInitializeOperationEClass, IOC_INITIALIZE_OPERATION__INIT_IOC_API);

		osSuspendAllInterruptsApiEClass = createEClass(OS_SUSPEND_ALL_INTERRUPTS_API);

		osGetSpinlockApiEClass = createEClass(OS_GET_SPINLOCK_API);

		multicoreRteStartApiEClass = createEClass(MULTICORE_RTE_START_API);
		createEReference(multicoreRteStartApiEClass, MULTICORE_RTE_START_API__CORE_START_API_IMPL);

		rteBufferWriteTrustedFunctionEClass = createEClass(RTE_BUFFER_WRITE_TRUSTED_FUNCTION);
		createEReference(rteBufferWriteTrustedFunctionEClass, RTE_BUFFER_WRITE_TRUSTED_FUNCTION__OPERATION);
		createEReference(rteBufferWriteTrustedFunctionEClass, RTE_BUFFER_WRITE_TRUSTED_FUNCTION__DATA_VARIABLE);

		trustedFunctionRteBufferWriteSendOperationEClass = createEClass(TRUSTED_FUNCTION_RTE_BUFFER_WRITE_SEND_OPERATION);
		createEReference(trustedFunctionRteBufferWriteSendOperationEClass, TRUSTED_FUNCTION_RTE_BUFFER_WRITE_SEND_OPERATION__ACCESS_TRUSTED_FUNCTION);

		iocCommunicationEClass = createEClass(IOC_COMMUNICATION);

		proxyComSendOperationEClass = createEClass(PROXY_COM_SEND_OPERATION);
		createEReference(proxyComSendOperationEClass, PROXY_COM_SEND_OPERATION__ACCESS_PROXY_API);

		iocSendGroupApiEClass = createEClass(IOC_SEND_GROUP_API);

		iocQueuedGroupCommunicationEClass = createEClass(IOC_QUEUED_GROUP_COMMUNICATION);
		createEReference(iocQueuedGroupCommunicationEClass, IOC_QUEUED_GROUP_COMMUNICATION__RECEIVE_API);
		createEReference(iocQueuedGroupCommunicationEClass, IOC_QUEUED_GROUP_COMMUNICATION__SEND_API);

		directExecutableStartOperationEClass = createEClass(DIRECT_EXECUTABLE_START_OPERATION);

		singlecoreRteStartApiEClass = createEClass(SINGLECORE_RTE_START_API);
		createEReference(singlecoreRteStartApiEClass, SINGLECORE_RTE_START_API__OPERATION);

		rteStartApiEClass = createEClass(RTE_START_API);

		headerFileEClass = createEClass(HEADER_FILE);
		createEAttribute(headerFileEClass, HEADER_FILE__GUARD_NAME);
		createEReference(headerFileEClass, HEADER_FILE__DEPENDENT_HEADERS);

		sourceFileEClass = createEClass(SOURCE_FILE);
		createEReference(sourceFileEClass, SOURCE_FILE__DEPENDENT_HEADERS);

		rteInternalHeaderEClass = createEClass(RTE_INTERNAL_HEADER);
		createEReference(rteInternalHeaderEClass, RTE_INTERNAL_HEADER__CONSTANT);
		createEReference(rteInternalHeaderEClass, RTE_INTERNAL_HEADER__GLOBAL_VARIABLE_GROUP);
		createEReference(rteInternalHeaderEClass, RTE_INTERNAL_HEADER__TRUSTED_FUNCTION_GROUP);
		createEReference(rteInternalHeaderEClass, RTE_INTERNAL_HEADER__BSW_SCHEDULABLE_ENTITY_GROUP);
		createEReference(rteInternalHeaderEClass, RTE_INTERNAL_HEADER__RTE_CORE_START_API_IMPL);
		createEReference(rteInternalHeaderEClass, RTE_INTERNAL_HEADER__DEPENDENT_EXECUTABLE_ENTITY_GROUP);
		createEReference(rteInternalHeaderEClass, RTE_INTERNAL_HEADER__SCHM_CORE_INIT_API_IMPL);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__ORIGINAL_TYPE_SYMBOL_NAME);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__SIGNEDNESS);

		unionTypeEClass = createEClass(UNION_TYPE);
		createEReference(unionTypeEClass, UNION_TYPE__MEMBER);

		blackboxTypeEClass = createEClass(BLACKBOX_TYPE);

		unionMemberEClass = createEClass(UNION_MEMBER);
		createEAttribute(unionMemberEClass, UNION_MEMBER__MEMBER_NAME);
		createEReference(unionMemberEClass, UNION_MEMBER__TYPE);

		variableMemberEClass = createEClass(VARIABLE_MEMBER);
		createEReference(variableMemberEClass, VARIABLE_MEMBER__PARENT);

		rteUtilityHeaderEClass = createEClass(RTE_UTILITY_HEADER);

		blackboxHeaderEClass = createEClass(BLACKBOX_HEADER);

		rteBufferQueueTypeEClass = createEClass(RTE_BUFFER_QUEUE_TYPE);
		createEReference(rteBufferQueueTypeEClass, RTE_BUFFER_QUEUE_TYPE__MAX_LENGTH_CONSTANT);
		createEReference(rteBufferQueueTypeEClass, RTE_BUFFER_QUEUE_TYPE__ELEMENT_TYPE);

		comSendTrustedFunctionParamTypeEClass = createEClass(COM_SEND_TRUSTED_FUNCTION_PARAM_TYPE);

		neverReadOperationEClass = createEClass(NEVER_READ_OPERATION);
		createEReference(neverReadOperationEClass, NEVER_READ_OPERATION__INIT_VALUE_CONSTANT);

		rteBufferInvalidateTrustedFunctionEClass = createEClass(RTE_BUFFER_INVALIDATE_TRUSTED_FUNCTION);
		createEReference(rteBufferInvalidateTrustedFunctionEClass, RTE_BUFFER_INVALIDATE_TRUSTED_FUNCTION__OPERATION);

		trustedFunctionRteBufferInvalidateSendOperationEClass = createEClass(TRUSTED_FUNCTION_RTE_BUFFER_INVALIDATE_SEND_OPERATION);
		createEReference(trustedFunctionRteBufferInvalidateSendOperationEClass, TRUSTED_FUNCTION_RTE_BUFFER_INVALIDATE_SEND_OPERATION__ACCESS_TRUSTED_FUNCTION);

		memoryMappingEClass = createEClass(MEMORY_MAPPING);
		createEAttribute(memoryMappingEClass, MEMORY_MAPPING__PREFIX);
		createEAttribute(memoryMappingEClass, MEMORY_MAPPING__MEMORY_SECTION_SYMBOL_NAME);

		swcMemoryMappingEClass = createEClass(SWC_MEMORY_MAPPING);

		bswMemoryMappingEClass = createEClass(BSW_MEMORY_MAPPING);

		globalVariableGroupEClass = createEClass(GLOBAL_VARIABLE_GROUP);
		createEReference(globalVariableGroupEClass, GLOBAL_VARIABLE_GROUP__GLOBAL_VARIABLE);
		createEReference(globalVariableGroupEClass, GLOBAL_VARIABLE_GROUP__MEMORY_MAPPING);

		functionGroupEClass = createEClass(FUNCTION_GROUP);
		createEReference(functionGroupEClass, FUNCTION_GROUP__MEMORY_MAPPING);
		createEReference(functionGroupEClass, FUNCTION_GROUP__FUNCTION);

		rteApiGroupEClass = createEClass(RTE_API_GROUP);
		createEReference(rteApiGroupEClass, RTE_API_GROUP__RTE_API);

		rteLifecycleApiGroupEClass = createEClass(RTE_LIFECYCLE_API_GROUP);
		createEReference(rteLifecycleApiGroupEClass, RTE_LIFECYCLE_API_GROUP__RTE_LIFECYCLE_API);

		taskBodyGroupEClass = createEClass(TASK_BODY_GROUP);
		createEReference(taskBodyGroupEClass, TASK_BODY_GROUP__TASK_BODY);

		bswSchedulableEntityGroupEClass = createEClass(BSW_SCHEDULABLE_ENTITY_GROUP);
		createEReference(bswSchedulableEntityGroupEClass, BSW_SCHEDULABLE_ENTITY_GROUP__BSW_SCHEDULABLE_ENTITY);

		comCallbackGroupEClass = createEClass(COM_CALLBACK_GROUP);
		createEReference(comCallbackGroupEClass, COM_CALLBACK_GROUP__COM_CALLBACK);

		trustedFunctionGroupEClass = createEClass(TRUSTED_FUNCTION_GROUP);
		createEReference(trustedFunctionGroupEClass, TRUSTED_FUNCTION_GROUP__TRUSTED_FUNCTION);

		executableEntityGroupEClass = createEClass(EXECUTABLE_ENTITY_GROUP);
		createEReference(executableEntityGroupEClass, EXECUTABLE_ENTITY_GROUP__EXECUTABLE_ENTITY);

		bswMemoryMappingHeaderEClass = createEClass(BSW_MEMORY_MAPPING_HEADER);
		createEReference(bswMemoryMappingHeaderEClass, BSW_MEMORY_MAPPING_HEADER__MEMORY_MAPPING);

		swcMemoryMappingHeaderEClass = createEClass(SWC_MEMORY_MAPPING_HEADER);
		createEReference(swcMemoryMappingHeaderEClass, SWC_MEMORY_MAPPING_HEADER__MEMORY_MAPPING);

		generationInfoEClass = createEClass(GENERATION_INFO);
		createEAttribute(generationInfoEClass, GENERATION_INFO__GENERATOR_NAME);
		createEAttribute(generationInfoEClass, GENERATION_INFO__GENERATOR_VERSION);
		createEAttribute(generationInfoEClass, GENERATION_INFO__GENERATION_DATE);

		macroEClass = createEClass(MACRO);
		createEAttribute(macroEClass, MACRO__SYMBOL_NAME);

		schmApiEClass = createEClass(SCHM_API);
		createEReference(schmApiEClass, SCHM_API__RETURN_VALUE);
		createEReference(schmApiEClass, SCHM_API__PARENT);

		schmLifecycleApiEClass = createEClass(SCHM_LIFECYCLE_API);

		schmEnterApiEClass = createEClass(SCHM_ENTER_API);
		createEReference(schmEnterApiEClass, SCHM_ENTER_API__OPERATION);

		schmExitApiEClass = createEClass(SCHM_EXIT_API);
		createEReference(schmExitApiEClass, SCHM_EXIT_API__OPERATION);

		moduleInterlinkHeaderEClass = createEClass(MODULE_INTERLINK_HEADER);
		createEReference(moduleInterlinkHeaderEClass, MODULE_INTERLINK_HEADER__SCHM_API_GROUP);
		createEReference(moduleInterlinkHeaderEClass, MODULE_INTERLINK_HEADER__DEPENDENT_EXECUTABLE_ENTITY_GROUP);
		createEReference(moduleInterlinkHeaderEClass, MODULE_INTERLINK_HEADER__CONSTANT);

		schmApiGroupEClass = createEClass(SCHM_API_GROUP);
		createEReference(schmApiGroupEClass, SCHM_API_GROUP__SCHM_API);

		moduleInterlinkTypeHeaderEClass = createEClass(MODULE_INTERLINK_TYPE_HEADER);
		createEReference(moduleInterlinkTypeHeaderEClass, MODULE_INTERLINK_TYPE_HEADER__CONSTANT);

		schmLifecycleApiGroupEClass = createEClass(SCHM_LIFECYCLE_API_GROUP);
		createEReference(schmLifecycleApiGroupEClass, SCHM_LIFECYCLE_API_GROUP__SCHM_LIFECYCLE_API);

		partedBswmEClass = createEClass(PARTED_BSWM);
		createEReference(partedBswmEClass, PARTED_BSWM__PARENT);
		createEReference(partedBswmEClass, PARTED_BSWM__DEPENDENT_EXECUTABLE_ENTITY);
		createEReference(partedBswmEClass, PARTED_BSWM__SCHM_API);
		createEReference(partedBswmEClass, PARTED_BSWM__BSW_MEMORY_MAPPING);
		createEReference(partedBswmEClass, PARTED_BSWM__BSWM);

		bswmEClass = createEClass(BSWM);
		createEReference(bswmEClass, BSWM__PARTED_BSWM);
		createEOperation(bswmEClass, BSWM___GET_SINGLE_PARTED_BSWM__PARTITION);

		schmDeinitApiEClass = createEClass(SCHM_DEINIT_API);

		schmInitApiEClass = createEClass(SCHM_INIT_API);

		singlecoreSchmInitApiEClass = createEClass(SINGLECORE_SCHM_INIT_API);
		createEReference(singlecoreSchmInitApiEClass, SINGLECORE_SCHM_INIT_API__OPERATION);

		multicoreSchmInitApiEClass = createEClass(MULTICORE_SCHM_INIT_API);
		createEReference(multicoreSchmInitApiEClass, MULTICORE_SCHM_INIT_API__CORE_INIT_API_IMPL);

		schmCoreInitApiImplEClass = createEClass(SCHM_CORE_INIT_API_IMPL);
		createEReference(schmCoreInitApiImplEClass, SCHM_CORE_INIT_API_IMPL__PARENT);
		createEReference(schmCoreInitApiImplEClass, SCHM_CORE_INIT_API_IMPL__OPERATION);

		// Create enums
		parameterPassTypeEnumEEnum = createEEnum(PARAMETER_PASS_TYPE_ENUM);
		signednessEnumEEnum = createEEnum(SIGNEDNESS_ENUM);
		constantTypeEnumEEnum = createEEnum(CONSTANT_TYPE_ENUM);

		// Create data types
		stringEDataType = createEDataType(STRING);
		verbatimStringEDataType = createEDataType(VERBATIM_STRING);
		cIdentifierEDataType = createEDataType(CIDENTIFIER);
		booleanEDataType = createEDataType(BOOLEAN);
		integerEDataType = createEDataType(INTEGER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		M2Package theM2Package = (M2Package)EPackage.Registry.INSTANCE.getEPackage(M2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		moduleReferrableEClass.getESuperTypes().add(this.getModuleObject());
		operationEClass.getESuperTypes().add(this.getModuleObject());
		writeApiEClass.getESuperTypes().add(this.getRteApi());
		sendOperationEClass.getESuperTypes().add(this.getOperation());
		rteBufferNonqueuedSendOperationEClass.getESuperTypes().add(this.getSendOperation());
		rteBufferNonqueuedReadOperationEClass.getESuperTypes().add(this.getReadOperation());
		readOperationEClass.getESuperTypes().add(this.getOperation());
		readApiEClass.getESuperTypes().add(this.getRteApi());
		rteBufferVariableSetEClass.getESuperTypes().add(this.getGlobalVariable());
		rteSourceEClass.getESuperTypes().add(this.getSourceFile());
		rteApiEClass.getESuperTypes().add(this.getFunction());
		globalVariableEClass.getESuperTypes().add(this.getVariable());
		fileEClass.getESuperTypes().add(this.getModuleReferrable());
		parameterEClass.getESuperTypes().add(this.getVariable());
		typeEClass.getESuperTypes().add(this.getModuleReferrable());
		localVariableEClass.getESuperTypes().add(this.getVariable());
		rteApplicationHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		functionEClass.getESuperTypes().add(this.getModuleReferrable());
		logicalCompartmentEClass.getESuperTypes().add(this.getModuleReferrable());
		coreEClass.getESuperTypes().add(this.getLogicalCompartment());
		partitionEClass.getESuperTypes().add(this.getLogicalCompartment());
		swcEClass.getESuperTypes().add(this.getLogicalCompartment());
		rteHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		rteLifecycleHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		rteApplicationTypeHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		rteVfbTraceHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		rteConfigurationHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		rteCallbackHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		rteTypeHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		invalidateApiEClass.getESuperTypes().add(this.getRteApi());
		iocNonqueuedSendOperationEClass.getESuperTypes().add(this.getSendOperation());
		directComSendOperationEClass.getESuperTypes().add(this.getComSendOperation());
		trustedFunctionComSendOperationEClass.getESuperTypes().add(this.getComSendOperation());
		immediateProxyComSendOperationEClass.getESuperTypes().add(this.getProxyComSendOperation());
		periodicProxyComSendOperationEClass.getESuperTypes().add(this.getProxyComSendOperation());
		iocNonqueuedReadOperationEClass.getESuperTypes().add(this.getReadOperation());
		comReadOperationEClass.getESuperTypes().add(this.getReadOperation());
		iocNonqueuedCommunicationEClass.getESuperTypes().add(this.getIocCommunication());
		iocWriteApiEClass.getESuperTypes().add(this.getIocApi());
		iocReadApiEClass.getESuperTypes().add(this.getIocApi());
		comSendSignalApiEClass.getESuperTypes().add(this.getComApi());
		comReceiveSignalApiEClass.getESuperTypes().add(this.getComApi());
		comReceiveCallbackEClass.getESuperTypes().add(this.getComCallback());
		comSendOperationEClass.getESuperTypes().add(this.getSendOperation());
		comCallbackEClass.getESuperTypes().add(this.getFunction());
		comReceiveTimeoutCallbackEClass.getESuperTypes().add(this.getComCallback());
		comInvalidateCallbackEClass.getESuperTypes().add(this.getComCallback());
		comSendSignalImmediateEntityEClass.getESuperTypes().add(this.getBswSchedulableEntity());
		comSendSignalPeriodicEntityEClass.getESuperTypes().add(this.getBswSchedulableEntity());
		filterOperationEClass.getESuperTypes().add(this.getOperation());
		maskedNewDiffersMaskedOldFilterOperationEClass.getESuperTypes().add(this.getFilterOperation());
		maskedNewDiffersXFilterOperationEClass.getESuperTypes().add(this.getFilterOperation());
		newIsWithinFilterOperationEClass.getESuperTypes().add(this.getFilterOperation());
		newIsOutsideFilterOperationEClass.getESuperTypes().add(this.getFilterOperation());
		maskedNewEqualsXFilterOperationEClass.getESuperTypes().add(this.getFilterOperation());
		oneEveryNFilterOperationEClass.getESuperTypes().add(this.getFilterOperation());
		rteCoreStartApiImplEClass.getESuperTypes().add(this.getRteLifecycleApi());
		rteStopApiEClass.getESuperTypes().add(this.getRteLifecycleApi());
		restartPartitionApiEClass.getESuperTypes().add(this.getRteLifecycleApi());
		partitionRestartingApiEClass.getESuperTypes().add(this.getRteLifecycleApi());
		partitionTerminatedApiEClass.getESuperTypes().add(this.getRteLifecycleApi());
		rteLifecycleApiEClass.getESuperTypes().add(this.getFunction());
		sendApiEClass.getESuperTypes().add(this.getRteApi());
		receiveApiEClass.getESuperTypes().add(this.getRteApi());
		rteBufferQueuedSendOperationEClass.getESuperTypes().add(this.getSendOperation());
		rteBufferQueuedVariableEClass.getESuperTypes().add(this.getGlobalVariable());
		rteBufferQueuedReadOperationEClass.getESuperTypes().add(this.getReadOperation());
		iocQueuedCommunicationEClass.getESuperTypes().add(this.getIocCommunication());
		iocReceiveApiEClass.getESuperTypes().add(this.getIocApi());
		iocSendApiEClass.getESuperTypes().add(this.getIocApi());
		iocQueuedSendOperationEClass.getESuperTypes().add(this.getSendOperation());
		iocQueuedReadOperationEClass.getESuperTypes().add(this.getReadOperation());
		callApiEClass.getESuperTypes().add(this.getRteApi());
		executableStartOperationEClass.getESuperTypes().add(this.getOperation());
		executableEntityEClass.getESuperTypes().add(this.getFunction());
		excludeOperationEClass.getESuperTypes().add(this.getOperation());
		allInterruptBlockExcludeOperationEClass.getESuperTypes().add(this.getExcludeOperation());
		osInterruptBlockExcludeOperationEClass.getESuperTypes().add(this.getExcludeOperation());
		osSpinlockExcludeOperationEClass.getESuperTypes().add(this.getExcludeOperation());
		osResourceExcludeOperationEClass.getESuperTypes().add(this.getExcludeOperation());
		constantEClass.getESuperTypes().add(this.getValue());
		bswSchedulableEntityEClass.getESuperTypes().add(this.getFunction());
		rteEnterApiEClass.getESuperTypes().add(this.getRteApi());
		rteExitApiEClass.getESuperTypes().add(this.getRteApi());
		osTaskActivationExecutableTaskBodyEClass.getESuperTypes().add(this.getTaskBody());
		osEventSetExecutableTaskBodyEClass.getESuperTypes().add(this.getTaskBody());
		osTaskActivationOperationEClass.getESuperTypes().add(this.getContextActivationOperation());
		osEventSetActivationOperationEClass.getESuperTypes().add(this.getContextActivationOperation());
		contextActivationOperationEClass.getESuperTypes().add(this.getOperation());
		timingTriggeringExecutableStartOperationEClass.getESuperTypes().add(this.getOperation());
		timingTriggeringExecutableStartOperationEClass.getESuperTypes().add(this.getExecutableStartOperation());
		cycleCountupOperationEClass.getESuperTypes().add(this.getOperation());
		startOffsetCountupOperationEClass.getESuperTypes().add(this.getOperation());
		taskBodyEClass.getESuperTypes().add(this.getFunction());
		iocEmptyQueueApiEClass.getESuperTypes().add(this.getIocApi());
		comApiEClass.getESuperTypes().add(this.getFunction());
		iocApiEClass.getESuperTypes().add(this.getFunction());
		rteEClass.getESuperTypes().add(this.getLogicalCompartment());
		valueEClass.getESuperTypes().add(this.getModuleReferrable());
		trustedFunctionEClass.getESuperTypes().add(this.getFunction());
		comSendSignalTrustedFunctionEClass.getESuperTypes().add(this.getTrustedFunction());
		osSetEventApiEClass.getESuperTypes().add(this.getOsApi());
		osApiEClass.getESuperTypes().add(this.getFunction());
		comSendSignalImmediateTaskBodyEClass.getESuperTypes().add(this.getTaskBody());
		variableEClass.getESuperTypes().add(this.getValue());
		comSendProxyOperationEClass.getESuperTypes().add(this.getOperation());
		iocReceiveGroupApiEClass.getESuperTypes().add(this.getIocApi());
		variableInitializeOperationEClass.getESuperTypes().add(this.getInitializeOperation());
		iocInitializeOperationEClass.getESuperTypes().add(this.getInitializeOperation());
		osSuspendAllInterruptsApiEClass.getESuperTypes().add(this.getOsApi());
		osGetSpinlockApiEClass.getESuperTypes().add(this.getOsApi());
		multicoreRteStartApiEClass.getESuperTypes().add(this.getRteLifecycleApi());
		multicoreRteStartApiEClass.getESuperTypes().add(this.getRteStartApi());
		rteBufferWriteTrustedFunctionEClass.getESuperTypes().add(this.getTrustedFunction());
		trustedFunctionRteBufferWriteSendOperationEClass.getESuperTypes().add(this.getSendOperation());
		proxyComSendOperationEClass.getESuperTypes().add(this.getComSendOperation());
		iocSendGroupApiEClass.getESuperTypes().add(this.getIocApi());
		iocQueuedGroupCommunicationEClass.getESuperTypes().add(this.getIocCommunication());
		directExecutableStartOperationEClass.getESuperTypes().add(this.getExecutableStartOperation());
		singlecoreRteStartApiEClass.getESuperTypes().add(this.getRteStartApi());
		rteStartApiEClass.getESuperTypes().add(this.getRteLifecycleApi());
		headerFileEClass.getESuperTypes().add(this.getFile());
		sourceFileEClass.getESuperTypes().add(this.getFile());
		rteInternalHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		primitiveTypeEClass.getESuperTypes().add(this.getType());
		unionTypeEClass.getESuperTypes().add(this.getType());
		blackboxTypeEClass.getESuperTypes().add(this.getType());
		variableMemberEClass.getESuperTypes().add(this.getVariable());
		rteUtilityHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		blackboxHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		rteBufferQueueTypeEClass.getESuperTypes().add(this.getBlackboxType());
		comSendTrustedFunctionParamTypeEClass.getESuperTypes().add(this.getBlackboxType());
		neverReadOperationEClass.getESuperTypes().add(this.getReadOperation());
		rteBufferInvalidateTrustedFunctionEClass.getESuperTypes().add(this.getTrustedFunction());
		trustedFunctionRteBufferInvalidateSendOperationEClass.getESuperTypes().add(this.getSendOperation());
		memoryMappingEClass.getESuperTypes().add(this.getModuleReferrable());
		swcMemoryMappingEClass.getESuperTypes().add(this.getMemoryMapping());
		bswMemoryMappingEClass.getESuperTypes().add(this.getMemoryMapping());
		globalVariableGroupEClass.getESuperTypes().add(this.getModuleObject());
		functionGroupEClass.getESuperTypes().add(this.getModuleObject());
		rteApiGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		rteLifecycleApiGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		taskBodyGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		bswSchedulableEntityGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		comCallbackGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		trustedFunctionGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		executableEntityGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		bswMemoryMappingHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		swcMemoryMappingHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		generationInfoEClass.getESuperTypes().add(this.getModuleObject());
		macroEClass.getESuperTypes().add(this.getModuleReferrable());
		schmApiEClass.getESuperTypes().add(this.getFunction());
		schmLifecycleApiEClass.getESuperTypes().add(this.getFunction());
		schmEnterApiEClass.getESuperTypes().add(this.getSchmApi());
		schmExitApiEClass.getESuperTypes().add(this.getSchmApi());
		moduleInterlinkHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		schmApiGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		moduleInterlinkTypeHeaderEClass.getESuperTypes().add(this.getHeaderFile());
		schmLifecycleApiGroupEClass.getESuperTypes().add(this.getFunctionGroup());
		partedBswmEClass.getESuperTypes().add(this.getLogicalCompartment());
		bswmEClass.getESuperTypes().add(this.getLogicalCompartment());
		schmDeinitApiEClass.getESuperTypes().add(this.getSchmLifecycleApi());
		schmInitApiEClass.getESuperTypes().add(this.getSchmLifecycleApi());
		singlecoreSchmInitApiEClass.getESuperTypes().add(this.getSchmInitApi());
		multicoreSchmInitApiEClass.getESuperTypes().add(this.getSchmInitApi());
		schmCoreInitApiImplEClass.getESuperTypes().add(this.getSchmLifecycleApi());

		// Initialize classes, features, and operations; add parameters
		initEClass(moduleObjectEClass, ModuleObject.class, "ModuleObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleObject_Source(), ecorePackage.getEObject(), null, "source", null, 0, -1, ModuleObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getModuleObject_SingleSource(), ecorePackage.getEObject(), null, "singleSource", null, 0, 1, ModuleObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModuleObject_RoleName(), this.getString(), "roleName", null, 0, 1, ModuleObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleReferrableEClass, ModuleReferrable.class, "ModuleReferrable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleReferrable_Id(), this.getString(), "id", null, 1, 1, ModuleReferrable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(writeApiEClass, WriteApi.class, "WriteApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWriteApi_Operation(), this.getSendOperation(), null, "operation", null, 0, -1, WriteApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWriteApi_DataParam(), this.getParameter(), null, "dataParam", null, 1, 1, WriteApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sendOperationEClass, SendOperation.class, "SendOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSendOperation_SendValue(), this.getValue(), null, "sendValue", null, 1, 1, SendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendOperation_SendStatus(), this.getValue(), null, "sendStatus", null, 1, 1, SendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendOperation_ExcludeOperation(), this.getExcludeOperation(), null, "excludeOperation", null, 0, 1, SendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendOperation_ReturnVariable(), this.getVariable(), null, "returnVariable", null, 0, 1, SendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteBufferNonqueuedSendOperationEClass, RteBufferNonqueuedSendOperation.class, "RteBufferNonqueuedSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferNonqueuedSendOperation_AccessVariable(), this.getRteBufferVariableSet(), null, "accessVariable", null, 1, 1, RteBufferNonqueuedSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteBufferNonqueuedSendOperation_FilterOperation(), this.getFilterOperation(), null, "filterOperation", null, 0, 1, RteBufferNonqueuedSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteBufferNonqueuedReadOperationEClass, RteBufferNonqueuedReadOperation.class, "RteBufferNonqueuedReadOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferNonqueuedReadOperation_AccessVariable(), this.getRteBufferVariableSet(), null, "accessVariable", null, 1, 1, RteBufferNonqueuedReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readOperationEClass, ReadOperation.class, "ReadOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReadOperation_InvalidValueConstant(), this.getConstant(), null, "invalidValueConstant", null, 0, 1, ReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReadOperation_ReadValueVariable(), this.getVariable(), null, "readValueVariable", null, 1, 1, ReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReadOperation_ReadStatusVariable(), this.getVariable(), null, "readStatusVariable", null, 0, 1, ReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReadOperation_ExcludeOperation(), this.getExcludeOperation(), null, "excludeOperation", null, 0, 1, ReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readApiEClass, ReadApi.class, "ReadApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReadApi_Operation(), this.getReadOperation(), null, "operation", null, 0, 1, ReadApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReadApi_DataParam(), this.getParameter(), null, "dataParam", null, 1, 1, ReadApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteBufferVariableSetEClass, RteBufferVariableSet.class, "RteBufferVariableSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferVariableSet_ValueVariable(), this.getGlobalVariable(), null, "valueVariable", null, 1, 1, RteBufferVariableSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteBufferVariableSet_StatusVariable(), this.getGlobalVariable(), null, "statusVariable", null, 0, 1, RteBufferVariableSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteSourceEClass, RteSource.class, "RteSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteSource_GlobalVariableGroup(), this.getGlobalVariableGroup(), null, "globalVariableGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_BswSchedulableEntityGroup(), this.getBswSchedulableEntityGroup(), null, "bswSchedulableEntityGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_RteApiGroup(), this.getRteApiGroup(), null, "rteApiGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_RteLifecycleApiGroup(), this.getRteLifecycleApiGroup(), null, "rteLifecycleApiGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_TaskBodyGroup(), this.getTaskBodyGroup(), null, "taskBodyGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_ComCallbackGroup(), this.getComCallbackGroup(), null, "comCallbackGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_TrustedFunctionGroup(), this.getTrustedFunctionGroup(), null, "trustedFunctionGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_SourceMacro(), this.getMacro(), null, "sourceMacro", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_SchmLifecycleApiGroup(), this.getSchmLifecycleApiGroup(), null, "schmLifecycleApiGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteSource_SchmApiGroup(), this.getSchmApiGroup(), null, "schmApiGroup", null, 0, -1, RteSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteApiEClass, RteApi.class, "RteApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRteApi_ApiMappingName(), this.getCIdentifier(), "apiMappingName", null, 1, 1, RteApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteApi_ReturnValue(), this.getValue(), null, "returnValue", null, 0, 1, RteApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRteApi_IsConnected(), this.getBoolean(), "isConnected", null, 1, 1, RteApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteApi_Parent(), this.getSwc(), this.getSwc_RteApi(), "parent", null, 1, 1, RteApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteModuleEClass, RteModule.class, "RteModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteModule_RteCommonSource(), this.getRteSource(), null, "rteCommonSource", null, 0, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RtePartitionSource(), this.getRteSource(), null, "rtePartitionSource", null, 0, -1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteApplicationHeader(), this.getRteApplicationHeader(), null, "rteApplicationHeader", null, 0, -1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteApplicationTypeHeader(), this.getRteApplicationTypeHeader(), null, "rteApplicationTypeHeader", null, 0, -1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteLifecycleHeader(), this.getRteLifecycleHeader(), null, "rteLifecycleHeader", null, 0, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteCallbackHeader(), this.getRteCallbackHeader(), null, "rteCallbackHeader", null, 0, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteConfigurationHeader(), this.getRteConfigurationHeader(), null, "rteConfigurationHeader", null, 0, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteVfbTraceHeader(), this.getRteVfbTraceHeader(), null, "rteVfbTraceHeader", null, 0, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteTypeHeader(), this.getRteTypeHeader(), null, "rteTypeHeader", null, 1, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteHeader(), this.getRteHeader(), null, "rteHeader", null, 1, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteCommonHeader(), this.getRteInternalHeader(), null, "rteCommonHeader", null, 0, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RtePartitionHeader(), this.getRteInternalHeader(), null, "rtePartitionHeader", null, 0, -1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_RteUtilityHeader(), this.getRteUtilityHeader(), null, "rteUtilityHeader", null, 0, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_DependentHeader(), this.getHeaderFile(), null, "dependentHeader", null, 0, -1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_BswMemoryMappingHeader(), this.getBswMemoryMappingHeader(), null, "bswMemoryMappingHeader", null, 0, 1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_SwcMemoryMappingHeader(), this.getSwcMemoryMappingHeader(), null, "swcMemoryMappingHeader", null, 0, -1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_ModuleInterlinkHeader(), this.getModuleInterlinkHeader(), null, "moduleInterlinkHeader", null, 0, -1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteModule_ModuleInterlinkTypeHeader(), this.getModuleInterlinkTypeHeader(), null, "moduleInterlinkTypeHeader", null, 0, -1, RteModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalVariableEClass, GlobalVariable.class, "GlobalVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalVariable_InitValueConstant(), this.getConstant(), null, "initValueConstant", null, 0, 1, GlobalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGlobalVariable_MemoryMapping(), this.getMemoryMapping(), null, "memoryMapping", null, 0, 1, GlobalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGlobalVariable_InitAtDefinition(), this.getBoolean(), "initAtDefinition", null, 1, 1, GlobalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileEClass, File.class, "File", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFile_FileName(), this.getString(), "fileName", null, 1, 1, File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFile_GenerationInfo(), this.getGenerationInfo(), null, "generationInfo", null, 0, 1, File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_PassType(), this.getParameterPassTypeEnum(), "passType", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_SymbolName(), this.getCIdentifier(), "symbolName", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_IsAnonymous(), this.getBoolean(), "isAnonymous", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localVariableEClass, LocalVariable.class, "LocalVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocalVariable_InitValueConstant(), this.getConstant(), null, "initValueConstant", null, 0, 1, LocalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalVariable_Parent(), this.getFunction(), this.getFunction_LocalVariable(), "parent", null, 1, 1, LocalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteApplicationHeaderEClass, RteApplicationHeader.class, "RteApplicationHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteApplicationHeader_RteApiGroup(), this.getRteApiGroup(), null, "rteApiGroup", null, 0, -1, RteApplicationHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteApplicationHeader_Constant(), this.getConstant(), null, "constant", null, 0, -1, RteApplicationHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteApplicationHeader_DependentExecutableEntityGroup(), this.getExecutableEntityGroup(), null, "dependentExecutableEntityGroup", null, 0, -1, RteApplicationHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_ReturnType(), this.getType(), null, "returnType", null, 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Param(), this.getParameter(), null, "param", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_LocalVariable(), this.getLocalVariable(), this.getLocalVariable_Parent(), "localVariable", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_LocalType(), this.getType(), null, "localType", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_MemoryMapping(), this.getMemoryMapping(), null, "memoryMapping", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_SymbolName(), this.getCIdentifier(), "symbolName", null, 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logicalCompartmentEClass, LogicalCompartment.class, "LogicalCompartment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogicalCompartment_CompartmentName(), this.getString(), "compartmentName", null, 1, 1, LogicalCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coreEClass, Core.class, "Core", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCore_Partition(), this.getPartition(), this.getPartition_Parent(), "partition", null, 0, -1, Core.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCore_RteStartApi(), this.getRteCoreStartApiImpl(), this.getRteCoreStartApiImpl_Parent(), "rteStartApi", null, 1, 1, Core.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCore_CoreId(), this.getInteger(), "coreId", null, 1, 1, Core.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCore_IsMasterCore(), this.getBoolean(), "isMasterCore", null, 1, 1, Core.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCore_SchmInitApi(), this.getSchmCoreInitApiImpl(), this.getSchmCoreInitApiImpl_Parent(), "schmInitApi", null, 1, 1, Core.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partitionEClass, Partition.class, "Partition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPartition_IsBswPartition(), this.getBoolean(), "isBswPartition", null, 1, 1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_Parent(), this.getCore(), this.getCore_Partition(), "parent", null, 1, 1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_Swc(), this.getSwc(), this.getSwc_Parent(), "swc", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_RteBufferVariableSet(), this.getRteBufferVariableSet(), null, "rteBufferVariableSet", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_FilterOldValueVariable(), this.getGlobalVariable(), null, "filterOldValueVariable", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPartition_FilterOccurrenceVariable(), this.getGlobalVariable(), null, "filterOccurrenceVariable", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPartition_RestartPartitionApi(), this.getRestartPartitionApi(), null, "restartPartitionApi", null, 0, 1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_PartitionTerminatedApi(), this.getPartitionTerminatedApi(), null, "partitionTerminatedApi", null, 1, 1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_PartitionRestartingApi(), this.getPartitionRestartingApi(), null, "partitionRestartingApi", null, 0, 1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_TaskBody(), this.getTaskBody(), null, "taskBody", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_RteBufferQueuedVariable(), this.getRteBufferQueuedVariable(), null, "rteBufferQueuedVariable", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_RteBufferInitValueConstant(), this.getConstant(), null, "rteBufferInitValueConstant", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_EntityStartVariable(), this.getGlobalVariable(), null, "entityStartVariable", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_EntityStartConstant(), this.getConstant(), null, "entityStartConstant", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_FilterConstant(), this.getConstant(), null, "filterConstant", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_RteBufferSendTrustedFunction(), this.getTrustedFunction(), null, "rteBufferSendTrustedFunction", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_OsTrustedMacro(), this.getMacro(), null, "osTrustedMacro", null, 0, 1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_PartedBswm(), this.getPartedBswm(), this.getPartedBswm_Parent(), "partedBswm", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swcEClass, Swc.class, "Swc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwc_Parent(), this.getPartition(), this.getPartition_Swc(), "parent", null, 1, 1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_RteApi(), this.getRteApi(), this.getRteApi_Parent(), "rteApi", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_ApiInitValueConstant(), this.getConstant(), null, "apiInitValueConstant", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_ApiApplicationErrorConstant(), this.getConstant(), null, "apiApplicationErrorConstant", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_ApiEnumConstant(), this.getConstant(), null, "apiEnumConstant", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_ApiUpperLowerLimitConstant(), this.getConstant(), null, "apiUpperLowerLimitConstant", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_FilterConstant(), this.getConstant(), null, "filterConstant", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_PortArgValueConstant(), this.getConstant(), null, "portArgValueConstant", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_DependentExecutableEntity(), this.getExecutableEntity(), null, "dependentExecutableEntity", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_InvalidValueConstant(), this.getConstant(), null, "invalidValueConstant", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_ImplInitValueConstant(), this.getConstant(), null, "implInitValueConstant", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwc_SwcMemoryMapping(), this.getSwcMemoryMapping(), null, "swcMemoryMapping", null, 0, -1, Swc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteHeaderEClass, RteHeader.class, "RteHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rteLifecycleHeaderEClass, RteLifecycleHeader.class, "RteLifecycleHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteLifecycleHeader_RteLifecycleApiGroup(), this.getRteLifecycleApiGroup(), null, "rteLifecycleApiGroup", null, 0, -1, RteLifecycleHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteLifecycleHeader_SchmLifecycleApiGroup(), this.getSchmLifecycleApiGroup(), null, "schmLifecycleApiGroup", null, 0, -1, RteLifecycleHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteApplicationTypeHeaderEClass, RteApplicationTypeHeader.class, "RteApplicationTypeHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteApplicationTypeHeader_Constant(), this.getConstant(), null, "constant", null, 0, -1, RteApplicationTypeHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteVfbTraceHeaderEClass, RteVfbTraceHeader.class, "RteVfbTraceHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rteConfigurationHeaderEClass, RteConfigurationHeader.class, "RteConfigurationHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rteCallbackHeaderEClass, RteCallbackHeader.class, "RteCallbackHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteCallbackHeader_ComCallbackGroup(), this.getComCallbackGroup(), null, "comCallbackGroup", null, 0, -1, RteCallbackHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteTypeHeaderEClass, RteTypeHeader.class, "RteTypeHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteTypeHeader_RteType(), this.getType(), null, "rteType", null, 0, -1, RteTypeHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteTypeHeader_RteTypeConstant(), this.getConstant(), null, "rteTypeConstant", null, 0, -1, RteTypeHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invalidateApiEClass, InvalidateApi.class, "InvalidateApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvalidateApi_Operation(), this.getSendOperation(), null, "operation", null, 0, -1, InvalidateApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocNonqueuedSendOperationEClass, IocNonqueuedSendOperation.class, "IocNonqueuedSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocNonqueuedSendOperation_AccessApi(), this.getIocWriteApi(), null, "accessApi", null, 1, 1, IocNonqueuedSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directComSendOperationEClass, DirectComSendOperation.class, "DirectComSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trustedFunctionComSendOperationEClass, TrustedFunctionComSendOperation.class, "TrustedFunctionComSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrustedFunctionComSendOperation_AccessTrustedFunction(), this.getComSendSignalTrustedFunction(), null, "accessTrustedFunction", null, 1, 1, TrustedFunctionComSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrustedFunctionComSendOperation_TrustedFunctionParamVariable(), this.getVariable(), null, "trustedFunctionParamVariable", null, 1, 1, TrustedFunctionComSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(immediateProxyComSendOperationEClass, ImmediateProxyComSendOperation.class, "ImmediateProxyComSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImmediateProxyComSendOperation_ActivationApi(), this.getOsSetEventApi(), null, "activationApi", null, 1, 1, ImmediateProxyComSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(periodicProxyComSendOperationEClass, PeriodicProxyComSendOperation.class, "PeriodicProxyComSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iocNonqueuedReadOperationEClass, IocNonqueuedReadOperation.class, "IocNonqueuedReadOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocNonqueuedReadOperation_AccessApi(), this.getIocReadApi(), null, "accessApi", null, 1, 1, IocNonqueuedReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comReadOperationEClass, ComReadOperation.class, "ComReadOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComReadOperation_AccessApi(), this.getComReceiveSignalApi(), null, "accessApi", null, 1, 1, ComReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocNonqueuedCommunicationEClass, IocNonqueuedCommunication.class, "IocNonqueuedCommunication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocNonqueuedCommunication_WriteApi(), this.getIocWriteApi(), this.getIocWriteApi_Parent(), "writeApi", null, 0, -1, IocNonqueuedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIocNonqueuedCommunication_ReadApi(), this.getIocReadApi(), null, "readApi", null, 1, 1, IocNonqueuedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIocNonqueuedCommunication_InitValue(), this.getConstant(), null, "initValue", null, 1, 1, IocNonqueuedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocWriteApiEClass, IocWriteApi.class, "IocWriteApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocWriteApi_Parent(), this.getIocNonqueuedCommunication(), this.getIocNonqueuedCommunication_WriteApi(), "parent", null, 1, 1, IocWriteApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocReadApiEClass, IocReadApi.class, "IocReadApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(comSendSignalApiEClass, ComSendSignalApi.class, "ComSendSignalApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(comReceiveSignalApiEClass, ComReceiveSignalApi.class, "ComReceiveSignalApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(comReceiveCallbackEClass, ComReceiveCallback.class, "ComReceiveCallback", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComReceiveCallback_Operation(), this.getSendOperation(), null, "operation", null, 0, -1, ComReceiveCallback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComReceiveCallback_DataVariable(), this.getLocalVariable(), null, "dataVariable", null, 1, 1, ComReceiveCallback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComReceiveCallback_AccessApi(), this.getComReceiveSignalApi(), null, "accessApi", null, 1, 1, ComReceiveCallback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comSendOperationEClass, ComSendOperation.class, "ComSendOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComSendOperation_AccessApi(), this.getComSendSignalApi(), null, "accessApi", null, 1, 1, ComSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comCallbackEClass, ComCallback.class, "ComCallback", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(comReceiveTimeoutCallbackEClass, ComReceiveTimeoutCallback.class, "ComReceiveTimeoutCallback", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComReceiveTimeoutCallback_Operation(), this.getSendOperation(), null, "operation", null, 0, -1, ComReceiveTimeoutCallback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComReceiveTimeoutCallback_DataVariable(), this.getLocalVariable(), null, "dataVariable", null, 1, 1, ComReceiveTimeoutCallback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComReceiveTimeoutCallback_AccessApi(), this.getComReceiveSignalApi(), null, "accessApi", null, 1, 1, ComReceiveTimeoutCallback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comInvalidateCallbackEClass, ComInvalidateCallback.class, "ComInvalidateCallback", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComInvalidateCallback_Operation(), this.getSendOperation(), null, "operation", null, 0, -1, ComInvalidateCallback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComInvalidateCallback_FilterResultVariable(), this.getLocalVariable(), null, "filterResultVariable", null, 0, 1, ComInvalidateCallback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comSendSignalImmediateEntityEClass, ComSendSignalImmediateEntity.class, "ComSendSignalImmediateEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComSendSignalImmediateEntity_Operation(), this.getComSendProxyOperation(), null, "operation", null, 0, -1, ComSendSignalImmediateEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comSendSignalPeriodicEntityEClass, ComSendSignalPeriodicEntity.class, "ComSendSignalPeriodicEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComSendSignalPeriodicEntity_Operation(), this.getComSendProxyOperation(), null, "operation", null, 0, -1, ComSendSignalPeriodicEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterOperationEClass, FilterOperation.class, "FilterOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilterOperation_FilterResultVariable(), this.getVariable(), null, "filterResultVariable", null, 1, 1, FilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(maskedNewDiffersMaskedOldFilterOperationEClass, MaskedNewDiffersMaskedOldFilterOperation.class, "MaskedNewDiffersMaskedOldFilterOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMaskedNewDiffersMaskedOldFilterOperation_OldValueVariable(), this.getGlobalVariable(), null, "oldValueVariable", null, 1, 1, MaskedNewDiffersMaskedOldFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMaskedNewDiffersMaskedOldFilterOperation_Mask(), this.getConstant(), null, "mask", null, 1, 1, MaskedNewDiffersMaskedOldFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(maskedNewDiffersXFilterOperationEClass, MaskedNewDiffersXFilterOperation.class, "MaskedNewDiffersXFilterOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMaskedNewDiffersXFilterOperation_Mask(), this.getConstant(), null, "mask", null, 1, 1, MaskedNewDiffersXFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMaskedNewDiffersXFilterOperation_X(), this.getConstant(), null, "x", null, 1, 1, MaskedNewDiffersXFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newIsWithinFilterOperationEClass, NewIsWithinFilterOperation.class, "NewIsWithinFilterOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewIsWithinFilterOperation_Min(), this.getConstant(), null, "min", null, 1, 1, NewIsWithinFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewIsWithinFilterOperation_Max(), this.getConstant(), null, "max", null, 1, 1, NewIsWithinFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newIsOutsideFilterOperationEClass, NewIsOutsideFilterOperation.class, "NewIsOutsideFilterOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewIsOutsideFilterOperation_Min(), this.getConstant(), null, "min", null, 1, 1, NewIsOutsideFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewIsOutsideFilterOperation_Max(), this.getConstant(), null, "max", null, 1, 1, NewIsOutsideFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(maskedNewEqualsXFilterOperationEClass, MaskedNewEqualsXFilterOperation.class, "MaskedNewEqualsXFilterOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMaskedNewEqualsXFilterOperation_Mask(), this.getConstant(), null, "mask", null, 1, 1, MaskedNewEqualsXFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMaskedNewEqualsXFilterOperation_X(), this.getConstant(), null, "x", null, 1, 1, MaskedNewEqualsXFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oneEveryNFilterOperationEClass, OneEveryNFilterOperation.class, "OneEveryNFilterOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOneEveryNFilterOperation_OccurrenceVariable(), this.getGlobalVariable(), null, "occurrenceVariable", null, 1, 1, OneEveryNFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOneEveryNFilterOperation_Period(), this.getConstant(), null, "period", null, 1, 1, OneEveryNFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOneEveryNFilterOperation_Offset(), this.getConstant(), null, "offset", null, 1, 1, OneEveryNFilterOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteCoreStartApiImplEClass, RteCoreStartApiImpl.class, "RteCoreStartApiImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteCoreStartApiImpl_Operation(), this.getInitializeOperation(), null, "operation", null, 0, -1, RteCoreStartApiImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteCoreStartApiImpl_Parent(), this.getCore(), this.getCore_RteStartApi(), "parent", null, 1, 1, RteCoreStartApiImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteStopApiEClass, RteStopApi.class, "RteStopApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(restartPartitionApiEClass, RestartPartitionApi.class, "RestartPartitionApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRestartPartitionApi_EReference0(), this.getGlobalVariable(), null, "EReference0", null, 0, 1, RestartPartitionApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestartPartitionApi_EReference1(), this.getIocApi(), null, "EReference1", null, 0, 1, RestartPartitionApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestartPartitionApi_Operation(), this.getInitializeOperation(), null, "operation", null, 0, -1, RestartPartitionApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partitionRestartingApiEClass, PartitionRestartingApi.class, "PartitionRestartingApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartitionRestartingApi_Operation(), this.getInterPartitionTimeoutOperation(), null, "operation", null, 0, 1, PartitionRestartingApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partitionTerminatedApiEClass, PartitionTerminatedApi.class, "PartitionTerminatedApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartitionTerminatedApi_Operation(), this.getInterPartitionTimeoutOperation(), null, "operation", null, 0, 1, PartitionTerminatedApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteLifecycleApiEClass, RteLifecycleApi.class, "RteLifecycleApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sendApiEClass, SendApi.class, "SendApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSendApi_Operation(), this.getSendOperation(), null, "operation", null, 0, -1, SendApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendApi_DataParam(), this.getParameter(), null, "dataParam", null, 1, 1, SendApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendApi_StatusVariable(), this.getLocalVariable(), null, "statusVariable", null, 1, 1, SendApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendApi_TrustedFunctionParamVariable(), this.getLocalVariable(), null, "trustedFunctionParamVariable", null, 0, 1, SendApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendApi_FilterResultVariable(), this.getLocalVariable(), null, "filterResultVariable", null, 0, 1, SendApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(receiveApiEClass, ReceiveApi.class, "ReceiveApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReceiveApi_Operation(), this.getReadOperation(), null, "operation", null, 0, 1, ReceiveApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReceiveApi_DataParam(), this.getParameter(), null, "dataParam", null, 1, 1, ReceiveApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReceiveApi_StatusVariable(), this.getLocalVariable(), null, "statusVariable", null, 1, 1, ReceiveApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteBufferQueuedSendOperationEClass, RteBufferQueuedSendOperation.class, "RteBufferQueuedSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferQueuedSendOperation_AccessVariable(), this.getRteBufferQueuedVariable(), null, "accessVariable", null, 1, 1, RteBufferQueuedSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteBufferQueuedSendOperation_TempReturnVariable(), this.getVariable(), null, "tempReturnVariable", null, 0, 1, RteBufferQueuedSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteBufferQueuedVariableEClass, RteBufferQueuedVariable.class, "RteBufferQueuedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferQueuedVariable_QueueType(), this.getRteBufferQueueType(), null, "queueType", null, 1, 1, RteBufferQueuedVariable.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(rteBufferQueuedReadOperationEClass, RteBufferQueuedReadOperation.class, "RteBufferQueuedReadOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferQueuedReadOperation_AccessVariable(), this.getRteBufferQueuedVariable(), null, "accessVariable", null, 1, 1, RteBufferQueuedReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocQueuedCommunicationEClass, IocQueuedCommunication.class, "IocQueuedCommunication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocQueuedCommunication_SendApi(), this.getIocSendApi(), null, "sendApi", null, 0, -1, IocQueuedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIocQueuedCommunication_ReceiveApi(), this.getIocReceiveApi(), null, "receiveApi", null, 1, 1, IocQueuedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIocQueuedCommunication_IocEmptyQueueApi(), this.getIocEmptyQueueApi(), null, "IocEmptyQueueApi", null, 1, 1, IocQueuedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocReceiveApiEClass, IocReceiveApi.class, "IocReceiveApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iocSendApiEClass, IocSendApi.class, "IocSendApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iocQueuedSendOperationEClass, IocQueuedSendOperation.class, "IocQueuedSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocQueuedSendOperation_AccessApi(), this.getIocSendApi(), null, "accessApi", null, 1, 1, IocQueuedSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocQueuedReadOperationEClass, IocQueuedReadOperation.class, "IocQueuedReadOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocQueuedReadOperation_AccessApi(), this.getIocReceiveApi(), null, "accessApi", null, 1, 1, IocQueuedReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callApiEClass, CallApi.class, "CallApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallApi_Operation(), this.getDirectExecutableStartOperation(), null, "operation", null, 0, 1, CallApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallApi_OperationParam(), this.getParameter(), null, "operationParam", null, 0, -1, CallApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallApi_PortArgValue(), this.getConstant(), null, "portArgValue", null, 0, -1, CallApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallApi_ReturnVariable(), this.getLocalVariable(), null, "returnVariable", null, 0, 1, CallApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executableStartOperationEClass, ExecutableStartOperation.class, "ExecutableStartOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutableStartOperation_ExcludeOperation(), this.getExcludeOperation(), null, "excludeOperation", null, 0, -1, ExecutableStartOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutableStartOperation_StartExecutable(), this.getExecutableEntity(), null, "startExecutable", null, 1, 1, ExecutableStartOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executableEntityEClass, ExecutableEntity.class, "ExecutableEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutableEntity_RoleParam(), this.getParameter(), null, "roleParam", null, 0, -1, ExecutableEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutableEntity_ParentPartedBswm(), this.getPartedBswm(), this.getPartedBswm_DependentExecutableEntity(), "parentPartedBswm", null, 0, 1, ExecutableEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(excludeOperationEClass, ExcludeOperation.class, "ExcludeOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(allInterruptBlockExcludeOperationEClass, AllInterruptBlockExcludeOperation.class, "AllInterruptBlockExcludeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(osInterruptBlockExcludeOperationEClass, OsInterruptBlockExcludeOperation.class, "OsInterruptBlockExcludeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(osSpinlockExcludeOperationEClass, OsSpinlockExcludeOperation.class, "OsSpinlockExcludeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOsSpinlockExcludeOperation_OsSpinlockId(), this.getCIdentifier(), "osSpinlockId", null, 1, 1, OsSpinlockExcludeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(osResourceExcludeOperationEClass, OsResourceExcludeOperation.class, "OsResourceExcludeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOsResourceExcludeOperation_OsResourceId(), this.getCIdentifier(), "osResourceId", null, 1, 1, OsResourceExcludeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstant_SymbolName(), this.getCIdentifier(), "symbolName", null, 1, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstant_Type(), this.getPrimitiveType(), null, "type", null, 1, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstant_Value(), this.getVerbatimString(), "value", null, 1, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstant_ConstantType(), this.getConstantTypeEnum(), "constantType", null, 1, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bswSchedulableEntityEClass, BswSchedulableEntity.class, "BswSchedulableEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rteEnterApiEClass, RteEnterApi.class, "RteEnterApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteEnterApi_Operation(), this.getExcludeOperation(), null, "operation", null, 1, 1, RteEnterApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteExitApiEClass, RteExitApi.class, "RteExitApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteExitApi_Operation(), this.getExcludeOperation(), null, "operation", null, 1, 1, RteExitApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(osTaskActivationExecutableTaskBodyEClass, OsTaskActivationExecutableTaskBody.class, "OsTaskActivationExecutableTaskBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOsTaskActivationExecutableTaskBody_Operation(), this.getOsTaskActivationOperation(), null, "operation", null, 1, 1, OsTaskActivationExecutableTaskBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(osEventSetExecutableTaskBodyEClass, OsEventSetExecutableTaskBody.class, "OsEventSetExecutableTaskBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOsEventSetExecutableTaskBody_Operation(), this.getOsEventSetActivationOperation(), null, "operation", null, 0, -1, OsEventSetExecutableTaskBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOsEventSetExecutableTaskBody_OsEventId(), this.getCIdentifier(), "osEventId", null, 1, -1, OsEventSetExecutableTaskBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOsEventSetExecutableTaskBody_ChecksOsEventId(), this.getBoolean(), "checksOsEventId", null, 1, 1, OsEventSetExecutableTaskBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOsEventSetExecutableTaskBody_EventVariable(), this.getVariable(), null, "eventVariable", null, 0, 1, OsEventSetExecutableTaskBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(osTaskActivationOperationEClass, OsTaskActivationOperation.class, "OsTaskActivationOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(osEventSetActivationOperationEClass, OsEventSetActivationOperation.class, "OsEventSetActivationOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOsEventSetActivationOperation_ActivationOsEventId(), this.getCIdentifier(), "activationOsEventId", null, 1, 1, OsEventSetActivationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextActivationOperationEClass, ContextActivationOperation.class, "ContextActivationOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextActivationOperation_ExecutableStartOperation(), this.getExecutableStartOperation(), null, "executableStartOperation", null, 0, -1, ContextActivationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextActivationOperation_CycleCountupOperation(), this.getCycleCountupOperation(), null, "cycleCountupOperation", null, 0, 1, ContextActivationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextActivationOperation_StartOffsetCountupOperation(), this.getStartOffsetCountupOperation(), null, "startOffsetCountupOperation", null, 0, 1, ContextActivationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timingTriggeringExecutableStartOperationEClass, TimingTriggeringExecutableStartOperation.class, "TimingTriggeringExecutableStartOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimingTriggeringExecutableStartOperation_CyclePeriodConstant(), this.getConstant(), null, "cyclePeriodConstant", null, 0, 1, TimingTriggeringExecutableStartOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimingTriggeringExecutableStartOperation_CycleOffsetConstant(), this.getConstant(), null, "cycleOffsetConstant", null, 0, 1, TimingTriggeringExecutableStartOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimingTriggeringExecutableStartOperation_StartOffsetConstant(), this.getConstant(), null, "startOffsetConstant", null, 0, 1, TimingTriggeringExecutableStartOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimingTriggeringExecutableStartOperation_StartOffsetCounterVariable(), this.getGlobalVariable(), null, "startOffsetCounterVariable", null, 0, 1, TimingTriggeringExecutableStartOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimingTriggeringExecutableStartOperation_CycleCounterVariable(), this.getGlobalVariable(), null, "cycleCounterVariable", null, 0, 1, TimingTriggeringExecutableStartOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cycleCountupOperationEClass, CycleCountupOperation.class, "CycleCountupOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCycleCountupOperation_CounterVariable(), this.getGlobalVariable(), null, "counterVariable", null, 1, 1, CycleCountupOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCycleCountupOperation_MaxConstant(), this.getConstant(), null, "maxConstant", null, 1, 1, CycleCountupOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startOffsetCountupOperationEClass, StartOffsetCountupOperation.class, "StartOffsetCountupOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStartOffsetCountupOperation_CounterVariable(), this.getGlobalVariable(), null, "counterVariable", null, 1, 1, StartOffsetCountupOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStartOffsetCountupOperation_MaxConstant(), this.getConstant(), null, "maxConstant", null, 1, 1, StartOffsetCountupOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskBodyEClass, TaskBody.class, "TaskBody", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTaskBody_OsTaskId(), this.getCIdentifier(), "osTaskId", null, 0, 1, TaskBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocEmptyQueueApiEClass, IocEmptyQueueApi.class, "IocEmptyQueueApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(comApiEClass, ComApi.class, "ComApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComApi_ComSignalSymbolName(), this.getCIdentifier(), "comSignalSymbolName", null, 1, 1, ComApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocApiEClass, IocApi.class, "IocApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rteEClass, Rte.class, "Rte", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRte_Core(), this.getCore(), null, "core", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_ComCallback(), this.getComCallback(), null, "comCallback", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_ComSendSignalPeriodicEntity(), this.getComSendSignalPeriodicEntity(), null, "comSendSignalPeriodicEntity", null, 0, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_ComSendSignalImmediateEntity(), this.getComSendSignalImmediateEntity(), null, "comSendSignalImmediateEntity", null, 0, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_ComSendSignalTrustedFunction(), this.getComSendSignalTrustedFunction(), null, "comSendSignalTrustedFunction", null, 0, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_DependentType(), this.getType(), null, "dependentType", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_RteType(), this.getType(), null, "rteType", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_DependentOsApi(), this.getOsApi(), null, "dependentOsApi", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_DependentIocCommunication(), this.getIocCommunication(), null, "dependentIocCommunication", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_DependentComApi(), this.getComApi(), null, "dependentComApi", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_RteStartApi(), this.getRteStartApi(), null, "rteStartApi", null, 0, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_IocInitValueConstant(), this.getConstant(), null, "iocInitValueConstant", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_DependentConstant(), this.getConstant(), null, "dependentConstant", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_ComSendSignalImmediateTaskBody(), this.getComSendSignalImmediateTaskBody(), null, "comSendSignalImmediateTaskBody", null, 0, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_RteStopApi(), this.getRteStopApi(), null, "rteStopApi", null, 1, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_RteTypeConstant(), this.getConstant(), null, "rteTypeConstant", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_RteMemoryMapping(), this.getBswMemoryMapping(), null, "rteMemoryMapping", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_GenerationInfo(), this.getGenerationInfo(), null, "generationInfo", null, 1, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_Bswm(), this.getBswm(), null, "bswm", null, 0, -1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_SchmInitApi(), this.getSchmInitApi(), null, "schmInitApi", null, 0, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRte_SchmDeinitApi(), this.getSchmDeinitApi(), null, "schmDeinitApi", null, 1, 1, Rte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trustedFunctionEClass, TrustedFunction.class, "TrustedFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTrustedFunction_TrustedFunctionIndex(), this.getCIdentifier(), "trustedFunctionIndex", null, 1, 1, TrustedFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comSendSignalTrustedFunctionEClass, ComSendSignalTrustedFunction.class, "ComSendSignalTrustedFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(osSetEventApiEClass, OsSetEventApi.class, "OsSetEventApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOsSetEventApi_OsTaskId(), this.getCIdentifier(), "osTaskId", null, 1, 1, OsSetEventApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOsSetEventApi_OsEventId(), this.getCIdentifier(), "osEventId", null, 1, 1, OsSetEventApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(osApiEClass, OsApi.class, "OsApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(comSendSignalImmediateTaskBodyEClass, ComSendSignalImmediateTaskBody.class, "ComSendSignalImmediateTaskBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComSendSignalImmediateTaskBody_StartEntity(), this.getComSendSignalImmediateEntity(), null, "startEntity", null, 1, 1, ComSendSignalImmediateTaskBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComSendSignalImmediateTaskBody_OsEventId(), this.getCIdentifier(), "osEventId", null, 1, 1, ComSendSignalImmediateTaskBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariable_Type(), this.getType(), null, "type", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_Member(), this.getVariableMember(), this.getVariableMember_Parent(), "member", null, 0, -1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_SymbolName(), this.getCIdentifier(), "symbolName", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comSendProxyOperationEClass, ComSendProxyOperation.class, "ComSendProxyOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComSendProxyOperation_ReadValueVariable(), this.getVariable(), null, "readValueVariable", null, 1, 1, ComSendProxyOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComSendProxyOperation_AccessApi(), this.getIocReceiveGroupApi(), null, "accessApi", null, 1, 1, ComSendProxyOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComSendProxyOperation_SignalIdVariable(), this.getVariable(), null, "signalIdVariable", null, 1, 1, ComSendProxyOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocReceiveGroupApiEClass, IocReceiveGroupApi.class, "IocReceiveGroupApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moduleRootEClass, ModuleRoot.class, "ModuleRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleRoot_RteModule(), this.getRteModule(), null, "rteModule", null, 1, 1, ModuleRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleRoot_Rte(), this.getRte(), null, "rte", null, 1, 1, ModuleRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interPartitionTimeoutOperationEClass, InterPartitionTimeoutOperation.class, "InterPartitionTimeoutOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterPartitionTimeoutOperation_TimeoutVariable(), this.getRteBufferVariableSet(), null, "timeoutVariable", null, 1, -1, InterPartitionTimeoutOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterPartitionTimeoutOperation_ExcludeOperation(), this.getExcludeOperation(), null, "excludeOperation", null, 0, 1, InterPartitionTimeoutOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initializeOperationEClass, InitializeOperation.class, "InitializeOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableInitializeOperationEClass, VariableInitializeOperation.class, "VariableInitializeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableInitializeOperation_InitVariable(), this.getGlobalVariable(), null, "initVariable", null, 0, -1, VariableInitializeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableInitializeOperation_ExcludeOperation(), this.getExcludeOperation(), null, "excludeOperation", null, 0, 1, VariableInitializeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocInitializeOperationEClass, IocInitializeOperation.class, "IocInitializeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocInitializeOperation_InitIocApi(), this.getIocApi(), null, "initIocApi", null, 0, -1, IocInitializeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(osSuspendAllInterruptsApiEClass, OsSuspendAllInterruptsApi.class, "OsSuspendAllInterruptsApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(osGetSpinlockApiEClass, OsGetSpinlockApi.class, "OsGetSpinlockApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multicoreRteStartApiEClass, MulticoreRteStartApi.class, "MulticoreRteStartApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMulticoreRteStartApi_CoreStartApiImpl(), this.getRteCoreStartApiImpl(), null, "coreStartApiImpl", null, 0, -1, MulticoreRteStartApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteBufferWriteTrustedFunctionEClass, RteBufferWriteTrustedFunction.class, "RteBufferWriteTrustedFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferWriteTrustedFunction_Operation(), this.getRteBufferNonqueuedSendOperation(), null, "operation", null, 1, 1, RteBufferWriteTrustedFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteBufferWriteTrustedFunction_DataVariable(), this.getLocalVariable(), null, "dataVariable", null, 1, 1, RteBufferWriteTrustedFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trustedFunctionRteBufferWriteSendOperationEClass, TrustedFunctionRteBufferWriteSendOperation.class, "TrustedFunctionRteBufferWriteSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrustedFunctionRteBufferWriteSendOperation_AccessTrustedFunction(), this.getRteBufferWriteTrustedFunction(), null, "accessTrustedFunction", null, 1, 1, TrustedFunctionRteBufferWriteSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocCommunicationEClass, IocCommunication.class, "IocCommunication", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyComSendOperationEClass, ProxyComSendOperation.class, "ProxyComSendOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProxyComSendOperation_AccessProxyApi(), this.getIocSendGroupApi(), null, "accessProxyApi", null, 0, 1, ProxyComSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iocSendGroupApiEClass, IocSendGroupApi.class, "IocSendGroupApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iocQueuedGroupCommunicationEClass, IocQueuedGroupCommunication.class, "IocQueuedGroupCommunication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIocQueuedGroupCommunication_ReceiveApi(), this.getIocReceiveGroupApi(), null, "receiveApi", null, 1, 1, IocQueuedGroupCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIocQueuedGroupCommunication_SendApi(), this.getIocSendGroupApi(), null, "sendApi", null, 1, 1, IocQueuedGroupCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directExecutableStartOperationEClass, DirectExecutableStartOperation.class, "DirectExecutableStartOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(singlecoreRteStartApiEClass, SinglecoreRteStartApi.class, "SinglecoreRteStartApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSinglecoreRteStartApi_Operation(), this.getInitializeOperation(), null, "operation", null, 0, -1, SinglecoreRteStartApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteStartApiEClass, RteStartApi.class, "RteStartApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(headerFileEClass, HeaderFile.class, "HeaderFile", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHeaderFile_GuardName(), this.getString(), "guardName", null, 1, 1, HeaderFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHeaderFile_DependentHeaders(), this.getHeaderFile(), null, "dependentHeaders", null, 0, -1, HeaderFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceFileEClass, SourceFile.class, "SourceFile", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceFile_DependentHeaders(), this.getHeaderFile(), null, "dependentHeaders", null, 0, -1, SourceFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteInternalHeaderEClass, RteInternalHeader.class, "RteInternalHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteInternalHeader_Constant(), this.getConstant(), null, "constant", null, 0, -1, RteInternalHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteInternalHeader_GlobalVariableGroup(), this.getGlobalVariableGroup(), null, "globalVariableGroup", null, 0, -1, RteInternalHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteInternalHeader_TrustedFunctionGroup(), this.getTrustedFunctionGroup(), null, "trustedFunctionGroup", null, 0, -1, RteInternalHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteInternalHeader_BswSchedulableEntityGroup(), this.getBswSchedulableEntityGroup(), null, "bswSchedulableEntityGroup", null, 0, -1, RteInternalHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteInternalHeader_RteCoreStartApiImpl(), this.getRteCoreStartApiImpl(), null, "rteCoreStartApiImpl", null, 0, 1, RteInternalHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteInternalHeader_DependentExecutableEntityGroup(), this.getExecutableEntityGroup(), null, "dependentExecutableEntityGroup", null, 0, -1, RteInternalHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteInternalHeader_SchmCoreInitApiImpl(), this.getSchmCoreInitApiImpl(), null, "schmCoreInitApiImpl", null, 0, 1, RteInternalHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveType_OriginalTypeSymbolName(), this.getCIdentifier(), "originalTypeSymbolName", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveType_Signedness(), this.getSignednessEnum(), "signedness", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unionTypeEClass, UnionType.class, "UnionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnionType_Member(), this.getUnionMember(), null, "member", null, 0, -1, UnionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blackboxTypeEClass, BlackboxType.class, "BlackboxType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unionMemberEClass, UnionMember.class, "UnionMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnionMember_MemberName(), this.getCIdentifier(), "memberName", null, 1, 1, UnionMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnionMember_Type(), this.getType(), null, "type", null, 1, 1, UnionMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableMemberEClass, VariableMember.class, "VariableMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableMember_Parent(), this.getVariable(), this.getVariable_Member(), "parent", null, 1, 1, VariableMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteUtilityHeaderEClass, RteUtilityHeader.class, "RteUtilityHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blackboxHeaderEClass, BlackboxHeader.class, "BlackboxHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rteBufferQueueTypeEClass, RteBufferQueueType.class, "RteBufferQueueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferQueueType_MaxLengthConstant(), this.getConstant(), null, "maxLengthConstant", null, 1, 1, RteBufferQueueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRteBufferQueueType_ElementType(), this.getType(), null, "elementType", null, 1, 1, RteBufferQueueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comSendTrustedFunctionParamTypeEClass, ComSendTrustedFunctionParamType.class, "ComSendTrustedFunctionParamType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(neverReadOperationEClass, NeverReadOperation.class, "NeverReadOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNeverReadOperation_InitValueConstant(), this.getConstant(), null, "initValueConstant", null, 1, 1, NeverReadOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteBufferInvalidateTrustedFunctionEClass, RteBufferInvalidateTrustedFunction.class, "RteBufferInvalidateTrustedFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteBufferInvalidateTrustedFunction_Operation(), this.getRteBufferNonqueuedSendOperation(), null, "operation", null, 1, 1, RteBufferInvalidateTrustedFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trustedFunctionRteBufferInvalidateSendOperationEClass, TrustedFunctionRteBufferInvalidateSendOperation.class, "TrustedFunctionRteBufferInvalidateSendOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrustedFunctionRteBufferInvalidateSendOperation_AccessTrustedFunction(), this.getRteBufferInvalidateTrustedFunction(), null, "accessTrustedFunction", null, 1, 1, TrustedFunctionRteBufferInvalidateSendOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memoryMappingEClass, MemoryMapping.class, "MemoryMapping", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemoryMapping_Prefix(), this.getCIdentifier(), "prefix", null, 1, 1, MemoryMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemoryMapping_MemorySectionSymbolName(), this.getCIdentifier(), "memorySectionSymbolName", null, 1, 1, MemoryMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swcMemoryMappingEClass, SwcMemoryMapping.class, "SwcMemoryMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bswMemoryMappingEClass, BswMemoryMapping.class, "BswMemoryMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(globalVariableGroupEClass, GlobalVariableGroup.class, "GlobalVariableGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalVariableGroup_GlobalVariable(), this.getGlobalVariable(), null, "globalVariable", null, 0, -1, GlobalVariableGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGlobalVariableGroup_MemoryMapping(), this.getMemoryMapping(), null, "memoryMapping", null, 1, 1, GlobalVariableGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionGroupEClass, FunctionGroup.class, "FunctionGroup", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionGroup_MemoryMapping(), this.getMemoryMapping(), null, "memoryMapping", null, 1, 1, FunctionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionGroup_Function(), this.getFunction(), null, "function", null, 0, -1, FunctionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rteApiGroupEClass, RteApiGroup.class, "RteApiGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteApiGroup_RteApi(), this.getRteApi(), null, "rteApi", null, 0, -1, RteApiGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(rteLifecycleApiGroupEClass, RteLifecycleApiGroup.class, "RteLifecycleApiGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRteLifecycleApiGroup_RteLifecycleApi(), this.getRteLifecycleApi(), null, "rteLifecycleApi", null, 0, -1, RteLifecycleApiGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(taskBodyGroupEClass, TaskBodyGroup.class, "TaskBodyGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskBodyGroup_TaskBody(), this.getTaskBody(), null, "taskBody", null, 0, -1, TaskBodyGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(bswSchedulableEntityGroupEClass, BswSchedulableEntityGroup.class, "BswSchedulableEntityGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBswSchedulableEntityGroup_BswSchedulableEntity(), this.getBswSchedulableEntity(), null, "bswSchedulableEntity", null, 0, -1, BswSchedulableEntityGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(comCallbackGroupEClass, ComCallbackGroup.class, "ComCallbackGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComCallbackGroup_ComCallback(), this.getComCallback(), null, "comCallback", null, 0, -1, ComCallbackGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(trustedFunctionGroupEClass, TrustedFunctionGroup.class, "TrustedFunctionGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrustedFunctionGroup_TrustedFunction(), this.getTrustedFunction(), null, "trustedFunction", null, 0, -1, TrustedFunctionGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(executableEntityGroupEClass, ExecutableEntityGroup.class, "ExecutableEntityGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutableEntityGroup_ExecutableEntity(), this.getExecutableEntity(), null, "executableEntity", null, 0, -1, ExecutableEntityGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(bswMemoryMappingHeaderEClass, BswMemoryMappingHeader.class, "BswMemoryMappingHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBswMemoryMappingHeader_MemoryMapping(), this.getBswMemoryMapping(), null, "memoryMapping", null, 0, -1, BswMemoryMappingHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swcMemoryMappingHeaderEClass, SwcMemoryMappingHeader.class, "SwcMemoryMappingHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwcMemoryMappingHeader_MemoryMapping(), this.getSwcMemoryMapping(), null, "memoryMapping", null, 0, -1, SwcMemoryMappingHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generationInfoEClass, GenerationInfo.class, "GenerationInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenerationInfo_GeneratorName(), this.getString(), "generatorName", null, 1, 1, GenerationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenerationInfo_GeneratorVersion(), this.getString(), "generatorVersion", null, 1, 1, GenerationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenerationInfo_GenerationDate(), this.getString(), "generationDate", null, 0, 1, GenerationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(macroEClass, Macro.class, "Macro", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMacro_SymbolName(), theM2Package.getCIdentifier(), "symbolName", null, 1, 1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schmApiEClass, SchmApi.class, "SchmApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchmApi_ReturnValue(), this.getValue(), null, "returnValue", null, 0, 1, SchmApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchmApi_Parent(), this.getPartedBswm(), this.getPartedBswm_SchmApi(), "parent", null, 1, 1, SchmApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schmLifecycleApiEClass, SchmLifecycleApi.class, "SchmLifecycleApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(schmEnterApiEClass, SchmEnterApi.class, "SchmEnterApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchmEnterApi_Operation(), this.getExcludeOperation(), null, "operation", null, 1, 1, SchmEnterApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schmExitApiEClass, SchmExitApi.class, "SchmExitApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchmExitApi_Operation(), this.getExcludeOperation(), null, "operation", null, 1, 1, SchmExitApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleInterlinkHeaderEClass, ModuleInterlinkHeader.class, "ModuleInterlinkHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleInterlinkHeader_SchmApiGroup(), this.getSchmApiGroup(), null, "schmApiGroup", null, 0, -1, ModuleInterlinkHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleInterlinkHeader_DependentExecutableEntityGroup(), this.getExecutableEntityGroup(), null, "dependentExecutableEntityGroup", null, 0, -1, ModuleInterlinkHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleInterlinkHeader_Constant(), this.getConstant(), null, "constant", null, 0, -1, ModuleInterlinkHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schmApiGroupEClass, SchmApiGroup.class, "SchmApiGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchmApiGroup_SchmApi(), this.getSchmApi(), null, "schmApi", null, 0, -1, SchmApiGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(moduleInterlinkTypeHeaderEClass, ModuleInterlinkTypeHeader.class, "ModuleInterlinkTypeHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleInterlinkTypeHeader_Constant(), this.getConstant(), null, "constant", null, 0, -1, ModuleInterlinkTypeHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schmLifecycleApiGroupEClass, SchmLifecycleApiGroup.class, "SchmLifecycleApiGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchmLifecycleApiGroup_SchmLifecycleApi(), this.getSchmLifecycleApi(), null, "schmLifecycleApi", null, 0, -1, SchmLifecycleApiGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(partedBswmEClass, PartedBswm.class, "PartedBswm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartedBswm_Parent(), this.getPartition(), this.getPartition_PartedBswm(), "parent", null, 1, 1, PartedBswm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartedBswm_DependentExecutableEntity(), this.getExecutableEntity(), this.getExecutableEntity_ParentPartedBswm(), "dependentExecutableEntity", null, 0, -1, PartedBswm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartedBswm_SchmApi(), this.getSchmApi(), this.getSchmApi_Parent(), "schmApi", null, 0, -1, PartedBswm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartedBswm_BswMemoryMapping(), this.getBswMemoryMapping(), null, "bswMemoryMapping", null, 0, -1, PartedBswm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartedBswm_Bswm(), this.getBswm(), this.getBswm_PartedBswm(), "bswm", null, 1, 1, PartedBswm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bswmEClass, Bswm.class, "Bswm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBswm_PartedBswm(), this.getPartedBswm(), this.getPartedBswm_Bswm(), "partedBswm", null, 0, -1, Bswm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getBswm__GetSinglePartedBswm__Partition(), this.getPartedBswm(), "getSinglePartedBswm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPartition(), "parent", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(schmDeinitApiEClass, SchmDeinitApi.class, "SchmDeinitApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(schmInitApiEClass, SchmInitApi.class, "SchmInitApi", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(singlecoreSchmInitApiEClass, SinglecoreSchmInitApi.class, "SinglecoreSchmInitApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSinglecoreSchmInitApi_Operation(), this.getInitializeOperation(), null, "operation", null, 0, -1, SinglecoreSchmInitApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multicoreSchmInitApiEClass, MulticoreSchmInitApi.class, "MulticoreSchmInitApi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMulticoreSchmInitApi_CoreInitApiImpl(), this.getSchmCoreInitApiImpl(), null, "coreInitApiImpl", null, 0, -1, MulticoreSchmInitApi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schmCoreInitApiImplEClass, SchmCoreInitApiImpl.class, "SchmCoreInitApiImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchmCoreInitApiImpl_Parent(), this.getCore(), this.getCore_SchmInitApi(), "parent", null, 1, 1, SchmCoreInitApiImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchmCoreInitApiImpl_Operation(), this.getInitializeOperation(), null, "operation", null, 0, -1, SchmCoreInitApiImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(parameterPassTypeEnumEEnum, ParameterPassTypeEnum.class, "ParameterPassTypeEnum");
		addEEnumLiteral(parameterPassTypeEnumEEnum, ParameterPassTypeEnum.VALUE);
		addEEnumLiteral(parameterPassTypeEnumEEnum, ParameterPassTypeEnum.REFERENCE);

		initEEnum(signednessEnumEEnum, SignednessEnum.class, "SignednessEnum");
		addEEnumLiteral(signednessEnumEEnum, SignednessEnum.SIGNED);
		addEEnumLiteral(signednessEnumEEnum, SignednessEnum.UNSIGNED);

		initEEnum(constantTypeEnumEEnum, ConstantTypeEnum.class, "ConstantTypeEnum");
		addEEnumLiteral(constantTypeEnumEEnum, ConstantTypeEnum.NUMERICAL_VALUE);
		addEEnumLiteral(constantTypeEnumEEnum, ConstantTypeEnum.TEXT_VALUE);
		addEEnumLiteral(constantTypeEnumEEnum, ConstantTypeEnum.UNKNOWN_VALUE);

		// Initialize data types
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(verbatimStringEDataType, String.class, "VerbatimString", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cIdentifierEDataType, String.class, "CIdentifier", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, Boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerEDataType, Integer.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });												
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";				
		addAnnotation
		  (getRteBufferQueuedVariable_QueueType(), 
		   source, 
		   new String[] {
			 "derivation", "self.type.oclAsType(RteBufferQueueType)"
		   });		
		addAnnotation
		  (getRteApiGroup_RteApi(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(RteApi)->asOrderedSet()"
		   });		
		addAnnotation
		  (getRteLifecycleApiGroup_RteLifecycleApi(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(RteLifecycleApi)->asOrderedSet()"
		   });		
		addAnnotation
		  (getTaskBodyGroup_TaskBody(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(TaskBody)->asOrderedSet()"
		   });		
		addAnnotation
		  (getBswSchedulableEntityGroup_BswSchedulableEntity(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(BswSchedulableEntity)->asOrderedSet()"
		   });		
		addAnnotation
		  (getComCallbackGroup_ComCallback(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(ComCallback)->asOrderedSet()"
		   });		
		addAnnotation
		  (getTrustedFunctionGroup_TrustedFunction(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(TrustedFunction)->asOrderedSet()"
		   });		
		addAnnotation
		  (getExecutableEntityGroup_ExecutableEntity(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(ExecutableEntity)->asOrderedSet()"
		   });		
		addAnnotation
		  (getSchmApiGroup_SchmApi(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(SchmApi)->asOrderedSet()"
		   });		
		addAnnotation
		  (getSchmLifecycleApiGroup_SchmLifecycleApi(), 
		   source, 
		   new String[] {
			 "derivation", "self.function.oclAsType(SchmLifecycleApi)->asOrderedSet()"
		   });	
	}

} //ModulePackageImpl
