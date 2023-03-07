package application;

import java.util.ArrayList;

/**
 * @author: Carlos Rodriguez
 * Class contains basic information
 * about Pokemons. */

public class Pokemon {
	private String name;
	private Object[] types;
	
	//Default Constructor
	public Pokemon() {
		this.setName("");
		this.setTypes(null);
	}
	
	//Passing name and types to constructor
	public Pokemon(String name, Object[] types) {
		this.setName(name);
		this.setTypes(types);
	}

	//Getters
	public String getName() {
		return name;
	}
	
	public Object[] getTypesArr() {
		return types;
	}
	
	public String getTypes() {
		if(this.types.length == 1) {
			String t1 = this.types[0].toString().substring(20, 32).toUpperCase();
			String[] filtert1 = t1.split(",");
			return filtert1[0].toUpperCase();
		}
		if(this.types.length > 1) {
			String t1 = this.types[0].toString().substring(20, 32);
			String[] filtert1 = t1.split(",");
			String t2 = this.types[1].toString().substring(20, 32);
			String[] filtert2 = t2.split(",");
			
			return filtert1[0].toUpperCase() + "/" + filtert2[0].toUpperCase();
		}
		return "";
	}

	//Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setTypes(Object[] types) {
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
		return "NAME: " + this.name.toUpperCase() + ". TYPE(s): " + this.getTypes();
	}
}
