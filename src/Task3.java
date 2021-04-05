import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Task3 {
    public static List<String> rarestWords(String filename) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, Integer> words = new HashMap<>();
        try(FileReader fileReader = new FileReader(filename, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String inputString;
            while((inputString = bufferedReader.readLine()) != null){
                inputString += " ";
                StringBuilder currentWord = new StringBuilder();
                for(char letter : inputString.toCharArray()){
                    if(letter != ' '){
                        currentWord.append(letter);
                    } else {
                        if(words.get(currentWord.toString()) != null){
                            words.put(currentWord.toString(), words.get(currentWord.toString()) + 1);
                        } else {
                            words.put(currentWord.toString(), 1);
                        }
                        currentWord.delete(0, currentWord.length());
                    }
                }
            }

            Integer minNumber = findMin(words.values());
            for(String word : words.keySet()){
                if(words.get(word) == minNumber){
                    result.add(word);
                }
            }
        } catch (IOException e) {
            throw new IOException("Unable to read file", e);
        }
        return result;
    }

    public static Integer findMin(Collection<Integer> numbers){
        Integer minNumber = null;
        for(Integer number : numbers){
            if(minNumber == null || number < minNumber){
                minNumber = number;
            }
        }
        return minNumber;
    }

}
