

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Keyboard  implements NativeKeyListener {

    public static void initKeyboard(){

         try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new Keyboard());

    }



    public void nativeKeyReleased(NativeKeyEvent e) {

        switch (LegendOfWar.getGame().getState()) {
            case MENU:

                if (e.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                    LegendOfWar.getGame().setState(GameState.CLASSE);
                }
                break;

            case PLAYING:
                if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
                    try {
                        LegendOfWar.getGame().leaveGame();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                if (e.getKeyCode() == 57416 || e.getKeyCode() == 57424) { // arrow up
                    UI.attack = !UI.attack;
                }
                if (e.getKeyCode() == 12) { // [°]
                    LegendOfWar.getGame().cheatAttackPlayer();
                }
                if (e.getKeyCode() == 13) { // [+]
                    LegendOfWar.getGame().cheatCapacityPlayer();
                }
                if (e.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                    if (UI.attack){
                        try {
                            LegendOfWar.getGame().attackPlayer();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else{
                        try {
                            LegendOfWar.getGame().capacityPlayer();
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
                break;
            case CLASSE:

                Joueur joueur = LegendOfWar.getGame().getJoueur();

                if (e.getKeyCode() == NativeKeyEvent.VC_RIGHT) {

                    if (joueur.getCategorie().ordinal() < 2) {
                        joueur.setCategorie(Classe.values()[joueur.getCategorie().ordinal() + 1]);
                    }
                }

                if (e.getKeyCode() == NativeKeyEvent.VC_LEFT) {

                    if (joueur.getCategorie().ordinal() > 0) {
                        joueur.setCategorie(Classe.values()[joueur.getCategorie().ordinal() - 1]);
                    }
                }

                if (e.getKeyCode() == NativeKeyEvent.VC_SPACE) {
                    LegendOfWar.getGame().startGame();
                }

                break;

        }

        UI.update();

    }
    
}
