package main_1;
import java.util.ArrayList;
import java.util.Scanner;
import album.Album;
import album.AlbumBySearch;
import album.BasicAlbum;
import page.EmptyPage;
import page.Page;
import page.PhotoPage;
import page.TextPage;
import page.TitlePage;
import print_exit.Exit;
import print_exit.Printer;
import java.lang.NullPointerException;

public class ergasiaanaptiksh134 {
	private static ArrayList<Album> albumlista;
	private static Printer ektipwths;
	
	
	
	public static void main(String args[]){
		albumlista=new ArrayList<Album>();
		Scanner in=new Scanner(System.in);
		String upoeisodos="";
		String onoma,stoixeia,eisodos;
		Album alb=null;
		Page page1=null;
		
		while(true){ //kyrio menu
			System.out.println("menu:epilogh me vash ton arithmo sthn parenthesh");
			System.out.println("(1)-gia na deitai thn lista me ta album");
			System.out.println("(2)-gia ektipwsh album se pptx me hmeromhnia h me seira prosthikhs ");
			System.out.println("(3)-gia dhmiourgeia neou album (vasikou h paragwgou)");
			System.out.println("(4)-gia prosthikh selidas se album");
			System.out.println("(5)-gia epeksergasia selidas");
			System.out.println("(6)-gia eksodo");
			eisodos=in.next();
			
			if(eisodos.equals("1")){   // gia na deitai thn lista me ta album 
				ektipwths=new Printer(albumlista);
				ektipwths.PrintAllAlbums();
			}else if(eisodos.equals("2")){   // gia ektipwsh album se pptx me hmeromhnia h me seira prosthikhs
				boolean x=false;
				while(!x){           // vgenei apo to loop otan dialeksei 1 h 2
					ektipwths=new Printer(albumlista);
					ektipwths.PrintAllAlbums();
					System.out.println("dwse to onoma tou album pou 8es ");
					onoma=in.next();
					System.out.println("(1)-ektipwsh me vash thn hmeromhnia");
					System.out.println("(2)-ektipwsh me vash thn seira prosthikhs");
					upoeisodos=in.next();
					if(upoeisodos.equals("1")){  //ektipwsh me vash thn hmeromhnia
						x=true;
						ektipwths.PrintAnAlbumByDate(onoma);
					}else if(upoeisodos.equals("2")){  //ektipwsh me vash thn seira prosthikhs
						x=true;
						ektipwths.PrintAnAlbum(onoma);
					}else{
						System.out.println("prepei na dwsetai 1 h 2");
						
					}
				}
			}else if(eisodos.equals("3")){  //gia dhmiourgeia neou album (vasikou h paragwgou)
				boolean x=false;
				Album album;
				String key;
				while(!x){  //vgenei apo to loop otan dialeksei 1 h 2
					System.out.println("(1)-gia dhmiourgeia basikou album");
					System.out.println("(2)-gia dhmiourgeia paragwgou album");
					upoeisodos=in.next();
					if(upoeisodos.equals("1")){  //gia dhmiourgeia basikou album
						x=true;
						System.out.println("dwse onoma gia to neo sou album");
						onoma =in.next();
						ArrayList<Page> xy=new ArrayList<Page>();
						album =new BasicAlbum(onoma,xy);
						albumlista.add(album);
					}else if(upoeisodos.equals("2")){  //gia dhmiourgeia paragwgou album
						System.out.println("dwse onoma gia to neo sou album");
						onoma =in.next();
						System.out.println("dwse key gia to  sou album");
						key =in.next();
						x=true;
						ArrayList<Page> lst=new ArrayList<Page>();
						album=new AlbumBySearch(onoma,key,albumlista,lst);
						albumlista.add(album);
					}else{
						System.out.println("prepei na dwsetai 1 h 2");
						System.out.println("gia eksodo dwse (-)");
						onoma=in.next();
						if(onoma.equals("-")){
							x=true;
							break;
						}
					}
				}	
			}else if(eisodos.equals("4")){  //gia prosthikh selidas se album
				boolean y=false;
				while(!y){
					System.out.println("dwse to onoma tou album sto opoio thes na prostheseis th selida");
					System.out.println("gia eksodo dwse (-)");
					onoma=in.next();
					if(onoma.equals("-")){
						y=true;
						break;
					}
					int ssr=0;
					for(int i=0;i<albumlista.size();i++){  // anazhthsei tou album sto opoio 8a eisagoume th selida
						if(onoma.equals(albumlista.get(i).getname())){
							alb=albumlista.get(i);
							ssr++;
						}	
					}
					if(ssr==0){
						System.out.println("den vrethike to album pou edwses");
						
					}else{
						upoeisodos="23";
						while(!(upoeisodos.equals("0"))&&!(upoeisodos.equals("2"))&&!(upoeisodos.equals("3"))&&!(upoeisodos.equals("1"))){
							System.out.println("dwse to tupo ths selidas"); // menu epiloghs tupou selidas
							System.out.println("(0)-gia EmptyPage");
							System.out.println("(1)-gia TextPage");
							System.out.println("(2)-gia TitlePage");
							System.out.println("(3)-gia PhotoPage");
							upoeisodos=in.next();
						}
						System.out.println("dwse thn hmeromhnia me morfh(x/x/xxxx)");
						String date=in.next();
						ArrayList<String> keys=new ArrayList<String>();
						System.out.println("dwse to prwto kleidi");
						stoixeia=in.next();
						int shmaiaa=0;
						while(shmaiaa==0){ // eisagwgh twn kleidiwn
							keys.add(stoixeia);
							System.out.println("thes na eisageis kialo kleidi(yes/no)");
							if(in.next().equals("no")){
								shmaiaa=1;
							}else{
								System.out.println("dwse to epomeno kleidi!!");
								stoixeia=in.next();
							}
						
						}	
						if(upoeisodos.equals("0")){  //gia EmptyPage
							y=true;   //flag  otan mpei se mia apo tis epiloges apo to parapano menu na bgei apo to loop
							System.out.println("dwse ton titlo" );
							String title=in.next();
							
							EmptyPage empty=new EmptyPage(date,keys,title);
							if(ssr!=0){
								alb.addPage(empty);
							}else{
								System.out.println("error den vre8hke to album");
							}
						}else if(upoeisodos.equals("1")){  //gia TextPage
							System.out.println("dwse to keimeno dwse(-) otan oloklhrwseis !");
							y=true;
							String text="";
							String input;
							while(!((input=in.next()).equals("-"))){
								text=text+" "+input;
							}
							System.out.println("dwse ton titlo ");
							String title=in.next();
							
							TextPage textp=new TextPage(date,keys,text,title);
							if(ssr!=0){
									alb.addPage(textp);
								
							}else{
								System.out.println("error den vre8hke to album");
							}
						
						}else if(upoeisodos.equals("2")){  //gia TitlePage
							System.out.println("dwse ton titlo ");
							String title=in.next();
							y=true;
							TitlePage titlep=new TitlePage(date,keys,title);
							if(ssr!=0){
								alb.addPage(titlep);
							}else{
								System.out.println("error den vre8hke to album");
							}
							
						}else if(upoeisodos.equals("3")){  //gia PhotoPage
							System.out.println("dwse ton titlo");
							String title=in.next();
							
							y=true;
							System.out.println("dwse to path ths photo");
							String path =in.nextLine();
							path =in.nextLine();
							System.out.println("dwse to path ths photo"+path);
							PhotoPage photo=new PhotoPage(date,keys,title,path);
							if(ssr!=0){
								alb.addPage(photo);
							}else{
								System.out.println("error den vre8hke to album");
							}	
						}
					}
				}		
			}else if(eisodos.equals("5")){  //gia epeksergasia selidas
				boolean z=false;
				String parametros;
				int thesh= -1;
				while(!z){
					//while(page1==null){
						
						System.out.println("dwse to onoma tou album( an den 3ereis to onoma tou album pata - )");
						stoixeia=in.next();
						if(!(stoixeia.equals("-"))){ //periptwsh pou mas dinete to onoma tou album apo to xrhsth
							// anazhthsh tou album kai anazitish selidas se afto
							for(int i=0;i<albumlista.size();i++){ //to stoixeia =onoma tou album
								if(stoixeia.equals(albumlista.get(i).getname())){ //ebresh tou album
									alb=albumlista.get(i);
									System.out.println("brethike to album!");
								
								}
							}
							onoma=in.nextLine();
							System.out.println("dwse to onoma ths selidas!"); 
							onoma=in.nextLine();
							System.out.println("dwsate selida:"+onoma);
							for(int i=0;i<alb.getPageList().size();i++){  // anazitish selidas se afto to album
								if(onoma.equals(alb.getPageList().get(i).gettitle().trim())){
									page1=alb.getPageList().get(i);
									thesh = i;
								}
							}
					
						}else{   //periptwsh pou den gnwrizoume to onoma tou album
						
							System.out.println("dwse to onoma ths selidas!");
							onoma=in.nextLine();
							onoma=in.nextLine();
							System.out.println("onoma:"+onoma);
							for(int i=0;i<albumlista.size();i++){ //anazhthsh selidas se ola ta album
								for(int j=0;j<albumlista.get(i).getPageList().size();j++){
									//System.out.println(""+albumlista.get(i).getPageList().get(j).gettitle()); gia th lista twn selidwn
									if(onoma.equals(albumlista.get(i).getPageList().get(j).gettitle().trim())){
										page1=albumlista.get(i).getPageList().get(j);
										alb=albumlista.get(i);
										thesh =j;
										
									}
								}
							}
						}
					//}
				    // exoume brei th selida pou 8elei o xrisths na epeksergastei
					// arxizei to menu epeksergasias!!
					if(page1.getType()==0){ //EmptyPage
						boolean s=false;
						while(!s){ //gia ka8e tupo selidas to susthma frontizei na mhn ginei leitourgeia pou den orizetai
							System.out.println("(2)-gia epeksergasia twn kleidiwn");
							System.out.println("(3)-gia epeksergasia ths hmeromhnias");
							System.out.println("(6)-gia epeksergasia tou tupou");
							System.out.println("(7)-den epi8hmw allh epeksergasia");
							upoeisodos=in.next();
							if(!(upoeisodos.equals("1"))&&!(upoeisodos.equals("4"))&&!(upoeisodos.equals("5"))){
								s=true;
							}else{
								System.out.println("den exeis adeia gia afth th leitourgeia");
							}
						}
					}else if(page1.getType()==1){ //TextPage
						boolean s=false;
						while(!s){
							System.out.println("(1)-gia epeksergasia tou titlou");
							System.out.println("(2)-gia epeksergasia twn kleidiwn");
							System.out.println("(3)-gia epeksergasia ths hmeromhnias");
							System.out.println("(4)-gia epeksergasia tou keimenou");
							System.out.println("(6)-gia epeksergasia tou tupou");
							System.out.println("(7)-den epi8hmw allh epeksergasia");
							upoeisodos=in.next();
							if(!(upoeisodos.equals("5"))){
								s=true;
							}else{
								System.out.println("den exeis adeia gia afth th leitourgeia");
							}
						}
						
					}else if(page1.getType()==2){ //TitlePage
						boolean s=false;
						while(!s){
							System.out.println("(1)-gia epeksergasia tou titlou");
							System.out.println("(2)-gia epeksergasia twn kleidiwn");
							System.out.println("(3)-gia epeksergasia ths hmeromhnias");
							System.out.println("(6)-gia epeksergasia tou tupou");
							System.out.println("(7)-den epi8hmw allh epeksergasia");
							upoeisodos=in.next();
							if(!(upoeisodos.equals("4")) &&!(upoeisodos.equals("5"))){
								s=true;
							}else{
								System.out.println("den exeis adeia gia afth th leitourgeia");
							}
						}
						
					}else if(page1.getType()==3){//PhotoPage
						boolean s=false;
						while(!s){
							System.out.println("(1)-gia epeksergasia tou titlou");
							System.out.println("(2)-gia epeksergasia twn kleidiwn");
							System.out.println("(3)-gia epeksergasia ths hmeromhnias");
							System.out.println("(5)-gia epeksergasia tou path");
							System.out.println("(6)-gia epeksergasia tou tupou");
							System.out.println("(7)-den epi8hmw allh epeksergasia");
							upoeisodos=in.next();
							if(!(upoeisodos.equals("4"))){
								s=true;
							}else{
								System.out.println("den exeis adeia gia afth th leitourgeia");
							}
						}
						
					}
					// ektelesh epilogwn  menu epeksergasia
					if(upoeisodos.equals("1")){//epeksergasia titlou
						System.out.println("dwse to neo titlo");
						String titl=in.next();
						page1.settitle(titl);
						
						z=true;
					}else if(upoeisodos.equals("2")){//epeksergasia kleidiwn
						ArrayList<String> keyss=new ArrayList<String>();
						z=true;
						System.out.println("dwse to prwto kleidi");
						String kleidi=in.next();
						int shmaiaa=0;
						while(shmaiaa==0){ // eisagwgh twn kleidiwn
							keyss.add(kleidi);
							System.out.println("thes na eisageis kialo kleidi(yes/no)");
							if(in.next().equals("no")){
								shmaiaa=1;
							}else{
								System.out.println("dwse to epomeno kleidi!!");
								kleidi=in.next();
							}
						
						}	
						page1.setkeys(keyss);
						
					}else if(upoeisodos.equals("3")){//epeksergasia hmeromhnias
						System.out.println("dwse th nea hmeromhnia");
						z=true;
						String date=in.next();
						page1.setdate(date);
						
					}else if(upoeisodos.equals("4")){//epeksergasia keimenou
						System.out.println("dwse to neo keimeno kai dwse (-) otan oloklhrwseis!!");
						z=true;
						String input;
						String keimeno="";
						while(!((input=in.next()).equals("-"))){
							keimeno=keimeno+" "+input;
						}
						page1.settext(keimeno);
						
					}else if(upoeisodos.equals("5")){//epeksergasia path
						System.out.println("dwse to neo path");
						z=true;
						String path=in.next();
						page1.setpath(path);
						
					
					}else if(upoeisodos.equals("6")){//allagh tupou page
						String typ;//menu epilogwn gia allagh tupou selidas
						System.out.println("dwse to neo tupo");
						System.out.println("(0)-gia adeia selida");
						System.out.println("(1)-gia selida me keimeno");
						System.out.println("(2)-gia selida me titlo");
						System.out.println("(3)-gia selida fotografias");
						typ=in.next();
						if(typ.equals(""+page1.getType())){
							System.out.println("o neos tupos einai idios me to prohgoumeno");
						}else{
							if(typ.equals("0")){
								String date=page1.getdate();
								z=true;
								ArrayList<String> keyss=page1.getkeys();
								String titlo=page1.gettitle();
								alb.getPageList().remove(thesh);
								EmptyPage page2=new EmptyPage(date,keyss,titlo);
								alb.addPage(page2);
								
							}else if(typ.equals("1")){//ektelesh epilogwn tou menu
								String titlo;
								String date=page1.getdate();
								z=true;
								ArrayList<String> keyss=page1.getkeys();
								System.out.println("dwse to keimeno ths selidas kai (-)otan oloklhrwseis!");
								String input;
								String keimeno ="";
								while(!((input=in.next()).equals("-"))){
									keimeno=keimeno+" "+input;
								}
								if(page1.getType()==0){//pernei to titlo apo ton xrhsth se periptwsh pou h selida epeksergasia einai kenh
									System.out.println("dwse to neo titlo");
									titlo=in.nextLine();
								}else{ //pernei ton uparxon titlo apo thn selida
									titlo=page1.gettitle();
								}
								alb.getPageList().remove(thesh);
								TextPage page2=new TextPage(date,keyss,keimeno,titlo);
								alb.addPage(page2);
								
							}else if(typ.equals("2")){
								String titlo;
								String date=page1.getdate();
								ArrayList<String> keyss=page1.getkeys();
								z=true;
								if(page1.getType()==0){ //pernei to titlo apo ton xrhsth se periptwsh pou h selida epeksergasia einai kenh
									System.out.println("dwse to neo titlo");
									titlo=in.next();
								}else{ //pernei ton uparxon titlo apo thn selida
									titlo=page1.gettitle();
								}
								alb.getPageList().remove(thesh);
								TitlePage page2=new TitlePage(date,keyss,titlo);
								alb.addPage(page2);
								
							}else if(typ.equals("3")){
								String titlo;
								String date=page1.getdate();
								ArrayList<String> keyss=page1.getkeys();
								z=true;
								if(page1.getType()==0){ //pernei to titlo apo ton xrhsth se periptwsh pou h selida epeksergasia einai kenh
									System.out.println("dwse to neo titlo");
									titlo=in.next();
								}else{ //pernei ton uparxon titlo apo thn selida
									titlo=page1.gettitle();
								}
								System.out.println("dwse to path ths foto");
								String path=in.next();
								alb.getPageList().remove(thesh);
								PhotoPage page2=new PhotoPage(date,keyss,titlo,path);
								alb.addPage(page2);
								
							}
								
								
							
						}
					
						
					}else if(upoeisodos.equals("7")){//bges apo to loup
						z=true;
					}else{
						System.out.println("lathos eisodos");
					}
			}		
			}else if(eisodos.equals("6")){ //gia eksodo
				Exit exit=new Exit();
			}															
		    
	    }
	}
}


		
	




