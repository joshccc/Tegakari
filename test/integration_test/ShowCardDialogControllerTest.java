package integration_test;

import junit.framework.TestCase;
import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;

/**
 *
 * @author DeionLaw
 */
public class ShowCardDialogControllerTest extends UISpecTestCase
{

    private ShowCardDialogController ctrl;
    private ShowCardDialog view;
    private JFrame parent;
    private List<CardMessage> receivedCards;
    private CardMessage message;
    private SuspectCard card;
    private Player from;
    private Player to;

    public ShowCardDialogControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        from = new HumanPlayer("from");
        to = new HumanPlayer("to");

        Theme theme = new Theme();
        card = new SuspectCard(theme.getSuspects().get(0));
        receivedCards = new ArrayList<CardMessage>();
        List<Card> list = new ArrayList<Card>();
        list.add(card);
        message = new CardMessage(to, from, list);
        receivedCards.add(message);


        parent = new JFrame();
        ctrl = new ShowCardDialogController();
        view = new ShowCardDialog(ctrl, parent, true, receivedCards);
        ctrl.setUp(view, true, receivedCards);
    }
    
    
    public void testKeyPress()
    {
        Window window = new Window(view);
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        window.typeKey(Key.SPACE);
        assertFalse(window.isVisible());
    }
}
