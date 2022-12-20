package main;

import Object.OBJ_bed1;
import Object.OBJ_bed2;
import Object.OBJ_chest;
import Object.OBJ_door;
import Object.OBJ_sword;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject(){
		
		gp.obj[0] = new OBJ_sword();
		gp.obj[0].worldX = 24 * gp.pixelSize;
		gp.obj[0].worldY = 19 * gp.pixelSize;
		
		gp.obj[1] = new OBJ_door();
		gp.obj[1].worldX = 23 * gp.pixelSize;
		gp.obj[1].worldY = 23 * gp.pixelSize;
		
		gp.obj[2] = new OBJ_bed1();
		gp.obj[2].worldX = 22 * gp.pixelSize;
		gp.obj[2].worldY = 20 * gp.pixelSize;
		
		gp.obj[3] = new OBJ_bed2();
		gp.obj[3].worldX = 22 * gp.pixelSize;
		gp.obj[3].worldY = 19 * gp.pixelSize;
		
		gp.obj[4] = new OBJ_chest();
		gp.obj[4].worldX = 23 * gp.pixelSize;
		gp.obj[4].worldY = 19 * gp.pixelSize;
	}
}
