/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import allguis.LobbyGUI;
import allguis.MainWindow;
import allguis.ScreenNameDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tegakari.*;
/**
 * The controller for the MainWindow
 * @author jchoi30
 */
public class MainWindowController implements ActionListener, KeyListener
{
    private Lobby lobby;
    private Object view;
    private boolean isConsole;
    private ActionEvent join;
    private ActionEvent help;

    /**
     * Sets up the controller
     * @param aView the view - GUI or Console
     * @param aLobby the game lobby
     * @param aConsole if it is a console
     */
    public void setup(Object aView, Lobby aLobby, boolean aConsole)
    {
        this.view = aView;
        this.lobby = aLobby;
        this.isConsole = aConsole;
        this.join = new ActionEvent(this, 0, "JOIN LOBBY");
        this.help = new ActionEvent(this, 0, "HELP");
    }
    
    /**
     * Action Performed
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        // if JOIN LOBBY
        if (cmd.equals("JOIN LOBBY"))
        {
            // if able to join lobby
            if (lobby.joinLobby())
            {
                // if not a console
                if (!isConsole)
                {
                    //System.out.println("1");
                    LobbyController lobbyCtrl = new LobbyController();
                    ScreenNameController screenControl = new ScreenNameController();
                    LobbyGUI lobbyGui = new LobbyGUI(lobby, lobbyCtrl);
                    lobby.addObserver(lobbyGui);
                    lobbyCtrl.setup(lobbyGui, lobby, false, lobbyGui);
                    lobbyGui.setVisible(true);
                    
                    MainWindow main = (MainWindow)view;
                    main.setVisible(false);
                    //((MainWindow)view).setVisible(false);

                   
                    
                    
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch(Exception exception)
                    {
                        System.out.println("sleep fail");
                    }
                   // System.out.println("breaks start here");
                    ScreenNameDialog screenName = new ScreenNameDialog(
                            lobbyGui, screenControl, true);
                   // System.out.println("setup");
                    screenControl.setup(screenName, lobby, false, lobbyGui);
                   // System.out.println("unlikely");
                    screenName.setLocationRelativeTo(lobbyGui);
                   // System.out.println("probable");
                    screenName.setVisible(true);
                  //  System.out.println("got past");
                }
            }
            // fail to join lobby
            else
            {
                ((MainWindow)view).failToJoin();
            }
                
        }
        // if HELP
        if (cmd.equals("HELP"))
        {
            ((MainWindow)view).openHelp();
        }
        

    }

    /**
     * key typed
     * @param e the key
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }

    /**
     * key pressed
     * @param e the key
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        // if J
        if(e.getKeyCode() == KeyEvent.VK_J)
        {
            this.actionPerformed(join);
        }
        // if H
        if(e.getKeyCode() == KeyEvent.VK_H)
        {
            this.actionPerformed(help);
        }
    }

    /**
     * key released
     * @param e the key
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
