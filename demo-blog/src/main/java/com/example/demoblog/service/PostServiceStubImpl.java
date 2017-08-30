package com.example.demoblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demoblog.entity.Post;
import com.example.demoblog.entity.User;

@Service
public class PostServiceStubImpl implements PostService {

	private static List<Post> posts = new ArrayList<>();

	static {
		posts.add(new Post(1L, "First Post", "<p>Line #1.</p><p>Line #2</p>", null));
		posts.add(new Post(2L, "Second Post", "Second post content:<ul><li>line 1</li><li>line 2</li></p>",
				new User(10L, "pesho10", "Peter Ivanov")));
		posts.add(new Post(3L, "Post #3", "<p>The post number 3 nice</p>", new User(10L, "merry", null)));
		posts.add(new Post(4L, "Forth Post", "<p>Not interesting post</p>", null));
		posts.add(new Post(5L, "Post Number 5", "<p>Just posting</p>", null));
		posts.add(new Post(6L, "Sixth Post", "<p>Another interesting post</p>", null));
	}

	@Override
	public List<Post> findAll() {
		return posts;
	}

	@Override
	public List<Post> findLatest5() {
		return posts.stream().sorted((a, b) -> b.getDate().compareTo(a.getDate())).limit(5)
				.collect(Collectors.toList());
	}

	@Override
	public Post findById(Long id) {
		return posts.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
	}

	@Override
	public Post create(Post post) {
		post.setId(posts.stream().mapToLong(p -> p.getId()).max().getAsLong() + 1);
		posts.add(post);
		return post;
	}

	@Override
	public Post edit(Post post) {
		for (int i = 0; i < posts.size(); i++) {
			if (Objects.equals(posts.get(i).getId(), post.getId())) {
				posts.set(i, post);
				return post;
			}
		}
		throw new RuntimeException("Post not found: " + post.getId());
	}

	@Override
	public void deleteById(Long id) {
		for (int i = 0; i < posts.size(); i++) {
			if (Objects.equals(posts.get(i).getId(), id)) {
				posts.remove(i);
				return;
			}
		}
		throw new RuntimeException("Post not found: " + id);

	}

}
