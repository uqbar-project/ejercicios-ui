package org.uqbar.arena.examples.conversor

import groovy.lang.Closure

import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.Widget
import org.uqbar.arena.widgets.tree.Tree
import org.uqbar.arena.windows.Dialog
import org.uqbar.lacar.ui.model.Action

class GroovyArenaExtensions {

  static def action(Closure closure) {
    closure as Action
  }

  static {
    Widget.metaClass {
      describe = { delegate.with(it) }
    }
    [
      [Selector, 'onSelection'],
      [Tree, 'onClickItem'],
      [Tree, 'onExpand'],
      [Dialog, 'onAccept'],
      [Dialog, 'onCancel'],
      [Button, 'onClick']
    ].each { ConcreteWidget, selector ->
      ConcreteWidget.metaClass."$selector" = { Closure actionClosure ->
        delegate."$selector"(action(actionClosure))
      }
    }
  }
}
