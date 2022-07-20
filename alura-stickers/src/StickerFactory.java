import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerFactory {

  public void create(InputStream inputStream, String fileName) throws IOException{

    // ler imagem - com inputStream tanto faz se vem de arquivo ou de API
    //InputStream inputStream = new FileInputStream("entries/movie.jpg");
    //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
    
    BufferedImage originalImage = ImageIO.read(inputStream);

    // criar nova imagem com transparência e tamanho novo
    int width = originalImage.getWidth();
    int height = originalImage.getHeight();
    int newHeight = height + 200;

    BufferedImage newImage =  new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    // copiar a imagem original para nova imagem
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(originalImage, 0, 0, null);

    // configurar a fonte do texto
    Font font =  new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(font);

    // escrever uma frase na imagem nova
    graphics.drawString("TOP", 200, newHeight - 80);

    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File("entries/sticker.png"));


  }

}
