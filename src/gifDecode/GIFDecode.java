package gifDecode;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import com.icafe4j.image.ImageIO;
import com.icafe4j.image.ImageType;



public class GIFDecode {

	public static byte[] getFirstFrameOfGif(String imageUrl) throws Exception{
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		BufferedImage image = ImageIO.getReader(ImageType.GIF).read(is); 
		javax.imageio.ImageIO.write(image, "bmp", os);
		os.flush();
		
		is.close();
		os.close();
		return os.toByteArray();
	}
}
