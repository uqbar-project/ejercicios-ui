package uqbar.videoclub.arena

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.Search

abstract class SearchWindow extends SimpleWindow {
  static final long serialVersionUID = 1L

  SearchWindow(WindowOwner owner, Search model) {
    super(owner, model)
  }

  @Override
  void createMainTemplate(Panel mainPanel) {
    super.createMainTemplate(mainPanel)
    createResultsGrid(mainPanel)
    createGridActions(mainPanel)
  }

  // ***********************************************************
  // ** Grid
  // ***********************************************************

  void createResultsGrid(Panel mainPanel) {
    new Table(mainPanel, modelObject.entityType).with {
      bindItemsToProperty(Search.RESULTS)
      bindSelection(Search.SELECTED)
      describeResultsGrid(it)
    }
  }

  abstract void describeResultsGrid(Table builder)

  // ***********************************************************
  // ** Actions
  // ***********************************************************

  @Override
  protected void addActions(Panel actionsPanel) {
    actionsPanel.describe {
      button {
        caption = "Buscar"
        onClick { this.modelObject.search() }
        setAsDefault()        
      }
    }

    // TODO Ver si agregamos la acción de limpiar:
    // new Button(actions).setCaption("Limpiar").onClick(new MessageSend(getModel(), "clear"));
  }

  protected void createGridActions(Panel mainPanel) {
    new Panel(mainPanel).describe {
      layout = new HorizontalLayout()
      button {
        caption = "Edit"
        bindEnabled(new NotNullObservable(Search.SELECTED))
        onClick { startEdition() }
      }
      button {
        caption = "Remove"
        bindEnabled(new NotNullObservable(Search.SELECTED))
        onClick{ modelObject.removeSelected() }
      }
    }
  }

  // ********************************************************
  // ** Actions
  // ********************************************************

  void startEdition() {
    createEditor(modelObject.selected).describe {
      onAccept { this.modelObject.search() }
      open()
    }
  }

  protected abstract Dialog createEditor(selected)

}
