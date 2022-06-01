package album;
import java.util.ArrayList;
import album.Album;
import page.Page;
public class BasicAlbum extends Album{
	public BasicAlbum(String name,ArrayList<Page> PageList){
		super(name,PageList);
	}
	public String getname(){
		return name;
	}
	public ArrayList<Page> getPageList(){
		return PageList;
	}
	public void addPage(Page x){
		PageList.add(x);
	}
	public void setName(String newName){
		name= newName;
	}
	public void setPageList(ArrayList<Page> PageList1){
		PageList=new ArrayList<Page>();
		for(int i=0;i<PageList1.size();i++){
			PageList.add(PageList1.get(i));
		}
	}
	public String getType(){
		return "VASIKO";
	}
}

