package album;
import java.util.ArrayList;
import page.Page;
public abstract class Album { // kanoume klironomikotita gia ta alboum me abstract mama kai paidia ta duo eidh album
	protected String name;
	protected ArrayList<Page> PageList;
	public abstract String getname();
	public abstract ArrayList<Page> getPageList();
	public abstract void addPage(Page x);//addPage(page)
	public abstract String getType();
	public Album(String name){
		this.name=name;
		ArrayList<Page> PageList= new ArrayList<Page>();
	}
	public Album(String name,ArrayList<Page> PageList1){
		this.name=name;
		PageList=new ArrayList<Page>();
		for(int i=0;i<PageList1.size();i++){
			PageList.add(PageList1.get(i));
		}
	}
	public void setname(String newname){
		name=newname;
	}
	public void setPageList(ArrayList<Page> PageList1){
		PageList=new ArrayList<Page>();
		for(int i=0;i<PageList1.size();i++){
			PageList.add(PageList1.get(i));
		}
	}
	
}
