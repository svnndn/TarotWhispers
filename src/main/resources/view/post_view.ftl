<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${post.title}</title>
    <link rel="stylesheet" type="text/css" href="/res/styles/comment_style.css">
    <link rel="stylesheet" type="text/css" href="/res/styles/form_style.css">
    <style>.note-details {
            width: 1800px;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="/res/styles/singlepost_style.css">
    <style>
        .menu {
            bottom: 0;
            width: 100%;
            background-color: #333;
            display: flex;
            justify-content: center;
            padding: 10px 0;
        }
        .menu a {
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            text-align: center;
            border: none;
            outline: none;
            background-color: transparent;
            cursor: pointer;
        }
        .menu a img {
            width: 24px;
            height: 24px;
        }
        .menu a:hover {
            background-color: #555;
        }
        .add-comment {
            text-align: -webkit-center;

        }
    </style>
    <script>
        function deletePost(postId) {
            if (confirm('Are you sure you want to delete this post?')) {
                fetch('/posts/delete/' + postId, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = '/posts/success_delete';
                        } else {
                            alert('Failed to delete the post.');
                        }
                    })
                    .catch(error => {
                        alert('Error: ' + error);
                    });
            }
        }

        function deleteComment(commentId, postId) {
            if (confirm('Are you sure you want to delete this comment?')) {
                fetch('/comments/delete/' + commentId, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                    .then(response => {
                        if (response.ok) {
                            window.location.href = '/posts/'+postId;
                        } else {
                            alert('Failed to delete the comment.');
                        }
                    })
                    .catch(error => {
                        alert('Error: ' + error);
                    });
            }
        }
    </script>
</head>
<body>
<header>
    <#include "includes/menu.ftl">
</header>
<div class="header">
    <div class="column" style="box-sizing: revert !important;">
        <#if post.imageUrl??>
            <img style="width: 300px; border-radius: 10px;" src="/res/images/tarotcard/${post.imageUrl}" alt="Card image">
        </#if>
        <h1>${post.title}</h1>
        <div>
            <p>${post.content}</p>
        </div>
        <div>
            <p><a href="/profile/${post.user.id}">Posted by ${post.user.username}</a></p>
        </div>
    </div>
</div>
<div class="menu">
    <a href="/posts/" title="Back to Posts">
        <img src="/res/images/icons/back_icon.png" alt="Back">
    </a>
    <#if (post.user.username == currentUser.username || currentUser.role == "ROLE_ADMIN")>
        <a href="/posts/update/${post.id}" title="Edit Post">
            <img src="/res/images/icons/edit_icon.png" alt="Edit">
        </a>
        <a href="#" onclick="deletePost('${post.id}')" title="Delete Post">
            <img src="/res/images/icons/delete_icon.png" alt="Delete">
        </a>
    </#if>
</div>
<div id="commentsList" class="comments-section">
    <h1>Comments</h1>
    <#list comments as comment>
        <div class="comment">
            <div class="comment-details" style="margin: 20px; display: flex;">
                <div style="flex: 1;">
                    <div class="comment-author">
                        <h2 style="text-align: left"><a href="/profile/${comment.user.id}">${comment.user.username}</a></h2>
                    </div>
                    <div class="comment-text"><p>${comment.text}</p></div>
                </div>
                <div style="margin-left: 10px;">
                    <#if (comment.user.username == currentUser.username || currentUser.role == "ROLE_ADMIN")>
                        <a href="#" onclick="deleteComment('${comment.id}', '${post.id}')" title="Delete Comment">
                            <img src="/res/images/icons/delete_icon.png" alt="Delete">
                        </a>
                    </#if>
                </div>
            </div>
        </div>
    </#list>
</div>
<div class="add-comment">
    <h2>Add Comment</h2>
    <form id="commentForm" style="width: 90%;">
        <label for="commentText" style="margin-bottom: 10px;">Your Comment:</label>
        <textarea name="text" id="commentText" rows="4" cols="50" required style="width: 100%; margin-bottom: 10px;"></textarea>
        <input type="hidden" id="userId" name="userId" value="${currentUser.id}">
        <input type="hidden" id="postId" name="postId" value="${post.id}">
        <button type="submit" style="padding: 10px 20px; background-color: #1c1c1c; color: white; border: none; cursor: pointer;">Submit</button>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/res/scripts/commentScript.js"></script>
</body>
</html>