package uqbar.videoclub.arena

import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.Search
import org.uqbar.lacar.ui.model.adapter.NotNullTransformer

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
    mainPanel.describe {
      table(items: "results", selection: "selected") {
        itemType = this.modelObject.entityType
        this.describeResultsGrid(it)
      }
    }
  }

  abstract void describeResultsGrid(Table builder)

  // ***********************************************************
  // ** Actions
  // ***********************************************************

  @Override
  void addActions(Panel actionsPanel) {
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

  void createGridActions(Panel mainPanel) {
    mainPanel.describe { 
      panel {
        layout = new HorizontalLayout()
        button(enabled: "selected".notNull()) {
          caption = "Edit"
          onClick { this.startEdition() }
        }
        button(enabled: "selected".notNull()) {
          caption = "Remove"
          onClick { this.modelObject.removeSelected() }
        }
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

  abstract Dialog createEditor(selected)

}
