package StackOverflowLLD;
import java.util.*;

public class StackOverflow {
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tag> tags;

    public StackOverflow() {
        users=new ConcurrentHashMap<>();
        questions=new ConcurrentHashMap<>();
        answers=new ConcurrentHashMap<>();
        tags=new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email) {

    }

    public Question askQuestion(User user, String title, String content, List<String> tags) {

    }

    public Answer answerQuestion(User user, Question question, String content) {

    }

    public Comment addComment(User user, Commentable commentable, String content) {

    }

    public void voteQuestion(User user, Votable question, VoteType type) {
        question.vote(user, type);
    }

    public void voteAnswer(User user, Votable answer, VoteType type) {
        answer.vote(user,type);
    }

    public void acceptAnswer(Answer answer) {
        answer.markAsAccepted();
    }

    public List<Question> searchQuestions(String query) {

    }

    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public Map<String, Tag> getTags() {
        return tags;
    }


}
