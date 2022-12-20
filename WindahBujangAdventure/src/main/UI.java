package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font pixel;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	public int commandNum = 0;
	
	public UI(GamePanel gp) {
		
		this.gp = gp;
		
		try {
			InputStream is = getClass().getResourceAsStream("/font/staypixel.ttf");
			pixel = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(pixel);
		g2.setColor(Color.WHITE);
		
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		if(gp.gameState == gp.playState) {
			
		}
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
	}
	
	public void drawTitleScreen() {
		
		g2.setColor(new Color(0,102,204));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,50F));
		String text = "Windah : Bujang Adventure";
		int x = getXforCenteredText(text);
		int y = gp.pixelSize*3;
		
		g2.setColor(Color.BLACK);
		g2.drawString(text, x+6, y+6);
		
		g2.setColor(Color.WHITE);
		g2.drawString(text,x,y);
		
		x = gp.screenWidth/2 - (gp.pixelSize*2)/2;
		y += gp.pixelSize*2;
		g2.drawImage(gp.player.down2, x, y, gp.pixelSize*2, gp.pixelSize*2, null);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,30F));
		
		text = "PLAY GAME";
		x = getXforCenteredText(text);
		y += gp.pixelSize*4;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-gp.pixelSize, y);
		}
		
		text = "CONTINUE";
		x = getXforCenteredText(text);
		y += gp.pixelSize;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-gp.pixelSize, y);
		}
		
		text = "EXIT";
		x = getXforCenteredText(text);
		y += gp.pixelSize;
		g2.drawString(text, x, y);
		if(commandNum == 2) {
			g2.drawString(">", x-gp.pixelSize, y);
		}
		
	}
	
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}
	
	public int getXforCenteredText(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
}
