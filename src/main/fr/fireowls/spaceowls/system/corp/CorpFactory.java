package fr.fireowls.spaceowls.system.corp;

import java.lang.reflect.InvocationTargetException;

public class CorpFactory {

	/**
	 * Methode qui inctancier un corp en fonction du type passé en parametre
	 * @param name est le nom du corp
	 * @param type est le type du corp (Static,Simule,Ship,..)
	 * @param doubles est la liste des parametre du corp
	 * @return le corp en fonction des parametre donné
	 */
	public static Corp createCorp(CorpType type,Object[] objs) {
		try {
			return type.getCorpClass().getConstructor(Object[].class).newInstance(objs);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

}
