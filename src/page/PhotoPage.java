package page;

import java.util.ArrayList;
import page.Page;
public class PhotoPage extends Page{
	private String title;
	private String path;
	public PhotoPage(String date,ArrayList<String> keys,String title,String path){
		super(date,keys);
		this.title=title;
		this.path=path;
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
	public String getpath(){
		return path;
	}
	public void setpath(String newpath){
		path=newpath;
	}
	public int getType(){
		return 3;
	}
	public String getkind(){
		return "PHOTO";
	}
}
