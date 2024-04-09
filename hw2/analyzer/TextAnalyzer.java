package edu.phystech.hw2.analyzer;


public interface TextAnalyzer {
    Label getLabel();

    Label processText(String text);
}
