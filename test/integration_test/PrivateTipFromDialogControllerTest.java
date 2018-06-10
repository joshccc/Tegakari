/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_test;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import tegakari.*;
import guiConsoleController.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TTStarck
 */
public class PrivateTipFromDialogControllerTest extends TestCase {
    private Player p;
    private PrivateTipFromDialogController ctrl;
    private PrivateTipDialogConsole view;
    private ClueCard clue;
    private List<ClueCard> cards;
    private Scanner input;
    
    public PrivateTipFromDialogControllerTest(String testName) {
        super(testName);
        Hand hand = new Hand();
        
        List<Attribute> att = new ArrayList<>();
        att.add(Attribute.RED);
        Destination d = new Destination("bob", att, 
                "/image/GreeceImages/Suspects-Hera.jpg");
        ActionCard a1 = new PrivateTipCard(ClueType.DESTINATION,
                "/image/GreeceImages/Suspects-Hera.jpg");
        ActionCard a2 = new PrivateTipCard(ClueType.SUSPECT, 
                "/image/GreeceImages/Suspects-Hera.jpg");
        hand.addToHand(a1);
        hand.addToHand(a2);
        p = new HumanPlayer("hi", hand, d);
        List<Player> list = new LinkedList<Player>();
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        
        cards = new ArrayList<>();
        DestinationCard card = new DestinationCard(d);
        cards.add(card);
        cards.add(card);
        cards.add(card);
        cards.add(card);
        cards.add(card);
        cards.add(card);
        
        clue = (ClueCard) card;
        
        PrivateTipCard tip = new PrivateTipCard(ClueType.DESTINATION, 
                "/image/GreeceImages/Suspects-Hera.jpg");
        
        input = new Scanner("1\n");
        ctrl = new PrivateTipFromDialogController();
        view = new PrivateTipDialogConsole(ctrl, cards, tip, p, input);
        ctrl.setup(true, view, cards, tip);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public void testKeys()
    {
        JButton btn = new JButton("");
        final KeyEvent ok = new KeyEvent(btn,0,0,KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE,'s');
        final KeyEvent one = new KeyEvent(btn,0,0,KeyEvent.VK_1,
                KeyEvent.VK_1,'1');
        final KeyEvent two = new KeyEvent(btn,0,0,KeyEvent.VK_2,
                KeyEvent.VK_2,'2');
        final KeyEvent three = new KeyEvent(btn,0,0,KeyEvent.VK_3,
                KeyEvent.VK_3,'3');
        final KeyEvent four = new KeyEvent(btn,0,0,KeyEvent.VK_4,
                KeyEvent.VK_4,'4');
        final KeyEvent five = new KeyEvent(btn,0,0,KeyEvent.VK_5,
                KeyEvent.VK_5,'5');
        final KeyEvent nothing = new KeyEvent(btn,0,0,KeyEvent.VK_6,
                KeyEvent.VK_6,'6');
        
        ctrl.keyReleased(one);
        ctrl.keyTyped(one);
        
        ctrl.keyPressed(one);
        assertEquals(ctrl.showDialog(), clue);
        
        PrivateTipCard tip = new PrivateTipCard(ClueType.DESTINATION, 
                Attribute.RED,
                "/image/GreeceImages/Suspects-Hera.jpg");
        view = new PrivateTipDialogConsole(ctrl, cards, tip, p, input);
        ctrl.setup(true, view, cards, tip);
        
        ctrl.keyPressed(two);
        assertEquals(ctrl.showDialog(), clue);
        ctrl.keyPressed(three);
        assertEquals(ctrl.showDialog(), clue);
        ctrl.keyPressed(four);
        assertEquals(ctrl.showDialog(), clue);
        ctrl.keyPressed(five);
        assertEquals(ctrl.showDialog(), clue);
        ctrl.keyPressed(nothing);
        ctrl.keyPressed(ok);
    }
}
