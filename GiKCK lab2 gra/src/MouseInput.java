import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    public void mousePressed(MouseEvent e)
    {
        int mysz_x = e.getX();
        int mysz_y = e.getY();

        if(mysz_x >= Commons.WIDTH / 2 - 170 &&  mysz_x <= Commons.WIDTH / 2 + 20  && Board.help == 1  )
        {
            if ( mysz_y >= 150 && mysz_y <= 200  )
            {
                Board.State = Board.STATE.GAME;
            }


        }

        if(mysz_x >= Commons.WIDTH / 2 - 170 &&  mysz_x <= Commons.WIDTH / 2 + 200  && Board.help != 1  )
        {
            if ( mysz_y >= 150 && mysz_y <= 200  ){
                Board.ile_break = 40;
                Board.State = Board.STATE.GAME;

            }


        }

        if(mysz_x >= Commons.WIDTH / 2 - 170 &&  mysz_x <= Commons.WIDTH / 2  + 20  )
        {
            if ( mysz_y >= 230 && mysz_y <= 280     )
            {

                Board.State = Board.STATE.My_Menu;
                Board.help = 1;



            }

        }
        if(mysz_x >= Commons.WIDTH / 2 - 170 &&  mysz_x <= Commons.WIDTH / 2  + 20   && Board.help == 1    )
        {
            if ( mysz_y >= 230 && mysz_y <= 280     )
            {

                Board.ile_break = 60;



            }

        }



        if(mysz_x >= Commons.WIDTH / 2 - 170 &&  mysz_x <= Commons.WIDTH / 2 +20  && Board.help ==1)
        {
            if ( mysz_y >= 310 && mysz_y <= 360   )
            {
                Board.ile_break=100;
                Board.State = Board.STATE.GAME;



            }

        }
        if(mysz_x >= Commons.WIDTH / 2 - 170 &&  mysz_x <= Commons.WIDTH / 2 +20  && Board.help !=1)
        {
            if ( mysz_y >= 310 && mysz_y <= 360   )
            {
                Board.State = Board.STATE.Clear;


            }

        }

        if(mysz_x >= Commons.WIDTH / 2 - 170 &&  mysz_x <= Commons.WIDTH / 2 +20  && Board.help !=1)
        {
            if ( mysz_y >= 310 && mysz_y <= 390   )
            {
                Board.State = Board.STATE.Clear;


            }

        }


        if(mysz_x >= 0 &&  mysz_x <= 80   )
        {
            if ( mysz_y >= 0 && mysz_y <= 80   )
            {
                Board.State = Board.STATE.MENU;
                Board.inGame =  true;




            }
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

