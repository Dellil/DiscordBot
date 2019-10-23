package eventmanagement;

import datamanagement.DataArrayManager;
import messageutil.SendMessage;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageEmbedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.time.ZonedDateTime;
import java.util.Hashtable;
import java.util.List;

public class MessageEvent extends ListenerAdapter {
    DataArrayManager dam;
    SendMessage sm;
    Hashtable<String, String> ht;

    public MessageEvent() {
        dam = new DataArrayManager();
        sm = new SendMessage();
        ht = new Hashtable<>();
    }
    // 모든 메시지 수신함.
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMessage().getTextChannel().getName().equals("commands")){
            if(!event.getAuthor().isBot()){
                Message message = event.getMessage();
                MessageChannel mc = message.getTextChannel();
                String text = message.getContentDisplay();

                    if(text.equals("")){
                        List<Message.Attachment> attachmentList = message.getAttachments();
                        for(Message.Attachment ma : attachmentList) {
                            dam.addLink(ma.getUrl(), event);
                            //sm.sendMessage(mc, new EmbedBuilder(), message.getAuthor().getName(), ma.getUrl(), ZonedDateTime.now());
                        }
                    }else if(text.equals("~cic")){
                        sm.sendMessage(mc, "```현재 이미지 개수 : " + dam.getSize() + "개```");
                    }else if(text.equals("~help")){
                        sm.sendMessage(mc, "~help");
                    }else if(text.equals("~suicide")){
                        sm.sendMessage(mc, "테스트용 커맨드(이였던것)");
                        //message.getJDA().shutdown();
                    }else {
                        //sm.sendMessage(mc, message.getContentDisplay());
                    }
            }
        }
    }

    @Override
    public void onGuildMessageEmbed(GuildMessageEmbedEvent event) {
        List<MessageEmbed> me = event.getMessageEmbeds();
        for(MessageEmbed m : me){
            String iUrl = m.getImage() != null ? m.getImage().getUrl() : m.getThumbnail().getUrl();
            dam.addLink(iUrl, event);
            //sm.sendMessage(mc, new EmbedBuilder(), message.getAuthor().getName(), iUrl, ZonedDateTime.now());
        }
    }

}