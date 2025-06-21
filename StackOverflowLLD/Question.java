package StackOverflowLLD;

import java.util.*;

public class Question implements Votable, Commentable {
    private final int id;
    private String title;
    private String content;
    private User author;
    private Date creationDate;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(User author, String title, String content, List<String> tagNames) {
        this.id=generateId();
        this.author=author;
        this.title=title;
        this.content=content;
        this.answers=new ArrayList<>();
        this.tags=new ArrayList<>();
        this.votes=new ArrayList<>();
        this.comments=new ArrayList<>();

        for (String tagName: tagNames)
            this.tags.add(new Tag(tagName));
    }

    public synchronized void addAnswer(Answer answer) {
        if (!answers.contains(answer))
            answers.add(answer);
    }

    public synchronized void acceptedAnswer(Answer answer) {
        this.acceptedAnswer=answer;
        answer.markAsAccepted();
    }

    @Override
    public void vote(User voter, VoteType type) {
        votes.removeIf(v -> v.getVoter().equals(voter));
        votes.add(new Vote(voter,type));
        author.updateReputation(5*(type == VoteType.UPVOTE ? 1 : -1));
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(v -> v.getType() == VoteType.UPVOTE ? 1 : -1)
                .sum();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    private int generateId() {
        return (int)(System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(Answer acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }


}
