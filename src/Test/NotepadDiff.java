package Test;
import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

    public class NotepadDiff {
        public NotepadDiff(){
            System.out.println("Test.Test()");
        }

        @SuppressWarnings("resource")
		public static void main(String[] args) throws Exception {
            BufferedReader br1 = null;
            BufferedReader br2 = null;
            String sCurrentLine;
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            br1 = new BufferedReader(new FileReader("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\Extracted_UAT.txt"));
            br2 = new BufferedReader(new FileReader("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\Extracted_Prod.txt"));
            while ((sCurrentLine = br1.readLine()) != null) {
                list1.add(sCurrentLine);
            }
            while ((sCurrentLine = br2.readLine()) != null) {
                list2.add(sCurrentLine);
            }
            List<String> tmpList = new ArrayList<String>(list1);
            tmpList.removeAll(list2);
            System.out.println("content from Extracted.txt which is not there in Extracted_Prod.txt");
            for(int i=0;i<tmpList.size();i++){
                System.out.println(tmpList.get(i)); //content from test.txt which is not there in test2.txt
            }

            System.out.println("content from Extracted_Prod.txt which is not there in Extracted.txt");

            tmpList = list2;
            tmpList.removeAll(list1);
            for(int i=0;i<tmpList.size();i++){
                System.out.println(tmpList.get(i)); //content from test2.txt which is not there in test.txt
            }
        }
    }
