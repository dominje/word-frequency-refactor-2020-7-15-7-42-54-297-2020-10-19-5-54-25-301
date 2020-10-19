import java.util.*;

public class WordFrequencyGame {

    private static final String WHITE_SPACES = "\\s+";
    public static final String NEW_LINE = "\n";

    public String getResult(String sentence) {
        if (isSentenceOnlyOneWord(sentence)) {
            return sentence + " 1";
        } else {
                try {
                    List<WordInfo> wordInfoList = calculateWordFrequency(sentence);
                    wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
                    StringJoiner wordCountOutput = new StringJoiner(NEW_LINE);
                    for (WordInfo word : wordInfoList) {
                        String wordInfoLine = String.format("%s %d", word.getWord(), word.getWordCount());
                        wordCountOutput.add(wordInfoLine);
                    }
                    return wordCountOutput.toString();
                } catch (Exception e) {
                    return "Calculate Error";
                }
        }
    }

    private boolean isSentenceOnlyOneWord(String sentence) {
        return sentence.split(WHITE_SPACES).length == 1;
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WordInfo> wordInfoList = new ArrayList<>();
        for (String word : new HashSet<>(words)) {
            int countWord = Collections.frequency(words, word);
            wordInfoList.add(new WordInfo(word, countWord));
        }
        return wordInfoList;
    }
}
