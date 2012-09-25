package com.uqbar.project.edu.progui.ejemplos.ui.wicket;

import java.util.List;

import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public abstract class AbstractListView extends ListView {

	public AbstractListView(String id) {
		super(id);
	}

	public AbstractListView(String id, IModel model) {
		super(id, model);
	}

	public AbstractListView(String id, List<?> list) {
		super(id, list);
	}

	@Override
	protected IModel getListItemModel(IModel listViewModel, int index) {
		return new CompoundPropertyModel(((List<?>) listViewModel.getObject()).get(index));
	}

}