import java.io.IOException;
import java.net.URI;
import java.util.*;

class SearchThings implements URLHandler{
    ArrayList<String> dataBase = new ArrayList<>();

    public String handleRequest(URI url){
        if (url.getPath().equals("/")){
            return "Welcome to the search engine created by Yang Han.";
        }

        else if (url.getPath().equals("/add")){
            String[] split_query= url.getQuery().split("=");
            dataBase.add(split_query[1]);

            return "String added!";
        }

        else if (url.getPath().equals("/search")){
            if (url.getQuery().contains("=")){
                String[] split_query= url.getQuery().split("=");
                ArrayList<String> temp= new ArrayList<>();
                for (int i=0; i<dataBase.size(); i++){
                    if(dataBase.get(i).contains(split_query[1])){
                        temp.add(dataBase.get(i));
                    }
                }

                String result= "Search results:\n";
                for (int i=0; i<temp.size(); i++){
                    result= result+temp.get(i)+"\n";
                }

                return result;
            }

        }

        return "404 not found";
    }
}

public class SearchEngine{
    public static void main(String args[]) throws IOException{
        if (args.length==0){
            System.out.println("There is no port number!");
            return;
        }

        int port= Integer.parseInt(args[0]);
        Server.start(port, new SearchThings());


    }
}
