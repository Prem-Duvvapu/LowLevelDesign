package StackOverflowLLD;
import java.util.*;

public class User {
    private final int id;
    private String username;
    private String email;
    private int reputation;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;

    private static final int QUESTION_REPUTATION=3;
    private static final int ANSWER_REPUTATION=10;
    private static final int COMMENT_REPUTATION=1;

    public User(int id,String username,String email) {
        this.id=id;
        this.username=username;
        this.email=email;
    }

    public synchronized void updateReputation(int value) {
        this.reputation+=value;
        if (this.reputation<0)
            this.reputation=0;
    }

    public Question askQuestion(String title, String content, List<String> tags) {
        Question question=new Question(this, title, content, tags);
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question, String content) {
        Answer answer=new Answer(this, question, content);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content) {
        Comment comment=new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
