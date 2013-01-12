package uqbar.videoclub.arena

import java.text.SimpleDateFormat
import java.util.Arrays

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Control
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.Search
import org.uqbar.commons.model.SearchByExample

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
    super(owner, new SearchByExample(Videoclub.instance.getHome(Socio)))
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
    searchFormPanel.bindContents(SearchByExample.EXAMPLE)
    searchFormPanel.setLayout(new ColumnLayout(2))

    // Field nombre
    Label nombreLabel = new Label(searchFormPanel)
    nombreLabel.setText("Nombre")

    Control nombre = new TextBox(searchFormPanel)
    nombre.bindValueToProperty(Socio.NOMBRE)

    // Field direccion
    Label direccionLabel = new Label(searchFormPanel)
    direccionLabel.setText("Direccion")

    Control direccion = new TextBox(searchFormPanel)
    direccion.bindValueToProperty(Socio.DIRECCION)

    new Label(searchFormPanel).setText("Estado")
    new Selector(searchFormPanel).setContents(Arrays.asList(Socio.Estado.values()), "nombre").bindValueToProperty("estado")
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
    new Button(actionsPanel).with {
      setCaption("Nuevo Socio")
      onClick(new MessageSend(this, "crearSocio"))
    }
    super.addActions(actionsPanel)
  }

  // ********************************************************
  // ** Acciones
  // ********************************************************

  void crearSocio() {
    new CrearSocioDialog(this).with {
      onAccept(new MessageSend(this.getModelObject(), Search.SEARCH))
      open()
    }
  }

  @Override
  Dialog createEditor(selected) {
    new ModificarSocioDialog(this, selected)
  }

}
