package page;
import java.util.ArrayList;
public abstract class Page {// dimiourgoume mia klhronomikotita me page abstract mama kai paidia kathe idous page
	protected String date;  // orizoume tis me8odous get kai set gia kathe paidi kai  episis th getType pou epistefei int analoga to eidos ths page 
	protected ArrayList<String> keys;
	public abstract String getdate();
	public abstract ArrayList<String> getkeys();
	public abstract int getType();
	public abstract String gettitle();
	public abstract String getkind();
	public Page(String date,ArrayList<String> keys){
		this.date=date;
		this.keys=keys;
	}
	public void setdate(String newdate){
			date=newdate;
	}
	public void setkeys(ArrayList<String> newkeys){
			keys=new ArrayList<String>();
			for(int i=0;i<newkeys.size();i++){
				keys.add(newkeys.get(i));
			}
	}
	public void settitle(String title){
	}
	public void setpath(String path){
	}
	public void settext(String text){
	}
	public String gettext(){
		return null;
	}
	public String getpath(){
		return null;
	}
	
	

}