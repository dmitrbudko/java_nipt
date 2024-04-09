package edu.phystech.hw2.analyzer;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private final int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label getLabel() {
        return Label.TOO_LONG;
    }

    @Override
    public Label processText(String text) {
        if (text.length() <= maxLength) {
            return Label.OK;
        } else {
            return getLabel();
        }
    }
}
