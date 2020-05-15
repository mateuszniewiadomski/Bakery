package bakery.img;

import javax.swing.*;

/*

    Images and photos from pexels.com

 */

public class img {

    public ImageIcon getImage(String s) {
        return new ImageIcon(this.getClass().getResource(s));
    }
}
