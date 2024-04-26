package edu.phystech.hw2.analyzer;

import java.util.List;

public class SpamAnalyzer extends KeywordAnalyzer{
    final private List keywords;
    public SpamAnalyzer(List keywords){
        this.keywords = keywords;
    }
    @Override
    public Label getLabel() {
        return Label.SPAM;
    }
    @Override
    protected List<String> getKeywords(){
        return keywords;
    }
}
