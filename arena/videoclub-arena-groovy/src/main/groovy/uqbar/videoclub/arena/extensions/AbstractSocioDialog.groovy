package uqbar.videoclub.arena.extensions

import java.util.Arrays
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.bindings.DateAdapter
import org.uqbar.arena.groovy.dsl.ArenaDSL;
import org.uqbar.arena.groovy.dsl.RichContainer;
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.Home

import tadp.blocbaster.daos.Videoclub
import tadp.blocbaster.entidades.Ciudad
import tadp.blocbaster.entidades.Socio

/**
 * @author npasserini
 */
abstract class AbstractSocioDialog extends TransactionalDialog {
  def home

  AbstractSocioDialog(WindowOwner owner, Socio model) {
    super(owner, model)
    this.home = Socio.home
  }

  @Override
  void createMainTemplate(Panel mainPanel) {
    title = "ABM de Socios"
    super.createMainTemplate(mainPanel)
  }

  @Override
  void createFormPanel(Panel mainPanel) {
    mainPanel.describe {
      panel {
        layout = new ColumnLayout(2)
        
        labeledTextBox("Nombre", "nombre")

        labeledTextBox("Direccion", "direccion")

        labeledTextBox("Fecha de Ingreso", "fecha".adaptDate())

        labeledSelector(
            label: "Estado",
            value: "estado",
            options: Socio.Estado.values())

        labeledSelector(
            label: "Ciudad",
            value: "ciudad",
            options: Ciudad.home.allInstances())
      }
    }
  }

  @Override
  void addActions(Panel actions) {
    actions.describe {
      button {
        caption = "Aceptar"
        onClick { this.accept() }
        setAsDefault()
        disableOnError()
      }
      button {
        caption = "Cancelar"
        onClick { this.cancel() }
      }
    }
        
  }
}