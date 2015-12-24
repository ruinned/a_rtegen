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
package jp.ac.nagoya_u.is.nces.a_rte.m2m.internal.module.builder;

import static jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage.Literals.MODULE_OBJECT__ROLE_NAME;
import static jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage.Literals.MODULE_OBJECT__SOURCE;
import static jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage.Literals.PARTITION;
import static jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage.Literals.PRIMITIVE_TYPE;
import static jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage.Literals.TYPE;
import static jp.ac.nagoya_u.is.nces.a_rte.model.util.EObjectConditions.hasAttr;
import static jp.ac.nagoya_u.is.nces.a_rte.model.util.EObjectConditions.isKindOf;
import static jp.ac.nagoya_u.is.nces.a_rte.model.util.EObjectConditions.ref;

import java.util.Collection;
import java.util.List;

import jp.ac.nagoya_u.is.nces.a_rte.m2m.internal.common.util.MaxValues;
import jp.ac.nagoya_u.is.nces.a_rte.model.ModelException;
import jp.ac.nagoya_u.is.nces.a_rte.model.ModelQuery;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPartition;
import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.m2.ImplementationDataType;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Partition;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.PrimitiveType;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Type;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;

/**
 * �⥸�塼���ǥ��Ѵ�������������ǥ�򸡺����롣
 */
public class BuiltModuleModelQuery {

	private final ModelQuery query;
	private final ModuleModelBuildCache cache;

	public BuiltModuleModelQuery(ModelQuery query, ModuleModelBuildCache cache) {
		this.query = query;
		this.cache = cache;
	}

	public PrimitiveType getAppropriateUintTypeForRange(int maxValue) {
		if (maxValue <= MaxValues.UINT8_MAX) {
			return this.cache.uint8Type;
		} else if (maxValue <= MaxValues.UINT16_MAX) {
			return this.cache.uint16Type;
		} else {
			return this.cache.uint32Type;
		}
	}

	/**
	 * EcucPartition���б�����Partition�򸡺����롣
	 * ������null(�������Υѡ��ƥ������ʤ�)����ꤷ����硢�ǥե���ȤΥѡ��ƥ������(�ޥ���������BSWM���֥ѡ��ƥ������)���֤���
	 * @param sourcePartition ��������EcucPartition
	 * @return EcucPartition���б�����Partition��������null����ꤷ����硢�ǥե����(�ޥ���������BSWM���֥ѡ��ƥ������)��Partition��
	 * @throws ModelException EcucPartition���б�����Partition�����Ĥ���ʤ����
	 */
	public Partition findDestPartition(EcucPartition sourcePartition) throws ModelException {
		return findDestPartition(Optional.fromNullable(sourcePartition));
	}

	/**
	 * EcucPartition���б�����Partition�򸡺����롣
	 * ������Optional.absent()(�������Υѡ��ƥ������ʤ�)����ꤷ����硢�ǥե���ȤΥѡ��ƥ������(�ޥ���������BSWM���֥ѡ��ƥ������)���֤���
	 * @param sourcePartition ��������EcucPartition
	 * @return EcucPartition���б�����Partition��������Optional.absent()����ꤷ����硢�ǥե����(�ޥ���������BSWM���֥ѡ��ƥ������)��Partition��
	 * @throws ModelException EcucPartition���б�����Partition�����Ĥ���ʤ����
	 */
	public Partition findDestPartition(Optional<EcucPartition> sourcePartition) throws ModelException {
		return !sourcePartition.isPresent() ? this.cache.masterBswPartition : this.<Partition> findDest(PARTITION, sourcePartition.get());
	}

	/**
	 * EcucPartition���б�����Partition�򸡺����롣
	 * ������null(�������Υѡ��ƥ������ʤ�)����ꤷ����硢�ǥե���ȤΥѡ��ƥ������(�ޥ���������BSWM���֥ѡ��ƥ������)���֤���
	 * @param partition ��������EcucPartition
	 * @return EcucPartition���б�����Partition��������null����ꤷ����硢�ǥե����(�ޥ���������BSWM���֥ѡ��ƥ������)��Partition��
	 */
	public Optional<Partition> tryFindDestPartition(EcucPartition partition) {
		// COVERAGE (���ѥ������ǤϤʤ����ᡤ�����ɥ�ӥ塼������ʤ����Ȥ��ǧ)
		// ���߻��Ѥ��Ƥ��ʤ��᥽�å�
		return partition == null ? Optional.of(this.cache.masterBswPartition) : this.<Partition> tryFindDest(PARTITION, partition);
	}

	public Type findDestType(ImplementationDataType sourceImplementationDataType) throws ModelException {
		return findDest(TYPE, sourceImplementationDataType);
	}

	public PrimitiveType findDestPrimitiveType(ImplementationDataType sourceImplementationDataType) throws ModelException {
		return findDest(PRIMITIVE_TYPE, sourceImplementationDataType);
	}

	public <T extends EObject> List<T> findDests(final EClass kind, EList<? extends EObject> sources) throws ModelException {
		final List<ModelException> caughtExceptions = Lists.newArrayList();

		List<T> collected = Lists.transform(sources, new Function<EObject, T>() {
			@Override
			public T apply(EObject input) {
				try {
					return findDest(kind, input);
				} catch (ModelException e) { // COVERAGE ���̤ã(�Զ�纮�����Τ���ã���륳���ɤʤΤǡ�̤���Х�å�������ʤ�)
					caughtExceptions.add(e);
					return null;
				}
			}
		});

		if (!caughtExceptions.isEmpty()) {// COVERAGE ���false(true�Ȥʤ�Τ��Զ�纮�����ΤߤʤΤǡ�̤���Х�å�������ʤ�)
			throw caughtExceptions.get(0);
		}

		return collected;
	}

	public <T extends EObject> T findDest(EClass kind, EObject source) throws ModelException {
		return this.query.findSingle(isKindOf(kind).AND(ref(MODULE_OBJECT__SOURCE, source)));
	}

	public <T extends EObject> T findDest(EClass kind, EObject source, String roleName) throws ModelException {
		return this.query.findSingle(isKindOf(kind).AND(ref(MODULE_OBJECT__SOURCE, source)).AND(hasAttr(MODULE_OBJECT__ROLE_NAME, roleName)));
	}

	public <T extends EObject> Optional<T> tryFindDest(EClass kind, EObject source) {
		return this.query.tryFindSingle(isKindOf(kind).AND(ref(MODULE_OBJECT__SOURCE, source)));
	}

	public <T extends EObject> T selectDest(Collection<T> dests, EObject source) throws ModelException {
		return this.query.selectSingle(dests, ref(MODULE_OBJECT__SOURCE, source));
	}

	public <T extends EObject> Optional<T> trySelectDest(Collection<T> dests, EObject source) {
		return this.query.trySelectSingle(dests, ref(MODULE_OBJECT__SOURCE, source));
	}

	public <T extends EObject> List<T> selectDests(Collection<T> dests, EObject source) {
		return this.query.select(dests, ref(MODULE_OBJECT__SOURCE, source));
	}
}