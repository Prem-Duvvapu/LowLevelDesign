package StackOverflowLLD;

public interface Votable {
    void vote(User user,VoteType type)
    int getVoteCount();
}
