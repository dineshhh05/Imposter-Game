package Lab5;

/**
 * This class implements a game like 'among us'
 *
 */
public class Game {
	private Player[] player;
	private Map map;
	

	/**
	 * This is the default constructors. 
	 * At most 10 player can play this game. 
	 */
	private Game() {
		this.player = new Player [10];
		this.map = Map.getInstance();
	}


	/**
	 * This is the overloaded constructor for this class
	 * @param player is an array containing all the players who entered the game.
	 * @param map is the area that is available to the players to play.
	 */
	private Game(Player[] player, Map map) {
		this.player = new Player[player.length];

		for (int i = 0; i < player.length; i++) {
	        this.player[i] = Player.getInstance(player[i]);  // Deep copy of each Player
	    }
		this.map = map;
	}
	

	/**
	 * This the copy constructor for this class
	 * @param game is an object of Game, whose component is deeply copied into 
	 * the component of this object.
	 */
	private Game(Game other) {
		this.player = other.player;
		this.map = other.map;
	}

	
	/**
	 * This is a static factory method
	 * @return IT returns an object of Game
	 */
	public static Game getInstance() {
		return new Game();
	}

	
	/**
	 * This is a static factory method
	 * @param player is an array that contains players.
	 * @param map is a map of the game
	 * @return It returns an object of Game made using the input parameters.
	 */
	public static Game getInstance(Player[] player, Map map){
		return new Game(player, map);
	}

	
	/**
	 * This is a static factory method
	 * @param game is an object of Game
	 * @return it returns an object of Game made using the input parameter. 
	 */
	public static Game getInstance(Game other) {
		return new Game(other);
	}


	/**
	 * This is the getter method for the player list.
	 * @return returns an array containing all the players of this game. 
	 */
	public Player[] getPlayer() {
		Player[] copy = new Player[this.player.length];
    	for (int i = 0; i < this.player.length; i++) {
    		copy[i] = Player.getInstance(this.player[i]);  // Return deep copy
	    }
    	
    	return copy;
	}


	/**
	 * This is the getter method for the map attribute.
	 * @return Returns an object of map containing all the components of this game's map.
	 */
	public Map getMap() {
		return Map.getInstance(this.map);
	}


	/**
	 * This is the setter method for the player attribute, which deeply copies 
	 * the input parameter into the player attribute of this object. 
	 * @param player is an array of Player, whose elements are copied in the player attribute of this object.
	 */
	public void setPlayer(Player[] player) {
		this.player = new Player[player.length];
        for (int i = 0; i < player.length; i++) {
            this.player[i] = Player.getInstance(player[i]);  // Deep copy of each Player
        }
	}
	

	/**
	 * This is the setter method for the map attribute, which deeply copies 
	 * the input parameter into the map attribute of this object.
	 * @param map is an object of Map, whose attributes are copied in the map attribute of this object.
	 */
	public void setMap(Map other) {
		this.map = Map.getInstance(other);
	}

	
} // end of class Game	


/**
 * 
 * This class implements all a player requires to play in this game. 
 *
 */
class Player {
	
	public String name;
	public Role role;
	
	private Player() {
		this.name = "";
		this.role = new Role();
	}
	
	
	/**
	 * This is the overloaded constructor for this class
	 * @param name
	 * @param role
	 */
	private Player(String name, Role role) {
		this.name = name;
		this.role = role;
	}

	
	/**
	 * This is the copy constructor for this class
	 * @param player
	 */
	private Player(Player other) {
		this.name = other.name;
		this.role = other.role;
	}

	
	
	/**
	 * This is a static factory method.
	 * @return It returns an object of Player
	 */
	public static Player getInstance() {
		return new Player();
	}

	
	/**
	 * This is a static factory method
	 * @param name is the name of player
	 * @param role is the role of the palyer in the game
	 * @return It returns an object of player, which is made by the two input variables. 
	 */
	public static Player getInstance(String name, Role role) {
		return new Player(name, role);
	}

	
	/**
	 * This is a static factory method
	 * @param player is an object of player
	 * @return it returns an object of player that is made using the input parameter. 
	 */
	public static Player getInstance(Player other) {
		return new Player(other);
	}


	/**
	 * This is the getter method for attribute name
	 * @return returns the value of attribute name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This is the getter method for attribute role
	 * @return returns the reference to attribute role.
	 */
	public Role getRole() {
		return this.role;
	}
	
	
	/**
	 * This is the setter method for attribute name
	 * @param name  is the value that is used to initialize name attribute
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This is the setter method for attribute role
	 * @param role is the object, whose reference is used to initialize attribute role.
	 */
	public void setRole(Role role) {
		this.role = role;
	} 

	
} // end of class Player
/**
 * This class implements the areas in which players can play.
 *
 */
class Map{
	public String theSkeld;
	public String miraHq;
	public String polus;
	public String airShip;
	
	private Map() {
		this.theSkeld = "";
        this.miraHq = "";
        this.polus = "";
        this.airShip = "";
	}
	
	
	/**
	 * This is the overloaded constructor.
	 * @param theSkeld is the first area in which player can play.
	 * @param miraHq is the second area in which player can play.
	 * @param polus is the third area in which player can play.
	 * @param airShip  is the fourth area in which player can play.
	 */
	private Map(String theSkeld, String miraHq, String polus, String airShip) {
		this.theSkeld = theSkeld;
		this.miraHq = miraHq;
		this.polus = polus;
		this.airShip = airShip;
	}

	
	
	/**
	 * This is a static factory method that initializes the attributes to their default values. 
	 * @return It returns an object of MAP
	 */
	public static Map getInstance() {
		return new Map();
	}

	
	
	/**
	 * This is a static factory method
	 * @param theSkeld is the first area in which player can play.
	 * @param miraHq is the second area in which player can play.
	 * @param polus is the third area in which player can play.
	 * @param airShip  is the fourth area in which player can play.
	 * @return it returns an object of MAP.
	 */
	public static Map getInstance(String theSkeld, String miraHq, String polus, String airShip) {
		return new Map(theSkeld, miraHq, polus, airShip);
	}

	
	
	/**
	 * This is the copy constructor.
	 * @param map is an object of Map that is used to initialize this object.
	 */
	private Map(Map other) {
		this.theSkeld = other.theSkeld;
		this.miraHq = other.miraHq;
		this.polus = other.polus;
		this.airShip = other.airShip;
	}

	
	
	/**
	 * This is a static factory method. 
	 * @param map is an object of Map
	 * @returnIt returns an object of Map
	 */
	public static Map getInstance(Map other) {
		return new Map(other);
	}

} // end of class Map



/**
 * 
 * This class presents the role of the players, 
 * which can be either imposter or crewmate. 
 *  Imposter role, gets the value of 'i'and 
 *  Cremate gets the value of 'c'
 *
 */
class Role{
	
	public char role;
	
	public Role() {
		this.role = ' ';
	}
	
	
	/**
	 * This is the overloaded constructor.
	 * @param role is used as an initial value of the instance variable role
	 */
	private Role(char role) {
		this.role = role;
	}
	
	
	/**
	 * This is a static factory method.
	 * @return it returns a reference to an object that is created in this factory method.
	 */
	public static Role getInstance() {
		return new Role();
	}

	
	
	/**
	 * This is a static factory method.
	 * @param role is the initial value of the role
	 * @return it returns a reference to an object that is created in this factory method.
	 */
	public static Role getInstance(char role) {
		return new Role(role);
	}

	
	/**
	 * This is the copy constructor. 
	 * @param role is an object of Role that is used to initialize the instance variable role.
	 */
	private Role(Role other) {
		this.role = other.role;
	}


	
	
	/**
	 * This is a static factory method
	 * @param role is a variable of type Role
	 * @return it returns an object of Role.
	 */
	public static Role getInstance(Role other) {
		return new Role(other);
	}

	
	/**
	 * This is the getter method for the role
	 * @return It returns the role of the player
	 */
	public char getRole() {
		return role;
	}


	
	
	/**
	 * This is the setter method for the role
	 * @param role is the initial value for attribute role
	 */
	public void setRole(char role) {
		this.role = role;
	}
	
} // end of class Role
