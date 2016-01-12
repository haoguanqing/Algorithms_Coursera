package gifDecode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import com.icafe4j.image.ImageIO;
import com.icafe4j.image.ImageType;
import com.icafe4j.image.gif.FrameReader;
import com.icafe4j.image.gif.GIFFrame;



public class GIFDecode {

/*	public static byte[] getFirstFrameOfGif(String imageUrl) throws Exception{
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		BufferedImage image = ImageIO.getReader(ImageType.GIF).read(is); 
		javax.imageio.ImageIO.write(image, "bmp", os);
		os.flush();
		
		is.close();
		os.close();
		return os.toByteArray();
	}*/
	
    public static byte[] getFirstFrameOfGif2(String imageUrl) throws Exception{
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();

        FrameReader frameReader = new FrameReader();
        GIFFrame frame = frameReader.getGIFFrame(is);
        BufferedImage thumbnail = frame.getFrame();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        javax.imageio.ImageIO.write(thumbnail, "bmp", os);

        os.flush();
        is.close();
        byte[] data = os.toByteArray();
        os.close();

        return data;
    }
}
