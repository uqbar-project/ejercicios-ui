/**
 * 
 */
package uqbar.videoclub.model;

import java.io.Serializable;

/**
 * Clase base para todos nuestros objetos de negocio / casos de uso.
 * Implementa la interfaz Serializable, requisito de wicket sobre cualquier objeto 
 * que utilizemos como model en las pantallas.
 * 
 * Esto es debido a que wicket mantiene estado en el servidor. Para hacer esto "guarda" todo el grafo de
 * objetos a trav�s de un mecanismo llamado "serializaci�n de objetos", que es nada m�s y nada menos que pasarlos
 * a un formato binario.
 * 
 * @author jfernandes
 */
public abstract class AbstractVideoClubObject implements Serializable {

}
