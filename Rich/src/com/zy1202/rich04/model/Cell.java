package com.zy1202.rich04.model;

import com.zy1202.rich04.biz.ICellBiz;
import com.zy1202.rich04.bo.ICellBO;

public class Cell implements ICellBO,ICellBiz{
	
	public static final String GIFT="GiftCell";
	public static final String HOSPITAL="HospitalCell";
	public static final String HOUSE="HouseCell";
	public static final String MAGIC="MagicCell";
	public static final String MINE="MineCell";
	public static final String PRISION="PrisonCell";
	public static final String PROP="PropCell";
	public static final String START="Cell";
	
	private String type;
	private int bombNum;
	private int roadBlockNum;
	private String name;
				
	public Cell(String type) {
		super();
		this.type = type;
		this.bombNum = 0;
		this.roadBlockNum = 0;
		this.name="起点";
	}

	@Override
	public boolean hasBomb() {
		// TODO Auto-generated method stub
		if(bombNum==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void addBomb() {
		// TODO Auto-generated method stub
		bombNum++;
	}

	@Override
	public void reduceBomb() {
		// TODO Auto-generated method stub
		bombNum--;
	}

	@Override
	public boolean hasRoadBlock() {
		// TODO Auto-generated method stub
		if(roadBlockNum==0){
		return false;
		}else{
			return true;
		}
	}

	@Override
	public void addRoadBlock() {
		// TODO Auto-generated method stub
		roadBlockNum++;
	}

	@Override
	public void reduceRoadBlock() {
		// TODO Auto-generated method stub
		roadBlockNum--;
	}

	@Override
	public void setType(String name) {
		// TODO Auto-generated method stub
		this.type=name;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public void setBombNum(int num) {
		// TODO Auto-generated method stub
		this.bombNum=num;
	}

	@Override
	public int getBombNum() {
		// TODO Auto-generated method stub
		return bombNum;
	}

	@Override
	public void setRoadBlockNum(int num) {
		// TODO Auto-generated method stub
		this.roadBlockNum=num;
	}

	@Override
	public int getRoadBlockNum() {
		// TODO Auto-generated method stub
		return roadBlockNum;
	}

	@Override
	public void moveAllBomb() {
		// TODO Auto-generated method stub
		bombNum=0;
	}

	@Override
	public void moveAllRoadBlock() {
		// TODO Auto-generated method stub
		roadBlockNum=0;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
