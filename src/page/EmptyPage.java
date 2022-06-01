package page;

import java.util.ArrayList;
import page.Page;
public class EmptyPage extends Page{
	private String title;
	public EmptyPage(String date,ArrayList<String> keys,String title){
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
	public int getType(){
		return 0;
	}
	public String gettitle(){
			return title;
	}
	public void settitle(String title){
		this.title=title;
	}
	public String getkind(){
		return "EMPTY";
	}
}
