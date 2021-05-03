package com.galere.pictures.entities.mocked;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <b>
 * 	Symbolise une catégorie. Une catégorie est appliquée à une image.
 * </b>
 * <p> Une catégorie est décrite par : </p>
 * <ul>
 *   <li> Son ID </li>
 *   <li> Son libellé </li>
 *  </ul>
 * <p>
 * 	Toute catégorie contient la liste des images auxquelles elle a été appliquée. 
 * </p>
 * 
 * @author Ilias HATTANE
 * @version 1.0
 *
 */
public class Category {
	
	/**
	 * <b> L'ID de la catégorie. </b>
	 * 
	 * @see Category#getId()
	 * @see Category#setId(Long)
	 * @see Category#toString()
	 * 
	 */
	private Long id;
	
	/**
	 * <b> Le libellé de lacatégorie. </b>
	 * 
	 * <p> Sa taille ne dépasse pas 35 carractères.
	 * 
	 * @see Category#getLabel()
	 * @see Category#setLabel(String)
	 * @see Category#toString()
	 */
	private String label;

	/**
	 * <b> Récupérer l'id de la catégorie. </b>
	 * 
	 * @return L'id de la catégorie.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * <b> Définir l'id de la catégorie </b>
	 * 
	 * @param id Le nouvel id de cette catégorie.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <b> Récupérer le libellé de la catégori. </b>
	 * 
	 * @return Le libellé de la catégorie.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <b> Définir le nouveau libellé de la catégorie. </b>
	 * 
	 * @param label Le libellé de la catégorie.
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * <b> Récupérer une description écrite de la catégorie. </b>
	 * 
	 * @return La description.
	 */
	@Override
	public String toString() {
		return "[" + getId() + "] " + getLabel();
	}
	
}

