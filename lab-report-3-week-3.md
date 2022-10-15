# CSE 15L Week 3 Lab Report

## Part 0 Code

```
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
            if (url.getQuery().contains("=")){
                String[] split_query= url.getQuery().split("=");
                dataBase.add(split_query[1]);
                return "String added:"+split_query[1];
            }
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
```

---

## Part 1 SearchEngine

* Add String

![Add_String](https://TonyYangHan.github.io/cse15l-lab-reports/Add_String_Apple.jpg)

Method being called:

When I start, the main method run the first. The port number equals to args[0] and Server.start method is called, and the web page is available, and we create a new class SearchThings with a field called ArrayList<String> dataBase by calling the constructor.

When I enter a url with _add_ path, .handleRequest(URI url) method will be called with intake parameter of the url I entered. Then, the _Path_ part of the url is being extracted by the method .getPath(). Then it enters a boolean comparison and execute the code whenever _Path_. equals(/add). Then, _query_ part is extracted by .getQuery() and is splitted at "=". The latter part (split_query[1]) is added to _dataBase_ for storage by .add(String element)

Finally the .handleRequest() method returns "String added:" + _theAddedString_


* Search String

![Search_String](https://TonyYangHan.github.io/cse15l-lab-reports/Search_String.jpg)

Firstly, the main method is called. The port number is set to args[0] and a _SearchThings_ class is created by calling the constructor. 

When I enter a url with _search_ path, the .handleRequst() method is being called with intake parameter of the url I entered. Then, the url's _Path_ is extracted by .getPath() and it enters boolean comparison. Then, the code under the condition else if (url.getPath().equals("/search")) is executed. The _query_ of the url will be extracted by .getQuery() and be splitted at "=". The latter part of _query_ (split_query[1]) is used as the search criteria.

The code then initialize a new ArrayList<String> temp to store the matching _String_ during search. The code uses a for loop to loop through the _dataBase_. In each iteration, whether the element with current index in _dataBase_ contains _split_query[1]_ is determined. If so, it will be added to _temp_ by .add(String element).

After this, I initialized a _String_ result ="Search results: \n" and use a for loop to add each element in _temp_ . The _result_ will then consist of each matching _String_ on a separate line as shown in the screenshot.

* Error Response

![Error_Response](https://TonyYangHan.github.io/cse15l-lab-reports/Error_Response.jpg)


When I enter the url with search term that does not match any elements in the _dataBase_, the main method is called. The port number is set to args[0] and a _SearchThings_ class is created by calling the constructor. 

The .handleRequest(URI url) is then called with intake paramer of the url I entered. Then, the url's _Path_ is pulled out by .getPath() method and goes into boolean comparison. The rest process is mostly similar to the process describe above. However, since the no term is matched in the _dataBase_, it will return _String_ "Search result:" with nothing under it.

---

## Part 2 JUnit Tests

* Bug in ArrayExamples

![Failure_Input](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_input.jpg)

The input was an int[] with increasing order. The expected output is {6,5,4,3,2,1}

![Failure_Symptom](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_Symptom.jpg)

![Failure_Symptom_2](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_Symptom_2.jpg)

The symptom was that two terms at index 3 in expected array and actual array does not match. (expected:3 actual:4) and the latter half of the actual array looks weird.

![Failure_Bug](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_Bug_2.jpg)

The Bug in this method is that you will lost the first half of elements are lost during the iteration. When you firstly change the first three elements to the last three elements in the array, everything worked fine (for now), BUT when you try to change the last three elements to the former three elements, you will encounter an issue: the former three elements have already been changed. Therefore, in this method, you basically lost the first half of information.

To fix this, a temporary variable can be created so that the element in the first half can be stored. Then, after changing the element in the first half to the corresponding element in the latter half, it can also change the element in the latter half to the corresponding element in the first half by assigning it with temp. (So basically the elements are being exchanged)

![Failure_Fix](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_fixed.jpg)



* Bug in ListExamples

![Failure_List_Input](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_List_Input.jpg)

I wrote a .checkString() method that returns true if the _String s_ has length greater than 5. I added three _String_ to the list and called filter to select those _String_ whose lengths are greater than 5. So in this case the expected output is {pinapple,watermelon}.


![Failure_List_Symptom](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_List_Symptom.jpg)

The actual array is {watermelon, pinapple}.

![Failure_List_Bug](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_List_bug.jpg)

The bug in the code is that the program inserts the newly added element at index 0, which means that elements added later will appear earlier in the list, which contradicts the order of the orinigal input list. This bug can be fixed simply by deleting the first parameter in the add method because then the newly added element will be appended to the end of the list, which conforms the original order.

![Failure_List_Bug_Fixed](https://TonyYangHan.github.io/cse15l-lab-reports/Failure_List_Bug_Fixed.jpg)

## The END
## Thank you!


