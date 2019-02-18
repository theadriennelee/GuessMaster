
public class Entity { //class name
	private String name; //instance variable
	private Date born; //instance variable

	public Entity(String name, Date birthDate) { //constructor
		this.name = name; //setting the instance variable to name
		born = birthDate; //setting the instance variable to birthDate
	}
	public String getName() { //accessor 
		return name; //access the name
	}
	public Date getBorn() { //accessor 
		return new Date(born); //access the day the person was born
	}
	public Entity(Entity entity) { //copy constructor
		this.name = new String(entity.name); //create new variable in object entity
		this.born = new Date(entity.born); //create new variable in object entity
	}

	public String toString() { //method that brings the name of the person and the day they were born
		return (name + ", born on" + born);
	}

	public boolean equals(Entity entity) { //compares two entities 
		if (entity == null) //if there is no entity
			return false; //then return false
		else //if there is an entity
			return (name.equals(entity.name) && born.equals(entity.born)); //compare the entity by comparing both instance variables
	}
}
