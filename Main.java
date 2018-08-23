import java.io.*;
class main {
  public static void main(String[] args) throws IOException
  {
    System.out.println("\n*****************************");
    String name="";
    FileReader f=new FileReader("test.txt");
    BufferedReader br=new BufferedReader(f);
    String temp="";
    while((temp=br.readLine())!=null)
	name+=temp+"\n";
    //System.out.println("The data in the file is:"+name);
    br.close();
    int ch[]=new int[256];
    for(int i=0;i<256;i++)
    {
    	ch[i]=0;
    }
    //String name="Santhosh";
    for(int i=0;i<name.length();i++)
    {
    	int index=(int)name.charAt(i);
    	//System.out.print(index+"\t");
    	ch[index]+=1;
    }
    bst b=new bst();
    //System.out.println("\tCharacter\tcount");
    for(int i=0;i<256;i++)
    {
    	if(ch[i]>0)
    	{
    	   /*
    		System.out.print("\t");
    		System.out.print((char)i);
    		System.out.print("\t\t");
    		System.out.println(ch[i]);
    	   */
    		b.singleton((char)i,ch[i]);
    	}
    }
    //b.printQueue(); //Prints the elements in the queue
    //System.out.println();
    b.formTree();
    //b.printQueue();
    //b.formcode();
    b.gCodes();
    //System.out.println("Printing Code words for each Character:");
    String code=b.pCodes(name);
    //System.out.println("From Main the code is:"+code);
    FileWriter w=new FileWriter("encoded.txt");
    BufferedWriter bw=new BufferedWriter(w);
    w.write(code);
    w.close();
    String decode=b.decode();
    FileWriter w1=new FileWriter("decoded.txt");
    BufferedWriter bw1=new BufferedWriter(w1);
    w1.write(decode);
    w1.close();
  }
}
