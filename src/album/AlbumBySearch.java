package album;
import java.util.ArrayList;
import album.Album;
import page.Page;
public class AlbumBySearch extends Album{
	private ArrayList<Page> lista = new ArrayList<Page>();
	private String name;
	public AlbumBySearch(String name,String key,ArrayList<Album> Albums,ArrayList<Page> lst){ // ftiaxnoume to album me basi to key pou dothike
		super(name,lst);//theleis na valeis ka arraylist
		int tr=0;
		this.name=name;
		for(int i=0;i<Albums.size();i++){
			ArrayList<Page> List = new ArrayList<Page>();
			List=Albums.get(i).getPageList();
			for(int j=0;j<List.size();j++){
				ArrayList<String> pagekeys =new ArrayList<String>();
				pagekeys =List.get(j).getkeys();
				for(int k=0;k<pagekeys.size();k++){
						if(key.equals(pagekeys.get(k))){
							addPage(List.get(j));
							tr++;
						}
				}
			}
			
		}
		if(tr==0){
			System.out.println("den vre8hke selida me afto to key!");
		}else{
			System.out.println("epitixhs dhmiourgeia vrethikan "+ tr+" selides");
		}
	}
	public void addPage(Page x){
		PageList.add(x);
			
	}
	public String getname(){
		return name;
	}
	public void setname(String newName){
		name=newName;
	}
	public ArrayList<Page> getPageList(){
		return PageList;
	}
	public void setPageList(ArrayList<Page> PageList1){
		PageList=new ArrayList<Page>();
		for(int i=0;i<PageList1.size();i++){
			PageList.add(PageList1.get(i));
		}
	}
	public String getType(){
		return "PARAGWGO";
	}
	
	
}

