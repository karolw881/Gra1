import java.awt.*;

public class Menu {

    public Rectangle gameButton = new Rectangle(Commons.WIDTH / 2 - 170 ,150,320,50);
    public Rectangle menuButton = new Rectangle(Commons.WIDTH / 2 - 170 ,230,280,50);
    public Rectangle quitButton = new Rectangle(Commons.WIDTH / 2 - 170 ,310,200,50);

    //public Rectangle menuBackButton= new Rectangle(0 ,0,50,50);

    public void render(Graphics g)
    {
        Graphics g2d = (Graphics2D) g;
        Font f1 = new Font("arial", Font.CENTER_BASELINE , 80);
        g.setFont(f1);
        g.setColor(Color.BLACK);
        g.drawString("Breakout",200,100);

        Font f2 = new Font("arial" , Font.HANGING_BASELINE , 40);
        g.setFont(f2);
        g.drawString("Start Game 4/10" , gameButton.x +20 , gameButton.y + 40);
        ((Graphics2D) g2d).draw(gameButton);

        Font f3 = new Font("arial" , Font.HANGING_BASELINE , 40);
        g.setFont(f3);
        g.drawString("6/10 or 10/10" , menuButton.x +20 , menuButton.y + 40);
        ((Graphics2D) g2d).draw(menuButton);


        Font f4 = new Font("arial" , Font.HANGING_BASELINE , 40);
        g.setFont(f4);
        g.drawString("Clear" , quitButton.x +20 , quitButton.y + 40);
        ((Graphics2D) g2d).draw(quitButton);
        Board.licznik = 0;


/*
        Font f5 = new Font("arial" , Font.HANGING_BASELINE,40);
        g.setFont(f5);
        g.drawString("Menu Back" , menuBackButton.x+20,menuBackButton.y+20);
        ((Graphics2D) g2d).draw(menuBackButton);

 */

    }
}
