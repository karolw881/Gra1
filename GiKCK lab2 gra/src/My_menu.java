import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class My_menu  {

    public Rectangle x = new Rectangle(Commons.WIDTH / 2 - 170 ,150,200,50);
    public Rectangle y = new Rectangle(Commons.WIDTH / 2 - 170 ,230,200,50);
    public Rectangle z = new Rectangle(Commons.WIDTH / 2 - 170 ,310,200,50);


    public void render(Graphics2D gg) {
        Graphics g2d = (Graphics2D) gg;

        Font f1 = new Font("arial", Font.CENTER_BASELINE , 80);
        gg.setFont(f1);
        gg.setColor(Color.BLACK);
        gg.drawString("Breakout",200,100);


        Font f2 = new Font("arial" , Font.HANGING_BASELINE , 40);
        gg.setFont(f2);
        gg.drawString("10 x 6 " , x.x +20 , x.y + 40);
        ((Graphics2D) g2d).draw(x);






        Font f3 = new Font("arial" , Font.HANGING_BASELINE , 40);
        gg.setFont(f3);
        gg.drawString("10 x 10 " , z.x +20 , z.y + 40);
        ((Graphics2D) g2d).draw(z);






    }

    public void RadioButtonExample(Graphics2D g){






        //g.draw(bg);
    }


}
