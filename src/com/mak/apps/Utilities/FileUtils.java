package com.mak.apps.Utilities;

import com.mak.apps.Model.Vote;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    private static void setVoters(){
        if (ReadFromFile(Constants.voters_file).isEmpty()){
            WriteToFile(Constants.voters_file,Constants.voters_list);
        }
    }
    public static boolean CreateDirSystem(){
        boolean result = true;
        File dirs = new File("C:\\Voting System\\data");
        if (!dirs.exists()){
            result = dirs.mkdirs();
        }
        File[] files = {new File("C:\\Voting System\\data\\voters.json"),
                new File("C:\\Voting System\\data\\votes.json"),
                new File("C:\\Voting System\\data\\candidates.json")
        };
        for (File f :files){
            if (!f.exists()){
                try {
                    result=  f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        setVoters();
        return result;
    }

    public static void WriteToFile(String path,String content)  {
        FileOutputStream fout= null;
        try {
            fout = new FileOutputStream(path);
            byte b[]=content.getBytes();//converting string into byte array
            fout.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static String ReadFromFile(String path) {
        StringBuilder out = new StringBuilder();
        FileInputStream fin= null;
        try {
            fin = new FileInputStream(path);
            int i=0;
            while((i=fin.read())!=-1){
                out.append(String.valueOf((char) i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(out);
    }

}
