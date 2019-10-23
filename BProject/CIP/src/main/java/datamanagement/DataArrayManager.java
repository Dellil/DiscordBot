package datamanagement;

import firebase.FireBase;
import net.dv8tion.jda.core.events.message.guild.GenericGuildMessageEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class DataArrayManager extends ListenerAdapter {
	DataArray da;
	FireBase fb;
	public DataArrayManager() {
		da = new DataArray();
		fb = new FireBase();
	}

	public void addLink(String iUrl , GenericGuildMessageEvent event){
		da.addLink(iUrl);
		int size = da.getSize();
		System.out.println(size+"번째 이미지 저장 완료");
		checkSize(size, event);
	}

	public void checkSize(int size, GenericGuildMessageEvent event) {
		if(size == 5){
			fb.insertData(da.getList());
			event.getChannel().sendMessage("```Image Save Complete!```").queue();
			da.clearData();
		}
	}

	public int getSize() {
		return da.getSize();
	}
}
