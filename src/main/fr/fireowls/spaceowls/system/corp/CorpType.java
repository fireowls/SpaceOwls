package fr.fireowls.spaceowls.system.corp;

public enum CorpType {

	STATIC("Fixe", StaticCorp.class),
	SIMULE("Simulé",SimuleCorp.class),
	ELLIPSE("Ellipse", EllipseCorp.class),
	CERCLE("Cercle",CircleCorp.class),
	VAISSEAU("Vaisseau",ShipCorp.class);
	
	private String name;
	private Class<? extends Corp> c;
	
	private CorpType(String name, Class<? extends Corp> c) {
		this.name = name;
		this.c = c;
	}
	
	public String getName() {
		return name;
	}

	public Class<? extends Corp> getCorpClass() {
		return c;
	}

}
