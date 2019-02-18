
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameUtil {
    //工具类将构造器私有化
    private GameUtil() {}

    //返回指定路径的图片对象
    public static Image getImage(String path) {
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}
