package com.galere.pictures.services;

import java.util.List;

import org.springframework.core.io.FileSystemResource;

import com.galere.pictures.entities.Image;
import com.galere.pictures.repositories.ImageRepository;

/**
 * <b>
 * 	Interface du service permettant de gérer les images stoqués en base de données, et sur la machine.
 * </b>
 * 
 * @see ImageRepository
 * @see Image
 * @see FileSystemResource
 * 
 * @author Ilias HATTANE
 * @version 1.0
 *
 */
public interface IImageService {
	
	/**
	 * <b> Récupérer l'instance du repository ImageRepository, et l'accès à la gestion des images stoquées en base de données. </b>
	 * 
	 * @return L'instance du repository.
	 */
	public ImageRepository getRepository();
	
	/**
	 * <b> Sauvegarder une image image en base de données et sur la machine. </b>
	 * 
	 * @param img L'instance de l'image à sauvegarder en base de données.
	 * @param content Le tableau de byte décrivant l'image.
	 * @param name Le nom de l'image.
	 * @return L'image sauvegardée.
	 */
	public Image saveImage(Image img, byte[] content, String name);
	
	/**
	 * <b> Récupérer une image stoquée sur la machine, grâce à l'id de l'image en base de données. </b>
	 * 
	 * @param id L'id de l'image recherchée.
	 * @return Le fichier de l'image.
	 */
	public FileSystemResource findImage(Long id);
	
	/**
	 * <b> Vérifier si une image existe en base de données grâce à son titre. </b>
	 * 
	 * @param title Le titre recherché.
	 * @return Un boolean : true si elle existe, false sinon.
	 */
	public boolean existsImage(String title);
	
	/**
	 * <b> Rechercher les images en lien avec les mots clés passés en paramètre. </b>
	 * 
	 * <p> La recherche est effectuée par rapport aux champs : </p>
	 * 	<ul>
	 * 		<li> Titre </li>
	 * 		<li> Description </li>
	 * 		<li> Tags (mots clés) </li>
	 * 		<li> Contenu de l'image </li>
	 * 		<li> Catégories de l'image </li>
	 * 		<li> Date d'ajout </li>
	 * 		<li> Id </li>
	 * 	</ul>
	 * 
	 * @param tags Les mots clés utilisés pour la recherche, séparés par un espace.
	 * @return La liste des images qui correspondent aux mots clés.
	 */
	public List<Image> searchByTags(String tags);

}
