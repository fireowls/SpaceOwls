package fr.fireowls.spaceowls.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.system.corp.CorpFactory;
import fr.fireowls.spaceowls.system.corp.CorpType;

/**
 * Class qui permet l'interpretaion de fichier systeme (.astro) pour créer le systeme et les objets preciser dans le ficher
 * @author bankaerb
 *
 */
public class FileInterpretor {

	private BufferedReader br;
	private FileReader fr;
	private ArrayList<String> content;
	
	public static void main(String[] args) {
		FileInterpretor fi = new FileInterpretor("04_ExempleDuSujet.astro");
		System.out.println("recup du contenu");
		fi.getContent();
		System.out.println("contenu recup | Creation du systeme");
		SpaceSystem ss = fi.createSystem();
		System.out.println("Systeme crée");
		System.out.println("g="+ss.getG()+" dt="+ss.getDt()+" fa="+ss.getFa()+" rayon="+ss.getRayon());
		System.out.println("Liste des fr.fireowls.spaceowls.system.corp");
		for(Corp c:ss.getCorps()) {
			System.out.println(c.toString());
		}
		System.out.println("Fin des teste");
		
	}

	/**
	 * Creer l'interpreteur du ficher passee en parametre
	 * @param fileName est le fichier que l'on veut charger
	 */
	public FileInterpretor(String fileName) {
		try {
			this.fr = new FileReader("res/system/"+fileName);
			this.br = new BufferedReader(this.fr);
		} catch (FileNotFoundException e) {
			return;
		}finally {
			System.out.println("Fichier "+fileName+" trouvé.");
		}
		this.content = new ArrayList<String>();
	}

	/**
	 * Recupere le contenu du fichier
	 * @return une liste avec une case par ligne du fichier
	 */
	public ArrayList<String> getContent() {
		String in = null;
		try {
			in = this.br.readLine();
		} catch (IOException e) {
			return null;
		}
		while(in != null) {
			if(in == "") {
				
			}else {
				content.add(in+"\n");
			}
			
			try {
				in = this.br.readLine();
			} catch (IOException e) {
				return null;
			}
		}
		return content;
	}

	/**
	 * Creer un systeme en fonction des informations du fichier
	 * @return le systeme creer
	 */
	public SpaceSystem createSystem() {
		getContent();
		double g = 0;
		double dt = 0;
		double fa = 0;
		double rayon = 0;
		
		boolean find = false;
		int idx = 0;		
		while(!find) {
			if(this.content.get(idx).contains("PARAMS ")) {
				find = true;
			}else { idx++; }
		}
		g = Double.parseDouble(this.content.get(idx).split(" ")[1].split("=")[1]);
		dt = Double.parseDouble(this.content.get(idx).split(" ")[2].split("=")[1]);
		fa = Double.parseDouble(this.content.get(idx).split(" ")[3].split("=")[1]);
		rayon = Double.parseDouble(this.content.get(idx).split(" ")[4].split("=")[1]);
		
		return new SpaceSystem(g,dt,fa,rayon,createCorp(idx+1));
	}
	
	public ArrayList<Corp> createCorp(int idx) {
		ArrayList<Corp> elements = new ArrayList<>();
		for(int i = idx; i  < this.content.size(); i++) {
			String name = this.content.get(i).split(":")[0];
			String line = this.content.get(i).split(":")[1].substring(1);
			line = line.substring(0,line.length()-1);
			double[] args = getAllArguments(line);
			double mass = Double.parseDouble(line.split(" ")[1].split("=")[1]);
			Corp c = CorpFactory.createCorp(name, args);
			c.setMass(mass);
			elements.add(c);
		}
		return elements;
	} 
	
	public double[] getAllArguments(String s) {
		int nbOfArgs = s.split(" ").length;
		double[] args = new double[nbOfArgs-2];
		for(int i = 2; i < nbOfArgs; i++) {
			args[i-2] = Double.parseDouble(s.split(" ")[i].split("=")[1]);
		}
		return args;
		
	}
}
