package org.jordi.service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jordi.application.config.Property;
import org.jordi.application.dao.PostDao;
import org.jordi.model.Post;


@Path("/post")
public class PostResource {


	 @Property("miproperty")
    @Inject
    String propiedad;
 


    @Inject
	PostDao postDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Post getByUd(@QueryParam("title") String title) {

		System.out.print(title);
		System.out.print("se escribre la propiedad:");
		System.out.println(this.propiedad);
		Post pst = new Post();

		if (title != null)
			pst.setTitle(title+this.propiedad);
		else
			pst.setTitle("default title");
		pst.setContent("this is a post content");
		postDao.createPost(pst);
		return pst;
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Post createPost(Post post) {

		System.out.print(post);
		return post;
	}
}
