package org.jordi.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jordi.model.Post;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("post")
public class PostResource {

@Resource(lookup = "jdbc/h2test")
DataSource ds;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Post post(@QueryParam("id") String id) {

		System.out.print(id);
		Post pst = new Post();

		if (id != null)
			pst.setId(id);
		else
			pst.setId("identifier");
		pst.setTitle("helloworld");
		pst.setContent("this is a post content");

		return pst;
	}

}
