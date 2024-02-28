package fr.argonaultes.appsecmybackapi.models;

public class RecoverResponse {
    private int questionId;
    private String response;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
