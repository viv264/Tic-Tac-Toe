package Models;

import Strategies.botplayingstrategies.BotPlayingStrategy;
import Strategies.botplayingstrategies.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private final BotPlayingStrategy botPlayingStrategy;

    public Bot(Symbol symbol, String name, BotDifficultyLevel botDifficultyLevel){
        super(symbol, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Cell makeMove(Board board){
        return botPlayingStrategy.makeMove(board);
    }
}
