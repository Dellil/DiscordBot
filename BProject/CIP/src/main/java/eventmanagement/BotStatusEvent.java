package eventmanagement;

import messageutil.SendMessage;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.ShutdownEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotStatusEvent extends ListenerAdapter {
    SendMessage sm;

    public BotStatusEvent() {
        sm = new SendMessage();
    }

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("준비완료");
        TextChannel tc = event.getJDA().getGuildsByName("Cyclops", false).get(0)
                .getTextChannelsByName("commands", false).get(0);
        sm.sendMessage(tc, "~help");
    }

    @Override
    public void onShutdown(ShutdownEvent event) {
        System.out.println("난죽택!!");
    }
}