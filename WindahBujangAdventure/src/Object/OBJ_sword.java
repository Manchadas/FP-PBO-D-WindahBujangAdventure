package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_sword extends SuperObject{
	
	public OBJ_sword() {
		
		name = "sword";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/sword.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
