import java.util.*;

public class WordFrequencyGame {

    public static final String WHITE_SPACES = "\\s+";

    public String getResult(String sentence){


        if (sentence.split(WHITE_SPACES).length==1) {
            return sentence + " 1";
        } else {

            try {
                List<WordInfo> wordInfoList = calculateWordInfo(sentence);

                wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordInfo word : wordInfoList) {
                    String wordInfoLine = String.format("%s %d", word.getValue(), word.getWordCount());
                    joiner.add(wordInfoLine);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }

    private List<WordInfo> calculateWordInfo(String sentence) {
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WordInfo> wordInfoList = new ArrayList<>();
        for (String word : new HashSet<>(words)) {
            int countWord = Collections.frequency(words, word);
            wordInfoList.add(new WordInfo(word, countWord));
        }
        return wordInfoList;
    }
}
