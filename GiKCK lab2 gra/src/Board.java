
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel {

    public static Timer timer;
    public static String message = "Game Over";
    private Ball ball;
    private Paddle paddle;
    private Brick[] bricks;
    public static boolean inGame = true;
    public Rectangle menuBackButton= new Rectangle(0 ,0,50,50);
    public static int help = 0 ;
    public static int ile_break = Commons.N_OF_BRICKS;
    public boolean temp = true;
    static public int licznik = 0;


    public Board() {

        initBoard();
        //System.out.println(ball.imageHeight + " " +ball.imageWidth);
    }


    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
        gameInit();

    }

    private void gameInit() {

        bricks = new Brick[ile_break];
        ball = new Ball();
        paddle = new Paddle();

        int k = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                bricks[k] = new Brick(j * 40 + 200, i * 10 + 50);
                k++;
            }
        }

        timer = new Timer( Commons.PERIOD , new GameCycle());
        timer.start();
    }



    public  enum STATE
    {
        GAME , MENU , Clear, My_Menu ;
    }



    public static STATE State = STATE.MENU;


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        drawObjects(g2d);


        if (inGame ) {

            drawObjects(g2d);
        } else {

            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();


    }



    public void drawObjects(Graphics2D g2d) {

        this.addMouseListener(new MouseInput() {});

        if(State == STATE.GAME){

            rysuj_licznik(g2d);
            draw_menu_back(g2d);

            g2d.drawImage(ball.getImage(), ball.getX() , ball.getY(),
                    ball.getImageWidth(), ball.getImageHeight(), this);
            g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                    paddle.getImageWidth(), paddle.getImageHeight(), this);

            for (int i = 0; i < ile_break; i++) {

                if (!bricks[i].isDestroyed()) {
                    g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                            bricks[i].getY(), bricks[i].getImageWidth(),
                            bricks[i].getImageHeight(), this);
                }
            }
        }


        if (State == STATE.MENU) {

            Menu menu = new Menu();
            menu.render(g2d);
            ball.resetState();


        }

        if(State == State.My_Menu)
        {
            My_menu my_menu = new My_menu();
            draw_menu_back(g2d);
            my_menu.render(g2d);



        }


    }



    public void rysuj_licznik(Graphics gg)
    {
        Font f1 = new Font("arial", Font.CENTER_BASELINE , 80);
        gg.setFont(f1);
        gg.setColor(Color.BLACK);
        gg.drawString(String.valueOf(licznik),0,400);
    }




    public void draw_menu_back(Graphics2D g)
    {

        Font f5 = new Font("arial" , Font.HANGING_BASELINE,20);
        g.setFont(f5);
        g.drawString("Menu" , menuBackButton.x,menuBackButton.y+30);
        g.draw(menuBackButton);




    }


    private void gameFinished(Graphics2D g2d) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(message,
                (Commons.WIDTH - fontMetrics.stringWidth(message)) / 2,
                Commons.WIDTH / 2);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            paddle.keyPressed(e);
        }
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {



                doGameCycle();

        }
    }

    private void doGameCycle() {

            ball.move();
            paddle.move();
            checkCollision();
            repaint();

    }






    private void stopGame() {

        inGame = false;
        timer.stop();

        
    }



    private void checkCollision() {

        if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {

            stopGame();
        }

        for (int i = 0, j = 0; i < ile_break; i++) {

            if (bricks[i].isDestroyed()) {

                j++;
            }

            if (j == ile_break) {

                message = "Victory";
                stopGame();
            }
        }

        if ((ball.getRect()).intersects(paddle.getRect())) {

            int paddleLPos = (int) paddle.getRect().getMinX();
            int ballLPos = (int) ball.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;


            if (ballLPos < first) {

                ball.setXDir(-1);
                ball.setYDir(-1);
            }

            if (ballLPos >= first && ballLPos < second) {

                ball.setXDir(-1);
                ball.setYDir(-1 * ball.getYDir());
            }

            if (ballLPos >= second && ballLPos < third) {

                ball.setXDir(0);
                ball.setYDir(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {

                ball.setXDir(1);
                ball.setYDir(-1 * ball.getYDir());
            }

            if (ballLPos > fourth) {

                ball.setXDir(1);
                ball.setYDir(-1);
            }
        }




        for (int i = 0; i < ile_break; i++) {

            if ((ball.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int) ball.getRect().getMinX();
                int ballHeight = (int) ball.getRect().getHeight();
                int ballWidth = (int) ball.getRect().getWidth();
                int ballTop = (int) ball.getRect().getMinY();

                var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                var pointLeft = new Point(ballLeft - 1, ballTop);
                var pointTop = new Point(ballLeft, ballTop - 1);
                var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].isDestroyed()) {

                    if (bricks[i].getRect().contains(pointRight)) {

                        ball.setXDir(-1);
                    } else if (bricks[i].getRect().contains(pointLeft)) {

                        ball.setXDir(1);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {

                        ball.setYDir(1);
                    } else if (bricks[i].getRect().contains(pointBottom)) {

                        ball.setYDir(-1);
                    }

                    bricks[i].setDestroyed(true);
                    licznik +=1;
                }
            }
        }
    }


}