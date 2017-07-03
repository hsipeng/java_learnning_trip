package dao;

import java.util.List;

import models.Comment;

public interface CommentDao {
	List<Comment> getAllComments();
	List<Comment> getAllCommentsByPage(int start,int end);
	public boolean newComment(String comment,int userid);
}
