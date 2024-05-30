package ru.itis.tarot_whispers.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.tarot_whispers.dto.PostDTO;
import ru.itis.tarot_whispers.dto.PostLikesDTO;
import ru.itis.tarot_whispers.model.Comment;
import ru.itis.tarot_whispers.model.Post;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.security.CanAccessPost;
import ru.itis.tarot_whispers.services.CommentService;
import ru.itis.tarot_whispers.services.LikeService;
import ru.itis.tarot_whispers.services.PostService;
import ru.itis.tarot_whispers.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    final PostService postService;
    final UserService userService;
    final CommentService commentService;
    final LikeService likeService;

    @GetMapping("/create")
    public String showCreatePostForm(Model model) {
        model.addAttribute("postDTO", new PostDTO());
        return "add_post_view";
    }

    @PostMapping
    public String createPost(@ModelAttribute PostDTO postDTO, Model model) {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            postDTO.setUserId(user.getId());
            Post post = postService.createPost(postDTO);
            return "redirect:/posts/" + post.getId();
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to create post. Please try again.");
            return "add_post_view";
        }
    }

    @CanAccessPost
    @GetMapping("/update/{id}")
    public String showUpdatePostForm(@PathVariable UUID id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "update_post_view";
    }

    @CanAccessPost
    @PutMapping("/{id}")
    public String updatePost(@PathVariable UUID id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam(value = "imageUrl", required = false) String imageUrl) {
        PostDTO postDTO = PostDTO.builder()
                .title(title)
                .content(content)
                .imageUrl(imageUrl)
                .build();

        postService.updatePost(id, postDTO);
        return "redirect:/posts/" + id;
    }

    @CanAccessPost
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable UUID id, Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Post post = postService.getPostById(id);
        List<Comment> comments = commentService.getCommentsByPostId(id);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post_view";
    }

    @GetMapping("/")
    public ModelAndView getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        List<PostLikesDTO> postLikesDTOs = new ArrayList<>();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        for (Post post : posts) {
            boolean likedByCurrentUser = likeService.isPostLikedByUser(post, currentUser);

            PostLikesDTO postLikesDTO = new PostLikesDTO();
            postLikesDTO.setPost(post);
            postLikesDTO.setLikedByCurrentUser(likedByCurrentUser);
            postLikesDTOs.add(postLikesDTO);
        }

        return new ModelAndView("all_posts_view", "posts", postLikesDTOs);
    }

    @GetMapping("/user")
    public ModelAndView getUserPosts() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<Post> posts = postService.getPostsByUserId(user.getId());
        return new ModelAndView("user_posts_view", "posts", posts);
    }

    @GetMapping("/success_delete")
    public String showSuccessDeletePost() {
        return "success_delete_post";
    }
}