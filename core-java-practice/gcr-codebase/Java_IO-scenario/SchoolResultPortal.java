import java.io.*;
public class SchoolResultPortal{
    public static void main(String[] args){
        try(BufferedReader br=new BufferedReader(new FileReader("students.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("report.txt",true))){
            String line;
            while((line=br.readLine())!=null){
                String[] p=line.split(",");
                int total=0;
                for(int i=1;i<p.length;i++) total+=Integer.parseInt(p[i]);
                bw.write(p[0]+" Average = "+(double)total/(p.length-1));
                bw.newLine();
            }
        }catch(FileNotFoundException e){System.out.println("students.txt not found.");}
        catch(Exception e){e.printStackTrace();}
    }
}