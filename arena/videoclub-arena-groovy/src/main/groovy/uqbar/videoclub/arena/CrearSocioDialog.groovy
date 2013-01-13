package uqbar.videoclub.arena

import org.uqbar.arena.windows.WindowOwner

import tadp.blocbaster.entidades.Socio

/**
 * 
 * @author npasserini
 */
class CrearSocioDialog extends AbstractSocioDialog {

  CrearSocioDialog(WindowOwner owner) {
    super(owner, new Socio())
  }

  @Override
  void executeTask() {
    super.executeTask()
    home.create(modelObject)
  }
}
