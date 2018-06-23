package integration_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.*;
import tegakari.*;

/**
 *
 * @author Tarrant
 */
public class RobotSnoopLogicTest extends TestCase{
    RobotSnoopLogic logic;
    Player turn;
    Player player;
    Queue<Player> playerList;
    Notepad notepad;
    AILevel basic = AILevel.BASIC;
    AILevel smart = AILevel.SMART;
    
    Hand humanHand;
    Hand robotHand;
    Destination destinationEastern;
    Destination destinationNorthern;
    DestinationCard cardEastern;
    DestinationCard cardNorthern;
    
    List<Attribute> listEastern;
    List<Attribute> listNorthern;
    
    ActionCard action;
    
    SuspectCard suspectCard;
    VehicleCard vehicleCard;
    
    List<SuspectCard> suspects;
    List<VehicleCard> vehicles;
    List<DestinationCard> destinations;
    
    Solution solution;
    
    public RobotSnoopLogicTest() {
        logic = new RobotSnoopLogic();
        
        listEastern = new ArrayList<>();
        listNorthern = new ArrayList<>();
        listEastern.add(Attribute.EASTERN);
        listNorthern.add(Attribute.NORTHERN);
        
        Suspect s = new Suspect("hera", listEastern, "path1");
        Vehicle v = new Vehicle("card", listNorthern, "path2");
        
        destinationEastern = new Destination("destinationEastern", listEastern, "path");
        destinationNorthern = new Destination("destinationNorthern", listNorthern, "path");
        cardEastern = new DestinationCard(destinationEastern);
        cardNorthern = new DestinationCard(destinationNorthern);
        suspectCard = new SuspectCard(s);
        vehicleCard = new VehicleCard(v);
        humanHand = new Hand();
        humanHand.addToHand(cardEastern);
        
        turn = new HumanPlayer("turn", humanHand, destinationNorthern);
        robotHand = new Hand();
        robotHand.addToHand(cardNorthern);
        player = new Robot("player", robotHand, destinationEastern, AILevel.SMART);
        
        action = new SnoopCard("snoopPath");
        
        playerList = new LinkedList<>();
        playerList.add(turn);
        playerList.add(player);
        
        suspects = new ArrayList<>();
        suspects.add(suspectCard);
        vehicles = new ArrayList<>();
        vehicles.add(vehicleCard);
        destinations = new ArrayList<>();
        destinations.add(cardEastern);
        destinations.add(cardNorthern);
        
        solution = new Solution(s, v, destinationEastern);
        notepad = new Notepad(list, suspects, vehicles, destinations, solution);
    }
    
    
    
    public void testResponse() {
         List<ClueCard> out;
         
         out = logic.responseToActionRequest(action, notepad, turn, self, basic);
         
         DestinationCard cardOut = (DestinationCard)out.get(0);
         
         DestinationCard check = cardNorthern;
         
         // why are we snooping on turn player?
         // aren't we suppose to snoop on the next player in the list?
         // right now the method snoops on the param turn player
         assertEquals(cardOut, cardEastern);
         
         NoteEntry entry = notepad.getEntry(cardEastern, turn);
         
         assertEquals(NoteEntry.HAS, entry);
         
         entry = notepad.getEntry(cardEastern, player);
         
         assertEquals(NoteEntry.HASNOT, entry);
         
         ClueCard put = logic.playSnoop((SnoopCard) action, notepad, turn, (Robot)player, basic);
         
         assertEquals(cardEastern, (DestinationCard) put);
         
    }
    
    public void testBenefit() {
        SnoopCard snoop = (SnoopCard) action;
    
        int out = logic.benefitFromAction(notepad, action);
        
        snoop = new SnoopCard(Direction.LEFT, "thePath");
        int out2 = logic.benefitFromAction(notepad, action);
        
        notepad.mark(cardEastern, player, NoteEntry.HAS);
        int out4 = logic.benefitFromAction(notepad, action);
        
        action = new PrivateTipCard(ClueType.DESTINATION, "path");
        
        int out3 = logic.benefitFromAction(notepad, action);
        
        
        assertEquals(5, out);
        assertEquals(5, out2);
        assertEquals(-1, out3);
        assertEquals(1, out4);
    }
}