package datamanagement;

import java.util.ArrayList;

public class DataArray {
	private static ArrayList<String> list = new ArrayList<>();

	public void addLink(String iUrl){
		list.add(iUrl);
	}

	public void clearData() {
		for(String iUrl : list){
			System.out.println("Data Array - 현재 그림 링크 : " + iUrl);
		}
		list.clear();
		System.out.println("ArrayList Data Clear Complete!");
	}

	public String getUrl(int index){
		return list.get(index);
	}

	public int getSize() {
		return list.size();
	}

	public ArrayList<String> getList() {
		return list;
	}
}