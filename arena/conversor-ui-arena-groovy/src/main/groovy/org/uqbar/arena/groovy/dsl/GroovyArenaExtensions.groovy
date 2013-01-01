package org.uqbar.arena.groovy.dsl

import java.lang.reflect.Modifier

import groovy.lang.Closure

import org.apache.commons.lang.WordUtils
import org.reflections.Reflections
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Container
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.Widget
import org.uqbar.arena.widgets.tree.Tree
import org.uqbar.arena.windows.Dialog
import org.uqbar.commons.model.IModel
import org.uqbar.lacar.ui.model.Action

/**
 * Agrega soporte para:
 * <ul>
 * <li>Pasar bloques ({@link Closure}s) en donde se espera una {@link Action}</li>
 * <li>"Describir" declarativamente y jerarquicamente los contenidos de los widgets, empleando él método </li>
 * 
 * </ul>
 * @author flbulgarelli
 *
 */
class GroovyArenaExtensions {

  static def action(Closure closure) {
    closure as Action
  }

  private static makeDescriptive() {
    Widget.metaClass.describe = { description ->
        def thisWidget = delegate
        def described = thisWidget instanceof Container ?
            new RichContainer(container: thisWidget) :
            thisWidget
        description.clone().with {
          it.delegate = described
          it(thisWidget)
        }
        thisWidget
    }
  }
  
  private static makeBindable() {
    Widget.metaClass.bind = { Map bindings ->
      def thisWidget = delegate
      bindings.each { binding, property ->
        //fea consideración, habría que cambiar Arena para que respete una convencion
        if(binding == "contents")
          thisWidget.bindContents(property)
        else
          thisWidget."bind${binding.capitalize()}ToProperty"(property)
      }
    }
  }

  private static supportClosuresAsActions() {
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

  static {
    makeDescriptive()
    makeBindable()
    supportClosuresAsActions()
  }
}

