package models;

import java.util.List;

/**
 * @author Ana
 */
public class Game {

	public enum State {
		IN_GAME, FINISHED, PAUSED
	}

	public int idGame;
	public State state;
	public String duration;
	public List<String> turnHistory;

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public List<String> getTurnHistory() {
		return turnHistory;
	}

	public void setTurnHistory(List<String> turnHistory) {
		this.turnHistory = turnHistory;
	}

	public boolean isGameOver() {
		// Implementar lógica para finalizar el juego.
		return true;
	}
}
