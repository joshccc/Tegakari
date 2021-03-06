

package integration_test;

import allguis.*;
import guiConsoleController.*;
import java.awt.event.KeyEvent;
import junit.framework.TestCase;
import javax.swing.*;
import static org.mockito.Mockito.*;
import org.uispec4j.*;
import org.uispec4j.interception.BasicHandler;
import org.uispec4j.interception.WindowInterceptor;
import tegakari.Lobby;

/**
 *
 * @author Chris Thibodeau - cathibod
 */
public class MainWindowControllerTest extends UISpecTestCase 
{
    
    MainWindowController ctrl = new MainWindowController();
    MainWindow view = new MainWindow(ctrl);
    
    public MainWindowControllerTest(String testName) {
        super(testName);
    }

    /**
     * Test of keyTyped method and keyReleased, of class MainWindowController.
     */
    public void testKeyTypedAndReleased() {
        System.out.println("keyTypedandReleased");
        
        ctrl.keyTyped(null);
        ctrl.keyReleased(null);
    }

    
    static
    {
        UISpec4J.init();
    }
    
    /**
     * Test of keyPressed, actionPerformed, and showDialog
     * methods, of class MainWindowController.
     */
    public void testJoin() 
    {
        System.out.println("controller");
        
        Lobby lobby = mock(Lobby.class);
        
        ctrl.setup(view, lobby, false);
        JButton btn = new JButton("");
        final KeyEvent j = new KeyEvent(btn,0,0,KeyEvent.VK_J,
                KeyEvent.VK_J,'j');
        final KeyEvent h = new KeyEvent(btn,0,0,KeyEvent.VK_H,
                KeyEvent.VK_H,'h');
        
        when(lobby.joinLobby()).thenReturn(true);
        
        
        System.out.println("starting tests");
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        System.out.println("start");
                        ctrl.keyPressed(j);
                        System.out.println("end");
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("3 players needed to start").
                triggerButtonClick("test")).run();
        
        System.out.println("finished JOIN");
        
        
    }
    
    public void testHelp()
    {
        Lobby lobby = mock(Lobby.class);
        
        ctrl.setup(view, lobby, false);
        JButton btn = new JButton("");
        final KeyEvent j = new KeyEvent(btn,0,0,KeyEvent.VK_J,
                KeyEvent.VK_J,'j');
        final KeyEvent h = new KeyEvent(btn,0,0,KeyEvent.VK_H,
                KeyEvent.VK_H,'h');
        
        when(lobby.joinLobby()).thenReturn(true);
        
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        System.out.println("start");
                        ctrl.keyPressed(h);
                        System.out.println("end");
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("About").
                triggerButtonClick("Quit Help")).run();
        
        System.out.println("finished HELP");
    }
}
