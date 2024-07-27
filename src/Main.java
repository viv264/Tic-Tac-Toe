import Controllers.GameController;
import Exceptions.InvalidGameParamsException;
import Models.*;
import Strategies.winningstrategies.OrderOneColumnWinningStrategy;
import Strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import Strategies.winningstrategies.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        Game game;
        List<Player> players = List.of(
                new Player(new Symbol('X'), "Vivek", PlayerType.HUMAN),
                new Bot(new Symbol('O'), "Bot", BotDifficultyLevel.EASY)
        );
        int dimension = 3;

        try{
            game = gameController.createGame(
                    dimension,
                    players,
                    List.of(
                            new OrderOneDiagonalWinningStrategy(players),
                            new OrderOneColumnWinningStrategy(dimension, players),
                            new OrderOneRowWinningStrategy(dimension, players)
                    )
            );
        } catch (InvalidGameParamsException e){
            System.out.println("Seems like you gave invalid params, Update those.");
            return;
        }

        System.out.println("-----Game is Starting------");

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is how board looks like:");
            //print board
            gameController.displayBoard(game);
            //print if undo
            System.out.println("Does anyone want to undo? (y/n)");
            //if yes -> call undo
            String input = scanner.next();

            if(input.equalsIgnoreCase("y")){
                gameController.undo(game);
            }else{
                //move next player
                gameController.makeMove(game);
            }
        }
        //check status of game

        gameController.printResult(game);
        gameController.displayBoard(game);
        //else -> print draw
    }
}