package edu.phystech.hw2.analyzer;

import java.util.List;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private final String[] keywords = {":(", "=(", ":|"};

    @Override
    public Label getLabel() {
        return Label.NEGATIVE;
    }

    @Override
    public List<String> getKeywords() {
        return List.of(keywords);
    }

    @Override
    public Label processText(String text) {
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}
