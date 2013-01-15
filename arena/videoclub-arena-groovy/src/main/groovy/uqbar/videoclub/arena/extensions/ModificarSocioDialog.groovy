package uqbar.videoclub.arena.extensions

import org.uqbar.arena.windows.WindowOwner

import tadp.blocbaster.entidades.Socio

/**
 * @author npasserini
 */
class ModificarSocioDialog extends AbstractSocioDialog {
  static final long serialVersionUID = -5686548988446128817L

  ModificarSocioDialog(WindowOwner owner, Socio socio) {
    super(owner, socio)
  }

  @Override
  void executeTask() {
    super.executeTask()
    home.update(modelObject)
  }
}
