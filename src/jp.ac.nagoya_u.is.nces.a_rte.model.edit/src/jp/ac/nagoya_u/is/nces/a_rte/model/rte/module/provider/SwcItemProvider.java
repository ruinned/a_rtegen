/**
 */
package jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.provider;


import java.util.Collection;
import java.util.List;

import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModuleFactory;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.ModulePackage;
import jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Swc;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link jp.ac.nagoya_u.is.nces.a_rte.model.rte.module.Swc} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SwcItemProvider extends LogicalCompartmentItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwcItemProvider(AdapterFactory adapterFactory) {
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

			addDependentExternalRunnableEntityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Dependent External Runnable Entity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDependentExternalRunnableEntityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Swc_dependentExternalRunnableEntity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Swc_dependentExternalRunnableEntity_feature", "_UI_Swc_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModulePackage.Literals.SWC__DEPENDENT_EXTERNAL_RUNNABLE_ENTITY,
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
			childrenFeatures.add(ModulePackage.Literals.SWC__SWC_MEMORY_MAPPING);
			childrenFeatures.add(ModulePackage.Literals.SWC__DEPENDENT_RUNNABLE_ENTITY);
			childrenFeatures.add(ModulePackage.Literals.SWC__RTE_API);
			childrenFeatures.add(ModulePackage.Literals.SWC__API_ENUM_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__API_UPPER_LOWER_LIMIT_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__SR_API_INIT_VALUE_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__SR_IMPL_INIT_VALUE_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__SR_IMPL_INVALID_VALUE_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__SR_FILTER_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__CS_API_APPLICATION_ERROR_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_VARIABLE);
			childrenFeatures.add(ModulePackage.Literals.SWC__IRV_BUFFER_INIT_VALUE_CONSTANT);
			childrenFeatures.add(ModulePackage.Literals.SWC__IRV_BUFFER_VARIABLE_SET);
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
	 * This returns Swc.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Swc")); //$NON-NLS-1$
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
		String label = ((Swc)object).getRoleName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_Swc_type"), StyledString.Style.QUALIFIER_STYLER);  //$NON-NLS-1$
		} else {
			styledLabel.append(getString("_UI_Swc_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label); //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(Swc.class)) {
			case ModulePackage.SWC__SWC_MEMORY_MAPPING:
			case ModulePackage.SWC__DEPENDENT_RUNNABLE_ENTITY:
			case ModulePackage.SWC__RTE_API:
			case ModulePackage.SWC__API_ENUM_CONSTANT:
			case ModulePackage.SWC__API_UPPER_LOWER_LIMIT_CONSTANT:
			case ModulePackage.SWC__SR_API_INIT_VALUE_CONSTANT:
			case ModulePackage.SWC__SR_IMPL_INIT_VALUE_CONSTANT:
			case ModulePackage.SWC__SR_IMPL_INVALID_VALUE_CONSTANT:
			case ModulePackage.SWC__SR_FILTER_CONSTANT:
			case ModulePackage.SWC__CS_API_APPLICATION_ERROR_CONSTANT:
			case ModulePackage.SWC__CS_PORT_ARG_VALUE_CONSTANT:
			case ModulePackage.SWC__CS_PORT_ARG_VALUE_VARIABLE:
			case ModulePackage.SWC__IRV_BUFFER_INIT_VALUE_CONSTANT:
			case ModulePackage.SWC__IRV_BUFFER_VARIABLE_SET:
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
				(ModulePackage.Literals.SWC__SWC_MEMORY_MAPPING,
				 ModuleFactory.eINSTANCE.createSwcMemoryMapping()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__DEPENDENT_RUNNABLE_ENTITY,
				 ModuleFactory.eINSTANCE.createRunnableEntity()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createWriteApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createReadApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createIrvReadApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createIrvWriteApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createInvalidateApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createSendApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createReceiveApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createCallApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createTfCallApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createRteEnterApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createRteExitApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__RTE_API,
				 ModuleFactory.eINSTANCE.createFeedbackApi()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__API_ENUM_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__API_ENUM_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__API_UPPER_LOWER_LIMIT_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__API_UPPER_LOWER_LIMIT_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__SR_API_INIT_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__SR_API_INIT_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__SR_IMPL_INIT_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__SR_IMPL_INIT_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__SR_IMPL_INVALID_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__SR_IMPL_INVALID_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__SR_FILTER_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__SR_FILTER_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_API_APPLICATION_ERROR_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_API_APPLICATION_ERROR_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_VARIABLE,
				 ModuleFactory.eINSTANCE.createGlobalVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_VARIABLE,
				 ModuleFactory.eINSTANCE.createRteBufferVariableSet()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_VARIABLE,
				 ModuleFactory.eINSTANCE.createGlobalVariableSet()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_VARIABLE,
				 ModuleFactory.eINSTANCE.createComProxyFunctionTableVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_VARIABLE,
				 ModuleFactory.eINSTANCE.createRteBufferQueuedVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_VARIABLE,
				 ModuleFactory.eINSTANCE.createModeQueuedVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__IRV_BUFFER_INIT_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstant()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__IRV_BUFFER_INIT_VALUE_CONSTANT,
				 ModuleFactory.eINSTANCE.createConstantMember()));

		newChildDescriptors.add
			(createChildParameter
				(ModulePackage.Literals.SWC__IRV_BUFFER_VARIABLE_SET,
				 ModuleFactory.eINSTANCE.createRteBufferVariableSet()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ModulePackage.Literals.SWC__API_ENUM_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__API_UPPER_LOWER_LIMIT_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__SR_API_INIT_VALUE_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__SR_IMPL_INIT_VALUE_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__SR_IMPL_INVALID_VALUE_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__SR_FILTER_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__CS_API_APPLICATION_ERROR_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__IRV_BUFFER_INIT_VALUE_CONSTANT ||
			childFeature == ModulePackage.Literals.SWC__CS_PORT_ARG_VALUE_VARIABLE ||
			childFeature == ModulePackage.Literals.SWC__IRV_BUFFER_VARIABLE_SET;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
