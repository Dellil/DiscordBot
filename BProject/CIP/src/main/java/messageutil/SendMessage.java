package messageutil;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageEmbed;

import java.time.temporal.TemporalAccessor;

public class SendMessage {
    public void sendMessage(MessageChannel mc, String s){
        if(!s.equals("~help")){
            mc.sendMessage(s).queue();
        }else {
            String message = "```" + "수행평가 제출용으로 만든 봇이며, 모든 명령어들은 접두사 ~를 붙여야 됩니다.\n"
                    +"명령어를 실행시키는 시점부터 이미지 저장을 시작하며, 5개씩 쌓일 때 DB에 저장합니다.\n"
                    +"예) ~help\n명령어 목록 : \n"
                    +"\n"
                    +"cic : 봇이 가동된 후, 총 모은 이미지 수를 보여줍니다.\n"
                    +"suicide : 자살합니다.\n"
                    +"help : 도움말을 다시 표시합니다. 그런데 이걸 하는 흑우가 있다고?"
                    + "```";
            mc.sendMessage(message).queue();
        }
    }

    public void sendMessage(MessageChannel mc, MessageEmbed me){
        mc.sendMessage(me).queue();
    }

    public void sendMessage(MessageChannel mc, EmbedBuilder eb, String author, String url, TemporalAccessor timestamp){
        eb.setAuthor(author);
        eb.setImage(url);
        eb.setTimestamp(timestamp);
        mc.sendMessage(eb.build()).queue();
    }
}