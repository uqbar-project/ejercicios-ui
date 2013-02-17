package uqbar.videoclub.arena

import java.text.SimpleDateFormat
import java.util.Arrays

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Control
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.SearchByExample
import org.uqbar.lacar.ui.model.Action

import tadp.blocbaster.daos.Videoclub
import tadp.blocbaster.entidades.Socio

import com.uqbar.commons.collections.Transformer

/**
 * Representa la ventana de busqueda de socios del videoclub.
 * 
 * @author npasserini
 */
class BuscarSociosWindow extends SearchWindow {

  BuscarSociosWindow(WindowOwner owner) {
    super(owner, new SearchByExample(Socio.home))
  }

  @Override
  void createMainTemplate(Panel formBuilder) {
    this.setTitle("Buscador de Socios")
    this.setTaskDescription("Ingrese los parámetros de búsqueda")
    super.createMainTemplate(formBuilder)
  }

  @Override
  void createFormPanel(Panel mainPanel) {
    Panel searchFormPanel = new Panel(mainPanel)
    searchFormPanel.describe {
      bindContents(SearchByExample.EXAMPLE)
      layout = new ColumnLayout(2)
      label {
        text = "Nombre"
      }
      textBox(value: "nombre" ) 
      
      label {
        text = "Direccion"
      }
      textBox(value: "direccion") 
      
      label {
        text = "Estado"
      }
      selector( value: "estado") {
        setContents(Socio.Estado.values() as List, "nombre")
      }
    }
  }

  @Override
  void describeResultsGrid(Table table) {
    table.describe {
      heigth = 300
      width = 600
      
      column {
        title = "Nombre"
        fixedSize = 200
        bindContentsToProperty(Socio.NOMBRE)
      }
      column {
        title = "Fecha de ingreso"
        fixedSize = 200
        bindContentsToTransformer(new Transformer<Socio, String>() {
              String transform(Socio socio) {
                socio.fecha.format("dd/MM/yyyy")
              }
            })
      }
      column {
        title = "Direccion"
        fixedSize = 200
        bindContentsToProperty(Socio.DIRECCION)
      }
    }
  }

  @Override
  void addActions(Panel actionsPanel) {
    super.addActions(actionsPanel)
    
    actionsPanel.describe {
      button {
        caption = "Nuevo Socio"
        onClick { crearSocio() }
      }
    }
  }

  // ********************************************************
  // ** Acciones
  // ********************************************************

  void crearSocio() {
    new CrearSocioDialog(this).with {
      onAccept( new MessageSend(this.modelObject, "search"))
      open()
    }
  }

  @Override
  Dialog createEditor(selected) {
    new ModificarSocioDialog(this, selected)
  }

}
