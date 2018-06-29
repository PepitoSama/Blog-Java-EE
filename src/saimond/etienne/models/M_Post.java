package saimond.etienne.models;

public class M_Post {

	private int idPost;
	private String PostContent;
	private String urlImgPost;
	
	public M_Post(int idPost, String postContent, String urlImgPost) {
		this.idPost = idPost;
		PostContent = postContent;
		this.urlImgPost = urlImgPost;
	}
	public int getIdPost() {
		return idPost;
	}
	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}
	public String getPostContent() {
		return PostContent;
	}
	public void setPostContent(String postContent) {
		PostContent = postContent;
	}
	public String getUrlImgPost() {
		return urlImgPost;
	}
	public void setUrlImgPost(String urlImgPost) {
		this.urlImgPost = urlImgPost;
	}

}
