package StackOverflowLLD;
import java.util.*;
import java.util.stream.Collectors;

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
        int id=users.size()+1;
        User user=new User(id, username, email);
        users.put(id,user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags) {
        Question question=user.askQuestion(title, content, tags);
        questions.put(question.getId(),question);
        for (Tag tag: question.getTags())
            this.tags.putIfAbsent(tag.getName(), tag);

        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer=new Answer(user, question, content);
        answers.put(answer.getId(),answer);

        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content) {
        return user.addComment(commentable, content);
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
        return questions.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase())  ||
                        q.getTags().stream().anyMatch(t -> t.getName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
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
