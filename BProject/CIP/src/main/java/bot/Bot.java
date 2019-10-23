package bot;

import eventmanagement.BotStatusEvent;
import eventmanagement.MessageEvent;
import firebase.FireBase;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    private static String token = "NTgyMDk1NTk0NDQ5OTI4MTky.XOpcEQ.lMuK5JjOVmPSxrxlmz8hCyM4RT0";

    public static void main(String args[]) throws LoginException {
        try {
            JDA jda = new JDABuilder(token).addEventListener(new BotStatusEvent()).addEventListener(new MessageEvent()).build();
            jda.awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}