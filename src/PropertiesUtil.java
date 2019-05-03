

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String fileName = "test.properties";
        PropertiesUtil pu = new PropertiesUtil();
        HashMap map=new HashMap();
        map.put("age", "22");
        map.put("name", "leishao");
        pu.updateProperty(fileName, map);
        System.out.println(pu.loadAllProperties(fileName));
        System.out.println(pu.loadProperty(fileName, "name"));
        

    }

    public HashMap<String, String> loadAllProperties(String fileName) {
        InputStream is = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Properties pr = new Properties();

        try {
            pr.load(br);
            HashMap<String, String> hm = new HashMap<String, String>();
            for (Object s : pr.keySet()) {
                hm.put(s + "", pr.getProperty(s + ""));
            }
            return hm;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
            }

        }
        return null;

    }

    public String loadProperty(String fileName, String key) {
        InputStream is = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Properties pr = new Properties();

        try {
            pr.load(br);
            
            if (pr.containsKey(key)) {
                return pr.get(key) + "";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
            }

        }
        return null;
    }

    public void updateProperty(String fileName, HashMap<String,String> map) {
        InputStream is = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Properties pr = new Properties();
        String filePath=PropertiesUtil.class.getClassLoader().getResource(fileName).getFile();
         
            
        try {
            pr.load(br);
            pr.putAll(map);
            OutputStream out=new FileOutputStream(filePath);
            pr.save(out, "");
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
            }

        }
         
    }

    
}