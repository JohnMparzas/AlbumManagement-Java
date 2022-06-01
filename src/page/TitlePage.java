package page;

import java.util.ArrayList;
import page.Page;
public class TitlePage extends Page{
	private String title;
	public TitlePage(String date,ArrayList<String> keys,String title){
		super(date,keys);
		this.title=title;
	}
	public String getdate(){
		return date;
	}
	public ArrayList<String> getkeys(){
		return keys;
	}
	public void setdate(String newdate){
		super.setdate(newdate);
	}
	public void setkeys(ArrayList<String> newkeys){
		super.setkeys(newkeys);
	}
	public String gettitle(){
		return title;
	}
	public void settitle(String newtitle){
		title=newtitle;
	}
	public int getType(){
		return 2;
	}
	public String getkind(){
		return "TITLE";
	}
}

