package org.uqbar.arena.examples.conversor

import org.uqbar.commons.utils.Observable


@Observable class Conversor {
  double millas
  double kilometros

  void convertir() {
    kilometros = millas * 1.60934
  }
}
