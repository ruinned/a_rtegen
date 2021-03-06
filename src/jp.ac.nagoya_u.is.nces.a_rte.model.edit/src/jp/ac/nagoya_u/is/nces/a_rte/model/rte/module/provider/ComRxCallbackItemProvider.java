/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.provider;


import java.util.Collection;
import java.util.List;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComRxCallback;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleFactory;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ComRxCallback} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComRxCallbackItemProvider extends ComCallbackItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComRxCallbackItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addActivationFlagPropertyDescriptor(object);
			addDataVariablePropertyDescriptor(object);
			addAccessApiPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Activation Flag feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActivationFlagPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComRxCallback_activationFlag_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ComRxCallback_activationFlag_feature", "_UI_ComRxCallback_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModulePackage.Literals.COM_RX_CALLBACK__ACTIVATION_FLAG,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Data Variable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataVariablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComRxCallback_dataVariable_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ComRxCallback_dataVariable_feature", "_UI_ComRxCallback_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModulePackage.Literals.COM_RX_CALLBACK__DATA_VARIABLE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Access Api feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccessApiPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComRxCallback_accessApi_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ComRxCallback_accessApi_feature", "_UI_ComRxCallback_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModulePackage.Literals.COM_RX_CALLBACK__ACCESS_API,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION);
			childrenFeatures.add(ModulePackage.Literals.COM_RX_CALLBACK__ACTIVATION_OPERATION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ComRxCallback.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ComRxCallback")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}
	

	/**
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((ComRxCallback)object).getRoleName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_ComRxCallback_type"), StyledString.Style.QUALIFIER_STYLER);  //$NON-NLS-1$
		} else {
			styledLabel.append(getString("_UI_ComRxCallback_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ComRxCallback.class)) {
			case ModulePackage.COM_RX_CALLBACK__OPERATION:
			case ModulePackage.COM_RX_CALLBACK__ACTIVATION_OPERATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createRteBufferNonqueuedSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createIocSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createIocNonqueuedSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createDirectComSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createTrustedFunctionRteOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createTrustedFunctionRteBufferWriteSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createTrustedFunctionRteBufferSendSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createTrustedFunctionRteBufferInvalidateSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createTrustedFunctionComSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createImmediateProxyComSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createPeriodicProxyComSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createRteBufferQueuedSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__OPERATION,
				 ModuleFactory.eINSTANCE.createIocQueuedSendOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.COM_RX_CALLBACK__ACTIVATION_OPERATION,
				 ModuleFactory.eINSTANCE.createActivationOperation()));
	}

}
