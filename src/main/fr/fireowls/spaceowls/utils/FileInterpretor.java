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
 * @version 1.7.1
 *
 */
public class FileInterpretor {

	private BufferedReader br;
	private FileReader fr;
	private ArrayList<String> content;
	private ArrayList<Corp> corpCreated;
	private SpaceSystem ss;
	
	public static void main(String[] args) {
		FileInterpretor fi = new FileInterpretor("res/system/04_ExempleDuSujet.astro");
		SpaceSystem ss = fi.ss;
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
			this.fr = new FileReader(fileName);
			this.br = new BufferedReader(this.fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}finally {
			System.out.println("Fichier "+fileName+" trouvé.");
			this.content = new ArrayList<>();
			this.corpCreated = new ArrayList<>();
			createSystem();
			try {
				this.fr.close();
				this.br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Recupere le contenu du fichier
	 * @return une liste avec une case par ligne du fichier
	 */
	public void getContent() {
		String in = null;
		try {
			in = this.br.readLine();
		} catch (IOException e) {
			return ;
		}
		while(in != null) {
			if(in == "") {
				
			}else {
				content.add(in+"\n");
			}
			
			try {
				in = this.br.readLine();
			} catch (IOException e) {
				return;
			}
		}
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
		this.ss = new SpaceSystem(g,dt,fa,rayon);
		this.ss.setCorps(createCorp(idx+1));
		return ss;
	}
	
	public ArrayList<Corp> createCorp(int idx) {
		ArrayList<Corp> elements = new ArrayList<>();
		for(int i = idx; i  < this.content.size(); i++) {
			if(this.content.get(i).split(":").length == 2) {
				String name = this.content.get(i).split(":")[0];
				String line = this.content.get(i).split(":")[1].substring(1);
				line = line.substring(0,line.length()-1);
				double mass = Double.parseDouble(line.split(" ")[1].split("=")[1]);

				CorpType type = getCorpType(line);
				Corp c = null;
				int posX = 0;
				int posY = 0;
				Location location = null;
				double vitX = 0;
				double vitY = 0;
				switch (type){
					case STATIC:
						posX = Integer.parseInt(line.split(" ")[2].split("=")[1]);
						posY = Integer.parseInt(line.split(" ")[3].split("=")[1]);
						location = new Location(posX,posY);
						c = CorpFactory.createStaticCorp(location);
						break;
					case SIMULE:
						posX = Integer.parseInt(line.split(" ")[2].split("=")[1]);
						posY = Integer.parseInt(line.split(" ")[3].split("=")[1]);
						location = new Location(posX,posY);
						vitX = Double.parseDouble(line.split(" ")[4].split("=")[1]);
						vitY = Double.parseDouble(line.split(" ")[5].split("=")[1]);
						c = CorpFactory.createSimuleCorp(location,vitX,vitY, ss);
						break;
					case VAISSEAU:
						posX = Integer.parseInt(line.split(" ")[2].split("=")[1]);
						posY = Integer.parseInt(line.split(" ")[3].split("=")[1]);
						location = new Location(posX,posY);
						vitX = Double.parseDouble(line.split(" ")[4].split("=")[1]);
						vitY = Double.parseDouble(line.split(" ")[5].split("=")[1]);
						double ppropul = Double.parseDouble(line.split(" ")[6].split("=")[1]);
						double pretro = Double.parseDouble(line.split(" ")[7].split("=")[1]);
						c = CorpFactory.createShipCorp(location,vitX,vitY,ppropul,pretro);
						break;
					case ELLIPSE:
						posX = Integer.parseInt(line.split(" ")[4].split("=")[1]);
						posY = Integer.parseInt(line.split(" ")[5].split("=")[1]);
						location = new Location(posX,posY);
						String name1 = line.split(" ")[2].split("=")[1];
						String name2 = line.split(" ")[3].split("=")[1];
						Corp c1 = getCreatedCorp(name1);
						Corp c2 = getCreatedCorp(name2);
						int periode = Integer.parseInt(line.split(" ")[6].split("=")[1]);
						c = CorpFactory.createEllipseCorp(location,c1,c2,periode);
						break;
				}
				c.setMass(mass);
				c.setName(name);
				this.corpCreated.add(c);
				elements.add(c);
				System.out.println("Corp "+name+" created!");
			}
			
		}
		return elements;
	}
	
	/**
	 * Methode qui retour le type de corp de la ligne passé en parametre
	 * @param line est la ligne du corp
	 * @return le type du corp
	 */
	public CorpType getCorpType(String line) {
		String type = line.split(" ")[0];
		if(type.equals(CorpType.STATIC.getName())) return CorpType.STATIC;
		else if(type.equals(CorpType.SIMULE.getName())) return CorpType.SIMULE;
		else if(type.equals(CorpType.VAISSEAU.getName())) return CorpType.VAISSEAU;
		else if(type.equals(CorpType.ELLIPSE.getName())) return CorpType.ELLIPSE;
		return null;
	}
	
	public Corp getCreatedCorp(String name) {
		for(Corp c:this.corpCreated) {
			if(c.getName().equals(name)) return c;
		}
		return null;
	}
}
