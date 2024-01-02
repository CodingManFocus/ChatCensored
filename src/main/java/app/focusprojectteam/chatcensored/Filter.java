package app.focusprojectteam.chatcensored;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class Filter implements Listener {

    private final Main plugin;
    private final FileHandler fileHandler;

    public Filter(Main plugin) {
        this.plugin = plugin;
        this.fileHandler = plugin.getFileHandler();
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        List<String> blockedWords = fileHandler.getConfig().getStringList("blocked_words");
        String message = event.getMessage();

        if (containsBlockedWord(message, blockedWords)) {
            handleBlockedWord(event, blockedWords);
        }
    }

    private boolean containsBlockedWord(String message, List<String> blockedWords) {
        for (String blockedWord : blockedWords) {
            if (message.toLowerCase().contains(blockedWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private void handleBlockedWord(AsyncPlayerChatEvent event, List<String> blockedWords) {
        String originMessage = event.getMessage();
        String filteredMessage = filterMessage(event.getMessage(), blockedWords);
        event.setMessage(filteredMessage);
        System.out.println("금지어가 감지! 원래의 메시지: " + originMessage);

    }

    private String filterMessage(String message, List<String> blockedWords) {
        for (String blockedWord : blockedWords) {
            message = message.replaceAll("(?i)" + blockedWord, "***");
        }
        return message;
    }
}