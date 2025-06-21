package StackOverflowLLD;
import java.util.*;

public class Answer implements Votable, Commentable {
    private final int id;
    private String content;
    private User author;
    private Question question;
    private boolean isAccepted;
    private Date creationDate;
    private List<Comment> comments;
    private List<Vote> votes;

    public Answer(User author, Question question, String content) {
        this.id=generateId();
    }

    @Override
    public void vote(User voter, VoteType type) {
        votes.removeIf(v -> v.getVoter.equals(voter));
        votes.add(new Vote(voter,type));
        author.updateReputation(10 * (type == VoteType.UPVOTE ? 1 : -1));
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(v -> v.getType() == VoteType.UPVOTE ? 1 : -1);
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

    public void markAsAccepted() {
        if (isAccepted)
            throw new IllegalStateException("This answer is already accepted");

        isAccepted=true;
        author.updateReputation(15); //15 reputation for accepted answer
    }

    private int generateId() {
        return (int)(System.currentTimeMillis()%Integer.MAX_VALUE);
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getId() {
        return id;
    }


}
