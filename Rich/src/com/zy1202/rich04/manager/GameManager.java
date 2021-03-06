package com.zy1202.rich04.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zy1202.rich04.bo.IPlayerBO;
import com.zy1202.rich04.model.Cell;
import com.zy1202.rich04.model.House;
import com.zy1202.rich04.model.HouseCell;
import com.zy1202.rich04.model.Player;
import com.zy1202.rich04.view.CellView;

public class GameManager {
	private List<Player> players;
	private int currentPlayer;
	private List<CellView> map;
	private static GameManager ourInstance;
	
	
	public GameManager() {
		super();
		players=new ArrayList<Player>();
		currentPlayer=0;
	}
	
	public static GameManager getInstance(){
		if(ourInstance==null){
				ourInstance=new GameManager();
		}
		return ourInstance;
	}
	
	

	
	private Player _getCurrentPlayer() {
		return players.get(currentPlayer);
	}
	private void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	private void _addPlayer(Player player){
		players.add(player);
	}
	
	private void _setCash(int cash){
		for(IPlayerBO playerBO:players){
			playerBO.getMoney().setCash(cash);
		}
	}
	
	private void _deletePlayer(Player player){
		players.remove(player);
		Iterator it=this.getMap().iterator();
		while(it.hasNext()){
			CellView cellview=(CellView)it.next();
			
			if(Cell.HOUSE.equals(cellview.getCell().getType())){
				HouseCell houseCell = (HouseCell)cellview.getCell();
				houseCell.setOwner(null);
				int price = houseCell.getHouse().getUpPrice();
				houseCell.setHouse(new House(price));
			}
		}
	}
	
	private List<Player> _getPlayers(){
		return players;
	}
	
	private void _toNextPlayer(){
		if(currentPlayer>=players.size()-1){
			currentPlayer=0;
		}else{
			currentPlayer++;
		}
		
		while(players.get(currentPlayer).isStop()==true){
			players.get(currentPlayer).reduceStopDay(1);
			if(currentPlayer==players.size()-1){
				currentPlayer=0;
			}else{
				currentPlayer++;
			}
		}
		
	}
	
	private void _initMap(List<CellView> cellViews){
		this.map=cellViews;
	}
	
	private List<CellView> _getMap(){
		return map;
	}
	
	private String _getHelp(){
		return null;
	}
	
	
	/**
	 * 公布方法
	 */
	public static Player getCurrentPlayer(){
		return getInstance()._getCurrentPlayer();
	}
	
	public static void addPlayer(Player player){
		getInstance()._addPlayer(player);
	}
	
	public static void setCash(int cash){
		getInstance()._setCash(cash);
	}
	public static void deletePlayer(Player player){
		getInstance()._deletePlayer(player);
	}
	
	public static List<Player> getPlayers(){
		return getInstance()._getPlayers();
	}
	
	public static void toNextPlayer(){
		getInstance()._toNextPlayer();
	}
	
	public static void initMap(List<CellView> cellViews){
		getInstance()._initMap(cellViews);
	}
	
	public static String getHelp(){
		return getInstance()._getHelp();
	}
	
	public static List<CellView> getMap(){
		return getInstance()._getMap();
	}
	
	
}
