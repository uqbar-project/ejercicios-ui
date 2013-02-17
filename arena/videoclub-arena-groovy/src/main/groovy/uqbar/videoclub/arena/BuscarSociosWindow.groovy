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
  void describeResultsGrid(Table<Socio> table) {
    Column<Socio> nombreColumn = new Column<Socio>(table)
    nombreColumn.setTitle("Nombre")
    nombreColumn.setFixedSize(200)
    nombreColumn.bindContentsToProperty(Socio.NOMBRE)
    // table.add(column);

    Column<Socio> ingresoColumn = new Column<Socio>(table)
    ingresoColumn.setTitle("Fecha de ingreso")
    ingresoColumn.setFixedSize(200)
    ingresoColumn.bindContentsToTransformer(new Transformer<Socio, String>() {
          @Override
          String transform(Socio socio) {
            new SimpleDateFormat("dd/MM/yyyy").format(socio.getFecha())
          }
        })

    Column<Socio> direccionColumn = new Column<Socio>(table)
    direccionColumn.setTitle("Direccion")
    direccionColumn.setFixedSize(200)
    direccionColumn.bindContentsToProperty(Socio.DIRECCION)

    table.setHeigth(300)
    table.setWidth(600)
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
