package table.queries;

public class TableQueries {

	public static final String SQL_ACTION = "CREATE TABLE Action (" + "id_action INT PRIMARY KEY, "
			+ "action_type VARCHAR(255), " + "times INT);";

	public static final String SQL_BOARD = "CREATE TABLE Board (" + "id_board INT PRIMARY KEY AUTO_INCREMENT, "
			+ "cells VARCHAR(100));";

	public static final String SQL_CARD = "CREATE TABLE Card (" + "id_card INT PRIMARY KEY, "
			+ "type ENUM('LUCK', 'COMMUNITY_CHEST'), " + "action_id INT, "
			+ "FOREIGN KEY (action_id) REFERENCES Action(id_action));";

	public static final String SQL_CELL = "CREATE TABLE Cell (" + "id_cell INT PRIMARY KEY, "
			+ "type ENUM('PROPERTY', 'JAIL', 'LUCK', 'COMMUNITY_CHEST'), " + "owner_id INT, " + "card_id INT, "
			+ "property_id INT, " + "FOREIGN KEY (owner_id) REFERENCES Player(id_player), "
			+ "FOREIGN KEY (card_id) REFERENCES Card(id_card), "
			+ "FOREIGN KEY (property_id) REFERENCES Property(id_property));";

	public static final String SQL_GAME = "CREATE TABLE Game (" + "id_game INT PRIMARY KEY, "
			+ "state ENUM('IN_GAME', 'FINISHED', 'PAUSED'), " + "duration VARCHAR(255));";

	public static final String SQL_PLAYER = "CREATE TABLE Player (" + "id_player INT PRIMARY KEY, " + "profile_id INT, "
			+ "cell_id INT, " + "money INT, " + "game_id INT, "
			+ "FOREIGN KEY (profile_id) REFERENCES Profile(id_profile), "
			+ "FOREIGN KEY (cell_id) REFERENCES Cell(id_cell), " + "FOREIGN KEY (game_id) REFERENCES Game(id_game));";

	public static final String SQL_PROFILE = "CREATE TABLE Profile (" + "id_profile INT PRIMARY KEY, "
			+ "nickname VARCHAR(255), " + "image VARCHAR(255));";

	public static final String SQL_PROPERTY = "CREATE TABLE Property (" + "id_property INT PRIMARY KEY, "
			+ "cell_id INT, " + "sell_value INT, " + "buy_value INT, " + "house_buy_value INT, "
			+ "hotel_buy_value INT, " + "rent_hotel_value INT, " + "rent_house_value JSON, " + "rent_base_value INT, "
			+ "FOREIGN KEY (cell_id) REFERENCES Cell(id_cell));";

}
