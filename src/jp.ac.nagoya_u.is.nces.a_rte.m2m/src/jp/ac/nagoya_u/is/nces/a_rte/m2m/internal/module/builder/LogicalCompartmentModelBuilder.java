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
package jp.ac.nagoya_u.is.nces.a_rte.m2m.internal.module.builder;

import static jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPackage.Literals.ECUC_PARTITION_COLLECTION;
import static jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPackage.Literals.OS_APPLICATION__OS_APP_ECUC_PARTITION;
import static jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPackage.Literals.OS_OS;
import static jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPackage.Literals.OS_TASK__OWNER_APPLICATION;
import static jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.instance.InstancePackage.Literals.SW_COMPONENT_INSTANCE_IN_SYSTEM;
import static jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.M2Package.Literals.ATOMIC_SW_COMPONENT_TYPE;
import static jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.M2Package.Literals.BSW_MODULE_DESCRIPTION;
import static jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage.Literals.CORE__CORE_ID;
import static jp.ac.nagoya_u.is.nces.a_rte.model.util.EObjectConditions.hasAttr;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jp.ac.nagoya_u.is.nces.a_rte.m2m.internal.common.util.ConfigValues;
import jp.ac.nagoya_u.is.nces.a_rte.model.ModelException;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPartition;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPartitionCollection;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsOS;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsTask;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.instance.SwComponentInstanceInSystem;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.AtomicSwComponentType;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.BswInternalBehavior;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.BswModuleDescription;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.BswModuleEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.BswSchedulableEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.ExclusiveArea;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.SwComponentType;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Bswm;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Core;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ExecutableEntity;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.GenerationInfo;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleFactory;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.PartedBswm;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Partition;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Rte;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Swc;
import jp.ac.nagoya_u.is.nces.a_rte.model.util.GeneratorInfos;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.Iterables;

public class LogicalCompartmentModelBuilder {
	private final ModuleModelBuildContext context;

	public LogicalCompartmentModelBuilder(ModuleModelBuildContext context) {
		this.context = context;
	}

	public void buildFromSystem() throws ModelException {
		buildRoot();

		Optional<EcucPartitionCollection> ecucPartitionCollection = this.context.query.tryFindSingleByKind(ECUC_PARTITION_COLLECTION);
		if (ecucPartitionCollection.isPresent()) {
			// パーティションあり構成
			buildFromPartitionedSystem(this.context.cache.rte, ecucPartitionCollection.get());
		} else {
			// パーティションなし構成
			buildFromNonPartitionedSystem(this.context.cache.rte);
		}
		
		buildBswm(this.context.cache.rte);
	}

	public void buildFromSwcAndBswm() throws ModelException {
		buildRoot();
		buildFromSwcAndBswm(this.context.cache.rte);
	}

	private void buildFromSwcAndBswm(Rte targetRte) throws ModelException {
		Core core = createDefaultCore();
		targetRte.getCore().add(core);

		Partition partition = createDefaultPartition();
		core.getPartition().add(partition);

		for (AtomicSwComponentType swComponentType : this.context.query.<AtomicSwComponentType> findByKind(ATOMIC_SW_COMPONENT_TYPE)) {
			partition.getSwc().add(createSwc(swComponentType));
		}

		for (BswModuleDescription bswModuleDescription : this.context.query.<BswModuleDescription> findByKind(BSW_MODULE_DESCRIPTION)) {
			if (!bswModuleDescription.getInternalBehavior().get(0).getImplementation().isEmpty()) {
				Bswm bswm = createBswm(bswModuleDescription);
				targetRte.getBswm().add(bswm);

				// エクスキュータブルをpartedBswmに登録する
				for (BswInternalBehavior internalBehavior : bswModuleDescription.getInternalBehavior()) {
					for (BswModuleEntity entity : internalBehavior.getEntity()) {
						PartedBswm partedBswm = createPartedBswm(bswm, partition);
						ExecutableEntity executableEntity = createExecutableEntity(entity, generateBswSchedulerNamePrefix(bswModuleDescription));
						partedBswm.getDependentExecutableEntity().add(executableEntity);
					}
				}
			}
		}
	}
	
	private Partition getTargetPartition(BswSchedulableEntity entity) throws ModelException {
		// BSWスケジューラブルが属するOSタスクを取得
		OsTask osTask = ((BswSchedulableEntity) entity).getEvent().get(0).getConfig().get(0).getRteBswMappedToTask();
	
		// OSタスクが属するパーティションを取得
		List<EcucPartition> partitions = this.context.query.collect(Collections.singletonList(osTask), OS_TASK__OWNER_APPLICATION, OS_APPLICATION__OS_APP_ECUC_PARTITION);
		EcucPartition sourcePartition = Iterables.getFirst(partitions, null);
		Partition targetPartition = this.context.builtQuery.findPartition(sourcePartition);
		
		return targetPartition;
	}
	
	private Partition getMasterCoreBswPartition(Rte targetRte) throws ModelException {
		Optional<EcucPartitionCollection> ecucPartitionCollection = this.context.query.tryFindSingleByKind(ECUC_PARTITION_COLLECTION);
		Partition targetPartition = null;
		if (ecucPartitionCollection.isPresent()) {
			// パーティションあり構成
			OsOS osOs = this.context.query.findSingleByKind(OS_OS);
			Integer coreId = osOs.getOsNumberOfCores() != null ? osOs.getOsMasterCoreId() : 0;
			Core masterCore = targetRte.getCore().get(coreId);
			
			// 以下の処理はマスタコアに必ずBSWM配置パーティションが1つある前提.
			targetPartition = masterCore.getPartition().get(0);
			for (Partition partition : masterCore.getPartition()) {	// COVERAGE 必ずbreak文でループを抜けるため、未カバレッジで問題ない.
				if (partition.getIsBswPartition()) {
					targetPartition = partition;
					break;
				}
			}
		} else {
			// パーティションなし構成
			targetPartition = targetRte.getCore().get(0).getPartition().get(0);
		}
		return targetPartition;
	}
	
	private void buildBswm(Rte targetRte) throws ModelException {
		Partition masterCorePartition = getMasterCoreBswPartition(targetRte);
		for (BswModuleDescription bswModuleDescription : this.context.query.<BswModuleDescription> findByKind(BSW_MODULE_DESCRIPTION)) {
			if (!bswModuleDescription.getInternalBehavior().get(0).getImplementation().isEmpty()) {
				Bswm bswm = createBswm(bswModuleDescription);
				targetRte.getBswm().add(bswm);
				
				for (BswInternalBehavior internalBehavior : bswModuleDescription.getInternalBehavior()) {

					// BSWスケジューラブルのExclusiveAreaとパーティションの対応表を作成する
					HashMap<ExclusiveArea, Partition> map = new HashMap<ExclusiveArea, Partition>();
					for (BswModuleEntity entity : internalBehavior.getEntity()) {
						if (entity instanceof BswSchedulableEntity) {
							Partition targetPartition = getTargetPartition((BswSchedulableEntity)entity);
							
							//ExclusiveAreaとBSWスケジューラブルが所属するパーティションのハッシュマップを作る
							for (ExclusiveArea exclusiveArea : entity.getCanEnterExclusiveArea()) {
								map.put(exclusiveArea, targetPartition);
							}
						}
					}

					// エクスキュータブルをpartedBswmに登録する
					for (BswModuleEntity entity : internalBehavior.getEntity()) {
						Partition targetPartition = null;
						if (entity instanceof BswSchedulableEntity) {
							targetPartition = getTargetPartition((BswSchedulableEntity)entity);
						} else {
							for (ExclusiveArea exclusiveArea : entity.getCanEnterExclusiveArea()) {
								targetPartition = map.get(exclusiveArea);
								if (targetPartition != null) {
									//BswSchedulableEntityと同じExclusiveAreaのときは、そのパーティションを使用する
									break;
								}
							}
							if (targetPartition == null) {
								targetPartition = masterCorePartition;
							}
						}
						PartedBswm partedBswm = createPartedBswm(bswm, targetPartition);
						ExecutableEntity executableEntity = createExecutableEntity(entity, generateBswSchedulerNamePrefix(bswModuleDescription));
						partedBswm.getDependentExecutableEntity().add(executableEntity);
					}
				}
			}
		}
	}

	private void buildRoot() {
		Rte rte = ModuleFactory.eINSTANCE.createRte();
		rte.setGenerationInfo(createGenerationInfo());
		this.context.cache.moduleRoot.setRte(rte);
		this.context.cache.rte = rte;
	}

	private GenerationInfo createGenerationInfo() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		GenerationInfo generationInfo = ModuleFactory.eINSTANCE.createGenerationInfo();
		generationInfo.setGeneratorName(GeneratorInfos.GENERATOR_TOOL_NAME);
		generationInfo.setGeneratorVersion(GeneratorInfos.GENERATOR_VERSION);
		if (context.options.writeGenerationTimeStamp) {
			generationInfo.setGenerationDate(format.format(new Date()));
		}
		return generationInfo;
	}

	private void buildFromPartitionedSystem(Rte targetRte, EcucPartitionCollection sourceEcucPartitionCollection) throws ModelException {
		OsOS osOs = this.context.query.findSingleByKind(OS_OS);

		for (Integer coreId : sourceEcucPartitionCollection.getAssignedCores()) {
			targetRte.getCore().add(createCore(coreId, osOs));
		}

		for (EcucPartition ecucPartition : sourceEcucPartitionCollection.getEcucPartition()) {
			Core ownerCore = this.context.query.findSingle(hasAttr(CORE__CORE_ID, ecucPartition.getOwnerCore()));

			Partition partition = createPartition(ecucPartition);
			ownerCore.getPartition().add(partition);

			for (SwComponentInstanceInSystem swComponentInstanceInSystem : ecucPartition.getEcucPartitionSoftwareComponent()) {
				partition.getSwc().add(createSwc(swComponentInstanceInSystem.getPrototype().getType()));
			}
		}
	}

	private void buildFromNonPartitionedSystem(Rte targetRte) {
		Core core = createDefaultCore();
		targetRte.getCore().add(core);

		Partition partition = createDefaultPartition();
		core.getPartition().add(partition);

		for (SwComponentInstanceInSystem swComponentInstanceInSystem : this.context.query.<SwComponentInstanceInSystem> findByKind(SW_COMPONENT_INSTANCE_IN_SYSTEM)) {
			Swc swc = createSwc(swComponentInstanceInSystem.getPrototype().getType());
			partition.getSwc().add(swc);
		}
	}

	private Core createDefaultCore() {
		Core core = ModuleFactory.eINSTANCE.createCore();
		core.setCompartmentName(String.valueOf(ConfigValues.DEFAULT_CORE_ID));
		core.setCoreId(ConfigValues.DEFAULT_CORE_ID);
		core.setIsMasterCore(true);
		return core;
	}

	private Core createCore(Integer sourceCoreId, OsOS osOs) throws ModelException {
		Core core = ModuleFactory.eINSTANCE.createCore();
		core.setCompartmentName(String.valueOf(sourceCoreId));
		core.setCoreId(sourceCoreId);
		core.setIsMasterCore(Objects.equal(osOs.getOsMasterCoreId(), core.getCoreId()));
		return core;
	}

	private Partition createDefaultPartition() {
		Partition partition = ModuleFactory.eINSTANCE.createPartition();
		partition.setCompartmentName("DefaultPartition");
		return partition;
	}

	private Partition createPartition(EcucPartition sourceEcucPartition) {
		Partition partition = ModuleFactory.eINSTANCE.createPartition();
		partition.setCompartmentName(sourceEcucPartition.getShortName());
		partition.setIsBswPartition(sourceEcucPartition.getEcucPartitionBswModuleExecution());
		partition.setSingleSource(sourceEcucPartition);
		return partition;
	}

	private Swc createSwc(SwComponentType sourceSwComponentType) {
		Swc swc = ModuleFactory.eINSTANCE.createSwc();
		swc.setCompartmentName(sourceSwComponentType.getShortName());
		swc.setSingleSource(sourceSwComponentType);
		return swc;
	}

	private Bswm createBswm(BswModuleDescription sourceBswModuleDescription) {
		Bswm bswm = ModuleFactory.eINSTANCE.createBswm();
		bswm.setCompartmentName(generateBswSchedulerNamePrefix(sourceBswModuleDescription));
		bswm.setSingleSource(sourceBswModuleDescription);
		return bswm;
	}
	
	private PartedBswm createPartedBswm(Bswm bswm, Partition targetPartition) {
		PartedBswm partedBswm = bswm.getSinglePartedBswm(targetPartition);
		if (partedBswm == null) {
			partedBswm = ModuleFactory.eINSTANCE.createPartedBswm();
			targetPartition.getPartedBswm().add(partedBswm);
			bswm.getPartedBswm().add(partedBswm);
		}		
		return partedBswm;
	}
	
	private String generateBswSchedulerNamePrefix(BswModuleDescription sourceBswModuleDescription) {
		// 現実装は単純にBswModuleDescriptionのショートネームを<bsnp>とする.
		// BswSchedulerNamePrefixクラスを使用した<bsnp>生成に対応する場合は、本関数を修正すること.
		return sourceBswModuleDescription.getShortName();
	}
	
	private ExecutableEntity createExecutableEntity(jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.BswModuleEntity sourceEntity, String bsnp) throws ModelException {
		ExecutableEntity executableEntity = ModuleFactory.eINSTANCE.createExecutableEntity();
		executableEntity.setSingleSource(sourceEntity);
		executableEntity.setSymbolName(bsnp + "_" + sourceEntity.getImplementedEntry().getShortName());
		return executableEntity;
	}
}
