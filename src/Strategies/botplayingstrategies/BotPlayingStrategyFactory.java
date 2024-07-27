package Strategies.botplayingstrategies;

import Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel){
        return new EasyBotPlayingStrategy();
    }
}
