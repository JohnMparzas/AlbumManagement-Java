package page;

import java.util.ArrayList;
import page.Page;
public class TextPage extends Page{
	private String text;
	private String title;
	public TextPage(String date,ArrayList<String> keys,String text,String title){
		super(date,keys);
		this.text=text;
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
	public String gettext(){
		return text;
	}
	public String gettitle(){
		return title;
	}
	public void settext(String newtext){
		text=newtext;
		
	}
	public void settitle(String newtitle){
		title=newtitle;
	}
	public int getType(){
		return 1;
	}
	public String getkind(){
		return "TEXT";
	}
	
}

