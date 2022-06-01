package print_exit;
import java.util.ArrayList;
import album.Album;
import page.Page;
import src.poiExtractor.*;
public class Printer{
	private ArrayList<Album> AlbumList;
	private Album album;
	public Printer(ArrayList<Album> AlbumList){ //Constructor
		this.AlbumList=AlbumList;
	}
	public void PrintAllAlbums(){ // tuponei th lista twn album  tis selides tous
		
			System.out.println("h lista twn album einai:");
			for(int i=0;i<AlbumList.size();i++){//gia kathe album
				if(AlbumList.get(i).getPageList()!=null){//an den einai keno
					System.out.println("-"+AlbumList.get(i).getType()+" "+AlbumList.get(i).getname()+" me "+AlbumList.get(i).getPageList().size()+" selides");
					for(int j=0;j<AlbumList.get(i).getPageList().size();j++){//gia kathe selida
						System.out.println("   -"+AlbumList.get(i).getPageList().get(j).getkind()+" "+AlbumList.get(i).getPageList().get(j).gettitle()+" me hmeromhnia "+AlbumList.get(i).getPageList().get(j).getdate()+" kai keys:");
						for(int sp=0;sp<AlbumList.get(i).getPageList().get(j).getkeys().size();sp++){//gia kathe key
							System.out.print(" 	"+AlbumList.get(i).getPageList().get(j).getkeys().get(sp)+" ");
							
						}
						System.out.println("");
					}
				}else{//keno
					System.out.println(""+AlbumList.get(i).getname()+" KENO");
				}
			}
	}
	public void PrintAnAlbumByDate(String albumname){ //tupwnei to album se pptx me hmeromhnia
		
		for(int i=0;i<AlbumList.size();i++){    //anazhthsh album
			if(AlbumList.get(i).getname().equals(albumname)){
				album=AlbumList.get(i);
				
			}
		}
		if(album==null){
			System.out.println("to onoma tou album  pou dwsate einai mh egiro");
			return;
		}
		int []hmeromhnies=new int[album.getPageList().size()];// dimiourgia 2 paralilwn pinakwn antistixia gia hmeromhnia kai pages
		Page []pages1=new Page[album.getPageList().size()];
		for(int i=0;i<album.getPageList().size();i++){// px 1/3/12->integer 120301 
			hmeromhnies[i]=stringtoint(album.getPageList().get(i).getdate()); // gia kathe selida pernoume thn hmeromhnia ths thn metatrepoume se int kai th bazoume se pinaka
			pages1[i]=album.getPageList().get(i);// bazoume th selida sto pinaka
		}
		for(int i=0;i<hmeromhnies.length;i++){ // taksinomish tou pinaka me ths hmerominies me basei tou parapanw integer
			for(int j=0;j<hmeromhnies.length-1;j++){ // kai paralila taksinomoume kai ton pinaka twn pages
				if(hmeromhnies[j]>hmeromhnies[j+1]){
					int temp=hmeromhnies[j];
					hmeromhnies[j]=hmeromhnies[j+1];
					hmeromhnies[j+1]=temp;
					Page temp2=pages1[j];
					pages1[j]=pages1[j+1];
					pages1[j+1]=temp2;
					
				}
			}
		}
		AlbumExtractor albumExtractor = new AlbumExtractor(album.getname()); // metatroph se pptx kai tupwsh
		for(int i=0;i<pages1.length;i++){
			if(pages1[i].getType()==0){
				BlankPageExtractor blank = new BlankPageExtractor();
				albumExtractor.addSlideExtractor(blank);
			}else if(pages1[i].getType()==1){
				ContentPageExtractor content = new ContentPageExtractor(pages1[i].gettitle(),pages1[i].gettext());
				albumExtractor.addSlideExtractor(content);
			}else if(pages1[i].getType()==2){
				TitlePageExtractor title = new TitlePageExtractor(pages1[i].gettitle());
				albumExtractor.addSlideExtractor(title);
			}else if(pages1[i].getType()==3){
				PicturePageWResizablePicExtractor picture = new PicturePageWResizablePicExtractor(pages1[i].gettitle(),pages1[i].getpath());
				albumExtractor.addSlideExtractor(picture);
			}else{
				System.out.println("error with type of page");
			}
		}
		albumExtractor.exportPOISlideShow();
	}
	public void PrintAnAlbum(String albumname){ //tupwnei to album se pptx me th seira eisagwghs twn selidwn 
	
		for(int i=0;i<AlbumList.size();i++){  //anazhthsh album
			if(AlbumList.get(i).getname().equals(albumname)){
				album=AlbumList.get(i);
			}
		}
		if(album==null){
			System.out.println("to onoma tou album pou dwsate einai mh egiro");
			return;
		}
		ArrayList<Page> listpage=album.getPageList();   // metatroph se pptx kai tupwsh
		AlbumExtractor albumExtractor = new AlbumExtractor(album.getname());
		for(int i=0;i<album.getPageList().size();i++){
			if(listpage.get(i).getType()==0){
				BlankPageExtractor blank = new BlankPageExtractor();
				albumExtractor.addSlideExtractor(blank);
			}else if(listpage.get(i).getType()==1){
				ContentPageExtractor content = new ContentPageExtractor(listpage.get(i).gettitle(),listpage.get(i).gettext());
				albumExtractor.addSlideExtractor(content);
			}else if(listpage.get(i).getType()==2){
				TitlePageExtractor title = new TitlePageExtractor(listpage.get(i).gettitle());
				albumExtractor.addSlideExtractor(title);
			}else if(listpage.get(i).getType()==3){
				PicturePageWResizablePicExtractor picture = new PicturePageWResizablePicExtractor(listpage.get(i).gettitle(),listpage.get(i).getpath());
				albumExtractor.addSlideExtractor(picture);
			}else{
				System.out.println("error with type of page");
			}
		}
		albumExtractor.exportPOISlideShow();
		
	}
	public int stringtoint(String date1){ // metatroph hmeromhnias apo string se int px dothisas 1/3/4512-> 45120301 
		int date;
		String []date2=date1.split("/");  //dimiourgoume pinaka 3on thesewn xwrismena me" / "
		if(date2[0].length()==1){         //an h hmera einai monh dld apo 1 mexri 9 -> 01 02 03 ...
			date2[0]="0"+date2[0];
			
		}
		if(date2[1].length()==1){    // to idio kanoume gia to mhna 
			date2[1]="0"+date2[1];
		}
		String date3=date2[2]+""+date2[1]+""+date2[0]; // dimiourgia tou telikou arithmou se string
		date=Integer.parseInt(date3); // metatropei se int
		return date;
	}
	
}