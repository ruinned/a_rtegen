/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.provider;

import java.util.ArrayList;
import java.util.Collection;

import jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.util.EcucAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EcucItemProviderAdapterFactory extends EcucAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcucItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(ITableItemLabelProvider.class);
		supportedTypes.add(ITableItemFontProvider.class);
		supportedTypes.add(IItemFontProvider.class);
		supportedTypes.add(IItemStyledLabelProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.DocumentRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootItemProvider documentRootItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.DocumentRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDocumentRootAdapter() {
		if (documentRootItemProvider == null) {
			documentRootItemProvider = new DocumentRootItemProvider(this);
		}

		return documentRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.Rte} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteItemProvider rteItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.Rte}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteAdapter() {
		if (rteItemProvider == null) {
			rteItemProvider = new RteItemProvider(this);
		}

		return rteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteGeneration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteGenerationItemProvider rteGenerationItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteGeneration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteGenerationAdapter() {
		if (rteGenerationItemProvider == null) {
			rteGenerationItemProvider = new RteGenerationItemProvider(this);
		}

		return rteGenerationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswGeneral} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteBswGeneralItemProvider rteBswGeneralItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswGeneral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteBswGeneralAdapter() {
		if (rteBswGeneralItemProvider == null) {
			rteBswGeneralItemProvider = new RteBswGeneralItemProvider(this);
		}

		return rteBswGeneralItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcucRootItemProvider ecucRootItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEcucRootAdapter() {
		if (ecucRootItemProvider == null) {
			ecucRootItemProvider = new EcucRootItemProvider(this);
		}

		return ecucRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteSwComponentInstance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteSwComponentInstanceItemProvider rteSwComponentInstanceItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteSwComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteSwComponentInstanceAdapter() {
		if (rteSwComponentInstanceItemProvider == null) {
			rteSwComponentInstanceItemProvider = new RteSwComponentInstanceItemProvider(this);
		}

		return rteSwComponentInstanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteEventToTaskMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteEventToTaskMappingItemProvider rteEventToTaskMappingItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteEventToTaskMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteEventToTaskMappingAdapter() {
		if (rteEventToTaskMappingItemProvider == null) {
			rteEventToTaskMappingItemProvider = new RteEventToTaskMappingItemProvider(this);
		}

		return rteEventToTaskMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.Os} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsItemProvider osItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.Os}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsAdapter() {
		if (osItemProvider == null) {
			osItemProvider = new OsItemProvider(this);
		}

		return osItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsTask} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsTaskItemProvider osTaskItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsTaskAdapter() {
		if (osTaskItemProvider == null) {
			osTaskItemProvider = new OsTaskItemProvider(this);
		}

		return osTaskItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteExclusiveAreaImplementation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteExclusiveAreaImplementationItemProvider rteExclusiveAreaImplementationItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteExclusiveAreaImplementation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteExclusiveAreaImplementationAdapter() {
		if (rteExclusiveAreaImplementationItemProvider == null) {
			rteExclusiveAreaImplementationItemProvider = new RteExclusiveAreaImplementationItemProvider(this);
		}

		return rteExclusiveAreaImplementationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsEventItemProvider osEventItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsEventAdapter() {
		if (osEventItemProvider == null) {
			osEventItemProvider = new OsEventItemProvider(this);
		}

		return osEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.Com} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComItemProvider comItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.Com}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComAdapter() {
		if (comItemProvider == null) {
			comItemProvider = new ComItemProvider(this);
		}

		return comItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.ComConfig} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComConfigItemProvider comConfigItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.ComConfig}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComConfigAdapter() {
		if (comConfigItemProvider == null) {
			comConfigItemProvider = new ComConfigItemProvider(this);
		}

		return comConfigItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.ComSignal} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComSignalItemProvider comSignalItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.ComSignal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComSignalAdapter() {
		if (comSignalItemProvider == null) {
			comSignalItemProvider = new ComSignalItemProvider(this);
		}

		return comSignalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.ComSignalGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComSignalGroupItemProvider comSignalGroupItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.ComSignalGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComSignalGroupAdapter() {
		if (comSignalGroupItemProvider == null) {
			comSignalGroupItemProvider = new ComSignalGroupItemProvider(this);
		}

		return comSignalGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.ComGroupSignal} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComGroupSignalItemProvider comGroupSignalItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.ComGroupSignal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComGroupSignalAdapter() {
		if (comGroupSignalItemProvider == null) {
			comGroupSignalItemProvider = new ComGroupSignalItemProvider(this);
		}

		return comGroupSignalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsAlarm} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsAlarmItemProvider osAlarmItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsAlarm}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsAlarmAdapter() {
		if (osAlarmItemProvider == null) {
			osAlarmItemProvider = new OsAlarmItemProvider(this);
		}

		return osAlarmItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsResourceItemProvider osResourceItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsResourceAdapter() {
		if (osResourceItemProvider == null) {
			osResourceItemProvider = new OsResourceItemProvider(this);
		}

		return osResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsApplication} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsApplicationItemProvider osApplicationItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsApplication}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsApplicationAdapter() {
		if (osApplicationItemProvider == null) {
			osApplicationItemProvider = new OsApplicationItemProvider(this);
		}

		return osApplicationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcuC} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcuCItemProvider ecuCItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcuC}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEcuCAdapter() {
		if (ecuCItemProvider == null) {
			ecuCItemProvider = new EcuCItemProvider(this);
		}

		return ecuCItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPartitionCollection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcucPartitionCollectionItemProvider ecucPartitionCollectionItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPartitionCollection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEcucPartitionCollectionAdapter() {
		if (ecucPartitionCollectionItemProvider == null) {
			ecucPartitionCollectionItemProvider = new EcucPartitionCollectionItemProvider(this);
		}

		return ecucPartitionCollectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPartition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcucPartitionItemProvider ecucPartitionItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.EcucPartition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEcucPartitionAdapter() {
		if (ecucPartitionItemProvider == null) {
			ecucPartitionItemProvider = new EcucPartitionItemProvider(this);
		}

		return ecucPartitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsSpinlock} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsSpinlockItemProvider osSpinlockItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsSpinlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsSpinlockAdapter() {
		if (osSpinlockItemProvider == null) {
			osSpinlockItemProvider = new OsSpinlockItemProvider(this);
		}

		return osSpinlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteOsInteraction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteOsInteractionItemProvider rteOsInteractionItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteOsInteraction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteOsInteractionAdapter() {
		if (rteOsInteractionItemProvider == null) {
			rteOsInteractionItemProvider = new RteOsInteractionItemProvider(this);
		}

		return rteOsInteractionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteUsedOsActivation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteUsedOsActivationItemProvider rteUsedOsActivationItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteUsedOsActivation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteUsedOsActivationAdapter() {
		if (rteUsedOsActivationItemProvider == null) {
			rteUsedOsActivationItemProvider = new RteUsedOsActivationItemProvider(this);
		}

		return rteUsedOsActivationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteInitializationBehavior} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteInitializationBehaviorItemProvider rteInitializationBehaviorItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteInitializationBehavior}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteInitializationBehaviorAdapter() {
		if (rteInitializationBehaviorItemProvider == null) {
			rteInitializationBehaviorItemProvider = new RteInitializationBehaviorItemProvider(this);
		}

		return rteInitializationBehaviorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIoc} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsIocItemProvider osIocItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIoc}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsIocAdapter() {
		if (osIocItemProvider == null) {
			osIocItemProvider = new OsIocItemProvider(this);
		}

		return osIocItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIocCommunication} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsIocCommunicationItemProvider osIocCommunicationItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIocCommunication}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsIocCommunicationAdapter() {
		if (osIocCommunicationItemProvider == null) {
			osIocCommunicationItemProvider = new OsIocCommunicationItemProvider(this);
		}

		return osIocCommunicationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIocSenderProperties} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsIocSenderPropertiesItemProvider osIocSenderPropertiesItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIocSenderProperties}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsIocSenderPropertiesAdapter() {
		if (osIocSenderPropertiesItemProvider == null) {
			osIocSenderPropertiesItemProvider = new OsIocSenderPropertiesItemProvider(this);
		}

		return osIocSenderPropertiesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIocReceiverProperties} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsIocReceiverPropertiesItemProvider osIocReceiverPropertiesItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIocReceiverProperties}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsIocReceiverPropertiesAdapter() {
		if (osIocReceiverPropertiesItemProvider == null) {
			osIocReceiverPropertiesItemProvider = new OsIocReceiverPropertiesItemProvider(this);
		}

		return osIocReceiverPropertiesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIocDataProperties} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsIocDataPropertiesItemProvider osIocDataPropertiesItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsIocDataProperties}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsIocDataPropertiesAdapter() {
		if (osIocDataPropertiesItemProvider == null) {
			osIocDataPropertiesItemProvider = new OsIocDataPropertiesItemProvider(this);
		}

		return osIocDataPropertiesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsApplicationTrustedFunction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsApplicationTrustedFunctionItemProvider osApplicationTrustedFunctionItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsApplicationTrustedFunction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsApplicationTrustedFunctionAdapter() {
		if (osApplicationTrustedFunctionItemProvider == null) {
			osApplicationTrustedFunctionItemProvider = new OsApplicationTrustedFunctionItemProvider(this);
		}

		return osApplicationTrustedFunctionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsOS} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsOSItemProvider osOSItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.OsOS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOsOSAdapter() {
		if (osOSItemProvider == null) {
			osOSItemProvider = new OsOSItemProvider(this);
		}

		return osOSItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswEventToTaskMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteBswEventToTaskMappingItemProvider rteBswEventToTaskMappingItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswEventToTaskMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteBswEventToTaskMappingAdapter() {
		if (rteBswEventToTaskMappingItemProvider == null) {
			rteBswEventToTaskMappingItemProvider = new RteBswEventToTaskMappingItemProvider(this);
		}

		return rteBswEventToTaskMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswRequiredModeGroupConnection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteBswRequiredModeGroupConnectionItemProvider rteBswRequiredModeGroupConnectionItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswRequiredModeGroupConnection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteBswRequiredModeGroupConnectionAdapter() {
		if (rteBswRequiredModeGroupConnectionItemProvider == null) {
			rteBswRequiredModeGroupConnectionItemProvider = new RteBswRequiredModeGroupConnectionItemProvider(this);
		}

		return rteBswRequiredModeGroupConnectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswModuleInstance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteBswModuleInstanceItemProvider rteBswModuleInstanceItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswModuleInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteBswModuleInstanceAdapter() {
		if (rteBswModuleInstanceItemProvider == null) {
			rteBswModuleInstanceItemProvider = new RteBswModuleInstanceItemProvider(this);
		}

		return rteBswModuleInstanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswExclusiveAreaImpl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RteBswExclusiveAreaImplItemProvider rteBswExclusiveAreaImplItemProvider;

	/**
	 * This creates an adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.ar4x.ecuc.RteBswExclusiveAreaImpl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRteBswExclusiveAreaImplAdapter() {
		if (rteBswExclusiveAreaImplItemProvider == null) {
			rteBswExclusiveAreaImplItemProvider = new RteBswExclusiveAreaImplItemProvider(this);
		}

		return rteBswExclusiveAreaImplItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (documentRootItemProvider != null) documentRootItemProvider.dispose();
		if (rteItemProvider != null) rteItemProvider.dispose();
		if (rteGenerationItemProvider != null) rteGenerationItemProvider.dispose();
		if (rteBswGeneralItemProvider != null) rteBswGeneralItemProvider.dispose();
		if (ecucRootItemProvider != null) ecucRootItemProvider.dispose();
		if (rteSwComponentInstanceItemProvider != null) rteSwComponentInstanceItemProvider.dispose();
		if (rteEventToTaskMappingItemProvider != null) rteEventToTaskMappingItemProvider.dispose();
		if (osItemProvider != null) osItemProvider.dispose();
		if (osTaskItemProvider != null) osTaskItemProvider.dispose();
		if (rteExclusiveAreaImplementationItemProvider != null) rteExclusiveAreaImplementationItemProvider.dispose();
		if (osEventItemProvider != null) osEventItemProvider.dispose();
		if (comItemProvider != null) comItemProvider.dispose();
		if (comConfigItemProvider != null) comConfigItemProvider.dispose();
		if (comSignalItemProvider != null) comSignalItemProvider.dispose();
		if (comSignalGroupItemProvider != null) comSignalGroupItemProvider.dispose();
		if (comGroupSignalItemProvider != null) comGroupSignalItemProvider.dispose();
		if (osAlarmItemProvider != null) osAlarmItemProvider.dispose();
		if (osResourceItemProvider != null) osResourceItemProvider.dispose();
		if (osApplicationItemProvider != null) osApplicationItemProvider.dispose();
		if (ecuCItemProvider != null) ecuCItemProvider.dispose();
		if (ecucPartitionCollectionItemProvider != null) ecucPartitionCollectionItemProvider.dispose();
		if (ecucPartitionItemProvider != null) ecucPartitionItemProvider.dispose();
		if (osSpinlockItemProvider != null) osSpinlockItemProvider.dispose();
		if (rteOsInteractionItemProvider != null) rteOsInteractionItemProvider.dispose();
		if (rteUsedOsActivationItemProvider != null) rteUsedOsActivationItemProvider.dispose();
		if (rteInitializationBehaviorItemProvider != null) rteInitializationBehaviorItemProvider.dispose();
		if (osIocItemProvider != null) osIocItemProvider.dispose();
		if (osIocCommunicationItemProvider != null) osIocCommunicationItemProvider.dispose();
		if (osIocSenderPropertiesItemProvider != null) osIocSenderPropertiesItemProvider.dispose();
		if (osIocReceiverPropertiesItemProvider != null) osIocReceiverPropertiesItemProvider.dispose();
		if (osIocDataPropertiesItemProvider != null) osIocDataPropertiesItemProvider.dispose();
		if (osApplicationTrustedFunctionItemProvider != null) osApplicationTrustedFunctionItemProvider.dispose();
		if (osOSItemProvider != null) osOSItemProvider.dispose();
		if (rteBswEventToTaskMappingItemProvider != null) rteBswEventToTaskMappingItemProvider.dispose();
		if (rteBswRequiredModeGroupConnectionItemProvider != null) rteBswRequiredModeGroupConnectionItemProvider.dispose();
		if (rteBswModuleInstanceItemProvider != null) rteBswModuleInstanceItemProvider.dispose();
		if (rteBswExclusiveAreaImplItemProvider != null) rteBswExclusiveAreaImplItemProvider.dispose();
	}

}