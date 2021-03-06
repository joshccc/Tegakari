/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_test;

import java.util.*;
import junit.framework.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import tegakari.*;

/**
 *
 * @author Tarrant
 */
public class RobotEngineInActiveTest extends TestCase
{
    
    private List<SuspectCard> suspects = new ArrayList<SuspectCard>();
    private List<VehicleCard> vehicles = new ArrayList<VehicleCard>();
    private List<DestinationCard> destinations = new ArrayList<DestinationCard>();
        
    Robot bot;
    AILevel level = AILevel.BASIC;
    Hand hand;
    Destination dm;
    DestinationCard card;
    
    List<Attribute> list1;
    List<Attribute> list2;
    
    RobotEngineInActive robot;
    
    RobotEngine engine;
    RobotEngineInIdle engineIdle;
    
    RobotState state;
    
    Player self;
    Player turn;
    Queue<Player> players;
    
    ActionCard action1;
    ActionCard action2;
    ActionCard action3;
    ActionCard action4;
    
    Notepad note;
    Solution solution;
    
    
    public RobotEngineInActiveTest() 
    {
        SetUp();
        System.out.println("--------Set up test");
        action1 = new SnoopCard("snoop");
        action2 = new SuperSleuthCard(ClueType.DESTINATION, 
                Attribute.NORTHERN, "hi");
        action3 = new PrivateTipCard(ClueType.SUSPECT, "tip");
        action4 = new SuggestionCard(true, "suggest");
        
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list1.add(Attribute.EASTERN);
        list2.add(Attribute.NORTHERN);
        
        
        dm = new Destination("dm", list1, "path");
        card = new DestinationCard(dm);
        hand = new Hand();
        hand.addToHand(card);
        hand.addToHand(action2);
        hand.addToHand(action3);
        hand.addToHand(action4);
        hand.addToHand(action1);
        hand.addToHand(action1);
        hand.addToHand(action4);
        hand.addToHand(action4);
        bot = new Robot("robot1_basic", hand, dm, AILevel.SMART);
        engine = new RobotEngine(bot, level);
        
        //robot.setEngine(engine);
        
        self = new HumanPlayer("playerself", hand, dm);
        turn = new HumanPlayer("playerturn", hand, dm);
        players = new LinkedList<Player>();
        players.add(self);
        players.add(turn);
        players.add(bot);
        
        solution = new Solution(suspects.get(0).getSuspect(), 
                vehicles.get(0).getVehicle(), 
                destinations.get(0).getDestination());
        //note = new Notepad(players, suspects, vehicles, destinations, solution);
        engineIdle = new RobotEngineInIdle();
        
        Theme theme = new Theme();
        
        List<SuspectCard> sCards = new ArrayList<SuspectCard>();
        List<Suspect> suspects = theme.getSuspects();
        for (Suspect sus: suspects)
        {
            sCards.add(new SuspectCard(sus));
            bot.getHand().addToHand(new SuspectCard(sus));
        }
        
        List<VehicleCard> vCards = new ArrayList<VehicleCard>();
        List<Vehicle> vehicles = theme.getVehicles();
        for (Vehicle veh: vehicles)
        {
            vCards.add(new VehicleCard(veh));
            turn.getHand().addToHand(new VehicleCard(veh));
        }
        
        List<DestinationCard> dCards = new ArrayList<DestinationCard>();
        List<Destination> destinations = theme.getDestinations();
        for (Destination des: destinations)
        {
            dCards.add(new DestinationCard(des));
            self.getHand().addToHand(new DestinationCard(des));
        }
        
        System.out.println("players size: " + players.size() + " " + players.peek().getName());
        engine = new RobotEngine(players, bot, AILevel.BASIC);
        robot = engine.getEngineActive();
        state = engine.getState();
        
        note = new Notepad(this.players, sCards, vCards, dCards, solution);
        System.out.println(note);
        System.out.println("ref state: " + state);
        state.setNote(note);
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /*
    public void testSetup() 
    {
        robot = new RobotEngineInActive(engine, state);
        
       // assertNull(robot.getState());
        //assertNull(robot.getEngine());
        assertNull(robot.getEngineIdle());
        
        
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list1.add(Attribute.EASTERN);
        list2.add(Attribute.NORTHERN);
        
        
        dm = new Destination("dm", list1, "path");
        card = new DestinationCard(dm);
        hand = new Hand();
        hand.addToHand(card);
        bot = new Robot("bot", hand, dm);
        engine = new RobotEngine(bot, level);
        
        robot.setEngine(engine);
        assertFalse(robot.getEngine() == null);
        
        self = new HumanPlayer("self", hand, dm);
        turn = new HumanPlayer("turn", hand, dm);
        players = new LinkedList<Player>();
        
        state = new RobotState(players, self, turn);
        
        robot.setState(state);
        assertFalse(robot.getState() == null);
        
        engineIdle = new RobotEngineInIdle();
        robot.setEngineInIdle(engineIdle);
        assertFalse(robot.getEngineIdle() == null);
    }*/
    
    private void SetUp() 
    {
        Theme theme = new Theme();
        suspects = new ArrayList<SuspectCard>();
        vehicles = new ArrayList<VehicleCard>();
        destinations = new ArrayList<DestinationCard>();
        
        
        for (Suspect suspect : theme.getSuspects())
        {
            suspects.add(new SuspectCard(suspect));
        }
        
        for (Vehicle vehicle : theme.getVehicles())
        {
            vehicles.add(new VehicleCard(vehicle));
        }
        
        for (Destination destination : theme.getDestinations())
        {
            destinations.add(new DestinationCard(destination));
        }
        
        System.out.println("--------Done Set up\n");
    }
    
    public void testPerform() 
    {
        List<Object> toSend = null;
        System.out.println("--------test perform SuperSleuth");
        robot.getState().setLog(new HistoryLog());
        HistoryLog log = robot.getState().getLog();
        assertTrue(log.isEmptyLog());
        
        // sleuth
        toSend = robot.beginTurn();
        
        assertEquals(3, toSend.size());
        assertTrue(toSend.get(0) instanceof HistoryLog);
        assertTrue(toSend.get(1) instanceof CardMessage);
        assertTrue(toSend.get(2) instanceof CardMessage);
        
        
        System.out.println("--------test perform PrivateTip - Show All");
        toSend = robot.beginTurn();
        assertEquals(3, toSend.size());
        assertTrue(toSend.get(0) instanceof HistoryLog);
        assertTrue(toSend.get(1) instanceof CardMessage);
        assertTrue(toSend.get(2) instanceof Protocol);
        log = (HistoryLog)(toSend.get(0));
        
        System.out.println("--------test perform Suggestion");
        // suggestion
        toSend = robot.beginTurn();
        assertEquals(2, toSend.size());
        assertTrue(toSend.get(1) instanceof SuggestionCardLogic);
        assertTrue(toSend.get(0) instanceof HistoryLog);
        
        
        // snoop
        System.out.println("--------test perform Snoop");
        toSend = robot.beginTurn();
        assertEquals(3, toSend.size());
        assertTrue(toSend.get(0) instanceof HistoryLog);
        assertTrue(toSend.get(1) instanceof CardMessage);
        assertTrue(toSend.get(2) instanceof Protocol);
    }
    
    public void testGettersSetters()
    {
        System.out.println("--------test Getters & Setters");
        robot.setEngineInIdle(engineIdle);
        assertEquals(engineIdle, robot.getEngineIdle());
        
        robot.setEngine(engine);
        assertEquals(engine, robot.getEngine());
        
        robot.setExpectedCard(1);
        robot.setReceivedCard(1);
        assertEquals(1, robot.getExpectedCard());
        assertEquals(1, robot.getReceivedCard());
        
        RobotActionLogic actionLogic = new RobotPrivateTipLogic(AILevel.BASIC,
                new ArrayList<Player>(players));
        robot.setRobotLogic(actionLogic);
        assertEquals(actionLogic, robot.getRobotLogic());
        
        RobotSuggestionLogic suggestLogic = new RobotSuggestionLogic(note, players.peek());
        robot.setRobotSLogic(suggestLogic);
        assertEquals(suggestLogic, robot.getRobotSLogic());
        
        robot.setState(state);
        assertEquals(state, robot.getState());
    }
    
    public void testChooseCardToPlay()
    {
        System.out.println("--------test choose Card in Smart Robot Mode");
        List<ActionCard> cardToPlay = new ArrayList<ActionCard>();
        cardToPlay.add(action4);
        cardToPlay.add(action2);
        assertEquals(action2, robot.chooseCardToPlay(cardToPlay, AILevel.SMART));
        
    }
    
    public void testFoundSolution()
    {
        System.out.println("--------test Found Solution");
        assertFalse(note.hasSolution());
        
        List<SuspectCard> sList = note.getSuspects();
        for (int idx = 1; idx < sList.size(); idx++)
        {
            note.mark(sList.get(idx), self , NoteEntry.HAS);
        }
        List<VehicleCard> vList = note.getVehicles();
        for (int idx = 1; idx < vList.size(); idx++)
        {
            note.mark(vList.get(idx), turn , NoteEntry.HAS);
        }
        List<DestinationCard> dList = note.getDestinations();
        for (int idx = 1; idx < dList.size(); idx++)
        {
            note.mark(dList.get(idx), bot , NoteEntry.HAS);
        }
        assertTrue(note.hasSolution());
        
        List<Object> out = robot.beginTurn();
        assertEquals(4, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof CardMessage);
        assertTrue(out.get(2) instanceof CardMessage);
        assertTrue(out.get(3) instanceof AccusationMessage);
        
    }
    
    public void testClueCard1() 
    {
        System.out.println("--------test ShowCard - other showing me");
        Theme theme = new Theme();
        ClueCard clue1 = self.getClueCards().get(0);
        ClueCard clue2 = turn.getClueCards().get(0);
        ClueCard clue3 = bot.getClueCards().get(0);
        players = new ArrayDeque<Player>();
        
        state.setPlayers(players);
        players.add(bot);
        players.add(self);
        players.add(turn);
        
        //Set Solution
        assertFalse(note.hasSolution());
        List<SuspectCard> sList = note.getSuspects();
        for (int idx = 1; idx < sList.size(); idx++)
        {
            note.mark(sList.get(idx), self , NoteEntry.HAS);
        }
        List<VehicleCard> vList = note.getVehicles();
        for (int idx = 1; idx < vList.size(); idx++)
        {
            note.mark(vList.get(idx), turn , NoteEntry.HAS);
        }
        List<DestinationCard> dList = note.getDestinations();
        for (int idx = 1; idx < dList.size(); idx++)
        {
            note.mark(dList.get(idx), bot , NoteEntry.HAS);
        }
        assertTrue(note.hasSolution());
        
        CardMessage mess = new CardMessage(bot, bot, clue2);
        List<Object> out = robot.handleClueCard(mess);
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof AccusationMessage);
        assertTrue(out.get(1) instanceof Protocol);
    }
    
    public void testPerformSuggestion()
    {
        System.out.println("--------test Suggestion - disprovable");
        hand = new Hand();
        action4 = new SuggestionCard(true, "suggest");
        hand.addToHand(action4);
        hand.addToHand(action4);
        bot = new Robot("robot1_basic", hand, dm, AILevel.BASIC);
        players = new ArrayDeque<Player>();
        players.add(bot);
        players.add(turn);
        players.add(self);
        engine = new RobotEngine(players, bot, AILevel.BASIC);
        robot = engine.getEngineActive();
        state = engine.getState();
        state.setNote(note);
        List<Object> out = robot.beginTurn();
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof SuggestionCardLogic);
    }
    
    public void testPerformSuggestion2()
    {
        System.out.println("--------test Suggestion - no one can disprove");
        hand = new Hand();
        action4 = new SuggestionCard(true, "suggest");
        hand.addToHand(action4);
        hand.addToHand(action4);
        bot = new Robot("robot1_basic", hand, dm, AILevel.BASIC);
        players = new ArrayDeque<Player>();
        players.add(bot);
        players.add(bot);
        players.add(bot);
        engine = new RobotEngine(players, bot, AILevel.BASIC);
        robot = engine.getEngineActive();
        state = engine.getState();
        state.setNote(note);
        List<Object> out = robot.beginTurn();
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof Protocol);
    }
    
    public void testPerformSleuth()
    {
        System.out.println("--------test perform Sleuth - has card to show");
        hand = new Hand();
        action2 = new SuperSleuthCard(ClueType.SUSPECT, 
                Attribute.MALE, "hi");
        hand = new Hand();
        hand.addToHand(action2);
        hand.addToHand(action2);
        bot = new Robot("robot1_basic", hand, dm, AILevel.BASIC);
        players = new ArrayDeque<Player>();
        players.add(bot);
        players.add(turn);
        players.add(self);
        engine = new RobotEngine(players, bot, AILevel.BASIC);
        robot = engine.getEngineActive();
        state = engine.getState();
        state.setNote(note);
        List<Object> out = robot.beginTurn();
        assertEquals(3, out.size());
        assertTrue(out.get(1) instanceof CardMessage);
    }
    
    public void testPerformSleuth2()
    {
        System.out.println("--------test perform Sleuth - no one response");
        hand = new Hand();
        action2 = new SuperSleuthCard(ClueType.SUSPECT, 
                Attribute.MALE, "hi");
        hand = new Hand();
        hand.addToHand(action2);
        hand.addToHand(action2);
        bot = new Robot("robot1_basic", hand, dm, AILevel.BASIC);
        players = new ArrayDeque<Player>();
        players.add(bot);
        players.add(bot);
        players.add(bot);
        engine = new RobotEngine(players, bot, AILevel.BASIC);
        robot = engine.getEngineActive();
        state = engine.getState();
        state.setNote(note);
        List<Object> out = robot.beginTurn();
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof Protocol);
    }
    
    public void testPerformSnoop()
    {
        System.out.println("--------test perform Snoop - All Snoop - Left");
        hand = new Hand();
        action2 =  new SnoopCard(Direction.LEFT, "snoop");
        hand = new Hand();
        hand.addToHand(action2);
        hand.addToHand(action2);
        bot = new Robot("robot1_basic", hand, dm, AILevel.BASIC);
        players = new ArrayDeque<Player>();
        players.add(bot);
        players.add(turn);
        players.add(self);
        engine = new RobotEngine(players, bot, AILevel.BASIC);
        robot = engine.getEngineActive();
        state = engine.getState();
        state.setNote(note);
        List<Object> out = robot.beginTurn();
        assertEquals(4, out.size());
        assertTrue(out.get(1) instanceof CardMessage);
    }
    
    public void testPerformSnoop2()
    {
        System.out.println("--------test perform Snoop - All Snoop - Right");
        hand = new Hand();
        action2 =  new SnoopCard(Direction.RIGHT, "snoop");
        hand = new Hand();
        hand.addToHand(action2);
        hand.addToHand(action2);
        bot = new Robot("robot1_basic", hand, dm, AILevel.BASIC);
        players = new ArrayDeque<Player>();
        players.add(bot);
        players.add(turn);
        players.add(self);
        engine = new RobotEngine(players, bot, AILevel.BASIC);
        robot = engine.getEngineActive();
        state = engine.getState();
        state.setNote(note);
        List<Object> out = robot.beginTurn();
        assertEquals(4, out.size());
        assertTrue(out.get(1) instanceof CardMessage);
    }
    public void testPerformTip()
    {
        System.out.println("--------test perform PrivateTip - Regular");
        hand = new Hand();
        action2 =  new PrivateTipCard(ClueType.VEHICLE, Attribute.BLUE, "tip");
        hand = new Hand();
        hand.addToHand(action2);
        hand.addToHand(action2);
        bot = new Robot("robot1_basic", hand, dm, AILevel.BASIC);
        players = new ArrayDeque<Player>();
        players.add(bot);
        players.add(turn);
        players.add(self);
        engine = new RobotEngine(players, bot, AILevel.BASIC);
        robot = engine.getEngineActive();
        state = engine.getState();
        state.setNote(note);
        List<Object> out = robot.beginTurn();
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof CardMessage);
    }
}