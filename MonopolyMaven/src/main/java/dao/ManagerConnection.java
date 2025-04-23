package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import table.queries.TableQueries;

/**
 * @author Ana
 */
public class ManagerConnection {

	private static String url = "jdbc:sqlite:MonopolyCartoonNetwork.db";
	private static Connection connexio = null;

	private static int connectar() {
		try {
			connexio = DriverManager.getConnection(url);
			createTables();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static boolean isConnected() throws SQLException {
		if (connexio == null || connexio.isClosed()) {
			return false;
		} else {
			return true;
		}
	}

	public static Connection obtenirConnexio() {
		try {
			if (!isConnected()) {
				connectar();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connexio;
	}

	public static void tancarConnexio() {
		try {
			if (connexio != null && !connexio.isClosed()) {
				connexio.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Aquí irán los sql de la creación de las tablas, luego lo llamaremos en la
	// conexión y creará las tablas
	private static void createTables() {
		try (Connection conn = obtenirConnexio()) {
			java.sql.Statement smt = conn.createStatement();
			smt.execute(TableQueries.SQL_ACTION);
			smt.execute(TableQueries.SQL_BOARD);
			smt.execute(TableQueries.SQL_CARD);
			smt.execute(TableQueries.SQL_CELL);
			smt.execute(TableQueries.SQL_GAME);
			smt.execute(TableQueries.SQL_PLAYER);
			smt.execute(TableQueries.SQL_PROFILE);
			smt.execute(TableQueries.SQL_PROPERTY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
