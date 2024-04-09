package edu.phystech.hw2.analyzer;

import java.util.List;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    public Label processText(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        TextAnalyzer[] textAnalyzers = {new NegativeTextAnalyzer(), new SpamAnalyzer(getKeywords())};
        for (int i = 0; i < textAnalyzers.length; i++) {
            for (String spam : getKeywords()) {
                if (stringBuilder.indexOf(spam) != -1) {
                    return getLabel();
                }
            }
        }
        return Label.OK;
    }
    public abstract Label getLabel();
    abstract protected List<String> getKeywords();
}
