package com.example.arunalu;

public class QuestionLibrary {

    private String mQuestions [] = {
            "නව වචන සෙමින් ඉගෙනීම",
            "අසන දේ තේරුම් ගැනීමේ ගැටළු",
            "අකුරු හා වචනවල සමානකම් හා වෙනස්කම් දැකීමේ අපහසුතාවය",
            "නිවැරදි වචනය සොයා ගැනීමට අපහසු වීම",
            "රිද්මයානුකූල ක්රීඩා කිරීමට අපහසු වීම"
    };

    private String mChoices [] [] = {
            {"ඔව්", "නැත"},
            {"ඔව්", "නැත"},
            {"ඔව්", "නැත"},
            {"ඔව්", "නැත"},
            {"ඔව්", "නැත"}
    };

    private String mCorrectAnswers[] = {"ඔව්", "ඔව්", "ඔව්","ඔව්", "ඔව්"};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
