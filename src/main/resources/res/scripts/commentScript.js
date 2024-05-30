document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("commentForm").addEventListener("submit", function(event) {
        event.preventDefault();

        let commentText = document.getElementById("commentText").value;
        let userId = document.getElementById("userId").value;
        let postId = document.getElementById("postId").value;

        let formData = new FormData();
        formData.append("text", commentText);
        formData.append("userId", userId);
        formData.append("postId", postId);

        fetch("/comments/add", {
            method: "POST",
            body: formData
        })
            .then(response => {
                if (response.ok) {
                    document.getElementById("commentText").value = "";
                    return response.json();
                } else {
                    throw new Error('Failed to add comment.');
                }
            })
            .then(newComment => {
                let newCommentHTML = `
                    <div class="comment">
            <div class="comment-details" style="margin: 20px; display: flex;">
                <div style="flex: 1;">
                    <div class="comment-author">
                        <h2 style="text-align: left"><a href="/profile/${newComment.user.id}">${newComment.user.username}</a></h2>
                    </div>
                    <div class="comment-text"><p>${newComment.text}</p></div>
                </div>
                <div style="margin-left: 10px;">
                    ${newComment.user.canDelete ?
                    `<a href="#" onclick="deleteComment('${newComment.id}, ${newComment.post.id}')" title="Delete Comment">
                            <img src="/res/images/icons/delete_icon.png" alt="Delete">
                        </a>` : ''}
                </div>
            </div>
        </div>
                `;
                document.getElementById("commentsList").insertAdjacentHTML('beforeend', newCommentHTML);
            })
            .catch(error => {
                console.error("Error:", error);
                alert("Failed to add comment. Please try again.");
            });
    });
});