package pacman.controllers.examples;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Random;
import java.util.Set;

import pacman.controllers.Controller;
import pacman.game.Constants;
import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.internal.Maze;
import pacman.game.internal.Node;
import pacman.neuralnetwork.*;

import static pacman.game.Constants.*;

public class CwiePacMan extends Controller<MOVE> 
{
	private Random rnd=new Random();
	private static int m_Depth = 5;
	
	public MOVE getMove(Game game,long timeDue)
	{		
		return TreeSearch(game, timeDue);
	}
	
	private MOVE TreeSearch(Game game, long timeDue){
		int minGhostDistance = 0;
		GHOST moveAway = null;
		for(GHOST ghost : GHOST.values())
		{
			int distance = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost));
			System.out.println(distance);
			if(minGhostDistance< distance && distance < 30)
			{
				minGhostDistance = distance;
				moveAway = ghost;
			}
		}
		
		if(timeDue < 0.5 || moveAway == null)
		{
			MOVE[] possibleMoves=game.getPossibleMoves(game.getPacmanCurrentNodeIndex(),game.getPacmanLastMoveMade());		//set flag as false to prevent reversals	
			System.out.println("Random");
			return possibleMoves[rnd.nextInt(possibleMoves.length)];			
		}
		if(game.getGhostEdibleTime(moveAway)==0)
			return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(moveAway), DM.PATH);
		else
			return game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(moveAway), DM.PATH);
	}

	private MOVE SearchTree(MOVE move, Game game) {
		if(game.getCurrentMaze().graph[game.getPacmanCurrentNodeIndex() + 1].pillIndex == game.getActivePillsIndices()[game.getPacmanCurrentNodeIndex()] + 1)
		{
			return move;	
		}
		return MOVE.NEUTRAL;
	}
}
