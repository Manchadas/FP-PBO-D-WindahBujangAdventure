package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyInput;

public class Player extends Entity{
	
	GamePanel gp;
	KeyInput keyI;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, KeyInput keyI) {
		this.gp = gp;
		this.keyI = keyI;
		
		screenX = gp.screenWidth/2 - (gp.pixelSize/2);
		screenY = gp.screenHeight/2;
		
		solidArea = new Rectangle();
		solidArea.x = 16;
		solidArea.y = 35;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 16;
		solidArea.height = 12;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		worldX = gp.pixelSize * 23;
		worldY = gp.pixelSize * 21;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/windah_up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/windah_up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/windah_down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/windah_down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/windah_left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/windah_left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/windah_right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/windah_right2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyI.upPressed == true || keyI.downPressed == true || keyI.leftPressed == true || keyI.rightPressed == true) {
			if(keyI.upPressed == true) {
				direction = "up";
				
			}else if(keyI.downPressed == true) {
				direction = "down";
				
			}else if(keyI.leftPressed == true) {
				direction = "left";
				
			}else if(keyI.rightPressed == true) {
				direction = "right";
				
			}
			
			collisionOn = false;
			gp.cCheck.checkTile(this);
			
			int objIndex = gp.cCheck.checkObject(this, true);
			
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 8) {
				if(spriteNum == 1) {
					spriteNum = 2;
				} else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.pixelSize, gp.pixelSize, null);
	}
}
