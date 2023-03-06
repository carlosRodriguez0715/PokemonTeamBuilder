package application;
/**
 * @author: Carlos Rodriguez
 * Class contains basic information
 * about Pokemons. */

public class Pokemon {
	private String name;
	private String[] types;
	
	//Default Constructor
	public Pokemon() {
		this.setName("");
		this.setTypes(null);
	}
	
	//Passing name and types to constructor
	public Pokemon(String name, String[] types) {
		this.setName(name);
		this.setTypes(types);
	}

	//Getters
	public String getName() {
		return name;
	}
	
	public String[] getTypes() {
		return types;
	}

	//Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}
	
	//Equals override
	public boolean equals(Object obj) {
		if(!(obj instanceof Pokemon)) {return false;}
		if(obj == this) {return true;}
		Pokemon pokeObj = (Pokemon) obj;
		return pokeObj.name.equals(this.name) && pokeObj.types.equals(this.types);
	}
	
	//toString override
	public String toString() {
		return "NAME: " + this.name + ". TYPE(s): " + this.types.toString();
	}
}
